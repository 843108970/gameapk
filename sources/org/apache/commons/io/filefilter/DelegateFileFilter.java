package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.Serializable;

public class DelegateFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -8723373124984771318L;
    private final FileFilter fileFilter;
    private final FilenameFilter filenameFilter;

    public DelegateFileFilter(FileFilter fileFilter2) {
        if (fileFilter2 == null) {
            throw new IllegalArgumentException("The FileFilter must not be null");
        }
        this.fileFilter = fileFilter2;
        this.filenameFilter = null;
    }

    public DelegateFileFilter(FilenameFilter filenameFilter2) {
        if (filenameFilter2 == null) {
            throw new IllegalArgumentException("The FilenameFilter must not be null");
        }
        this.filenameFilter = filenameFilter2;
        this.fileFilter = null;
    }

    public boolean accept(File file) {
        return this.fileFilter != null ? this.fileFilter.accept(file) : super.accept(file);
    }

    public boolean accept(File file, String str) {
        return this.filenameFilter != null ? this.filenameFilter.accept(file, str) : super.accept(file, str);
    }

    public String toString() {
        String obj = (this.fileFilter != null ? this.fileFilter : this.filenameFilter).toString();
        return super.toString() + "(" + obj + ")";
    }
}
