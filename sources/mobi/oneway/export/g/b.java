package mobi.oneway.export.g;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class b {
    public static String a(String str) {
        return new String(a(str.getBytes("utf-8")), "ASCII");
    }

    public static String a(String str, String str2) {
        try {
            try {
                return new String(a(str.getBytes(str2)), "ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("ASCII is not supported!", e);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Unsupported charset: " + str2, e2);
        }
    }

    public static void a(File file, File file2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    a((InputStream) fileInputStream, (OutputStream) fileOutputStream2);
                    j.a(fileOutputStream2);
                    j.a(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    j.a(fileOutputStream);
                    j.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                j.a(fileOutputStream);
                j.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            j.a(fileOutputStream);
            j.a(fileInputStream);
            throw th;
        }
    }

    public static void a(File file, File file2, int i) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    a((InputStream) fileInputStream, (OutputStream) fileOutputStream2, i);
                    j.a(fileOutputStream2);
                    j.a(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    j.a(fileOutputStream);
                    j.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                j.a(fileOutputStream);
                j.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            j.a(fileOutputStream);
            j.a(fileInputStream);
            throw th;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        a(inputStream, outputStream, 0);
    }

    public static void a(InputStream inputStream, OutputStream outputStream, int i) {
        d dVar = new d(outputStream, i);
        c(inputStream, dVar);
        dVar.a();
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0);
    }

    public static byte[] a(byte[] bArr, int i) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a((InputStream) byteArrayInputStream, (OutputStream) byteArrayOutputStream, i);
            j.a(byteArrayInputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Unexpected I/O error", e);
        } catch (Throwable th) {
            j.a(byteArrayInputStream, byteArrayOutputStream);
            throw th;
        }
    }

    public static String b(String str) {
        try {
            return new String(b(str.getBytes("ASCII")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII is not supported!", e);
        }
    }

    public static String b(String str, String str2) {
        try {
            try {
                return new String(b(str.getBytes("ASCII")), str2);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Unsupported charset: " + str2, e);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII is not supported!", e2);
        }
    }

    public static void b(File file, File file2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    b((InputStream) fileInputStream, (OutputStream) fileOutputStream2);
                    j.a(fileOutputStream2);
                    j.a(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    j.a(fileOutputStream);
                    j.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                j.a(fileOutputStream);
                j.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            j.a(fileOutputStream);
            j.a(fileInputStream);
            throw th;
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) {
        c(new c(inputStream), outputStream);
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b((InputStream) byteArrayInputStream, (OutputStream) byteArrayOutputStream);
            j.a(byteArrayInputStream);
            j.a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Unexpected I/O error", e);
        } catch (Throwable th) {
            j.a(byteArrayInputStream);
            j.a(byteArrayOutputStream);
            throw th;
        }
    }

    private static void c(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
