package b;

import c.f;
import com.lidroid.xutils.util.CharsetUtils;
import java.nio.charset.Charset;

public final class o {
    private o() {
    }

    private static String a(String str, String str2) {
        Charset forName = Charset.forName(CharsetUtils.DEFAULT_ENCODING_CHARSET);
        String base64 = f.of((str + ":" + str2).getBytes(forName)).base64();
        return "Basic " + base64;
    }

    private static String a(String str, String str2, Charset charset) {
        String base64 = f.of((str + ":" + str2).getBytes(charset)).base64();
        return "Basic " + base64;
    }
}
