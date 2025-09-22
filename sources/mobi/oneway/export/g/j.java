package mobi.oneway.export.g;

import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;

public class j {
    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable a2 : closeableArr) {
                a(a2);
            }
        }
    }
}
