package org.apache.commons.mail;

import java.net.URL;

public class EmailAttachment {
    public static final String ATTACHMENT = "attachment";
    public static final String INLINE = "inline";
    private String description = "";
    private String disposition = "attachment";
    private String name = "";
    private String path = "";
    private URL url;

    public String getDescription() {
        return this.description;
    }

    public String getDisposition() {
        return this.disposition;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public URL getURL() {
        return this.url;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDisposition(String str) {
        this.disposition = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setURL(URL url2) {
        this.url = url2;
    }
}
