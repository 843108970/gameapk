package org.litepal.e;

import net.grandcentrix.tray.provider.ContentProviderStorage;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class c extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    private a f4735a;

    public final void characters(char[] cArr, int i, int i2) throws SAXException {
    }

    public final void endDocument() throws SAXException {
    }

    public final void endElement(String str, String str2, String str3) throws SAXException {
    }

    public final void startDocument() throws SAXException {
        this.f4735a = a.a();
        this.f4735a.d().clear();
    }

    public final void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        int i = 0;
        if ("dbname".equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.f4735a.f4730b = attributes.getValue(i).trim();
                }
                i++;
            }
        } else if (ContentProviderStorage.VERSION.equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.f4735a.f4729a = Integer.parseInt(attributes.getValue(i).trim());
                }
                i++;
            }
        } else if ("mapping".equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("class".equalsIgnoreCase(attributes.getLocalName(i))) {
                    a aVar = this.f4735a;
                    aVar.d().add(attributes.getValue(i).trim());
                }
                i++;
            }
        } else if ("cases".equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.f4735a.f4731c = attributes.getValue(i).trim();
                }
                i++;
            }
        } else if ("storage".equalsIgnoreCase(str2)) {
            while (i < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i))) {
                    this.f4735a.d = attributes.getValue(i).trim();
                }
                i++;
            }
        }
    }
}
