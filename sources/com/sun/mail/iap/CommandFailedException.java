package com.sun.mail.iap;

public class CommandFailedException extends ProtocolException {
    private static final long serialVersionUID = 793932807880443631L;

    public CommandFailedException() {
    }

    public CommandFailedException(Response response) {
        super(response);
    }

    public CommandFailedException(String str) {
        super(str);
    }
}
