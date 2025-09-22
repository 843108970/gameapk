package com.cyjh.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1674a = "ElfinCompat";

    private static Intent a(Context context) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        } else if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent("android.intent.action.GET_CONTENT");
        } else {
            intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addFlags(3);
            intent.setType("image/*");
            return intent;
        }
        intent.addCategory("android.intent.category.OPENABLE");
        intent.addFlags(3);
        intent.setType("image/*");
        return intent;
    }

    private static void a(Activity activity, int i) {
        activity.startActivityForResult(a(activity), i);
    }

    private static void a(Fragment fragment, int i) {
        fragment.startActivityForResult(a(fragment.getActivity()), i);
    }
}
