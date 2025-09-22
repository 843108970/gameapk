package com.sun.mail.imap.protocol;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class BASE64MailboxDecoder {
    static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', ','};
    private static final byte[] pem_convert_array = new byte[256];

    static {
        for (int i = 0; i < 255; i++) {
            pem_convert_array[i] = -1;
        }
        for (int i2 = 0; i2 < pem_array.length; i2++) {
            pem_convert_array[pem_array[i2]] = (byte) i2;
        }
    }

    protected static int base64decode(char[] cArr, int i, CharacterIterator characterIterator) {
        byte b2;
        byte b3;
        boolean z = true;
        loop0:
        while (true) {
            byte b4 = -1;
            while (true) {
                byte next = (byte) characterIterator.next();
                if (next != -1) {
                    if (next != 45) {
                        z = false;
                        byte next2 = (byte) characterIterator.next();
                        if (next2 != -1 && next2 != 45) {
                            byte b5 = pem_convert_array[next & 255];
                            byte b6 = pem_convert_array[next2 & 255];
                            byte b7 = (byte) (((b5 << 2) & 252) | ((b6 >>> 4) & 3));
                            if (b4 != -1) {
                                cArr[i] = (char) ((b4 << 8) | (b7 & 255));
                                i++;
                                b4 = -1;
                            } else {
                                b4 = b7 & 255;
                            }
                            byte next3 = (byte) characterIterator.next();
                            if (next3 != 61) {
                                if (next3 != -1 && next3 != 45) {
                                    byte b8 = pem_convert_array[next3 & 255];
                                    byte b9 = (byte) (((b6 << 4) & 240) | ((b8 >>> 2) & 15));
                                    if (b4 != -1) {
                                        cArr[i] = (char) ((b4 << 8) | (b9 & 255));
                                        i++;
                                        b3 = -1;
                                    } else {
                                        b3 = b9 & 255;
                                    }
                                    byte next4 = (byte) characterIterator.next();
                                    if (next4 != 61) {
                                        if (next4 == -1 || next4 == 45) {
                                            break loop0;
                                        }
                                        b2 = (byte) (((b8 << 6) & 192) | (pem_convert_array[next4 & 255] & 63));
                                        if (b4 != -1) {
                                            break;
                                        }
                                        b4 = b2 & 255;
                                    } else {
                                        continue;
                                    }
                                } else {
                                    break loop0;
                                }
                            }
                        } else {
                            break loop0;
                        }
                    } else if (z) {
                        cArr[i] = '&';
                        return i + 1;
                    }
                } else {
                    break loop0;
                }
            }
            cArr[i] = (char) ((b4 << 8) | (b2 & 255));
            i++;
        }
        return i;
    }

    public static String decode(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cArr = new char[str.length()];
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        boolean z = false;
        int i = 0;
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '&') {
                z = true;
                i = base64decode(cArr, i, stringCharacterIterator);
            } else {
                cArr[i] = first;
                i++;
            }
        }
        return z ? new String(cArr, 0, i) : str;
    }
}
