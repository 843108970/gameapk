package com.c.d;

import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private Element f1581a;

    public i(InputStream inputStream) throws SAXException {
        try {
            this.f1581a = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
        } catch (ParserConfigurationException unused) {
        } catch (IOException e) {
            throw new SAXException(e);
        }
    }

    private i(String str) throws SAXException {
        this(str.getBytes());
    }

    private i(Element element) {
        this.f1581a = element;
    }

    private i(byte[] bArr) throws SAXException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    private i a(String str) {
        NodeList elementsByTagName = this.f1581a.getElementsByTagName(str);
        if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
            return null;
        }
        return new i((Element) elementsByTagName.item(0));
    }

    private i a(String str, String str2, String str3) {
        List<i> b2 = b(str, str2, str3);
        if (b2.size() == 0) {
            return null;
        }
        return b2.get(0);
    }

    private static i a(Node node, String str, String str2, String str3) {
        if (node.getNodeType() != 1) {
            return null;
        }
        Element element = (Element) node;
        if (str != null && !str.equals(element.getTagName())) {
            return null;
        }
        if (str2 != null && !element.hasAttribute(str2)) {
            return null;
        }
        if (str3 == null || str3.equals(element.getAttribute(str2))) {
            return new i(element);
        }
        return null;
    }

    private static String a(Node node) {
        String str;
        switch (node.getNodeType()) {
            case 3:
                str = node.getNodeValue();
                if (str != null) {
                    str = str.trim();
                    break;
                }
                break;
            case 4:
                str = node.getNodeValue();
                break;
            default:
                str = null;
                break;
        }
        return str == null ? "" : str;
    }

    private static List<i> a(NodeList nodeList, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            i iVar = null;
            if (item.getNodeType() == 1) {
                Element element = (Element) item;
                if ((str == null || str.equals(element.getTagName())) && ((str2 == null || element.hasAttribute(str2)) && (str3 == null || str3.equals(element.getAttribute(str2))))) {
                    iVar = new i(element);
                }
            }
            if (iVar != null) {
                arrayList.add(iVar);
            }
        }
        return arrayList;
    }

    private Element a() {
        return this.f1581a;
    }

    private void a(Element element, XmlSerializer xmlSerializer, int i, String str) throws Exception {
        String tagName = element.getTagName();
        a(xmlSerializer, i, str);
        xmlSerializer.startTag("", tagName);
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                Attr attr = (Attr) attributes.item(i2);
                xmlSerializer.attribute("", attr.getName(), attr.getValue());
            }
        }
        if (element.hasChildNodes()) {
            NodeList childNodes = element.getChildNodes();
            int i3 = 0;
            for (int i4 = 0; i4 < childNodes.getLength(); i4++) {
                Node item = childNodes.item(i4);
                short nodeType = item.getNodeType();
                if (nodeType != 1) {
                    switch (nodeType) {
                        case 3:
                            xmlSerializer.text(a(item));
                            break;
                        case 4:
                            xmlSerializer.cdsect(a(item));
                            break;
                    }
                } else {
                    a((Element) item, xmlSerializer, i + 1, str);
                    i3++;
                }
            }
            if (i3 > 0) {
                a(xmlSerializer, i, str);
            }
        }
        xmlSerializer.endTag("", tagName);
    }

    private static void a(XmlSerializer xmlSerializer, int i, String str) throws Exception {
        if (str != null) {
            xmlSerializer.text("\n");
            for (int i2 = 0; i2 < i; i2++) {
                xmlSerializer.text(str);
            }
        }
    }

    private String b() {
        return c();
    }

    private List<i> b(String str) {
        return b(str, (String) null, (String) null);
    }

    private List<i> b(String str, String str2, String str3) {
        return a(this.f1581a.getElementsByTagName(str), (String) null, str2, str3);
    }

    private i c(String str) {
        List<i> f = f(str);
        if (f.size() == 0) {
            return null;
        }
        return f.get(0);
    }

    private String c() {
        try {
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument("utf-8", (Boolean) null);
            a(this.f1581a, newSerializer, 0, (String) null);
            newSerializer.endDocument();
            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private i d(String str) {
        List<i> f = f(str);
        if (f.size() == 0) {
            return null;
        }
        return f.get(0);
    }

    private String d() {
        NodeList childNodes = this.f1581a.getChildNodes();
        if (childNodes.getLength() == 1) {
            return childNodes.item(0).getNodeValue();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childNodes.getLength(); i++) {
            sb.append(a(childNodes.item(i)));
        }
        return sb.toString();
    }

    private List<i> e(String str) {
        return f(str);
    }

    private List<i> f(String str) {
        return a(this.f1581a.getChildNodes(), str, (String) null, (String) null);
    }

    private String g(String str) {
        List<i> f = f(str);
        i iVar = f.size() == 0 ? null : f.get(0);
        if (iVar == null) {
            return null;
        }
        NodeList childNodes = iVar.f1581a.getChildNodes();
        if (childNodes.getLength() == 1) {
            return childNodes.item(0).getNodeValue();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childNodes.getLength(); i++) {
            sb.append(a(childNodes.item(i)));
        }
        return sb.toString();
    }

    private String h(String str) {
        return this.f1581a.getAttribute(str);
    }

    public String toString() {
        return c();
    }
}
