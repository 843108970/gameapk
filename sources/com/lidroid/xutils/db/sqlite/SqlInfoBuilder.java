package com.lidroid.xutils.db.sqlite;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.table.Column;
import com.lidroid.xutils.db.table.ColumnUtils;
import com.lidroid.xutils.db.table.Finder;
import com.lidroid.xutils.db.table.Id;
import com.lidroid.xutils.db.table.KeyValue;
import com.lidroid.xutils.db.table.Table;
import com.lidroid.xutils.db.table.TableUtils;
import com.lidroid.xutils.exception.DbException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SqlInfoBuilder {
    private SqlInfoBuilder() {
    }

    public static SqlInfo buildCreateTableSqlInfo(DbUtils dbUtils, Class<?> cls) throws DbException {
        String str;
        Table table = Table.get(dbUtils, cls);
        Id id = table.id;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append(table.tableName);
        stringBuffer.append(" ( ");
        if (id.isAutoIncrement()) {
            stringBuffer.append("\"");
            stringBuffer.append(id.getColumnName());
            str = "\"  INTEGER PRIMARY KEY AUTOINCREMENT,";
        } else {
            stringBuffer.append("\"");
            stringBuffer.append(id.getColumnName());
            stringBuffer.append("\"  ");
            stringBuffer.append(id.getColumnDbType());
            str = " PRIMARY KEY,";
        }
        stringBuffer.append(str);
        for (Column next : table.columnMap.values()) {
            if (!(next instanceof Finder)) {
                stringBuffer.append("\"");
                stringBuffer.append(next.getColumnName());
                stringBuffer.append("\"  ");
                stringBuffer.append(next.getColumnDbType());
                if (ColumnUtils.isUnique(next.getColumnField())) {
                    stringBuffer.append(" UNIQUE");
                }
                if (ColumnUtils.isNotNull(next.getColumnField())) {
                    stringBuffer.append(" NOT NULL");
                }
                String check = ColumnUtils.getCheck(next.getColumnField());
                if (check != null) {
                    stringBuffer.append(" CHECK(");
                    stringBuffer.append(check);
                    stringBuffer.append(")");
                }
                stringBuffer.append(",");
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" )");
        return new SqlInfo(stringBuffer.toString());
    }

    private static String buildDeleteSqlByTableName(String str) {
        return "DELETE FROM " + str;
    }

    public static SqlInfo buildDeleteSqlInfo(DbUtils dbUtils, Class<?> cls, WhereBuilder whereBuilder) throws DbException {
        StringBuilder sb = new StringBuilder(buildDeleteSqlByTableName(Table.get(dbUtils, cls).tableName));
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            sb.append(" WHERE ");
            sb.append(whereBuilder.toString());
        }
        return new SqlInfo(sb.toString());
    }

    public static SqlInfo buildDeleteSqlInfo(DbUtils dbUtils, Class<?> cls, Object obj) throws DbException {
        SqlInfo sqlInfo = new SqlInfo();
        Table table = Table.get(dbUtils, cls);
        Id id = table.id;
        if (obj == null) {
            throw new DbException("this entity[" + cls + "]'s id value is null");
        }
        sqlInfo.setSql(buildDeleteSqlByTableName(table.tableName) + " WHERE " + WhereBuilder.b(id.getColumnName(), "=", obj));
        return sqlInfo;
    }

    public static SqlInfo buildDeleteSqlInfo(DbUtils dbUtils, Object obj) throws DbException {
        SqlInfo sqlInfo = new SqlInfo();
        Table table = Table.get(dbUtils, obj.getClass());
        Id id = table.id;
        Object columnValue = id.getColumnValue(obj);
        if (columnValue == null) {
            throw new DbException("this entity[" + obj.getClass() + "]'s id value is null");
        }
        sqlInfo.setSql(buildDeleteSqlByTableName(table.tableName) + " WHERE " + WhereBuilder.b(id.getColumnName(), "=", columnValue));
        return sqlInfo;
    }

    public static SqlInfo buildInsertSqlInfo(DbUtils dbUtils, Object obj) throws DbException {
        List<KeyValue> entity2KeyValueList = entity2KeyValueList(dbUtils, obj);
        if (entity2KeyValueList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INSERT INTO ");
        stringBuffer.append(TableUtils.getTableName(obj.getClass()));
        stringBuffer.append(" (");
        for (KeyValue next : entity2KeyValueList) {
            stringBuffer.append(next.key);
            stringBuffer.append(",");
            sqlInfo.addBindArgWithoutConverter(next.value);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES (");
        int size = entity2KeyValueList.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    public static SqlInfo buildReplaceSqlInfo(DbUtils dbUtils, Object obj) throws DbException {
        List<KeyValue> entity2KeyValueList = entity2KeyValueList(dbUtils, obj);
        if (entity2KeyValueList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("REPLACE INTO ");
        stringBuffer.append(TableUtils.getTableName(obj.getClass()));
        stringBuffer.append(" (");
        for (KeyValue next : entity2KeyValueList) {
            stringBuffer.append(next.key);
            stringBuffer.append(",");
            sqlInfo.addBindArgWithoutConverter(next.value);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES (");
        int size = entity2KeyValueList.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    public static SqlInfo buildUpdateSqlInfo(DbUtils dbUtils, Object obj, WhereBuilder whereBuilder, String... strArr) throws DbException {
        List<KeyValue> entity2KeyValueList = entity2KeyValueList(dbUtils, obj);
        HashSet hashSet = null;
        if (entity2KeyValueList.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        String tableName = TableUtils.getTableName(obj.getClass());
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer("UPDATE ");
        stringBuffer.append(tableName);
        stringBuffer.append(" SET ");
        for (KeyValue next : entity2KeyValueList) {
            if (hashSet == null || hashSet.contains(next.key)) {
                stringBuffer.append(next.key);
                stringBuffer.append("=?,");
                sqlInfo.addBindArgWithoutConverter(next.value);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        if (whereBuilder != null && whereBuilder.getWhereItemSize() > 0) {
            stringBuffer.append(" WHERE ");
            stringBuffer.append(whereBuilder.toString());
        }
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    public static SqlInfo buildUpdateSqlInfo(DbUtils dbUtils, Object obj, String... strArr) throws DbException {
        List<KeyValue> entity2KeyValueList = entity2KeyValueList(dbUtils, obj);
        HashSet hashSet = null;
        if (entity2KeyValueList.size() == 0) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
        }
        Table table = Table.get(dbUtils, obj.getClass());
        Id id = table.id;
        Object columnValue = id.getColumnValue(obj);
        if (columnValue == null) {
            throw new DbException("this entity[" + obj.getClass() + "]'s id value is null");
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer("UPDATE ");
        stringBuffer.append(table.tableName);
        stringBuffer.append(" SET ");
        for (KeyValue next : entity2KeyValueList) {
            if (hashSet == null || hashSet.contains(next.key)) {
                stringBuffer.append(next.key);
                stringBuffer.append("=?,");
                sqlInfo.addBindArgWithoutConverter(next.value);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" WHERE ");
        stringBuffer.append(WhereBuilder.b(id.getColumnName(), "=", columnValue));
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    private static KeyValue column2KeyValue(Object obj, Column column) {
        String columnName = column.getColumnName();
        if (columnName == null) {
            return null;
        }
        Object columnValue = column.getColumnValue(obj);
        if (columnValue == null) {
            columnValue = column.getDefaultValue();
        }
        return new KeyValue(columnName, columnValue);
    }

    public static List<KeyValue> entity2KeyValueList(DbUtils dbUtils, Object obj) {
        KeyValue column2KeyValue;
        ArrayList arrayList = new ArrayList();
        Table table = Table.get(dbUtils, obj.getClass());
        Id id = table.id;
        if (!id.isAutoIncrement()) {
            arrayList.add(new KeyValue(id.getColumnName(), id.getColumnValue(obj)));
        }
        for (Column next : table.columnMap.values()) {
            if (!(next instanceof Finder) && (column2KeyValue = column2KeyValue(obj, next)) != null) {
                arrayList.add(column2KeyValue);
            }
        }
        return arrayList;
    }
}
