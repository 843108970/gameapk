package com.lidroid.xutils.http.client.multipart;

import com.lidroid.xutils.http.client.multipart.MultipartEntity;
import com.lidroid.xutils.http.client.multipart.content.ContentBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.http.util.ByteArrayBuffer;

class HttpMultipart {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$lidroid$xutils$http$client$multipart$HttpMultipartMode;
    private static final ByteArrayBuffer CR_LF = encode(MIME.DEFAULT_CHARSET, IOUtils.LINE_SEPARATOR_WINDOWS);
    private static final ByteArrayBuffer FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
    private static final ByteArrayBuffer TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
    private final String boundary;
    private final Charset charset;
    private final HttpMultipartMode mode;
    private final List<FormBodyPart> parts;
    private String subType;

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|10) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$com$lidroid$xutils$http$client$multipart$HttpMultipartMode() {
        /*
            int[] r0 = $SWITCH_TABLE$com$lidroid$xutils$http$client$multipart$HttpMultipartMode
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.lidroid.xutils.http.client.multipart.HttpMultipartMode[] r0 = com.lidroid.xutils.http.client.multipart.HttpMultipartMode.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.lidroid.xutils.http.client.multipart.HttpMultipartMode r1 = com.lidroid.xutils.http.client.multipart.HttpMultipartMode.BROWSER_COMPATIBLE     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.lidroid.xutils.http.client.multipart.HttpMultipartMode r1 = com.lidroid.xutils.http.client.multipart.HttpMultipartMode.STRICT     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            $SWITCH_TABLE$com$lidroid$xutils$http$client$multipart$HttpMultipartMode = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.client.multipart.HttpMultipart.$SWITCH_TABLE$com$lidroid$xutils$http$client$multipart$HttpMultipartMode():int[]");
    }

    public HttpMultipart(String str, String str2) {
        this(str, (Charset) null, str2);
    }

    public HttpMultipart(String str, Charset charset2, String str2) {
        this(str, charset2, str2, HttpMultipartMode.STRICT);
    }

    public HttpMultipart(String str, Charset charset2, String str2, HttpMultipartMode httpMultipartMode) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        } else {
            this.subType = str;
            this.charset = charset2 == null ? MIME.DEFAULT_CHARSET : charset2;
            this.boundary = str2;
            this.parts = new ArrayList();
            this.mode = httpMultipartMode;
        }
    }

    private void doWriteTo(HttpMultipartMode httpMultipartMode, OutputStream outputStream, MultipartEntity.CallBackInfo callBackInfo, boolean z) throws IOException {
        callBackInfo.pos = 0;
        ByteArrayBuffer encode = encode(this.charset, getBoundary());
        for (FormBodyPart next : this.parts) {
            if (!callBackInfo.doCallBack(true)) {
                throw new InterruptedIOException("cancel");
            }
            writeBytes(TWO_DASHES, outputStream);
            callBackInfo.pos += (long) TWO_DASHES.length();
            writeBytes(encode, outputStream);
            callBackInfo.pos += (long) encode.length();
            writeBytes(CR_LF, outputStream);
            callBackInfo.pos += (long) CR_LF.length();
            MinimalFieldHeader header = next.getHeader();
            switch ($SWITCH_TABLE$com$lidroid$xutils$http$client$multipart$HttpMultipartMode()[httpMultipartMode.ordinal()]) {
                case 1:
                    Iterator<MinimalField> it = header.iterator();
                    while (it.hasNext()) {
                        MinimalField next2 = it.next();
                        writeField(next2, outputStream);
                        callBackInfo.pos = callBackInfo.pos + ((long) (encode(MIME.DEFAULT_CHARSET, String.valueOf(next2.getName()) + next2.getBody()).length() + FIELD_SEP.length() + CR_LF.length()));
                    }
                    break;
                case 2:
                    MinimalField field = header.getField("Content-Disposition");
                    writeField(field, this.charset, outputStream);
                    callBackInfo.pos = callBackInfo.pos + ((long) (encode(this.charset, String.valueOf(field.getName()) + field.getBody()).length() + FIELD_SEP.length() + CR_LF.length()));
                    if (next.getBody().getFilename() != null) {
                        MinimalField field2 = header.getField("Content-Type");
                        writeField(field2, this.charset, outputStream);
                        callBackInfo.pos = callBackInfo.pos + ((long) (encode(this.charset, String.valueOf(field2.getName()) + field2.getBody()).length() + FIELD_SEP.length() + CR_LF.length()));
                        break;
                    }
                    break;
            }
            writeBytes(CR_LF, outputStream);
            callBackInfo.pos += (long) CR_LF.length();
            if (z) {
                ContentBody body = next.getBody();
                body.setCallBackInfo(callBackInfo);
                body.writeTo(outputStream);
            }
            writeBytes(CR_LF, outputStream);
            callBackInfo.pos += (long) CR_LF.length();
        }
        writeBytes(TWO_DASHES, outputStream);
        callBackInfo.pos += (long) TWO_DASHES.length();
        writeBytes(encode, outputStream);
        callBackInfo.pos += (long) encode.length();
        writeBytes(TWO_DASHES, outputStream);
        callBackInfo.pos += (long) TWO_DASHES.length();
        writeBytes(CR_LF, outputStream);
        callBackInfo.pos += (long) CR_LF.length();
        callBackInfo.doCallBack(true);
    }

    private void doWriteTo(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z) throws IOException {
        doWriteTo(httpMultipartMode, outputStream, MultipartEntity.CallBackInfo.DEFAULT, z);
    }

    private static ByteArrayBuffer encode(Charset charset2, String str) {
        ByteBuffer encode = charset2.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void writeBytes(String str, OutputStream outputStream) throws IOException {
        writeBytes(encode(MIME.DEFAULT_CHARSET, str), outputStream);
    }

    private static void writeBytes(String str, Charset charset2, OutputStream outputStream) throws IOException {
        writeBytes(encode(charset2, str), outputStream);
    }

    private static void writeBytes(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
        outputStream.flush();
    }

    private static void writeField(MinimalField minimalField, OutputStream outputStream) throws IOException {
        writeBytes(minimalField.getName(), outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), outputStream);
        writeBytes(CR_LF, outputStream);
    }

    private static void writeField(MinimalField minimalField, Charset charset2, OutputStream outputStream) throws IOException {
        writeBytes(minimalField.getName(), charset2, outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), charset2, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    public void addBodyPart(FormBodyPart formBodyPart) {
        if (formBodyPart != null) {
            this.parts.add(formBodyPart);
        }
    }

    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    public String getBoundary() {
        return this.boundary;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public HttpMultipartMode getMode() {
        return this.mode;
    }

    public String getSubType() {
        return this.subType;
    }

    public long getTotalLength() {
        long j = 0;
        for (FormBodyPart body : this.parts) {
            long contentLength = body.getBody().getContentLength();
            if (contentLength < 0) {
                return -1;
            }
            j += contentLength;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            doWriteTo(this.mode, byteArrayOutputStream, false);
            return j + ((long) byteArrayOutputStream.toByteArray().length);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public void setSubType(String str) {
        this.subType = str;
    }

    public void writeTo(OutputStream outputStream, MultipartEntity.CallBackInfo callBackInfo) throws IOException {
        doWriteTo(this.mode, outputStream, callBackInfo, true);
    }
}
