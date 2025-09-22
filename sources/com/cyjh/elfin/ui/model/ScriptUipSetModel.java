package com.cyjh.elfin.ui.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.cyjh.common.util.n;
import com.cyjh.common.util.o;
import com.cyjh.elfin.entity.ParamsWrap;
import com.elfin.engin.d;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;

public class ScriptUipSetModel extends AndroidViewModel {

    /* renamed from: a  reason: collision with root package name */
    public b f2283a;

    /* renamed from: b  reason: collision with root package name */
    public MutableLiveData<Integer> f2284b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private a f2285c;
    private c d;

    private static class a extends AsyncTask<InputStream, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private File[] f2286a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<ScriptUipSetModel> f2287b;

        private a(ScriptUipSetModel scriptUipSetModel, File... fileArr) {
            this.f2287b = new WeakReference<>(scriptUipSetModel);
            this.f2286a = fileArr;
        }

        /* synthetic */ a(ScriptUipSetModel scriptUipSetModel, File[] fileArr, byte b2) {
            this(scriptUipSetModel, fileArr);
        }

        private Boolean a(InputStream... inputStreamArr) {
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles doInBackground 1\n", "UTF-8");
            for (int i = 0; i < inputStreamArr.length; i++) {
                if (inputStreamArr[i] != null) {
                    o.a(inputStreamArr[i], this.f2286a[i]);
                }
            }
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles doInBackground 2\n", "UTF-8");
            if (((ScriptUipSetModel) this.f2287b.get()) != null && com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getUipFile().exists() && com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getUipFile().length() > 0) {
                d.a(this.f2286a[0].getAbsolutePath(), ParamsWrap.getParamsWrap().getScriptEncryptKey());
            }
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles doInBackground 3\n", "UTF-8");
            return true;
        }

