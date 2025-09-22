package org.apache.commons.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class DefaultAuthenticator extends Authenticator {
    private final PasswordAuthentication authentication;

    public DefaultAuthenticator(String str, String str2) {
        this.authentication = new PasswordAuthentication(str, str2);
    }

    /* access modifiers changed from: protected */
    public PasswordAuthentication getPasswordAuthentication() {
        return this.authentication;
    }
}
