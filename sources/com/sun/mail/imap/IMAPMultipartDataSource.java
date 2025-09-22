package com.sun.mail.imap;

import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import java.util.Vector;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

public class IMAPMultipartDataSource extends MimePartDataSource implements MultipartDataSource {
    private Vector parts;

    protected IMAPMultipartDataSource(MimePart mimePart, BODYSTRUCTURE[] bodystructureArr, String str, IMAPMessage iMAPMessage) {
        super(mimePart);
        String str2;
        this.parts = new Vector(bodystructureArr.length);
        for (int i = 0; i < bodystructureArr.length; i++) {
            Vector vector = this.parts;
            BODYSTRUCTURE bodystructure = bodystructureArr[i];
            if (str == null) {
                str2 = Integer.toString(i + 1);
            } else {
                str2 = String.valueOf(str) + "." + Integer.toString(i + 1);
            }
            vector.addElement(new IMAPBodyPart(bodystructure, str2, iMAPMessage));
        }
    }

    public BodyPart getBodyPart(int i) throws MessagingException {
        return (BodyPart) this.parts.elementAt(i);
    }

    public int getCount() {
        return this.parts.size();
    }
}
