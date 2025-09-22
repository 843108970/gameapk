package org.junit.a.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.i;

public final class c implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<String, Long> fDurations = new HashMap();
    private final Map<String, Long> fFailureTimestamps = new HashMap();
    private final File fHistoryStore;

    private final class a extends org.junit.runner.b.b {

        /* renamed from: b  reason: collision with root package name */
        private long f4433b;

        /* renamed from: c  reason: collision with root package name */
        private Map<org.junit.runner.c, Long> f4434c;

        private a() {
            this.f4433b = System.currentTimeMillis();
            this.f4434c = new HashMap();
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void a(org.junit.runner.b.a aVar) throws Exception {
            c.this.putTestFailureTimestamp(aVar.getDescription(), this.f4433b);
        }

        public final void a(org.junit.runner.c cVar) throws Exception {
            c.this.putTestDuration(cVar, System.nanoTime() - this.f4434c.get(cVar).longValue());
        }

        public final void a(i iVar) throws Exception {
            c.this.save();
        }

        public final void b(org.junit.runner.c cVar) throws Exception {
            this.f4434c.put(cVar, Long.valueOf(System.nanoTime()));
        }
    }

    private class b implements Comparator<org.junit.runner.c> {
        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }

        private int a(org.junit.runner.c cVar, org.junit.runner.c cVar2) {
            if (c.this.isNewTest(cVar)) {
                return -1;
            }
            if (c.this.isNewTest(cVar2)) {
                return 1;
            }
            int compareTo = a(cVar2).compareTo(a(cVar));
            return compareTo != 0 ? compareTo : c.this.getTestDuration(cVar).compareTo(c.this.getTestDuration(cVar2));
        }

        private Long a(org.junit.runner.c cVar) {
            Long failureTimestamp = c.this.getFailureTimestamp(cVar);
            if (failureTimestamp == null) {
                return 0L;
            }
            return failureTimestamp;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            org.junit.runner.c cVar = (org.junit.runner.c) obj;
            org.junit.runner.c cVar2 = (org.junit.runner.c) obj2;
            if (c.this.isNewTest(cVar)) {
                return -1;
            }
            if (c.this.isNewTest(cVar2)) {
                return 1;
            }
            int compareTo = a(cVar2).compareTo(a(cVar));
            return compareTo != 0 ? compareTo : c.this.getTestDuration(cVar).compareTo(c.this.getTestDuration(cVar2));
        }
    }

    private c(File file) {
        this.fHistoryStore = file;
    }

    public static c forFolder(File file) {
        if (file.exists()) {
            try {
                return readHistory(file);
            } catch (a e) {
                e.printStackTrace();
                file.delete();
            }
        }
        return new c(file);
    }

    private static c readHistory(File file) throws a {
        ObjectInputStream objectInputStream;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                c cVar = (c) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                return cVar;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (Exception e) {
            throw new a(e);
        }
    }

    /* access modifiers changed from: private */
    public void save() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fHistoryStore));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    public final Long getFailureTimestamp(org.junit.runner.c cVar) {
        return this.fFailureTimestamps.get(cVar.toString());
    }

    /* access modifiers changed from: package-private */
    public final Long getTestDuration(org.junit.runner.c cVar) {
        return this.fDurations.get(cVar.toString());
    }

    /* access modifiers changed from: package-private */
    public final boolean isNewTest(org.junit.runner.c cVar) {
        return !this.fDurations.containsKey(cVar.toString());
    }

    public final org.junit.runner.b.b listener() {
        return new a(this, (byte) 0);
    }

    /* access modifiers changed from: package-private */
    public final void putTestDuration(org.junit.runner.c cVar, long j) {
        this.fDurations.put(cVar.toString(), Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final void putTestFailureTimestamp(org.junit.runner.c cVar, long j) {
        this.fFailureTimestamps.put(cVar.toString(), Long.valueOf(j));
    }

    public final Comparator<org.junit.runner.c> testComparator() {
        return new b(this, (byte) 0);
    }
}
