package android.support.transition;

import android.os.Build;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

class ViewGroupUtils {
    private static final ViewGroupUtilsImpl IMPL = (Build.VERSION.SDK_INT >= 18 ? new ViewGroupUtilsApi18() : new ViewGroupUtilsApi14());

    ViewGroupUtils() {
    }

    static ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return IMPL.getOverlay(viewGroup);
    }

    static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        IMPL.suppressLayout(viewGroup, z);
    }
}
