package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1386a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f1387b = Charset.forName("UTF-8");

    void a(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
