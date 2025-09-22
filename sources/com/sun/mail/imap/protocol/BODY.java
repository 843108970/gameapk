package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

public class BODY implements Item {
    static final char[] name = {'B', 'O', 'D', 'Y'};
    public ByteArray data;
    public int msgno;
    public int origin = 0;
    public String section;

    public BODY(FetchResponse fetchResponse) throws ParsingException {
        byte readByte;
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        do {
            readByte = fetchResponse.readByte();
            if (readByte == 93) {
                if (fetchResponse.readByte() == 60) {
                    this.origin = fetchResponse.readNumber();
                    fetchResponse.skip(1);
                }
                this.data = fetchResponse.readByteArray();
                return;
            }
        } while (readByte != 0);
        throw new ParsingException("BODY parse error: missing ``]'' at section end");
    }

    public ByteArray getByteArray() {
        return this.data;
    }

    public ByteArrayInputStream getByteArrayInputStream() {
        if (this.data != null) {
            return this.data.toByteArrayInputStream();
        }
        return null;
    }
}
