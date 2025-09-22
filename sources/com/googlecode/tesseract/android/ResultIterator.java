package com.googlecode.tesseract.android;

import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class ResultIterator extends PageIterator {

    /* renamed from: a  reason: collision with root package name */
    private final long f3401a;

    static {
        System.loadLibrary("jpgt");
        System.loadLibrary("pngt");
        System.loadLibrary("lept");
        System.loadLibrary("tess");
    }

    ResultIterator(long j) {
        super(j);
        this.f3401a = j;
    }

    private String a(int i) {
        return nativeGetUTF8Text(this.f3401a, i);
    }

    private List<Pair<String, Double>> a() {
        String str;
        String[] nativeGetSymbolChoices = nativeGetSymbolChoices(this.f3401a);
        ArrayList arrayList = new ArrayList();
        for (String str2 : nativeGetSymbolChoices) {
            int lastIndexOf = str2.lastIndexOf(124);
            Double valueOf = Double.valueOf(0.0d);
            if (lastIndexOf > 0) {
                str = str2.substring(0, lastIndexOf);
                try {
                    valueOf = Double.valueOf(Double.parseDouble(str2.substring(lastIndexOf + 1)));
                } catch (NumberFormatException unused) {
                    Log.e("ResultIterator", "Invalid confidence level for " + str2);
                }
            } else {
                str = str2;
            }
            arrayList.add(new Pair(str, valueOf));
        }
        return arrayList;
    }

    private boolean a(int i, int i2) {
        return nativeIsAtFinalElement(this.f3401a, i, i2);
    }

    private float b(int i) {
        return nativeConfidence(this.f3401a, i);
    }

    private void b() {
        nativeDelete(this.f3401a);
    }

    private boolean c(int i) {
        return nativeIsAtBeginningOf(this.f3401a, i);
    }

    private static native float nativeConfidence(long j, int i);

    private static native void nativeDelete(long j);

    private static native String[] nativeGetSymbolChoices(long j);

    private static native String nativeGetUTF8Text(long j, int i);

    private static native boolean nativeIsAtBeginningOf(long j, int i);

    private static native boolean nativeIsAtFinalElement(long j, int i, int i2);
}
