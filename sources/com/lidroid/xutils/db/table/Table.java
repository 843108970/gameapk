package com.lidroid.xutils.db.table;

import android.text.TextUtils;
import com.lidroid.xutils.DbUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Table {
    private static final HashMap<String, Table> tableMap = new HashMap<>();
    private boolean checkedDatabase;
    public final HashMap<String, Column> columnMap;
    public final DbUtils db;
    public final HashMap<String, Finder> finderMap = new HashMap<>();
    public final Id id;
    public final String tableName;

    private Table(DbUtils dbUtils, Class<?> cls) {
        this.db = dbUtils;
        this.tableName = TableUtils.getTableName(cls);
        this.id = TableUtils.getId(cls);
        this.columnMap = TableUtils.getColumnMap(cls);
        for (Column next : this.columnMap.values()) {
            next.setTable(this);
            if (next instanceof Finder) {
                this.finderMap.put(next.getColumnName(), (Finder) next);
            }
        }
    }

    public static synchronized Table get(DbUtils dbUtils, Class<?> cls) {
        Table table;
        synchronized (Table.class) {
            String str = String.valueOf(dbUtils.getDaoConfig().getDbName()) + "#" + cls.getName();
            table = tableMap.get(str);
            if (table == null) {
                table = new Table(dbUtils, cls);
                tableMap.put(str, table);
            }
        }
        return table;
    }

    public static synchronized void remove(DbUtils dbUtils, Class<?> cls) {
        synchronized (Table.class) {
            tableMap.remove(String.valueOf(dbUtils.getDaoConfig().getDbName()) + "#" + cls.getName());
        }
    }

    public static synchronized void remove(DbUtils dbUtils, String str) {
        synchronized (Table.class) {
            if (tableMap.size() > 0) {
                String str2 = null;
                Iterator<Map.Entry<String, Table>> it = tableMap.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry next = it.next();
                        Table table = (Table) next.getValue();
                        if (table != null && table.tableName.equals(str)) {
                            str2 = (String) next.getKey();
                            if (str2.startsWith(String.valueOf(dbUtils.getDaoConfig().getDbName()) + "#")) {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    tableMap.remove(str2);
                }
            }
        }
    }

    public boolean isCheckedDatabase() {
        return this.checkedDatabase;
    }

    public void setCheckedDatabase(boolean z) {
        this.checkedDatabase = z;
    }
}
