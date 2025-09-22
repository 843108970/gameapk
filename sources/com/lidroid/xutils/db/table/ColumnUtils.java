package com.lidroid.xutils.db.table;

import android.text.TextUtils;
import com.lidroid.xutils.db.annotation.Check;
import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Finder;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NotNull;
import com.lidroid.xutils.db.annotation.Transient;
import com.lidroid.xutils.db.annotation.Unique;
import com.lidroid.xutils.db.sqlite.FinderLazyLoader;
import com.lidroid.xutils.db.sqlite.ForeignLazyLoader;
import com.lidroid.xutils.util.LogUtils;
import com.umeng.commonsdk.proguard.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;

public class ColumnUtils {
    private static final HashSet<String> DB_PRIMITIVE_TYPES;

    static {
        HashSet<String> hashSet = new HashSet<>(14);
        DB_PRIMITIVE_TYPES = hashSet;
        hashSet.add(Integer.TYPE.getName());
        DB_PRIMITIVE_TYPES.add(Long.TYPE.getName());
        DB_PRIMITIVE_TYPES.add(Short.TYPE.getName());
        DB_PRIMITIVE_TYPES.add(Byte.TYPE.getName());
        DB_PRIMITIVE_TYPES.add(Float.TYPE.getName());
        DB_PRIMITIVE_TYPES.add(Double.TYPE.getName());
        DB_PRIMITIVE_TYPES.add(Integer.class.getName());
        DB_PRIMITIVE_TYPES.add(Long.class.getName());
        DB_PRIMITIVE_TYPES.add(Short.class.getName());
        DB_PRIMITIVE_TYPES.add(Byte.class.getName());
        DB_PRIMITIVE_TYPES.add(Float.class.getName());
        DB_PRIMITIVE_TYPES.add(Double.class.getName());
        DB_PRIMITIVE_TYPES.add(String.class.getName());
        DB_PRIMITIVE_TYPES.add(byte[].class.getName());
    }

