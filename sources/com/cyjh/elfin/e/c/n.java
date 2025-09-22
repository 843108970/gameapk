package com.cyjh.elfin.e.c;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import com.cyjh.common.util.ab;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.af;
import com.cyjh.common.util.ak;
import com.cyjh.common.util.toast.p;
import com.cyjh.common.util.u;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.http.bean.response.ProjectNumberInfo;
import com.cyjh.http.c.c.h;
import com.cyjh.http.e.b;
import com.cyjh.mq.sdk.MqRunner;
import java.io.File;
import java.util.concurrent.Executors;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static int f1929a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static int f1930b = 1001;

    /* renamed from: c  reason: collision with root package name */
    public static int f1931c = 1002;
    public static int d = 1003;
    public static int e = 1004;
    /* access modifiers changed from: private */
    public static String f = "n";
    private static n k;
    private Context g;
    private String h;
    private int i = f1931c;
    private Handler j;

    private class a extends AsyncTask<String, Integer, Void> {
        private a() {
        }

        /* synthetic */ a(n nVar, byte b2) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            try {
                String str = strArr[0];
                File a2 = com.cyjh.common.util.n.a(strArr[1], str.substring(str.lastIndexOf("/")));
                b.a().a(str, a2.getParentFile().getAbsolutePath(), a2.getName(), -1, new b.a() {

                    /* renamed from: b  reason: collision with root package name */
                    private long f1942b = 0;

                    public final void a(int i) {
                        String b2 = n.f;
                        ad.c(b2, "onDownloading --> progress=" + i);
                        long j = (long) i;
                        if (this.f1942b != j) {
                            this.f1942b = j;
                            a.this.publishProgress(new Integer[]{Integer.valueOf(i)});
                        }
                    }

                    public final void a(File file) {
                        String b2 = n.f;
                        ad.c(b2, "onDownloadSuccess --> file=" + file.getName());
                        this.f1942b = 0;
                        n.a(n.this, file);
                    }

                    public final void a(Exception exc) {
                        String b2 = n.f;
                        ad.c(b2, "onDownloadFailed --> exception=" + exc.getMessage());
                        n.a(n.this);
                    }
                });
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        private void a(Integer... numArr) {
            super.onProgressUpdate(numArr);
            String b2 = n.f;
            ad.c(b2, "onProgressUpdate --> progress=" + numArr[0]);
            p.b((CharSequence) "正在更新脚本(" + numArr[0] + "%)");
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onProgressUpdate(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            super.onProgressUpdate(numArr);
            String b2 = n.f;
            ad.c(b2, "onProgressUpdate --> progress=" + numArr[0]);
            p.b((CharSequence) "正在更新脚本(" + numArr[0] + "%)");
        }
    }

    private n() {
    }

    public static n a() {
        if (k == null) {
            synchronized (n.class) {
                if (k == null) {
                    k = new n();
                }
            }
        }
        return k;
    }

    static /* synthetic */ void a(n nVar) {
        nVar.j.post(new Runnable() {
            public final void run() {
                p.a((CharSequence) "脚本更新失败，请重启小精灵进行更新");
            }
        });
        if (nVar.i != f1929a) {
            f.a();
            f.a(AppContext.a(), "ScriptDownloadHelper  afterDownloadFailure -->");
            af.a().a(af.a().c());
        }
    }

    static /* synthetic */ void a(n nVar, File file) {
        ad.c(f, "afterDownloadSuccess --> 1 开始解压……");
        boolean a2 = ak.a(file, com.cyjh.common.util.n.a(nVar.g, com.cyjh.elfin.a.b.au));
        String str = f;
        ad.c(str, "afterDownloadSuccess --> 2 解压是否成功：" + a2);
        if (a2) {
            nVar.j.post(new Runnable() {
                public final void run() {
                    p.a((CharSequence) "脚本更新完成");
                }
            });
            com.cyjh.common.util.n.c(file);
            ad.c(f, "afterDownloadSuccess --> 3 initScript");
            String id = c.f().f2011a.getId();
            String str2 = f;
            ad.c(str2, "afterDownloadSuccess --> 3 initScript script beforeUpdateScriptId :" + id);
            c.f().b();
            k.a(1);
            af.a().b(af.a().b());
            String str3 = f;
            ad.c(str3, "afterDownloadSuccess --> 3 initScript mCurrentType:" + nVar.i);
            final String id2 = c.f().f2011a.getId();
            String str4 = f;
            ad.c(str4, "afterDownloadSuccess --> 3 initScript script afterUpdateScriptId :" + id2);
            if (!id.equals(id2) && !TextUtils.isEmpty(AppContext.a().e)) {
                h.a().a(AppContext.a(), id, new h.a() {
                    public final void a(ProjectNumberInfo projectNumberInfo) {
                        ad.c(n.f, "afterDownloadSuccess --> 3 unbindStudioProject onSuccess");
                        String str = r1;
                        final String str2 = AppContext.a().e;
                        String b2 = o.b(AppContext.a(), c.f().f2012c);
                        String a2 = o.a(AppContext.a(), c.f().f2012c);
                        final String b3 = o.b(AppContext.a());
                        h.a().a(AppContext.a(), str2, str, b2, a2, b3, new h.a() {
                            public final void a(ProjectNumberInfo projectNumberInfo) {
                                ad.c(n.f, "afterDownloadSuccess --> 3 bindStudioProject onSuccess");
                                AppContext.a().e = str2;
                                h.a().f2497b = null;
                                ab.a().a(com.cyjh.elfin.a.a.H, u.a(b3));
                                org.greenrobot.eventbus.c.a().c((Object) new com.elf.studio.a.b(10001, projectNumberInfo.IMToken));
                            }

                            public final void a(String str) {
                                h.a().f2497b = null;
                            }
                        });
                    }

                    public final void a(String str) {
                    }
                });
            }
            if (nVar.i != f1929a && nVar.i == d) {
                if (MqRunner.getInstance().isScriptStarted()) {
                    MqRunner.getInstance().stop();
                    String str5 = f;
                    ad.c(str5, "stop --> 3 initScript mCurrentType:" + nVar.i);
                }
                org.greenrobot.eventbus.c.a().c((Object) new MsgItem(MsgItem.SCRIPT_NEED_START));
            }
            if (e == nVar.i) {
                org.greenrobot.eventbus.c.a().c((Object) new MsgItem(MsgItem.SCRIPT_NEED_START));
            }
            org.greenrobot.eventbus.c.a().c((Object) new com.cyjh.common.e.b(nVar.i));
            org.greenrobot.eventbus.c.a().c((Object) new com.cyjh.common.e.a());
            org.greenrobot.eventbus.c.a().c((Object) new MsgItem(1008));
            return;
        }
        nVar.j.post(new Runnable() {
            public final void run() {
                p.a((CharSequence) "脚本更新失败，请重启小精灵进行更新");
            }
        });
        if (nVar.i != f1929a) {
            af.a().a(af.a().c());
        }
    }

    private void a(File file) {
        ad.c(f, "afterDownloadSuccess --> 1 开始解压……");
        boolean a2 = ak.a(file, com.cyjh.common.util.n.a(this.g, com.cyjh.elfin.a.b.au));
        String str = f;
        ad.c(str, "afterDownloadSuccess --> 2 解压是否成功：" + a2);
        if (a2) {
            this.j.post(new Runnable() {
                public final void run() {
                    p.a((CharSequence) "脚本更新完成");
                }
            });
            com.cyjh.common.util.n.c(file);
            ad.c(f, "afterDownloadSuccess --> 3 initScript");
            String id = c.f().f2011a.getId();
            String str2 = f;
            ad.c(str2, "afterDownloadSuccess --> 3 initScript script beforeUpdateScriptId :" + id);
            c.f().b();
            k.a(1);
            af.a().b(af.a().b());
            String str3 = f;
            ad.c(str3, "afterDownloadSuccess --> 3 initScript mCurrentType:" + this.i);
            final String id2 = c.f().f2011a.getId();
            String str4 = f;
            ad.c(str4, "afterDownloadSuccess --> 3 initScript script afterUpdateScriptId :" + id2);
            if (!id.equals(id2) && !TextUtils.isEmpty(AppContext.a().e)) {
                h.a().a(AppContext.a(), id, new h.a() {
                    public final void a(ProjectNumberInfo projectNumberInfo) {
                        ad.c(n.f, "afterDownloadSuccess --> 3 unbindStudioProject onSuccess");
                        String str = r1;
                        final String str2 = AppContext.a().e;
                        String b2 = o.b(AppContext.a(), c.f().f2012c);
                        String a2 = o.a(AppContext.a(), c.f().f2012c);
                        final String b3 = o.b(AppContext.a());
                        h.a().a(AppContext.a(), str2, str, b2, a2, b3, new h.a() {
                            public final void a(ProjectNumberInfo projectNumberInfo) {
                                ad.c(n.f, "afterDownloadSuccess --> 3 bindStudioProject onSuccess");
                                AppContext.a().e = str2;
                                h.a().f2497b = null;
                                ab.a().a(com.cyjh.elfin.a.a.H, u.a(b3));
                                org.greenrobot.eventbus.c.a().c((Object) new com.elf.studio.a.b(10001, projectNumberInfo.IMToken));
                            }

                            public final void a(String str) {
                                h.a().f2497b = null;
                            }
                        });
                    }

                    public final void a(String str) {
                    }
                });
            }
            if (this.i != f1929a && this.i == d) {
                if (MqRunner.getInstance().isScriptStarted()) {
                    MqRunner.getInstance().stop();
                    String str5 = f;
                    ad.c(str5, "stop --> 3 initScript mCurrentType:" + this.i);
                }
                org.greenrobot.eventbus.c.a().c((Object) new MsgItem(MsgItem.SCRIPT_NEED_START));
            }
            if (e == this.i) {
                org.greenrobot.eventbus.c.a().c((Object) new MsgItem(MsgItem.SCRIPT_NEED_START));
            }
            org.greenrobot.eventbus.c.a().c((Object) new com.cyjh.common.e.b(this.i));
            org.greenrobot.eventbus.c.a().c((Object) new com.cyjh.common.e.a());
            org.greenrobot.eventbus.c.a().c((Object) new MsgItem(1008));
            return;
        }
        this.j.post(new Runnable() {
            public final void run() {
                p.a((CharSequence) "脚本更新失败，请重启小精灵进行更新");
            }
        });
        if (this.i != f1929a) {
            af.a().a(af.a().c());
        }
    }

    private void b(String str) {
        String str2 = this.g.getPackageName() + File.separator + com.cyjh.elfin.a.b.as;
        ad.c(f, "scriptDownloadTask --> path=" + str2 + ",scriptDownloadUrl = " + str);
        f.a();
        f.a(AppContext.a(), "ScriptDownloadHelper  scriptDownloadTask --> path=" + str2 + ",scriptDownloadUrl=" + str);
        p.a((CharSequence) "脚本开始热更新");
        new a(this, (byte) 0).executeOnExecutor(Executors.newCachedThreadPool(), new String[]{str, str2});
    }

    private void c() {
        this.j.post(new Runnable() {
            public final void run() {
                p.a((CharSequence) "脚本更新失败，请重启小精灵进行更新");
            }
        });
        if (this.i != f1929a) {
            f.a();
            f.a(AppContext.a(), "ScriptDownloadHelper  afterDownloadFailure -->");
            af.a().a(af.a().c());
        }
    }

    private void d() {
        String id = c.f().f2011a.getId();
        String str = f;
        ad.c(str, "afterDownloadSuccess --> 3 initScript script beforeUpdateScriptId :" + id);
        c.f().b();
        k.a(1);
        af a2 = af.a();
        String b2 = af.a().b();
        ad.b("setLastAppVersion", "appVersion:" + b2);
        if (a2.f1661a != null) {
            try {
                a2.f1661a.edit().putString(af.f1660c, b2).apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String str2 = f;
        ad.c(str2, "afterDownloadSuccess --> 3 initScript mCurrentType:" + this.i);
        final String id2 = c.f().f2011a.getId();
        String str3 = f;
        ad.c(str3, "afterDownloadSuccess --> 3 initScript script afterUpdateScriptId :" + id2);
        if (!id.equals(id2) && !TextUtils.isEmpty(AppContext.a().e)) {
            h.a().a(AppContext.a(), id, new h.a() {
                public final void a(ProjectNumberInfo projectNumberInfo) {
                    ad.c(n.f, "afterDownloadSuccess --> 3 unbindStudioProject onSuccess");
                    String str = id2;
                    final String str2 = AppContext.a().e;
                    String b2 = o.b(AppContext.a(), c.f().f2012c);
                    String a2 = o.a(AppContext.a(), c.f().f2012c);
                    final String b3 = o.b(AppContext.a());
                    h.a().a(AppContext.a(), str2, str, b2, a2, b3, new h.a() {
                        public final void a(ProjectNumberInfo projectNumberInfo) {
                            ad.c(n.f, "afterDownloadSuccess --> 3 bindStudioProject onSuccess");
                            AppContext.a().e = str2;
                            h.a().f2497b = null;
                            ab.a().a(com.cyjh.elfin.a.a.H, u.a(b3));
                            org.greenrobot.eventbus.c.a().c((Object) new com.elf.studio.a.b(10001, projectNumberInfo.IMToken));
                        }

                        public final void a(String str) {
                            h.a().f2497b = null;
                        }
                    });
                }

                public final void a(String str) {
                }
            });
        }
        if (this.i != f1929a && this.i == d) {
            if (MqRunner.getInstance().isScriptStarted()) {
                MqRunner.getInstance().stop();
                String str4 = f;
                ad.c(str4, "stop --> 3 initScript mCurrentType:" + this.i);
            }
            org.greenrobot.eventbus.c.a().c((Object) new MsgItem(MsgItem.SCRIPT_NEED_START));
        }
        if (e == this.i) {
            org.greenrobot.eventbus.c.a().c((Object) new MsgItem(MsgItem.SCRIPT_NEED_START));
        }
        org.greenrobot.eventbus.c.a().c((Object) new com.cyjh.common.e.b(this.i));
        org.greenrobot.eventbus.c.a().c((Object) new com.cyjh.common.e.a());
    }

    public final n a(Context context, String str, int i2) {
        f.a();
        AppContext a2 = AppContext.a();
        f.a(a2, "ScriptDownloadHelper  init --> type=" + i2);
        this.g = context;
        if (this.j == null) {
            this.j = new Handler(this.g.getMainLooper());
        }
        this.h = str;
        this.i = i2;
        return this;
    }

    public final void a(String str) {
        if (this.i != f1929a) {
            b(str);
        } else if (!MqRunner.getInstance().isScriptStarted()) {
            b(str);
        }
    }
}
