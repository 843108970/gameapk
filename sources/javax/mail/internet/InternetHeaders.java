package javax.mail.internet;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cyjh.common.util.s;
import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.mail.Header;
import javax.mail.MessagingException;
import org.apache.commons.io.IOUtils;

public class InternetHeaders {
    protected List headers = new ArrayList(40);

    protected static final class InternetHeader extends Header {
        String line;

        public InternetHeader(String str) {
            super("", "");
            int indexOf = str.indexOf(58);
            this.name = indexOf < 0 ? str.trim() : str.substring(0, indexOf).trim();
            this.line = str;
        }

        public InternetHeader(String str, String str2) {
            super(str, "");
            String str3;
            if (str2 != null) {
                str3 = String.valueOf(str) + ": " + str2;
            } else {
                str3 = null;
            }
            this.line = str3;
        }

        public final String getValue() {
            char charAt;
            int indexOf = this.line.indexOf(58);
            if (indexOf < 0) {
                return this.line;
            }
            while (true) {
                indexOf++;
                if (indexOf < this.line.length() && ((charAt = this.line.charAt(indexOf)) == ' ' || charAt == 9 || charAt == 13 || charAt == 10)) {
                }
            }
            return this.line.substring(indexOf);
        }
    }

    static class matchEnum implements Enumeration {
        private Iterator e;
        private boolean match;
        private String[] names;
        private InternetHeader next_header = null;
        private boolean want_line;

        matchEnum(List list, String[] strArr, boolean z, boolean z2) {
            this.e = list.iterator();
            this.names = strArr;
            this.match = z;
            this.want_line = z2;
        }

        private InternetHeader nextMatch() {
            while (this.e.hasNext()) {
                InternetHeader internetHeader = (InternetHeader) this.e.next();
                if (internetHeader.line != null) {
                    if (this.names != null) {
                        int i = 0;
                        while (true) {
                            if (i >= this.names.length) {
                                if (!this.match) {
                                    return internetHeader;
                                }
                            } else if (!this.names[i].equalsIgnoreCase(internetHeader.getName())) {
                                i++;
                            } else if (this.match) {
                                return internetHeader;
                            }
                        }
                    } else if (this.match) {
                        return null;
                    } else {
                        return internetHeader;
                    }
                }
            }
            return null;
        }

        public boolean hasMoreElements() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            return this.next_header != null;
        }

