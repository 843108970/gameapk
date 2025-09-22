package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import javax.mail.Flags;

public class FLAGS extends Flags implements Item {
    static final char[] name = {'F', 'L', 'A', 'G', 'S'};
    private static final long serialVersionUID = 439049847053756670L;
    public int msgno;

    public FLAGS(IMAPResponse iMAPResponse) throws ParsingException {
        Flags.Flag flag;
        this.msgno = iMAPResponse.getNumber();
        iMAPResponse.skipSpaces();
        String[] readSimpleList = iMAPResponse.readSimpleList();
        if (readSimpleList != null) {
            for (String str : readSimpleList) {
                if (str.length() >= 2 && str.charAt(0) == '\\') {
                    char upperCase = Character.toUpperCase(str.charAt(1));
                    if (upperCase == '*') {
                        flag = Flags.Flag.USER;
                    } else if (upperCase == 'A') {
                        flag = Flags.Flag.ANSWERED;
                    } else if (upperCase != 'D') {
                        if (upperCase != 'F') {
                            switch (upperCase) {
                                case 'R':
                                    flag = Flags.Flag.RECENT;
                                    break;
                                case 'S':
                                    flag = Flags.Flag.SEEN;
                                    break;
                            }
                        } else {
                            flag = Flags.Flag.FLAGGED;
                        }
                    } else if (str.length() >= 3) {
                        char charAt = str.charAt(2);
                        if (charAt == 'e' || charAt == 'E') {
                            flag = Flags.Flag.DELETED;
                        } else if (charAt == 'r' || charAt == 'R') {
                            flag = Flags.Flag.DRAFT;
                        }
                    }
                    add(flag);
                }
                add(str);
            }
        }
    }
}
