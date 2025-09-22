package com.sun.mail.smtp;

import android.support.v7.widget.ActivityChooserView;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.umeng.commonsdk.proguard.bg;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StreamTokenizer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class DigestMD5 {
    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String clientResponse;
    private PrintStream debugout;
    private MessageDigest md5;
    private String uri;

    public DigestMD5(PrintStream printStream) {
        this.debugout = printStream;
        if (printStream != null) {
            printStream.println("DEBUG DIGEST-MD5: Loaded");
        }
    }

    private static String toHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            int i2 = i + 1;
            cArr[i] = digits[b3 >> 4];
            i = i2 + 1;
            cArr[i2] = digits[b3 & bg.m];
        }
        return new String(cArr);
    }

    private Hashtable tokenize(String str) throws IOException {
        String str2;
        Hashtable hashtable = new Hashtable();
        byte[] bytes = str.getBytes();
        StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(new BASE64DecoderStream(new ByteArrayInputStream(bytes, 4, bytes.length - 4))));
        streamTokenizer.ordinaryChars(48, 57);
        streamTokenizer.wordChars(48, 57);
        while (true) {
            String str3 = null;
            while (true) {
                int nextToken = streamTokenizer.nextToken();
                if (nextToken != -1) {
                    if (nextToken == -3) {
                        if (str3 != null) {
                            break;
                        }
                        str3 = streamTokenizer.sval;
                    } else if (nextToken == 34) {
                        break;
                    }
                } else {
                    return hashtable;
                }
            }
            if (this.debugout != null) {
                this.debugout.println("DEBUG DIGEST-MD5: Received => " + str3 + "='" + streamTokenizer.sval + "'");
            }
            if (hashtable.containsKey(str3)) {
                str2 = hashtable.get(str3) + "," + streamTokenizer.sval;
            } else {
                str2 = streamTokenizer.sval;
            }
            hashtable.put(str3, str2);
        }
    }

    public byte[] authClient(String str, String str2, String str3, String str4, String str5) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        try {
            SecureRandom secureRandom = new SecureRandom();
            this.md5 = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            this.uri = "smtp/" + str;
            byte[] bArr = new byte[32];
            if (this.debugout != null) {
                this.debugout.println("DEBUG DIGEST-MD5: Begin authentication ...");
            }
            Hashtable hashtable = tokenize(str5);
            if (str4 == null) {
                String str6 = (String) hashtable.get("realm");
                if (str6 != null) {
                    str = new StringTokenizer(str6, ",").nextToken();
                }
                str4 = str;
            }
            String str7 = (String) hashtable.get("nonce");
            secureRandom.nextBytes(bArr);
            bASE64EncoderStream.write(bArr);
            bASE64EncoderStream.flush();
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            byteArrayOutputStream.reset();
            MessageDigest messageDigest = this.md5;
            MessageDigest messageDigest2 = this.md5;
            messageDigest.update(messageDigest2.digest(ASCIIUtility.getBytes(String.valueOf(str2) + ":" + str4 + ":" + str3)));
            MessageDigest messageDigest3 = this.md5;
            messageDigest3.update(ASCIIUtility.getBytes(":" + str7 + ":" + byteArrayOutputStream2));
            this.clientResponse = String.valueOf(toHex(this.md5.digest())) + ":" + str7 + ":" + "00000001" + ":" + byteArrayOutputStream2 + ":" + "auth" + ":";
            MessageDigest messageDigest4 = this.md5;
            StringBuilder sb = new StringBuilder("AUTHENTICATE:");
            sb.append(this.uri);
            messageDigest4.update(ASCIIUtility.getBytes(sb.toString()));
            MessageDigest messageDigest5 = this.md5;
            StringBuilder sb2 = new StringBuilder(String.valueOf(this.clientResponse));
            sb2.append(toHex(this.md5.digest()));
            messageDigest5.update(ASCIIUtility.getBytes(sb2.toString()));
            stringBuffer.append("username=\"" + str2 + "\"");
            stringBuffer.append(",realm=\"" + str4 + "\"");
            StringBuilder sb3 = new StringBuilder(",qop=");
            sb3.append("auth");
            stringBuffer.append(sb3.toString());
            stringBuffer.append(",nc=" + "00000001");
            stringBuffer.append(",nonce=\"" + str7 + "\"");
            stringBuffer.append(",cnonce=\"" + byteArrayOutputStream2 + "\"");
            stringBuffer.append(",digest-uri=\"" + this.uri + "\"");
            StringBuilder sb4 = new StringBuilder(",response=");
            sb4.append(toHex(this.md5.digest()));
            stringBuffer.append(sb4.toString());
            if (this.debugout != null) {
                PrintStream printStream = this.debugout;
                printStream.println("DEBUG DIGEST-MD5: Response => " + stringBuffer.toString());
            }
            bASE64EncoderStream.write(ASCIIUtility.getBytes(stringBuffer.toString()));
            bASE64EncoderStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (NoSuchAlgorithmException e) {
            if (this.debugout != null) {
                PrintStream printStream2 = this.debugout;
                printStream2.println("DEBUG DIGEST-MD5: " + e);
            }
            throw new IOException(e.toString());
        }
    }

    public boolean authServer(String str) throws IOException {
        Hashtable hashtable = tokenize(str);
        MessageDigest messageDigest = this.md5;
        messageDigest.update(ASCIIUtility.getBytes(":" + this.uri));
        MessageDigest messageDigest2 = this.md5;
        messageDigest2.update(ASCIIUtility.getBytes(String.valueOf(this.clientResponse) + toHex(this.md5.digest())));
        String hex = toHex(this.md5.digest());
        if (hex.equals((String) hashtable.get("rspauth"))) {
            return true;
        }
        if (this.debugout == null) {
            return false;
        }
        PrintStream printStream = this.debugout;
        printStream.println("DEBUG DIGEST-MD5: Expected => rspauth=" + hex);
        return false;
    }
}
