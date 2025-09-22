package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Vector;
import org.apache.commons.io.IOUtils;

public class ListInfo {
    public static final int CHANGED = 1;
    public static final int INDETERMINATE = 3;
    public static final int UNCHANGED = 2;
    public String[] attrs;
    public boolean canOpen = true;
    public int changeState = 3;
    public boolean hasInferiors = true;
    public String name = null;
    public char separator = IOUtils.DIR_SEPARATOR_UNIX;

    public ListInfo(IMAPResponse iMAPResponse) throws ParsingException {
        String[] readSimpleList = iMAPResponse.readSimpleList();
        Vector vector = new Vector();
        if (readSimpleList != null) {
            for (int i = 0; i < readSimpleList.length; i++) {
                if (readSimpleList[i].equalsIgnoreCase("\\Marked")) {
                    this.changeState = 1;
                } else if (readSimpleList[i].equalsIgnoreCase("\\Unmarked")) {
                    this.changeState = 2;
                } else if (readSimpleList[i].equalsIgnoreCase("\\Noselect")) {
                    this.canOpen = false;
                } else if (readSimpleList[i].equalsIgnoreCase("\\Noinferiors")) {
                    this.hasInferiors = false;
                }
                vector.addElement(readSimpleList[i]);
            }
        }
        this.attrs = new String[vector.size()];
        vector.copyInto(this.attrs);
        iMAPResponse.skipSpaces();
        if (iMAPResponse.readByte() == 34) {
            char readByte = (char) iMAPResponse.readByte();
            this.separator = readByte;
            if (readByte == '\\') {
                this.separator = (char) iMAPResponse.readByte();
            }
            iMAPResponse.skip(1);
        } else {
            iMAPResponse.skip(2);
        }
        iMAPResponse.skipSpaces();
        this.name = iMAPResponse.readAtomString();
        this.name = BASE64MailboxDecoder.decode(this.name);
    }
}
