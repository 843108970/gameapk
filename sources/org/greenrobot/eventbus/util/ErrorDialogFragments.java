package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public final class ErrorDialogFragments {

    /* renamed from: a  reason: collision with root package name */
    public static int f4337a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f4338b;

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.a(getActivity(), getArguments());
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static class Support extends android.support.v4.app.DialogFragment implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialogInterface, int i) {
            ErrorDialogFragments.a(getActivity(), getArguments());
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.d));
        builder.setMessage(bundle.getString(ErrorDialogManager.e));
        if (f4337a != 0) {
            builder.setIcon(f4337a);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void a(Activity activity, Bundle bundle) {
        if (f4338b != null) {
            try {
                ErrorDialogManager.f4339a.f4359a.a().c((Object) f4338b.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Event cannot be constructed", e);
            }
        }
        if (bundle.getBoolean(ErrorDialogManager.f, false) && activity != null) {
            activity.finish();
        }
    }
}
