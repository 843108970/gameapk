package com.google.a.g.a.a;

import java.util.List;

final class a {
    private a() {
    }

    private static com.google.a.c.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).f3177b == null) {
            size--;
        }
        com.google.a.c.a aVar = new com.google.a.c.a(size * 12);
        int i = list.get(0).f3177b.f3182a;
        int i2 = 0;
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & i) != 0) {
                aVar.b(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            b bVar = list.get(i4);
            int i5 = bVar.f3176a.f3182a;
            int i6 = i2;
            for (int i7 = 11; i7 >= 0; i7--) {
                if (((1 << i7) & i5) != 0) {
                    aVar.b(i6);
                }
                i6++;
            }
            if (bVar.f3177b != null) {
                int i8 = bVar.f3177b.f3182a;
                for (int i9 = 11; i9 >= 0; i9--) {
                    if (((1 << i9) & i8) != 0) {
                        aVar.b(i6);
                    }
                    i6++;
                }
            }
            i2 = i6;
        }
        return aVar;
    }
}
