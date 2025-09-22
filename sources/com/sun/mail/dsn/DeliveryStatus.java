package com.sun.mail.dsn;

import com.sun.mail.util.LineOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;

public class DeliveryStatus {
    private static boolean debug = false;
    protected InternetHeaders messageDSN;
    protected InternetHeaders[] recipientDSN;

    static {
        try {
            String property = System.getProperty("mail.dsn.debug");
            debug = property != null && !property.equalsIgnoreCase("false");
        } catch (SecurityException unused) {
        }
    }

    public DeliveryStatus() throws MessagingException {
        this.messageDSN = new InternetHeaders();
        this.recipientDSN = new InternetHeaders[0];
    }

    public DeliveryStatus(InputStream inputStream) throws MessagingException, IOException {
        this.messageDSN = new InternetHeaders(inputStream);
        if (debug) {
            System.out.println("DSN: got messageDSN");
        }
        Vector vector = new Vector();
        while (inputStream.available() > 0) {
            try {
                InternetHeaders internetHeaders = new InternetHeaders(inputStream);
                if (debug) {
                    System.out.println("DSN: got recipientDSN");
                }
                vector.addElement(internetHeaders);
            } catch (EOFException unused) {
                if (debug) {
                    System.out.println("DSN: got EOFException");
                }
            }
        }
        if (debug) {
            PrintStream printStream = System.out;
            printStream.println("DSN: recipientDSN size " + vector.size());
        }
        this.recipientDSN = new InternetHeaders[vector.size()];
        vector.copyInto(this.recipientDSN);
    }

    private static void writeInternetHeaders(InternetHeaders internetHeaders, LineOutputStream lineOutputStream) throws IOException {
        Enumeration allHeaderLines = internetHeaders.getAllHeaderLines();
        while (allHeaderLines.hasMoreElements()) {
            try {
                lineOutputStream.writeln((String) allHeaderLines.nextElement());
            } catch (MessagingException e) {
                Exception nextException = e.getNextException();
                if (nextException instanceof IOException) {
                    throw ((IOException) nextException);
                }
                throw new IOException("Exception writing headers: " + e);
            }
        }
    }

    public void addRecipientDSN(InternetHeaders internetHeaders) {
        InternetHeaders[] internetHeadersArr = new InternetHeaders[(this.recipientDSN.length + 1)];
        System.arraycopy(this.recipientDSN, 0, internetHeadersArr, 0, this.recipientDSN.length);
        this.recipientDSN = internetHeadersArr;
        this.recipientDSN[this.recipientDSN.length - 1] = internetHeaders;
    }

    public InternetHeaders getMessageDSN() {
        return this.messageDSN;
    }

    public InternetHeaders getRecipientDSN(int i) {
        return this.recipientDSN[i];
    }

    public int getRecipientDSNCount() {
        return this.recipientDSN.length;
    }

    public void setMessageDSN(InternetHeaders internetHeaders) {
        this.messageDSN = internetHeaders;
    }

    public String toString() {
        return "DeliveryStatus: Reporting-MTA=" + this.messageDSN.getHeader("Reporting-MTA", (String) null) + ", #Recipients=" + this.recipientDSN.length;
    }

    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        LineOutputStream lineOutputStream = outputStream instanceof LineOutputStream ? (LineOutputStream) outputStream : new LineOutputStream(outputStream);
        writeInternetHeaders(this.messageDSN, lineOutputStream);
        lineOutputStream.writeln();
        for (InternetHeaders writeInternetHeaders : this.recipientDSN) {
            writeInternetHeaders(writeInternetHeaders, lineOutputStream);
            lineOutputStream.writeln();
        }
    }
}
