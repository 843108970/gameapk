package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import myjava.awt.datatransfer.DataFlavor;
import myjava.awt.datatransfer.Transferable;
import myjava.awt.datatransfer.UnsupportedFlavorException;

public class DataHandler implements Transferable {
    private static final DataFlavor[] emptyFlavors = new DataFlavor[0];
    private static DataContentHandlerFactory factory;
    private CommandMap currentCommandMap = null;
    private DataContentHandler dataContentHandler = null;
    private DataSource dataSource = null;
    private DataContentHandler factoryDCH = null;
    private DataSource objDataSource = null;
    /* access modifiers changed from: private */
    public Object object = null;
    /* access modifiers changed from: private */
    public String objectMimeType = null;
    private DataContentHandlerFactory oldFactory = null;
    private String shortType = null;
    private DataFlavor[] transferFlavors = emptyFlavors;

    public DataHandler(Object obj, String str) {
        this.object = obj;
        this.objectMimeType = str;
        this.oldFactory = factory;
    }

    public DataHandler(URL url) {
        this.dataSource = new URLDataSource(url);
        this.oldFactory = factory;
    }

    public DataHandler(DataSource dataSource2) {
        this.dataSource = dataSource2;
        this.oldFactory = factory;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String getBaseType() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.shortType     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0017
            java.lang.String r0 = r2.getContentType()     // Catch:{ all -> 0x001b }
            javax.activation.MimeType r1 = new javax.activation.MimeType     // Catch:{ MimeTypeParseException -> 0x0015 }
            r1.<init>(r0)     // Catch:{ MimeTypeParseException -> 0x0015 }
            java.lang.String r1 = r1.getBaseType()     // Catch:{ MimeTypeParseException -> 0x0015 }
            r2.shortType = r1     // Catch:{ MimeTypeParseException -> 0x0015 }
            goto L_0x0017
        L_0x0015:
            r2.shortType = r0     // Catch:{ all -> 0x001b }
        L_0x0017:
            java.lang.String r0 = r2.shortType     // Catch:{ all -> 0x001b }
            monitor-exit(r2)
            return r0
        L_0x001b:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.DataHandler.getBaseType():java.lang.String");
    }

    private synchronized CommandMap getCommandMap() {
        if (this.currentCommandMap != null) {
            return this.currentCommandMap;
        }
        return CommandMap.getDefaultCommandMap();
    }

    private synchronized DataContentHandler getDataContentHandler() {
        if (factory != this.oldFactory) {
            this.oldFactory = factory;
            this.factoryDCH = null;
            this.dataContentHandler = null;
            this.transferFlavors = emptyFlavors;
        }
        if (this.dataContentHandler != null) {
            return this.dataContentHandler;
        }
        String baseType = getBaseType();
        if (this.factoryDCH == null && factory != null) {
            this.factoryDCH = factory.createDataContentHandler(baseType);
        }
        if (this.factoryDCH != null) {
            this.dataContentHandler = this.factoryDCH;
        }
        if (this.dataContentHandler == null) {
            this.dataContentHandler = this.dataSource != null ? getCommandMap().createDataContentHandler(baseType, this.dataSource) : getCommandMap().createDataContentHandler(baseType);
        }
        this.dataContentHandler = this.dataSource != null ? new DataSourceDataContentHandler(this.dataContentHandler, this.dataSource) : new ObjectDataContentHandler(this.dataContentHandler, this.object, this.objectMimeType);
        return this.dataContentHandler;
    }

