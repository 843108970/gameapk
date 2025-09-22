package com.cyjh.mobileanjian.ipc.utils;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public final class FileUtils {
    private static String a(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.charAt(0) == File.separatorChar) {
            stringBuffer.deleteCharAt(0);
            if (stringBuffer.length() == 0) {
                return null;
            }
        }
        while (stringBuffer.charAt(stringBuffer.length() - 1) == File.separator.charAt(0)) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            if (stringBuffer.length() == 0) {
                return null;
            }
        }
        return stringBuffer.toString();
    }

    public static void copyAssetsFile(Context context, String str, String str2) {
        try {
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x008d A[SYNTHETIC, Splitter:B:44:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092 A[Catch:{ IOException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009d A[SYNTHETIC, Splitter:B:54:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2 A[Catch:{ IOException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a9 A[SYNTHETIC, Splitter:B:61:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b1 A[Catch:{ IOException -> 0x00ad }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:41:0x0088=Splitter:B:41:0x0088, B:51:0x0098=Splitter:B:51:0x0098} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyRawFile(android.content.Context r6, int r7, java.lang.String r8) {
        /*
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            r2.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            boolean r3 = r2.exists()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            if (r3 != 0) goto L_0x0011
            r2.createNewFile()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            goto L_0x0039
        L_0x0011:
            boolean r3 = r2.isDirectory()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            if (r3 == 0) goto L_0x0039
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            java.lang.String r2 = r2.getResourceName(r7)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            r4.append(r8)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            java.lang.String r8 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            r4.append(r8)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            r4.append(r2)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            java.lang.String r8 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            r3.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            r2 = r3
        L_0x0039:
            r8 = 4096(0x1000, float:5.74E-42)
            byte[] r8 = new byte[r8]     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            java.io.InputStream r6 = r6.openRawResource(r7)     // Catch:{ FileNotFoundException -> 0x0096, IOException -> 0x0086, all -> 0x0083 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0077, all -> 0x0071 }
            r7.<init>(r2)     // Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x0077, all -> 0x0071 }
        L_0x004a:
            int r0 = r6.read(r8)     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, all -> 0x0065 }
            if (r0 <= 0) goto L_0x0054
            r7.write(r8, r1, r0)     // Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x0069, all -> 0x0065 }
            goto L_0x004a
        L_0x0054:
            r1 = 1
            if (r6 == 0) goto L_0x005d
            r6.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r6 = move-exception
            goto L_0x0061
        L_0x005d:
            r7.close()     // Catch:{ IOException -> 0x005b }
            return r1
        L_0x0061:
            r6.printStackTrace()
            return r1
        L_0x0065:
            r8 = move-exception
            r0 = r6
            r6 = r8
            goto L_0x00a7
        L_0x0069:
            r8 = move-exception
            r0 = r6
            r6 = r8
            goto L_0x0088
        L_0x006d:
            r8 = move-exception
            r0 = r6
            r6 = r8
            goto L_0x0098
        L_0x0071:
            r7 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L_0x00a7
        L_0x0077:
            r7 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L_0x0088
        L_0x007d:
            r7 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L_0x0098
        L_0x0083:
            r6 = move-exception
            r7 = r0
            goto L_0x00a7
        L_0x0086:
            r6 = move-exception
            r7 = r0
        L_0x0088:
            r6.printStackTrace()     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0090
            r0.close()     // Catch:{ IOException -> 0x005b }
        L_0x0090:
            if (r7 == 0) goto L_0x00a5
            r7.close()     // Catch:{ IOException -> 0x005b }
            return r1
        L_0x0096:
            r6 = move-exception
            r7 = r0
        L_0x0098:
            r6.printStackTrace()     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x00a0
            r0.close()     // Catch:{ IOException -> 0x005b }
        L_0x00a0:
            if (r7 == 0) goto L_0x00a5
            r7.close()     // Catch:{ IOException -> 0x005b }
        L_0x00a5:
            return r1
        L_0x00a6:
            r6 = move-exception
        L_0x00a7:
            if (r0 == 0) goto L_0x00af
            r0.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00af
        L_0x00ad:
            r7 = move-exception
            goto L_0x00b5
        L_0x00af:
            if (r7 == 0) goto L_0x00b8
            r7.close()     // Catch:{ IOException -> 0x00ad }
            goto L_0x00b8
        L_0x00b5:
            r7.printStackTrace()
        L_0x00b8:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.utils.FileUtils.copyRawFile(android.content.Context, int, java.lang.String):boolean");
    }

    public static String file2Text(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File(str);
        try {
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                stringBuffer.append(new String(bArr, 0, read, str2));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getBaseFilePath(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x001b
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x001b
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            if (r0 < 0) goto L_0x001b
            int r1 = r2.length()
            if (r0 >= r1) goto L_0x001b
            r1 = 0
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x001b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.utils.FileUtils.getBaseFilePath(java.lang.String):java.lang.String");
    }

    public static String makeAbsolutePath(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        for (String str2 : strArr) {
            if (str2 == null) {
                return null;
            }
        }
        String str3 = File.separator;
        StringBuffer stringBuffer = new StringBuffer();
        if (!str.startsWith(str3)) {
            stringBuffer.append(str3);
        }
        stringBuffer.append(str);
        if (!str.endsWith(str3)) {
            stringBuffer.append(str3);
        }
        for (String a2 : strArr) {
            String a3 = a(a2);
            if (a3 != null) {
                stringBuffer.append(a3);
                stringBuffer.append(str3);
            }
        }
        if (stringBuffer.lastIndexOf(str3) == stringBuffer.length() - 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cd A[SYNTHETIC, Splitter:B:54:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d6 A[Catch:{ IOException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e6 A[SYNTHETIC, Splitter:B:68:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00eb A[Catch:{ IOException -> 0x00d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f3 A[SYNTHETIC, Splitter:B:76:0x00f3] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fc A[Catch:{ IOException -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:65:0x00e1=Splitter:B:65:0x00e1, B:51:0x00c8=Splitter:B:51:0x00c8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int moveFiles(java.lang.String r17, java.lang.String r18, boolean r19) {
        /*
            r1 = r17
            r2 = r18
            java.io.File r3 = new java.io.File
            r3.<init>(r1)
            java.io.File r4 = new java.io.File
            r4.<init>(r2)
            boolean r5 = r3.exists()
            if (r5 != 0) goto L_0x0016
            r1 = 1
            return r1
        L_0x0016:
            boolean r5 = r4.exists()
            if (r5 != 0) goto L_0x001e
            r1 = 2
            return r1
        L_0x001e:
            boolean r4 = r4.isDirectory()
            if (r4 != 0) goto L_0x0026
            r1 = 3
            return r1
        L_0x0026:
            boolean r4 = r3.isFile()
            r5 = -1
            if (r4 == 0) goto L_0x0104
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r7 = java.io.File.separator
            r6.append(r7)
            java.lang.String r7 = r3.getName()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r4.<init>(r6)
            boolean r4 = r4.exists()
            if (r4 == 0) goto L_0x0054
            if (r19 != 0) goto L_0x0054
            r1 = 4
            return r1
        L_0x0054:
            r4 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00de, IOException -> 0x00c5, all -> 0x00c1 }
            r6.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00de, IOException -> 0x00c5, all -> 0x00c1 }
            java.nio.channels.FileChannel r1 = r6.getChannel()     // Catch:{ FileNotFoundException -> 0x00de, IOException -> 0x00c5, all -> 0x00c1 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            r7.append(r2)     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            r7.append(r2)     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            java.lang.String r2 = r3.getName()     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            r7.append(r2)     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            java.lang.String r2 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            r6.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            java.nio.channels.FileChannel r2 = r6.getChannel()     // Catch:{ FileNotFoundException -> 0x00bc, IOException -> 0x00b7, all -> 0x00b3 }
            r13 = 0
            r15 = r13
        L_0x0082:
            r4 = 0
            long r11 = r13 - r15
            r7 = r2
            r8 = r1
            r9 = r15
            long r6 = r7.transferFrom(r8, r9, r11)     // Catch:{ FileNotFoundException -> 0x00b1, IOException -> 0x00af, all -> 0x00ad }
            r4 = 0
            long r8 = r15 + r6
            int r4 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r4 < 0) goto L_0x00ab
            r3.delete()     // Catch:{ FileNotFoundException -> 0x00b1, IOException -> 0x00af, all -> 0x00ad }
            if (r1 == 0) goto L_0x009f
            r1.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x009f
        L_0x009c:
            r0 = move-exception
            r1 = r0
            goto L_0x00a6
        L_0x009f:
            if (r2 == 0) goto L_0x0107
            r2.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x0107
        L_0x00a6:
            r1.printStackTrace()
            goto L_0x0107
        L_0x00ab:
            r15 = r8
            goto L_0x0082
        L_0x00ad:
            r0 = move-exception
            goto L_0x00b5
        L_0x00af:
            r0 = move-exception
            goto L_0x00b9
        L_0x00b1:
            r0 = move-exception
            goto L_0x00be
        L_0x00b3:
            r0 = move-exception
            r2 = r4
        L_0x00b5:
            r4 = r1
            goto L_0x00f0
        L_0x00b7:
            r0 = move-exception
            r2 = r4
        L_0x00b9:
            r4 = r1
            r1 = r0
            goto L_0x00c8
        L_0x00bc:
            r0 = move-exception
            r2 = r4
        L_0x00be:
            r4 = r1
            r1 = r0
            goto L_0x00e1
        L_0x00c1:
            r0 = move-exception
            r1 = r0
            r2 = r4
            goto L_0x00f1
        L_0x00c5:
            r0 = move-exception
            r1 = r0
            r2 = r4
        L_0x00c8:
            r1.printStackTrace()     // Catch:{ all -> 0x00ef }
            if (r4 == 0) goto L_0x00d4
            r4.close()     // Catch:{ IOException -> 0x00d1 }
            goto L_0x00d4
        L_0x00d1:
            r0 = move-exception
            r1 = r0
            goto L_0x00da
        L_0x00d4:
            if (r2 == 0) goto L_0x0108
            r2.close()     // Catch:{ IOException -> 0x00d1 }
            return r5
        L_0x00da:
            r1.printStackTrace()
            return r5
        L_0x00de:
            r0 = move-exception
            r1 = r0
            r2 = r4
        L_0x00e1:
            r1.printStackTrace()     // Catch:{ all -> 0x00ef }
            if (r4 == 0) goto L_0x00e9
            r4.close()     // Catch:{ IOException -> 0x00d1 }
        L_0x00e9:
            if (r2 == 0) goto L_0x0108
            r2.close()     // Catch:{ IOException -> 0x00d1 }
            return r5
        L_0x00ef:
            r0 = move-exception
        L_0x00f0:
            r1 = r0
        L_0x00f1:
            if (r4 == 0) goto L_0x00fa
            r4.close()     // Catch:{ IOException -> 0x00f7 }
            goto L_0x00fa
        L_0x00f7:
            r0 = move-exception
            r2 = r0
            goto L_0x0100
        L_0x00fa:
            if (r2 == 0) goto L_0x0103
            r2.close()     // Catch:{ IOException -> 0x00f7 }
            goto L_0x0103
        L_0x0100:
            r2.printStackTrace()
        L_0x0103:
            throw r1
        L_0x0104:
            r3.isDirectory()
        L_0x0107:
            r5 = 0
        L_0x0108:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.utils.FileUtils.moveFiles(java.lang.String, java.lang.String, boolean):int");
    }

    public static void recursionDeleteFiles(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    recursionDeleteFiles(file2.getAbsolutePath());
                }
                file2.delete();
            }
        }
    }

    public static void writeStringToFile(File file, String str) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
