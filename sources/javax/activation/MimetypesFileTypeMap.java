package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MimeTypeFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class MimetypesFileTypeMap extends FileTypeMap {
    private static final int PROG = 0;
    private static MimeTypeFile defDB = null;
    private static String defaultType = "application/octet-stream";
    private MimeTypeFile[] DB;

    public MimetypesFileTypeMap() {
        Vector vector = new Vector(5);
        vector.addElement((Object) null);
        LogSupport.log("MimetypesFileTypeMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MimeTypeFile loadFile = loadFile(String.valueOf(property) + File.separator + ".mime.types");
                if (loadFile != null) {
                    vector.addElement(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MimetypesFileTypeMap: load SYS");
        try {
            MimeTypeFile loadFile2 = loadFile(String.valueOf(System.getProperty("java.home")) + File.separator + "lib" + File.separator + "mime.types");
            if (loadFile2 != null) {
                vector.addElement(loadFile2);
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MimetypesFileTypeMap: load JAR");
        loadAllResources(vector, "mime.types");
        LogSupport.log("MimetypesFileTypeMap: load DEF");
        synchronized (MimetypesFileTypeMap.class) {
            if (defDB == null) {
                defDB = loadResource("/mimetypes.default");
            }
        }
        if (defDB != null) {
            vector.addElement(defDB);
        }
        this.DB = new MimeTypeFile[vector.size()];
        vector.copyInto(this.DB);
    }

    public MimetypesFileTypeMap(InputStream inputStream) {
        this();
        try {
            this.DB[0] = new MimeTypeFile(inputStream);
        } catch (IOException unused) {
        }
    }

    public MimetypesFileTypeMap(String str) throws IOException {
        this();
        this.DB[0] = new MimeTypeFile(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.io.InputStream} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x00e4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a9 A[Catch:{ IOException -> 0x00bd, SecurityException -> 0x00a0, all -> 0x009d, all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bc A[Catch:{ IOException -> 0x00bd, SecurityException -> 0x00a0, all -> 0x009d, all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c6 A[Catch:{ IOException -> 0x00bd, SecurityException -> 0x00a0, all -> 0x009d, all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e1 A[SYNTHETIC, Splitter:B:66:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00da A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00da A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.util.Vector r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            java.lang.ClassLoader r1 = javax.activation.SecuritySupport.getContextClassLoader()     // Catch:{ Exception -> 0x00e8 }
            if (r1 != 0) goto L_0x000f
            java.lang.Class r1 = r8.getClass()     // Catch:{ Exception -> 0x00e8 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ Exception -> 0x00e8 }
        L_0x000f:
            if (r1 == 0) goto L_0x0016
            java.net.URL[] r1 = javax.activation.SecuritySupport.getResources(r1, r10)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x001a
        L_0x0016:
            java.net.URL[] r1 = javax.activation.SecuritySupport.getSystemResources(r10)     // Catch:{ Exception -> 0x00e8 }
        L_0x001a:
            if (r1 == 0) goto L_0x0100
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ Exception -> 0x00e8 }
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = "MimetypesFileTypeMap: getResources"
            com.sun.activation.registries.LogSupport.log(r2)     // Catch:{ Exception -> 0x00e8 }
        L_0x0027:
            r2 = 0
        L_0x0028:
            int r3 = r1.length     // Catch:{ Exception -> 0x00e5 }
            if (r0 < r3) goto L_0x002e
            r0 = r2
            goto L_0x0100
        L_0x002e:
            r3 = r1[r0]     // Catch:{ Exception -> 0x00e5 }
            r4 = 0
            boolean r5 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ Exception -> 0x00e5 }
            if (r5 == 0) goto L_0x0048
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r6 = "MimetypesFileTypeMap: URL "
            r5.<init>(r6)     // Catch:{ Exception -> 0x00e5 }
            r5.append(r3)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00e5 }
            com.sun.activation.registries.LogSupport.log(r5)     // Catch:{ Exception -> 0x00e5 }
        L_0x0048:
            r5 = 1
            java.io.InputStream r6 = javax.activation.SecuritySupport.openStream(r3)     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x00a0, all -> 0x009d }
            if (r6 == 0) goto L_0x0080
            com.sun.activation.registries.MimeTypeFile r4 = new com.sun.activation.registries.MimeTypeFile     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            r4.<init>((java.io.InputStream) r6)     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            r9.addElement(r4)     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0074, all -> 0x0070 }
            if (r2 == 0) goto L_0x006e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0074, all -> 0x0070 }
            java.lang.String r4 = "MimetypesFileTypeMap: successfully loaded mime types from URL: "
            r2.<init>(r4)     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0074, all -> 0x0070 }
            r2.append(r3)     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0074, all -> 0x0070 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0074, all -> 0x0070 }
            com.sun.activation.registries.LogSupport.log(r2)     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0074, all -> 0x0070 }
        L_0x006e:
            r2 = 1
            goto L_0x0097
        L_0x0070:
            r0 = move-exception
            r2 = 1
            goto L_0x00df
        L_0x0074:
            r2 = move-exception
            r4 = r2
            r2 = 1
            goto L_0x00a3
        L_0x0078:
            r2 = move-exception
            r4 = r2
            r2 = 1
            goto L_0x00c0
        L_0x007c:
            r4 = move-exception
            goto L_0x00a3
        L_0x007e:
            r4 = move-exception
            goto L_0x00c0
        L_0x0080:
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            if (r4 == 0) goto L_0x0097
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            java.lang.String r5 = "MimetypesFileTypeMap: not loading mime types from URL: "
            r4.<init>(r5)     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            r4.append(r3)     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            com.sun.activation.registries.LogSupport.log(r4)     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
        L_0x0097:
            if (r6 == 0) goto L_0x00da
        L_0x0099:
            r6.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00da
        L_0x009d:
            r0 = move-exception
            r6 = r4
            goto L_0x00df
        L_0x00a0:
            r5 = move-exception
            r6 = r4
            r4 = r5
        L_0x00a3:
            boolean r5 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x00de }
            if (r5 == 0) goto L_0x00ba
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00de }
            java.lang.String r7 = "MimetypesFileTypeMap: can't load "
            r5.<init>(r7)     // Catch:{ all -> 0x00de }
            r5.append(r3)     // Catch:{ all -> 0x00de }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00de }
            com.sun.activation.registries.LogSupport.log(r3, r4)     // Catch:{ all -> 0x00de }
        L_0x00ba:
            if (r6 == 0) goto L_0x00da
            goto L_0x0099
        L_0x00bd:
            r5 = move-exception
            r6 = r4
            r4 = r5
        L_0x00c0:
            boolean r5 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x00de }
            if (r5 == 0) goto L_0x00d7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00de }
            java.lang.String r7 = "MimetypesFileTypeMap: can't load "
            r5.<init>(r7)     // Catch:{ all -> 0x00de }
            r5.append(r3)     // Catch:{ all -> 0x00de }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00de }
            com.sun.activation.registries.LogSupport.log(r3, r4)     // Catch:{ all -> 0x00de }
        L_0x00d7:
            if (r6 == 0) goto L_0x00da
            goto L_0x0099
        L_0x00da:
            int r0 = r0 + 1
            goto L_0x0028
        L_0x00de:
            r0 = move-exception
        L_0x00df:
            if (r6 == 0) goto L_0x00e4
            r6.close()     // Catch:{ IOException -> 0x00e4 }
        L_0x00e4:
            throw r0     // Catch:{ Exception -> 0x00e5 }
        L_0x00e5:
            r1 = move-exception
            r0 = r2
            goto L_0x00e9
        L_0x00e8:
            r1 = move-exception
        L_0x00e9:
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r2 == 0) goto L_0x0100
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "MimetypesFileTypeMap: can't load "
            r2.<init>(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            com.sun.activation.registries.LogSupport.log(r2, r1)
        L_0x0100:
            if (r0 != 0) goto L_0x011e
            java.lang.String r0 = "MimetypesFileTypeMap: !anyLoaded"
            com.sun.activation.registries.LogSupport.log(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "/"
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            com.sun.activation.registries.MimeTypeFile r10 = r8.loadResource(r10)
            if (r10 == 0) goto L_0x011e
            r9.addElement(r10)
        L_0x011e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadAllResources(java.util.Vector, java.lang.String):void");
    }

    private MimeTypeFile loadFile(String str) {
        try {
            return new MimeTypeFile(str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        if (r1 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        if (r1 == null) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0059 A[Catch:{ IOException -> 0x006d, SecurityException -> 0x0051, all -> 0x004e, all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c A[Catch:{ IOException -> 0x006d, SecurityException -> 0x0051, all -> 0x004e, all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075 A[Catch:{ IOException -> 0x006d, SecurityException -> 0x0051, all -> 0x004e, all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008d A[SYNTHETIC, Splitter:B:43:0x008d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sun.activation.registries.MimeTypeFile loadResource(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Class r1 = r5.getClass()     // Catch:{ IOException -> 0x006d, SecurityException -> 0x0051, all -> 0x004e }
            java.io.InputStream r1 = javax.activation.SecuritySupport.getResourceAsStream(r1, r6)     // Catch:{ IOException -> 0x006d, SecurityException -> 0x0051, all -> 0x004e }
            if (r1 == 0) goto L_0x0031
            com.sun.activation.registries.MimeTypeFile r2 = new com.sun.activation.registries.MimeTypeFile     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            r2.<init>((java.io.InputStream) r1)     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            if (r3 == 0) goto L_0x0027
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            java.lang.String r4 = "MimetypesFileTypeMap: successfully loaded mime types file: "
            r3.<init>(r4)     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            r3.append(r6)     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            com.sun.activation.registries.LogSupport.log(r3)     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x002c }
        L_0x002c:
            return r2
        L_0x002d:
            r2 = move-exception
            goto L_0x0053
        L_0x002f:
            r2 = move-exception
            goto L_0x006f
        L_0x0031:
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            if (r2 == 0) goto L_0x0048
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            java.lang.String r3 = "MimetypesFileTypeMap: not loading mime types file: "
            r2.<init>(r3)     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            r2.append(r6)     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            com.sun.activation.registries.LogSupport.log(r2)     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
        L_0x0048:
            if (r1 == 0) goto L_0x0089
        L_0x004a:
            r1.close()     // Catch:{ IOException -> 0x0089 }
            return r0
        L_0x004e:
            r6 = move-exception
            r1 = r0
            goto L_0x008b
        L_0x0051:
            r2 = move-exception
            r1 = r0
        L_0x0053:
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x006a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            java.lang.String r4 = "MimetypesFileTypeMap: can't load "
            r3.<init>(r4)     // Catch:{ all -> 0x008a }
            r3.append(r6)     // Catch:{ all -> 0x008a }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x008a }
            com.sun.activation.registries.LogSupport.log(r6, r2)     // Catch:{ all -> 0x008a }
        L_0x006a:
            if (r1 == 0) goto L_0x0089
            goto L_0x004a
        L_0x006d:
            r2 = move-exception
            r1 = r0
        L_0x006f:
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0086
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            java.lang.String r4 = "MimetypesFileTypeMap: can't load "
            r3.<init>(r4)     // Catch:{ all -> 0x008a }
            r3.append(r6)     // Catch:{ all -> 0x008a }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x008a }
            com.sun.activation.registries.LogSupport.log(r6, r2)     // Catch:{ all -> 0x008a }
        L_0x0086:
            if (r1 == 0) goto L_0x0089
            goto L_0x004a
        L_0x0089:
            return r0
        L_0x008a:
            r6 = move-exception
        L_0x008b:
            if (r1 == 0) goto L_0x0090
            r1.close()     // Catch:{ IOException -> 0x0090 }
        L_0x0090:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadResource(java.lang.String):com.sun.activation.registries.MimeTypeFile");
    }

    public synchronized void addMimeTypes(String str) {
        if (this.DB[0] == null) {
            this.DB[0] = new MimeTypeFile();
        }
        this.DB[0].appendToRegistry(str);
    }

    public String getContentType(File file) {
        return getContentType(file.getName());
    }

    public synchronized String getContentType(String str) {
        String mIMETypeString;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return defaultType;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.length() == 0) {
            return defaultType;
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null && (mIMETypeString = this.DB[i].getMIMETypeString(substring)) != null) {
                return mIMETypeString;
            }
        }
        return defaultType;
    }
}