    public static synchronized void setDataContentHandlerFactory(DataContentHandlerFactory dataContentHandlerFactory) {
        synchronized (DataHandler.class) {
            if (factory != null) {
                throw new Error("DataContentHandlerFactory already defined");
            }
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                try {
                    securityManager.checkSetFactory();
                } catch (SecurityException e) {
                    if (DataHandler.class.getClassLoader() != dataContentHandlerFactory.getClass().getClassLoader()) {
                        throw e;
                    }
                }
            }
            factory = dataContentHandlerFactory;
        }
    }

    public CommandInfo[] getAllCommands() {
        return this.dataSource != null ? getCommandMap().getAllCommands(getBaseType(), this.dataSource) : getCommandMap().getAllCommands(getBaseType());
    }

    public Object getBean(CommandInfo commandInfo) {
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            return commandInfo.getCommandObject(this, contextClassLoader);
        } catch (IOException | ClassNotFoundException unused) {
            return null;
        }
    }

    public CommandInfo getCommand(String str) {
        return this.dataSource != null ? getCommandMap().getCommand(getBaseType(), str, this.dataSource) : getCommandMap().getCommand(getBaseType(), str);
    }

    public Object getContent() throws IOException {
        return this.object != null ? this.object : getDataContentHandler().getContent(getDataSource());
    }

    public String getContentType() {
        return this.dataSource != null ? this.dataSource.getContentType() : this.objectMimeType;
    }

    public DataSource getDataSource() {
        if (this.dataSource != null) {
            return this.dataSource;
        }
        if (this.objDataSource == null) {
            this.objDataSource = new DataHandlerDataSource(this);
        }
        return this.objDataSource;
    }

    public InputStream getInputStream() throws IOException {
        if (this.dataSource != null) {
            return this.dataSource.getInputStream();
        }
        final DataContentHandler dataContentHandler2 = getDataContentHandler();
        if (dataContentHandler2 == null) {
            throw new UnsupportedDataTypeException("no DCH for MIME type " + getBaseType());
        } else if (!(dataContentHandler2 instanceof ObjectDataContentHandler) || ((ObjectDataContentHandler) dataContentHandler2).getDCH() != null) {
            final PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
            new Thread(new Runnable() {
                /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0020 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r4 = this;
                        javax.activation.DataContentHandler r0 = r0     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                        javax.activation.DataHandler r1 = javax.activation.DataHandler.this     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                        java.lang.Object r1 = r1.object     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                        javax.activation.DataHandler r2 = javax.activation.DataHandler.this     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                        java.lang.String r2 = r2.objectMimeType     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                        java.io.PipedOutputStream r3 = r1     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                        r0.writeTo(r1, r2, r3)     // Catch:{ IOException -> 0x0020, all -> 0x0019 }
                        java.io.PipedOutputStream r0 = r1     // Catch:{ IOException -> 0x0018 }
                        r0.close()     // Catch:{ IOException -> 0x0018 }
                    L_0x0018:
                        return
                    L_0x0019:
                        r0 = move-exception
                        java.io.PipedOutputStream r1 = r1     // Catch:{ IOException -> 0x001f }
                        r1.close()     // Catch:{ IOException -> 0x001f }
                    L_0x001f:
                        throw r0
                    L_0x0020:
                        java.io.PipedOutputStream r0 = r1     // Catch:{ IOException -> 0x0025 }
                        r0.close()     // Catch:{ IOException -> 0x0025 }
                    L_0x0025:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: javax.activation.DataHandler.AnonymousClass1.run():void");
                }
            }, "DataHandler.getInputStream").start();
            return pipedInputStream;
        } else {
            throw new UnsupportedDataTypeException("no object DCH for MIME type " + getBaseType());
        }
    }

    public String getName() {
        if (this.dataSource != null) {
            return this.dataSource.getName();
        }
        return null;
    }

    public OutputStream getOutputStream() throws IOException {
        if (this.dataSource != null) {
            return this.dataSource.getOutputStream();
        }
        return null;
    }

    public CommandInfo[] getPreferredCommands() {
        return this.dataSource != null ? getCommandMap().getPreferredCommands(getBaseType(), this.dataSource) : getCommandMap().getPreferredCommands(getBaseType());
    }

    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        return getDataContentHandler().getTransferData(dataFlavor, this.dataSource);
    }

    public synchronized DataFlavor[] getTransferDataFlavors() {
        if (factory != this.oldFactory) {
            this.transferFlavors = emptyFlavors;
        }
        if (this.transferFlavors == emptyFlavors) {
            this.transferFlavors = getDataContentHandler().getTransferDataFlavors();
        }
        return this.transferFlavors;
    }

    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        DataFlavor[] transferDataFlavors = getTransferDataFlavors();
        for (DataFlavor equals : transferDataFlavors) {
            if (equals.equals(dataFlavor)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void setCommandMap(CommandMap commandMap) {
        if (commandMap != this.currentCommandMap || commandMap == null) {
            this.transferFlavors = emptyFlavors;
            this.dataContentHandler = null;
            this.currentCommandMap = commandMap;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.dataSource != null) {
            byte[] bArr = new byte[8192];
            InputStream inputStream = this.dataSource.getInputStream();
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                } finally {
                    inputStream.close();
                }
            }
        } else {
            getDataContentHandler().writeTo(this.object, this.objectMimeType, outputStream);
        }
    }
}
