package com.google.a.g;

import com.google.a.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.w;
import java.util.Map;
import org.apache.commons.io.IOUtils;

public final class f extends s {
    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    private static String b(String str) {
        String str2;
        int i;
        int i2;
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        str2 = "%V";
                    } else if (charAt != '`') {
                        switch (charAt) {
                            case '-':
                            case '.':
                                break;
                            default:
                                if (charAt > 26) {
                                    if (charAt >= ' ') {
                                        if (charAt > ',' && charAt != '/' && charAt != ':') {
                                            if (charAt <= '9') {
                                                i2 = (charAt - '0') + 48;
                                            } else if (charAt <= '?') {
                                                sb.append('%');
                                                i2 = (charAt - ';') + 70;
                                            } else if (charAt <= 'Z') {
                                                i = charAt - 'A';
                                            } else if (charAt <= '_') {
                                                sb.append('%');
                                                i2 = (charAt - '[') + 75;
                                            } else if (charAt <= 'z') {
                                                sb.append('+');
                                                i = charAt - 'a';
                                            } else if (charAt <= 127) {
                                                sb.append('%');
                                                i2 = (charAt - '{') + 80;
                                            } else {
                                                throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i3) + "'");
                                            }
                                            charAt = (char) i2;
                                            break;
                                        } else {
                                            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                                            i = charAt - '!';
                                        }
                                    } else {
                                        sb.append('%');
                                        i = charAt - 27;
                                    }
                                } else {
                                    sb.append('$');
                                    i = charAt - 1;
                                }
                                i2 = i + 65;
                                charAt = (char) i2;
                        }
                    } else {
                        str2 = "%W";
                    }
                }
                sb.append(charAt);
            } else {
                str2 = "%U";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    public final b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (aVar == a.CODE_39) {
            return super.a(str, aVar, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            } else if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i)) < 0) {
                str = b(str);
                length = str.length();
                if (length > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i++;
            }
        }
        int[] iArr = new int[9];
        int i2 = length + 25;
        int i3 = 0;
        while (i3 < length) {
            a(e.f3200b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i3))], iArr);
            int i4 = i2;
            for (int i5 = 0; i5 < 9; i5++) {
                i4 += iArr[i5];
            }
            i3++;
            i2 = i4;
        }
        boolean[] zArr = new boolean[i2];
        a(148, iArr);
        int a2 = a(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int a3 = a2 + a(zArr, a2, iArr2, false);
        for (int i6 = 0; i6 < length; i6++) {
            a(e.f3200b["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i6))], iArr);
            int a4 = a3 + a(zArr, a3, iArr, true);
            a3 = a4 + a(zArr, a4, iArr2, false);
        }
        a(148, iArr);
        a(zArr, a3, iArr, true);
        return zArr;
    }
}
