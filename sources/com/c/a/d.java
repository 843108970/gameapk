package com.c.a;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.c.b.c;
import org.apache.http.HttpRequest;

public final class d extends a implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public AccountManager f1523a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Account f1524b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f1525c;
    /* access modifiers changed from: private */
    public Activity d;
    private String e;
    private Account[] f;
    /* access modifiers changed from: private */
    public String g;

    private class a extends AsyncTask<String, String, Bundle> {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        private Bundle a() {
            try {
                return d.this.f1523a.getAuthToken(d.this.f1524b, d.this.f1525c, (Bundle) null, d.this.d, (AccountManagerCallback) null, (Handler) null).getResult();
            } catch (OperationCanceledException unused) {
                return null;
            } catch (AuthenticatorException | Exception e) {
                com.c.d.a.a(e);
                return null;
            }
        }

        private void a(Bundle bundle) {
            if (bundle == null || !bundle.containsKey("authtoken")) {
                d.this.a((int) c.g, "rejected");
                return;
            }
            d.this.g = bundle.getString("authtoken");
            d.this.a((Context) d.this.d);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object... objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Bundle bundle = (Bundle) obj;
            if (bundle == null || !bundle.containsKey("authtoken")) {
                d.this.a((int) c.g, "rejected");
                return;
            }
            d.this.g = bundle.getString("authtoken");
            d.this.a((Context) d.this.d);
        }
    }

    public d(Activity activity, String str, String str2) {
        str2 = com.c.d.d.E.equals(str2) ? PreferenceManager.getDefaultSharedPreferences(activity).getString(com.c.d.d.E, (String) null) : str2;
        this.d = activity;
        this.f1525c = str.substring(2);
        this.e = str2;
        this.f1523a = AccountManager.get(activity);
    }

    private void a(Account account) {
        this.f1524b = account;
        new a(this, (byte) 0).execute(new String[0]);
    }

    private static void a(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(com.c.d.d.E, str).commit();
    }

    private static String b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(com.c.d.d.E, (String) null);
    }

    private String d() {
        return this.f1525c;
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        this.f = this.f1523a.getAccountsByType("com.google");
        int length = this.f.length;
        if (length == 1) {
            a(this.f[0]);
            return;
        }
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = this.f[i].name;
        }
        builder.setItems(strArr, this);
        builder.setOnCancelListener(this);
        new com.c.a(this.d).a((Dialog) builder.create());
    }

    public final void a(com.c.b.a<?, ?> aVar, HttpRequest httpRequest) {
        httpRequest.addHeader("Authorization", "GoogleLogin auth=" + this.g);
    }

    public final boolean a() {
        return this.g != null;
    }

    public final boolean a(com.c.b.a<?, ?> aVar, c cVar) {
        int i = cVar.i;
        return i == 401 || i == 403;
    }

    public final String b(String str) {
        return String.valueOf(str) + "#" + this.g;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        int i = 0;
        if (this.e == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
            this.f = this.f1523a.getAccountsByType("com.google");
            int length = this.f.length;
            if (length == 1) {
                a(this.f[0]);
                return;
            }
            String[] strArr = new String[length];
            while (i < length) {
                strArr[i] = this.f[i].name;
                i++;
            }
            builder.setItems(strArr, this);
            builder.setOnCancelListener(this);
            new com.c.a(this.d).a((Dialog) builder.create());
            return;
        }
        Account[] accountsByType = this.f1523a.getAccountsByType("com.google");
        while (i < accountsByType.length) {
            Account account = accountsByType[i];
            if (this.e.equals(account.name)) {
                a(account);
                return;
            }
            i++;
        }
    }

    public final boolean b(com.c.b.a<?, ?> aVar) {
        this.f1523a.invalidateAuthToken(this.f1524b.type, this.g);
        try {
            this.g = this.f1523a.blockingGetAuthToken(this.f1524b, this.f1525c, true);
            com.c.d.a.b((Object) "re token", (Object) this.g);
        } catch (Exception e2) {
            com.c.d.a.a((Throwable) e2);
            this.g = null;
        }
        return this.g != null;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a((int) c.g, "cancel");
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Account account = this.f[i];
        com.c.d.a.b((Object) "acc", (Object) account.name);
        Activity activity = this.d;
        PreferenceManager.getDefaultSharedPreferences(activity).edit().putString(com.c.d.d.E, account.name).commit();
        a(account);
    }
}
