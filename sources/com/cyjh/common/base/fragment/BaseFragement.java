package com.cyjh.common.base.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragement extends Fragment {
    private static void b() {
    }

    private static void c() {
    }

    public abstract int a();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(a(), viewGroup, false);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        setUserVisibleHint(true);
    }
}
