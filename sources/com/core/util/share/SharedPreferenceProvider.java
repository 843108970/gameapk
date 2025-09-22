package com.core.util.share;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SharedPreferenceProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, a> f1591a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private a f1592b = new a() {
        public final Bundle a(@Nullable String str, @Nullable Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(b.g, Process.myPid());
            return bundle2;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private a f1593c = new a() {
        public final Bundle a(@Nullable String str, @Nullable Bundle bundle) {
            if (bundle == null) {
                throw new IllegalArgumentException("methodQueryValues, extras is null!");
            }
            Context context = SharedPreferenceProvider.this.getContext();
            if (context == null) {
                throw new IllegalArgumentException("methodQueryValues, ctx is null!");
            }
            String string = bundle.getString("key_key");
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            int i = bundle.getInt("key_value_type");
            switch (i) {
                case 1:
                    bundle.putString("key_value", sharedPreferences.getString(string, bundle.getString("key_value")));
                    return bundle;
                case 2:
                    bundle.putInt("key_value", sharedPreferences.getInt(string, bundle.getInt("key_value")));
                    return bundle;
                case 3:
                    bundle.putLong("key_value", sharedPreferences.getLong(string, bundle.getLong("key_value")));
                    return bundle;
                case 4:
                    bundle.putFloat("key_value", sharedPreferences.getFloat(string, bundle.getFloat("key_value")));
                    return bundle;
                case 5:
                    bundle.putBoolean("key_value", sharedPreferences.getBoolean(string, bundle.getBoolean("key_value")));
                    return bundle;
                case 6:
                    ArrayList arrayList = null;
                    Set<String> stringSet = sharedPreferences.getStringSet(string, (Set) null);
                    if (stringSet != null) {
                        arrayList = new ArrayList(stringSet);
                    }
                    bundle.putStringArrayList("key_value", arrayList);
                    return bundle;
                default:
                    throw new IllegalArgumentException("unknown valueType:" + i);
            }
        }
    };
    private a d = new a() {
        public final Bundle a(@Nullable String str, @Nullable Bundle bundle) {
            if (bundle == null) {
                throw new IllegalArgumentException("methodQueryValues, extras is null!");
            }
            Context context = SharedPreferenceProvider.this.getContext();
            if (context == null) {
                throw new IllegalArgumentException("methodQueryValues, ctx is null!");
            }
            bundle.putBoolean(b.g, context.getSharedPreferences(str, 0).contains(bundle.getString("key_key")));
            return bundle;
        }
    };
    private a e = new a() {
        private static SharedPreferences.Editor a(SharedPreferences.Editor editor, Bundle bundle) {
            String string = bundle.getString("key_key");
            int i = bundle.getInt("key_value_type");
            switch (i) {
                case 1:
                    return editor.putString(string, bundle.getString("key_value"));
                case 2:
                    return editor.putInt(string, bundle.getInt("key_value"));
                case 3:
                    return editor.putLong(string, bundle.getLong("key_value"));
                case 4:
                    return editor.putFloat(string, bundle.getFloat("key_value"));
                case 5:
                    return editor.putBoolean(string, bundle.getBoolean("key_value"));
                case 6:
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("key_value");
                    return stringArrayList == null ? editor.putStringSet(string, (Set) null) : editor.putStringSet(string, new HashSet(stringArrayList));
                default:
                    throw new IllegalArgumentException("unknown valueType:" + i);
            }
        }

        public final Bundle a(@Nullable String str, @Nullable Bundle bundle) {
            if (bundle == null) {
                throw new IllegalArgumentException("methodQueryValues, extras is null!");
            }
            Context context = SharedPreferenceProvider.this.getContext();
            if (context == null) {
                throw new IllegalArgumentException("methodQueryValues, ctx is null!");
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(b.g);
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList();
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator it = parcelableArrayList.iterator();
            while (true) {
                HashSet hashSet = null;
                if (it.hasNext()) {
                    Bundle bundle2 = (Bundle) it.next();
                    int i = bundle2.getInt("key_op_type");
                    switch (i) {
                        case 2:
                            String string = bundle2.getString("key_key");
                            int i2 = bundle2.getInt("key_value_type");
                            switch (i2) {
                                case 1:
                                    edit = edit.putString(string, bundle2.getString("key_value"));
                                    break;
                                case 2:
                                    edit = edit.putInt(string, bundle2.getInt("key_value"));
                                    break;
                                case 3:
                                    edit = edit.putLong(string, bundle2.getLong("key_value"));
                                    break;
                                case 4:
                                    edit = edit.putFloat(string, bundle2.getFloat("key_value"));
                                    break;
                                case 5:
                                    edit = edit.putBoolean(string, bundle2.getBoolean("key_value"));
                                    break;
                                case 6:
                                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("key_value");
                                    if (stringArrayList != null) {
                                        hashSet = new HashSet(stringArrayList);
                                    }
                                    edit = edit.putStringSet(string, hashSet);
                                    break;
                                default:
                                    throw new IllegalArgumentException("unknown valueType:" + i2);
                            }
                        case 3:
                            edit = edit.clear();
                            break;
                        case 4:
                            edit = edit.remove(bundle2.getString("key_key"));
                            break;
                        default:
                            throw new IllegalArgumentException("unkonw op type:" + i);
                    }
                } else {
                    int i3 = bundle.getInt("key_op_type");
                    if (i3 == 6) {
                        edit.apply();
                        return null;
                    } else if (i3 == 5) {
                        boolean commit = edit.commit();
                        Bundle bundle3 = new Bundle();
                        bundle3.putBoolean(b.g, commit);
                        return bundle3;
                    } else {
                        throw new IllegalArgumentException("unknown applyOrCommit:" + i3);
                    }
                }
            }
        }
    };

    public interface a {
        Bundle a(@Nullable String str, @Nullable Bundle bundle);
    }

    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        a aVar = this.f1591a.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.a(str2, bundle);
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    public boolean onCreate() {
        this.f1591a.put(b.d, this.f1593c);
        this.f1591a.put(b.f1601a, this.d);
        this.f1591a.put(b.e, this.e);
        this.f1591a.put(b.f, this.f1592b);
        return true;
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        throw new UnsupportedOperationException();
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
