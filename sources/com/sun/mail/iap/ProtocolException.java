package com.sun.mail.iap;

public class ProtocolException extends Exception {
    private static final long serialVersionUID = -4360500807971797439L;
    protected transient Response response = null;

    public ProtocolException() {
    }

    public ProtocolException(Response response2) {
        super(response2.toString());
        this.response = response2;
    }

    public ProtocolException(String str) {
        super(str);
    }

    public Response getResponse() {
        return this.response;
    }
}
