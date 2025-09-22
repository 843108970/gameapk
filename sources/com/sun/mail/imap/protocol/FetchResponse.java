package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import java.io.IOException;
import java.util.Vector;
import org.apache.commons.io.FilenameUtils;

public class FetchResponse extends IMAPResponse {
    private static final char[] HEADER = {FilenameUtils.EXTENSION_SEPARATOR, 'H', 'E', 'A', 'D', 'E', 'R'};
    private static final char[] TEXT = {FilenameUtils.EXTENSION_SEPARATOR, 'T', 'E', 'X', 'T'};
    private Item[] items;

    public FetchResponse(Protocol protocol) throws IOException, ProtocolException {
        super(protocol);
        parse();
    }

    public FetchResponse(IMAPResponse iMAPResponse) throws IOException, ProtocolException {
        super(iMAPResponse);
        parse();
    }

    public static Item getItem(Response[] responseArr, int i, Class cls) {
        if (responseArr == null) {
            return null;
        }
        for (int i2 = 0; i2 < responseArr.length; i2++) {
            if (responseArr[i2] != null && (responseArr[i2] instanceof FetchResponse) && responseArr[i2].getNumber() == i) {
                FetchResponse fetchResponse = responseArr[i2];
                for (int i3 = 0; i3 < fetchResponse.items.length; i3++) {
                    if (cls.isInstance(fetchResponse.items[i3])) {
                        return fetchResponse.items[i3];
                    }
                }
                continue;
            }
        }
        return null;
    }

    private boolean match(char[] cArr) {
        int length = cArr.length;
        int i = this.index;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            int i4 = i2 + 1;
            if (Character.toUpperCase((char) this.buffer[i]) != cArr[i2]) {
                return false;
            }
            i2 = i4;
            i = i3;
        }
        return true;
    }

    private void parse() throws ParsingException {
        int i;
        int length;
        int i2;
        int length2;
        skipSpaces();
        if (this.buffer[this.index] != 40) {
            throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.index);
        }
        Vector vector = new Vector();
        Object obj = null;
        do {
            this.index++;
            if (this.index >= this.size) {
                throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.size);
            }
            byte b2 = this.buffer[this.index];
            if (b2 != 66) {
                if (b2 != 73) {
                    if (b2 != 82) {
                        if (b2 != 85) {
                            switch (b2) {
                                case 69:
                                    if (match(ENVELOPE.name)) {
                                        this.index += ENVELOPE.name.length;
                                        obj = new ENVELOPE(this);
                                        break;
                                    }
                                    break;
                                case 70:
                                    if (match(FLAGS.name)) {
                                        this.index += FLAGS.name.length;
                                        obj = new FLAGS(this);
                                        break;
                                    }
                                    break;
                            }
                        } else if (match(UID.name)) {
                            this.index += UID.name.length;
                            obj = new UID(this);
                        }
                    } else if (match(RFC822SIZE.name)) {
                        this.index += RFC822SIZE.name.length;
                        obj = new RFC822SIZE(this);
                    } else if (match(RFC822DATA.name)) {
                        this.index += RFC822DATA.name.length;
                        if (match(HEADER)) {
                            i2 = this.index;
                            length2 = HEADER.length;
                        } else {
                            if (match(TEXT)) {
                                i2 = this.index;
                                length2 = TEXT.length;
                            }
                            obj = new RFC822DATA(this);
                        }
                        this.index = i2 + length2;
                        obj = new RFC822DATA(this);
                    }
                } else if (match(INTERNALDATE.name)) {
                    this.index += INTERNALDATE.name.length;
                    obj = new INTERNALDATE(this);
                }
            } else if (match(BODY.name)) {
                if (this.buffer[this.index + 4] == 91) {
                    this.index += BODY.name.length;
                    obj = new BODY(this);
                } else {
                    if (match(BODYSTRUCTURE.name)) {
                        i = this.index;
                        length = BODYSTRUCTURE.name.length;
                    } else {
                        i = this.index;
                        length = BODY.name.length;
                    }
                    this.index = i + length;
                    obj = new BODYSTRUCTURE(this);
                }
            }
            if (obj != null) {
                vector.addElement(obj);
            }
        } while (this.buffer[this.index] != 41);
        this.index++;
        this.items = new Item[vector.size()];
        vector.copyInto(this.items);
    }

    public Item getItem(int i) {
        return this.items[i];
    }

    public Item getItem(Class cls) {
        for (int i = 0; i < this.items.length; i++) {
            if (cls.isInstance(this.items[i])) {
                return this.items[i];
            }
        }
        return null;
    }

    public int getItemCount() {
        return this.items.length;
    }
}