        private void a() {
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles onPostExecute 1\n", "UTF-8");
            ScriptUipSetModel scriptUipSetModel = (ScriptUipSetModel) this.f2287b.get();
            if (scriptUipSetModel != null) {
                scriptUipSetModel.f2284b.postValue(0);
            }
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles onPostExecute 2\n", "UTF-8");
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            InputStream[] inputStreamArr = (InputStream[]) objArr;
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles doInBackground 1\n", "UTF-8");
            for (int i = 0; i < inputStreamArr.length; i++) {
                if (inputStreamArr[i] != null) {
                    o.a(inputStreamArr[i], this.f2286a[i]);
                }
            }
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles doInBackground 2\n", "UTF-8");
            if (((ScriptUipSetModel) this.f2287b.get()) != null && com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getUipFile().exists() && com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getUipFile().length() > 0) {
                d.a(this.f2286a[0].getAbsolutePath(), ParamsWrap.getParamsWrap().getScriptEncryptKey());
            }
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles doInBackground 3\n", "UTF-8");
            return true;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles onPostExecute 1\n", "UTF-8");
            ScriptUipSetModel scriptUipSetModel = (ScriptUipSetModel) this.f2287b.get();
            if (scriptUipSetModel != null) {
                scriptUipSetModel.f2284b.postValue(0);
            }
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles onPostExecute 2\n", "UTF-8");
        }
    }

    private class b implements Runnable {
        private b() {
        }

        public /* synthetic */ b(ScriptUipSetModel scriptUipSetModel, byte b2) {
            this();
        }

        public final void run() {
            try {
                ScriptUipSetModel.this.c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class c extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private File f2289a;

        /* renamed from: b  reason: collision with root package name */
        private File f2290b;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<ScriptUipSetModel> f2291c;

        private c(ScriptUipSetModel scriptUipSetModel, File... fileArr) {
            this.f2291c = new WeakReference<>(scriptUipSetModel);
            this.f2289a = fileArr[0];
            this.f2290b = fileArr[1];
        }

        /* synthetic */ c(ScriptUipSetModel scriptUipSetModel, File[] fileArr, byte b2) {
            this(scriptUipSetModel, fileArr);
        }

        private Boolean a() {
            if (((ScriptUipSetModel) this.f2291c.get()) != null && this.f2290b.exists() && this.f2290b.length() > 0) {
                d.a(this.f2289a.getAbsolutePath(), ParamsWrap.getParamsWrap().getScriptEncryptKey());
            }
            return true;
        }

        private void b() {
            ScriptUipSetModel scriptUipSetModel = (ScriptUipSetModel) this.f2291c.get();
            if (scriptUipSetModel != null) {
                scriptUipSetModel.f2284b.postValue(0);
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            if (((ScriptUipSetModel) this.f2291c.get()) != null && this.f2290b.exists() && this.f2290b.length() > 0) {
                d.a(this.f2289a.getAbsolutePath(), ParamsWrap.getParamsWrap().getScriptEncryptKey());
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            ScriptUipSetModel scriptUipSetModel = (ScriptUipSetModel) this.f2291c.get();
            if (scriptUipSetModel != null) {
                scriptUipSetModel.f2284b.postValue(0);
            }
        }
    }

    public ScriptUipSetModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<Integer> d() {
        return this.f2284b;
    }

    private void e() {
        if (com.cyjh.elfin.floatingwindowprocess.c.c.f().f2012c) {
            n.b(new File("/sdcard/elf11.txt"), "sdCardScriptFiles\n", "UTF-8");
            String a2 = com.cyjh.elfin.e.c.o.a(getApplication());
            try {
                this.d = new c(this, new File[]{new File(a2, com.cyjh.elfin.a.a.n), new File(a2, com.cyjh.elfin.a.a.r)}, (byte) 0);
                this.d.executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles\n", "UTF-8");
            n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles start\n", "UTF-8");
            AssetManager assets = getApplication().getAssets();
            File lcFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getLcFile();
            File propFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getPropFile();
            File atcFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getAtcFile();
            File uipFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getUipFile();
            File rtdFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getRtdFile();
            File file = new File("/sdcard/elf11.txt");
            n.b(file, "lcFile = " + lcFile.getAbsolutePath() + "\npropFile = " + propFile.getAbsolutePath() + "\natcFile = " + atcFile.getAbsolutePath() + "\nuipFile = " + uipFile.getAbsolutePath() + "\nrtdFile = " + rtdFile.getAbsolutePath() + "\n", "UTF-8");
            try {
                InputStream open = assets.open(com.cyjh.elfin.a.a.n);
                InputStream open2 = assets.open(com.cyjh.elfin.a.a.o);
                InputStream open3 = assets.open(com.cyjh.elfin.a.a.p);
                InputStream open4 = assets.open(com.cyjh.elfin.a.a.r);
                InputStream open5 = assets.open(com.cyjh.elfin.a.a.s);
                this.f2285c = new a(this, new File[]{lcFile, propFile, atcFile, rtdFile, uipFile}, (byte) 0);
                this.f2285c.executeOnExecutor(Executors.newCachedThreadPool(), new InputStream[]{open, open2, open3, open5, open4});
            } catch (IOException e2) {
                IOException iOException = e2;
                File file2 = new File("/sdcard/elf11.txt");
                n.b(file2, "copyScriptFiles error" + iOException.getMessage() + "\n", "UTF-8");
                iOException.printStackTrace();
            }
        }
    }

    private static void f() {
    }

    private void g() {
        this.f2283a = new b(this, (byte) 0);
        com.cyjh.feedback.lib.d.b.a().a(this.f2283a);
    }

    public final void a() {
        String a2 = com.cyjh.elfin.e.c.o.a(getApplication());
        try {
            this.d = new c(this, new File[]{new File(a2, com.cyjh.elfin.a.a.n), new File(a2, com.cyjh.elfin.a.a.r)}, (byte) 0);
            this.d.executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        n.b(new File("/sdcard/elf11.txt"), "copyScriptFiles start\n", "UTF-8");
        AssetManager assets = getApplication().getAssets();
        File lcFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getLcFile();
        File propFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getPropFile();
        File atcFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getAtcFile();
        File uipFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getUipFile();
        File rtdFile = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a.getRtdFile();
        File file = new File("/sdcard/elf11.txt");
        n.b(file, "lcFile = " + lcFile.getAbsolutePath() + "\npropFile = " + propFile.getAbsolutePath() + "\natcFile = " + atcFile.getAbsolutePath() + "\nuipFile = " + uipFile.getAbsolutePath() + "\nrtdFile = " + rtdFile.getAbsolutePath() + "\n", "UTF-8");
        try {
            InputStream open = assets.open(com.cyjh.elfin.a.a.n);
            InputStream open2 = assets.open(com.cyjh.elfin.a.a.o);
            InputStream open3 = assets.open(com.cyjh.elfin.a.a.p);
            InputStream open4 = assets.open(com.cyjh.elfin.a.a.r);
            InputStream open5 = assets.open(com.cyjh.elfin.a.a.s);
            this.f2285c = new a(this, new File[]{lcFile, propFile, atcFile, rtdFile, uipFile}, (byte) 0);
            this.f2285c.executeOnExecutor(Executors.newCachedThreadPool(), new InputStream[]{open, open2, open3, open5, open4});
        } catch (IOException e) {
            File file2 = new File("/sdcard/elf11.txt");
            n.b(file2, "copyScriptFiles error" + e.getMessage() + "\n", "UTF-8");
            e.printStackTrace();
        }
    }

    public final void c() throws Exception {
        if (this.f2284b != null) {
            this.f2284b.postValue(1);
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        if (this.f2283a != null) {
            com.cyjh.feedback.lib.d.a a2 = com.cyjh.feedback.lib.d.b.a();
            b bVar = this.f2283a;
            if (bVar != null) {
                a2.f2407a.remove(bVar);
            }
        }
        if (this.f2285c != null) {
            this.f2285c.cancel(false);
            this.f2285c = null;
        }
    }
}
