package com.google.a.d.c;

import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.helper.ItemTouchHelper;

final class b implements g {
    b() {
    }

    private static char a(char c2, int i) {
        int i2 = c2 + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }

    public final int a() {
        return 5;
    }

    public final void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!hVar.b()) {
                break;
            }
            sb.append(hVar.a());
            hVar.f++;
            if (j.a(hVar.f3116a, hVar.f, 5) != 5) {
                hVar.g = 0;
                break;
            }
        }
        int length = sb.length() - 1;
        int length2 = hVar.e.length() + length + 1;
        hVar.a(length2);
        boolean z = hVar.h.f3126b - length2 > 0;
        if (hVar.b() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                sb.insert(1, (char) (length % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length3 = sb.length();
        for (int i = 0; i < length3; i++) {
            int charAt = sb.charAt(i) + (((hVar.e.length() + 1) * 149) % 255) + 1;
            if (charAt > 255) {
                charAt += InputDeviceCompat.SOURCE_ANY;
            }
            hVar.a((char) charAt);
        }
    }
}
