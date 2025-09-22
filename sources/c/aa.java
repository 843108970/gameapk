package c;

public final class aa {
    private aa() {
    }

    private static long a(String str) {
        long j;
        long j2;
        int length = str.length();
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (length < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + length + " < 0");
        } else if (length > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + length + " > " + str.length());
        } else {
            long j3 = 0;
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    i++;
                    j3++;
                } else {
                    if (charAt < 2048) {
                        j = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        j = 3;
                    } else {
                        int i2 = i + 1;
                        char charAt2 = i2 < length ? str.charAt(i2) : 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j3++;
                            i = i2;
                        } else {
                            j2 = j3 + 4;
                            i += 2;
                            j3 = j2;
                        }
                    }
                    j2 = j3 + j;
                    i++;
                    j3 = j2;
                }
            }
            return j3;
        }
    }

    private static long a(String str, int i) {
        long j;
        long j2;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i + " < 0");
        } else if (i > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i + " > " + str.length());
        } else {
            long j3 = 0;
            int i2 = 0;
            while (i2 < i) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    i2++;
                    j3++;
                } else {
                    if (charAt < 2048) {
                        j = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        j = 3;
                    } else {
                        int i3 = i2 + 1;
                        char charAt2 = i3 < i ? str.charAt(i3) : 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j3++;
                            i2 = i3;
                        } else {
                            j2 = j3 + 4;
                            i2 += 2;
                            j3 = j2;
                        }
                    }
                    j2 = j3 + j;
                    i2++;
                    j3 = j2;
                }
            }
            return j3;
        }
    }
}
