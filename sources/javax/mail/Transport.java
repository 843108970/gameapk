package javax.mail;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;

public abstract class Transport extends Service {
    private Vector transportListeners = null;

    public Transport(Session session, URLName uRLName) {
        super(session, uRLName);
    }

    public static void send(Message message) throws MessagingException {
        message.saveChanges();
        send0(message, message.getAllRecipients());
    }

    public static void send(Message message, Address[] addressArr) throws MessagingException {
        message.saveChanges();
        send0(message, addressArr);
    }

    private static void send0(Message message, Address[] addressArr) throws MessagingException {
        Address[] addressArr2;
        Address[] addressArr3;
        Message message2 = message;
        Address[] addressArr4 = addressArr;
        if (addressArr4 == null || addressArr4.length == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Hashtable hashtable = new Hashtable();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < addressArr4.length; i++) {
            if (hashtable.containsKey(addressArr4[i].getType())) {
                ((Vector) hashtable.get(addressArr4[i].getType())).addElement(addressArr4[i]);
            } else {
                Vector vector4 = new Vector();
                vector4.addElement(addressArr4[i]);
                hashtable.put(addressArr4[i].getType(), vector4);
            }
        }
        int size = hashtable.size();
        if (size == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Address[] addressArr5 = null;
        Session defaultInstance = message2.session != null ? message2.session : Session.getDefaultInstance(System.getProperties(), (Authenticator) null);
        if (size == 1) {
            Transport transport = defaultInstance.getTransport(addressArr4[0]);
            try {
                transport.connect();
                transport.sendMessage(message2, addressArr4);
                transport.close();
            } catch (Throwable th) {
                Throwable th2 = th;
                transport.close();
                throw th2;
            }
        } else {
            Enumeration elements = hashtable.elements();
            SendFailedException sendFailedException = null;
            boolean z = false;
            while (elements.hasMoreElements()) {
                Vector vector5 = (Vector) elements.nextElement();
                Address[] addressArr6 = new Address[vector5.size()];
                vector5.copyInto(addressArr6);
                Transport transport2 = defaultInstance.getTransport(addressArr6[0]);
                if (transport2 == null) {
                    for (Address addElement : addressArr6) {
                        vector.addElement(addElement);
                    }
                } else {
                    try {
                        transport2.connect();
                        transport2.sendMessage(message2, addressArr6);
                        transport2.close();
                    } catch (SendFailedException e) {
                        SendFailedException sendFailedException2 = e;
                        if (sendFailedException == null) {
                            sendFailedException = sendFailedException2;
                        } else {
                            sendFailedException.setNextException(sendFailedException2);
                        }
                        Address[] invalidAddresses = sendFailedException2.getInvalidAddresses();
                        if (invalidAddresses != null) {
                            for (Address addElement2 : invalidAddresses) {
                                vector.addElement(addElement2);
                            }
                        }
                        Address[] validSentAddresses = sendFailedException2.getValidSentAddresses();
                        if (validSentAddresses != null) {
                            for (Address addElement3 : validSentAddresses) {
                                vector2.addElement(addElement3);
                            }
                        }
                        Address[] validUnsentAddresses = sendFailedException2.getValidUnsentAddresses();
                        if (validUnsentAddresses != null) {
                            for (Address addElement4 : validUnsentAddresses) {
                                vector3.addElement(addElement4);
                            }
                        }
                        transport2.close();
                        z = true;
                    } catch (MessagingException e2) {
                        MessagingException messagingException = e2;
                        if (sendFailedException == null) {
                            sendFailedException = messagingException;
                        } else {
                            sendFailedException.setNextException(messagingException);
                        }
                        transport2.close();
                        z = true;
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        transport2.close();
                        throw th4;
                    }
                }
            }
            if (z || vector.size() != 0 || vector3.size() != 0) {
                if (vector2.size() > 0) {
                    Address[] addressArr7 = new Address[vector2.size()];
                    vector2.copyInto(addressArr7);
                    addressArr2 = addressArr7;
                } else {
                    addressArr2 = null;
                }
                if (vector3.size() > 0) {
                    Address[] addressArr8 = new Address[vector3.size()];
                    vector3.copyInto(addressArr8);
                    addressArr3 = addressArr8;
                } else {
                    addressArr3 = null;
                }
                if (vector.size() > 0) {
                    addressArr5 = new Address[vector.size()];
                    vector.copyInto(addressArr5);
                }
                throw new SendFailedException("Sending failed", sendFailedException, addressArr2, addressArr3, addressArr5);
            }
        }
    }

    public synchronized void addTransportListener(TransportListener transportListener) {
        if (this.transportListeners == null) {
            this.transportListeners = new Vector();
        }
        this.transportListeners.addElement(transportListener);
    }

    /* access modifiers changed from: protected */
    public void notifyTransportListeners(int i, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        if (this.transportListeners != null) {
            queueEvent(new TransportEvent(this, i, addressArr, addressArr2, addressArr3, message), this.transportListeners);
        }
    }

    public synchronized void removeTransportListener(TransportListener transportListener) {
        if (this.transportListeners != null) {
            this.transportListeners.removeElement(transportListener);
        }
    }

    public abstract void sendMessage(Message message, Address[] addressArr) throws MessagingException;
}
