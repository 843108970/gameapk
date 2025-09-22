package com.alibaba.sdk.android.oss.common;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OSSLogToFileUtils {
    private static final String LOG_DIR_NAME = "OSSLog";
    /* access modifiers changed from: private */
    public static long LOG_MAX_SIZE = 5242880;
    /* access modifiers changed from: private */
    public static OSSLogToFileUtils instance;
    private static LogThreadPoolManager logService = LogThreadPoolManager.newInstance();
    private static Context sContext;
    /* access modifiers changed from: private */
    public static File sLogFile;
    /* access modifiers changed from: private */
    public static SimpleDateFormat sLogSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private boolean useSdCard = true;

    private static class WriteCall implements Runnable {
        private Object mStr;

        public WriteCall(Object obj) {
            this.mStr = obj;
        }

        private PrintWriter printEx(PrintWriter printWriter) {
            printWriter.println("crash_time：" + OSSLogToFileUtils.sLogSDF.format(new Date()));
            ((Throwable) this.mStr).printStackTrace(printWriter);
            return printWriter;
        }

        public void run() {
            if (OSSLogToFileUtils.sLogFile != null) {
                OSSLogToFileUtils.getInstance();
                if (OSSLogToFileUtils.getLogFileSize(OSSLogToFileUtils.sLogFile) > OSSLogToFileUtils.LOG_MAX_SIZE) {
                    OSSLogToFileUtils.getInstance().resetLogFile();
                }
                try {
                    PrintWriter printWriter = new PrintWriter(new FileWriter(OSSLogToFileUtils.sLogFile, true), true);
                    if (this.mStr instanceof Throwable) {
                        printEx(printWriter);
                    } else {
                        printWriter.println(OSSLogToFileUtils.getInstance().getFunctionInfo((StackTraceElement[]) null) + " - " + this.mStr.toString());
                    }
                    printWriter.println("------>end of log");
                    printWriter.println();
                    printWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private OSSLogToFileUtils() {
    }

    /* access modifiers changed from: private */
    public String getFunctionInfo(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            return null;
        }
        return "[" + sLogSDF.format(new Date()) + "]";
    }

    public static OSSLogToFileUtils getInstance() {
        if (instance == null) {
            synchronized (OSSLogToFileUtils.class) {
                if (instance == null) {
                    instance = new OSSLogToFileUtils();
                }
            }
        }
        return instance;
    }

    public static long getLocalLogFileSize() {
        return getLogFileSize(sLogFile);
    }

    private File getLogFile() {
        File file;
        boolean z = false;
        if (!this.useSdCard || !Environment.getExternalStorageState().equals("mounted")) {
            if (readSystemSpace() > LOG_MAX_SIZE / 1024) {
                z = true;
            }
            file = new File(sContext.getFilesDir().getPath() + File.separator + LOG_DIR_NAME);
        } else {
            if (readSDCardSpace() > LOG_MAX_SIZE / 1024) {
                z = true;
            }
            file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + LOG_DIR_NAME);
        }
        File file2 = null;
        if (z) {
            if (!file.exists()) {
                file.mkdirs();
            }
            file2 = new File(file.getPath() + "/logs.csv");
            if (!file2.exists()) {
                createNewFile(file2);
            }
        }
        return file2;
    }

    public static long getLogFileSize(File file) {
        if (file == null || !file.exists()) {
            return 0;
        }
        return file.length();
    }

    public static void init(Context context, ClientConfiguration clientConfiguration) {
        OSSLog.logDebug("init ...", false);
        if (sContext == null || instance == null || sLogFile == null || !sLogFile.exists()) {
            instance = getInstance();
            if (clientConfiguration != null) {
                LOG_MAX_SIZE = clientConfiguration.getMaxLogSize();
            }
            sContext = context.getApplicationContext();
            sLogFile = instance.getLogFile();
            logService.addExecuteTask(new Runnable() {
                public final void run() {
                    if (OSSLogToFileUtils.sLogFile != null) {
                        OSSLog.logInfo("LogFilePath is: " + OSSLogToFileUtils.sLogFile.getPath(), false);
                        if (OSSLogToFileUtils.LOG_MAX_SIZE < OSSLogToFileUtils.getLogFileSize(OSSLogToFileUtils.sLogFile)) {
                            OSSLog.logInfo("init reset log file", false);
                            OSSLogToFileUtils.instance.resetLogFile();
                        }
                    }
                }
            });
            return;
        }
        OSSLog.logDebug("LogToFileUtils has been init ...", false);
    }

    private long readSDCardSpace() {
        long j;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } else {
            j = 0;
        }
        OSSLog.logDebug("sd卡存储空间:" + String.valueOf(j) + "kb", false);
        return j;
    }

    private long readSystemSpace() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        long availableBlocks = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024;
        OSSLog.logDebug("内部存储空间:" + String.valueOf(availableBlocks) + "kb", false);
        return availableBlocks;
    }

    public static void reset() {
        sContext = null;
        instance = null;
        sLogFile = null;
    }

    public void createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (Exception e) {
            OSSLog.logError("Create log file failure !!! " + e.toString(), false);
        }
    }

    public void deleteLogFile() {
        File file = new File(sLogFile.getParent() + "/logs.csv");
        if (file.exists()) {
            OSSLog.logDebug("delete Log File ... ", false);
            file.delete();
        }
    }

    public void deleteLogFileDir() {
        deleteLogFile();
        File file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + LOG_DIR_NAME);
        if (file.exists()) {
            OSSLog.logDebug("delete Log FileDir ... ", false);
            file.delete();
        }
    }

    public void resetLogFile() {
        OSSLog.logDebug("Reset Log File ... ", false);
        if (!sLogFile.getParentFile().exists()) {
            OSSLog.logDebug("Reset Log make File dir ... ", false);
            sLogFile.getParentFile().mkdir();
        }
        File file = new File(sLogFile.getParent() + "/logs.csv");
        if (file.exists()) {
            file.delete();
        }
        createNewFile(file);
    }

    public void setUseSdCard(boolean z) {
        this.useSdCard = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void write(java.lang.Object r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = com.alibaba.sdk.android.oss.common.OSSLog.isEnableLog()     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002c
            android.content.Context r0 = sContext     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002a
            com.alibaba.sdk.android.oss.common.OSSLogToFileUtils r0 = instance     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002a
            java.io.File r0 = sLogFile     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0014
            goto L_0x002a
        L_0x0014:
            java.io.File r0 = sLogFile     // Catch:{ all -> 0x002e }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x001f
            r1.resetLogFile()     // Catch:{ all -> 0x002e }
        L_0x001f:
            com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$WriteCall r0 = new com.alibaba.sdk.android.oss.common.OSSLogToFileUtils$WriteCall     // Catch:{ all -> 0x002e }
            r0.<init>(r2)     // Catch:{ all -> 0x002e }
            com.alibaba.sdk.android.oss.common.LogThreadPoolManager r2 = logService     // Catch:{ all -> 0x002e }
            r2.addExecuteTask(r0)     // Catch:{ all -> 0x002e }
            goto L_0x002c
        L_0x002a:
            monitor-exit(r1)
            return
        L_0x002c:
            monitor-exit(r1)
            return
        L_0x002e:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.write(java.lang.Object):void");
    }
}
