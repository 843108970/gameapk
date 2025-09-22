package org.litepal.g;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.grandcentrix.tray.provider.TrayContract;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4840a = "DBUtility";

    /* renamed from: b  reason: collision with root package name */
    private static final String f4841b = ",abort,add,after,all,alter,and,as,asc,autoincrement,before,begin,between,by,cascade,check,collate,column,commit,conflict,constraint,create,cross,database,deferrable,deferred,delete,desc,distinct,drop,each,end,escape,except,exclusive,exists,foreign,from,glob,group,having,in,index,inner,insert,intersect,into,is,isnull,join,like,limit,match,natural,not,notnull,null,of,offset,on,or,order,outer,plan,pragma,primary,query,raise,references,regexp,reindex,release,rename,replace,restrict,right,rollback,row,savepoint,select,set,table,temp,temporary,then,to,transaction,trigger,union,unique,update,using,vacuum,values,view,virtual,when,where,";

    /* renamed from: c  reason: collision with root package name */
    private static final String f4842c = "_lpcolumn";
    private static final String d = "\\s*(=|!=|<>|<|>)";
    private static final String e = "\\s+(not\\s+)?(like|between)\\s+";
    private static final String f = "\\s+(not\\s+)?(in)\\s*\\(";

    private c() {
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || '.' == str.charAt(str.length() - 1)) {
            return null;
        }
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static String a(String str, String str2) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.toLowerCase(Locale.US).compareTo(str2.toLowerCase(Locale.US)) <= 0) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(str2);
        } else {
            sb = new StringBuilder();
            sb.append(str2);
            sb.append("_");
            sb.append(str);
        }
        return sb.toString();
    }

    public static String a(Field field) {
        return a.a(field.getName() + TrayContract.Preferences.Columns.ID);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> a(android.database.sqlite.SQLiteDatabase r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "select * from sqlite_master where type = ?"
            java.lang.String r3 = "table"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x003f }
            android.database.Cursor r4 = r4.rawQuery(r2, r3)     // Catch:{ Exception -> 0x003f }
            boolean r1 = r4.moveToFirst()     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            if (r1 == 0) goto L_0x0031
        L_0x0018:
            java.lang.String r1 = "tbl_name"
            int r1 = r4.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            java.lang.String r1 = r4.getString(r1)     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            boolean r2 = r0.contains(r1)     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            if (r2 != 0) goto L_0x002b
            r0.add(r1)     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
        L_0x002b:
            boolean r1 = r4.moveToNext()     // Catch:{ Exception -> 0x003a, all -> 0x0037 }
            if (r1 != 0) goto L_0x0018
        L_0x0031:
            if (r4 == 0) goto L_0x0036
            r4.close()
        L_0x0036:
            return r0
        L_0x0037:
            r0 = move-exception
            r1 = r4
            goto L_0x004d
        L_0x003a:
            r0 = move-exception
            r1 = r4
            goto L_0x0040
        L_0x003d:
            r0 = move-exception
            goto L_0x004d
        L_0x003f:
            r0 = move-exception
        L_0x0040:
            r0.printStackTrace()     // Catch:{ all -> 0x003d }
            org.litepal.c.b r4 = new org.litepal.c.b     // Catch:{ all -> 0x003d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x003d }
            r4.<init>(r0)     // Catch:{ all -> 0x003d }
            throw r4     // Catch:{ all -> 0x003d }
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()
        L_0x0052:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.g.c.a(android.database.sqlite.SQLiteDatabase):java.util.List");
    }

    private static List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (String a2 : list) {
                arrayList.add(a(a2));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x0069
            java.lang.String r0 = "[0-9a-zA-Z]+_[0-9a-zA-Z]+"
            boolean r0 = r9.matches(r0)
            if (r0 == 0) goto L_0x0069
            r0 = 0
            java.lang.String r2 = "table_schema"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0059 }
            boolean r0 = r10.moveToFirst()     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
            if (r0 == 0) goto L_0x004b
        L_0x0022:
            java.lang.String r0 = "name"
            int r0 = r10.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
            if (r0 == 0) goto L_0x0045
            java.lang.String r9 = "type"
            int r9 = r10.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
            int r9 = r10.getInt(r9)     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
            r0 = 1
            if (r9 != r0) goto L_0x004b
            if (r10 == 0) goto L_0x0044
            r10.close()
        L_0x0044:
            return r0
        L_0x0045:
            boolean r0 = r10.moveToNext()     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
            if (r0 != 0) goto L_0x0022
        L_0x004b:
            if (r10 == 0) goto L_0x0069
            r10.close()
            goto L_0x0069
        L_0x0051:
            r9 = move-exception
            goto L_0x0063
        L_0x0053:
            r9 = move-exception
            r0 = r10
            goto L_0x005a
        L_0x0056:
            r9 = move-exception
            r10 = r0
            goto L_0x0063
        L_0x0059:
            r9 = move-exception
        L_0x005a:
            r9.printStackTrace()     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0069
            r0.close()
            goto L_0x0069
        L_0x0063:
            if (r10 == 0) goto L_0x0068
            r10.close()
        L_0x0068:
            throw r9
        L_0x0069:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.g.c.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r4, java.lang.String r5, android.database.sqlite.SQLiteDatabase r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 != 0) goto L_0x0062
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0052 }
            java.lang.String r3 = "pragma table_info("
            r2.<init>(r3)     // Catch:{ Exception -> 0x0052 }
            r2.append(r5)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = ")"
            r2.append(r5)     // Catch:{ Exception -> 0x0052 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x0052 }
            android.database.Cursor r5 = r6.rawQuery(r5, r0)     // Catch:{ Exception -> 0x0052 }
            boolean r6 = r5.moveToFirst()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r6 == 0) goto L_0x0044
        L_0x002c:
            java.lang.String r6 = "name"
            int r6 = r5.getColumnIndexOrThrow(r6)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            java.lang.String r6 = r5.getString(r6)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            boolean r6 = r4.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r6 == 0) goto L_0x003e
            r1 = 1
            goto L_0x0044
        L_0x003e:
            boolean r6 = r5.moveToNext()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r6 != 0) goto L_0x002c
        L_0x0044:
            if (r5 == 0) goto L_0x005b
            r5.close()
            return r1
        L_0x004a:
            r4 = move-exception
            r0 = r5
            goto L_0x005c
        L_0x004d:
            r4 = move-exception
            r0 = r5
            goto L_0x0053
        L_0x0050:
            r4 = move-exception
            goto L_0x005c
        L_0x0052:
            r4 = move-exception
        L_0x0053:
            r4.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x005b
            r0.close()
        L_0x005b:
            return r1
        L_0x005c:
            if (r0 == 0) goto L_0x0061
            r0.close()
        L_0x0061:
            throw r4
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.g.c.a(java.lang.String, java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static String[] a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = d(strArr[i]);
        }
        return strArr2;
    }

    public static String b(String str) {
        return a.a(a(str) + TrayContract.Preferences.Columns.ID);
    }

    public static String b(String str, String str2) {
        String a2 = a(str);
        return a.a(a2 + "_" + str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.String r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x006a
            java.lang.String r0 = "[0-9a-zA-Z]+_[0-9a-zA-Z]+"
            boolean r0 = r9.matches(r0)
            if (r0 == 0) goto L_0x006a
            r0 = 0
            java.lang.String r2 = "table_schema"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005a }
            boolean r0 = r10.moveToFirst()     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            if (r0 == 0) goto L_0x004c
        L_0x0022:
            java.lang.String r0 = "name"
            int r0 = r10.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            if (r0 == 0) goto L_0x0046
            java.lang.String r9 = "type"
            int r9 = r10.getColumnIndexOrThrow(r9)     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            int r9 = r10.getInt(r9)     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            r0 = 2
            if (r9 != r0) goto L_0x004c
            if (r10 == 0) goto L_0x0044
            r10.close()
        L_0x0044:
            r9 = 1
            return r9
        L_0x0046:
            boolean r0 = r10.moveToNext()     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            if (r0 != 0) goto L_0x0022
        L_0x004c:
            if (r10 == 0) goto L_0x006a
            r10.close()
            goto L_0x006a
        L_0x0052:
            r9 = move-exception
            goto L_0x0064
        L_0x0054:
            r9 = move-exception
            r0 = r10
            goto L_0x005b
        L_0x0057:
            r9 = move-exception
            r10 = r0
            goto L_0x0064
        L_0x005a:
            r9 = move-exception
        L_0x005b:
            r9.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r0 == 0) goto L_0x006a
            r0.close()
            goto L_0x006a
        L_0x0064:
            if (r10 == 0) goto L_0x0069
            r10.close()
        L_0x0069:
            throw r9
        L_0x006a:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.g.c.b(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder(",");
        sb.append(str.toLowerCase(Locale.US));
        sb.append(",");
        return f4841b.contains(sb.toString());
    }

    public static boolean c(String str, SQLiteDatabase sQLiteDatabase) {
        try {
            return a.a((Collection<String>) a(sQLiteDatabase), str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String d(String str) {
        if (!c(str)) {
            return str;
        }
        return str + f4842c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.litepal.f.b.d d(java.lang.String r7, android.database.sqlite.SQLiteDatabase r8) {
        /*
            boolean r0 = c(r7, r8)
            if (r0 == 0) goto L_0x00a8
            java.util.List r0 = e(r7, r8)
            org.litepal.f.b.d r1 = new org.litepal.f.b.d
            r1.<init>()
            r1.f4821a = r7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "pragma table_info("
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r7 = ")"
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r2 = 0
            android.database.Cursor r7 = r8.rawQuery(r7, r2)     // Catch:{ Exception -> 0x0094 }
            boolean r8 = r7.moveToFirst()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            if (r8 == 0) goto L_0x0086
        L_0x002f:
            org.litepal.f.b.b r8 = new org.litepal.f.b.b     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            r8.<init>()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            java.lang.String r2 = "name"
            int r2 = r7.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            java.lang.String r3 = "type"
            int r3 = r7.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            java.lang.String r3 = r7.getString(r3)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            java.lang.String r4 = "notnull"
            int r4 = r7.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            int r4 = r7.getInt(r4)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            r5 = 1
            if (r4 == r5) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r5 = 0
        L_0x0057:
            boolean r4 = r0.contains(r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            java.lang.String r6 = "dflt_value"
            int r6 = r7.getColumnIndexOrThrow(r6)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            java.lang.String r6 = r7.getString(r6)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            r8.f4815a = r2     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            r8.f4816b = r3     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            r8.f4817c = r5     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            r8.d = r4     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            if (r6 == 0) goto L_0x0078
            java.lang.String r2 = "'"
            java.lang.String r3 = ""
            java.lang.String r2 = r6.replace(r2, r3)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            goto L_0x007a
        L_0x0078:
            java.lang.String r2 = ""
        L_0x007a:
            r8.a((java.lang.String) r2)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            r1.a((org.litepal.f.b.b) r8)     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            boolean r8 = r7.moveToNext()     // Catch:{ Exception -> 0x008e, all -> 0x008c }
            if (r8 != 0) goto L_0x002f
        L_0x0086:
            if (r7 == 0) goto L_0x008b
            r7.close()
        L_0x008b:
            return r1
        L_0x008c:
            r8 = move-exception
            goto L_0x00a2
        L_0x008e:
            r8 = move-exception
            r2 = r7
            goto L_0x0095
        L_0x0091:
            r8 = move-exception
            r7 = r2
            goto L_0x00a2
        L_0x0094:
            r8 = move-exception
        L_0x0095:
            r8.printStackTrace()     // Catch:{ all -> 0x0091 }
            org.litepal.c.b r7 = new org.litepal.c.b     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0091 }
            r7.<init>(r8)     // Catch:{ all -> 0x0091 }
            throw r7     // Catch:{ all -> 0x0091 }
        L_0x00a2:
            if (r7 == 0) goto L_0x00a7
            r7.close()
        L_0x00a7:
            throw r8
        L_0x00a8:
            org.litepal.c.b r8 = new org.litepal.c.b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Table doesn't exist when executing "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.g.c.d(java.lang.String, android.database.sqlite.SQLiteDatabase):org.litepal.f.b.d");
    }

    public static String e(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("(\\w+\\s*(=|!=|<>|<|>)|\\w+\\s+(not\\s+)?(like|between)\\s+|\\w+\\s+(not\\s+)?(in)\\s*\\()").matcher(str);
                while (matcher.find()) {
                    String group = matcher.group();
                    String replaceAll = group.replaceAll("(\\s*(=|!=|<>|<|>)|\\s+(not\\s+)?(like|between)\\s+|\\s+(not\\s+)?(in)\\s*\\()", "");
                    String replace = group.replace(replaceAll, "");
                    String d2 = d(replaceAll);
                    matcher.appendReplacement(stringBuffer, d2 + replace);
                }
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> e(java.lang.String r6, android.database.sqlite.SQLiteDatabase r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String r3 = "pragma index_list("
            r2.<init>(r3)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            r2.append(r6)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String r6 = ")"
            r2.append(r6)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            android.database.Cursor r6 = r7.rawQuery(r6, r1)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            boolean r2 = r6.moveToFirst()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r2 == 0) goto L_0x007a
            r2 = r1
        L_0x0024:
            java.lang.String r3 = "unique"
            int r3 = r6.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            int r3 = r6.getInt(r3)     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            r4 = 1
            if (r3 != r4) goto L_0x006e
            java.lang.String r3 = "name"
            int r3 = r6.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            java.lang.String r3 = r6.getString(r3)     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            java.lang.String r5 = "pragma index_info("
            r4.<init>(r5)     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            r4.append(r3)     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            java.lang.String r3 = ")"
            r4.append(r3)     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            android.database.Cursor r3 = r7.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            boolean r2 = r3.moveToFirst()     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            if (r2 == 0) goto L_0x0065
            java.lang.String r2 = "name"
            int r2 = r3.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            r0.add(r2)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
        L_0x0065:
            r2 = r3
            goto L_0x006e
        L_0x0067:
            r7 = move-exception
            r2 = r3
            goto L_0x00a1
        L_0x006a:
            r7 = move-exception
            r1 = r6
            r2 = r3
            goto L_0x0092
        L_0x006e:
            boolean r3 = r6.moveToNext()     // Catch:{ Exception -> 0x0078, all -> 0x0076 }
            if (r3 != 0) goto L_0x0024
            r1 = r2
            goto L_0x007a
        L_0x0076:
            r7 = move-exception
            goto L_0x00a1
        L_0x0078:
            r7 = move-exception
            goto L_0x008a
        L_0x007a:
            if (r6 == 0) goto L_0x007f
            r6.close()
        L_0x007f:
            if (r1 == 0) goto L_0x0084
            r1.close()
        L_0x0084:
            return r0
        L_0x0085:
            r7 = move-exception
            r2 = r1
            goto L_0x00a1
        L_0x0088:
            r7 = move-exception
            r2 = r1
        L_0x008a:
            r1 = r6
            goto L_0x0092
        L_0x008c:
            r7 = move-exception
            r6 = r1
            r2 = r6
            goto L_0x00a1
        L_0x0090:
            r7 = move-exception
            r2 = r1
        L_0x0092:
            r7.printStackTrace()     // Catch:{ all -> 0x009f }
            org.litepal.c.b r6 = new org.litepal.c.b     // Catch:{ all -> 0x009f }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x009f }
            r6.<init>(r7)     // Catch:{ all -> 0x009f }
            throw r6     // Catch:{ all -> 0x009f }
        L_0x009f:
            r7 = move-exception
            r6 = r1
        L_0x00a1:
            if (r6 == 0) goto L_0x00a6
            r6.close()
        L_0x00a6:
            if (r2 == 0) goto L_0x00ab
            r2.close()
        L_0x00ab:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.g.c.e(java.lang.String, android.database.sqlite.SQLiteDatabase):java.util.List");
    }

    public static String f(String str) {
        String str2;
        if (str.endsWith("asc")) {
            str = str.replace("asc", "").trim();
            str2 = " asc";
        } else if (str.endsWith("desc")) {
            str = str.replace("desc", "").trim();
            str2 = " desc";
        } else {
            str2 = "";
        }
        return d(str) + str2;
    }

    private static String g(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.US).endsWith(TrayContract.Preferences.Columns.ID)) {
            return null;
        }
        return str.substring(0, str.length() - 3);
    }

    private static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.trim().toLowerCase(Locale.US);
        if (!lowerCase.contains(",")) {
            return f(lowerCase);
        }
        String[] split = lowerCase.split(",");
        StringBuilder sb = new StringBuilder();
        int length = split.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            String str2 = split[i];
            if (z) {
                sb.append(",");
            }
            sb.append(f(str2));
            i++;
            z = true;
        }
        return sb.toString();
    }
}
