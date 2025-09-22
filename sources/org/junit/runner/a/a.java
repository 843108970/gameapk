package org.junit.runner.a;

import java.util.Iterator;
import org.junit.runner.c;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f4606a = new a() {
        public final String a() {
            return "all tests";
        }

        public final a a(a aVar) {
            return aVar;
        }

        public final void a(Object obj) throws c {
        }

        public final boolean a(c cVar) {
            return true;
        }
    };

    public static a b(final c cVar) {
        return new a() {
            public final String a() {
                return String.format("Method %s", new Object[]{cVar.getDisplayName()});
            }

            public final boolean a(c cVar) {
                if (cVar.isTest()) {
                    return cVar.equals(cVar);
                }
                Iterator<c> it = cVar.getChildren().iterator();
                while (it.hasNext()) {
                    if (a(it.next())) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    public abstract String a();

    public a a(final a aVar) {
        return (aVar == this || aVar == f4606a) ? this : new a() {
            public final String a() {
                return this.a() + " and " + aVar.a();
            }

            public final boolean a(c cVar) {
                return this.a(cVar) && aVar.a(cVar);
            }
        };
    }

    public void a(Object obj) throws c {
        if (obj instanceof b) {
            ((b) obj).a(this);
        }
    }

    public abstract boolean a(c cVar);
}
