package com.cyjh.feedback.lib.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import com.cyjh.feedback.lib.a.a;
import com.cyjh.feedback.lib.base.BaseFragment;
import com.cyjh.feedback.lib.c.b;
import com.cyjh.feedback.libraryfeedbackinfo.R;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ImageSelectFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2441a = 272;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2442b = ",";

    /* renamed from: c  reason: collision with root package name */
    private GridView f2443c;
    /* access modifiers changed from: private */
    public List<b> d;
    private a e;
    /* access modifiers changed from: private */
    public Button f;
    private ArrayList<String> g;
    private List<String> h;
    /* access modifiers changed from: private */
    public File i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public ProgressDialog k;
    /* access modifiers changed from: private */
    public Handler l = new Handler() {
        public final void handleMessage(Message message) {
            ImageSelectFragment.this.k.dismiss();
            ImageSelectFragment.a(ImageSelectFragment.this, (b) message.obj);
        }
    };

    private void a(View view) {
        this.g = new ArrayList<>();
        this.f2443c = (GridView) view.findViewById(R.id.grid_view);
        this.h = new ArrayList();
        this.d = new ArrayList();
        this.f = (Button) view.findViewById(R.id.id_btn_sure);
        this.f.setText(getString(R.string.btn_sure, Integer.valueOf(this.g.size())));
        this.f.setOnClickListener(this);
    }

    private void a(b bVar) {
        if (TextUtils.isEmpty(bVar.f2400a)) {
            Toast.makeText(getActivity(), getString(R.string.no_everything_picture), 0).show();
        } else if (this.i == null) {
            Toast.makeText(getActivity(), getString(R.string.no_everything_picture), 1).show();
        } else if (this.h == null || this.h.size() > 0) {
            this.e = new a(getActivity(), this.h);
            this.f2443c.setAdapter(this.e);
            this.e.notifyDataSetChanged();
            this.e.f2372b = new a.C0034a() {
                public final void a(int i) {
                    ImageSelectFragment.this.f.setText(ImageSelectFragment.this.getString(R.string.btn_sure, Integer.valueOf(i)));
                }
            };
        } else {
            Toast.makeText(getActivity(), getString(R.string.no_everything_picture), 1).show();
        }
    }

    static /* synthetic */ void a(ImageSelectFragment imageSelectFragment, b bVar) {
        if (TextUtils.isEmpty(bVar.f2400a)) {
            Toast.makeText(imageSelectFragment.getActivity(), imageSelectFragment.getString(R.string.no_everything_picture), 0).show();
        } else if (imageSelectFragment.i == null) {
            Toast.makeText(imageSelectFragment.getActivity(), imageSelectFragment.getString(R.string.no_everything_picture), 1).show();
        } else if (imageSelectFragment.h == null || imageSelectFragment.h.size() > 0) {
            imageSelectFragment.e = new a(imageSelectFragment.getActivity(), imageSelectFragment.h);
            imageSelectFragment.f2443c.setAdapter(imageSelectFragment.e);
            imageSelectFragment.e.notifyDataSetChanged();
            imageSelectFragment.e.f2372b = new a.C0034a() {
                public final void a(int i) {
                    ImageSelectFragment.this.f.setText(ImageSelectFragment.this.getString(R.string.btn_sure, Integer.valueOf(i)));
                }
            };
        } else {
            Toast.makeText(imageSelectFragment.getActivity(), imageSelectFragment.getString(R.string.no_everything_picture), 1).show();
        }
    }

    static /* synthetic */ boolean a(String str) {
        return str.toLowerCase().endsWith(".jpg") || str.toLowerCase().endsWith(".jpeg") || str.toLowerCase().endsWith(".png");
    }

    public static ImageSelectFragment b() {
        return new ImageSelectFragment();
    }

    private void b(b bVar) {
        this.h.clear();
        for (String str : bVar.f2400a.split(f2442b)) {
            String[] list = new File(str).list(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return ImageSelectFragment.a(str);
                }
            });
            if (list != null) {
                for (String str2 : list) {
                    this.h.add(str + File.separator + str2);
                }
            }
        }
    }

    static /* synthetic */ void b(ImageSelectFragment imageSelectFragment, b bVar) {
        imageSelectFragment.h.clear();
        for (String str : bVar.f2400a.split(f2442b)) {
            String[] list = new File(str).list(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return ImageSelectFragment.a(str);
                }
            });
            if (list != null) {
                for (String str2 : list) {
                    imageSelectFragment.h.add(str + File.separator + str2);
                }
            }
        }
    }

    private static boolean b(String str) {
        return str.toLowerCase().endsWith(".jpg") || str.toLowerCase().endsWith(".jpeg") || str.toLowerCase().endsWith(".png");
    }

    private void c() {
        this.e.f2372b = new a.C0034a() {
            public final void a(int i) {
                ImageSelectFragment.this.f.setText(ImageSelectFragment.this.getString(R.string.btn_sure, Integer.valueOf(i)));
            }
        };
    }

    private void d() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            Toast.makeText(getActivity(), getString(R.string.no_sdk), 1).show();
            return;
        }
        this.k = ProgressDialog.show(getActivity(), (CharSequence) null, getString(R.string.loading_somethings));
        new Thread() {
            public final void run() {
                Cursor query = ImageSelectFragment.this.getActivity().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String[]) null, "mime_type= ? or mime_type=?", new String[]{"image/jpeg", "image/png"}, "date_modified");
                HashSet hashSet = new HashSet();
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("_data"));
                    File parentFile = new File(string).getParentFile();
                    if (parentFile != null) {
                        String absolutePath = parentFile.getAbsolutePath();
                        if (!hashSet.contains(absolutePath)) {
                            hashSet.add(absolutePath);
                            b bVar = new b();
                            bVar.a(absolutePath);
                            bVar.f2402c = string;
                            if (parentFile.list() != null) {
                                int length = parentFile.list(new FilenameFilter() {
                                    public final boolean accept(File file, String str) {
                                        return ImageSelectFragment.a(str);
                                    }
                                }).length;
                                if (length > ImageSelectFragment.this.j) {
                                    int unused = ImageSelectFragment.this.j = length;
                                    File unused2 = ImageSelectFragment.this.i = parentFile;
                                }
                                bVar.d = length;
                                ImageSelectFragment.this.d.add(bVar);
                            }
                        }
                    }
                }
                query.close();
                b bVar2 = new b();
                if (ImageSelectFragment.this.d != null && ImageSelectFragment.this.d.size() > 0) {
                    bVar2.f2401b = ImageSelectFragment.this.getString(R.string.all_photo_mobile);
                    bVar2.f2402c = ((b) ImageSelectFragment.this.d.get(0)).f2402c;
                }
                String str = "";
                int i = 0;
                for (b bVar3 : ImageSelectFragment.this.d) {
                    str = str + bVar3.f2400a + ImageSelectFragment.f2442b;
                    i += bVar3.d;
                }
                bVar2.d = i;
                bVar2.a(str);
                ImageSelectFragment.this.d.add(0, bVar2);
                ImageSelectFragment.b(ImageSelectFragment.this, bVar2);
                Message obtainMessage = ImageSelectFragment.this.l.obtainMessage();
                obtainMessage.what = 272;
                obtainMessage.obj = bVar2;
                ImageSelectFragment.this.l.sendMessage(obtainMessage);
            }
        }.start();
    }

    public final int a() {
        return R.layout.fragment_select_image;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.id_btn_sure && this.e != null) {
            if (this.e.f2371a.size() <= 0) {
                Toast.makeText(getActivity(), getString(R.string.please_choose_photo), 1).show();
                return;
            }
            for (String add : this.e.f2371a) {
                this.g.add(add);
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("image", this.g);
            intent.putExtra("bundle", bundle);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(ImageSelectFragment.class.getCanonicalName());
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(ImageSelectFragment.class.getCanonicalName());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.g = new ArrayList<>();
        this.f2443c = (GridView) view.findViewById(R.id.grid_view);
        this.h = new ArrayList();
        this.d = new ArrayList();
        this.f = (Button) view.findViewById(R.id.id_btn_sure);
        this.f.setText(getString(R.string.btn_sure, Integer.valueOf(this.g.size())));
        this.f.setOnClickListener(this);
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            Toast.makeText(getActivity(), getString(R.string.no_sdk), 1).show();
            return;
        }
        this.k = ProgressDialog.show(getActivity(), (CharSequence) null, getString(R.string.loading_somethings));
        new Thread() {
            public final void run() {
                Cursor query = ImageSelectFragment.this.getActivity().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String[]) null, "mime_type= ? or mime_type=?", new String[]{"image/jpeg", "image/png"}, "date_modified");
                HashSet hashSet = new HashSet();
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("_data"));
                    File parentFile = new File(string).getParentFile();
                    if (parentFile != null) {
                        String absolutePath = parentFile.getAbsolutePath();
                        if (!hashSet.contains(absolutePath)) {
                            hashSet.add(absolutePath);
                            b bVar = new b();
                            bVar.a(absolutePath);
                            bVar.f2402c = string;
                            if (parentFile.list() != null) {
                                int length = parentFile.list(new FilenameFilter() {
                                    public final boolean accept(File file, String str) {
                                        return ImageSelectFragment.a(str);
                                    }
                                }).length;
                                if (length > ImageSelectFragment.this.j) {
                                    int unused = ImageSelectFragment.this.j = length;
                                    File unused2 = ImageSelectFragment.this.i = parentFile;
                                }
                                bVar.d = length;
                                ImageSelectFragment.this.d.add(bVar);
                            }
                        }
                    }
                }
                query.close();
                b bVar2 = new b();
                if (ImageSelectFragment.this.d != null && ImageSelectFragment.this.d.size() > 0) {
                    bVar2.f2401b = ImageSelectFragment.this.getString(R.string.all_photo_mobile);
                    bVar2.f2402c = ((b) ImageSelectFragment.this.d.get(0)).f2402c;
                }
                String str = "";
                int i = 0;
                for (b bVar3 : ImageSelectFragment.this.d) {
                    str = str + bVar3.f2400a + ImageSelectFragment.f2442b;
                    i += bVar3.d;
                }
                bVar2.d = i;
                bVar2.a(str);
                ImageSelectFragment.this.d.add(0, bVar2);
                ImageSelectFragment.b(ImageSelectFragment.this, bVar2);
                Message obtainMessage = ImageSelectFragment.this.l.obtainMessage();
                obtainMessage.what = 272;
                obtainMessage.obj = bVar2;
                ImageSelectFragment.this.l.sendMessage(obtainMessage);
            }
        }.start();
    }
}
