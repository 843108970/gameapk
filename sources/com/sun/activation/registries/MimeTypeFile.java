package com.sun.activation.registries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.litepal.g.b;

public class MimeTypeFile {
    private String fname = null;
    private Hashtable type_hash = new Hashtable();

    public MimeTypeFile() {
    }

    public MimeTypeFile(InputStream inputStream) throws IOException {
        parse(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public MimeTypeFile(String str) throws IOException {
        this.fname = str;
        FileReader fileReader = new FileReader(new File(this.fname));
        try {
            parse(new BufferedReader(fileReader));
        } finally {
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        }
    }

    private void parse(BufferedReader bufferedReader) throws IOException {
        String str;
        String readLine;
        loop0:
        while (true) {
            str = null;
            while (true) {
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (str != null) {
                        readLine = String.valueOf(str) + readLine;
                    }
                    int length = readLine.length();
                    if (readLine.length() <= 0) {
                        break;
                    }
                    int i = length - 1;
                    if (readLine.charAt(i) != '\\') {
                        break;
                    }
                    str = readLine.substring(0, i);
                } else {
                    break loop0;
                }
            }
            parseEntry(readLine);
        }
        if (str != null) {
            parseEntry(str);
        }
    }

    private void parseEntry(String str) {
        String trim = str.trim();
        if (trim.length() != 0 && trim.charAt(0) != '#') {
            if (trim.indexOf(61) > 0) {
                LineTokenizer lineTokenizer = new LineTokenizer(trim);
                String str2 = null;
                while (lineTokenizer.hasMoreTokens()) {
                    String nextToken = lineTokenizer.nextToken();
                    String nextToken2 = (!lineTokenizer.hasMoreTokens() || !lineTokenizer.nextToken().equals("=") || !lineTokenizer.hasMoreTokens()) ? null : lineTokenizer.nextToken();
                    if (nextToken2 == null) {
                        if (LogSupport.isLoggable()) {
                            LogSupport.log("Bad .mime.types entry: " + trim);
                            return;
                        }
                        return;
                    } else if (nextToken.equals(b.c.f4839c)) {
                        str2 = nextToken2;
                    } else if (nextToken.equals("exts")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(nextToken2, ",");
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken3 = stringTokenizer.nextToken();
                            MimeTypeEntry mimeTypeEntry = new MimeTypeEntry(str2, nextToken3);
                            this.type_hash.put(nextToken3, mimeTypeEntry);
                            if (LogSupport.isLoggable()) {
                                LogSupport.log("Added: " + mimeTypeEntry.toString());
                            }
                        }
                    }
                }
                return;
            }
            StringTokenizer stringTokenizer2 = new StringTokenizer(trim);
            if (stringTokenizer2.countTokens() != 0) {
                String nextToken4 = stringTokenizer2.nextToken();
                while (stringTokenizer2.hasMoreTokens()) {
                    String nextToken5 = stringTokenizer2.nextToken();
                    MimeTypeEntry mimeTypeEntry2 = new MimeTypeEntry(nextToken4, nextToken5);
                    this.type_hash.put(nextToken5, mimeTypeEntry2);
                    if (LogSupport.isLoggable()) {
                        LogSupport.log("Added: " + mimeTypeEntry2.toString());
                    }
                }
            }
        }
    }

    public void appendToRegistry(String str) {
        try {
            parse(new BufferedReader(new StringReader(str)));
        } catch (IOException unused) {
        }
    }

    public String getMIMETypeString(String str) {
        MimeTypeEntry mimeTypeEntry = getMimeTypeEntry(str);
        if (mimeTypeEntry != null) {
            return mimeTypeEntry.getMIMEType();
        }
        return null;
    }

    public MimeTypeEntry getMimeTypeEntry(String str) {
        return (MimeTypeEntry) this.type_hash.get(str);
    }
}
