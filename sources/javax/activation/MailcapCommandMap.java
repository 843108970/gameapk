package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MailcapFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MailcapCommandMap extends CommandMap {
    private static final int PROG = 0;
    private static MailcapFile defDB;
    private MailcapFile[] DB;

    public MailcapCommandMap() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add((Object) null);
        LogSupport.log("MailcapCommandMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MailcapFile loadFile = loadFile(String.valueOf(property) + File.separator + ".mailcap");
                if (loadFile != null) {
                    arrayList.add(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MailcapCommandMap: load SYS");
        try {
            MailcapFile loadFile2 = loadFile(String.valueOf(System.getProperty("java.home")) + File.separator + "lib" + File.separator + "mailcap");
            if (loadFile2 != null) {
                arrayList.add(loadFile2);
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MailcapCommandMap: load JAR");
        loadAllResources(arrayList, "mailcap");
        LogSupport.log("MailcapCommandMap: load DEF");
        synchronized (MailcapCommandMap.class) {
            if (defDB == null) {
                defDB = loadResource("mailcap.default");
            }
        }
        if (defDB != null) {
            arrayList.add(defDB);
        }
        this.DB = new MailcapFile[arrayList.size()];
        this.DB = (MailcapFile[]) arrayList.toArray(this.DB);
    }

    public MailcapCommandMap(InputStream inputStream) {
        this();
        LogSupport.log("MailcapCommandMap: load PROG");
        if (this.DB[0] == null) {
            try {
                this.DB[0] = new MailcapFile(inputStream);
            } catch (IOException unused) {
            }
        }
    }

    public MailcapCommandMap(String str) throws IOException {
        this();
        if (LogSupport.isLoggable()) {
            LogSupport.log("MailcapCommandMap: load PROG from " + str);
        }
        if (this.DB[0] == null) {
            this.DB[0] = new MailcapFile(str);
        }
    }

    private void appendCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            for (String commandInfo : (List) map.get(str)) {
                list.add(new CommandInfo(str, commandInfo));
            }
        }
    }

    private void appendPrefCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            if (!checkForVerb(list, str)) {
                list.add(new CommandInfo(str, (String) ((List) map.get(str)).get(0)));
            }
        }
    }

    private boolean checkForVerb(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((CommandInfo) it.next()).getCommandName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = java.lang.Class.forName(r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.activation.DataContentHandler getDataContentHandler(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "    got content-handler"
            com.sun.activation.registries.LogSupport.log(r0)
        L_0x000b:
            boolean r0 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r0 == 0) goto L_0x0022
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "      class "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.sun.activation.registries.LogSupport.log(r0)
        L_0x0022:
            java.lang.ClassLoader r0 = javax.activation.SecuritySupport.getContextClassLoader()     // Catch:{ IllegalAccessException -> 0x0060, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0042 }
            if (r0 != 0) goto L_0x0030
            java.lang.Class r0 = r3.getClass()     // Catch:{ IllegalAccessException -> 0x0060, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0042 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ IllegalAccessException -> 0x0060, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0042 }
        L_0x0030:
            java.lang.Class r0 = r0.loadClass(r4)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            java.lang.Class r0 = java.lang.Class.forName(r4)     // Catch:{ IllegalAccessException -> 0x0060, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0042 }
        L_0x0039:
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r0.newInstance()     // Catch:{ IllegalAccessException -> 0x0060, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0042 }
            javax.activation.DataContentHandler r0 = (javax.activation.DataContentHandler) r0     // Catch:{ IllegalAccessException -> 0x0060, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0042 }
            return r0
        L_0x0042:
            r0 = move-exception
            boolean r1 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r1 == 0) goto L_0x0078
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Can't load DCH "
            r1.<init>(r2)
            goto L_0x006e
        L_0x0051:
            r0 = move-exception
            boolean r1 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r1 == 0) goto L_0x0078
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Can't load DCH "
            r1.<init>(r2)
            goto L_0x006e
        L_0x0060:
            r0 = move-exception
            boolean r1 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r1 == 0) goto L_0x0078
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Can't load DCH "
            r1.<init>(r2)
        L_0x006e:
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            com.sun.activation.registries.LogSupport.log(r4, r0)
        L_0x0078:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.getDataContentHandler(java.lang.String):javax.activation.DataContentHandler");
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
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00da A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00da A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.util.List r9, java.lang.String r10) {
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
            java.lang.String r2 = "MailcapCommandMap: getResources"
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
            java.lang.String r6 = "MailcapCommandMap: URL "
            r5.<init>(r6)     // Catch:{ Exception -> 0x00e5 }
            r5.append(r3)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00e5 }
            com.sun.activation.registries.LogSupport.log(r5)     // Catch:{ Exception -> 0x00e5 }
        L_0x0048:
            r5 = 1
            java.io.InputStream r6 = javax.activation.SecuritySupport.openStream(r3)     // Catch:{ IOException -> 0x00bd, SecurityException -> 0x00a0, all -> 0x009d }
            if (r6 == 0) goto L_0x0080
            com.sun.activation.registries.MailcapFile r4 = new com.sun.activation.registries.MailcapFile     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            r4.<init>((java.io.InputStream) r6)     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            r9.add(r4)     // Catch:{ IOException -> 0x007e, SecurityException -> 0x007c }
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0074, all -> 0x0070 }
            if (r2 == 0) goto L_0x006e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0074, all -> 0x0070 }
            java.lang.String r4 = "MailcapCommandMap: successfully loaded mailcap file from URL: "
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
            java.lang.String r5 = "MailcapCommandMap: not loading mailcap file from URL: "
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
            java.lang.String r7 = "MailcapCommandMap: can't load "
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
            java.lang.String r7 = "MailcapCommandMap: can't load "
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
            java.lang.String r3 = "MailcapCommandMap: can't load "
            r2.<init>(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            com.sun.activation.registries.LogSupport.log(r2, r1)
        L_0x0100:
            if (r0 != 0) goto L_0x0124
            boolean r0 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r0 == 0) goto L_0x010d
            java.lang.String r0 = "MailcapCommandMap: !anyLoaded"
            com.sun.activation.registries.LogSupport.log(r0)
        L_0x010d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "/"
            r0.<init>(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            com.sun.activation.registries.MailcapFile r10 = r8.loadResource(r10)
            if (r10 == 0) goto L_0x0124
            r9.add(r10)
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadAllResources(java.util.List, java.lang.String):void");
    }

    private MailcapFile loadFile(String str) {
        try {
            return new MailcapFile(str);
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
    private com.sun.activation.registries.MailcapFile loadResource(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Class r1 = r5.getClass()     // Catch:{ IOException -> 0x006d, SecurityException -> 0x0051, all -> 0x004e }
            java.io.InputStream r1 = javax.activation.SecuritySupport.getResourceAsStream(r1, r6)     // Catch:{ IOException -> 0x006d, SecurityException -> 0x0051, all -> 0x004e }
            if (r1 == 0) goto L_0x0031
            com.sun.activation.registries.MailcapFile r2 = new com.sun.activation.registries.MailcapFile     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            r2.<init>((java.io.InputStream) r1)     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            if (r3 == 0) goto L_0x0027
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x002f, SecurityException -> 0x002d }
            java.lang.String r4 = "MailcapCommandMap: successfully loaded mailcap file: "
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
            java.lang.String r3 = "MailcapCommandMap: not loading mailcap file: "
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
            java.lang.String r4 = "MailcapCommandMap: can't load "
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
            java.lang.String r4 = "MailcapCommandMap: can't load "
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
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadResource(java.lang.String):com.sun.activation.registries.MailcapFile");
    }

    public synchronized void addMailcap(String str) {
        LogSupport.log("MailcapCommandMap: add to PROG");
        if (this.DB[0] == null) {
            this.DB[0] = new MailcapFile();
        }
        this.DB[0].appendToMailcap(str);
    }

    public synchronized DataContentHandler createDataContentHandler(String str) {
        List list;
        DataContentHandler dataContentHandler;
        List list2;
        DataContentHandler dataContentHandler2;
        if (LogSupport.isLoggable()) {
            LogSupport.log("MailcapCommandMap: createDataContentHandler for " + str);
        }
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (this.DB[i] != null) {
                if (LogSupport.isLoggable()) {
                    LogSupport.log("  search DB #" + i);
                }
                Map mailcapList = this.DB[i].getMailcapList(str);
                if (!(mailcapList == null || (list2 = (List) mailcapList.get("content-handler")) == null || (dataContentHandler2 = getDataContentHandler((String) list2.get(0))) == null)) {
                    return dataContentHandler2;
                }
            }
        }
        for (int i2 = 0; i2 < this.DB.length; i2++) {
            if (this.DB[i2] != null) {
                if (LogSupport.isLoggable()) {
                    LogSupport.log("  search fallback DB #" + i2);
                }
                Map mailcapFallbackList = this.DB[i2].getMailcapFallbackList(str);
                if (!(mailcapFallbackList == null || (list = (List) mailcapFallbackList.get("content-handler")) == null || (dataContentHandler = getDataContentHandler((String) list.get(0))) == null)) {
                    return dataContentHandler;
                }
            }
        }
        return null;
    }

    public synchronized CommandInfo[] getAllCommands(String str) {
        ArrayList arrayList;
        Map mailcapFallbackList;
        Map mailcapList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (!(this.DB[i] == null || (mailcapList = this.DB[i].getMailcapList(str)) == null)) {
                appendCmdsToList(mailcapList, arrayList);
            }
        }
        for (int i2 = 0; i2 < this.DB.length; i2++) {
            if (!(this.DB[i2] == null || (mailcapFallbackList = this.DB[i2].getMailcapFallbackList(str)) == null)) {
                appendCmdsToList(mailcapFallbackList, arrayList);
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    public synchronized CommandInfo getCommand(String str, String str2) {
        Map mailcapFallbackList;
        List list;
        String str3;
        Map mailcapList;
        List list2;
        String str4;
        if (str != null) {
            try {
                str = str.toLowerCase(Locale.ENGLISH);
            } catch (Throwable th) {
                throw th;
            }
        }
        int i = 0;
        while (i < this.DB.length) {
            if (this.DB[i] == null || (mailcapList = this.DB[i].getMailcapList(str)) == null || (list2 = (List) mailcapList.get(str2)) == null || (str4 = (String) list2.get(0)) == null) {
                i++;
            } else {
                return new CommandInfo(str2, str4);
            }
        }
        int i2 = 0;
        while (i2 < this.DB.length) {
            if (this.DB[i2] == null || (mailcapFallbackList = this.DB[i2].getMailcapFallbackList(str)) == null || (list = (List) mailcapFallbackList.get(str2)) == null || (str3 = (String) list.get(0)) == null) {
                i2++;
            } else {
                return new CommandInfo(str2, str3);
            }
        }
        return null;
    }

    public synchronized String[] getMimeTypes() {
        ArrayList arrayList;
        String[] mimeTypes;
        arrayList = new ArrayList();
        for (int i = 0; i < this.DB.length; i++) {
            if (!(this.DB[i] == null || (mimeTypes = this.DB[i].getMimeTypes()) == null)) {
                for (int i2 = 0; i2 < mimeTypes.length; i2++) {
                    if (!arrayList.contains(mimeTypes[i2])) {
                        arrayList.add(mimeTypes[i2]);
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized String[] getNativeCommands(String str) {
        ArrayList arrayList;
        String[] nativeCommands;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (!(this.DB[i] == null || (nativeCommands = this.DB[i].getNativeCommands(str)) == null)) {
                for (int i2 = 0; i2 < nativeCommands.length; i2++) {
                    if (!arrayList.contains(nativeCommands[i2])) {
                        arrayList.add(nativeCommands[i2]);
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized CommandInfo[] getPreferredCommands(String str) {
        ArrayList arrayList;
        Map mailcapFallbackList;
        Map mailcapList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        for (int i = 0; i < this.DB.length; i++) {
            if (!(this.DB[i] == null || (mailcapList = this.DB[i].getMailcapList(str)) == null)) {
                appendPrefCmdsToList(mailcapList, arrayList);
            }
        }
        for (int i2 = 0; i2 < this.DB.length; i2++) {
            if (!(this.DB[i2] == null || (mailcapFallbackList = this.DB[i2].getMailcapFallbackList(str)) == null)) {
                appendPrefCmdsToList(mailcapFallbackList, arrayList);
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }
}
