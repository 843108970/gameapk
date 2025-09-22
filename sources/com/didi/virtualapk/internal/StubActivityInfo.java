package com.didi.virtualapk.internal;

import java.util.HashMap;

class StubActivityInfo {
    public static final int MAX_COUNT_SINGLEINSTANCE = 8;
    public static final int MAX_COUNT_SINGLETASK = 8;
    public static final int MAX_COUNT_SINGLETOP = 8;
    public static final int MAX_COUNT_STANDARD = 1;
    public static final String STUB_ACTIVITY_SINGLEINSTANCE = "%s.D$%d";
    public static final String STUB_ACTIVITY_SINGLETASK = "%s.C$%d";
    public static final String STUB_ACTIVITY_SINGLETOP = "%s.B$%d";
    public static final String STUB_ACTIVITY_STANDARD = "%s.A$%d";
    public static final String corePackage = "com.didi.virtualapk.core";
    private HashMap<String, String> mCachedStubActivity = new HashMap<>();
    public int usedSingleInstanceStubActivity = 0;
    public int usedSingleTaskStubActivity = 0;
    public int usedSingleTopStubActivity = 0;
    public final int usedStandardStubActivity = 1;

    StubActivityInfo() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getStubActivity(java.lang.String r7, int r8, android.content.res.Resources.Theme r9) {
        /*
            r6 = this;
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r6.mCachedStubActivity
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            r0 = 2
            int[] r1 = new int[r0]
            r1 = {16842840, 16842836} // fill-array
            android.content.res.TypedArray r9 = r9.obtainStyledAttributes(r1)
            r1 = 0
            boolean r2 = r9.getBoolean(r1, r1)
            r9.recycle()
            java.lang.String r9 = "VA.StubActivityInfo"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getStubActivity, is transparent theme ? "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r9, r3)
            java.lang.String r9 = "%s.A$%d"
            java.lang.Object[] r3 = new java.lang.Object[r0]
            java.lang.String r4 = "com.didi.virtualapk.core"
            r3[r1] = r4
            r4 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r3[r4] = r5
            java.lang.String r9 = java.lang.String.format(r9, r3)
            switch(r8) {
                case 0: goto L_0x0093;
                case 1: goto L_0x0077;
                case 2: goto L_0x005f;
                case 3: goto L_0x0047;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x00b6
        L_0x0047:
            int r8 = r6.usedSingleInstanceStubActivity
            int r8 = r8 % 8
            int r8 = r8 + r4
            r6.usedSingleInstanceStubActivity = r8
            java.lang.String r8 = "%s.D$%d"
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.String r0 = "com.didi.virtualapk.core"
            r9[r1] = r0
            int r0 = r6.usedSingleInstanceStubActivity
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9[r4] = r0
            goto L_0x008e
        L_0x005f:
            int r8 = r6.usedSingleTaskStubActivity
            int r8 = r8 % 8
            int r8 = r8 + r4
            r6.usedSingleTaskStubActivity = r8
            java.lang.String r8 = "%s.C$%d"
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.String r0 = "com.didi.virtualapk.core"
            r9[r1] = r0
            int r0 = r6.usedSingleTaskStubActivity
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9[r4] = r0
            goto L_0x008e
        L_0x0077:
            int r8 = r6.usedSingleTopStubActivity
            int r8 = r8 % 8
            int r8 = r8 + r4
            r6.usedSingleTopStubActivity = r8
            java.lang.String r8 = "%s.B$%d"
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.String r0 = "com.didi.virtualapk.core"
            r9[r1] = r0
            int r0 = r6.usedSingleTopStubActivity
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9[r4] = r0
        L_0x008e:
            java.lang.String r9 = java.lang.String.format(r8, r9)
            goto L_0x00b6
        L_0x0093:
            java.lang.String r8 = "%s.A$%d"
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.String r3 = "com.didi.virtualapk.core"
            r9[r1] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r9[r4] = r3
            java.lang.String r9 = java.lang.String.format(r8, r9)
            if (r2 == 0) goto L_0x00b6
            java.lang.String r8 = "%s.A$%d"
            java.lang.Object[] r9 = new java.lang.Object[r0]
            java.lang.String r2 = "com.didi.virtualapk.core"
            r9[r1] = r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9[r4] = r0
            goto L_0x008e
        L_0x00b6:
            java.util.HashMap<java.lang.String, java.lang.String> r8 = r6.mCachedStubActivity
            r8.put(r7, r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.virtualapk.internal.StubActivityInfo.getStubActivity(java.lang.String, int, android.content.res.Resources$Theme):java.lang.String");
    }
}
