package com.google.a.b.a;

import com.google.a.r;
import java.util.List;

public final class ag extends u {
    private static String a(CharSequence charSequence, String str) {
        List<String> b2 = af.b(charSequence, str, true, false);
        if (b2 == null || b2.isEmpty()) {
            return null;
        }
        return b2.get(0);
    }

    private static String a(String str) {
        return str != null ? (str.startsWith("mailto:") || str.startsWith("MAILTO:")) ? str.substring(7) : str : str;
    }

    private static String[] b(CharSequence charSequence, String str) {
        List<List<String>> a2 = af.a(charSequence, str, true, false);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        int size = a2.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) a2.get(i).get(0);
        }
        return strArr;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.a.b.a.g c(com.google.a.r r17) {
        /*
            java.lang.String r0 = b((com.google.a.r) r17)
            java.lang.String r1 = "BEGIN:VEVENT"
            int r1 = r0.indexOf(r1)
            r2 = 0
            if (r1 >= 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r1 = "SUMMARY"
            java.lang.String r4 = a(r1, r0)
            java.lang.String r1 = "DTSTART"
            java.lang.String r5 = a(r1, r0)
            if (r5 != 0) goto L_0x001d
            return r2
        L_0x001d:
            java.lang.String r1 = "DTEND"
            java.lang.String r6 = a(r1, r0)
            java.lang.String r1 = "DURATION"
            java.lang.String r7 = a(r1, r0)
            java.lang.String r1 = "LOCATION"
            java.lang.String r8 = a(r1, r0)
            java.lang.String r1 = "ORGANIZER"
            java.lang.String r1 = a(r1, r0)
            java.lang.String r9 = a((java.lang.String) r1)
            java.lang.String r1 = "ATTENDEE"
            r3 = 1
            r10 = 0
            java.util.List r1 = com.google.a.b.a.af.a(r1, r0, r3, r10)
            if (r1 == 0) goto L_0x0064
            boolean r11 = r1.isEmpty()
            if (r11 == 0) goto L_0x004a
            goto L_0x0064
        L_0x004a:
            int r11 = r1.size()
            java.lang.String[] r12 = new java.lang.String[r11]
            r13 = 0
        L_0x0051:
            if (r13 >= r11) goto L_0x0065
            java.lang.Object r14 = r1.get(r13)
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r14 = r14.get(r10)
            java.lang.String r14 = (java.lang.String) r14
            r12[r13] = r14
            int r13 = r13 + 1
            goto L_0x0051
        L_0x0064:
            r12 = r2
        L_0x0065:
            if (r12 == 0) goto L_0x0076
            r1 = 0
        L_0x0068:
            int r11 = r12.length
            if (r1 >= r11) goto L_0x0076
            r11 = r12[r1]
            java.lang.String r11 = a((java.lang.String) r11)
            r12[r1] = r11
            int r1 = r1 + 1
            goto L_0x0068
        L_0x0076:
            java.lang.String r1 = "DESCRIPTION"
            java.lang.String r11 = a(r1, r0)
            java.lang.String r1 = "GEO"
            java.lang.String r0 = a(r1, r0)
            r13 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            if (r0 != 0) goto L_0x0088
            r0 = r13
            goto L_0x00a2
        L_0x0088:
            r1 = 59
            int r1 = r0.indexOf(r1)
            if (r1 >= 0) goto L_0x0091
            return r2
        L_0x0091:
            java.lang.String r10 = r0.substring(r10, r1)     // Catch:{ NumberFormatException -> 0x00ad }
            double r13 = java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x00ad }
            int r1 = r1 + r3
            java.lang.String r0 = r0.substring(r1)     // Catch:{ NumberFormatException -> 0x00ad }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ad }
        L_0x00a2:
            com.google.a.b.a.g r16 = new com.google.a.b.a.g     // Catch:{  }
            r3 = r16
            r10 = r12
            r12 = r13
            r14 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14)     // Catch:{  }
            return r16
        L_0x00ad:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.ag.c(com.google.a.r):com.google.a.b.a.g");
    }

    public final /* synthetic */ q a(r rVar) {
        return c(rVar);
    }
}
