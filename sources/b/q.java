package b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f339a = new q() {
        public final List<InetAddress> a(String str) throws UnknownHostException {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    };

    List<InetAddress> a(String str) throws UnknownHostException;
}
