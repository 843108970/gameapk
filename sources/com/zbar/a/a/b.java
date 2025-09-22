package com.zbar.a.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.regex.Pattern;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final String f3988a = "b";
    private static final int g = 27;
    private static final Pattern h = Pattern.compile(",");

    /* renamed from: b  reason: collision with root package name */
    public final Context f3989b;

    /* renamed from: c  reason: collision with root package name */
    public Point f3990c;
    public Point d;
    public int e;
    public String f;

    b(Context context) {
        this.f3989b = context;
    }

    static int a(CharSequence charSequence, int i) {
        String[] split = h.split(charSequence);
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            try {
                double parseDouble = Double.parseDouble(split[i2].trim());
                int i4 = (int) (10.0d * parseDouble);
                if (Math.abs(((double) i) - parseDouble) < ((double) Math.abs(i - i3))) {
                    i3 = i4;
                }
                i2++;
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i3;
    }

    private Point a() {
        return this.d;
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point point2 = null;
        if (str != null) {
            point2 = a((CharSequence) str, point);
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    static Point a(CharSequence charSequence, Point point) {
        String[] split = h.split(charSequence);
        int length = split.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        while (true) {
            if (i >= length) {
                break;
            }
            String trim = split[i].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf >= 0) {
                try {
                    int parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - point.x) + Math.abs(parseInt2 - point.y);
                    if (abs == 0) {
                        i3 = parseInt2;
                        i2 = parseInt;
                        break;
                    } else if (abs < i4) {
                        i3 = parseInt2;
                        i4 = abs;
                        i2 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    continue;
                }
            }
            i++;
        }
        if (i2 <= 0 || i3 <= 0) {
            return null;
        }
        return new Point(i2, i3);
    }

    public static void a(Camera.Parameters parameters) {
        int i;
        String str;
        if (!Build.MODEL.contains("Behold II") || c.f3991a != 3) {
            str = "flash-value";
            i = 2;
        } else {
            str = "flash-value";
            i = 1;
        }
        parameters.set(str, i);
        parameters.set("flash-mode", "off");
    }

    private void a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.e = parameters.getPreviewFormat();
        this.f = parameters.get("preview-format");
        Display defaultDisplay = ((WindowManager) this.f3989b.getSystemService("window")).getDefaultDisplay();
        this.f3990c = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Point point = new Point();
        point.x = this.f3990c.x;
        point.y = this.f3990c.y;
        if (this.f3990c.x < this.f3990c.y) {
            point.x = this.f3990c.y;
            point.y = this.f3990c.x;
        }
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point point2 = null;
        if (str != null) {
            point2 = a((CharSequence) str, point);
        }
        if (point2 == null) {
            point2 = new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        this.d = point2;
    }

    private Point b() {
        return this.f3990c;
    }

    public static void b(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            String str2 = parameters.get("max-zoom");
            int i = 27;
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    String str3 = f3988a;
                    Log.w(str3, "Bad max-zoom: " + str2);
                }
            }
            String str4 = parameters.get("taking-picture-zoom-max");
            if (str4 != null) {
                try {
                    int parseInt = Integer.parseInt(str4);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    String str5 = f3988a;
                    Log.w(str5, "Bad taking-picture-zoom-max: " + str4);
                }
            }
            String str6 = parameters.get("mot-zoom-values");
            if (str6 != null) {
                i = a((CharSequence) str6, i);
            }
            String str7 = parameters.get("mot-zoom-step");
            if (str7 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str7.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (!(str2 == null && str6 == null)) {
                parameters.set("zoom", String.valueOf(((double) i) / 10.0d));
            }
            if (str4 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }

    private void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(this.d.x, this.d.y);
        if (!Build.MODEL.contains("Behold II") || c.f3991a != 3) {
            parameters.set("flash-value", 2);
        } else {
            parameters.set("flash-value", 1);
        }
        parameters.set("flash-mode", "off");
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            String str2 = parameters.get("max-zoom");
            int i = 27;
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    String str3 = f3988a;
                    Log.w(str3, "Bad max-zoom: " + str2);
                }
            }
            String str4 = parameters.get("taking-picture-zoom-max");
            if (str4 != null) {
                try {
                    int parseInt = Integer.parseInt(str4);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    String str5 = f3988a;
                    Log.w(str5, "Bad taking-picture-zoom-max: " + str4);
                }
            }
            String str6 = parameters.get("mot-zoom-values");
            if (str6 != null) {
                i = a((CharSequence) str6, i);
            }
            String str7 = parameters.get("mot-zoom-step");
            if (str7 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str7.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (!(str2 == null && str6 == null)) {
                parameters.set("zoom", String.valueOf(((double) i) / 10.0d));
            }
            if (str4 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    private int c() {
        return this.e;
    }

    private String d() {
        return this.f;
    }
}
