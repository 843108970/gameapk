package com.cyjh.elfin.ui.view.customview.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyjh.elfin.ui.view.customview.FindErrorView;
import com.ywfzjbcy.R;

public final class g {
    private static View a(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.load_error_view, (ViewGroup) null);
    }

    private static View a(Context context, View view) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.load_loading_view, (ViewGroup) null);
        inflate.setVisibility(8);
        a(inflate, view);
        return inflate;
    }

    private static View a(Context context, View view, View.OnClickListener onClickListener) {
        FindErrorView findErrorView = new FindErrorView(context);
        findErrorView.setErrorImg(R.drawable.icon_null);
        findErrorView.setErrorTips(R.string.load_data_empty);
        ((TextView) findErrorView.findViewById(R.id.vel_error_btn)).setOnClickListener(onClickListener);
        findErrorView.setVisibility(8);
        a((View) findErrorView, view);
        return findErrorView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: android.widget.LinearLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.widget.RelativeLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: android.widget.LinearLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: android.widget.LinearLayout$LayoutParams} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.view.View r2, android.view.View r3) {
        /*
            android.view.ViewParent r3 = r3.getParent()
            android.view.View r3 = (android.view.View) r3
            if (r3 == 0) goto L_0x004b
            boolean r0 = r3 instanceof android.widget.RelativeLayout
            r1 = -1
            if (r0 == 0) goto L_0x0028
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.addView(r2)
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            r3.<init>(r0)
            r0 = 13
            r3.addRule(r0, r1)
            r3.width = r1
            r3.height = r1
        L_0x0024:
            r2.setLayoutParams(r3)
            return
        L_0x0028:
            boolean r0 = r3 instanceof android.widget.LinearLayout
            if (r0 == 0) goto L_0x0043
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r3.addView(r2)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            r3.<init>(r0)
            r3.width = r1
            r3.height = r1
            r0 = 17
            r3.gravity = r0
            goto L_0x0024
        L_0x0043:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "ParentView must be a RelativeLayout or LinearLayout!!!"
            r2.<init>(r3)
            throw r2
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.ui.view.customview.a.g.a(android.view.View, android.view.View):void");
    }

    private static View b(Context context, View view) {
        FindErrorView findErrorView = new FindErrorView(context);
        findErrorView.setErrorImg(R.drawable.bg_none_script);
        findErrorView.setErrorTips(R.string.notoolbox_text);
        findErrorView.findViewById(R.id.vel_error_btn).setVisibility(8);
        findErrorView.setVisibility(8);
        a((View) findErrorView, view);
        return findErrorView;
    }

    private static View b(Context context, View view, View.OnClickListener onClickListener) {
        FindErrorView findErrorView = new FindErrorView(context);
        findErrorView.setErrorImg(R.drawable.icon_net_instability);
        findErrorView.setErrorTips(R.string.load_data_error);
        ((TextView) findErrorView.findViewById(R.id.vel_error_btn)).setOnClickListener(onClickListener);
        findErrorView.setVisibility(8);
        a((View) findErrorView, view);
        return findErrorView;
    }

    private static View c(Context context, View view) {
        FindErrorView findErrorView = new FindErrorView(context);
        findErrorView.setVisibility(8);
        a((View) findErrorView, view);
        return findErrorView;
    }

    private static View c(Context context, View view, View.OnClickListener onClickListener) {
        FindErrorView findErrorView = new FindErrorView(context);
        ((TextView) findErrorView.findViewById(R.id.vel_error_btn)).setOnClickListener(onClickListener);
        findErrorView.setVisibility(8);
        a((View) findErrorView, view);
        return findErrorView;
    }
}
