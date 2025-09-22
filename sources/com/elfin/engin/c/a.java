package com.elfin.engin.c;

import com.cyjh.elfin.a.b;

public final class a {
    public static int a(String str, String str2) {
        try {
            Class[] classes = Class.forName(b.w + ".R").getClasses();
            Class cls = null;
            int i = 0;
            while (true) {
                if (i >= classes.length) {
                    break;
                } else if (classes[i].getName().split("\\$")[1].equals(str)) {
                    cls = classes[i];
                    break;
                } else {
                    i++;
                }
            }
            if (cls != null) {
                return cls.getField(str2).getInt(cls);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0;
        } catch (SecurityException e3) {
            e3.printStackTrace();
            return 0;
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            return 0;
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
            return 0;
        }
        return 0;
    }
}
