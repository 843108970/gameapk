package com.cyjh.elfin.sweepcode;

import android.hardware.Camera;
import android.util.Log;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2088b = "yanzi";

    /* renamed from: c  reason: collision with root package name */
    private static a f2089c;

    /* renamed from: a  reason: collision with root package name */
    C0031a f2090a = new C0031a();

    /* renamed from: com.cyjh.elfin.sweepcode.a$a  reason: collision with other inner class name */
    public class C0031a implements Comparator<Camera.Size> {
        public C0031a() {
        }

        private static int a(Camera.Size size, Camera.Size size2) {
            if (size.width == size2.width) {
                return 0;
            }
            return size.width < size2.width ? 1 : -1;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            Camera.Size size = (Camera.Size) obj;
            Camera.Size size2 = (Camera.Size) obj2;
            if (size.width == size2.width) {
                return 0;
            }
            return size.width < size2.width ? 1 : -1;
        }
    }

    private a() {
    }

    private Camera.Size a(List<Camera.Size> list, float f, int i) {
        Collections.sort(list, this.f2090a);
        Iterator<Camera.Size> it = list.iterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            Log.i(f2088b, "ratioPreview:" + (((float) next.width) / ((float) next.height)));
            Log.i(f2088b, "PreviewSize:w = " + next.width + "h = " + next.height);
            if (next.height >= i && a(next, f)) {
                Log.i(f2088b, "ratioPreview2:" + f + "   minH:" + i);
                Log.i(f2088b, "PreviewSize:w = " + next.width + "h = " + next.height);
                break;
            }
            i3++;
        }
        if (i3 != list.size()) {
            i2 = i3;
        }
        return list.get(i2);
    }

    public static a a() {
        if (f2089c != null) {
            return f2089c;
        }
        a aVar = new a();
        f2089c = aVar;
        return aVar;
    }

    public static void a(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        for (int i = 0; i < supportedPreviewSizes.size(); i++) {
            supportedPreviewSizes.get(i);
        }
    }

    public static boolean a(Camera.Size size, float f) {
        float f2 = ((float) size.width) / ((float) size.height);
        PrintStream printStream = System.out;
        printStream.println("r:" + f2);
        PrintStream printStream2 = System.out;
        StringBuilder sb = new StringBuilder("r2:");
        float f3 = f2 - f;
        sb.append(Math.abs(f3));
        printStream2.println(sb.toString());
        return ((double) Math.abs(f3)) <= 0.2d;
    }

    private Camera.Size b(List<Camera.Size> list, float f, int i) {
        Collections.sort(list, this.f2090a);
        Iterator<Camera.Size> it = list.iterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width >= i && a(next, f)) {
                Log.i(f2088b, "PictureSize : w = " + next.width + "h = " + next.height);
                break;
            }
            i3++;
        }
        if (i3 != list.size()) {
            i2 = i3;
        }
        return list.get(i2);
    }

    public static void b(Camera.Parameters parameters) {
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        for (int i = 0; i < supportedPictureSizes.size(); i++) {
            Camera.Size size = supportedPictureSizes.get(i);
            Log.i(f2088b, "pictureSizes:width = " + size.width + " height = " + size.height);
        }
    }

    private static void c(Camera.Parameters parameters) {
        for (String str : parameters.getSupportedFocusModes()) {
            Log.i(f2088b, "focusModes--" + str);
        }
    }
}
