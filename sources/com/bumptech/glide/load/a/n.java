package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class n extends l<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1004a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f1005b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f1006c = 3;
    private static final int d = 4;
    private static final int e = 5;
    private static final UriMatcher f;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f.addURI("com.android.contacts", "contacts/#/photo", 2);
        f.addURI("com.android.contacts", "contacts/#", 3);
        f.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private static InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    private static void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.InputStream b(android.net.Uri r3, android.content.ContentResolver r4) throws java.io.FileNotFoundException {
        /*
            android.content.UriMatcher r0 = f
            int r0 = r0.match(r3)
            r1 = 1
            if (r0 == r1) goto L_0x0019
            r2 = 3
            if (r0 == r2) goto L_0x0014
            r2 = 5
            if (r0 == r2) goto L_0x0019
            java.io.InputStream r4 = r4.openInputStream(r3)
            goto L_0x002b
        L_0x0014:
            java.io.InputStream r4 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r4, r3, r1)
            goto L_0x002b
        L_0x0019:
            android.net.Uri r0 = android.provider.ContactsContract.Contacts.lookupContact(r4, r3)
            if (r0 != 0) goto L_0x0027
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            java.lang.String r4 = "Contact cannot be found"
            r3.<init>(r4)
            throw r3
        L_0x0027:
            java.io.InputStream r4 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r4, r0, r1)
        L_0x002b:
            if (r4 != 0) goto L_0x0041
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "InputStream is null for "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        L_0x0041:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.a.n.b(android.net.Uri, android.content.ContentResolver):java.io.InputStream");
    }

    private static InputStream c(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f.match(uri);
        if (match != 1) {
            if (match == 3) {
                return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    @NonNull
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(android.net.Uri r4, android.content.ContentResolver r5) throws java.io.FileNotFoundException {
        /*
            r3 = this;
            android.content.UriMatcher r0 = f
            int r0 = r0.match(r4)
            r1 = 1
            if (r0 == r1) goto L_0x0019
            r2 = 3
            if (r0 == r2) goto L_0x0014
            r2 = 5
            if (r0 == r2) goto L_0x0019
            java.io.InputStream r5 = r5.openInputStream(r4)
            goto L_0x002b
        L_0x0014:
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r5, r4, r1)
            goto L_0x002b
        L_0x0019:
            android.net.Uri r0 = android.provider.ContactsContract.Contacts.lookupContact(r5, r4)
            if (r0 != 0) goto L_0x0027
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException
            java.lang.String r5 = "Contact cannot be found"
            r4.<init>(r5)
            throw r4
        L_0x0027:
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r5, r0, r1)
        L_0x002b:
            if (r5 != 0) goto L_0x0041
            java.io.FileNotFoundException r5 = new java.io.FileNotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "InputStream is null for "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            throw r5
        L_0x0041:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.a.n.a(android.net.Uri, android.content.ContentResolver):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }
}
