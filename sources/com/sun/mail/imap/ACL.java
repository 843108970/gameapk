package com.sun.mail.imap;

public class ACL implements Cloneable {
    private String name;
    private Rights rights;

    public ACL(String str) {
        this.name = str;
        this.rights = new Rights();
    }

    public ACL(String str, Rights rights2) {
        this.name = str;
        this.rights = rights2;
    }

    public Object clone() throws CloneNotSupportedException {
        ACL acl = (ACL) super.clone();
        acl.rights = (Rights) this.rights.clone();
        return acl;
    }

    public String getName() {
        return this.name;
    }

    public Rights getRights() {
        return this.rights;
    }

    public void setRights(Rights rights2) {
        this.rights = rights2;
    }
}
