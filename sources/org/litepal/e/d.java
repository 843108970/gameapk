package org.litepal.e;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.litepal.LitePalApplication;
import org.litepal.c.f;
import org.litepal.g.b;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final String f4736a = "dbname";

    /* renamed from: b  reason: collision with root package name */
    static final String f4737b = "version";

    /* renamed from: c  reason: collision with root package name */
    static final String f4738c = "list";
    static final String d = "mapping";
    static final String e = "cases";
    static final String f = "storage";
    static final String g = "value";
    static final String h = "class";
    private static d i;

    public static b a() {
        if (i == null) {
            i = new d();
        }
        return c();
    }

    private static void b() {
        try {
            XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            xMLReader.setContentHandler(new c());
            xMLReader.parse(new InputSource(d()));
        } catch (Resources.NotFoundException unused) {
            throw new f(f.CAN_NOT_FIND_LITEPAL_FILE);
        } catch (SAXException unused2) {
            throw new f(f.FILE_FORMAT_IS_NOT_CORRECT);
        } catch (ParserConfigurationException unused3) {
            throw new f(f.PARSE_CONFIG_FAILED);
        } catch (IOException unused4) {
            throw new f(f.IO_EXCEPTION);
        }
    }

    private static b c() {
        try {
            b bVar = new b();
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(d(), "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                if (eventType == 2) {
                    if (f4736a.equals(name)) {
                        bVar.f4733b = newPullParser.getAttributeValue("", g);
                    } else if ("version".equals(name)) {
                        bVar.f4732a = Integer.parseInt(newPullParser.getAttributeValue("", g));
                    } else if (d.equals(name)) {
                        bVar.a().add(newPullParser.getAttributeValue("", h));
                    } else if (e.equals(name)) {
                        bVar.f4734c = newPullParser.getAttributeValue("", g);
                    } else if (f.equals(name)) {
                        bVar.d = newPullParser.getAttributeValue("", g);
                    }
                }
            }
            return bVar;
        } catch (XmlPullParserException unused) {
            throw new f(f.FILE_FORMAT_IS_NOT_CORRECT);
        } catch (IOException unused2) {
            throw new f(f.IO_EXCEPTION);
        }
    }

    private static InputStream d() throws IOException {
        AssetManager assets = LitePalApplication.a().getAssets();
        String[] list = assets.list("");
        if (list != null && list.length > 0) {
            for (String str : list) {
                if (b.a.e.equalsIgnoreCase(str)) {
                    return assets.open(str, 3);
                }
            }
        }
        throw new f(f.CAN_NOT_FIND_LITEPAL_FILE);
    }
}
