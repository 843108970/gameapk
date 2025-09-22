package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build;
import android.widget.ImageView;

class ImageViewUtils {
    private static final ImageViewUtilsImpl IMPL = (Build.VERSION.SDK_INT >= 21 ? new ImageViewUtilsApi21() : new ImageViewUtilsApi14());

    ImageViewUtils() {
    }

    static void animateTransform(ImageView imageView, Matrix matrix) {
        IMPL.animateTransform(imageView, matrix);
    }

    static void reserveEndAnimateTransform(ImageView imageView, Animator animator) {
        IMPL.reserveEndAnimateTransform(imageView, animator);
    }

    static void startAnimateTransform(ImageView imageView) {
        IMPL.startAnimateTransform(imageView);
    }
}
