package com.cyjh.elfin.ui.adpter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.ywfzjbcy.R;
import java.util.ArrayList;

public class TabAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Fragment> f2237a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f2238b;

    /* renamed from: c  reason: collision with root package name */
    private Context f2239c;

    public TabAdapter(Context context, FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
        super(fragmentManager);
        this.f2239c = context;
        this.f2237a = arrayList;
        this.f2238b = context.getResources().getStringArray(R.array.array_pagetitles_name);
    }

    public int getCount() {
        return this.f2237a.size();
    }

    public Fragment getItem(int i) {
        return this.f2237a.get(i);
    }

    public CharSequence getPageTitle(int i) {
        return this.f2238b[i];
    }
}
