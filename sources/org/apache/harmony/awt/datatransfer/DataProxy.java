package org.apache.harmony.awt.datatransfer;

import com.github.kevinsawicki.http.HttpRequest;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.harmony.awt.internal.nls.Messages;

public final class DataProxy implements Transferable {
    public static final Class[] charsetTextClasses = {byte[].class, ByteBuffer.class, InputStream.class};
    public static final Class[] unicodeTextClasses = {String.class, Reader.class, CharBuffer.class, char[].class};
    private final DataProvider data;
    private final SystemFlavorMap flavorMap = SystemFlavorMap.getDefaultFlavorMap();

    public DataProxy(DataProvider dataProvider) {
        this.data = dataProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.awt.image.BufferedImage createBufferedImage(org.apache.harmony.awt.datatransfer.RawBitmap r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = 0
            if (r0 == 0) goto L_0x00fc
            java.lang.Object r2 = r0.buffer
            if (r2 == 0) goto L_0x00fc
            int r2 = r0.width
            if (r2 <= 0) goto L_0x00fc
            int r2 = r0.height
            if (r2 > 0) goto L_0x0012
            return r1
        L_0x0012:
            int r2 = r0.bits
            r3 = 32
            r4 = 24
            r5 = 0
            r6 = 2
            r7 = 3
            r8 = 1
            if (r2 != r3) goto L_0x0061
            java.lang.Object r2 = r0.buffer
            boolean r2 = r2 instanceof int[]
            if (r2 == 0) goto L_0x0061
            boolean r2 = r19.isRGB(r20)
            if (r2 != 0) goto L_0x0031
            boolean r2 = r19.isBGR(r20)
            if (r2 != 0) goto L_0x0031
            return r1
        L_0x0031:
            int[] r13 = new int[r7]
            int r2 = r0.rMask
            r13[r5] = r2
            int r2 = r0.gMask
            r13[r8] = r2
            int r2 = r0.bMask
            r13[r6] = r2
            java.lang.Object r2 = r0.buffer
            int[] r2 = (int[]) r2
            java.awt.image.DirectColorModel r3 = new java.awt.image.DirectColorModel
            int r6 = r0.rMask
            int r7 = r0.gMask
            int r8 = r0.bMask
            r3.<init>(r4, r6, r7, r8)
            java.awt.image.DataBufferInt r9 = new java.awt.image.DataBufferInt
            int r4 = r2.length
            r9.<init>(r2, r4)
        L_0x0054:
            int r10 = r0.width
            int r11 = r0.height
            int r12 = r0.stride
            r14 = 0
            java.awt.image.WritableRaster r0 = java.awt.image.Raster.createPackedRaster(r9, r10, r11, r12, r13, r14)
            goto L_0x00f1
        L_0x0061:
            int r2 = r0.bits
            if (r2 != r4) goto L_0x00b6
            java.lang.Object r2 = r0.buffer
            boolean r2 = r2 instanceof byte[]
            if (r2 == 0) goto L_0x00b6
            int[] r11 = new int[r7]
            r11 = {8, 8, 8} // fill-array
            boolean r2 = r19.isRGB(r20)
            if (r2 == 0) goto L_0x007f
            int[] r2 = new int[r7]
            r2[r8] = r8
            r2[r6] = r6
        L_0x007c:
            r17 = r2
            goto L_0x008c
        L_0x007f:
            boolean r2 = r19.isBGR(r20)
            if (r2 == 0) goto L_0x00b5
            int[] r2 = new int[r7]
            r2[r5] = r6
            r2[r8] = r8
            goto L_0x007c
        L_0x008c:
            java.lang.Object r2 = r0.buffer
            byte[] r2 = (byte[]) r2
            java.awt.image.ComponentColorModel r3 = new java.awt.image.ComponentColorModel
            r4 = 1000(0x3e8, float:1.401E-42)
            java.awt.color.ColorSpace r10 = java.awt.color.ColorSpace.getInstance(r4)
            r12 = 0
            r13 = 0
            r14 = 1
            r15 = 0
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15)
            java.awt.image.DataBufferByte r12 = new java.awt.image.DataBufferByte
            int r4 = r2.length
            r12.<init>(r2, r4)
            int r13 = r0.width
            int r14 = r0.height
            int r15 = r0.stride
            r16 = 3
            r18 = 0
            java.awt.image.WritableRaster r0 = java.awt.image.Raster.createInterleavedRaster(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x00f1
        L_0x00b5:
            return r1
        L_0x00b6:
            int r2 = r0.bits
            r3 = 16
            if (r2 == r3) goto L_0x00c2
            int r2 = r0.bits
            r3 = 15
            if (r2 != r3) goto L_0x00ef
        L_0x00c2:
            java.lang.Object r2 = r0.buffer
            boolean r2 = r2 instanceof short[]
            if (r2 == 0) goto L_0x00ef
            int[] r13 = new int[r7]
            int r2 = r0.rMask
            r13[r5] = r2
            int r2 = r0.gMask
            r13[r8] = r2
            int r2 = r0.bMask
            r13[r6] = r2
            java.lang.Object r2 = r0.buffer
            short[] r2 = (short[]) r2
            java.awt.image.DirectColorModel r3 = new java.awt.image.DirectColorModel
            int r4 = r0.bits
            int r6 = r0.rMask
            int r7 = r0.gMask
            int r8 = r0.bMask
            r3.<init>(r4, r6, r7, r8)
            java.awt.image.DataBufferUShort r9 = new java.awt.image.DataBufferUShort
            int r4 = r2.length
            r9.<init>(r2, r4)
            goto L_0x0054
        L_0x00ef:
            r0 = r1
            r3 = r0
        L_0x00f1:
            if (r3 == 0) goto L_0x00fc
            if (r0 != 0) goto L_0x00f6
            return r1
        L_0x00f6:
            java.awt.image.BufferedImage r2 = new java.awt.image.BufferedImage
            r2.<init>(r3, r0, r5, r1)
            return r2
        L_0x00fc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.awt.datatransfer.DataProxy.createBufferedImage(org.apache.harmony.awt.datatransfer.RawBitmap):java.awt.image.BufferedImage");
    }

    private String getCharset(DataFlavor dataFlavor) {
        return dataFlavor.getParameter(HttpRequest.PARAM_CHARSET);
    }

    private Object getFileList(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (!this.data.isNativeFormatAvailable("application/x-java-file-list")) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        String[] fileList = this.data.getFileList();
        if (fileList != null) {
            return Arrays.asList(fileList);
        }
        throw new IOException(Messages.getString("awt.4F"));
    }

    private Object getHTML(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (!this.data.isNativeFormatAvailable("text/html")) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        String html = this.data.getHTML();
        if (html != null) {
            return getTextRepresentation(html, dataFlavor);
        }
        throw new IOException(Messages.getString("awt.4F"));
    }

    private Image getImage(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (!this.data.isNativeFormatAvailable("image/x-java-image")) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        RawBitmap rawBitmap = this.data.getRawBitmap();
        if (rawBitmap != null) {
            return createBufferedImage(rawBitmap);
        }
        throw new IOException(Messages.getString("awt.4F"));
    }

    private Object getPlainText(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (!this.data.isNativeFormatAvailable("text/plain")) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        String text = this.data.getText();
        if (text != null) {
            return getTextRepresentation(text, dataFlavor);
        }
        throw new IOException(Messages.getString("awt.4F"));
    }

    private Object getSerializedObject(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        String encodeDataFlavor = SystemFlavorMap.encodeDataFlavor(dataFlavor);
        if (encodeDataFlavor == null || !this.data.isNativeFormatAvailable(encodeDataFlavor)) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        byte[] serializedObject = this.data.getSerializedObject(dataFlavor.getRepresentationClass());
        if (serializedObject == null) {
            throw new IOException(Messages.getString("awt.4F"));
        }
        try {
            return new ObjectInputStream(new ByteArrayInputStream(serializedObject)).readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e.getMessage());
        }
    }

