package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

class ObjectAnimatorUtils {
    private static final ObjectAnimatorUtilsImpl IMPL = (Build.VERSION.SDK_INT >= 21 ? new ObjectAnimatorUtilsApi21() : new ObjectAnimatorUtilsApi14());

    ObjectAnimatorUtils() {
    }

    static <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
        return IMPL.ofPointF(t, property, path);
    }
}
