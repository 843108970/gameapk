package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.b;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.g;
import com.umeng.commonsdk.statistics.internal.d;

public class ABTest implements d {
    private static ABTest instance;
    private Context context = null;
    private boolean isInTest = false;
    private int mGroup = -1;
    private int mInterval = -1;
    private String mPoli = null;
    private int mPolicy = -1;
    private float mProb07 = 0.0f;
    private float mProb13 = 0.0f;

    private ABTest(Context context2, String str, int i) {
        this.context = context2;
        onExperimentChanged(str, i);
    }

    public static synchronized ABTest getService(Context context2) {
        ABTest aBTest;
        synchronized (ABTest.class) {
            if (instance == null) {
                instance = new ABTest(context2, UMEnvelopeBuild.imprintProperty(context2, "client_test", (String) null), Integer.valueOf(UMEnvelopeBuild.imprintProperty(context2, "test_report_interval", "0")).intValue());
            }
            aBTest = instance;
        }
        return aBTest;
    }

    private void parseFIXED(String str) {
        if (str != null) {
            String[] split = str.split("\\|");
            float f = 0.0f;
            if (split[2].equals("SIG13")) {
                f = Float.valueOf(split[3]).floatValue();
            }
            if (this.mProb13 > f) {
                this.isInTest = false;
                return;
            }
            int intValue = split[0].equals("FIXED") ? Integer.valueOf(split[1]).intValue() : -1;
            int[] iArr = null;
            if (split[4].equals("RPT")) {
                this.mPoli = "RPT";
                String[] split2 = split[5].split(",");
                iArr = new int[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    iArr[i] = Integer.valueOf(split2[i]).intValue();
                }
            } else if (split[4].equals("DOM")) {
                this.mPoli = "DOM";
                this.isInTest = true;
                try {
                    String[] split3 = split[5].split(",");
                    int[] iArr2 = new int[split3.length];
                    int i2 = 0;
                    while (i2 < split3.length) {
                        try {
                            iArr2[i2] = Integer.valueOf(split3[i2]).intValue();
                            i2++;
                        } catch (Exception unused) {
                        }
                    }
                    iArr = iArr2;
                } catch (Exception unused2) {
                }
            }
            if (intValue != -1) {
                this.isInTest = true;
                this.mGroup = intValue;
                if (iArr != null) {
                    this.mPolicy = iArr[intValue - 1];
                    return;
                }
                return;
            }
            this.isInTest = false;
        }
    }

    private void parseSig7(String str) {
        float[] fArr;
        if (str != null) {
            String[] split = str.split("\\|");
            float f = 0.0f;
            if (this.mProb13 > (split[2].equals("SIG13") ? Float.valueOf(split[3]).floatValue() : 0.0f)) {
                this.isInTest = false;
                return;
            }
            int[] iArr = null;
            if (split[0].equals("SIG7")) {
                String[] split2 = split[1].split(",");
                fArr = new float[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    fArr[i] = Float.valueOf(split2[i]).floatValue();
                }
            } else {
                fArr = null;
            }
            if (split[4].equals("RPT")) {
                this.mPoli = "RPT";
                String[] split3 = split[5].split(",");
                iArr = new int[split3.length];
                for (int i2 = 0; i2 < split3.length; i2++) {
                    iArr[i2] = Integer.valueOf(split3[i2]).intValue();
                }
            } else if (split[4].equals("DOM")) {
                this.isInTest = true;
                this.mPoli = "DOM";
                try {
                    String[] split4 = split[5].split(",");
                    int[] iArr2 = new int[split4.length];
                    int i3 = 0;
                    while (i3 < split4.length) {
                        try {
                            iArr2[i3] = Integer.valueOf(split4[i3]).intValue();
                            i3++;
                        } catch (Exception unused) {
                        }
                    }
                    iArr = iArr2;
                } catch (Exception unused2) {
                }
            }
            int i4 = 0;
            while (true) {
                if (i4 >= fArr.length) {
                    i4 = -1;
                    break;
                }
                f += fArr[i4];
                if (this.mProb07 < f) {
                    break;
                }
                i4++;
            }
            if (i4 != -1) {
                this.isInTest = true;
                this.mGroup = i4 + 1;
                if (iArr != null) {
                    this.mPolicy = iArr[i4];
                    return;
                }
                return;
            }
            this.isInTest = false;
        }
    }

    private float prob(String str, int i) {
        int i2 = i * 2;
        if (str == null) {
            return 0.0f;
        }
        return ((float) Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue()) / 1048576.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r0 = r6[5].split(",").length;
        r6 = java.lang.Integer.parseInt(r6[1]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean validate(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.String r0 = "\\|"
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r6.length
            r2 = 6
            if (r0 == r2) goto L_0x0013
            return r1
        L_0x0013:
            r0 = r6[r1]
            java.lang.String r2 = "SIG7"
            boolean r0 = r0.startsWith(r2)
            r2 = 5
            r3 = 1
            if (r0 == 0) goto L_0x0034
            r0 = r6[r3]
            java.lang.String r4 = ","
            java.lang.String[] r0 = r0.split(r4)
            int r0 = r0.length
            r4 = r6[r2]
            java.lang.String r5 = ","
            java.lang.String[] r4 = r4.split(r5)
            int r4 = r4.length
            if (r0 != r4) goto L_0x0034
            return r3
        L_0x0034:
            r0 = r6[r1]
            java.lang.String r4 = "FIXED"
            boolean r0 = r0.startsWith(r4)
            if (r0 == 0) goto L_0x0052
            r0 = r6[r2]
            java.lang.String r2 = ","
            java.lang.String[] r0 = r0.split(r2)
            int r0 = r0.length
            r6 = r6[r3]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r0 < r6) goto L_0x0052
            if (r6 <= 0) goto L_0x0052
            return r3
        L_0x0052:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.noise.ABTest.validate(java.lang.String):boolean");
    }

    public int getGroup() {
        return this.mGroup;
    }

    public String getGroupInfo() {
        return !this.isInTest ? b.J : String.valueOf(this.mGroup);
    }

    public int getTestInterval() {
        return this.mInterval;
    }

    public String getTestName() {
        return this.mPoli;
    }

    public int getTestPolicy() {
        return this.mPolicy;
    }

    public boolean isInTest() {
        return this.isInTest;
    }

    public void onExperimentChanged(String str, int i) {
        this.mInterval = i;
        String signature = Envelope.getSignature(this.context);
        if (TextUtils.isEmpty(signature) || TextUtils.isEmpty(str)) {
            this.isInTest = false;
            return;
        }
        try {
            this.mProb13 = prob(signature, 12);
            this.mProb07 = prob(signature, 6);
            if (str.startsWith("SIG7")) {
                parseSig7(str);
            } else if (str.startsWith("FIXED")) {
                parseFIXED(str);
            }
        } catch (Exception e) {
            this.isInTest = false;
            MLog.e("v:" + str, (Throwable) e);
        }
    }

    public void onImprintChanged(g.a aVar) {
        onExperimentChanged(aVar.a("client_test", (String) null), Integer.valueOf(aVar.a("test_report_interval", "0")).intValue());
    }

    public String toString() {
        return " p13:" + this.mProb13 + " p07:" + this.mProb07 + " policy:" + this.mPolicy + " interval:" + this.mInterval;
    }
}
