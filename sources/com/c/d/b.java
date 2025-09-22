package com.c.d;

import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class b extends LinkedHashMap<String, Bitmap> {
    private static final long serialVersionUID = 1;
    private int maxCount;
    private int maxPixels;
    private int maxTotalPixels;
    private int pixels;

    public b(int i, int i2, int i3) {
        super(8, 0.75f, true);
        this.maxCount = i;
        this.maxPixels = i2;
        this.maxTotalPixels = i3;
    }

    private int pixels(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth() * bitmap.getHeight();
    }

    private void shrink() {
        if (this.pixels > this.maxTotalPixels) {
            Iterator it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
                if (this.pixels <= this.maxTotalPixels) {
                    return;
                }
            }
        }
    }

    public final void clear() {
        super.clear();
        this.pixels = 0;
    }

    public final Bitmap put(String str, Bitmap bitmap) {
        int pixels2 = pixels(bitmap);
        if (pixels2 > this.maxPixels) {
            return null;
        }
        this.pixels += pixels2;
        Bitmap bitmap2 = (Bitmap) super.put(str, bitmap);
        if (bitmap2 == null) {
            return bitmap2;
        }
        this.pixels -= pixels(bitmap2);
        return bitmap2;
    }

    public final Bitmap remove(Object obj) {
        Bitmap bitmap = (Bitmap) super.remove(obj);
        if (bitmap != null) {
            this.pixels -= pixels(bitmap);
        }
        return bitmap;
    }

    public final boolean removeEldestEntry(Map.Entry<String, Bitmap> entry) {
        if (this.pixels > this.maxTotalPixels || size() > this.maxCount) {
            remove((Object) entry.getKey());
        }
        shrink();
        return false;
    }
}
