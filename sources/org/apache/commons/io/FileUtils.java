package org.apache.commons.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.output.NullOutputStream;

public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY = new File[0];
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    public static final long ONE_GB = 1073741824;
    public static final BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI;
    public static final long ONE_MB = 1048576;
    public static final BigInteger ONE_MB_BI;
    public static final long ONE_PB = 1125899906842624L;
    public static final BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    public static final long ONE_TB = 1099511627776L;
    public static final BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
    public static final BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
    public static final BigInteger ONE_ZB = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(ONE_EB));

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        ONE_KB_BI = valueOf;
        ONE_MB_BI = valueOf.multiply(valueOf);
    }

    public static String byteCountToDisplaySize(long j) {
        return byteCountToDisplaySize(BigInteger.valueOf(j));
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        StringBuilder sb;
        String str;
        if (bigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger.divide(ONE_EB_BI)));
            str = " EB";
        } else if (bigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger.divide(ONE_PB_BI)));
            str = " PB";
        } else if (bigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger.divide(ONE_TB_BI)));
            str = " TB";
        } else if (bigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger.divide(ONE_GB_BI)));
            str = " GB";
        } else if (bigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger.divide(ONE_MB_BI)));
            str = " MB";
        } else if (bigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger.divide(ONE_KB_BI)));
            str = " KB";
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(bigInteger));
            str = " bytes";
        }
        sb.append(str);
        return sb.toString();
    }

    private static void checkDirectory(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    private static void checkFileRequirements(File file, File file2) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
    }

    public static Checksum checksum(File file, Checksum checksum) throws IOException {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("Checksums can't be computed on directories");
        }
        CheckedInputStream checkedInputStream = null;
        try {
            CheckedInputStream checkedInputStream2 = new CheckedInputStream(new FileInputStream(file), checksum);
            try {
                IOUtils.copy((InputStream) checkedInputStream2, (OutputStream) new NullOutputStream());
                IOUtils.closeQuietly((InputStream) checkedInputStream2);
                return checksum;
            } catch (Throwable th) {
                th = th;
                checkedInputStream = checkedInputStream2;
                IOUtils.closeQuietly((InputStream) checkedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly((InputStream) checkedInputStream);
            throw th;
        }
    }

    public static long checksumCRC32(File file) throws IOException {
        CRC32 crc32 = new CRC32();
        checksum(file, crc32);
        return crc32.getValue();
    }

    public static void cleanDirectory(File file) throws IOException {
        IOException e = null;
        for (File forceDelete : verifiedListFiles(file)) {
            try {
                forceDelete(forceDelete);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private static void cleanDirectoryOnExit(File file) throws IOException {
        IOException e = null;
        for (File forceDeleteOnExit : verifiedListFiles(file)) {
            try {
                forceDeleteOnExit(forceDeleteOnExit);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static boolean contentEquals(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new IOException("Can't compare directories, only files");
        } else if (file.length() != file2.length()) {
            return false;
        } else {
            if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
                return true;
            }
            FileInputStream fileInputStream3 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream2 = new FileInputStream(file2);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly((InputStream) fileInputStream);
                    IOUtils.closeQuietly((InputStream) fileInputStream3);
                    throw th;
                }
                try {
                    boolean contentEquals = IOUtils.contentEquals((InputStream) fileInputStream, (InputStream) fileInputStream2);
                    IOUtils.closeQuietly((InputStream) fileInputStream);
                    IOUtils.closeQuietly((InputStream) fileInputStream2);
                    return contentEquals;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream3 = fileInputStream2;
                    IOUtils.closeQuietly((InputStream) fileInputStream);
                    IOUtils.closeQuietly((InputStream) fileInputStream3);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                IOUtils.closeQuietly((InputStream) fileInputStream);
                IOUtils.closeQuietly((InputStream) fileInputStream3);
                throw th;
            }
        }
    }

    public static boolean contentEqualsIgnoreEOL(File file, File file2, String str) throws IOException {
        InputStreamReader inputStreamReader;
        Throwable th;
        InputStreamReader inputStreamReader2;
        boolean exists = file.exists();
        if (exists != file2.exists()) {
            return false;
        }
        if (!exists) {
            return true;
        }
        if (file.isDirectory() || file2.isDirectory()) {
            throw new IOException("Can't compare directories, only files");
        } else if (file.getCanonicalFile().equals(file2.getCanonicalFile())) {
            return true;
        } else {
            InputStreamReader inputStreamReader3 = null;
            if (str == null) {
                try {
                    InputStreamReader inputStreamReader4 = new InputStreamReader(new FileInputStream(file), Charset.defaultCharset());
                    try {
                        inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), Charset.defaultCharset());
                        inputStreamReader3 = inputStreamReader4;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader = null;
                        inputStreamReader3 = inputStreamReader4;
                        IOUtils.closeQuietly((Reader) inputStreamReader3);
                        IOUtils.closeQuietly((Reader) inputStreamReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    IOUtils.closeQuietly((Reader) inputStreamReader3);
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    throw th;
                }
            } else {
                InputStreamReader inputStreamReader5 = new InputStreamReader(new FileInputStream(file), str);
                try {
                    inputStreamReader2 = new InputStreamReader(new FileInputStream(file2), str);
                    inputStreamReader3 = inputStreamReader5;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                    inputStreamReader3 = inputStreamReader5;
                    IOUtils.closeQuietly((Reader) inputStreamReader3);
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    throw th;
                }
            }
            try {
                boolean contentEqualsIgnoreEOL = IOUtils.contentEqualsIgnoreEOL(inputStreamReader3, inputStreamReader2);
                IOUtils.closeQuietly((Reader) inputStreamReader3);
                IOUtils.closeQuietly((Reader) inputStreamReader2);
                return contentEqualsIgnoreEOL;
            } catch (Throwable th5) {
                Throwable th6 = th5;
                inputStreamReader = inputStreamReader2;
                th = th6;
                IOUtils.closeQuietly((Reader) inputStreamReader3);
                IOUtils.closeQuietly((Reader) inputStreamReader);
                throw th;
            }
        }
    }

    public static File[] convertFileCollectionToFileArray(Collection<File> collection) {
        return (File[]) collection.toArray(new File[collection.size()]);
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter) throws IOException {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z) throws IOException {
        checkFileRequirements(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            ArrayList arrayList = null;
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
                if (listFiles != null && listFiles.length > 0) {
                    arrayList = new ArrayList(listFiles.length);
                    for (File name : listFiles) {
                        arrayList.add(new File(file2, name.getName()).getCanonicalPath());
                    }
                }
            }
            doCopyDirectory(file, file2, fileFilter, z, arrayList);
        }
    }

    public static void copyDirectory(File file, File file2, boolean z) throws IOException {
        copyDirectory(file, file2, (FileFilter) null, z);
    }

    public static void copyDirectoryToDirectory(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("Source '" + file2 + "' is not a directory");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file2.exists() || file2.isDirectory()) {
            copyDirectory(file, new File(file2, file.getName()), true);
        } else {
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
    }

    public static long copyFile(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return IOUtils.copyLarge((InputStream) fileInputStream, outputStream);
        } finally {
            fileInputStream.close();
        }
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        checkFileRequirements(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        } else {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                doCopyFile(file, file2, z);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        }
    }

    public static void copyFileToDirectory(File file, File file2) throws IOException {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyFileToDirectory(File file, File file2, boolean z) throws IOException {
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file2.exists() || file2.isDirectory()) {
            copyFile(file, new File(file2, file.getName()), z);
        } else {
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
    }

    public static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
        try {
            copyToFile(inputStream, file);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static void copyToFile(InputStream inputStream, File file) throws IOException {
        FileOutputStream openOutputStream = openOutputStream(file);
        try {
            IOUtils.copy(inputStream, (OutputStream) openOutputStream);
            openOutputStream.close();
        } finally {
            IOUtils.closeQuietly((OutputStream) openOutputStream);
        }
    }

    public static void copyURLToFile(URL url, File file) throws IOException {
        copyInputStreamToFile(url.openStream(), file);
    }

    public static void copyURLToFile(URL url, File file, int i, int i2) throws IOException {
        URLConnection openConnection = url.openConnection();
        openConnection.setConnectTimeout(i);
        openConnection.setReadTimeout(i2);
        copyInputStreamToFile(openConnection.getInputStream(), file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        if (r3.position() > 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
        r3.flip();
        r2.append(org.apache.commons.io.Charsets.UTF_8.decode(r3).toString());
        r3.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        r3.flip();
        r2.append(org.apache.commons.io.Charsets.UTF_8.decode(r3).toString());
        r3.clear();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[ExcHandler: all (r8v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:8:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String decodeUrl(java.lang.String r8) {
        /*
            if (r8 == 0) goto L_0x009e
            r0 = 37
            int r1 = r8.indexOf(r0)
            if (r1 < 0) goto L_0x009e
            int r1 = r8.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r1)
            r4 = 0
        L_0x0018:
            if (r4 >= r1) goto L_0x009a
            char r5 = r8.charAt(r4)
            if (r5 != r0) goto L_0x008e
        L_0x0020:
            int r5 = r4 + 1
            int r6 = r4 + 3
            java.lang.String r5 = r8.substring(r5, r6)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            r7 = 16
            int r5 = java.lang.Integer.parseInt(r5, r7)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            byte r5 = (byte) r5     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            r3.put(r5)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            if (r6 >= r1) goto L_0x003f
            char r4 = r8.charAt(r6)     // Catch:{ RuntimeException -> 0x003d, all -> 0x005a }
            if (r4 == r0) goto L_0x003b
            goto L_0x003f
        L_0x003b:
            r4 = r6
            goto L_0x0020
        L_0x003d:
            r4 = r6
            goto L_0x0075
        L_0x003f:
            int r4 = r3.position()
            if (r4 <= 0) goto L_0x0058
            r3.flip()
            java.nio.charset.Charset r4 = org.apache.commons.io.Charsets.UTF_8
            java.nio.CharBuffer r4 = r4.decode(r3)
            java.lang.String r4 = r4.toString()
            r2.append(r4)
            r3.clear()
        L_0x0058:
            r4 = r6
            goto L_0x0018
        L_0x005a:
            r8 = move-exception
            int r0 = r3.position()
            if (r0 <= 0) goto L_0x0074
            r3.flip()
            java.nio.charset.Charset r0 = org.apache.commons.io.Charsets.UTF_8
            java.nio.CharBuffer r0 = r0.decode(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            r3.clear()
        L_0x0074:
            throw r8
        L_0x0075:
            int r5 = r3.position()
            if (r5 <= 0) goto L_0x008e
            r3.flip()
            java.nio.charset.Charset r5 = org.apache.commons.io.Charsets.UTF_8
            java.nio.CharBuffer r5 = r5.decode(r3)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            r3.clear()
        L_0x008e:
            int r5 = r4 + 1
            char r4 = r8.charAt(r4)
            r2.append(r4)
            r4 = r5
            goto L_0x0018
        L_0x009a:
            java.lang.String r8 = r2.toString()
        L_0x009e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.decodeUrl(java.lang.String):java.lang.String");
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    private static void deleteDirectoryOnExit(File file) throws IOException {
        if (file.exists()) {
            file.deleteOnExit();
            if (!isSymlink(file)) {
                cleanDirectoryOnExit(file);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|4|(1:6)|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean deleteQuietly(java.io.File r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r2.isDirectory()     // Catch:{ Exception -> 0x000d }
            if (r1 == 0) goto L_0x000d
            cleanDirectory(r2)     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            boolean r2 = r2.delete()     // Catch:{ Exception -> 0x0012 }
            return r2
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.deleteQuietly(java.io.File):boolean");
    }

    public static boolean directoryContains(File file, File file2) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Directory must not be null");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + file);
        } else if (file2 != null && file.exists() && file2.exists()) {
            return FilenameUtils.directoryContains(file.getCanonicalPath(), file2.getCanonicalPath());
        } else {
            return false;
        }
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) throws IOException {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : listFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    doCopyDirectory(file3, file4, fileFilter, z, list);
                } else {
                    doCopyFile(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v4, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v7, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doCopyFile(java.io.File r27, java.io.File r28, boolean r29) throws java.io.IOException {
        /*
            r1 = r27
            r2 = r28
            boolean r3 = r28.exists()
            if (r3 == 0) goto L_0x0029
            boolean r3 = r28.isDirectory()
            if (r3 == 0) goto L_0x0029
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Destination '"
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = "' exists but is a directory"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0029:
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            r7 = 4
            r8 = 0
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ all -> 0x00db }
            r9.<init>(r1)     // Catch:{ all -> 0x00db }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ all -> 0x00d7 }
            r10.<init>(r2)     // Catch:{ all -> 0x00d7 }
            java.nio.channels.FileChannel r15 = r9.getChannel()     // Catch:{ all -> 0x00d2 }
            java.nio.channels.FileChannel r17 = r10.getChannel()     // Catch:{ all -> 0x00cd }
            long r18 = r15.size()     // Catch:{ all -> 0x00c6 }
            r20 = 0
            r22 = r20
        L_0x0049:
            int r8 = (r22 > r18 ? 1 : (r22 == r18 ? 0 : -1))
            if (r8 >= 0) goto L_0x0075
            long r11 = r18 - r22
            r13 = 31457280(0x1e00000, double:1.55419614E-316)
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 <= 0) goto L_0x0059
            r24 = r13
            goto L_0x005b
        L_0x0059:
            r24 = r11
        L_0x005b:
            r11 = r17
            r12 = r15
            r13 = r22
            r26 = r15
            r15 = r24
            long r11 = r11.transferFrom(r12, r13, r15)     // Catch:{ all -> 0x0073 }
            int r8 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r8 == 0) goto L_0x0077
            long r13 = r22 + r11
            r22 = r13
            r15 = r26
            goto L_0x0049
        L_0x0073:
            r0 = move-exception
            goto L_0x00c9
        L_0x0075:
            r26 = r15
        L_0x0077:
            java.io.Closeable[] r7 = new java.io.Closeable[r7]
            r7[r6] = r17
            r7[r5] = r10
            r7[r4] = r26
            r7[r3] = r9
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Closeable[]) r7)
            long r3 = r27.length()
            long r5 = r28.length()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00bc
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Failed to copy full contents from '"
            r8.<init>(r9)
            r8.append(r1)
            java.lang.String r1 = "' to '"
            r8.append(r1)
            r8.append(r2)
            java.lang.String r1 = "' Expected length: "
            r8.append(r1)
            r8.append(r3)
            java.lang.String r1 = " Actual: "
            r8.append(r1)
            r8.append(r5)
            java.lang.String r1 = r8.toString()
            r7.<init>(r1)
            throw r7
        L_0x00bc:
            if (r29 == 0) goto L_0x00c5
            long r3 = r27.lastModified()
            r2.setLastModified(r3)
        L_0x00c5:
            return
        L_0x00c6:
            r0 = move-exception
            r26 = r15
        L_0x00c9:
            r1 = r0
            r8 = r17
            goto L_0x00e1
        L_0x00cd:
            r0 = move-exception
            r26 = r15
            r1 = r0
            goto L_0x00e1
        L_0x00d2:
            r0 = move-exception
            r1 = r0
            r26 = r8
            goto L_0x00e1
        L_0x00d7:
            r0 = move-exception
            r1 = r0
            r10 = r8
            goto L_0x00df
        L_0x00db:
            r0 = move-exception
            r1 = r0
            r9 = r8
            r10 = r9
        L_0x00df:
            r26 = r10
        L_0x00e1:
            java.io.Closeable[] r2 = new java.io.Closeable[r7]
            r2[r6] = r8
            r2[r5] = r10
            r2[r4] = r26
            r2[r3] = r9
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Closeable[]) r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.doCopyFile(java.io.File, java.io.File, boolean):void");
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static void forceDeleteOnExit(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    public static void forceMkdir(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static void forceMkdirParent(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            forceMkdir(parentFile);
        }
    }

    public static File getFile(File file, String... strArr) {
        if (file == null) {
            throw new NullPointerException("directory must not be null");
        } else if (strArr == null) {
            throw new NullPointerException("names must not be null");
        } else {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                i++;
                file = new File(file, strArr[i]);
            }
            return file;
        }
    }

    public static File getFile(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("names must not be null");
        }
        File file = null;
        for (String str : strArr) {
            file = file == null ? new File(str) : new File(file, str);
        }
        return file;
    }

    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }

    public static String getTempDirectoryPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static File getUserDirectory() {
        return new File(getUserDirectoryPath());
    }

    public static String getUserDirectoryPath() {
        return System.getProperty("user.home");
    }

    private static void innerListFiles(Collection<File> collection, File file, IOFileFilter iOFileFilter, boolean z) {
        File[] listFiles = file.listFiles(iOFileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z) {
                        collection.add(file2);
                    }
                    innerListFiles(collection, file2, iOFileFilter, z);
                } else {
                    collection.add(file2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r3 = r3.getCanonicalFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r3 = (r0 = r3.getParentFile()).listFiles(new org.apache.commons.io.FileUtils.AnonymousClass1());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isBrokenSymlink(java.io.File r3) throws java.io.IOException {
        /*
            boolean r0 = r3.exists()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.File r3 = r3.getCanonicalFile()
            java.io.File r0 = r3.getParentFile()
            if (r0 == 0) goto L_0x0029
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x0019
            return r1
        L_0x0019:
            org.apache.commons.io.FileUtils$1 r2 = new org.apache.commons.io.FileUtils$1
            r2.<init>(r3)
            java.io.File[] r3 = r0.listFiles(r2)
            if (r3 == 0) goto L_0x0029
            int r3 = r3.length
            if (r3 <= 0) goto L_0x0029
            r3 = 1
            return r3
        L_0x0029:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.FileUtils.isBrokenSymlink(java.io.File):boolean");
    }

    public static boolean isFileNewer(File file, long j) {
        if (file != null) {
            return file.exists() && file.lastModified() > j;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean isFileNewer(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        } else if (file2.exists()) {
            return isFileNewer(file, file2.lastModified());
        } else {
            throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
        }
    }

    public static boolean isFileNewer(File file, Date date) {
        if (date != null) {
            return isFileNewer(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileOlder(File file, long j) {
        if (file != null) {
            return file.exists() && file.lastModified() < j;
        }
        throw new IllegalArgumentException("No specified file");
    }

    public static boolean isFileOlder(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        } else if (file2.exists()) {
            return isFileOlder(file, file2.lastModified());
        } else {
            throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
        }
    }

    public static boolean isFileOlder(File file, Date date) {
        if (date != null) {
            return isFileOlder(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isSymlink(File file) throws IOException {
        if (Java7Support.isAtLeastJava7()) {
            return Java7Support.isSymLink(file);
        }
        if (file == null) {
            throw new NullPointerException("File must not be null");
        } else if (FilenameUtils.isSystemWindows()) {
            return false;
        } else {
            File file2 = file.getParent() == null ? file : new File(file.getParentFile().getCanonicalFile(), file.getName());
            if (file2.getCanonicalFile().equals(file2.getAbsoluteFile())) {
                return isBrokenSymlink(file);
            }
            return true;
        }
    }

    public static Iterator<File> iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static Iterator<File> iterateFiles(File file, String[] strArr, boolean z) {
        return listFiles(file, strArr, z).iterator();
    }

    public static Iterator<File> iterateFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFilesAndDirs(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static LineIterator lineIterator(File file) throws IOException {
        return lineIterator(file, (String) null);
    }

    public static LineIterator lineIterator(File file, String str) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                return IOUtils.lineIterator((InputStream) fileInputStream, str);
            } catch (IOException e) {
                e = e;
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            fileInputStream = null;
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw e;
        }
    }

    public static Collection<File> listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), false);
        return linkedList;
    }

    public static Collection<File> listFiles(File file, String[] strArr, boolean z) {
        return listFiles(file, strArr == null ? TrueFileFilter.INSTANCE : new SuffixFileFilter(toSuffixes(strArr)), z ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
    }

    public static Collection<File> listFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        if (file.isDirectory()) {
            linkedList.add(file);
        }
        innerListFiles(linkedList, file, FileFilterUtils.or(upEffectiveFileFilter, upEffectiveDirFilter), true);
        return linkedList;
    }

    public static void moveDirectory(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' is not a directory");
        } else if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        } else if (!file.renameTo(file2)) {
            String canonicalPath = file2.getCanonicalPath();
            if (canonicalPath.startsWith(file.getCanonicalPath() + File.separator)) {
                throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
            }
            copyDirectory(file, file2);
            deleteDirectory(file);
            if (file.exists()) {
                throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    public static void moveDirectoryToDirectory(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination directory must not be null");
        } else {
            if (!file2.exists() && z) {
                file2.mkdirs();
            }
            if (!file2.exists()) {
                throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
            } else if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' is not a directory");
            } else {
                moveDirectory(file, new File(file2, file.getName()));
            }
        }
    }

    public static void moveFile(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        } else if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        } else if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        } else if (!file.renameTo(file2)) {
            copyFile(file, file2);
            if (!file.delete()) {
                deleteQuietly(file2);
                throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    public static void moveFileToDirectory(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination directory must not be null");
        } else {
            if (!file2.exists() && z) {
                file2.mkdirs();
            }
            if (!file2.exists()) {
                throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
            } else if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' is not a directory");
            } else {
                moveFile(file, new File(file2, file.getName()));
            }
        }
    }

    public static void moveToDirectory(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            moveDirectoryToDirectory(file, file2, z);
        } else {
            moveFileToDirectory(file, file2, z);
        }
    }

    public static FileInputStream openInputStream(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        return openOutputStream(file, false);
    }

    public static FileOutputStream openOutputStream(File file, boolean z) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static byte[] readFileToByteArray(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                byte[] byteArray = IOUtils.toByteArray((InputStream) fileInputStream);
                IOUtils.closeQuietly((InputStream) fileInputStream);
                return byteArray;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw th;
        }
    }

    @Deprecated
    public static String readFileToString(File file) throws IOException {
        return readFileToString(file, Charset.defaultCharset());
    }

    public static String readFileToString(File file, String str) throws IOException {
        return readFileToString(file, Charsets.toCharset(str));
    }

    public static String readFileToString(File file, Charset charset) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                String iOUtils = IOUtils.toString((InputStream) fileInputStream, Charsets.toCharset(charset));
                IOUtils.closeQuietly((InputStream) fileInputStream);
                return iOUtils;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw th;
        }
    }

    @Deprecated
    public static List<String> readLines(File file) throws IOException {
        return readLines(file, Charset.defaultCharset());
    }

    public static List<String> readLines(File file, String str) throws IOException {
        return readLines(file, Charsets.toCharset(str));
    }

    public static List<String> readLines(File file, Charset charset) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
            try {
                List<String> readLines = IOUtils.readLines((InputStream) fileInputStream, Charsets.toCharset(charset));
                IOUtils.closeQuietly((InputStream) fileInputStream);
                return readLines;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            IOUtils.closeQuietly((InputStream) fileInputStream);
            throw th;
        }
    }

    private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter iOFileFilter) {
        if (iOFileFilter == null) {
            return FalseFileFilter.INSTANCE;
        }
        return FileFilterUtils.and(iOFileFilter, DirectoryFileFilter.INSTANCE);
    }

    private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter iOFileFilter) {
        return FileFilterUtils.and(iOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
    }

    public static long sizeOf(File file) {
        if (file.exists()) {
            return file.isDirectory() ? sizeOfDirectory0(file) : file.length();
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    private static long sizeOf0(File file) {
        return file.isDirectory() ? sizeOfDirectory0(file) : file.length();
    }

    public static BigInteger sizeOfAsBigInteger(File file) {
        if (file.exists()) {
            return file.isDirectory() ? sizeOfDirectoryBig0(file) : BigInteger.valueOf(file.length());
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    private static BigInteger sizeOfBig0(File file) {
        return file.isDirectory() ? sizeOfDirectoryBig0(file) : BigInteger.valueOf(file.length());
    }

    public static long sizeOfDirectory(File file) {
        checkDirectory(file);
        return sizeOfDirectory0(file);
    }

    private static long sizeOfDirectory0(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        long j = 0;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    long sizeOf0 = j + sizeOf0(file2);
                    if (sizeOf0 < 0) {
                        return sizeOf0;
                    }
                    j = sizeOf0;
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return j;
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file) {
        checkDirectory(file);
        return sizeOfDirectoryBig0(file);
    }

    private static BigInteger sizeOfDirectoryBig0(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return BigInteger.ZERO;
        }
        BigInteger bigInteger = BigInteger.ZERO;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    bigInteger = bigInteger.add(sizeOfBig0(file2));
                }
            } catch (IOException unused) {
            }
        }
        return bigInteger;
    }

    public static File toFile(URL url) {
        if (url == null || !"file".equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new File(decodeUrl(url.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar)));
    }

    public static File[] toFiles(URL[] urlArr) {
        if (urlArr == null || urlArr.length == 0) {
            return EMPTY_FILE_ARRAY;
        }
        File[] fileArr = new File[urlArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            URL url = urlArr[i];
            if (url != null) {
                if (!url.getProtocol().equals("file")) {
                    throw new IllegalArgumentException("URL could not be converted to a File: " + url);
                }
                fileArr[i] = toFile(url);
            }
        }
        return fileArr;
    }

    private static String[] toSuffixes(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = "." + strArr[i];
        }
        return strArr2;
    }

    public static URL[] toURLs(File[] fileArr) throws IOException {
        URL[] urlArr = new URL[fileArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            urlArr[i] = fileArr[i].toURI().toURL();
        }
        return urlArr;
    }

    public static void touch(File file) throws IOException {
        if (!file.exists()) {
            IOUtils.closeQuietly((OutputStream) openOutputStream(file));
        }
        if (!file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to set the last modification time for " + file);
        }
    }

    private static void validateListFilesParameters(File file, IOFileFilter iOFileFilter) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Parameter 'directory' is not a directory: " + file);
        } else if (iOFileFilter == null) {
            throw new NullPointerException("Parameter 'fileFilter' is null");
        }
    }

    private static File[] verifiedListFiles(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                return listFiles;
            }
            throw new IOException("Failed to list contents of " + file);
        }
    }

    public static boolean waitFor(File file, int i) {
        long currentTimeMillis = System.currentTimeMillis() + (((long) i) * 1000);
        boolean z = false;
        while (!file.exists()) {
            try {
                long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                if (currentTimeMillis2 < 0) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                try {
                    Thread.sleep(Math.min(100, currentTimeMillis2));
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Exception unused2) {
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return true;
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void write(File file, CharSequence charSequence, String str) throws IOException {
        write(file, charSequence, str, false);
    }

    public static void write(File file, CharSequence charSequence, String str, boolean z) throws IOException {
        write(file, charSequence, Charsets.toCharset(str), z);
    }

    public static void write(File file, CharSequence charSequence, Charset charset) throws IOException {
        write(file, charSequence, charset, false);
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z) throws IOException {
        writeStringToFile(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence, boolean z) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), z);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws IOException {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i, int i2) throws IOException {
        writeByteArrayToFile(file, bArr, i, i2, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i, int i2, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z);
            try {
                fileOutputStream.write(bArr, i, i2);
                fileOutputStream.close();
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
            throw th;
        }
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z) throws IOException {
        writeByteArrayToFile(file, bArr, 0, bArr.length, z);
    }

    public static void writeLines(File file, String str, Collection<?> collection) throws IOException {
        writeLines(file, str, collection, (String) null, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2) throws IOException {
        writeLines(file, str, collection, str2, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                IOUtils.writeLines(collection, str2, (OutputStream) bufferedOutputStream, str);
                bufferedOutputStream.flush();
                fileOutputStream.close();
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
            throw th;
        }
    }

    public static void writeLines(File file, String str, Collection<?> collection, boolean z) throws IOException {
        writeLines(file, str, collection, (String) null, z);
    }

    public static void writeLines(File file, Collection<?> collection) throws IOException {
        writeLines(file, (String) null, collection, (String) null, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str) throws IOException {
        writeLines(file, (String) null, collection, str, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str, boolean z) throws IOException {
        writeLines(file, (String) null, collection, str, z);
    }

    public static void writeLines(File file, Collection<?> collection, boolean z) throws IOException {
        writeLines(file, (String) null, collection, (String) null, z);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), false);
    }

    public static void writeStringToFile(File file, String str, String str2) throws IOException {
        writeStringToFile(file, str, str2, false);
    }

    public static void writeStringToFile(File file, String str, String str2, boolean z) throws IOException {
        writeStringToFile(file, str, Charsets.toCharset(str2), z);
    }

    public static void writeStringToFile(File file, String str, Charset charset) throws IOException {
        writeStringToFile(file, str, charset, false);
    }

    public static void writeStringToFile(File file, String str, Charset charset, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = openOutputStream(file, z);
            try {
                IOUtils.write(str, (OutputStream) fileOutputStream, charset);
                fileOutputStream.close();
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            IOUtils.closeQuietly((OutputStream) fileOutputStream);
            throw th;
        }
    }

    @Deprecated
    public static void writeStringToFile(File file, String str, boolean z) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), z);
    }
}
