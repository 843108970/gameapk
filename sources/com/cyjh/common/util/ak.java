package com.cyjh.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1665a = "ak";

    /* renamed from: b  reason: collision with root package name */
    private static final int f1666b = 512;

    public static boolean a(File file, File file2) {
        boolean z;
        String str = f1665a;
        ad.c(str, "unzipFile --> zipFile= " + file + ",destDir=" + file2);
        if (file == null || file2 == null) {
            return false;
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            byte[] bArr = new byte[512];
            z = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    if (nextEntry.isDirectory()) {
                        File file3 = new File(file2.getAbsolutePath() + File.separator + nextEntry.getName());
                        if (!file3.exists()) {
                            file3.mkdirs();
                            String str2 = f1665a;
                            ad.c(str2, "unzipFile --> mkdirs: " + file3.getCanonicalPath());
                        }
                    }
                    File a2 = n.a(new File(file2.getAbsolutePath(), nextEntry.getName()));
                    FileOutputStream fileOutputStream = new FileOutputStream(a2);
                    while (true) {
                        int read = zipInputStream.read(bArr, 0, 512);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    z = true;
                    String str3 = f1665a;
                    ad.c(str3, "unzipFile --> success: fileName=" + a2.getName());
                } catch (Exception e) {
                    e = e;
                    String str4 = f1665a;
                    ad.c(str4, "unzipFile --> exception: " + e.getMessage());
                    e.printStackTrace();
                    return z;
                }
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
            String str42 = f1665a;
            ad.c(str42, "unzipFile --> exception: " + e.getMessage());
            e.printStackTrace();
            return z;
        }
        return z;
    }
}
