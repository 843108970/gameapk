package mobi.oneway.export.g;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class t {
    public static int a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i += read;
            } else {
                outputStream.flush();
                return i;
            }
        }
    }

    public static List<String> a(InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset().name());
    }

    public static List<String> a(InputStream inputStream, String str) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public static InputStreamReader b(InputStream inputStream, String str) {
        return str == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str);
    }

    public static String c(InputStream inputStream, String str) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(str == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            sb.append(readLine);
        }
    }
}
