package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

public final class BitmapCompat {
    static final BitmapCompatBaseImpl IMPL = (Build.VERSION.SDK_INT >= 19 ? new BitmapCompatApi19Impl() : Build.VERSION.SDK_INT >= 18 ? new BitmapCompatApi18Impl() : new BitmapCompatBaseImpl());

    @RequiresApi(18)
    static class BitmapCompatApi18Impl extends BitmapCompatBaseImpl {
        BitmapCompatApi18Impl() {
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
            bitmap.setHasMipMap(z);
        }
    }

    @RequiresApi(19)
    static class BitmapCompatApi19Impl extends BitmapCompatApi18Impl {
        BitmapCompatApi19Impl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static class BitmapCompatBaseImpl {
        BitmapCompatBaseImpl() {
        }

        public int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getByteCount();
        }

        public boolean hasMipMap(Bitmap bitmap) {
            return false;
        }

        public void setHasMipMap(Bitmap bitmap, boolean z) {
        }
    }

    private BitmapCompat() {
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return IMPL.getAllocationByteCount(bitmap);
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return IMPL.hasMipMap(bitmap);
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z) {
        IMPL.setHasMipMap(bitmap, z);
    }
}
