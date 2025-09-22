package mobi.oneway.export.g;

import java.io.PrintWriter;
import java.io.StringWriter;

public class g {
    public static String a(Exception exc) {
        return exc.getMessage();
    }

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
        }
    }
}
