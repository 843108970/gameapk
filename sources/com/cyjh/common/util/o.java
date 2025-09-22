package com.cyjh.common.util;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f1683a = Pattern.compile("[\\w%+,./=_-]+");

    public static class a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        private String f1684a;

        public a(String str) {
            this.f1684a = str;
        }

        public final boolean accept(File file, String str) {
            return str.endsWith(this.f1684a);
        }
    }

    public static class b extends AsyncTask<File[], ArrayList<HashMap<String, Integer>>, ArrayList<HashMap<String, Boolean>>> {

        /* renamed from: a  reason: collision with root package name */
        private a f1685a;

        public interface a {
            void a();
        }

        private static ArrayList<HashMap<String, Boolean>> a(File[]... fileArr) {
            new ArrayList(fileArr[0].length);
            for (int i = 0; i < fileArr[0].length; i++) {
                o.a(fileArr[0][i], fileArr[1][i]);
            }
            return null;
        }

        private void a(a aVar) {
            this.f1685a = aVar;
        }

        private void a(ArrayList<HashMap<String, Boolean>> arrayList) {
            super.onPostExecute(arrayList);
        }

        private void a(ArrayList<HashMap<String, Integer>>... arrayListArr) {
            super.onProgressUpdate(arrayListArr);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            File[][] fileArr = (File[][]) objArr;
            new ArrayList(fileArr[0].length);
            for (int i = 0; i < fileArr[0].length; i++) {
                o.a(fileArr[0][i], fileArr[1][i]);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((ArrayList) obj);
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
            super.onProgressUpdate((ArrayList[]) objArr);
        }
    }

    private static File a(Context context) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String a(long j) {
        StringBuilder sb;
        String str;
        DecimalFormat decimalFormat = new DecimalFormat("#");
        if (j < 1024) {
            sb = new StringBuilder();
            sb.append(decimalFormat.format((double) j));
            str = "B";
        } else if (j < 1048576) {
            sb = new StringBuilder();
            sb.append(decimalFormat.format(((double) j) / 1024.0d));
            str = "KB";
        } else if (j < FileUtils.ONE_GB) {
            sb = new StringBuilder();
            sb.append(decimalFormat.format(((double) j) / 1048576.0d));
            str = "MB";
        } else {
            sb = new StringBuilder();
            sb.append(decimalFormat.format(((double) j) / 1.073741824E9d));
            str = "G";
        }
        sb.append(str);
        return sb.toString();
    }

    public static String a(Context context, String str) {
        return d(new File(a(context), str).getAbsolutePath(), "utf-8");
    }

    private static String a(File file) {
        int read;
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            do {
                read = bufferedReader.read();
                if (read != -1) {
                    stringBuffer.append((char) read);
                    continue;
                }
            } while (read != -1);
            bufferedReader.close();
            String stringBuffer2 = stringBuffer.toString();
            int indexOf = stringBuffer2.indexOf(IOUtils.LINE_SEPARATOR_WINDOWS);
            int indexOf2 = stringBuffer2.indexOf("\r");
            if (indexOf != -1) {
                str = IOUtils.LINE_SEPARATOR_WINDOWS;
            } else if (indexOf2 == -1) {
                return stringBuffer2;
            } else {
                str = "\r";
            }
            return stringBuffer2.replaceAll(str, "\n");
        } catch (IOException | OutOfMemoryError unused) {
            return null;
        }
    }

    public static String a(File file, int i) throws IOException {
        int read;
        String byteArrayOutputStream;
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        try {
            long length = file.length();
            if (length > 0) {
                if (length > 0) {
                    i = (int) length;
                }
                byte[] bArr = new byte[(i + 1)];
                int read2 = bufferedInputStream.read(bArr);
                if (read2 <= 0) {
                    byteArrayOutputStream = "";
                } else if (read2 <= i) {
                    String str = new String(bArr, 0, read2);
                    bufferedInputStream.close();
                    fileInputStream.close();
                    return str;
                } else {
                    String str2 = new String(bArr, 0, i);
                    bufferedInputStream.close();
                    fileInputStream.close();
                    return str2;
                }
            } else {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[1024];
                do {
                    read = bufferedInputStream.read(bArr2);
                    if (read > 0) {
                        byteArrayOutputStream2.write(bArr2, 0, read);
                        continue;
                    }
                } while (read == 1024);
                byteArrayOutputStream = byteArrayOutputStream2.toString();
            }
            return byteArrayOutputStream;
        } finally {
            bufferedInputStream.close();
            fileInputStream.close();
        }
    }

    private static String a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            try {
                if (!file.isDirectory()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file.getAbsolutePath();
    }

    public static String a(String str, String str2) {
        StringBuilder sb;
        if (str.endsWith(File.separator)) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str = File.separator;
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void a(Context context, String str, String str2) {
        FileWriter fileWriter;
        try {
            File file = new File(a(context), str);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(str2);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            fileWriter.close();
            throw th;
        }
    }

    public static boolean a(File file, File file2) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            boolean a2 = a((InputStream) fileInputStream, file2);
            fileInputStream.close();
            return a2;
        } catch (IOException unused) {
            return false;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:1|2|(1:4)|5|6|7|8|(2:9|(1:11)(1:12))|13|14|15|16|17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:19|20|21|22|23|24|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0037 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0027=Splitter:B:16:0x0027, B:23:0x0037=Splitter:B:23:0x0037} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.InputStream r3, java.io.File r4) {
        /*
            r0 = 0
            boolean r1 = r4.exists()     // Catch:{ IOException -> 0x003b }
            if (r1 == 0) goto L_0x000a
            r4.delete()     // Catch:{ IOException -> 0x003b }
        L_0x000a:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003b }
            r1.<init>(r4)     // Catch:{ IOException -> 0x003b }
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x002c }
        L_0x0013:
            int r2 = r3.read(r4)     // Catch:{ all -> 0x002c }
            if (r2 < 0) goto L_0x001d
            r1.write(r4, r0, r2)     // Catch:{ all -> 0x002c }
            goto L_0x0013
        L_0x001d:
            r1.flush()     // Catch:{ IOException -> 0x003b }
            java.io.FileDescriptor r3 = r1.getFD()     // Catch:{ IOException -> 0x0027 }
            r3.sync()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            r1.close()     // Catch:{ IOException -> 0x003b }
            r3 = 1
            return r3
        L_0x002c:
            r3 = move-exception
            r1.flush()     // Catch:{ IOException -> 0x003b }
            java.io.FileDescriptor r4 = r1.getFD()     // Catch:{ IOException -> 0x0037 }
            r4.sync()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            r1.close()     // Catch:{ IOException -> 0x003b }
            throw r3     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.o.a(java.io.InputStream, java.io.File):boolean");
    }

    private static String b(String str) {
        return d(str, "utf-8");
    }

    private static void b(String str, String str2) throws IOException {
        FileWriter fileWriter = new FileWriter(str);
        try {
            fileWriter.write(str2);
        } finally {
            fileWriter.close();
        }
    }

    private static boolean b(File file) {
        return f1683a.matcher(file.getPath()).matches();
    }

    private static boolean c(String str, String str2) {
        StringBuilder sb;
        if (str2 == null) {
            str2 = "";
        }
        if (str == null) {
            str = "";
        }
        if (str.lastIndexOf("/") == str.length() - 1) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str = "/";
        }
        sb.append(str);
        sb.append(str2);
        return new File(sb.toString()).exists();
    }

    private static String d(String str, String str2) {
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
}
