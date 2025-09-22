package com.google.protobuf;

import com.lidroid.xutils.util.CharsetUtils;
import java.io.UnsupportedEncodingException;

public class Internal {

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    public static ByteString bytesDefaultValue(String str) {
        try {
            return ByteString.copyFrom(str.getBytes(CharsetUtils.DEFAULT_ENCODING_CHARSET));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static String stringDefaultValue(String str) {
        try {
            return new String(str.getBytes(CharsetUtils.DEFAULT_ENCODING_CHARSET), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Java VM does not support a standard character set.", e);
        }
    }
}