    private ColumnUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r0 = com.lidroid.xutils.db.converter.ColumnConverterFactory.getColumnConverter(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object convert2DbColumnValueIfNeeded(java.lang.Object r2) {
        /*
            if (r2 == 0) goto L_0x0016
            java.lang.Class r0 = r2.getClass()
            boolean r1 = isDbPrimitiveType(r0)
            if (r1 != 0) goto L_0x0016
            com.lidroid.xutils.db.converter.ColumnConverter r0 = com.lidroid.xutils.db.converter.ColumnConverterFactory.getColumnConverter(r0)
            if (r0 == 0) goto L_0x0016
            java.lang.Object r2 = r0.fieldValue2ColumnValue(r2)
        L_0x0016:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.db.table.ColumnUtils.convert2DbColumnValueIfNeeded(java.lang.Object):java.lang.Object");
    }

    private static Method getBooleanColumnGetMethod(Class<?> cls, String str) {
        String str2 = v.Y + str.substring(0, 1).toUpperCase() + str.substring(1);
        if (!isStartWithIs(str)) {
            str = str2;
        }
        try {
            return cls.getDeclaredMethod(str, new Class[0]);
        } catch (NoSuchMethodException unused) {
            LogUtils.d(String.valueOf(str) + " not exist");
            return null;
        }
    }

    private static Method getBooleanColumnSetMethod(Class<?> cls, Field field) {
        StringBuilder sb;
        String substring;
        String name = field.getName();
        if (isStartWithIs(field.getName())) {
            sb = new StringBuilder("set");
            sb.append(name.substring(2, 3).toUpperCase());
            substring = name.substring(3);
        } else {
            sb = new StringBuilder("set");
            sb.append(name.substring(0, 1).toUpperCase());
            substring = name.substring(1);
        }
        sb.append(substring);
        String sb2 = sb.toString();
        try {
            return cls.getDeclaredMethod(sb2, new Class[]{field.getType()});
        } catch (NoSuchMethodException unused) {
            LogUtils.d(String.valueOf(sb2) + " not exist");
            return null;
        }
    }

    public static String getCheck(Field field) {
        Check check = (Check) field.getAnnotation(Check.class);
        if (check != null) {
            return check.value();
        }
        return null;
    }

    public static String getColumnDefaultValue(Field field) {
        Column column = (Column) field.getAnnotation(Column.class);
        if (column == null || TextUtils.isEmpty(column.defaultValue())) {
            return null;
        }
        return column.defaultValue();
    }

    public static Method getColumnGetMethod(Class<?> cls, Field field) {
        Method method;
        while (true) {
            String name = field.getName();
            method = null;
            Class<? super Object> cls2 = cls;
            if (field.getType() == Boolean.TYPE) {
                method = getBooleanColumnGetMethod(cls2, name);
            }
            if (method == null) {
                String str = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
                try {
                    method = cls2.getDeclaredMethod(str, new Class[0]);
                } catch (NoSuchMethodException unused) {
                    LogUtils.d(String.valueOf(str) + " not exist");
                }
            }
            if (method != null || Object.class.equals(cls2.getSuperclass())) {
                return method;
            }
            cls2 = cls2.getSuperclass();
        }
        return method;
    }

    public static String getColumnNameByField(Field field) {
        Column column = (Column) field.getAnnotation(Column.class);
        if (column != null && !TextUtils.isEmpty(column.column())) {
            return column.column();
        }
        Id id = (Id) field.getAnnotation(Id.class);
        if (id != null && !TextUtils.isEmpty(id.column())) {
            return id.column();
        }
        Foreign foreign = (Foreign) field.getAnnotation(Foreign.class);
        return (foreign == null || TextUtils.isEmpty(foreign.column())) ? ((Finder) field.getAnnotation(Finder.class)) != null ? field.getName() : field.getName() : foreign.column();
    }

    public static Method getColumnSetMethod(Class<?> cls, Field field) {
        Method method;
        while (true) {
            String name = field.getName();
            method = null;
            Class<? super Object> cls2 = cls;
            if (field.getType() == Boolean.TYPE) {
                method = getBooleanColumnSetMethod(cls2, field);
            }
            if (method == null) {
                String str = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                try {
                    method = cls2.getDeclaredMethod(str, new Class[]{field.getType()});
                } catch (NoSuchMethodException unused) {
                    LogUtils.d(String.valueOf(str) + " not exist");
                }
            }
            if (method != null || Object.class.equals(cls2.getSuperclass())) {
                return method;
            }
            cls2 = cls2.getSuperclass();
        }
        return method;
    }

    public static Class<?> getFinderTargetEntityType(Finder finder) {
        Class<?> type = finder.getColumnField().getType();
        return (type.equals(FinderLazyLoader.class) || type.equals(List.class)) ? (Class) ((ParameterizedType) finder.getColumnField().getGenericType()).getActualTypeArguments()[0] : type;
    }

    public static String getForeignColumnNameByField(Field field) {
        Foreign foreign = (Foreign) field.getAnnotation(Foreign.class);
        return foreign != null ? foreign.foreign() : field.getName();
    }

    public static Class<?> getForeignEntityType(Foreign foreign) {
        Class<?> type = foreign.getColumnField().getType();
        return (type.equals(ForeignLazyLoader.class) || type.equals(List.class)) ? (Class) ((ParameterizedType) foreign.getColumnField().getGenericType()).getActualTypeArguments()[0] : type;
    }

    public static boolean isDbPrimitiveType(Class<?> cls) {
        return DB_PRIMITIVE_TYPES.contains(cls.getName());
    }

    public static boolean isFinder(Field field) {
        return field.getAnnotation(Finder.class) != null;
    }

    public static boolean isForeign(Field field) {
        return field.getAnnotation(Foreign.class) != null;
    }

    public static boolean isNotNull(Field field) {
        return field.getAnnotation(NotNull.class) != null;
    }

    private static boolean isStartWithIs(String str) {
        return str != null && str.startsWith(v.Y);
    }

    public static boolean isTransient(Field field) {
        return field.getAnnotation(Transient.class) != null;
    }

    public static boolean isUnique(Field field) {
        return field.getAnnotation(Unique.class) != null;
    }
}
