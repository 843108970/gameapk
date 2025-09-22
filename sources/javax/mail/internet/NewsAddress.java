package javax.mail.internet;

import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;

public class NewsAddress extends Address {
    private static final long serialVersionUID = -4203797299824684143L;
    protected String host;
    protected String newsgroup;

    public NewsAddress() {
    }

    public NewsAddress(String str) {
        this(str, (String) null);
    }

    public NewsAddress(String str, String str2) {
        this.newsgroup = str;
        this.host = str2;
    }

    public static NewsAddress[] parse(String str) throws AddressException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Vector vector = new Vector();
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(new NewsAddress(stringTokenizer.nextToken()));
        }
        int size = vector.size();
        NewsAddress[] newsAddressArr = new NewsAddress[size];
        if (size > 0) {
            vector.copyInto(newsAddressArr);
        }
        return newsAddressArr;
    }

    public static String toString(Address[] addressArr) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(addressArr[0].toString());
        for (int i = 1; i < addressArr.length; i++) {
            stringBuffer.append(",");
            stringBuffer.append(addressArr[i].toString());
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NewsAddress)) {
            return false;
        }
        NewsAddress newsAddress = (NewsAddress) obj;
        if (this.newsgroup.equals(newsAddress.newsgroup)) {
            if (this.host == null && newsAddress.host == null) {
                return true;
            }
            return (this.host == null || newsAddress.host == null || !this.host.equalsIgnoreCase(newsAddress.host)) ? false : true;
        }
    }

    public String getHost() {
        return this.host;
    }

    public String getNewsgroup() {
        return this.newsgroup;
    }

    public String getType() {
        return "news";
    }

    public int hashCode() {
        int i = 0;
        if (this.newsgroup != null) {
            i = 0 + this.newsgroup.hashCode();
        }
        return this.host != null ? i + this.host.toLowerCase(Locale.ENGLISH).hashCode() : i;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setNewsgroup(String str) {
        this.newsgroup = str;
    }

    public String toString() {
        return this.newsgroup;
    }
}
