package mobi.oneway.export.g;

import android.content.SharedPreferences;
import java.util.Map;
import mobi.oneway.export.a.b;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4231a = "OneWay_sp";

    /* renamed from: b  reason: collision with root package name */
    private String f4232b;

    public r(String str) {
        this.f4232b = str;
    }

    public static r a() {
        return a(f4231a);
    }

    public static r a(String str) {
        return new r(str);
    }

    private SharedPreferences d() {
        return b.a().getSharedPreferences(this.f4232b, 0);
    }

    public r a(String str, Object obj) {
        SharedPreferences.Editor edit = d().edit();
        if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else {
            edit.putString(str, String.valueOf(obj));
        }
        edit.apply();
        return this;
    }

    public Object b(String str, Object obj) {
        SharedPreferences d = d();
        if (obj instanceof Boolean) {
            return Boolean.valueOf(d.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(d.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(d.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(d.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return d.getString(str, (String) obj);
        }
        return null;
    }

    public Map<String, ?> b() {
        return d().getAll();
    }

    public r b(String str) {
        d().edit().remove(str).apply();
        return this;
    }

    public r c() {
        d().edit().clear().apply();
        return this;
    }
}
