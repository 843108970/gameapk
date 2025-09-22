package com.cyjh.elfin.e.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.n;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.c.o;
import com.cyjh.elfin.floatingwindowprocess.c.c;
import com.cyjh.http.c.c.k;
import com.cyjh.http.c.c.q;
import com.cyjh.http.oss.MyOSSUtils;
import com.cyjh.mobileanjian.ipc.interfaces.OnScreenShotCallback;
import com.cyjh.mq.sdk.MqRunner;
import com.google.protobuf.ByteString;
import com.ywfzjbcy.R;
import java.io.File;

public final class b extends AsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1893a = "MyAsyncTask";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f1894b;

    public interface a {
        void a();
    }

    private b(a aVar) {
        this.f1894b = aVar;
    }

    private String a() {
        final String absolutePath = n.a(AppContext.a().getPackageName(), "screen_capture.png").getAbsolutePath();
        MqRunner.getInstance().a((OnScreenShotCallback) new OnScreenShotCallback() {
            public final void onScreenShotDone(String str, ByteString byteString) {
                int intValue = Integer.valueOf(str).intValue();
                int i = 65535 & intValue;
                int i2 = intValue >> 16;
                ad.c(b.f1893a, "onScreenShotDone -->　width=" + i2 + ",height = " + i);
                Bitmap a2 = o.a(i2, i, byteString);
                if (a2 != null) {
                    n.a(a2, r3);
                    File file = new File(r3);
                    if (file.exists() && file.length() > 0) {
                        if (com.cyjh.http.b.a.a().d == null) {
                            if (b.this.f1894b != null) {
                                a unused = b.this.f1894b;
                            }
                            new k().a((Context) AppContext.a());
                        } else if (!TextUtils.isEmpty(com.cyjh.http.b.a.a().d.OssStudioScreenshotPathF)) {
                            final String str2 = com.cyjh.http.b.a.a().d.OssStudioScreenshotPathF.replace("{AppId}", AppContext.a().getString(R.string.elfin_appid)).replace("{ScriptId}", c.f().f2011a.getId()).replace("{DeviceId}", com.cyjh.http.e.a.c(AppContext.a()).DeviceId) + File.separator + System.currentTimeMillis() + ".png";
                            ad.c(b.f1893a, "objectKey=" + str2);
                            MyOSSUtils build = new MyOSSUtils.Builder(AppContext.a(), com.cyjh.http.b.a.a().d).build();
                            if (build.isTokenExpireTime()) {
                                if (b.this.f1894b != null) {
                                    a unused2 = b.this.f1894b;
                                }
                                new k().a((Context) AppContext.a());
                                return;
                            }
                            build.uploadFile(r3, str2, new MyOSSUtils.UploadFileCallBack() {
                                public final void uploadFail(String str) {
                                    ad.c(b.f1893a, "uploadFail -- > 上传图片失败 fileName=" + str);
                                }

                                public final void uploadProgress(long j, long j2) {
                                }

                                public final void uploadSuc(String str, String str2) {
                                    ad.c(b.f1893a, "uploadSuc -- > 上传图片成功 serverUrl=" + str);
                                    q.a().a(AppContext.a(), c.f().f2011a.getId(), str2, new q.a() {
                                        public final void a() {
                                        }

                                        public final void b() {
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
            }

            public final void onScreenShotFailed(int i) {
            }
        });
        return absolutePath;
    }

    private void a(String str, String str2) {
        q.a().a(AppContext.a(), str, str2, new q.a() {
            public final void a() {
            }

            public final void b() {
            }
        });
    }

    private static void b() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        final String absolutePath = n.a(AppContext.a().getPackageName(), "screen_capture.png").getAbsolutePath();
        MqRunner.getInstance().a((OnScreenShotCallback) new OnScreenShotCallback() {
            public final void onScreenShotDone(String str, ByteString byteString) {
                int intValue = Integer.valueOf(str).intValue();
                int i = 65535 & intValue;
                int i2 = intValue >> 16;
                ad.c(b.f1893a, "onScreenShotDone -->　width=" + i2 + ",height = " + i);
                Bitmap a2 = o.a(i2, i, byteString);
                if (a2 != null) {
                    n.a(a2, absolutePath);
                    File file = new File(absolutePath);
                    if (file.exists() && file.length() > 0) {
                        if (com.cyjh.http.b.a.a().d == null) {
                            if (b.this.f1894b != null) {
                                a unused = b.this.f1894b;
                            }
                            new k().a((Context) AppContext.a());
                        } else if (!TextUtils.isEmpty(com.cyjh.http.b.a.a().d.OssStudioScreenshotPathF)) {
                            final String str2 = com.cyjh.http.b.a.a().d.OssStudioScreenshotPathF.replace("{AppId}", AppContext.a().getString(R.string.elfin_appid)).replace("{ScriptId}", c.f().f2011a.getId()).replace("{DeviceId}", com.cyjh.http.e.a.c(AppContext.a()).DeviceId) + File.separator + System.currentTimeMillis() + ".png";
                            ad.c(b.f1893a, "objectKey=" + str2);
                            MyOSSUtils build = new MyOSSUtils.Builder(AppContext.a(), com.cyjh.http.b.a.a().d).build();
                            if (build.isTokenExpireTime()) {
                                if (b.this.f1894b != null) {
                                    a unused2 = b.this.f1894b;
                                }
                                new k().a((Context) AppContext.a());
                                return;
                            }
                            build.uploadFile(absolutePath, str2, new MyOSSUtils.UploadFileCallBack() {
                                public final void uploadFail(String str) {
                                    ad.c(b.f1893a, "uploadFail -- > 上传图片失败 fileName=" + str);
                                }

                                public final void uploadProgress(long j, long j2) {
                                }

                                public final void uploadSuc(String str, String str2) {
                                    ad.c(b.f1893a, "uploadSuc -- > 上传图片成功 serverUrl=" + str);
                                    q.a().a(AppContext.a(), c.f().f2011a.getId(), str2, new q.a() {
                                        public final void a() {
                                        }

                                        public final void b() {
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
            }

            public final void onScreenShotFailed(int i) {
            }
        });
        return absolutePath;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }
}
