package com.lidroid.xutils.view;

import android.app.Activity;
import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.view.View;

public class ViewFinder {
    private Activity activity;
    private PreferenceActivity preferenceActivity;
    private PreferenceGroup preferenceGroup;
    private View view;

    public ViewFinder(Activity activity2) {
        this.activity = activity2;
    }

    public ViewFinder(PreferenceActivity preferenceActivity2) {
        this.preferenceActivity = preferenceActivity2;
        this.activity = preferenceActivity2;
    }

    public ViewFinder(PreferenceGroup preferenceGroup2) {
        this.preferenceGroup = preferenceGroup2;
    }

    public ViewFinder(View view2) {
        this.view = view2;
    }

    public Preference findPreference(CharSequence charSequence) {
        return this.preferenceGroup == null ? this.preferenceActivity.findPreference(charSequence) : this.preferenceGroup.findPreference(charSequence);
    }

    public View findViewById(int i) {
        return this.activity == null ? this.view.findViewById(i) : this.activity.findViewById(i);
    }

    public View findViewById(int i, int i2) {
        View findViewById = i2 > 0 ? findViewById(i2) : null;
        return findViewById != null ? findViewById.findViewById(i) : findViewById(i);
    }

    public View findViewByInfo(ViewInjectInfo viewInjectInfo) {
        return findViewById(((Integer) viewInjectInfo.value).intValue(), viewInjectInfo.parentId);
    }

    public Context getContext() {
        if (this.view != null) {
            return this.view.getContext();
        }
        if (this.activity != null) {
            return this.activity;
        }
        if (this.preferenceActivity != null) {
            return this.preferenceActivity;
        }
        return null;
    }
}
