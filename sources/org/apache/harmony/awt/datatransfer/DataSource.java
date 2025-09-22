package org.apache.harmony.awt.datatransfer;

import android.support.v4.view.MotionEventCompat;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.mail.EmailConstants;

public class DataSource implements DataProvider {
    protected final Transferable contents;
    private DataFlavor[] flavors;
    private List<String> nativeFormats;

    public DataSource(Transferable transferable) {
        this.contents = transferable;
    }

    private RawBitmap getImageBitmap(Image image) {
        if (image instanceof BufferedImage) {
            BufferedImage bufferedImage = (BufferedImage) image;
            if (bufferedImage.getType() == 1) {
                return getImageBitmap32(bufferedImage);
            }
        }
        int width = image.getWidth((ImageObserver) null);
        int height = image.getHeight((ImageObserver) null);
        if (width <= 0 || height <= 0) {
            return null;
        }
        BufferedImage bufferedImage2 = new BufferedImage(width, height, 1);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(image, 0, 0, (ImageObserver) null);
        graphics.dispose();
        return getImageBitmap32(bufferedImage2);
    }

    private RawBitmap getImageBitmap32(BufferedImage bufferedImage) {
        int[] iArr = new int[(bufferedImage.getWidth() * bufferedImage.getHeight())];
        DataBufferInt dataBuffer = bufferedImage.getRaster().getDataBuffer();
        int numBanks = dataBuffer.getNumBanks();
        int[] offsets = dataBuffer.getOffsets();
        int i = 0;
        for (int i2 = 0; i2 < numBanks; i2++) {
            int[] data = dataBuffer.getData(i2);
            System.arraycopy(data, offsets[i2], iArr, i, data.length - offsets[i2]);
            i += data.length - offsets[i2];
        }
        return new RawBitmap(bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage.getWidth(), 32, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, iArr);
    }

    private static List<String> getNativesForFlavors(DataFlavor[] dataFlavorArr) {
        ArrayList arrayList = new ArrayList();
        SystemFlavorMap defaultFlavorMap = SystemFlavorMap.getDefaultFlavorMap();
        for (DataFlavor nativesForFlavor : dataFlavorArr) {
            for (String str : defaultFlavorMap.getNativesForFlavor(nativesForFlavor)) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private String getText(boolean z) {
        DataFlavor[] transferDataFlavors = this.contents.getTransferDataFlavors();
        for (DataFlavor dataFlavor : transferDataFlavors) {
            if (dataFlavor.isFlavorTextType() && (!z || isHtmlFlavor(dataFlavor))) {
                try {
                    return String.class.isAssignableFrom(dataFlavor.getRepresentationClass()) ? (String) this.contents.getTransferData(dataFlavor) : getTextFromReader(dataFlavor.getReaderForText(this.contents));
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    private String getTextFromReader(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[1024];
        while (true) {
            int read = reader.read(cArr);
            if (read <= 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    private boolean isHtmlFlavor(DataFlavor dataFlavor) {
        return EmailConstants.TEXT_SUBTYPE_HTML.equalsIgnoreCase(dataFlavor.getSubType());
    }

    /* access modifiers changed from: protected */
    public DataFlavor[] getDataFlavors() {
        if (this.flavors == null) {
            this.flavors = this.contents.getTransferDataFlavors();
        }
        return this.flavors;
    }

    public String[] getFileList() {
        try {
            List list = (List) this.contents.getTransferData(DataFlavor.javaFileListFlavor);
            return (String[]) list.toArray(new String[list.size()]);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getHTML() {
        return getText(true);
    }

    public String[] getNativeFormats() {
        return (String[]) getNativeFormatsList().toArray(new String[0]);
    }

    public List<String> getNativeFormatsList() {
        if (this.nativeFormats == null) {
            this.nativeFormats = getNativesForFlavors(getDataFlavors());
        }
        return this.nativeFormats;
    }

    public RawBitmap getRawBitmap() {
        DataFlavor[] transferDataFlavors = this.contents.getTransferDataFlavors();
        for (DataFlavor dataFlavor : transferDataFlavors) {
            Class representationClass = dataFlavor.getRepresentationClass();
            if (representationClass != null && Image.class.isAssignableFrom(representationClass) && (dataFlavor.isMimeTypeEqual(DataFlavor.imageFlavor) || dataFlavor.isFlavorSerializedObjectType())) {
                try {
                    return getImageBitmap((Image) this.contents.getTransferData(dataFlavor));
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    public byte[] getSerializedObject(Class<?> cls) {
        try {
            DataFlavor dataFlavor = new DataFlavor(cls, (String) null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject((Serializable) this.contents.getTransferData(dataFlavor));
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getText() {
        return getText(false);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        return ((java.net.URL) r2.contents.getTransferData(uriFlavor)).toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        return new java.net.URL(getText()).toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getURL() {
        /*
            r2 = this;
            java.awt.datatransfer.Transferable r0 = r2.contents     // Catch:{ Exception -> 0x000f }
            java.awt.datatransfer.DataFlavor r1 = urlFlavor     // Catch:{ Exception -> 0x000f }
            java.lang.Object r0 = r0.getTransferData(r1)     // Catch:{ Exception -> 0x000f }
            java.net.URL r0 = (java.net.URL) r0     // Catch:{ Exception -> 0x000f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x000f }
            return r0
        L_0x000f:
            java.awt.datatransfer.Transferable r0 = r2.contents     // Catch:{ Exception -> 0x001e }
            java.awt.datatransfer.DataFlavor r1 = uriFlavor     // Catch:{ Exception -> 0x001e }
            java.lang.Object r0 = r0.getTransferData(r1)     // Catch:{ Exception -> 0x001e }
            java.net.URL r0 = (java.net.URL) r0     // Catch:{ Exception -> 0x001e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x001e }
            return r0
        L_0x001e:
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x002c }
            java.lang.String r1 = r2.getText()     // Catch:{ Exception -> 0x002c }
            r0.<init>(r1)     // Catch:{ Exception -> 0x002c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x002c }
            return r0
        L_0x002c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.awt.datatransfer.DataSource.getURL():java.lang.String");
    }

    public boolean isNativeFormatAvailable(String str) {
        return getNativeFormatsList().contains(str);
    }
}
