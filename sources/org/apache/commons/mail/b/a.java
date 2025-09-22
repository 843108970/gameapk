package org.apache.commons.mail.b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParseException;
import javax.mail.util.ByteArrayDataSource;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final MimeMessage f4286a;

    /* renamed from: b  reason: collision with root package name */
    private String f4287b;

    /* renamed from: c  reason: collision with root package name */
    private String f4288c;
    private final List<DataSource> d = new ArrayList();
    private final Map<String, DataSource> e = new HashMap();
    private boolean f;

    private a(MimeMessage mimeMessage) {
        this.f4286a = mimeMessage;
        this.f = false;
    }

    private static String a(String str) {
        if (str == null) {
            return null;
        }
        return str.trim().replaceAll("[\\<\\>]", "");
    }

    private static String a(Part part, DataSource dataSource) throws MessagingException, UnsupportedEncodingException {
        String name = dataSource.getName();
        if (name == null || name.length() == 0) {
            name = part.getFileName();
        }
        if (name == null || name.length() <= 0) {
            return null;
        }
        return MimeUtility.decodeText(name);
    }

    private a a() throws Exception {
        a((MimePart) this.f4286a);
        return this;
    }

    private void a(MimePart mimePart) throws MessagingException, IOException {
        if (a(mimePart, "text/plain") && this.f4287b == null && !"attachment".equalsIgnoreCase(mimePart.getDisposition())) {
            this.f4287b = (String) mimePart.getContent();
        } else if (!a(mimePart, "text/html") || this.f4288c != null || "attachment".equalsIgnoreCase(mimePart.getDisposition())) {
            if (a(mimePart, "multipart/*")) {
                this.f = true;
                Multipart multipart = (Multipart) mimePart.getContent();
                int count = multipart.getCount();
                for (int i = 0; i < count; i++) {
                    a((MimePart) (MimeBodyPart) multipart.getBodyPart(i));
                }
                return;
            }
            String contentID = mimePart.getContentID();
            String str = null;
            String replaceAll = contentID == null ? null : contentID.trim().replaceAll("[\\<\\>]", "");
            DataSource dataSource = mimePart.getDataHandler().getDataSource();
            String contentType = dataSource.getContentType();
            int indexOf = contentType.indexOf(59);
            if (indexOf >= 0) {
                contentType = contentType.substring(0, indexOf);
            }
            InputStream inputStream = dataSource.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
            while (true) {
                int read = bufferedInputStream.read();
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(read);
            }
            bufferedOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bufferedOutputStream.close();
            ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource(byteArray, contentType);
            String name = dataSource.getName();
            if (name == null || name.length() == 0) {
                name = mimePart.getFileName();
            }
            if (name != null && name.length() > 0) {
                str = MimeUtility.decodeText(name);
            }
            byteArrayDataSource.setName(str);
            if (replaceAll != null) {
                this.e.put(replaceAll, byteArrayDataSource);
            }
            this.d.add(byteArrayDataSource);
        } else {
            this.f4288c = (String) mimePart.getContent();
        }
    }

    private static boolean a(MimePart mimePart, String str) throws MessagingException, IOException {
        try {
            return new ContentType(mimePart.getDataHandler().getContentType()).match(str);
        } catch (ParseException unused) {
            return mimePart.getContentType().equalsIgnoreCase(str);
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        while (true) {
            int read = bufferedInputStream.read();
            if (read != -1) {
                bufferedOutputStream.write(read);
            } else {
                bufferedOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedOutputStream.close();
                return byteArray;
            }
        }
    }

    private List<Address> b() throws Exception {
        Address[] recipients = this.f4286a.getRecipients(Message.RecipientType.TO);
        return recipients != null ? Arrays.asList(recipients) : new ArrayList();
    }

    private DataSource b(String str) {
        for (int i = 0; i < this.d.size(); i++) {
            DataSource dataSource = this.d.get(i);
            if (str.equalsIgnoreCase(dataSource.getName())) {
                return dataSource;
            }
        }
        return null;
    }

    private static DataSource b(MimePart mimePart) throws MessagingException, IOException {
        DataSource dataSource = mimePart.getDataHandler().getDataSource();
        String contentType = dataSource.getContentType();
        int indexOf = contentType.indexOf(59);
        if (indexOf >= 0) {
            contentType = contentType.substring(0, indexOf);
        }
        InputStream inputStream = dataSource.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        while (true) {
            int read = bufferedInputStream.read();
            if (read == -1) {
                break;
            }
            bufferedOutputStream.write(read);
        }
        bufferedOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        bufferedOutputStream.close();
        ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource(byteArray, contentType);
        String name = dataSource.getName();
        if (name == null || name.length() == 0) {
            name = mimePart.getFileName();
        }
        byteArrayDataSource.setName((name == null || name.length() <= 0) ? null : MimeUtility.decodeText(name));
        return byteArrayDataSource;
    }

    private List<Address> c() throws Exception {
        Address[] recipients = this.f4286a.getRecipients(Message.RecipientType.CC);
        return recipients != null ? Arrays.asList(recipients) : new ArrayList();
    }

    private DataSource c(String str) {
        return this.e.get(str);
    }

    private static String d(String str) {
        int indexOf = str.indexOf(59);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    private List<Address> d() throws Exception {
        Address[] recipients = this.f4286a.getRecipients(Message.RecipientType.BCC);
        return recipients != null ? Arrays.asList(recipients) : new ArrayList();
    }

    private String e() throws Exception {
        Address[] from = this.f4286a.getFrom();
        if (from == null || from.length == 0) {
            return null;
        }
        return ((InternetAddress) from[0]).getAddress();
    }

    private String f() throws Exception {
        Address[] replyTo = this.f4286a.getReplyTo();
        if (replyTo == null || replyTo.length == 0) {
            return null;
        }
        return ((InternetAddress) replyTo[0]).getAddress();
    }

    private String g() throws Exception {
        return this.f4286a.getSubject();
    }

    private MimeMessage h() {
        return this.f4286a;
    }

    private boolean i() {
        return this.f;
    }

    private String j() {
        return this.f4287b;
    }

    private List<DataSource> k() {
        return this.d;
    }

    private Collection<String> l() {
        return Collections.unmodifiableSet(this.e.keySet());
    }

    private String m() {
        return this.f4288c;
    }

    private boolean n() {
        return this.f4287b != null;
    }

    private boolean o() {
        return this.f4288c != null;
    }

    private boolean p() {
        return this.d.size() > 0;
    }
}
