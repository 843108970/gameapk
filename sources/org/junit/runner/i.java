package org.junit.runner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.b.b;

public final class i implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(b.class).getFields();
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final AtomicInteger count;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<org.junit.runner.b.a> failures;
    /* access modifiers changed from: private */
    public final AtomicInteger ignoreCount;
    /* access modifiers changed from: private */
    public final AtomicLong runTime;
    private b serializedForm;
    /* access modifiers changed from: private */
    public final AtomicLong startTime;

    @b.a
    private class a extends org.junit.runner.b.b {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }

        public final void a(org.junit.runner.b.a aVar) throws Exception {
            i.this.failures.add(aVar);
        }

        public final void a(c cVar) throws Exception {
            i.this.count.getAndIncrement();
        }

        public final void a(i iVar) throws Exception {
            i.this.runTime.addAndGet(System.currentTimeMillis() - i.this.startTime.get());
        }

        public final void b(org.junit.runner.b.a aVar) {
        }

        public final void c(c cVar) throws Exception {
            i.this.ignoreCount.getAndIncrement();
        }

        public final void d(c cVar) throws Exception {
            i.this.startTime.set(System.currentTimeMillis());
        }
    }

    private static class b implements Serializable {
        private static final long serialVersionUID = 1;
        /* access modifiers changed from: private */
        public final AtomicInteger fCount;
        /* access modifiers changed from: private */
        public final List<org.junit.runner.b.a> fFailures;
        /* access modifiers changed from: private */
        public final AtomicInteger fIgnoreCount;
        /* access modifiers changed from: private */
        public final long fRunTime;
        /* access modifiers changed from: private */
        public final long fStartTime;

        private b(ObjectInputStream.GetField getField) throws IOException {
            this.fCount = (AtomicInteger) getField.get("fCount", (Object) null);
            this.fIgnoreCount = (AtomicInteger) getField.get("fIgnoreCount", (Object) null);
            this.fFailures = (List) getField.get("fFailures", (Object) null);
            this.fRunTime = getField.get("fRunTime", 0);
            this.fStartTime = getField.get("fStartTime", 0);
        }

        public b(i iVar) {
            this.fCount = iVar.count;
            this.fIgnoreCount = iVar.ignoreCount;
            this.fFailures = Collections.synchronizedList(new ArrayList(iVar.failures));
            this.fRunTime = iVar.runTime.longValue();
            this.fStartTime = iVar.startTime.longValue();
        }

        public static b deserialize(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            return new b(objectInputStream.readFields());
        }

        public void serialize(ObjectOutputStream objectOutputStream) throws IOException {
            ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
            putFields.put("fCount", this.fCount);
            putFields.put("fIgnoreCount", this.fIgnoreCount);
            putFields.put("fFailures", this.fFailures);
            putFields.put("fRunTime", this.fRunTime);
            putFields.put("fStartTime", this.fStartTime);
            objectOutputStream.writeFields();
        }
    }

    public i() {
        this.count = new AtomicInteger();
        this.ignoreCount = new AtomicInteger();
        this.failures = new CopyOnWriteArrayList<>();
        this.runTime = new AtomicLong();
        this.startTime = new AtomicLong();
    }

    private i(b bVar) {
        this.count = bVar.fCount;
        this.ignoreCount = bVar.fIgnoreCount;
        this.failures = new CopyOnWriteArrayList<>(bVar.fFailures);
        this.runTime = new AtomicLong(bVar.fRunTime);
        this.startTime = new AtomicLong(bVar.fStartTime);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.serializedForm = b.deserialize(objectInputStream);
    }

    private Object readResolve() {
        return new i(this.serializedForm);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        new b(this).serialize(objectOutputStream);
    }

    public final org.junit.runner.b.b createListener() {
        return new a(this, (byte) 0);
    }

    public final int getFailureCount() {
        return this.failures.size();
    }

    public final List<org.junit.runner.b.a> getFailures() {
        return this.failures;
    }

    public final int getIgnoreCount() {
        return this.ignoreCount.get();
    }

    public final int getRunCount() {
        return this.count.get();
    }

    public final long getRunTime() {
        return this.runTime.get();
    }

    public final boolean wasSuccessful() {
        return getFailureCount() == 0;
    }
}
