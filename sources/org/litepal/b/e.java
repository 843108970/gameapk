package org.litepal.b;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.b.a.g;
import org.litepal.f;
import org.litepal.f.c;
import org.litepal.g.a;

public class e {
    protected static final String AES = "AES";
    protected static final String MD5 = "MD5";
    Map<String, List<Long>> associatedModelsMapForJoinTable;
    private Map<String, Set<Long>> associatedModelsMapWithFK;
    private Map<String, Long> associatedModelsMapWithoutFK;
    long baseObjId;
    private List<String> fieldsToSetToDefault;
    private List<String> listToClearAssociatedFK;
    private List<String> listToClearSelfFK;

    protected e() {
    }

    private void clearFKNameList() {
        getListToClearSelfFK().clear();
        getListToClearAssociatedFK().clear();
    }

    private void clearIdOfModelForJoinTable() {
        for (String str : getAssociatedModelsMapForJoinTable().keySet()) {
            this.associatedModelsMapForJoinTable.get(str).clear();
        }
        this.associatedModelsMapForJoinTable.clear();
    }

    private void clearIdOfModelWithFK() {
        for (String str : getAssociatedModelsMapWithFK().keySet()) {
            this.associatedModelsMapWithFK.get(str).clear();
        }
        this.associatedModelsMapWithFK.clear();
    }

    private void clearIdOfModelWithoutFK() {
        getAssociatedModelsMapWithoutFK().clear();
    }

