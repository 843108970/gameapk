package org.apache.harmony.misc;

public class SystemUtils {
    public static final int ARC_IA32 = 1;
    public static final int ARC_IA64 = 2;
    public static final int ARC_UNKNOWN = -1;
    public static final int OS_LINUX = 2;
    public static final int OS_UNKNOWN = -1;
    public static final int OS_WINDOWS = 1;
    private static int arc;
    private static int os;

    public static int getOS() {
        if (os == 0) {
            String substring = System.getProperty("os.name").substring(0, 3);
            os = substring.compareToIgnoreCase("win") == 0 ? 1 : substring.compareToIgnoreCase("lin") == 0 ? 2 : -1;
        }
        return os;
    }
}
