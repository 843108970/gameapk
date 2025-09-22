package javax.mail.internet;

import com.cyjh.common.util.s;
import com.lidroid.xutils.http.client.multipart.MIME;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.BEncoderStream;
import com.sun.mail.util.QEncoderStream;
import com.sun.mail.util.QPDecoderStream;
import com.sun.mail.util.QPEncoderStream;
import com.sun.mail.util.UUDecoderStream;
import com.sun.mail.util.UUEncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.mail.EmailConstants;

public class MimeUtility {
    public static final int ALL = -1;
    static final int ALL_ASCII = 1;
    static final int MOSTLY_ASCII = 2;
    static final int MOSTLY_NONASCII = 3;
    private static boolean decodeStrict = true;
    private static String defaultJavaCharset = null;
    private static String defaultMIMECharset = null;
    private static boolean encodeEolStrict = false;
    private static boolean foldEncodedWords = false;
    private static boolean foldText = true;
    private static Hashtable java2mime = new Hashtable(40);
    private static Hashtable mime2java = new Hashtable(10);

    /* JADX WARNING: Can't wrap try/catch for region: R(5:38|41|42|43|44) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0092 */
    static {
        /*
            java.lang.String r0 = "mail.mime.decodetext.strict"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0054 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0014
            java.lang.String r3 = "false"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ SecurityException -> 0x0054 }
            if (r0 == 0) goto L_0x0014
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            decodeStrict = r0     // Catch:{ SecurityException -> 0x0054 }
            java.lang.String r0 = "mail.mime.encodeeol.strict"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0054 }
            if (r0 == 0) goto L_0x0029
            java.lang.String r3 = "true"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ SecurityException -> 0x0054 }
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            encodeEolStrict = r0     // Catch:{ SecurityException -> 0x0054 }
            java.lang.String r0 = "mail.mime.foldencodedwords"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0054 }
            if (r0 == 0) goto L_0x003e
            java.lang.String r3 = "true"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ SecurityException -> 0x0054 }
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = 0
        L_0x003f:
            foldEncodedWords = r0     // Catch:{ SecurityException -> 0x0054 }
            java.lang.String r0 = "mail.mime.foldtext"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0054 }
            if (r0 == 0) goto L_0x0052
            java.lang.String r3 = "false"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ SecurityException -> 0x0054 }
            if (r0 == 0) goto L_0x0052
            r1 = 0
        L_0x0052:
            foldText = r1     // Catch:{ SecurityException -> 0x0054 }
        L_0x0054:
            java.util.Hashtable r0 = new java.util.Hashtable
            r1 = 40
            r0.<init>(r1)
            java2mime = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r1 = 10
            r0.<init>(r1)
            mime2java = r0
            java.lang.Class<javax.mail.internet.MimeUtility> r0 = javax.mail.internet.MimeUtility.class
            java.lang.String r1 = "/META-INF/javamail.charset.map"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)     // Catch:{ Exception -> 0x0093 }
            if (r0 == 0) goto L_0x0093
            com.sun.mail.util.LineInputStream r1 = new com.sun.mail.util.LineInputStream     // Catch:{ all -> 0x008b }
            r1.<init>(r0)     // Catch:{ all -> 0x008b }
            r0 = r1
            com.sun.mail.util.LineInputStream r0 = (com.sun.mail.util.LineInputStream) r0     // Catch:{ all -> 0x0089 }
            java.util.Hashtable r2 = java2mime     // Catch:{ all -> 0x0089 }
            loadMappings(r0, r2)     // Catch:{ all -> 0x0089 }
            r0 = r1
            com.sun.mail.util.LineInputStream r0 = (com.sun.mail.util.LineInputStream) r0     // Catch:{ all -> 0x0089 }
            java.util.Hashtable r2 = mime2java     // Catch:{ all -> 0x0089 }
            loadMappings(r0, r2)     // Catch:{ all -> 0x0089 }
            r1.close()     // Catch:{ Exception -> 0x0093 }
            goto L_0x0093
        L_0x0089:
            r0 = move-exception
            goto L_0x008f
        L_0x008b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x008f:
            r1.close()     // Catch:{ Exception -> 0x0092 }
        L_0x0092:
            throw r0     // Catch:{ Exception -> 0x0093 }
        L_0x0093:
            java.util.Hashtable r0 = java2mime
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01d6
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_1"
            java.lang.String r2 = "ISO-8859-1"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_1"
            java.lang.String r2 = "ISO-8859-1"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-1"
            java.lang.String r2 = "ISO-8859-1"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_2"
            java.lang.String r2 = "ISO-8859-2"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_2"
            java.lang.String r2 = "ISO-8859-2"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-2"
            java.lang.String r2 = "ISO-8859-2"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_3"
            java.lang.String r2 = "ISO-8859-3"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_3"
            java.lang.String r2 = "ISO-8859-3"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-3"
            java.lang.String r2 = "ISO-8859-3"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_4"
            java.lang.String r2 = "ISO-8859-4"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_4"
            java.lang.String r2 = "ISO-8859-4"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-4"
            java.lang.String r2 = "ISO-8859-4"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_5"
            java.lang.String r2 = "ISO-8859-5"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_5"
            java.lang.String r2 = "ISO-8859-5"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-5"
            java.lang.String r2 = "ISO-8859-5"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_6"
            java.lang.String r2 = "ISO-8859-6"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_6"
            java.lang.String r2 = "ISO-8859-6"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-6"
            java.lang.String r2 = "ISO-8859-6"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_7"
            java.lang.String r2 = "ISO-8859-7"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_7"
            java.lang.String r2 = "ISO-8859-7"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-7"
            java.lang.String r2 = "ISO-8859-7"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_8"
            java.lang.String r2 = "ISO-8859-8"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_8"
            java.lang.String r2 = "ISO-8859-8"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-8"
            java.lang.String r2 = "ISO-8859-8"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "8859_9"
            java.lang.String r2 = "ISO-8859-9"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859_9"
            java.lang.String r2 = "ISO-8859-9"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso8859-9"
            java.lang.String r2 = "ISO-8859-9"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "sjis"
            java.lang.String r2 = "Shift_JIS"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "jis"
            java.lang.String r2 = "ISO-2022-JP"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "iso2022jp"
            java.lang.String r2 = "ISO-2022-JP"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "euc_jp"
            java.lang.String r2 = "euc-jp"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "koi8_r"
            java.lang.String r2 = "koi8-r"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "euc_cn"
            java.lang.String r2 = "euc-cn"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "euc_tw"
            java.lang.String r2 = "euc-tw"
            r0.put(r1, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r1 = "euc_kr"
            java.lang.String r2 = "euc-kr"
            r0.put(r1, r2)
        L_0x01d6:
            java.util.Hashtable r0 = mime2java
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0238
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "iso-2022-cn"
            java.lang.String r2 = "ISO2022CN"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "iso-2022-kr"
            java.lang.String r2 = "ISO2022KR"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "utf-8"
            java.lang.String r2 = "UTF8"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "utf8"
            java.lang.String r2 = "UTF8"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "ja_jp.iso2022-7"
            java.lang.String r2 = "ISO2022JP"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "ja_jp.eucjp"
            java.lang.String r2 = "EUCJIS"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "euc-kr"
            java.lang.String r2 = "KSC5601"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "euckr"
            java.lang.String r2 = "KSC5601"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "us-ascii"
            java.lang.String r2 = "ISO-8859-1"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "x-us-ascii"
            java.lang.String r2 = "ISO-8859-1"
            r0.put(r1, r2)
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.<clinit>():void");
    }

    private MimeUtility() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int checkAscii(java.io.InputStream r18, int r19, boolean r20) {
        /*
            r0 = r19
            boolean r2 = encodeEolStrict
            r4 = 0
            if (r2 == 0) goto L_0x000b
            if (r20 == 0) goto L_0x000b
            r2 = 1
            goto L_0x000c
        L_0x000b:
            r2 = 0
        L_0x000c:
            r5 = 0
            r6 = -1
            r7 = 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x001c
            if (r0 != r6) goto L_0x0015
            goto L_0x001a
        L_0x0015:
            int r5 = java.lang.Math.min(r0, r7)
            r7 = r5
        L_0x001a:
            byte[] r5 = new byte[r7]
        L_0x001c:
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x0021:
            if (r0 != 0) goto L_0x0025
            goto L_0x007f
        L_0x0025:
            r14 = r18
            int r15 = r14.read(r5, r4, r7)     // Catch:{ IOException -> 0x007f }
            if (r15 != r6) goto L_0x002f
            goto L_0x007f
        L_0x002f:
            r16 = r12
            r12 = r10
            r10 = r9
            r9 = r8
            r8 = 0
        L_0x0035:
            if (r8 < r15) goto L_0x0041
            if (r0 == r6) goto L_0x003a
            int r0 = r0 - r15
        L_0x003a:
            r8 = r9
            r9 = r10
            r10 = r12
            r12 = r16
            r4 = 0
            goto L_0x0021
        L_0x0041:
            byte r6 = r5[r8]     // Catch:{ IOException -> 0x007c }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r3 = 10
            r13 = 13
            if (r2 == 0) goto L_0x0054
            if (r4 != r13) goto L_0x004f
            if (r6 != r3) goto L_0x0053
        L_0x004f:
            if (r4 == r13) goto L_0x0054
            if (r6 != r3) goto L_0x0054
        L_0x0053:
            r12 = 1
        L_0x0054:
            if (r6 == r13) goto L_0x0066
            if (r6 != r3) goto L_0x0059
            goto L_0x0066
        L_0x0059:
            int r4 = r16 + 1
            r3 = 998(0x3e6, float:1.398E-42)
            if (r4 <= r3) goto L_0x0063
            r16 = r4
            r11 = 1
            goto L_0x0068
        L_0x0063:
            r16 = r4
            goto L_0x0068
        L_0x0066:
            r16 = 0
        L_0x0068:
            boolean r3 = nonascii(r6)     // Catch:{ IOException -> 0x007c }
            if (r3 == 0) goto L_0x0075
            if (r20 == 0) goto L_0x0072
            r3 = 3
            return r3
        L_0x0072:
            int r10 = r10 + 1
            goto L_0x0077
        L_0x0075:
            int r9 = r9 + 1
        L_0x0077:
            int r8 = r8 + 1
            r4 = r6
            r6 = -1
            goto L_0x0035
        L_0x007c:
            r8 = r9
            r9 = r10
            r10 = r12
        L_0x007f:
            if (r0 != 0) goto L_0x0085
            if (r20 == 0) goto L_0x0085
            r0 = 3
            return r0
        L_0x0085:
            r0 = 3
            r1 = 2
            if (r9 != 0) goto L_0x0091
            if (r10 == 0) goto L_0x008c
            return r0
        L_0x008c:
            if (r11 == 0) goto L_0x008f
            return r1
        L_0x008f:
            r0 = 1
            return r0
        L_0x0091:
            if (r8 <= r9) goto L_0x0094
            return r1
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.checkAscii(java.io.InputStream, int, boolean):int");
    }

    static int checkAscii(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (nonascii(str.charAt(i3))) {
                i++;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            return 1;
        }
        return i2 > i ? 2 : 3;
    }

    static int checkAscii(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        for (byte b2 : bArr) {
            if (nonascii(b2 & 255)) {
                i++;
            } else {
                i2++;
            }
        }
        if (i == 0) {
            return 1;
        }
        return i2 > i ? 2 : 3;
    }

    public static InputStream decode(InputStream inputStream, String str) throws MessagingException {
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64DecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase(MIME.ENC_BINARY) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase(MIME.ENC_8BIT)) {
            return inputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    private static String decodeInnerWords(String str) throws UnsupportedEncodingException {
        int indexOf;
        int indexOf2;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int indexOf3 = str.indexOf("=?", i);
            if (indexOf3 >= 0) {
                stringBuffer.append(str.substring(i, indexOf3));
                int indexOf4 = str.indexOf(63, indexOf3 + 2);
                if (indexOf4 < 0 || (indexOf = str.indexOf(63, indexOf4 + 1)) < 0 || (indexOf2 = str.indexOf("?=", indexOf + 1)) < 0) {
                    break;
                }
                i = indexOf2 + 2;
                String substring = str.substring(indexOf3, i);
                try {
                    substring = decodeWord(substring);
                } catch (ParseException unused) {
                }
                stringBuffer.append(substring);
            } else {
                break;
            }
        }
        if (i == 0) {
            return str;
        }
        if (i < str.length()) {
            stringBuffer.append(str.substring(i));
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0080, code lost:
        if (r0.length() > 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0087, code lost:
        if (r0.length() > 0) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decodeText(java.lang.String r8) throws java.io.UnsupportedEncodingException {
        /*
            java.lang.String r0 = " \t\n\r"
            java.lang.String r1 = "=?"
            int r1 = r8.indexOf(r1)
            r2 = -1
            if (r1 != r2) goto L_0x000c
            return r8
        L_0x000c:
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            r2 = 1
            r1.<init>(r8, r0, r2)
            java.lang.StringBuffer r8 = new java.lang.StringBuffer
            r8.<init>()
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r3 = 0
            r4 = 0
        L_0x001e:
            boolean r5 = r1.hasMoreTokens()
            if (r5 != 0) goto L_0x002c
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            return r8
        L_0x002c:
            java.lang.String r5 = r1.nextToken()
            char r6 = r5.charAt(r3)
            r7 = 32
            if (r6 == r7) goto L_0x0094
            r7 = 9
            if (r6 == r7) goto L_0x0094
            r7 = 13
            if (r6 == r7) goto L_0x0094
            r7 = 10
            if (r6 != r7) goto L_0x0045
            goto L_0x0094
        L_0x0045:
            java.lang.String r6 = decodeWord(r5)     // Catch:{ ParseException -> 0x0057 }
            if (r4 != 0) goto L_0x0054
            int r7 = r0.length()     // Catch:{ ParseException -> 0x0057 }
            if (r7 <= 0) goto L_0x0054
            r8.append(r0)     // Catch:{ ParseException -> 0x0057 }
        L_0x0054:
            r5 = r6
            r4 = 1
            goto L_0x008d
        L_0x0057:
            boolean r6 = decodeStrict
            if (r6 != 0) goto L_0x0083
            java.lang.String r6 = decodeInnerWords(r5)
            if (r6 == r5) goto L_0x007c
            if (r4 == 0) goto L_0x006b
            java.lang.String r4 = "=?"
            boolean r4 = r5.startsWith(r4)
            if (r4 != 0) goto L_0x0074
        L_0x006b:
            int r4 = r0.length()
            if (r4 <= 0) goto L_0x0074
            r8.append(r0)
        L_0x0074:
            java.lang.String r4 = "?="
            boolean r4 = r5.endsWith(r4)
            r5 = r6
            goto L_0x008d
        L_0x007c:
            int r4 = r0.length()
            if (r4 <= 0) goto L_0x008c
            goto L_0x0089
        L_0x0083:
            int r4 = r0.length()
            if (r4 <= 0) goto L_0x008c
        L_0x0089:
            r8.append(r0)
        L_0x008c:
            r4 = 0
        L_0x008d:
            r8.append(r5)
            r0.setLength(r3)
            goto L_0x001e
        L_0x0094:
            r0.append(r6)
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.decodeText(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e0 A[Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decodeWord(java.lang.String r7) throws javax.mail.internet.ParseException, java.io.UnsupportedEncodingException {
        /*
            java.lang.String r0 = "=?"
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x001c
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "encoded word does not start with \"=?\": "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x001c:
            r0 = 63
            r1 = 2
            int r2 = r7.indexOf(r0, r1)
            r3 = -1
            if (r2 != r3) goto L_0x003a
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "encoded word does not include charset: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x003a:
            java.lang.String r4 = r7.substring(r1, r2)
            java.lang.String r4 = javaCharset(r4)
            int r2 = r2 + 1
            int r0 = r7.indexOf(r0, r2)
            if (r0 != r3) goto L_0x005e
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "encoded word does not include encoding: "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x005e:
            java.lang.String r2 = r7.substring(r2, r0)
            int r0 = r0 + 1
            java.lang.String r5 = "?="
            int r5 = r7.indexOf(r5, r0)
            if (r5 != r3) goto L_0x0080
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "encoded word does not end with \"?=\": "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x0080:
            java.lang.String r0 = r7.substring(r0, r5)
            int r3 = r0.length()     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            if (r3 <= 0) goto L_0x00bb
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            byte[] r0 = com.sun.mail.util.ASCIIUtility.getBytes((java.lang.String) r0)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r3.<init>(r0)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            java.lang.String r0 = "B"
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            if (r0 == 0) goto L_0x00a1
            com.sun.mail.util.BASE64DecoderStream r0 = new com.sun.mail.util.BASE64DecoderStream     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r0.<init>(r3)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            goto L_0x00ae
        L_0x00a1:
            java.lang.String r0 = "Q"
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            if (r0 == 0) goto L_0x00c5
            com.sun.mail.util.QDecoderStream r0 = new com.sun.mail.util.QDecoderStream     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r0.<init>(r3)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
        L_0x00ae:
            int r2 = r3.available()     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            byte[] r3 = new byte[r2]     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r6 = 0
            int r0 = r0.read(r3, r6, r2)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            if (r0 > 0) goto L_0x00be
        L_0x00bb:
            java.lang.String r0 = ""
            goto L_0x00d9
        L_0x00be:
            java.lang.String r2 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r2.<init>(r3, r6, r0, r4)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r0 = r2
            goto L_0x00d9
        L_0x00c5:
            java.io.UnsupportedEncodingException r7 = new java.io.UnsupportedEncodingException     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            java.lang.String r1 = "unknown encoding: "
            r0.<init>(r1)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r0.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            java.lang.String r0 = r0.toString()     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r7.<init>(r0)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            throw r7     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
        L_0x00d9:
            int r5 = r5 + r1
            int r1 = r7.length()     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            if (r5 >= r1) goto L_0x00fc
            java.lang.String r7 = r7.substring(r5)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            boolean r1 = decodeStrict     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            if (r1 != 0) goto L_0x00ec
            java.lang.String r7 = decodeInnerWords(r7)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
        L_0x00ec:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r1.<init>(r0)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            r1.append(r7)     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
            java.lang.String r0 = r1.toString()     // Catch:{ UnsupportedEncodingException -> 0x010e, IOException -> 0x0103, IllegalArgumentException -> 0x00fd }
        L_0x00fc:
            return r0
        L_0x00fd:
            java.io.UnsupportedEncodingException r7 = new java.io.UnsupportedEncodingException
            r7.<init>(r4)
            throw r7
        L_0x0103:
            r7 = move-exception
            javax.mail.internet.ParseException r0 = new javax.mail.internet.ParseException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        L_0x010e:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.decodeWord(java.lang.String):java.lang.String");
    }

    private static void doEncode(String str, boolean z, String str2, int i, String str3, boolean z2, boolean z3, StringBuffer stringBuffer) throws UnsupportedEncodingException {
        byte[] bytes;
        int length;
        boolean z4 = z3;
        StringBuffer stringBuffer2 = stringBuffer;
        int i2 = 0;
        String str4 = str;
        String str5 = str2;
        boolean z5 = z2;
        while (true) {
            bytes = str4.getBytes(str5);
            int i3 = i;
            if ((z ? BEncoderStream.encodedLength(bytes) : QEncoderStream.encodedLength(bytes, z4)) <= i3 || (length = str4.length()) <= 1) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            } else {
                int i4 = length / 2;
                doEncode(str4.substring(i2, i4), z, str5, i3, str3, z5, z4, stringBuffer2);
                str4 = str4.substring(i4, length);
                z5 = false;
                i2 = 0;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        OutputStream bEncoderStream = z ? new BEncoderStream(byteArrayOutputStream2) : new QEncoderStream(byteArrayOutputStream2, z4);
        try {
            bEncoderStream.write(bytes);
            bEncoderStream.close();
        } catch (IOException unused) {
        }
        byte[] byteArray = byteArrayOutputStream2.toByteArray();
        if (!z5) {
            stringBuffer2.append(foldEncodedWords ? "\r\n " : s.a.f1696a);
        }
        stringBuffer2.append(str3);
        for (byte b2 : byteArray) {
            stringBuffer2.append((char) b2);
        }
        stringBuffer2.append("?=");
    }

    public static OutputStream encode(OutputStream outputStream, String str) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase(MIME.ENC_BINARY) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase(MIME.ENC_8BIT)) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static OutputStream encode(OutputStream outputStream, String str, String str2) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream, str2);
        }
        if (str.equalsIgnoreCase(MIME.ENC_BINARY) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase(MIME.ENC_8BIT)) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static String encodeText(String str) throws UnsupportedEncodingException {
        return encodeText(str, (String) null, (String) null);
    }

    public static String encodeText(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, false);
    }

    public static String encodeWord(String str) throws UnsupportedEncodingException {
        return encodeWord(str, (String) null, (String) null);
    }

    public static String encodeWord(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, true);
    }

    private static String encodeWord(String str, String str2, String str3, boolean z) throws UnsupportedEncodingException {
        String str4;
        boolean z2;
        int checkAscii = checkAscii(str);
        if (checkAscii == 1) {
            return str;
        }
        if (str2 == null) {
            str4 = getDefaultJavaCharset();
            str2 = getDefaultMIMECharset();
        } else {
            str4 = javaCharset(str2);
        }
        if (str3 == null) {
            str3 = checkAscii != 3 ? "Q" : "B";
        }
        if (str3.equalsIgnoreCase("B")) {
            z2 = true;
        } else if (str3.equalsIgnoreCase("Q")) {
            z2 = false;
        } else {
            throw new UnsupportedEncodingException("Unknown transfer encoding: " + str3);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = 68 - str2.length();
        doEncode(str, z2, str4, length, "=?" + str2 + "?" + str3 + "?", true, z, stringBuffer);
        return stringBuffer.toString();
    }

    public static String fold(int i, String str) {
        if (!foldText) {
            return str;
        }
        int length = str.length() - 1;
        while (length >= 0 && ((r4 = str.charAt(length)) == ' ' || r4 == 9 || r4 == 13 || r4 == 10)) {
            length--;
        }
        if (length != str.length() - 1) {
            str = str.substring(0, length + 1);
        }
        if (str.length() + i <= 76) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 4);
        int i2 = i;
        String str2 = str;
        char c2 = 0;
        while (true) {
            if (str2.length() + i2 <= 76) {
                break;
            }
            char c3 = c2;
            int i3 = 0;
            int i4 = -1;
            while (i3 < str2.length() && (i4 == -1 || i2 + i3 <= 76)) {
                char charAt = str2.charAt(i3);
                if (!((charAt != ' ' && charAt != 9) || c3 == ' ' || c3 == 9)) {
                    i4 = i3;
                }
                i3++;
                c3 = charAt;
            }
            if (i4 == -1) {
                stringBuffer.append(str2);
                str2 = "";
                break;
            }
            stringBuffer.append(str2.substring(0, i4));
            stringBuffer.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            c2 = str2.charAt(i4);
            stringBuffer.append(c2);
            str2 = str2.substring(i4 + 1);
            i2 = 1;
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static String getDefaultJavaCharset() {
        if (defaultJavaCharset == null) {
            String str = null;
            try {
                str = System.getProperty(EmailConstants.MAIL_MIME_CHARSET);
            } catch (SecurityException unused) {
            }
            if (str == null || str.length() <= 0) {
                try {
                    defaultJavaCharset = System.getProperty("file.encoding", "8859_1");
                } catch (SecurityException unused2) {
                    String encoding = new InputStreamReader(new InputStream() {
                        public int read() {
                            return 0;
                        }
                    }).getEncoding();
                    defaultJavaCharset = encoding;
                    if (encoding == null) {
                        defaultJavaCharset = "8859_1";
                    }
                }
            } else {
                String javaCharset = javaCharset(str);
                defaultJavaCharset = javaCharset;
                return javaCharset;
            }
        }
        return defaultJavaCharset;
    }

    static String getDefaultMIMECharset() {
        if (defaultMIMECharset == null) {
            try {
                defaultMIMECharset = System.getProperty(EmailConstants.MAIL_MIME_CHARSET);
            } catch (SecurityException unused) {
            }
        }
        if (defaultMIMECharset == null) {
            defaultMIMECharset = mimeCharset(getDefaultJavaCharset());
        }
        return defaultMIMECharset;
    }

    public static String getEncoding(DataHandler dataHandler) {
        if (dataHandler.getName() != null) {
            return getEncoding(dataHandler.getDataSource());
        }
        try {
            if (new ContentType(dataHandler.getContentType()).match("text/*")) {
                AsciiOutputStream asciiOutputStream = new AsciiOutputStream(false, false);
                try {
                    dataHandler.writeTo(asciiOutputStream);
                } catch (IOException unused) {
                }
                switch (asciiOutputStream.getAscii()) {
                    case 1:
                        return "7bit";
                    case 2:
                        return "quoted-printable";
                    default:
                        return "base64";
                }
            } else {
                AsciiOutputStream asciiOutputStream2 = new AsciiOutputStream(true, encodeEolStrict);
                try {
                    dataHandler.writeTo(asciiOutputStream2);
                } catch (IOException unused2) {
                }
                return asciiOutputStream2.getAscii() == 1 ? "7bit" : "base64";
            }
        } catch (Exception unused3) {
            return "base64";
        }
    }

    public static String getEncoding(DataSource dataSource) {
        String str;
        try {
            ContentType contentType = new ContentType(dataSource.getContentType());
            InputStream inputStream = dataSource.getInputStream();
            switch (checkAscii(inputStream, -1, !contentType.match("text/*"))) {
                case 1:
                    str = "7bit";
                    break;
                case 2:
                    str = "quoted-printable";
                    break;
                default:
                    str = "base64";
                    break;
            }
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            return str;
        } catch (Exception unused2) {
            return "base64";
        }
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    private static int indexOfAny(String str, String str2, int i) {
        try {
            int length = str.length();
            while (i < length) {
                if (str2.indexOf(str.charAt(i)) >= 0) {
                    return i;
                }
                i++;
            }
            return -1;
        } catch (StringIndexOutOfBoundsException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = (java.lang.String) mime2java.get(r2.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String javaCharset(java.lang.String r2) {
        /*
            java.util.Hashtable r0 = mime2java
            if (r0 == 0) goto L_0x0019
            if (r2 != 0) goto L_0x0007
            return r2
        L_0x0007:
            java.util.Hashtable r0 = mime2java
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r2.toLowerCase(r1)
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0018
            return r2
        L_0x0018:
            return r0
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.javaCharset(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:15:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void loadMappings(com.sun.mail.util.LineInputStream r3, java.util.Hashtable r4) {
        /*
        L_0x0000:
            java.lang.String r0 = r3.readLine()     // Catch:{ IOException -> 0x0041 }
            if (r0 == 0) goto L_0x0041
            java.lang.String r1 = "--"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0016
            java.lang.String r1 = "--"
            boolean r1 = r0.endsWith(r1)
            if (r1 != 0) goto L_0x0041
        L_0x0016:
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x0000
            java.lang.String r1 = "#"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0000
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            java.lang.String r2 = " \t"
            r1.<init>(r0, r2)
            java.lang.String r0 = r1.nextToken()     // Catch:{ NoSuchElementException -> 0x0000 }
            java.lang.String r1 = r1.nextToken()     // Catch:{ NoSuchElementException -> 0x0000 }
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ NoSuchElementException -> 0x0000 }
            java.lang.String r0 = r0.toLowerCase(r2)     // Catch:{ NoSuchElementException -> 0x0000 }
            r4.put(r0, r1)     // Catch:{ NoSuchElementException -> 0x0000 }
            goto L_0x0000
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.loadMappings(com.sun.mail.util.LineInputStream, java.util.Hashtable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = (java.lang.String) java2mime.get(r2.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String mimeCharset(java.lang.String r2) {
        /*
            java.util.Hashtable r0 = java2mime
            if (r0 == 0) goto L_0x0019
            if (r2 != 0) goto L_0x0007
            return r2
        L_0x0007:
            java.util.Hashtable r0 = java2mime
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r2.toLowerCase(r1)
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0018
            return r2
        L_0x0018:
            return r0
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.mimeCharset(java.lang.String):java.lang.String");
    }

    static final boolean nonascii(int i) {
        if (i < 127) {
            return (i >= 32 || i == 13 || i == 10 || i == 9) ? false : true;
        }
        return true;
    }

    public static String quote(String str, String str2) {
        StringBuffer stringBuffer;
        int length = str.length();
        char c2 = 0;
        int i = 0;
        boolean z = false;
        while (true) {
            if (i < length) {
                char charAt = str.charAt(i);
                if (charAt == '\"' || charAt == '\\' || charAt == 13 || charAt == 10) {
                    stringBuffer = new StringBuffer(length + 3);
                    stringBuffer.append('\"');
                    stringBuffer.append(str.substring(0, i));
                } else {
                    if (charAt < ' ' || charAt >= 127 || str2.indexOf(charAt) >= 0) {
                        z = true;
                    }
                    i++;
                }
            } else if (!z) {
                return str;
            } else {
                stringBuffer = new StringBuffer(length + 2);
                stringBuffer.append('\"');
                stringBuffer.append(str);
            }
        }
        stringBuffer = new StringBuffer(length + 3);
        stringBuffer.append('\"');
        stringBuffer.append(str.substring(0, i));
        while (i < length) {
            char charAt2 = str.charAt(i);
            if ((charAt2 == '\"' || charAt2 == '\\' || charAt2 == 13 || charAt2 == 10) && !(charAt2 == 10 && c2 == 13)) {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
            }
            stringBuffer.append(charAt2);
            i++;
            c2 = charAt2;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String unfold(java.lang.String r8) {
        /*
            boolean r0 = foldText
            if (r0 != 0) goto L_0x0005
            return r8
        L_0x0005:
            r0 = 0
        L_0x0006:
            java.lang.String r1 = "\r\n"
            int r1 = indexOfAny(r8, r1)
            if (r1 >= 0) goto L_0x0018
            if (r0 == 0) goto L_0x0017
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0017:
            return r8
        L_0x0018:
            int r2 = r8.length()
            int r3 = r1 + 1
            if (r3 >= r2) goto L_0x0034
            int r4 = r3 + -1
            char r4 = r8.charAt(r4)
            r5 = 13
            if (r4 != r5) goto L_0x0034
            char r4 = r8.charAt(r3)
            r5 = 10
            if (r4 != r5) goto L_0x0034
            int r3 = r3 + 1
        L_0x0034:
            r4 = 0
            if (r1 == 0) goto L_0x0060
            int r5 = r1 + -1
            char r6 = r8.charAt(r5)
            r7 = 92
            if (r6 == r7) goto L_0x0042
            goto L_0x0060
        L_0x0042:
            if (r0 != 0) goto L_0x004d
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            int r2 = r8.length()
            r0.<init>(r2)
        L_0x004d:
            java.lang.String r2 = r8.substring(r4, r5)
            r0.append(r2)
            java.lang.String r1 = r8.substring(r1, r3)
        L_0x0058:
            r0.append(r1)
        L_0x005b:
            java.lang.String r8 = r8.substring(r3)
            goto L_0x0006
        L_0x0060:
            if (r3 >= r2) goto L_0x0092
            char r5 = r8.charAt(r3)
            r6 = 9
            r7 = 32
            if (r5 == r7) goto L_0x006e
            if (r5 != r6) goto L_0x0092
        L_0x006e:
            int r3 = r3 + 1
            if (r3 >= r2) goto L_0x007a
            char r5 = r8.charAt(r3)
            if (r5 == r7) goto L_0x006e
            if (r5 == r6) goto L_0x006e
        L_0x007a:
            if (r0 != 0) goto L_0x0085
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            int r2 = r8.length()
            r0.<init>(r2)
        L_0x0085:
            if (r1 == 0) goto L_0x005b
            java.lang.String r1 = r8.substring(r4, r1)
            r0.append(r1)
            r0.append(r7)
            goto L_0x005b
        L_0x0092:
            if (r0 != 0) goto L_0x009d
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            int r1 = r8.length()
            r0.<init>(r1)
        L_0x009d:
            java.lang.String r1 = r8.substring(r4, r3)
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.unfold(java.lang.String):java.lang.String");
    }
}
