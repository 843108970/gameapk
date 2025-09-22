package com.lidroid.xutils.http.client.util;

import android.text.TextUtils;
import com.umeng.commonsdk.proguard.bg;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final char[] DELIM = {'&'};
    private static final BitSet FRAGMENT = new BitSet(256);
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    private static final BitSet PATHSAFE = new BitSet(256);
    private static final BitSet PUNCT = new BitSet(256);
    private static final int RADIX = 16;
    private static final BitSet RESERVED = new BitSet(256);
    private static final BitSet UNRESERVED = new BitSet(256);
    private static final BitSet URLENCODER = new BitSet(256);
    private static final BitSet USERINFO = new BitSet(256);

    static {
        for (int i = 97; i <= 122; i++) {
            UNRESERVED.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            UNRESERVED.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            UNRESERVED.set(i3);
        }
        UNRESERVED.set(95);
        UNRESERVED.set(45);
        UNRESERVED.set(46);
        UNRESERVED.set(42);
        URLENCODER.or(UNRESERVED);
        UNRESERVED.set(33);
        UNRESERVED.set(126);
        UNRESERVED.set(39);
        UNRESERVED.set(40);
        UNRESERVED.set(41);
        PUNCT.set(44);
        PUNCT.set(59);
        PUNCT.set(58);
        PUNCT.set(36);
        PUNCT.set(38);
        PUNCT.set(43);
        PUNCT.set(61);
        USERINFO.or(UNRESERVED);
        USERINFO.or(PUNCT);
        PATHSAFE.or(UNRESERVED);
        PATHSAFE.set(47);
        PATHSAFE.set(59);
        PATHSAFE.set(58);
        PATHSAFE.set(64);
        PATHSAFE.set(38);
        PATHSAFE.set(61);
        PATHSAFE.set(43);
        PATHSAFE.set(36);
        PATHSAFE.set(44);
        RESERVED.set(59);
        RESERVED.set(47);
        RESERVED.set(63);
        RESERVED.set(58);
        RESERVED.set(64);
        RESERVED.set(38);
        RESERVED.set(61);
        RESERVED.set(43);
        RESERVED.set(36);
        RESERVED.set(44);
        RESERVED.set(91);
        RESERVED.set(93);
        FRAGMENT.or(RESERVED);
        FRAGMENT.or(UNRESERVED);
    }

    private static String decodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "UTF-8";
        }
        return urldecode(str, Charset.forName(str2), true);
    }

    private static String decodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Charset.forName("UTF-8");
        }
        return urldecode(str, charset, true);
    }

    static String encFragment(String str, Charset charset) {
        return urlencode(str, charset, FRAGMENT, false);
    }

    static String encPath(String str, Charset charset) {
        return urlencode(str, charset, PATHSAFE, false);
    }

    static String encUserInfo(String str, Charset charset) {
        return urlencode(str, charset, USERINFO, false);
    }

    private static String encodeFormFields(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "UTF-8";
        }
        return urlencode(str, Charset.forName(str2), URLENCODER, true);
    }

    private static String encodeFormFields(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Charset.forName("UTF-8");
        }
        return urlencode(str, charset, URLENCODER, true);
    }

    public static String format(Iterable<? extends NameValuePair> iterable, Charset charset) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair next : iterable) {
            String encodeFormFields = encodeFormFields(next.getName(), charset);
            String encodeFormFields2 = encodeFormFields(next.getValue(), charset);
            if (sb.length() > 0) {
                sb.append(PARAMETER_SEPARATOR);
            }
            sb.append(encodeFormFields);
            if (encodeFormFields2 != null) {
                sb.append(NAME_VALUE_SEPARATOR);
                sb.append(encodeFormFields2);
            }
        }
        return sb.toString();
    }

    public static String format(List<? extends NameValuePair> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair next : list) {
            String encodeFormFields = encodeFormFields(next.getName(), str);
            String encodeFormFields2 = encodeFormFields(next.getValue(), str);
            if (sb.length() > 0) {
                sb.append(PARAMETER_SEPARATOR);
            }
            sb.append(encodeFormFields);
            if (encodeFormFields2 != null) {
                sb.append(NAME_VALUE_SEPARATOR);
                sb.append(encodeFormFields2);
            }
        }
        return sb.toString();
    }

    public static boolean isEncoded(HttpEntity httpEntity) {
        Header contentType = httpEntity.getContentType();
        if (contentType != null) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return elements[0].getName().equalsIgnoreCase("application/x-www-form-urlencoded");
            }
        }
        return false;
    }

    public static List<NameValuePair> parse(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        BasicHeaderValueParser basicHeaderValueParser = BasicHeaderValueParser.DEFAULT;
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            NameValuePair parseNameValuePair = basicHeaderValueParser.parseNameValuePair(charArrayBuffer, parserCursor, DELIM);
            if (parseNameValuePair.getName().length() > 0) {
                arrayList.add(new BasicNameValuePair(parseNameValuePair.getName(), parseNameValuePair.getValue()));
            }
        }
        return arrayList;
    }

    public static List<NameValuePair> parse(URI uri) {
        String rawQuery = uri.getRawQuery();
        if (TextUtils.isEmpty(rawQuery)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        parse(arrayList, new Scanner(rawQuery));
        return arrayList;
    }

    public static void parse(List<NameValuePair> list, Scanner scanner) {
        String str;
        String str2;
        scanner.useDelimiter(PARAMETER_SEPARATOR);
        while (scanner.hasNext()) {
            String next = scanner.next();
            int indexOf = next.indexOf(NAME_VALUE_SEPARATOR);
            if (indexOf != -1) {
                str2 = next.substring(0, indexOf).trim();
                str = next.substring(indexOf + 1).trim();
            } else {
                String trim = next.trim();
                str = null;
                str2 = trim;
            }
            list.add(new BasicNameValuePair(str2, str));
        }
    }

    private static String urldecode(String str, Charset charset, boolean z) {
        byte b2;
        if (str == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(str.length());
        CharBuffer wrap = CharBuffer.wrap(str);
        while (wrap.hasRemaining()) {
            int i = wrap.get();
            if (i == 37 && wrap.remaining() >= 2) {
                char c2 = wrap.get();
                char c3 = wrap.get();
                int digit = Character.digit(c2, 16);
                int digit2 = Character.digit(c3, 16);
                if (digit == -1 || digit2 == -1) {
                    allocate.put((byte) 37);
                    allocate.put((byte) c2);
                    b2 = (byte) c3;
                    allocate.put(b2);
                } else {
                    i = (digit << 4) + digit2;
                }
            } else if (z && i == 43) {
                b2 = 32;
                allocate.put(b2);
            }
            b2 = (byte) i;
            allocate.put(b2);
        }
        allocate.flip();
        return charset.decode(allocate).toString();
    }

    private static String urlencode(String str, Charset charset, BitSet bitSet, boolean z) {
        char upperCase;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b2 = encode.get() & 255;
            if (bitSet.get(b2)) {
                upperCase = (char) b2;
            } else if (!z || b2 != 32) {
                sb.append("%");
                char upperCase2 = Character.toUpperCase(Character.forDigit((b2 >> 4) & 15, 16));
                upperCase = Character.toUpperCase(Character.forDigit(b2 & bg.m, 16));
                sb.append(upperCase2);
            } else {
                upperCase = '+';
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }
}
