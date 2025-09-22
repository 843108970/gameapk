package com.lidroid.xutils.db.sqlite;

import android.text.TextUtils;
import com.cyjh.common.util.s;
import com.lidroid.xutils.db.converter.ColumnConverterFactory;
import com.lidroid.xutils.db.table.ColumnUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WhereBuilder {
    private final List<String> whereItems = new ArrayList();

    private WhereBuilder() {
    }

    private void appendCondition(String str, String str2, String str3, Object obj) {
        Object obj2;
        StringBuilder sb;
        String str4;
        String sb2;
        StringBuilder sb3 = new StringBuilder();
        if (this.whereItems.size() > 0) {
            sb3.append(s.a.f1696a);
        }
        if (!TextUtils.isEmpty(str)) {
            sb3.append(String.valueOf(str) + s.a.f1696a);
        }
        sb3.append(str2);
        if ("!=".equals(str3)) {
            str3 = "<>";
        } else if ("==".equals(str3)) {
            str3 = "=";
        }
        if (obj != null) {
            sb3.append(s.a.f1696a + str3 + s.a.f1696a);
            int i = 0;
            Iterable<Object> iterable = null;
            if ("IN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    iterable = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    ArrayList arrayList = new ArrayList();
                    int length = Array.getLength(obj);
                    while (i < length) {
                        arrayList.add(Array.get(obj, i));
                        i++;
                    }
                    iterable = arrayList;
                }
                if (iterable != null) {
                    StringBuffer stringBuffer = new StringBuffer("(");
                    for (Object convert2DbColumnValueIfNeeded : iterable) {
                        Object convert2DbColumnValueIfNeeded2 = ColumnUtils.convert2DbColumnValueIfNeeded(convert2DbColumnValueIfNeeded);
                        if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(convert2DbColumnValueIfNeeded2.getClass()))) {
                            String obj3 = convert2DbColumnValueIfNeeded2.toString();
                            if (obj3.indexOf(39) != -1) {
                                obj3 = obj3.replace("'", "''");
                            }
                            stringBuffer.append("'" + obj3 + "'");
                        } else {
                            stringBuffer.append(convert2DbColumnValueIfNeeded2);
                        }
                        stringBuffer.append(",");
                    }
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    stringBuffer.append(")");
                    sb2 = stringBuffer.toString();
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else {
                if ("BETWEEN".equalsIgnoreCase(str3)) {
                    if (obj instanceof Iterable) {
                        iterable = (Iterable) obj;
                    } else if (obj.getClass().isArray()) {
                        ArrayList arrayList2 = new ArrayList();
                        int length2 = Array.getLength(obj);
                        while (i < length2) {
                            arrayList2.add(Array.get(obj, i));
                            i++;
                        }
                        iterable = arrayList2;
                    }
                    if (iterable != null) {
                        Iterator it = iterable.iterator();
                        if (!it.hasNext()) {
                            throw new IllegalArgumentException("value must have tow items.");
                        }
                        Object next = it.next();
                        if (!it.hasNext()) {
                            throw new IllegalArgumentException("value must have tow items.");
                        }
                        Object next2 = it.next();
                        Object convert2DbColumnValueIfNeeded3 = ColumnUtils.convert2DbColumnValueIfNeeded(next);
                        obj2 = ColumnUtils.convert2DbColumnValueIfNeeded(next2);
                        if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(convert2DbColumnValueIfNeeded3.getClass()))) {
                            String obj4 = convert2DbColumnValueIfNeeded3.toString();
                            if (obj4.indexOf(39) != -1) {
                                obj4 = obj4.replace("'", "''");
                            }
                            str4 = obj2.toString();
                            if (str4.indexOf(39) != -1) {
                                str4 = str4.replace("'", "''");
                            }
                            sb3.append("'" + obj4 + "'");
                            sb3.append(" AND ");
                            sb = new StringBuilder("'");
                        } else {
                            sb3.append(convert2DbColumnValueIfNeeded3);
                            sb3.append(" AND ");
                            sb3.append(obj2);
                            this.whereItems.add(sb3.toString());
                        }
                    } else {
                        throw new IllegalArgumentException("value must be an Array or an Iterable.");
                    }
                } else {
                    obj2 = ColumnUtils.convert2DbColumnValueIfNeeded(obj);
                    if (ColumnDbType.TEXT.equals(ColumnConverterFactory.getDbColumnType(obj2.getClass()))) {
                        String obj5 = obj2.toString();
                        if (obj5.indexOf(39) != -1) {
                            obj5 = obj5.replace("'", "''");
                        }
                        sb = new StringBuilder("'");
                    }
                    sb3.append(obj2);
                    this.whereItems.add(sb3.toString());
                }
                sb.append(str4);
                sb.append("'");
                sb2 = sb.toString();
            }
        } else if ("=".equals(str3)) {
            sb2 = " IS NULL";
        } else if ("<>".equals(str3)) {
            sb2 = " IS NOT NULL";
        } else {
            sb2 = s.a.f1696a + str3 + " NULL";
        }
        sb3.append(sb2);
        this.whereItems.add(sb3.toString());
    }

    public static WhereBuilder b() {
        return new WhereBuilder();
    }

    public static WhereBuilder b(String str, String str2, Object obj) {
        WhereBuilder whereBuilder = new WhereBuilder();
        whereBuilder.appendCondition((String) null, str, str2, obj);
        return whereBuilder;
    }

    public WhereBuilder and(String str, String str2, Object obj) {
        appendCondition(this.whereItems.size() == 0 ? null : "AND", str, str2, obj);
        return this;
    }

    public WhereBuilder expr(String str) {
        List<String> list = this.whereItems;
        list.add(s.a.f1696a + str);
        return this;
    }

    public WhereBuilder expr(String str, String str2, Object obj) {
        appendCondition((String) null, str, str2, obj);
        return this;
    }

    public int getWhereItemSize() {
        return this.whereItems.size();
    }

    public WhereBuilder or(String str, String str2, Object obj) {
        appendCondition(this.whereItems.size() == 0 ? null : "OR", str, str2, obj);
        return this;
    }

    public String toString() {
        if (this.whereItems.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : this.whereItems) {
            sb.append(append);
        }
        return sb.toString();
    }
}
