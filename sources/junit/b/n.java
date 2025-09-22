package junit.b;

import com.cyjh.common.b.a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.b.h;

public class n implements i {

    /* renamed from: a  reason: collision with root package name */
    public String f4040a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<i> f4041b;

    public n() {
        this.f4041b = new Vector<>(10);
    }

    public n(Class<?> cls) {
        this.f4041b = new Vector<>(10);
        b(cls);
    }

    public n(Class<? extends j> cls, String str) {
        this((Class<?>) cls);
        this.f4040a = str;
    }

    public n(String str) {
        this.f4041b = new Vector<>(10);
        this.f4040a = str;
    }

    private n(Class<?>... clsArr) {
        i iVar;
        this.f4041b = new Vector<>(10);
        for (Class<?> cls : clsArr) {
            if (j.class.isAssignableFrom(cls)) {
                iVar = new n((Class<?>) cls.asSubclass(j.class));
            } else {
                iVar = a(cls.getCanonicalName() + " does not extend TestCase");
            }
            a(iVar);
        }
    }

    private n(Class<? extends j>[] clsArr, String str) {
        this((Class<?>[]) clsArr);
        this.f4040a = str;
    }

    private static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static Constructor<?> a(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(new Class[]{String.class});
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    public static i a(Class<?> cls, String str) {
        String str2;
        StringBuilder sb;
        Object obj;
        try {
            Constructor<?> a2 = a(cls);
            try {
                if (a2.getParameterTypes().length == 0) {
                    obj = a2.newInstance(new Object[0]);
                    if (obj instanceof j) {
                        ((j) obj).f4032a = str;
                    }
                } else {
                    obj = a2.newInstance(new Object[]{str});
                }
                return (i) obj;
            } catch (InstantiationException e) {
                e = e;
                sb = new StringBuilder("Cannot instantiate test case: ");
                sb.append(str);
                sb.append(" (");
                sb.append(a(e));
                sb.append(")");
                str2 = sb.toString();
                return a(str2);
            } catch (InvocationTargetException e2) {
                sb = new StringBuilder("Exception in constructor: ");
                sb.append(str);
                sb.append(" (");
                e = e2.getTargetException();
                sb.append(a(e));
                sb.append(")");
                str2 = sb.toString();
                return a(str2);
            } catch (IllegalAccessException e3) {
                e = e3;
                sb = new StringBuilder("Cannot access test case: ");
                sb.append(str);
                sb.append(" (");
                sb.append(a(e));
                sb.append(")");
                str2 = sb.toString();
                return a(str2);
            }
        } catch (NoSuchMethodException unused) {
            str2 = "Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()";
            return a(str2);
        }
    }

    private static i a(final String str) {
        return new j("warning") {
            /* access modifiers changed from: protected */
            public final void c() {
                a.a(str);
            }
        };
    }

    private void a(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (!list.contains(name)) {
            if (b(method) && Modifier.isPublic(method.getModifiers())) {
                list.add(name);
                a(a(cls, name));
            } else if (b(method)) {
                a(a("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
            }
        }
    }

    private static boolean a(Method method) {
        return b(method) && Modifier.isPublic(method.getModifiers());
    }

    private String b() {
        return this.f4040a;
    }

    private void b(Class<?> cls) {
        StringBuilder sb;
        String str;
        i iVar;
        this.f4040a = cls.getName();
        try {
            a(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                sb = new StringBuilder("Class ");
                sb.append(cls.getName());
                str = " is not public";
                sb.append(str);
                a(a(sb.toString()));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls2 = cls; i.class.isAssignableFrom(cls2); cls2 = cls2.getSuperclass()) {
                for (Method method : h.a(cls2)) {
                    String name = method.getName();
                    if (!arrayList.contains(name)) {
                        if (b(method) && Modifier.isPublic(method.getModifiers())) {
                            arrayList.add(name);
                            iVar = a(cls, name);
                        } else if (b(method)) {
                            iVar = a("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")");
                        }
                        a(iVar);
                    }
                }
            }
            if (this.f4041b.size() == 0) {
                a(a("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            sb = new StringBuilder("Class ");
            sb.append(cls.getName());
            str = " has no public constructor TestCase(String name) or TestCase()";
        }
    }

    private void b(String str) {
        this.f4040a = str;
    }

    private static boolean b(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith(a.aI) && method.getReturnType().equals(Void.TYPE);
    }

    private int c() {
        return this.f4041b.size();
    }

    private static i c(Class<?> cls) {
        if (j.class.isAssignableFrom(cls)) {
            return new n((Class<?>) cls.asSubclass(j.class));
        }
        return a(cls.getCanonicalName() + " does not extend TestCase");
    }

    private Enumeration<i> d() {
        return this.f4041b.elements();
    }

    private void d(Class<? extends j> cls) {
        a((i) new n((Class<?>) cls));
    }

    public final int a() {
        Iterator<i> it = this.f4041b.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().a();
        }
        return i;
    }

    public final i a(int i) {
        return this.f4041b.get(i);
    }

    public final void a(i iVar) {
        this.f4041b.add(iVar);
    }

    public void a(i iVar, m mVar) {
        iVar.a(mVar);
    }

    public void a(m mVar) {
        Iterator<i> it = this.f4041b.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!mVar.f()) {
                a(next, mVar);
            } else {
                return;
            }
        }
    }

    public String toString() {
        return this.f4040a != null ? this.f4040a : super.toString();
    }
}
