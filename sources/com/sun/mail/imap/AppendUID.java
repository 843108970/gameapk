package com.sun.mail.imap;

public class AppendUID {
    public long uid = -1;
    public long uidvalidity = -1;

    public AppendUID(long j, long j2) {
        this.uidvalidity = j;
        this.uid = j2;
    }
}
