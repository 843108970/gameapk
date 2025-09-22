package com.google.a.d.a;

import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.a.h;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f3096a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f3097b = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', FilenameUtils.EXTENSION_SEPARATOR, IOUtils.DIR_SEPARATOR_UNIX, ':', ';', '<', '=', '>', '?', '@', '[', IOUtils.DIR_SEPARATOR_WINDOWS, ']', '^', '_'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f3098c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] d = f3097b;
    private static final char[] e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* renamed from: com.google.a.d.a.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3099a = new int[a.values$68f9f718().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        static {
            /*
                int[] r0 = com.google.a.d.a.c.a.values$68f9f718()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3099a = r0
                r0 = 1
                int[] r1 = f3099a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.google.a.d.a.c.a.C40_ENCODE$6e85352     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = r2 - r0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r1 = f3099a     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = com.google.a.d.a.c.a.TEXT_ENCODE$6e85352     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = r2 - r0
                r3 = 2
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r1 = f3099a     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = com.google.a.d.a.c.a.ANSIX12_ENCODE$6e85352     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2 - r0
                r3 = 3
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r1 = f3099a     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = com.google.a.d.a.c.a.EDIFACT_ENCODE$6e85352     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = r2 - r0
                r3 = 4
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                int[] r1 = f3099a     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = com.google.a.d.a.c.a.BASE256_ENCODE$6e85352     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = r2 - r0
                r0 = 5
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.c.AnonymousClass1.<clinit>():void");
        }
    }

    private enum a {
        ;
        
        public static final int ANSIX12_ENCODE$6e85352 = 5;
        public static final int ASCII_ENCODE$6e85352 = 2;
        public static final int BASE256_ENCODE$6e85352 = 7;
        public static final int C40_ENCODE$6e85352 = 3;
        public static final int EDIFACT_ENCODE$6e85352 = 6;
        public static final int PAD_ENCODE$6e85352 = 1;
        public static final int TEXT_ENCODE$6e85352 = 4;

        static {
            $VALUES$3a3249a9 = new int[]{PAD_ENCODE$6e85352, ASCII_ENCODE$6e85352, C40_ENCODE$6e85352, TEXT_ENCODE$6e85352, ANSIX12_ENCODE$6e85352, EDIFACT_ENCODE$6e85352, BASE256_ENCODE$6e85352};
        }

        public static int[] values$68f9f718() {
            return (int[]) $VALUES$3a3249a9.clone();
        }
    }

    private c() {
    }

    private static int a(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }

    private static int a(com.google.a.c.c cVar, StringBuilder sb, StringBuilder sb2) throws h {
        String str;
        boolean z = false;
        do {
            int a2 = cVar.a(8);
            if (a2 == 0) {
                throw h.getFormatInstance();
            } else if (a2 <= 128) {
                if (z) {
                    a2 += 128;
                }
                sb.append((char) (a2 - 1));
                return a.ASCII_ENCODE$6e85352;
            } else if (a2 == 129) {
                return a.PAD_ENCODE$6e85352;
            } else {
                if (a2 <= 229) {
                    int i = a2 - 130;
                    if (i < 10) {
                        sb.append('0');
                    }
                    sb.append(i);
                } else {
                    switch (a2) {
                        case 230:
                            return a.C40_ENCODE$6e85352;
                        case 231:
                            return a.BASE256_ENCODE$6e85352;
                        case 232:
                            sb.append(29);
                            break;
                        case 233:
                        case 234:
                        case 241:
                            break;
                        case 235:
                            z = true;
                            break;
                        case 236:
                            str = "[)>\u001e05\u001d";
                            break;
                        case 237:
                            str = "[)>\u001e06\u001d";
                            break;
                        case 238:
                            return a.ANSIX12_ENCODE$6e85352;
                        case 239:
                            return a.TEXT_ENCODE$6e85352;
                        case 240:
                            return a.EDIFACT_ENCODE$6e85352;
                        default:
                            if (!(a2 == 254 && cVar.a() == 0)) {
                                throw h.getFormatInstance();
                            }
                    }
                    sb.append(str);
                    sb2.insert(0, "\u001e\u0004");
                }
            }
        } while (cVar.a() > 0);
        return a.ASCII_ENCODE$6e85352;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.a.c.e a(byte[] r6) throws com.google.a.h {
        /*
            com.google.a.c.c r0 = new com.google.a.c.c
            r0.<init>(r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 100
            r1.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 0
            r2.<init>(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 1
            r3.<init>(r4)
            int r4 = com.google.a.d.a.c.a.ASCII_ENCODE$6e85352
        L_0x001a:
            int r5 = com.google.a.d.a.c.a.ASCII_ENCODE$6e85352
            if (r4 != r5) goto L_0x0023
            int r4 = a((com.google.a.c.c) r0, (java.lang.StringBuilder) r1, (java.lang.StringBuilder) r2)
            goto L_0x0046
        L_0x0023:
            int[] r5 = com.google.a.d.a.c.AnonymousClass1.f3099a
            int r4 = r4 + -1
            r4 = r5[r4]
            switch(r4) {
                case 1: goto L_0x0041;
                case 2: goto L_0x003d;
                case 3: goto L_0x0039;
                case 4: goto L_0x0035;
                case 5: goto L_0x0031;
                default: goto L_0x002c;
            }
        L_0x002c:
            com.google.a.h r6 = com.google.a.h.getFormatInstance()
            throw r6
        L_0x0031:
            a((com.google.a.c.c) r0, (java.lang.StringBuilder) r1, (java.util.Collection<byte[]>) r3)
            goto L_0x0044
        L_0x0035:
            d(r0, r1)
            goto L_0x0044
        L_0x0039:
            c(r0, r1)
            goto L_0x0044
        L_0x003d:
            b(r0, r1)
            goto L_0x0044
        L_0x0041:
            a((com.google.a.c.c) r0, (java.lang.StringBuilder) r1)
        L_0x0044:
            int r4 = com.google.a.d.a.c.a.ASCII_ENCODE$6e85352
        L_0x0046:
            int r5 = com.google.a.d.a.c.a.PAD_ENCODE$6e85352
            if (r4 == r5) goto L_0x0050
            int r5 = r0.a()
            if (r5 > 0) goto L_0x001a
        L_0x0050:
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x0059
            r1.append(r2)
        L_0x0059:
            com.google.a.c.e r0 = new com.google.a.c.e
            java.lang.String r1 = r1.toString()
            boolean r2 = r3.isEmpty()
            r4 = 0
            if (r2 == 0) goto L_0x0067
            r3 = r4
        L_0x0067:
            r0.<init>(r6, r1, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.c.a(byte[]):com.google.a.c.e");
    }

    private static void a(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        int i5 = i3 - (i4 * 1600);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r9.append((char) r6);
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r9.append((char) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008c, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.a.c.c r8, java.lang.StringBuilder r9) throws com.google.a.h {
        /*
            r0 = 3
            int[] r1 = new int[r0]
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0006:
            int r5 = r8.a()
            r6 = 8
            if (r5 != r6) goto L_0x000f
            return
        L_0x000f:
            int r5 = r8.a(r6)
            r7 = 254(0xfe, float:3.56E-43)
            if (r5 != r7) goto L_0x0018
            return
        L_0x0018:
            int r6 = r8.a(r6)
            a((int) r5, (int) r6, (int[]) r1)
            r5 = r3
            r3 = 0
        L_0x0021:
            if (r3 >= r0) goto L_0x0094
            r6 = r1[r3]
            switch(r4) {
                case 0: goto L_0x0071;
                case 1: goto L_0x006a;
                case 2: goto L_0x003e;
                case 3: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            com.google.a.h r8 = com.google.a.h.getFormatInstance()
            throw r8
        L_0x002d:
            if (r5 == 0) goto L_0x0037
            int r6 = r6 + 224
        L_0x0031:
            char r4 = (char) r6
            r9.append(r4)
            r5 = 0
            goto L_0x006f
        L_0x0037:
            int r6 = r6 + 96
        L_0x0039:
            char r4 = (char) r6
            r9.append(r4)
            goto L_0x006f
        L_0x003e:
            char[] r4 = f3097b
            int r4 = r4.length
            if (r6 >= r4) goto L_0x0055
            char[] r4 = f3097b
            char r4 = r4[r6]
            if (r5 == 0) goto L_0x0051
            int r4 = r4 + 128
            char r4 = (char) r4
            r9.append(r4)
            r4 = 0
            goto L_0x0068
        L_0x0051:
            r9.append(r4)
            goto L_0x0067
        L_0x0055:
            r4 = 27
            if (r6 == r4) goto L_0x0064
            r4 = 30
            if (r6 == r4) goto L_0x0062
            com.google.a.h r8 = com.google.a.h.getFormatInstance()
            throw r8
        L_0x0062:
            r4 = 1
            goto L_0x0068
        L_0x0064:
            r4 = 29
            goto L_0x0051
        L_0x0067:
            r4 = r5
        L_0x0068:
            r5 = r4
            goto L_0x006f
        L_0x006a:
            if (r5 == 0) goto L_0x0039
            int r6 = r6 + 128
            goto L_0x0031
        L_0x006f:
            r4 = 0
            goto L_0x008c
        L_0x0071:
            if (r6 >= r0) goto L_0x0076
            int r4 = r6 + 1
            goto L_0x008c
        L_0x0076:
            char[] r7 = f3096a
            int r7 = r7.length
            if (r6 >= r7) goto L_0x008f
            char[] r7 = f3096a
            char r6 = r7[r6]
            if (r5 == 0) goto L_0x0089
            int r6 = r6 + 128
            char r5 = (char) r6
            r9.append(r5)
            r5 = 0
            goto L_0x008c
        L_0x0089:
            r9.append(r6)
        L_0x008c:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x008f:
            com.google.a.h r8 = com.google.a.h.getFormatInstance()
            throw r8
        L_0x0094:
            int r3 = r8.a()
            if (r3 > 0) goto L_0x009b
            return
        L_0x009b:
            r3 = r5
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.c.a(com.google.a.c.c, java.lang.StringBuilder):void");
    }

    private static void a(com.google.a.c.c cVar, StringBuilder sb, Collection<byte[]> collection) throws h {
        int i = cVar.f3072a + 1;
        int i2 = i + 1;
        int a2 = a(cVar.a(8), i);
        if (a2 == 0) {
            a2 = cVar.a() / 8;
        } else if (a2 >= 250) {
            a2 = ((a2 - 249) * ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + a(cVar.a(8), i2);
            i2++;
        }
        if (a2 < 0) {
            throw h.getFormatInstance();
        }
        byte[] bArr = new byte[a2];
        int i3 = 0;
        while (i3 < a2) {
            if (cVar.a() < 8) {
                throw h.getFormatInstance();
            }
            bArr[i3] = (byte) a(cVar.a(8), i2);
            i3++;
            i2++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e2)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        r9.append(r4);
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        r9.append(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(com.google.a.c.c r8, java.lang.StringBuilder r9) throws com.google.a.h {
        /*
            r0 = 3
            int[] r1 = new int[r0]
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0006:
            int r5 = r8.a()
            r6 = 8
            if (r5 != r6) goto L_0x000f
            return
        L_0x000f:
            int r5 = r8.a(r6)
            r7 = 254(0xfe, float:3.56E-43)
            if (r5 != r7) goto L_0x0018
            return
        L_0x0018:
            int r6 = r8.a(r6)
            a((int) r5, (int) r6, (int[]) r1)
            r5 = r3
            r3 = 0
        L_0x0021:
            if (r3 >= r0) goto L_0x00a2
            r6 = r1[r3]
            switch(r4) {
                case 0: goto L_0x007f;
                case 1: goto L_0x0075;
                case 2: goto L_0x0049;
                case 3: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            com.google.a.h r8 = com.google.a.h.getFormatInstance()
            throw r8
        L_0x002d:
            char[] r4 = e
            int r4 = r4.length
            if (r6 >= r4) goto L_0x0044
            char[] r4 = e
            char r4 = r4[r6]
            if (r5 == 0) goto L_0x0040
            int r4 = r4 + 128
            char r4 = (char) r4
        L_0x003b:
            r9.append(r4)
            r5 = 0
            goto L_0x007d
        L_0x0040:
            r9.append(r4)
            goto L_0x007d
        L_0x0044:
            com.google.a.h r8 = com.google.a.h.getFormatInstance()
            throw r8
        L_0x0049:
            char[] r4 = d
            int r4 = r4.length
            if (r6 >= r4) goto L_0x0060
            char[] r4 = d
            char r4 = r4[r6]
            if (r5 == 0) goto L_0x005c
            int r4 = r4 + 128
            char r4 = (char) r4
            r9.append(r4)
            r4 = 0
            goto L_0x0073
        L_0x005c:
            r9.append(r4)
            goto L_0x0072
        L_0x0060:
            r4 = 27
            if (r6 == r4) goto L_0x006f
            r4 = 30
            if (r6 == r4) goto L_0x006d
            com.google.a.h r8 = com.google.a.h.getFormatInstance()
            throw r8
        L_0x006d:
            r4 = 1
            goto L_0x0073
        L_0x006f:
            r4 = 29
            goto L_0x005c
        L_0x0072:
            r4 = r5
        L_0x0073:
            r5 = r4
            goto L_0x007d
        L_0x0075:
            if (r5 == 0) goto L_0x007b
            int r6 = r6 + 128
            char r4 = (char) r6
            goto L_0x003b
        L_0x007b:
            char r4 = (char) r6
            goto L_0x0040
        L_0x007d:
            r4 = 0
            goto L_0x009a
        L_0x007f:
            if (r6 >= r0) goto L_0x0084
            int r4 = r6 + 1
            goto L_0x009a
        L_0x0084:
            char[] r7 = f3098c
            int r7 = r7.length
            if (r6 >= r7) goto L_0x009d
            char[] r7 = f3098c
            char r6 = r7[r6]
            if (r5 == 0) goto L_0x0097
            int r6 = r6 + 128
            char r5 = (char) r6
            r9.append(r5)
            r5 = 0
            goto L_0x009a
        L_0x0097:
            r9.append(r6)
        L_0x009a:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x009d:
            com.google.a.h r8 = com.google.a.h.getFormatInstance()
            throw r8
        L_0x00a2:
            int r3 = r8.a()
            if (r3 > 0) goto L_0x00a9
            return
        L_0x00a9:
            r3 = r5
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.c.b(com.google.a.c.c, java.lang.StringBuilder):void");
    }

    private static void c(com.google.a.c.c cVar, StringBuilder sb) throws h {
        int a2;
        char c2;
        int i;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (a2 = cVar.a(8)) != 254) {
            a(a2, cVar.a(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                switch (i3) {
                    case 0:
                        c2 = 13;
                        break;
                    case 1:
                        c2 = '*';
                        break;
                    case 2:
                        c2 = '>';
                        break;
                    case 3:
                        c2 = ' ';
                        break;
                    default:
                        if (i3 < 14) {
                            i = i3 + 44;
                        } else if (i3 < 40) {
                            i = i3 + 51;
                        } else {
                            throw h.getFormatInstance();
                        }
                        c2 = (char) i;
                        break;
                }
                sb.append(c2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void d(com.google.a.c.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i = 0; i < 4; i++) {
                int a2 = cVar.a(6);
                if (a2 == 31) {
                    int i2 = 8 - cVar.f3073b;
                    if (i2 != 8) {
                        cVar.a(i2);
                        return;
                    }
                    return;
                }
                if ((a2 & 32) == 0) {
                    a2 |= 64;
                }
                sb.append((char) a2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }
}
