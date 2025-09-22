package com.android.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final AccountManager f518a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f519b;

    /* renamed from: c  reason: collision with root package name */
    private final String f520c;
    private final boolean d;

    private a(AccountManager accountManager, Account account, String str) {
        this.f518a = accountManager;
        this.f519b = account;
        this.f520c = str;
        this.d = false;
    }

    private a(Context context, Account account, String str) {
        this(context, account, str, (byte) 0);
    }

    private a(Context context, Account account, String str, byte b2) {
        this(AccountManager.get(context), account, str);
    }

    private Account b() {
        return this.f519b;
    }

    public final String a() throws com.android.volley.a {
        AccountManagerFuture<Bundle> authToken = this.f518a.getAuthToken(this.f519b, this.f520c, this.d, (AccountManagerCallback) null, (Handler) null);
        try {
            Bundle result = authToken.getResult();
            String str = null;
            if (authToken.isDone() && !authToken.isCancelled()) {
                if (result.containsKey("intent")) {
                    throw new com.android.volley.a((Intent) result.getParcelable("intent"));
                }
                str = result.getString("authtoken");
            }
            if (str != null) {
                return str;
            }
            throw new com.android.volley.a("Got null auth token for type: " + this.f520c);
        } catch (Exception e) {
            throw new com.android.volley.a("Error while retrieving auth token", e);
        }
    }

    public final void a(String str) {
        this.f518a.invalidateAuthToken(this.f519b.type, str);
    }
}
