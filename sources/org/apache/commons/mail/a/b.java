package org.apache.commons.mail.a;

import java.io.IOException;
import java.io.InputStream;
import javax.activation.DataSource;
import javax.activation.FileTypeMap;
import javax.mail.util.ByteArrayDataSource;

public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private final String f4282b;

    public b() {
        this.f4282b = "/";
    }

    private b(String str) {
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        this.f4282b = str;
    }

    private b(String str, boolean z) {
        super(z);
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        this.f4282b = str;
    }

    private String a() {
        return this.f4282b;
    }

    private String b(String str) {
        return (this.f4282b + str).replaceAll("//", "/");
    }

    public DataSource resolve(String str) throws IOException {
        return resolve(str, this.f4281a);
    }

    public DataSource resolve(String str, boolean z) throws IOException {
        try {
            if (str.startsWith("cid:") || a(str)) {
                return null;
            }
            String contentType = FileTypeMap.getDefaultFileTypeMap().getContentType(str);
            String replaceAll = (this.f4282b + str).replaceAll("//", "/");
            InputStream resourceAsStream = b.class.getResourceAsStream(replaceAll);
            if (resourceAsStream != null) {
                ByteArrayDataSource byteArrayDataSource = new ByteArrayDataSource(resourceAsStream, contentType);
                byteArrayDataSource.setName(b.class.getResource(replaceAll).toString());
                return byteArrayDataSource;
            } else if (z) {
                return null;
            } else {
                throw new IOException("The following class path resource was not found : " + str);
            }
        } catch (IOException e) {
            if (z) {
                return null;
            }
            throw e;
        }
    }
}
