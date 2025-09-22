package javax.activation;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import myjava.awt.datatransfer.DataFlavor;
import myjava.awt.datatransfer.UnsupportedFlavorException;

class ObjectDataContentHandler implements DataContentHandler {
    private DataContentHandler dch = null;
    private String mimeType;
    private Object obj;
    private DataFlavor[] transferFlavors = null;

    public ObjectDataContentHandler(DataContentHandler dataContentHandler, Object obj2, String str) {
        this.obj = obj2;
        this.mimeType = str;
        this.dch = dataContentHandler;
    }

    public Object getContent(DataSource dataSource) {
        return this.obj;
    }

    public DataContentHandler getDCH() {
        return this.dch;
    }

    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws UnsupportedFlavorException, IOException {
        if (this.dch != null) {
            return this.dch.getTransferData(dataFlavor, dataSource);
        }
        if (dataFlavor.equals(getTransferDataFlavors()[0])) {
            return this.obj;
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    public synchronized DataFlavor[] getTransferDataFlavors() {
        if (this.transferFlavors == null) {
            if (this.dch != null) {
                this.transferFlavors = this.dch.getTransferDataFlavors();
            } else {
                this.transferFlavors = new DataFlavor[1];
                this.transferFlavors[0] = new ActivationDataFlavor(this.obj.getClass(), this.mimeType, this.mimeType);
            }
        }
        return this.transferFlavors;
    }

    public void writeTo(Object obj2, String str, OutputStream outputStream) throws IOException {
        if (this.dch != null) {
            this.dch.writeTo(obj2, str, outputStream);
        } else if (obj2 instanceof byte[]) {
            outputStream.write((byte[]) obj2);
        } else if (obj2 instanceof String) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write((String) obj2);
            outputStreamWriter.flush();
        } else {
            throw new UnsupportedDataTypeException("no object DCH for MIME type " + this.mimeType);
        }
    }
}
