package com.sun.mail.imap.protocol;

import java.util.Vector;

public class MessageSet {
    public int end;
    public int start;

    public MessageSet() {
    }

    public MessageSet(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    public static MessageSet[] createMessageSets(int[] iArr) {
        Vector vector = new Vector();
        int i = 0;
        while (i < iArr.length) {
            MessageSet messageSet = new MessageSet();
            messageSet.start = iArr[i];
            do {
                i++;
                if (i >= iArr.length || iArr[i] != iArr[i - 1] + 1) {
                    int i2 = i - 1;
                    messageSet.end = iArr[i2];
                    vector.addElement(messageSet);
                    i = i2 + 1;
                }
                i++;
                break;
            } while (iArr[i] != iArr[i - 1] + 1);
            int i22 = i - 1;
            messageSet.end = iArr[i22];
            vector.addElement(messageSet);
            i = i22 + 1;
        }
        MessageSet[] messageSetArr = new MessageSet[vector.size()];
        vector.copyInto(messageSetArr);
        return messageSetArr;
    }

    public static int size(MessageSet[] messageSetArr) {
        if (messageSetArr == null) {
            return 0;
        }
        int i = 0;
        for (MessageSet size : messageSetArr) {
            i += size.size();
        }
        return i;
    }

    public static String toString(MessageSet[] messageSetArr) {
        if (messageSetArr == null || messageSetArr.length == 0) {
            return null;
        }
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = messageSetArr.length;
        while (true) {
            int i2 = messageSetArr[i].start;
            int i3 = messageSetArr[i].end;
            if (i3 > i2) {
                stringBuffer.append(i2);
                stringBuffer.append(':');
                stringBuffer.append(i3);
            } else {
                stringBuffer.append(i2);
            }
            i++;
            if (i >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(',');
        }
    }

    public int size() {
        return (this.end - this.start) + 1;
    }
}
