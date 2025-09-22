package com.lidroid.xutils.http.callback;

import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.OtherUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;

public class StringDownloadHandler {
    public String handleEntity(HttpEntity httpEntity, RequestCallBackHandler requestCallBackHandler, String str) throws IOException {
        InputStream inputStream;
        Throwable th;
        long j;
        String str2 = str;
        if (httpEntity == null) {
            return null;
        }
        long j2 = 0;
        long contentLength = httpEntity.getContentLength();
        if (requestCallBackHandler != null && !requestCallBackHandler.updateProgress(contentLength, 0, true)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = httpEntity.getContent();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        j = j2;
                        break;
                    }
                    sb.append(readLine);
                    sb.append(10);
                    long sizeOfString = j2 + OtherUtils.sizeOfString(readLine, str2);
                    if (requestCallBackHandler != null) {
                        if (!requestCallBackHandler.updateProgress(contentLength, sizeOfString, false)) {
                            j = sizeOfString;
                            break;
                        }
                    }
                    j2 = sizeOfString;
                }
                if (requestCallBackHandler != null) {
                    requestCallBackHandler.updateProgress(contentLength, j, true);
                }
                IOUtils.closeQuietly((Closeable) inputStream);
                return sb.toString().trim();
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            IOUtils.closeQuietly((Closeable) inputStream);
            throw th;
        }
    }
}
