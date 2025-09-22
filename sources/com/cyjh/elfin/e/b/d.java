package com.cyjh.elfin.e.b;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.cyjh.common.util.ad;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.http.c.c.k;
import com.cyjh.http.c.c.q;
import com.cyjh.http.oss.MyOSSUtils;
import com.ywfzjbcy.R;
import java.io.File;

public final class d extends AsyncTask<String, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1903a = "MyAsyncTask";

    public interface a {
        void a();
    }

    private String a(String... strArr) {
        k kVar;
        String str = strArr[0];
        TextUtils.isEmpty(str);
        File file = new File(strArr[0]);
        if (file.exists() && file.length() > 0) {
            if (com.cyjh.http.b.a.a().d == null) {
                kVar = new k();
            } else if (!TextUtils.isEmpty(com.cyjh.http.b.a.a().d.OssStudioScreenshotPathF)) {
                final String str2 = com.cyjh.http.b.a.a().d.OssStudioScreenshotPathF.replace("{AppId}", AppContext.a().getString(R.string.elfin_appid)).replace("{ScriptId}", c.f().f2011a.getId()).replace("{DeviceId}", com.cyjh.http.e.a.c(AppContext.a()).DeviceId) + File.separator + System.currentTimeMillis() + ".png";
                ad.c(f1903a, "objectKey=" + str2);
                MyOSSUtils build = new MyOSSUtils.Builder(AppContext.a(), com.cyjh.http.b.a.a().d).build();
                if (build.isTokenExpireTime()) {
                    kVar = new k();
                } else {
                    build.uploadFile(str, str2, new MyOSSUtils.UploadFileCallBack() {
                        public final void uploadFail(String str) {
                            ad.c(d.f1903a, "uploadFail -- > 上传图片失败 fileName=" + str);
                        }

                        public final void uploadProgress(long j, long j2) {
                        }

                        public final void uploadSuc(String str, String str2) {
                            ad.c(d.f1903a, "uploadSuc -- > 上传图片成功 serverUrl=" + str);
                            q.a().a(AppContext.a(), c.f().f2011a.getId(), r7, new q.a() {
                                public final void a() {
                                }

                                public final void b() {
                                }
                            });
                        }
                    });
                    return str;
                }
            }
            kVar.a((Context) AppContext.a());
        }
        return str;
    }

    private static void a() {
    }

    private void a(String str, String str2) {
        q.a().a(AppContext.a(), str, str2, new q.a() {
            public final void a() {
            }

            public final void b() {
            }
        });
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        k kVar;
        String[] strArr = (String[]) objArr;
        String str = strArr[0];
        TextUtils.isEmpty(str);
        File file = new File(strArr[0]);
        if (file.exists() && file.length() > 0) {
            if (com.cyjh.http.b.a.a().d == null) {
                kVar = new k();
            } else if (!TextUtils.isEmpty(com.cyjh.http.b.a.a().d.OssStudioScreenshotPathF)) {
                final String str2 = com.cyjh.http.b.a.a().d.OssStudioScreenshotPathF.replace("{AppId}", AppContext.a().getString(R.string.elfin_appid)).replace("{ScriptId}", c.f().f2011a.getId()).replace("{DeviceId}", com.cyjh.http.e.a.c(AppContext.a()).DeviceId) + File.separator + System.currentTimeMillis() + ".png";
                ad.c(f1903a, "objectKey=" + str2);
                MyOSSUtils build = new MyOSSUtils.Builder(AppContext.a(), com.cyjh.http.b.a.a().d).build();
                if (build.isTokenExpireTime()) {
                    kVar = new k();
                } else {
                    build.uploadFile(str, str2, new MyOSSUtils.UploadFileCallBack() {
                        public final void uploadFail(String str) {
                            ad.c(d.f1903a, "uploadFail -- > 上传图片失败 fileName=" + str);
                        }

                        public final void uploadProgress(long j, long j2) {
                        }

                        public final void uploadSuc(String str, String str2) {
                            ad.c(d.f1903a, "uploadSuc -- > 上传图片成功 serverUrl=" + str);
                            q.a().a(AppContext.a(), c.f().f2011a.getId(), str2, new q.a() {
                                public final void a() {
                                }

                                public final void b() {
                                }
                            });
                        }
                    });
                    return str;
                }
            }
            kVar.a((Context) AppContext.a());
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }
}
