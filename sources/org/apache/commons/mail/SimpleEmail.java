package org.apache.commons.mail;

public class SimpleEmail extends Email {
    public Email setMsg(String str) throws EmailException {
        if (EmailUtils.isEmpty(str)) {
            throw new EmailException("Invalid message supplied");
        }
        setContent(str, "text/plain");
        return this;
    }
}