        public Object nextElement() {
            if (this.next_header == null) {
                this.next_header = nextMatch();
            }
            if (this.next_header == null) {
                throw new NoSuchElementException("No more headers");
            }
            InternetHeader internetHeader = this.next_header;
            this.next_header = null;
            return this.want_line ? internetHeader.line : new Header(internetHeader.getName(), internetHeader.getValue());
        }
    }

    public InternetHeaders() {
        this.headers.add(new InternetHeader("Return-Path", (String) null));
        this.headers.add(new InternetHeader("Received", (String) null));
        this.headers.add(new InternetHeader("Resent-Date", (String) null));
        this.headers.add(new InternetHeader("Resent-From", (String) null));
        this.headers.add(new InternetHeader("Resent-Sender", (String) null));
        this.headers.add(new InternetHeader("Resent-To", (String) null));
        this.headers.add(new InternetHeader("Resent-Cc", (String) null));
        this.headers.add(new InternetHeader("Resent-Bcc", (String) null));
        this.headers.add(new InternetHeader("Resent-Message-Id", (String) null));
        this.headers.add(new InternetHeader("Date", (String) null));
        this.headers.add(new InternetHeader("From", (String) null));
        this.headers.add(new InternetHeader("Sender", (String) null));
        this.headers.add(new InternetHeader("Reply-To", (String) null));
        this.headers.add(new InternetHeader("To", (String) null));
        this.headers.add(new InternetHeader("Cc", (String) null));
        this.headers.add(new InternetHeader("Bcc", (String) null));
        this.headers.add(new InternetHeader("Message-Id", (String) null));
        this.headers.add(new InternetHeader("In-Reply-To", (String) null));
        this.headers.add(new InternetHeader("References", (String) null));
        this.headers.add(new InternetHeader("Subject", (String) null));
        this.headers.add(new InternetHeader("Comments", (String) null));
        this.headers.add(new InternetHeader("Keywords", (String) null));
        this.headers.add(new InternetHeader("Errors-To", (String) null));
        this.headers.add(new InternetHeader("MIME-Version", (String) null));
        this.headers.add(new InternetHeader("Content-Type", (String) null));
        this.headers.add(new InternetHeader(MIME.CONTENT_TRANSFER_ENC, (String) null));
        this.headers.add(new InternetHeader(HttpHeaders.CONTENT_MD5, (String) null));
        this.headers.add(new InternetHeader(":", (String) null));
        this.headers.add(new InternetHeader("Content-Length", (String) null));
        this.headers.add(new InternetHeader("Status", (String) null));
    }

    public InternetHeaders(InputStream inputStream) throws MessagingException {
        load(inputStream);
    }

    public void addHeader(String str, String str2) {
        int size = this.headers.size();
        boolean z = str.equalsIgnoreCase("Received") || str.equalsIgnoreCase("Return-Path");
        if (z) {
            size = 0;
        }
        for (int size2 = this.headers.size() - 1; size2 >= 0; size2--) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(size2);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (z) {
                    size = size2;
                } else {
                    this.headers.add(size2 + 1, new InternetHeader(str, str2));
                    return;
                }
            }
            if (internetHeader.getName().equals(":")) {
                size = size2;
            }
        }
        this.headers.add(size, new InternetHeader(str, str2));
    }

    public void addHeaderLine(String str) {
        try {
            char charAt = str.charAt(0);
            if (charAt != ' ') {
                if (charAt != 9) {
                    this.headers.add(new InternetHeader(str));
                    return;
                }
            }
            InternetHeader internetHeader = (InternetHeader) this.headers.get(this.headers.size() - 1);
            internetHeader.line = String.valueOf(internetHeader.line) + IOUtils.LINE_SEPARATOR_WINDOWS + str;
        } catch (StringIndexOutOfBoundsException | NoSuchElementException unused) {
        }
    }

    public Enumeration getAllHeaderLines() {
        return getNonMatchingHeaderLines((String[]) null);
    }

    public Enumeration getAllHeaders() {
        return new matchEnum(this.headers, (String[]) null, false, false);
    }

    public String getHeader(String str, String str2) {
        String[] header = getHeader(str);
        if (header == null) {
            return null;
        }
        if (header.length == 1 || str2 == null) {
            return header[0];
        }
        StringBuffer stringBuffer = new StringBuffer(header[0]);
        for (int i = 1; i < header.length; i++) {
            stringBuffer.append(str2);
            stringBuffer.append(header[i]);
        }
        return stringBuffer.toString();
    }

    public String[] getHeader(String str) {
        ArrayList arrayList = new ArrayList();
        for (InternetHeader internetHeader : this.headers) {
            if (str.equalsIgnoreCase(internetHeader.getName()) && internetHeader.line != null) {
                arrayList.add(internetHeader.getValue());
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Enumeration getMatchingHeaderLines(String[] strArr) {
        return new matchEnum(this.headers, strArr, true, true);
    }

    public Enumeration getMatchingHeaders(String[] strArr) {
        return new matchEnum(this.headers, strArr, true, false);
    }

    public Enumeration getNonMatchingHeaderLines(String[] strArr) {
        return new matchEnum(this.headers, strArr, false, true);
    }

    public Enumeration getNonMatchingHeaders(String[] strArr) {
        return new matchEnum(this.headers, strArr, false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[Catch:{ IOException -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022 A[Catch:{ IOException -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load(java.io.InputStream r6) throws javax.mail.MessagingException {
        /*
            r5 = this;
            com.sun.mail.util.LineInputStream r0 = new com.sun.mail.util.LineInputStream
            r0.<init>(r6)
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            r1 = 0
            r2 = r1
        L_0x000c:
            java.lang.String r3 = r0.readLine()     // Catch:{ IOException -> 0x0052 }
            if (r3 == 0) goto L_0x0031
            java.lang.String r4 = " "
            boolean r4 = r3.startsWith(r4)     // Catch:{ IOException -> 0x0052 }
            if (r4 != 0) goto L_0x0022
            java.lang.String r4 = "\t"
            boolean r4 = r3.startsWith(r4)     // Catch:{ IOException -> 0x0052 }
            if (r4 == 0) goto L_0x0031
        L_0x0022:
            if (r2 == 0) goto L_0x0028
            r6.append(r2)     // Catch:{ IOException -> 0x0052 }
            r2 = r1
        L_0x0028:
            java.lang.String r4 = "\r\n"
            r6.append(r4)     // Catch:{ IOException -> 0x0052 }
            r6.append(r3)     // Catch:{ IOException -> 0x0052 }
            goto L_0x0049
        L_0x0031:
            if (r2 == 0) goto L_0x0037
            r5.addHeaderLine(r2)     // Catch:{ IOException -> 0x0052 }
            goto L_0x0048
        L_0x0037:
            int r2 = r6.length()     // Catch:{ IOException -> 0x0052 }
            if (r2 <= 0) goto L_0x0048
            java.lang.String r2 = r6.toString()     // Catch:{ IOException -> 0x0052 }
            r5.addHeaderLine(r2)     // Catch:{ IOException -> 0x0052 }
            r2 = 0
            r6.setLength(r2)     // Catch:{ IOException -> 0x0052 }
        L_0x0048:
            r2 = r3
        L_0x0049:
            if (r3 == 0) goto L_0x0051
            int r3 = r3.length()     // Catch:{ IOException -> 0x0052 }
            if (r3 > 0) goto L_0x000c
        L_0x0051:
            return
        L_0x0052:
            r6 = move-exception
            javax.mail.MessagingException r0 = new javax.mail.MessagingException
            java.lang.String r1 = "Error in input stream"
            r0.<init>(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.InternetHeaders.load(java.io.InputStream):void");
    }

    public void removeHeader(String str) {
        for (int i = 0; i < this.headers.size(); i++) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(i);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                internetHeader.line = null;
            }
        }
    }

    public void setHeader(String str, String str2) {
        String str3;
        int indexOf;
        int i = 0;
        boolean z = false;
        while (i < this.headers.size()) {
            InternetHeader internetHeader = (InternetHeader) this.headers.get(i);
            if (str.equalsIgnoreCase(internetHeader.getName())) {
                if (!z) {
                    if (internetHeader.line == null || (indexOf = internetHeader.line.indexOf(58)) < 0) {
                        str3 = String.valueOf(str) + ": " + str2;
                    } else {
                        str3 = String.valueOf(internetHeader.line.substring(0, indexOf + 1)) + s.a.f1696a + str2;
                    }
                    internetHeader.line = str3;
                    z = true;
                } else {
                    this.headers.remove(i);
                    i--;
                }
            }
            i++;
        }
        if (!z) {
            addHeader(str, str2);
        }
    }
}
