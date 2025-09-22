package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;

public class Status {
    static final String[] standardItems = {"MESSAGES", "RECENT", "UNSEEN", "UIDNEXT", "UIDVALIDITY"};
    public String mbox = null;
    public int recent = -1;
    public int total = -1;
    public long uidnext = -1;
    public long uidvalidity = -1;
    public int unseen = -1;

    public Status(Response response) throws ParsingException {
        this.mbox = response.readAtomString();
        response.skipSpaces();
        if (response.readByte() != 40) {
            throw new ParsingException("parse error in STATUS");
        }
        do {
            String readAtom = response.readAtom();
            if (readAtom.equalsIgnoreCase("MESSAGES")) {
                this.total = response.readNumber();
            } else if (readAtom.equalsIgnoreCase("RECENT")) {
                this.recent = response.readNumber();
            } else if (readAtom.equalsIgnoreCase("UIDNEXT")) {
                this.uidnext = response.readLong();
            } else if (readAtom.equalsIgnoreCase("UIDVALIDITY")) {
                this.uidvalidity = response.readLong();
            } else if (readAtom.equalsIgnoreCase("UNSEEN")) {
                this.unseen = response.readNumber();
            }
        } while (response.readByte() != 41);
    }

    public static void add(Status status, Status status2) {
        if (status2.total != -1) {
            status.total = status2.total;
        }
        if (status2.recent != -1) {
            status.recent = status2.recent;
        }
        if (status2.uidnext != -1) {
            status.uidnext = status2.uidnext;
        }
        if (status2.uidvalidity != -1) {
            status.uidvalidity = status2.uidvalidity;
        }
        if (status2.unseen != -1) {
            status.unseen = status2.unseen;
        }
    }
}
