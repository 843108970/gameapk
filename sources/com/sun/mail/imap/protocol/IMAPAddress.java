package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import java.util.Vector;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

class IMAPAddress extends InternetAddress {
    private static final long serialVersionUID = -3835822029483122232L;
    private boolean group = false;
    private InternetAddress[] grouplist;
    private String groupname;

    IMAPAddress(Response response) throws ParsingException {
        response.skipSpaces();
        if (response.readByte() != 40) {
            throw new ParsingException("ADDRESS parse error");
        }
        this.encodedPersonal = response.readString();
        response.readString();
        String readString = response.readString();
        String readString2 = response.readString();
        if (response.readByte() != 41) {
            throw new ParsingException("ADDRESS parse error");
        } else if (readString2 == null) {
            this.group = true;
            this.groupname = readString;
            if (this.groupname != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.groupname);
                stringBuffer.append(':');
                Vector vector = new Vector();
                while (response.peekByte() != 41) {
                    IMAPAddress iMAPAddress = new IMAPAddress(response);
                    if (iMAPAddress.isEndOfGroup()) {
                        break;
                    }
                    if (vector.size() != 0) {
                        stringBuffer.append(',');
                    }
                    stringBuffer.append(iMAPAddress.toString());
                    vector.addElement(iMAPAddress);
                }
                stringBuffer.append(';');
                this.address = stringBuffer.toString();
                this.grouplist = new IMAPAddress[vector.size()];
                vector.copyInto(this.grouplist);
            }
        } else if (readString == null || readString.length() == 0) {
            this.address = readString2;
        } else if (readString2.length() == 0) {
            this.address = readString;
        } else {
            this.address = String.valueOf(readString) + "@" + readString2;
        }
    }

    public InternetAddress[] getGroup(boolean z) throws AddressException {
        if (this.grouplist == null) {
            return null;
        }
        return (InternetAddress[]) this.grouplist.clone();
    }

    /* access modifiers changed from: package-private */
    public boolean isEndOfGroup() {
        return this.group && this.groupname == null;
    }

    public boolean isGroup() {
        return this.group;
    }
}
