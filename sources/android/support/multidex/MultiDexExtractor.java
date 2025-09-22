package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class MultiDexExtractor {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String DEX_SUFFIX = ".dex";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";

    private static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    MultiDexExtractor() {
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w(TAG, "Failed to close resource", e);
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, EXTRACTED_SUFFIX, file.getParentFile());
        Log.i(TAG, "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (!createTempFile.setReadOnly()) {
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            }
            Log.i(TAG, "Renaming to " + file.getPath());
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            closeQuietly(inputStream);
            createTempFile.delete();
        } catch (Throwable th) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th;
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long zipCrc = ZipUtil.getZipCrc(file);
        return zipCrc == -1 ? zipCrc - 1 : zipCrc;
    }

    private static boolean isModified(Context context, File file, long j, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + KEY_TIME_STAMP, -1) != getTimeStamp(file)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(KEY_CRC);
        return multiDexPreferences.getLong(sb.toString(), -1) != j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b7 A[SYNTHETIC, Splitter:B:23:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0109 A[SYNTHETIC, Splitter:B:41:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<? extends java.io.File> load(android.content.Context r14, java.io.File r15, java.io.File r16, java.lang.String r17, boolean r18) throws java.io.IOException {
        /*
            r2 = r17
            r1 = r18
            java.lang.String r3 = "MultiDex"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "MultiDexExtractor.load("
            r4.<init>(r5)
            java.lang.String r5 = r15.getPath()
            r4.append(r5)
            java.lang.String r5 = ", "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ", "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = ")"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.i(r3, r4)
            long r5 = getZipCrc(r15)
            java.io.File r8 = new java.io.File
            java.lang.String r3 = "MultiDex.lock"
            r4 = r16
            r8.<init>(r4, r3)
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r9.<init>(r8, r3)
            r10 = 0
            java.nio.channels.FileChannel r11 = r9.getChannel()     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = "MultiDex"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ff }
            java.lang.String r12 = "Blocking on lock "
            r7.<init>(r12)     // Catch:{ all -> 0x00ff }
            java.lang.String r12 = r8.getPath()     // Catch:{ all -> 0x00ff }
            r7.append(r12)     // Catch:{ all -> 0x00ff }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00ff }
            android.util.Log.i(r3, r7)     // Catch:{ all -> 0x00ff }
            java.nio.channels.FileLock r12 = r11.lock()     // Catch:{ all -> 0x00ff }
            java.lang.String r3 = "MultiDex"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
            r7.<init>()     // Catch:{ all -> 0x00fc }
            java.lang.String r13 = r8.getPath()     // Catch:{ all -> 0x00fc }
            r7.append(r13)     // Catch:{ all -> 0x00fc }
            java.lang.String r13 = " locked"
            r7.append(r13)     // Catch:{ all -> 0x00fc }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00fc }
            android.util.Log.i(r3, r7)     // Catch:{ all -> 0x00fc }
            if (r1 != 0) goto L_0x00a3
            r1 = r14
            r3 = r15
            boolean r7 = isModified(r1, r3, r5, r2)     // Catch:{ all -> 0x00fc }
            if (r7 != 0) goto L_0x00a5
            java.util.List r7 = loadExistingExtractions(r14, r15, r16, r17)     // Catch:{ IOException -> 0x008e }
            r13 = r7
            goto L_0x00b5
        L_0x008e:
            r0 = move-exception
            java.lang.String r7 = "MultiDex"
            java.lang.String r13 = "Failed to reload existing extracted secondary dex files, falling back to fresh extraction"
            android.util.Log.w(r7, r13, r0)     // Catch:{ all -> 0x00fc }
            java.util.List r13 = performExtractions(r15, r16)     // Catch:{ all -> 0x00fc }
            long r3 = getTimeStamp(r3)     // Catch:{ all -> 0x00fc }
        L_0x009e:
            r7 = r13
            putStoredApkInfo(r1, r2, r3, r5, r7)     // Catch:{ all -> 0x00fc }
            goto L_0x00b5
        L_0x00a3:
            r1 = r14
            r3 = r15
        L_0x00a5:
            java.lang.String r7 = "MultiDex"
            java.lang.String r13 = "Detected that extraction must be performed."
            android.util.Log.i(r7, r13)     // Catch:{ all -> 0x00fc }
            java.util.List r13 = performExtractions(r15, r16)     // Catch:{ all -> 0x00fc }
            long r3 = getTimeStamp(r3)     // Catch:{ all -> 0x00fc }
            goto L_0x009e
        L_0x00b5:
            if (r12 == 0) goto L_0x00d4
            r12.release()     // Catch:{ IOException -> 0x00bb }
            goto L_0x00d4
        L_0x00bb:
            r0 = move-exception
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to release lock on "
            r2.<init>(r3)
            java.lang.String r3 = r8.getPath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r10 = r0
        L_0x00d4:
            if (r11 == 0) goto L_0x00d9
            closeQuietly(r11)
        L_0x00d9:
            closeQuietly(r9)
            if (r10 == 0) goto L_0x00df
            throw r10
        L_0x00df:
            java.lang.String r1 = "MultiDex"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "load found "
            r2.<init>(r3)
            int r3 = r13.size()
            r2.append(r3)
            java.lang.String r3 = " secondary dex files"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r1, r2)
            return r13
        L_0x00fc:
            r0 = move-exception
            r1 = r0
            goto L_0x0107
        L_0x00ff:
            r0 = move-exception
            r1 = r0
            r12 = r10
            goto L_0x0107
        L_0x0103:
            r0 = move-exception
            r1 = r0
            r11 = r10
            r12 = r11
        L_0x0107:
            if (r12 == 0) goto L_0x0124
            r12.release()     // Catch:{ IOException -> 0x010d }
            goto L_0x0124
        L_0x010d:
            java.lang.String r2 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to release lock on "
            r3.<init>(r4)
            java.lang.String r4 = r8.getPath()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
        L_0x0124:
            if (r11 == 0) goto L_0x0129
            closeQuietly(r11)
        L_0x0129:
            closeQuietly(r9)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDexExtractor.load(android.content.Context, java.io.File, java.io.File, java.lang.String, boolean):java.util.List");
    }

    private static List<ExtractedDex> loadExistingExtractions(Context context, File file, File file2, String str) throws IOException {
        String str2 = str;
        Log.i(TAG, "loading existing secondary dex files");
        String str3 = file.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i = multiDexPreferences.getInt(str2 + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            ExtractedDex extractedDex = new ExtractedDex(file2, str3 + i2 + EXTRACTED_SUFFIX);
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                long j = multiDexPreferences.getLong(str2 + KEY_DEX_CRC + i2, -1);
                long j2 = multiDexPreferences.getLong(str2 + KEY_DEX_TIME + i2, -1);
                long lastModified = extractedDex.lastModified();
                if (j2 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i2++;
                        str3 = str4;
                        multiDexPreferences = sharedPreferences;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + extractedDex.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    private static List<ExtractedDex> performExtractions(File file, File file2) throws IOException {
        ExtractedDex extractedDex;
        boolean z;
        String str = file.getName() + EXTRACTED_NAME_EXT;
        prepareDexDir(file2, str);
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        int i = 2;
        String str2 = "classes2.dex";
        while (true) {
            try {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry != null) {
                    extractedDex = new ExtractedDex(file2, str + i + EXTRACTED_SUFFIX);
                    arrayList.add(extractedDex);
                    StringBuilder sb = new StringBuilder("Extraction is needed for file ");
                    sb.append(extractedDex);
                    Log.i(TAG, sb.toString());
                    int i2 = 0;
                    z = false;
                    while (i2 < 3 && !z) {
                        i2++;
                        extract(zipFile, entry, extractedDex, str);
                        extractedDex.crc = getZipCrc(extractedDex);
                        z = true;
                        StringBuilder sb2 = new StringBuilder("Extraction ");
                        sb2.append(z ? "succeeded" : "failed");
                        sb2.append(" - length ");
                        sb2.append(extractedDex.getAbsolutePath());
                        sb2.append(": ");
                        sb2.append(extractedDex.length());
                        sb2.append(" - crc: ");
                        sb2.append(extractedDex.crc);
                        Log.i(TAG, sb2.toString());
                        if (!z) {
                            extractedDex.delete();
                            if (extractedDex.exists()) {
                                Log.w(TAG, "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                            }
                        }
                    }
                    if (!z) {
                        throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i + ")");
                    }
                    i++;
                    str2 = DEX_PREFIX + i + DEX_SUFFIX;
                } else {
                    try {
                        zipFile.close();
                        return arrayList;
                    } catch (IOException e) {
                        Log.w(TAG, "Failed to close resource", e);
                        return arrayList;
                    }
                }
            } catch (IOException e2) {
                Log.w(TAG, "Failed to read crc from " + extractedDex.getAbsolutePath(), e2);
                z = false;
            } catch (Throwable th) {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    Log.w(TAG, "Failed to close resource", e3);
                }
                throw th;
            }
        }
    }

    private static void prepareDexDir(File file, final String str) {
        File[] listFiles = file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                String name = file.getName();
                return !name.startsWith(str) && !name.equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            Log.w(TAG, "Failed to list secondary dex dir content (" + file.getPath() + ").");
            return;
        }
        for (File file2 : listFiles) {
            Log.i(TAG, "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                Log.w(TAG, "Failed to delete old file " + file2.getPath());
            } else {
                Log.i(TAG, "Deleted old file " + file2.getPath());
            }
        }
    }

    private static void putStoredApkInfo(Context context, String str, long j, long j2, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + KEY_TIME_STAMP, j);
        edit.putLong(str + KEY_CRC, j2);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + KEY_DEX_CRC + i, next.crc);
            edit.putLong(str + KEY_DEX_TIME + i, next.lastModified());
            i++;
        }
        edit.commit();
    }
}
