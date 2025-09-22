package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import java.util.Date;
import java.util.Vector;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MailDateFormat;

public class ENVELOPE implements Item {
    private static MailDateFormat mailDateFormat = new MailDateFormat();
    static final char[] name = {'E', 'N', 'V', 'E', 'L', 'O', 'P', 'E'};
    public InternetAddress[] bcc;
    public InternetAddress[] cc;
    public Date date = null;
    public InternetAddress[] from;
    public String inReplyTo;
    public String messageId;
    public int msgno;
    public InternetAddress[] replyTo;
    public InternetAddress[] sender;
    public String subject;
    public InternetAddress[] to;

    public ENVELOPE(FetchResponse fetchResponse) throws ParsingException {
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() != 40) {
            throw new ParsingException("ENVELOPE parse error");
        }
        String readString = fetchResponse.readString();
        if (readString != null) {
            try {
                this.date = mailDateFormat.parse(readString);
            } catch (Exception unused) {
            }
        }
        this.subject = fetchResponse.readString();
        this.from = parseAddressList(fetchResponse);
        this.sender = parseAddressList(fetchResponse);
        this.replyTo = parseAddressList(fetchResponse);
        this.to = parseAddressList(fetchResponse);
        this.cc = parseAddressList(fetchResponse);
        this.bcc = parseAddressList(fetchResponse);
        this.inReplyTo = fetchResponse.readString();
        this.messageId = fetchResponse.readString();
        if (fetchResponse.readByte() != 41) {
            throw new ParsingException("ENVELOPE parse error");
        }
    }

    private InternetAddress[] parseAddressList(Response response) throws ParsingException {
        response.skipSpaces();
        byte readByte = response.readByte();
        if (readByte == 40) {
            Vector vector = new Vector();
            do {
                IMAPAddress iMAPAddress = new IMAPAddress(response);
                if (!iMAPAddress.isEndOfGroup()) {
                    vector.addElement(iMAPAddress);
                }
            } while (response.peekByte() != 41);
            response.skip(1);
            InternetAddress[] internetAddressArr = new InternetAddress[vector.size()];
            vector.copyInto(internetAddressArr);
            return internetAddressArr;
        } else if (readByte == 78 || readByte == 110) {
            response.skip(2);
            return null;
        } else {
            throw new ParsingException("ADDRESS parse error");
        }
    }
}