    /* access modifiers changed from: package-private */
    public void addAssociatedModelForJoinTable(String str, long j) {
        List list = getAssociatedModelsMapForJoinTable().get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j));
            this.associatedModelsMapForJoinTable.put(str, arrayList);
            return;
        }
        list.add(Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void addAssociatedModelWithFK(String str, long j) {
        Set set = getAssociatedModelsMapWithFK().get(str);
        if (set == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(j));
            this.associatedModelsMapWithFK.put(str, hashSet);
            return;
        }
        set.add(Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void addAssociatedModelWithoutFK(String str, long j) {
        getAssociatedModelsMapWithoutFK().put(str, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public void addAssociatedTableNameToClearFK(String str) {
        List<String> listToClearAssociatedFK2 = getListToClearAssociatedFK();
        if (!listToClearAssociatedFK2.contains(str)) {
            listToClearAssociatedFK2.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void addEmptyModelForJoinTable(String str) {
        if (getAssociatedModelsMapForJoinTable().get(str) == null) {
            this.associatedModelsMapForJoinTable.put(str, new ArrayList());
        }
    }

    /* access modifiers changed from: package-private */
    public void addFKNameToClearSelf(String str) {
        List<String> listToClearSelfFK2 = getListToClearSelfFK();
        if (!listToClearSelfFK2.contains(str)) {
            listToClearSelfFK2.add(str);
        }
    }

    public void assignBaseObjId(int i) {
        this.baseObjId = (long) i;
    }

    /* access modifiers changed from: package-private */
    public void clearAssociatedData() {
        clearIdOfModelWithFK();
        clearIdOfModelWithoutFK();
        clearIdOfModelForJoinTable();
        clearFKNameList();
    }

    public void clearSavedState() {
        this.baseObjId = 0;
    }

    public int delete() {
        int b2;
        synchronized (e.class) {
            SQLiteDatabase a2 = c.a();
            a2.beginTransaction();
            try {
                b2 = new c(a2).b(this);
                this.baseObjId = 0;
                a2.setTransactionSuccessful();
            } finally {
                a2.endTransaction();
            }
        }
        return b2;
    }

    public g deleteAsync() {
        final g gVar = new g();
        gVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int delete = e.this.delete();
                    if (gVar.f4691b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return gVar;
    }

    /* access modifiers changed from: package-private */
    public Map<String, List<Long>> getAssociatedModelsMapForJoinTable() {
        if (this.associatedModelsMapForJoinTable == null) {
            this.associatedModelsMapForJoinTable = new HashMap();
        }
        return this.associatedModelsMapForJoinTable;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Set<Long>> getAssociatedModelsMapWithFK() {
        if (this.associatedModelsMapWithFK == null) {
            this.associatedModelsMapWithFK = new HashMap();
        }
        return this.associatedModelsMapWithFK;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Long> getAssociatedModelsMapWithoutFK() {
        if (this.associatedModelsMapWithoutFK == null) {
            this.associatedModelsMapWithoutFK = new HashMap();
        }
        return this.associatedModelsMapWithoutFK;
    }

    /* access modifiers changed from: protected */
    public long getBaseObjId() {
        return this.baseObjId;
    }

    /* access modifiers changed from: protected */
    public String getClassName() {
        return getClass().getName();
    }

    /* access modifiers changed from: package-private */
    public List<String> getFieldsToSetToDefault() {
        if (this.fieldsToSetToDefault == null) {
            this.fieldsToSetToDefault = new ArrayList();
        }
        return this.fieldsToSetToDefault;
    }

    /* access modifiers changed from: package-private */
    public List<String> getListToClearAssociatedFK() {
        if (this.listToClearAssociatedFK == null) {
            this.listToClearAssociatedFK = new ArrayList();
        }
        return this.listToClearAssociatedFK;
    }

    /* access modifiers changed from: package-private */
    public List<String> getListToClearSelfFK() {
        if (this.listToClearSelfFK == null) {
            this.listToClearSelfFK = new ArrayList();
        }
        return this.listToClearSelfFK;
    }

    /* access modifiers changed from: protected */
    public String getTableName() {
        return a.a(org.litepal.g.c.a(getClassName()));
    }

    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    public boolean save() {
        try {
            saveThrows();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public org.litepal.b.a.f saveAsync() {
        final org.litepal.b.a.f fVar = new org.litepal.b.a.f();
        fVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final boolean save = e.this.save();
                    if (fVar.f4690b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return fVar;
    }

    @Deprecated
    public boolean saveIfNotExist(String... strArr) {
        if (!f.c(getClass(), strArr)) {
            return save();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0063, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0068, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0005, B:27:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean saveOrUpdate(java.lang.String... r6) {
        /*
            r5 = this;
            java.lang.Class<org.litepal.b.e> r0 = org.litepal.b.e.class
            monitor-enter(r0)
            if (r6 != 0) goto L_0x000d
            boolean r6 = r5.save()     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return r6
        L_0x000b:
            r6 = move-exception
            goto L_0x0067
        L_0x000d:
            org.litepal.b r6 = org.litepal.f.b((java.lang.String[]) r6)     // Catch:{ all -> 0x000b }
            java.lang.Class r1 = r5.getClass()     // Catch:{ all -> 0x000b }
            r2 = 0
            java.util.List r6 = r6.a(r1, (boolean) r2)     // Catch:{ all -> 0x000b }
            boolean r1 = r6.isEmpty()     // Catch:{ all -> 0x000b }
            if (r1 == 0) goto L_0x0026
            boolean r6 = r5.save()     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return r6
        L_0x0026:
            android.database.sqlite.SQLiteDatabase r1 = org.litepal.f.c.a()     // Catch:{ all -> 0x000b }
            r1.beginTransaction()     // Catch:{ all -> 0x000b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x005a }
        L_0x0031:
            boolean r3 = r6.hasNext()     // Catch:{ Exception -> 0x005a }
            if (r3 == 0) goto L_0x004f
            java.lang.Object r3 = r6.next()     // Catch:{ Exception -> 0x005a }
            org.litepal.b.e r3 = (org.litepal.b.e) r3     // Catch:{ Exception -> 0x005a }
            long r3 = r3.getBaseObjId()     // Catch:{ Exception -> 0x005a }
            r5.baseObjId = r3     // Catch:{ Exception -> 0x005a }
            org.litepal.b.j r3 = new org.litepal.b.j     // Catch:{ Exception -> 0x005a }
            r3.<init>(r1)     // Catch:{ Exception -> 0x005a }
            r3.b((org.litepal.b.e) r5)     // Catch:{ Exception -> 0x005a }
            r5.clearAssociatedData()     // Catch:{ Exception -> 0x005a }
            goto L_0x0031
        L_0x004f:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x005a }
            r1.endTransaction()     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            r6 = 1
            return r6
        L_0x0058:
            r6 = move-exception
            goto L_0x0063
        L_0x005a:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0058 }
            r1.endTransaction()     // Catch:{ all -> 0x000b }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return r2
        L_0x0063:
            r1.endTransaction()     // Catch:{ all -> 0x000b }
            throw r6     // Catch:{ all -> 0x000b }
        L_0x0067:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.b.e.saveOrUpdate(java.lang.String[]):boolean");
    }

    public org.litepal.b.a.f saveOrUpdateAsync(final String... strArr) {
        final org.litepal.b.a.f fVar = new org.litepal.b.a.f();
        fVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final boolean saveOrUpdate = e.this.saveOrUpdate(strArr);
                    if (fVar.f4690b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return fVar;
    }

    public void saveThrows() {
        synchronized (e.class) {
            SQLiteDatabase a2 = c.a();
            a2.beginTransaction();
            try {
                new j(a2).b(this);
                clearAssociatedData();
                a2.setTransactionSuccessful();
                a2.endTransaction();
            } catch (Exception e) {
                throw new org.litepal.c.e(e.getMessage(), e);
            } catch (Throwable th) {
                a2.endTransaction();
                throw th;
            }
        }
    }

    public void setToDefault(String str) {
        getFieldsToSetToDefault().add(str);
    }

    public int update(long j) {
        int b2;
        synchronized (e.class) {
            try {
                b2 = new k(c.a()).b(this, j);
                getFieldsToSetToDefault().clear();
            } catch (Exception e) {
                throw new org.litepal.c.e(e.getMessage(), e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    public int updateAll(String... strArr) {
        int a2;
        synchronized (e.class) {
            try {
                a2 = new k(c.a()).a(this, strArr);
                getFieldsToSetToDefault().clear();
            } catch (Exception e) {
                throw new org.litepal.c.e(e.getMessage(), e);
            } catch (Throwable th) {
                throw th;
            }
        }
        return a2;
    }

    public g updateAllAsync(final String... strArr) {
        final g gVar = new g();
        gVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int updateAll = e.this.updateAll(strArr);
                    if (gVar.f4691b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return gVar;
    }

    public g updateAsync(final long j) {
        final g gVar = new g();
        gVar.f4685a = new Runnable() {
            public final void run() {
                synchronized (e.class) {
                    final int update = e.this.update(j);
                    if (gVar.f4691b != null) {
                        f.a().post(new Runnable() {
                            public final void run() {
                            }
                        });
                    }
                }
            }
        };
        return gVar;
    }
}
