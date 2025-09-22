package javax.mail;

import java.util.Vector;
import javax.mail.event.MailEvent;

class EventQueue implements Runnable {
    private QueueElement head = null;
    private Thread qThread = new Thread(this, "JavaMail-EventQueue");
    private QueueElement tail = null;

    static class QueueElement {
        MailEvent event = null;
        QueueElement next = null;
        QueueElement prev = null;
        Vector vector = null;

        QueueElement(MailEvent mailEvent, Vector vector2) {
            this.event = mailEvent;
            this.vector = vector2;
        }
    }

    public EventQueue() {
        this.qThread.setDaemon(true);
        this.qThread.start();
    }

    private synchronized QueueElement dequeue() throws InterruptedException {
        QueueElement queueElement;
        while (this.tail == null) {
            wait();
        }
        queueElement = this.tail;
        this.tail = queueElement.prev;
        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        queueElement.next = null;
        queueElement.prev = null;
        return queueElement;
    }

    public synchronized void enqueue(MailEvent mailEvent, Vector vector) {
        QueueElement queueElement = new QueueElement(mailEvent, vector);
        if (this.head == null) {
            this.head = queueElement;
            this.tail = queueElement;
        } else {
            queueElement.next = this.head;
            this.head.prev = queueElement;
            this.head = queueElement;
        }
        notifyAll();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[EDGE_INSN: B:0:0x0000->B:1:? ?: BREAK  , LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0007 A[Catch:{ InterruptedException -> 0x0023 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
        L_0x0000:
            javax.mail.EventQueue$QueueElement r0 = r4.dequeue()     // Catch:{ InterruptedException -> 0x0023 }
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            javax.mail.event.MailEvent r1 = r0.event     // Catch:{ InterruptedException -> 0x0023 }
            java.util.Vector r0 = r0.vector     // Catch:{ InterruptedException -> 0x0023 }
            r2 = 0
        L_0x000c:
            int r3 = r0.size()     // Catch:{ InterruptedException -> 0x0023 }
            if (r2 < r3) goto L_0x0013
            goto L_0x0000
        L_0x0013:
            java.lang.Object r3 = r0.elementAt(r2)     // Catch:{ Throwable -> 0x001b }
            r1.dispatch(r3)     // Catch:{ Throwable -> 0x001b }
            goto L_0x0020
        L_0x001b:
            r3 = move-exception
            boolean r3 = r3 instanceof java.lang.InterruptedException     // Catch:{ InterruptedException -> 0x0023 }
            if (r3 != 0) goto L_0x0023
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.EventQueue.run():void");
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        if (this.qThread != null) {
            this.qThread.interrupt();
            this.qThread = null;
        }
    }
}