    private Object getTextRepresentation(String str, DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        if (dataFlavor.getRepresentationClass() == String.class) {
            return str;
        }
        if (dataFlavor.isRepresentationClassReader()) {
            return new StringReader(str);
        }
        if (dataFlavor.isRepresentationClassCharBuffer()) {
            return CharBuffer.wrap(str);
        }
        if (dataFlavor.getRepresentationClass() == char[].class) {
            char[] cArr = new char[str.length()];
            str.getChars(0, str.length(), cArr, 0);
            return cArr;
        }
        String charset = getCharset(dataFlavor);
        if (dataFlavor.getRepresentationClass() == byte[].class) {
            return str.getBytes(charset);
        }
        if (dataFlavor.isRepresentationClassByteBuffer()) {
            return ByteBuffer.wrap(str.getBytes(charset));
        }
        if (dataFlavor.isRepresentationClassInputStream()) {
            return new ByteArrayInputStream(str.getBytes(charset));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getURL(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (!this.data.isNativeFormatAvailable("application/x-java-url")) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        String url = this.data.getURL();
        if (url == null) {
            throw new IOException(Messages.getString("awt.4F"));
        }
        URL url2 = new URL(url);
        if (dataFlavor.getRepresentationClass().isAssignableFrom(URL.class)) {
            return url2;
        }
        if (dataFlavor.isFlavorTextType()) {
            return getTextRepresentation(url2.toString(), dataFlavor);
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private boolean isBGR(RawBitmap rawBitmap) {
        return rawBitmap.rMask == 255 && rawBitmap.gMask == 65280 && rawBitmap.bMask == 16711680;
    }

    private boolean isRGB(RawBitmap rawBitmap) {
        return rawBitmap.rMask == 16711680 && rawBitmap.gMask == 65280 && rawBitmap.bMask == 255;
    }

    public final DataProvider getDataProvider() {
        return this.data;
    }

    public final Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        String str = String.valueOf(dataFlavor.getPrimaryType()) + "/" + dataFlavor.getSubType();
        if (dataFlavor.isFlavorTextType()) {
            return str.equalsIgnoreCase("text/html") ? getHTML(dataFlavor) : str.equalsIgnoreCase(DataProvider.TYPE_URILIST) ? getURL(dataFlavor) : getPlainText(dataFlavor);
        }
        if (dataFlavor.isFlavorJavaFileListType()) {
            return getFileList(dataFlavor);
        }
        if (dataFlavor.isFlavorSerializedObjectType()) {
            return getSerializedObject(dataFlavor);
        }
        if (dataFlavor.equals(DataProvider.urlFlavor)) {
            return getURL(dataFlavor);
        }
        if (str.equalsIgnoreCase("image/x-java-image") && Image.class.isAssignableFrom(dataFlavor.getRepresentationClass())) {
            return getImage(dataFlavor);
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    public final DataFlavor[] getTransferDataFlavors() {
        ArrayList arrayList = new ArrayList();
        String[] nativeFormats = this.data.getNativeFormats();
        for (String flavorsForNative : nativeFormats) {
            for (DataFlavor dataFlavor : this.flavorMap.getFlavorsForNative(flavorsForNative)) {
                if (!arrayList.contains(dataFlavor)) {
                    arrayList.add(dataFlavor);
                }
            }
        }
        return (DataFlavor[]) arrayList.toArray(new DataFlavor[arrayList.size()]);
    }

    public final boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        DataFlavor[] transferDataFlavors = getTransferDataFlavors();
        for (DataFlavor equals : transferDataFlavors) {
            if (equals.equals(dataFlavor)) {
                return true;
            }
        }
        return false;
    }
}
