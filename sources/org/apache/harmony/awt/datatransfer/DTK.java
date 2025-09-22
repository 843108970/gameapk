package org.apache.harmony.awt.datatransfer;

import com.lidroid.xutils.util.CharsetUtils;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.dnd.peer.DropTargetContextPeer;
import java.nio.charset.Charset;
import org.apache.commons.mail.EmailConstants;
import org.apache.harmony.awt.internal.nls.Messages;
import org.apache.harmony.misc.SystemUtils;

public abstract class DTK {
    protected final DataTransferThread dataTransferThread = new DataTransferThread(this);
    private NativeClipboard nativeClipboard = null;
    private NativeClipboard nativeSelection = null;
    protected SystemFlavorMap systemFlavorMap;

    protected DTK() {
        this.dataTransferThread.start();
    }

    private static DTK createDTK() {
        String str;
        switch (SystemUtils.getOS()) {
            case 1:
                str = "org.apache.harmony.awt.datatransfer.windows.WinDTK";
                break;
            case 2:
                str = "org.apache.harmony.awt.datatransfer.linux.LinuxDTK";
                break;
            default:
                throw new RuntimeException(Messages.getString("awt.4E"));
        }
        try {
            return (DTK) Class.forName(str).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.harmony.awt.datatransfer.DTK getDTK() {
        /*
            java.lang.Object r0 = org.apache.harmony.awt.ContextStorage.getContextLock()
            monitor-enter(r0)
            boolean r1 = org.apache.harmony.awt.ContextStorage.shutdownPending()     // Catch:{ all -> 0x001d }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            r0 = 0
            return r0
        L_0x000e:
            org.apache.harmony.awt.datatransfer.DTK r1 = org.apache.harmony.awt.ContextStorage.getDTK()     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x001b
            org.apache.harmony.awt.datatransfer.DTK r1 = createDTK()     // Catch:{ all -> 0x001d }
            org.apache.harmony.awt.ContextStorage.setDTK(r1)     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return r1
        L_0x001d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.awt.datatransfer.DTK.getDTK():org.apache.harmony.awt.datatransfer.DTK");
    }

    /* access modifiers changed from: protected */
    public void appendSystemFlavorMap(SystemFlavorMap systemFlavorMap2, DataFlavor dataFlavor, String str) {
        systemFlavorMap2.addFlavorForUnencodedNative(str, dataFlavor);
        systemFlavorMap2.addUnencodedNativeForFlavor(dataFlavor, str);
    }

    /* access modifiers changed from: protected */
    public void appendSystemFlavorMap(SystemFlavorMap systemFlavorMap2, String[] strArr, String str, String str2) {
        TextFlavor.addUnicodeClasses(systemFlavorMap2, str2, str);
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != null && Charset.isSupported(strArr[i])) {
                TextFlavor.addCharsetClasses(systemFlavorMap2, str2, str, strArr[i]);
            }
        }
    }

    public abstract DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dragGestureEvent);

    public abstract DropTargetContextPeer createDropTargetContextPeer(DropTargetContext dropTargetContext);

    /* access modifiers changed from: protected */
    public String[] getCharsets() {
        return new String[]{"UTF-16", "UTF-8", "unicode", CharsetUtils.DEFAULT_ENCODING_CHARSET, "US-ASCII"};
    }

    public String getDefaultCharset() {
        return "unicode";
    }

    public NativeClipboard getNativeClipboard() {
        if (this.nativeClipboard == null) {
            this.nativeClipboard = newNativeClipboard();
        }
        return this.nativeClipboard;
    }

    public NativeClipboard getNativeSelection() {
        if (this.nativeSelection == null) {
            this.nativeSelection = newNativeSelection();
        }
        return this.nativeSelection;
    }

    public synchronized SystemFlavorMap getSystemFlavorMap() {
        return this.systemFlavorMap;
    }

    public abstract void initDragAndDrop();

    public void initSystemFlavorMap(SystemFlavorMap systemFlavorMap2) {
        String[] charsets = getCharsets();
        appendSystemFlavorMap(systemFlavorMap2, DataFlavor.stringFlavor, "text/plain");
        appendSystemFlavorMap(systemFlavorMap2, charsets, "plain", "text/plain");
        appendSystemFlavorMap(systemFlavorMap2, charsets, EmailConstants.TEXT_SUBTYPE_HTML, "text/html");
        appendSystemFlavorMap(systemFlavorMap2, DataProvider.urlFlavor, "application/x-java-url");
        appendSystemFlavorMap(systemFlavorMap2, charsets, "uri-list", "application/x-java-url");
        appendSystemFlavorMap(systemFlavorMap2, DataFlavor.javaFileListFlavor, "application/x-java-file-list");
        appendSystemFlavorMap(systemFlavorMap2, DataFlavor.imageFlavor, "image/x-java-image");
    }

    /* access modifiers changed from: protected */
    public abstract NativeClipboard newNativeClipboard();

    /* access modifiers changed from: protected */
    public abstract NativeClipboard newNativeSelection();

    public abstract void runEventLoop();

    public synchronized void setSystemFlavorMap(SystemFlavorMap systemFlavorMap2) {
        this.systemFlavorMap = systemFlavorMap2;
    }
}
