package com.lidroid.xutils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.CursorUtils;
import com.lidroid.xutils.db.sqlite.DbModelSelector;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.SqlInfo;
import com.lidroid.xutils.db.sqlite.SqlInfoBuilder;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.db.table.DbModel;
import com.lidroid.xutils.db.table.Id;
import com.lidroid.xutils.db.table.Table;
import com.lidroid.xutils.db.table.TableUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DbUtils {
    private static HashMap<String, DbUtils> daoMap = new HashMap<>();
    private boolean allowTransaction = false;
    private DaoConfig daoConfig;
    private SQLiteDatabase database;
    private boolean debug = false;
    private final FindTempCache findTempCache = new FindTempCache(this, (FindTempCache) null);
    private Lock writeLock = new ReentrantLock();
    private volatile boolean writeLocked = false;

    public static class DaoConfig {
        private Context context;
        private String dbDir;
        private String dbName = "xUtils.db";
        private DbUpgradeListener dbUpgradeListener;
        private int dbVersion = 1;

        public DaoConfig(Context context2) {
            this.context = context2.getApplicationContext();
        }

        public Context getContext() {
            return this.context;
        }

        public String getDbDir() {
            return this.dbDir;
        }

        public String getDbName() {
            return this.dbName;
        }

        public DbUpgradeListener getDbUpgradeListener() {
            return this.dbUpgradeListener;
        }

        public int getDbVersion() {
            return this.dbVersion;
        }

        public void setDbDir(String str) {
            this.dbDir = str;
        }

        public void setDbName(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.dbName = str;
            }
        }

        public void setDbUpgradeListener(DbUpgradeListener dbUpgradeListener2) {
            this.dbUpgradeListener = dbUpgradeListener2;
        }

        public void setDbVersion(int i) {
            this.dbVersion = i;
        }
    }

    public interface DbUpgradeListener {
        void onUpgrade(DbUtils dbUtils, int i, int i2);
    }

    private class FindTempCache {
        private final ConcurrentHashMap<String, Object> cache;
        private long seq;

        private FindTempCache() {
            this.cache = new ConcurrentHashMap<>();
            this.seq = 0;
        }

        /* synthetic */ FindTempCache(DbUtils dbUtils, FindTempCache findTempCache) {
            this();
        }

        public Object get(String str) {
            return this.cache.get(str);
        }

        public void put(String str, Object obj) {
            if (str != null && obj != null) {
                this.cache.put(str, obj);
            }
        }

        public void setSeq(long j) {
            if (this.seq != j) {
                this.cache.clear();
                this.seq = j;
            }
        }
    }

    private DbUtils(DaoConfig daoConfig2) {
        if (daoConfig2 == null) {
            throw new IllegalArgumentException("daoConfig may not be null");
        }
        this.database = createDatabase(daoConfig2);
        this.daoConfig = daoConfig2;
    }

    private void beginTransaction() {
        if (this.allowTransaction) {
            this.database.beginTransaction();
            return;
        }
        this.writeLock.lock();
        this.writeLocked = true;
    }

    public static DbUtils create(Context context) {
        return getInstance(new DaoConfig(context));
    }

    public static DbUtils create(Context context, String str) {
        DaoConfig daoConfig2 = new DaoConfig(context);
        daoConfig2.setDbName(str);
        return getInstance(daoConfig2);
    }

    public static DbUtils create(Context context, String str, int i, DbUpgradeListener dbUpgradeListener) {
        DaoConfig daoConfig2 = new DaoConfig(context);
        daoConfig2.setDbName(str);
        daoConfig2.setDbVersion(i);
        daoConfig2.setDbUpgradeListener(dbUpgradeListener);
        return getInstance(daoConfig2);
    }

    public static DbUtils create(Context context, String str, String str2) {
        DaoConfig daoConfig2 = new DaoConfig(context);
        daoConfig2.setDbDir(str);
        daoConfig2.setDbName(str2);
        return getInstance(daoConfig2);
    }

    public static DbUtils create(Context context, String str, String str2, int i, DbUpgradeListener dbUpgradeListener) {
        DaoConfig daoConfig2 = new DaoConfig(context);
        daoConfig2.setDbDir(str);
        daoConfig2.setDbName(str2);
        daoConfig2.setDbVersion(i);
        daoConfig2.setDbUpgradeListener(dbUpgradeListener);
        return getInstance(daoConfig2);
    }

    public static DbUtils create(DaoConfig daoConfig2) {
        return getInstance(daoConfig2);
    }

    private SQLiteDatabase createDatabase(DaoConfig daoConfig2) {
        String dbDir = daoConfig2.getDbDir();
        if (TextUtils.isEmpty(dbDir)) {
            return daoConfig2.getContext().openOrCreateDatabase(daoConfig2.getDbName(), 0, (SQLiteDatabase.CursorFactory) null);
        }
        File file = new File(dbDir);
        if (file.exists() || file.mkdirs()) {
            return SQLiteDatabase.openOrCreateDatabase(new File(dbDir, daoConfig2.getDbName()), (SQLiteDatabase.CursorFactory) null);
        }
        return null;
    }

    private void debugSql(String str) {
        if (this.debug) {
            LogUtils.d(str);
        }
    }

    private void endTransaction() {
        if (this.allowTransaction) {
            this.database.endTransaction();
        }
        if (this.writeLocked) {
            this.writeLock.unlock();
            this.writeLocked = false;
        }
    }

    private static synchronized DbUtils getInstance(DaoConfig daoConfig2) {
        DbUtils dbUtils;
        synchronized (DbUtils.class) {
            dbUtils = daoMap.get(daoConfig2.getDbName());
            if (dbUtils == null) {
                dbUtils = new DbUtils(daoConfig2);
                daoMap.put(daoConfig2.getDbName(), dbUtils);
            } else {
                dbUtils.daoConfig = daoConfig2;
            }
            SQLiteDatabase sQLiteDatabase = dbUtils.database;
            int version = sQLiteDatabase.getVersion();
            int dbVersion = daoConfig2.getDbVersion();
            if (version != dbVersion) {
                if (version != 0) {
                    DbUpgradeListener dbUpgradeListener = daoConfig2.getDbUpgradeListener();
                    if (dbUpgradeListener != null) {
                        dbUpgradeListener.onUpgrade(dbUtils, version, dbVersion);
                    } else {
                        try {
                            dbUtils.dropDb();
                        } catch (DbException e) {
                            LogUtils.e(e.getMessage(), e);
                        }
                    }
                }
                sQLiteDatabase.setVersion(dbVersion);
            }
        }
        return dbUtils;
    }

    private long getLastAutoIncrementId(String str) throws DbException {
        Cursor execQuery = execQuery("SELECT seq FROM sqlite_sequence WHERE name='" + str + "'");
        long j = -1;
        if (execQuery == null) {
            return -1;
        }
        try {
            if (execQuery.moveToNext()) {
                j = execQuery.getLong(0);
            }
            IOUtils.closeQuietly(execQuery);
            return j;
        } catch (Throwable th) {
            IOUtils.closeQuietly(execQuery);
            throw th;
        }
    }

    private boolean saveBindingIdWithoutTransaction(Object obj) throws DbException {
        Table table = Table.get(this, obj.getClass());
        Id id = table.id;
        if (id.isAutoIncrement()) {
            execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(this, obj));
            long lastAutoIncrementId = getLastAutoIncrementId(table.tableName);
            if (lastAutoIncrementId == -1) {
                return false;
            }
            id.setAutoIncrementId(obj, lastAutoIncrementId);
            return true;
        }
        execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(this, obj));
        return true;
    }

    private void saveOrUpdateWithoutTransaction(Object obj) throws DbException {
        SqlInfo buildReplaceSqlInfo;
        Id id = Table.get(this, obj.getClass()).id;
        if (!id.isAutoIncrement()) {
            buildReplaceSqlInfo = SqlInfoBuilder.buildReplaceSqlInfo(this, obj);
        } else if (id.getColumnValue(obj) != null) {
            buildReplaceSqlInfo = SqlInfoBuilder.buildUpdateSqlInfo(this, obj, new String[0]);
        } else {
            saveBindingIdWithoutTransaction(obj);
            return;
        }
        execNonQuery(buildReplaceSqlInfo);
    }

    private void setTransactionSuccessful() {
        if (this.allowTransaction) {
            this.database.setTransactionSuccessful();
        }
    }

    public void close() {
        String dbName = this.daoConfig.getDbName();
        if (daoMap.containsKey(dbName)) {
            daoMap.remove(dbName);
            this.database.close();
        }
    }

    public DbUtils configAllowTransaction(boolean z) {
        this.allowTransaction = z;
        return this;
    }

    public DbUtils configDebug(boolean z) {
        this.debug = z;
        return this;
    }

    public long count(Selector selector) throws DbException {
        Class<?> entityType = selector.getEntityType();
        if (!tableIsExist(entityType)) {
            return 0;
        }
        Table table = Table.get(this, entityType);
        return findDbModelFirst(selector.select("count(" + table.id.getColumnName() + ") as count")).getLong("count");
    }

    public long count(Class<?> cls) throws DbException {
        return count(Selector.from(cls));
    }

    public void createTableIfNotExist(Class<?> cls) throws DbException {
        if (!tableIsExist(cls)) {
            execNonQuery(SqlInfoBuilder.buildCreateTableSqlInfo(this, cls));
            String execAfterTableCreated = TableUtils.getExecAfterTableCreated(cls);
            if (!TextUtils.isEmpty(execAfterTableCreated)) {
                execNonQuery(execAfterTableCreated);
            }
        }
    }

    public void delete(Class<?> cls, WhereBuilder whereBuilder) throws DbException {
        if (tableIsExist(cls)) {
            try {
                beginTransaction();
                execNonQuery(SqlInfoBuilder.buildDeleteSqlInfo(this, cls, whereBuilder));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void delete(Object obj) throws DbException {
        if (tableIsExist(obj.getClass())) {
            try {
                beginTransaction();
                execNonQuery(SqlInfoBuilder.buildDeleteSqlInfo(this, obj));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void deleteAll(Class<?> cls) throws DbException {
        delete(cls, (WhereBuilder) null);
    }

    public void deleteAll(List<?> list) throws DbException {
        if (list != null && list.size() != 0 && tableIsExist(list.get(0).getClass())) {
            try {
                beginTransaction();
                for (Object buildDeleteSqlInfo : list) {
                    execNonQuery(SqlInfoBuilder.buildDeleteSqlInfo(this, buildDeleteSqlInfo));
                }
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void deleteById(Class<?> cls, Object obj) throws DbException {
        if (tableIsExist(cls)) {
            try {
                beginTransaction();
                execNonQuery(SqlInfoBuilder.buildDeleteSqlInfo(this, cls, obj));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void dropDb() throws DbException {
        Cursor execQuery = execQuery("SELECT name FROM sqlite_master WHERE type='table' AND name<>'sqlite_sequence'");
        if (execQuery != null) {
            while (execQuery.moveToNext()) {
                try {
                    String string = execQuery.getString(0);
                    execNonQuery("DROP TABLE " + string);
                    Table.remove(this, string);
                } catch (Throwable th) {
                    try {
                        throw new DbException(th);
                    } catch (Throwable th2) {
                        IOUtils.closeQuietly(execQuery);
                        throw th2;
                    }
                }
            }
            IOUtils.closeQuietly(execQuery);
        }
    }

    public void dropTable(Class<?> cls) throws DbException {
        if (tableIsExist(cls)) {
            String tableName = TableUtils.getTableName(cls);
            execNonQuery("DROP TABLE " + tableName);
            Table.remove(this, cls);
        }
    }

    public void execNonQuery(SqlInfo sqlInfo) throws DbException {
        debugSql(sqlInfo.getSql());
        try {
            if (sqlInfo.getBindArgs() != null) {
                this.database.execSQL(sqlInfo.getSql(), sqlInfo.getBindArgsAsArray());
            } else {
                this.database.execSQL(sqlInfo.getSql());
            }
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    public void execNonQuery(String str) throws DbException {
        debugSql(str);
        try {
            this.database.execSQL(str);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    public Cursor execQuery(SqlInfo sqlInfo) throws DbException {
        debugSql(sqlInfo.getSql());
        try {
            return this.database.rawQuery(sqlInfo.getSql(), sqlInfo.getBindArgsAsStrArray());
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    public Cursor execQuery(String str) throws DbException {
        debugSql(str);
        try {
            return this.database.rawQuery(str, (String[]) null);
        } catch (Throwable th) {
            throw new DbException(th);
        }
    }

    public <T> List<T> findAll(Selector selector) throws DbException {
        if (!tableIsExist(selector.getEntityType())) {
            return null;
        }
        String selector2 = selector.toString();
        long seq = CursorUtils.FindCacheSequence.getSeq();
        this.findTempCache.setSeq(seq);
        Object obj = this.findTempCache.get(selector2);
        if (obj != null) {
            return (List) obj;
        }
        ArrayList arrayList = new ArrayList();
        Cursor execQuery = execQuery(selector2);
        if (execQuery == null) {
            return arrayList;
        }
        while (execQuery.moveToNext()) {
            try {
                arrayList.add(CursorUtils.getEntity(this, execQuery, selector.getEntityType(), seq));
            } catch (Throwable th) {
                IOUtils.closeQuietly(execQuery);
                throw th;
            }
        }
        this.findTempCache.put(selector2, arrayList);
        IOUtils.closeQuietly(execQuery);
        return arrayList;
    }

    public <T> List<T> findAll(Class<T> cls) throws DbException {
        return findAll(Selector.from(cls));
    }

    public <T> T findById(Class<T> cls, Object obj) throws DbException {
        if (!tableIsExist(cls)) {
            return null;
        }
        String selector = Selector.from(cls).where(Table.get(this, cls).id.getColumnName(), "=", obj).limit(1).toString();
        long seq = CursorUtils.FindCacheSequence.getSeq();
        this.findTempCache.setSeq(seq);
        T t = this.findTempCache.get(selector);
        if (t != null) {
            return t;
        }
        Cursor execQuery = execQuery(selector);
        if (execQuery == null) {
            return null;
        }
        try {
            if (execQuery.moveToNext()) {
                T entity = CursorUtils.getEntity(this, execQuery, cls, seq);
                this.findTempCache.put(selector, entity);
                IOUtils.closeQuietly(execQuery);
                return entity;
            }
            IOUtils.closeQuietly(execQuery);
            return null;
        } catch (Throwable th) {
            IOUtils.closeQuietly(execQuery);
            throw th;
        }
    }

    public List<DbModel> findDbModelAll(DbModelSelector dbModelSelector) throws DbException {
        if (!tableIsExist(dbModelSelector.getEntityType())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor execQuery = execQuery(dbModelSelector.toString());
        if (execQuery == null) {
            return arrayList;
        }
        while (execQuery.moveToNext()) {
            try {
                arrayList.add(CursorUtils.getDbModel(execQuery));
            } catch (Throwable th) {
                IOUtils.closeQuietly(execQuery);
                throw th;
            }
        }
        IOUtils.closeQuietly(execQuery);
        return arrayList;
    }

    public List<DbModel> findDbModelAll(SqlInfo sqlInfo) throws DbException {
        ArrayList arrayList = new ArrayList();
        Cursor execQuery = execQuery(sqlInfo);
        if (execQuery == null) {
            return arrayList;
        }
        while (execQuery.moveToNext()) {
            try {
                arrayList.add(CursorUtils.getDbModel(execQuery));
            } catch (Throwable th) {
                IOUtils.closeQuietly(execQuery);
                throw th;
            }
        }
        IOUtils.closeQuietly(execQuery);
        return arrayList;
    }

    public DbModel findDbModelFirst(DbModelSelector dbModelSelector) throws DbException {
        Cursor execQuery;
        if (!tableIsExist(dbModelSelector.getEntityType()) || (execQuery = execQuery(dbModelSelector.limit(1).toString())) == null) {
            return null;
        }
        try {
            if (execQuery.moveToNext()) {
                DbModel dbModel = CursorUtils.getDbModel(execQuery);
                IOUtils.closeQuietly(execQuery);
                return dbModel;
            }
            IOUtils.closeQuietly(execQuery);
            return null;
        } catch (Throwable th) {
            IOUtils.closeQuietly(execQuery);
            throw th;
        }
    }

    public DbModel findDbModelFirst(SqlInfo sqlInfo) throws DbException {
        Cursor execQuery = execQuery(sqlInfo);
        if (execQuery == null) {
            return null;
        }
        try {
            if (execQuery.moveToNext()) {
                DbModel dbModel = CursorUtils.getDbModel(execQuery);
                IOUtils.closeQuietly(execQuery);
                return dbModel;
            }
            IOUtils.closeQuietly(execQuery);
            return null;
        } catch (Throwable th) {
            IOUtils.closeQuietly(execQuery);
            throw th;
        }
    }

    public <T> T findFirst(Selector selector) throws DbException {
        if (!tableIsExist(selector.getEntityType())) {
            return null;
        }
        String selector2 = selector.limit(1).toString();
        long seq = CursorUtils.FindCacheSequence.getSeq();
        this.findTempCache.setSeq(seq);
        T t = this.findTempCache.get(selector2);
        if (t != null) {
            return t;
        }
        Cursor execQuery = execQuery(selector2);
        if (execQuery == null) {
            return null;
        }
        try {
            if (execQuery.moveToNext()) {
                T entity = CursorUtils.getEntity(this, execQuery, selector.getEntityType(), seq);
                this.findTempCache.put(selector2, entity);
                IOUtils.closeQuietly(execQuery);
                return entity;
            }
            IOUtils.closeQuietly(execQuery);
            return null;
        } catch (Throwable th) {
            IOUtils.closeQuietly(execQuery);
            throw th;
        }
    }

    public <T> T findFirst(Class<T> cls) throws DbException {
        return findFirst(Selector.from(cls));
    }

    public DaoConfig getDaoConfig() {
        return this.daoConfig;
    }

    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    public void replace(Object obj) throws DbException {
        try {
            beginTransaction();
            createTableIfNotExist(obj.getClass());
            execNonQuery(SqlInfoBuilder.buildReplaceSqlInfo(this, obj));
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public void replaceAll(List<?> list) throws DbException {
        if (list != null && list.size() != 0) {
            try {
                beginTransaction();
                createTableIfNotExist(list.get(0).getClass());
                for (Object buildReplaceSqlInfo : list) {
                    execNonQuery(SqlInfoBuilder.buildReplaceSqlInfo(this, buildReplaceSqlInfo));
                }
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void save(Object obj) throws DbException {
        try {
            beginTransaction();
            createTableIfNotExist(obj.getClass());
            execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(this, obj));
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public void saveAll(List<?> list) throws DbException {
        if (list != null && list.size() != 0) {
            try {
                beginTransaction();
                createTableIfNotExist(list.get(0).getClass());
                for (Object buildInsertSqlInfo : list) {
                    execNonQuery(SqlInfoBuilder.buildInsertSqlInfo(this, buildInsertSqlInfo));
                }
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public boolean saveBindingId(Object obj) throws DbException {
        try {
            beginTransaction();
            createTableIfNotExist(obj.getClass());
            boolean saveBindingIdWithoutTransaction = saveBindingIdWithoutTransaction(obj);
            setTransactionSuccessful();
            return saveBindingIdWithoutTransaction;
        } finally {
            endTransaction();
        }
    }

    public void saveBindingIdAll(List<?> list) throws DbException {
        if (list != null && list.size() != 0) {
            try {
                beginTransaction();
                createTableIfNotExist(list.get(0).getClass());
                for (Object saveBindingIdWithoutTransaction : list) {
                    if (!saveBindingIdWithoutTransaction(saveBindingIdWithoutTransaction)) {
                        throw new DbException("saveBindingId error, transaction will not commit!");
                    }
                }
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void saveOrUpdate(Object obj) throws DbException {
        try {
            beginTransaction();
            createTableIfNotExist(obj.getClass());
            saveOrUpdateWithoutTransaction(obj);
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public void saveOrUpdateAll(List<?> list) throws DbException {
        if (list != null && list.size() != 0) {
            try {
                beginTransaction();
                createTableIfNotExist(list.get(0).getClass());
                for (Object saveOrUpdateWithoutTransaction : list) {
                    saveOrUpdateWithoutTransaction(saveOrUpdateWithoutTransaction);
                }
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public boolean tableIsExist(Class<?> cls) throws DbException {
        Table table = Table.get(this, cls);
        if (table.isCheckedDatabase()) {
            return true;
        }
        Cursor execQuery = execQuery("SELECT COUNT(*) AS c FROM sqlite_master WHERE type='table' AND name='" + table.tableName + "'");
        if (execQuery == null) {
            return false;
        }
        try {
            if (!execQuery.moveToNext() || execQuery.getInt(0) <= 0) {
                IOUtils.closeQuietly(execQuery);
                return false;
            }
            table.setCheckedDatabase(true);
            IOUtils.closeQuietly(execQuery);
            return true;
        } catch (Throwable th) {
            IOUtils.closeQuietly(execQuery);
            throw th;
        }
    }

    public void update(Object obj, WhereBuilder whereBuilder, String... strArr) throws DbException {
        if (tableIsExist(obj.getClass())) {
            try {
                beginTransaction();
                execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo(this, obj, whereBuilder, strArr));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void update(Object obj, String... strArr) throws DbException {
        if (tableIsExist(obj.getClass())) {
            try {
                beginTransaction();
                execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo(this, obj, strArr));
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void updateAll(List<?> list, WhereBuilder whereBuilder, String... strArr) throws DbException {
        if (list != null && list.size() != 0 && tableIsExist(list.get(0).getClass())) {
            try {
                beginTransaction();
                for (Object buildUpdateSqlInfo : list) {
                    execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo(this, buildUpdateSqlInfo, whereBuilder, strArr));
                }
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void updateAll(List<?> list, String... strArr) throws DbException {
        if (list != null && list.size() != 0 && tableIsExist(list.get(0).getClass())) {
            try {
                beginTransaction();
                for (Object buildUpdateSqlInfo : list) {
                    execNonQuery(SqlInfoBuilder.buildUpdateSqlInfo(this, buildUpdateSqlInfo, strArr));
                }
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }
}
