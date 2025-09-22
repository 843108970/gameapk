package com.cyjh.common.util.toast;

import android.content.res.Resources;
import com.cyjh.elfin.a.b;

public final class d {
    private static int a() {
        Resources resources = q.a().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", b.f1842b));
    }

    private static int b() {
        Resources resources = q.a().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", b.f1842b);
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
