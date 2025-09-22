package com.cyjh.feedback.lib.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.os.EnvironmentCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.cyjh.common.util.aa;
import com.cyjh.feedback.lib.a.b;
import com.cyjh.feedback.lib.activity.ImageSelectActivity;
import com.cyjh.feedback.lib.b.b;
import com.cyjh.feedback.lib.b.c;
import com.cyjh.feedback.lib.base.BaseFragment;
import com.cyjh.feedback.libraryfeedbackinfo.R;
import com.cyjh.http.b.a;
import com.cyjh.http.bean.request.FeedbackRequestInfo;
import com.cyjh.http.c.c.k;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;

public class FeedBackInfoFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2434a = 256;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2435b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2436c = 1;
    public static final int d = 0;
    public static final String e = "feedbackTips";
    public static final String f = "isPhoneRoot";
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 8;
    private static final int l = 16;
    private static final int x = 4;
    private boolean A;
    private GridView m;
    private b n;
    /* access modifiers changed from: private */
    public List<String> o = new ArrayList();
    private EditText p;
    private EditText q;
    /* access modifiers changed from: private */
    public TextView r;
    /* access modifiers changed from: private */
    public TextView s;
    private c t;
    private FeedbackRequestInfo u;
    private TextView v;
    private View w;
    private k y;
    private String z;

    public static FeedBackInfoFragment a(String str, boolean z2) {
        FeedBackInfoFragment feedBackInfoFragment = new FeedBackInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(e, str);
        bundle.putBoolean(f, z2);
        feedBackInfoFragment.setArguments(bundle);
        return feedBackInfoFragment;
    }

    private String a(int i2) {
        int i3;
        if (i2 == 8) {
            i3 = R.string.cpu_core_eight;
        } else if (i2 != 16) {
            switch (i2) {
                case 1:
                    i3 = R.string.cpu_core_one;
                    break;
                case 2:
                    i3 = R.string.cpu_core_two;
                    break;
                case 3:
                    i3 = R.string.cpu_core_three;
                    break;
                case 4:
                    i3 = R.string.cpu_core_four;
                    break;
                default:
                    return null;
            }
        } else {
            i3 = R.string.cpu_core_sixteen;
        }
        return getString(i3);
    }

    private void a(View view) {
        this.m = (GridView) view.findViewById(R.id.grid_view);
        this.p = (EditText) view.findViewById(R.id.id_et_qq_phone);
        this.q = (EditText) view.findViewById(R.id.id_et_feedback);
        this.r = (TextView) view.findViewById(R.id.id_tv_image_num);
        this.s = (TextView) view.findViewById(R.id.id_tv_feedback_input_font_num);
        this.n = new b(getActivity());
        this.m.setAdapter(this.n);
        ((Button) view.findViewById(R.id.id_btn_commit_feedback)).setOnClickListener(this);
        this.r.setText(getString(R.string.image_add, Integer.valueOf(this.o.size())));
        this.s.setText(getString(R.string.feedback_num_hint, 0));
        this.v = (TextView) view.findViewById(R.id.id_complaints_qq);
        this.w = view.findViewById(R.id.id_line);
    }

    private void b() {
        com.cyjh.feedback.lib.b.b bVar = new com.cyjh.feedback.lib.b.b(getActivity(), this.u, this.o);
        bVar.show();
        bVar.f2390c = new b.a() {
            public final void a(int i) {
                FragmentActivity activity;
                int i2;
                if (FeedBackInfoFragment.this.getActivity() != null) {
                    FeedBackInfoFragment.this.o.clear();
                    if (i == 1) {
                        activity = FeedBackInfoFragment.this.getActivity();
                        i2 = -1;
                    } else {
                        activity = FeedBackInfoFragment.this.getActivity();
                        i2 = 0;
                    }
                    activity.setResult(i2);
                    FeedBackInfoFragment.this.getActivity().finish();
                }
            }
        };
    }

    private void c() {
        this.t = new c(getActivity());
        if (!TextUtils.isEmpty(this.z)) {
            this.w.setVisibility(0);
            this.v.setText(this.z);
            this.v.setVisibility(0);
            return;
        }
        this.v.setVisibility(8);
        this.w.setVisibility(8);
    }

    private void d() {
        this.q.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FeedBackInfoFragment.this.s.setText(FeedBackInfoFragment.this.getString(R.string.feedback_num_hint, Integer.valueOf(charSequence.length())));
            }
        });
        this.m.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == FeedBackInfoFragment.this.o.size()) {
                    FeedBackInfoFragment.this.startActivityForResult(new Intent(FeedBackInfoFragment.this.getActivity(), ImageSelectActivity.class), 256);
                }
            }
        });
        this.n.f2381b = new b.a() {
            public final void a(int i) {
                FeedBackInfoFragment.this.r.setText(FeedBackInfoFragment.this.getString(R.string.image_add, Integer.valueOf(i)));
            }
        };
    }

    private void e() {
        if (this.u == null) {
            this.t.dismiss();
            return;
        }
        if (TextUtils.isEmpty(this.u.Contact)) {
            this.u.Contact = "0";
        }
        if (TextUtils.isEmpty(this.u.Content)) {
            this.u.Content = "0";
        }
        if (TextUtils.isEmpty(this.u.AndoridVersion)) {
            this.u.AndoridVersion = "0";
        }
        if (TextUtils.isEmpty(this.u.CoreVersion)) {
            this.u.CoreVersion = "0";
        }
        if (TextUtils.isEmpty(this.u.SerialNumber)) {
            this.u.SerialNumber = "0";
        }
        this.t.dismiss();
        com.cyjh.feedback.lib.b.b bVar = new com.cyjh.feedback.lib.b.b(getActivity(), this.u, this.o);
        bVar.show();
        bVar.f2390c = new b.a() {
            public final void a(int i) {
                FragmentActivity activity;
                int i2;
                if (FeedBackInfoFragment.this.getActivity() != null) {
                    FeedBackInfoFragment.this.o.clear();
                    if (i == 1) {
                        activity = FeedBackInfoFragment.this.getActivity();
                        i2 = -1;
                    } else {
                        activity = FeedBackInfoFragment.this.getActivity();
                        i2 = 0;
                    }
                    activity.setResult(i2);
                    FeedBackInfoFragment.this.getActivity().finish();
                }
            }
        };
    }

    private void f() {
        String str;
        int i2;
        String trim = this.p.getText().toString().trim();
        String trim2 = this.q.getText().toString().trim();
        if (!TextUtils.isEmpty(trim) || !TextUtils.isEmpty(trim2)) {
            if (this.u == null) {
                this.u = new FeedbackRequestInfo(a.a().b(getActivity()));
            }
            this.u.Contact = trim;
            this.u.Content = trim2;
            this.u.AndoridVersion = Build.VERSION.RELEASE;
            this.u.DeviceModel = Build.MODEL;
            if (this.A) {
                this.u.RootStatus = 1;
            } else {
                this.u.RootStatus = 0;
            }
            int i3 = com.cyjh.http.e.a.b((Context) getActivity()).x;
            int i4 = com.cyjh.http.e.a.b((Context) getActivity()).y;
            this.u.Resolution = i3 + Marker.ANY_MARKER + i4;
            getActivity();
            this.u.RAM = Formatter.formatFileSize(getActivity(), com.cyjh.http.e.a.a());
            FeedbackRequestInfo feedbackRequestInfo = this.u;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            feedbackRequestInfo.DPI = displayMetrics.densityDpi;
            this.u.SerialNumber = Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
            this.u.CoreVersion = com.cyjh.http.e.a.b();
            FeedbackRequestInfo feedbackRequestInfo2 = this.u;
            String a2 = aa.a("ro.miui.ui.version.name");
            aa.h = a2;
            if (!TextUtils.isEmpty(a2)) {
                str = aa.f1643a;
            } else {
                String a3 = aa.a("ro.build.version.emui");
                aa.h = a3;
                if (!TextUtils.isEmpty(a3)) {
                    str = aa.f1644b;
                } else {
                    String a4 = aa.a("ro.build.version.opporom");
                    aa.h = a4;
                    if (!TextUtils.isEmpty(a4)) {
                        str = aa.d;
                    } else {
                        String a5 = aa.a("ro.vivo.os.version");
                        aa.h = a5;
                        if (!TextUtils.isEmpty(a5)) {
                            str = aa.f;
                        } else {
                            String a6 = aa.a("ro.smartisan.version");
                            aa.h = a6;
                            if (!TextUtils.isEmpty(a6)) {
                                str = aa.e;
                            } else {
                                String str2 = Build.DISPLAY;
                                aa.h = str2;
                                if (str2.toUpperCase().contains(aa.f1645c)) {
                                    str = aa.f1645c;
                                } else {
                                    aa.h = EnvironmentCompat.MEDIA_UNKNOWN;
                                    str = Build.MANUFACTURER.toUpperCase();
                                    if (TextUtils.isEmpty(str)) {
                                        str = "0";
                                    }
                                }
                            }
                        }
                    }
                }
            }
            feedbackRequestInfo2.SystemVersion = str;
            int a7 = com.cyjh.feedback.lib.e.a.a();
            String str3 = null;
            if (a7 == 8) {
                i2 = R.string.cpu_core_eight;
            } else if (a7 != 16) {
                switch (a7) {
                    case 1:
                        i2 = R.string.cpu_core_one;
                        break;
                    case 2:
                        i2 = R.string.cpu_core_two;
                        break;
                    case 3:
                        i2 = R.string.cpu_core_three;
                        break;
                    case 4:
                        i2 = R.string.cpu_core_four;
                        break;
                }
            } else {
                i2 = R.string.cpu_core_sixteen;
            }
            str3 = getString(i2);
            String b2 = com.cyjh.feedback.lib.e.a.b();
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(b2)) {
                str3 = str3 + "，CPU型号：" + b2;
            } else if (TextUtils.isEmpty(str3) || !TextUtils.isEmpty(b2)) {
                if (!TextUtils.isEmpty(str3) || TextUtils.isEmpty(b2)) {
                    str3 = "0";
                } else {
                    str3 = "CPU型号：" + b2;
                }
            }
            this.u.Processor = str3;
            return;
        }
        Toast.makeText(getActivity(), getString(R.string.no_fill_info), 1).show();
    }

    public final int a() {
        return R.layout.fragment_feedback_info;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.y = new k();
        this.y.a((Context) getActivity());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        ArrayList<String> stringArrayList;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 256 && i3 == -1 && intent != null && (stringArrayList = intent.getBundleExtra("bundle").getStringArrayList("image")) != null) {
            int size = this.o.size();
            if (stringArrayList.size() + size > 4) {
                Toast.makeText(getActivity(), getString(R.string.img_num_limit, Integer.valueOf(size), Integer.valueOf(4 - size)), 1).show();
                stringArrayList.clear();
                return;
            }
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.o.contains(next)) {
                    this.o.add(next);
                }
            }
            this.r.setText(getString(R.string.image_add, Integer.valueOf(this.o.size())));
            this.n.f2380a = this.o;
            this.m.setAdapter(this.n);
            this.n.notifyDataSetChanged();
        }
    }

    public void onClick(View view) {
        String str;
        int i2;
        if (view.getId() == R.id.id_btn_commit_feedback) {
            this.t.show();
            String trim = this.p.getText().toString().trim();
            String trim2 = this.q.getText().toString().trim();
            if (!TextUtils.isEmpty(trim) || !TextUtils.isEmpty(trim2)) {
                if (this.u == null) {
                    this.u = new FeedbackRequestInfo(a.a().b(getActivity()));
                }
                this.u.Contact = trim;
                this.u.Content = trim2;
                this.u.AndoridVersion = Build.VERSION.RELEASE;
                this.u.DeviceModel = Build.MODEL;
                if (this.A) {
                    this.u.RootStatus = 1;
                } else {
                    this.u.RootStatus = 0;
                }
                int i3 = com.cyjh.http.e.a.b((Context) getActivity()).x;
                int i4 = com.cyjh.http.e.a.b((Context) getActivity()).y;
                this.u.Resolution = i3 + Marker.ANY_MARKER + i4;
                getActivity();
                this.u.RAM = Formatter.formatFileSize(getActivity(), com.cyjh.http.e.a.a());
                FeedbackRequestInfo feedbackRequestInfo = this.u;
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                feedbackRequestInfo.DPI = displayMetrics.densityDpi;
                this.u.SerialNumber = Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
                this.u.CoreVersion = com.cyjh.http.e.a.b();
                FeedbackRequestInfo feedbackRequestInfo2 = this.u;
                String a2 = aa.a("ro.miui.ui.version.name");
                aa.h = a2;
                if (!TextUtils.isEmpty(a2)) {
                    str = aa.f1643a;
                } else {
                    String a3 = aa.a("ro.build.version.emui");
                    aa.h = a3;
                    if (!TextUtils.isEmpty(a3)) {
                        str = aa.f1644b;
                    } else {
                        String a4 = aa.a("ro.build.version.opporom");
                        aa.h = a4;
                        if (!TextUtils.isEmpty(a4)) {
                            str = aa.d;
                        } else {
                            String a5 = aa.a("ro.vivo.os.version");
                            aa.h = a5;
                            if (!TextUtils.isEmpty(a5)) {
                                str = aa.f;
                            } else {
                                String a6 = aa.a("ro.smartisan.version");
                                aa.h = a6;
                                if (!TextUtils.isEmpty(a6)) {
                                    str = aa.e;
                                } else {
                                    String str2 = Build.DISPLAY;
                                    aa.h = str2;
                                    if (str2.toUpperCase().contains(aa.f1645c)) {
                                        str = aa.f1645c;
                                    } else {
                                        aa.h = EnvironmentCompat.MEDIA_UNKNOWN;
                                        str = Build.MANUFACTURER.toUpperCase();
                                        if (TextUtils.isEmpty(str)) {
                                            str = "0";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                feedbackRequestInfo2.SystemVersion = str;
                int a7 = com.cyjh.feedback.lib.e.a.a();
                String str3 = null;
                if (a7 == 8) {
                    i2 = R.string.cpu_core_eight;
                } else if (a7 != 16) {
                    switch (a7) {
                        case 1:
                            i2 = R.string.cpu_core_one;
                            break;
                        case 2:
                            i2 = R.string.cpu_core_two;
                            break;
                        case 3:
                            i2 = R.string.cpu_core_three;
                            break;
                        case 4:
                            i2 = R.string.cpu_core_four;
                            break;
                    }
                } else {
                    i2 = R.string.cpu_core_sixteen;
                }
                str3 = getString(i2);
                String b2 = com.cyjh.feedback.lib.e.a.b();
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(b2)) {
                    str3 = str3 + "，CPU型号：" + b2;
                } else if (TextUtils.isEmpty(str3) || !TextUtils.isEmpty(b2)) {
                    if (!TextUtils.isEmpty(str3) || TextUtils.isEmpty(b2)) {
                        str3 = "0";
                    } else {
                        str3 = "CPU型号：" + b2;
                    }
                }
                this.u.Processor = str3;
            } else {
                Toast.makeText(getActivity(), getString(R.string.no_fill_info), 1).show();
            }
            if (this.u == null) {
                this.t.dismiss();
                return;
            }
            if (TextUtils.isEmpty(this.u.Contact)) {
                this.u.Contact = "0";
            }
            if (TextUtils.isEmpty(this.u.Content)) {
                this.u.Content = "0";
            }
            if (TextUtils.isEmpty(this.u.AndoridVersion)) {
                this.u.AndoridVersion = "0";
            }
            if (TextUtils.isEmpty(this.u.CoreVersion)) {
                this.u.CoreVersion = "0";
            }
            if (TextUtils.isEmpty(this.u.SerialNumber)) {
                this.u.SerialNumber = "0";
            }
            this.t.dismiss();
            com.cyjh.feedback.lib.b.b bVar = new com.cyjh.feedback.lib.b.b(getActivity(), this.u, this.o);
            bVar.show();
            bVar.f2390c = new b.a() {
                public final void a(int i) {
                    FragmentActivity activity;
                    int i2;
                    if (FeedBackInfoFragment.this.getActivity() != null) {
                        FeedBackInfoFragment.this.o.clear();
                        if (i == 1) {
                            activity = FeedBackInfoFragment.this.getActivity();
                            i2 = -1;
                        } else {
                            activity = FeedBackInfoFragment.this.getActivity();
                            i2 = 0;
                        }
                        activity.setResult(i2);
                        FeedBackInfoFragment.this.getActivity().finish();
                    }
                }
            };
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.z = getArguments().getString(e);
            this.A = getArguments().getBoolean(f);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.y != null) {
            k.a();
        }
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(FeedBackInfoFragment.class.getCanonicalName());
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(FeedBackInfoFragment.class.getCanonicalName());
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m = (GridView) view.findViewById(R.id.grid_view);
        this.p = (EditText) view.findViewById(R.id.id_et_qq_phone);
        this.q = (EditText) view.findViewById(R.id.id_et_feedback);
        this.r = (TextView) view.findViewById(R.id.id_tv_image_num);
        this.s = (TextView) view.findViewById(R.id.id_tv_feedback_input_font_num);
        this.n = new com.cyjh.feedback.lib.a.b(getActivity());
        this.m.setAdapter(this.n);
        ((Button) view.findViewById(R.id.id_btn_commit_feedback)).setOnClickListener(this);
        this.r.setText(getString(R.string.image_add, Integer.valueOf(this.o.size())));
        this.s.setText(getString(R.string.feedback_num_hint, 0));
        this.v = (TextView) view.findViewById(R.id.id_complaints_qq);
        this.w = view.findViewById(R.id.id_line);
        this.t = new c(getActivity());
        if (!TextUtils.isEmpty(this.z)) {
            this.w.setVisibility(0);
            this.v.setText(this.z);
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
            this.w.setVisibility(8);
        }
        this.q.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                FeedBackInfoFragment.this.s.setText(FeedBackInfoFragment.this.getString(R.string.feedback_num_hint, Integer.valueOf(charSequence.length())));
            }
        });
        this.m.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == FeedBackInfoFragment.this.o.size()) {
                    FeedBackInfoFragment.this.startActivityForResult(new Intent(FeedBackInfoFragment.this.getActivity(), ImageSelectActivity.class), 256);
                }
            }
        });
        this.n.f2381b = new b.a() {
            public final void a(int i) {
                FeedBackInfoFragment.this.r.setText(FeedBackInfoFragment.this.getString(R.string.image_add, Integer.valueOf(i)));
            }
        };
    }
}
