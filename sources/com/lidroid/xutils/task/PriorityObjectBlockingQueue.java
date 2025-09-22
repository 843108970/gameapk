package com.lidroid.xutils.task;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PriorityObjectBlockingQueue<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
    private static final long serialVersionUID = -6903933977591709194L;
    private final int capacity;
    private final AtomicInteger count;
    transient Node<E> head;
    private transient Node<E> last;
    private final Condition notEmpty;
    private final Condition notFull;
    private final ReentrantLock putLock;
    private final ReentrantLock takeLock;

    private class Itr implements Iterator<E> {
        private Node<E> current;
        private E currentElement;
        private Node<E> lastRet;

        Itr() {
            PriorityObjectBlockingQueue.this.fullyLock();
            try {
                this.current = PriorityObjectBlockingQueue.this.head.next;
                if (this.current != null) {
                    this.currentElement = this.current.getValue();
                }
            } finally {
                PriorityObjectBlockingQueue.this.fullyUnlock();
            }
        }

        private Node<E> nextNode(Node<E> node) {
            while (true) {
                Node<T> node2 = node.next;
                if (node2 == node) {
                    return PriorityObjectBlockingQueue.this.head.next;
                }
                if (node2 == null || node2.getValue() != null) {
                    return node2;
                }
                node = node2;
            }
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public E next() {
            PriorityObjectBlockingQueue.this.fullyLock();
            try {
                if (this.current == null) {
                    throw new NoSuchElementException();
                }
                E e = this.currentElement;
                this.lastRet = this.current;
                this.current = nextNode(this.current);
                this.currentElement = this.current == null ? null : this.current.getValue();
                return e;
            } finally {
                PriorityObjectBlockingQueue.this.fullyUnlock();
            }
        }

        public void remove() {
            if (this.lastRet == null) {
                throw new IllegalStateException();
            }
            PriorityObjectBlockingQueue.this.fullyLock();
            try {
                Node<E> node = this.lastRet;
                this.lastRet = null;
                Node<E> node2 = PriorityObjectBlockingQueue.this.head;
                while (true) {
                    Node<E> node3 = node2;
                    node2 = node2.next;
                    if (node2 != null) {
                        if (node2 == node) {
                            PriorityObjectBlockingQueue.this.unlink(node2, node3);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } finally {
                PriorityObjectBlockingQueue.this.fullyUnlock();
            }
        }
    }

    public PriorityObjectBlockingQueue() {
        this((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public PriorityObjectBlockingQueue(int i) {
        this.count = new AtomicInteger();
        this.takeLock = new ReentrantLock();
        this.notEmpty = this.takeLock.newCondition();
        this.putLock = new ReentrantLock();
        this.notFull = this.putLock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
        Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
    }

    public PriorityObjectBlockingQueue(Collection<? extends E> collection) {
        this((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        int i = 0;
        try {
            for (Object next : collection) {
                if (next == null) {
                    throw new NullPointerException();
                } else if (i == this.capacity) {
                    throw new IllegalStateException("Queue full");
                } else {
                    opQueue(new Node(next));
                    i++;
                }
            }
            this.count.set(i);
        } finally {
            reentrantLock.unlock();
        }
    }

    private E _dequeue() {
        Node<E> node = this.head;
        Node node2 = node.next;
        node.next = node;
        this.head = node2;
        E value = node2.getValue();
        node2.setValue(null);
        return value;
    }

    private void _enqueue(Node<E> node) {
        boolean z;
        Node node2 = this.head;
        while (true) {
            if (node2.next == null) {
                z = false;
                break;
            }
            Node<T> node3 = node2.next;
            if (node3.getPriority().ordinal() > node.getPriority().ordinal()) {
                node2.next = node;
                node.next = node3;
                z = true;
                break;
            }
            node2 = node2.next;
        }
        if (!z) {
            this.last.next = node;
            this.last = node;
        }
    }

    private synchronized E opQueue(Node<E> node) {
        if (node == null) {
            return _dequeue();
        }
        _enqueue(node);
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count.set(0);
        Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private void signalNotEmpty() {
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            this.notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void signalNotFull() {
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            this.notFull.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        fullyLock();
        try {
            objectOutputStream.defaultWriteObject();
            Node node = this.head;
            while (true) {
                node = node.next;
                if (node == null) {
                    objectOutputStream.writeObject((Object) null);
                    return;
                }
                objectOutputStream.writeObject(node.getValue());
            }
        } finally {
            fullyUnlock();
        }
    }

    public void clear() {
        fullyLock();
        try {
            Node<E> node = this.head;
            while (true) {
                Node<T> node2 = node.next;
                if (node2 == null) {
                    break;
                }
                node.next = node;
                node2.setValue(null);
                node = node2;
            }
            this.head = this.last;
            if (this.count.getAndSet(0) == this.capacity) {
                this.notFull.signal();
            }
        } finally {
            fullyUnlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            Node node = this.head;
            do {
                node = node.next;
                if (node == null) {
                    fullyUnlock();
                    return false;
                }
            } while (!obj.equals(node.getValue()));
            fullyUnlock();
            return true;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        Node<T> node;
        int i2;
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection == this) {
            throw new IllegalArgumentException();
        } else {
            boolean z = false;
            if (i <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.takeLock;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.count.get());
                node = this.head;
                i2 = 0;
                while (i2 < min) {
                    Node<T> node2 = node.next;
                    collection.add(node2.getValue());
                    node2.setValue(null);
                    node.next = node;
                    i2++;
                    node = node2;
                }
                if (i2 > 0) {
                    this.head = node;
                    if (this.count.getAndAdd(-i2) == this.capacity) {
                        z = true;
                    }
                }
                reentrantLock.unlock();
                if (z) {
                    signalNotFull();
                }
                return min;
            } catch (Throwable th) {
                reentrantLock.unlock();
                if (0 != 0) {
                    signalNotFull();
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    /* access modifiers changed from: package-private */
    public void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        AtomicInteger atomicInteger = this.count;
        if (atomicInteger.get() == this.capacity) {
            return false;
        }
        int i = -1;
        Node node = new Node(e);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.capacity) {
                opQueue(node);
                i = atomicInteger.getAndIncrement();
                if (i + 1 < this.capacity) {
                    this.notFull.signal();
                }
            }
            if (i == 0) {
                signalNotEmpty();
            }
            return i >= 0;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        opQueue(new Node(e));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        reentrantLock.unlock();
        if (andIncrement != 0) {
            return true;
        }
        signalNotEmpty();
        return true;
    }

    public E peek() {
        if (this.count.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            Node node = this.head.next;
            if (node == null) {
                return null;
            }
            E value = node.getValue();
            reentrantLock.unlock();
            return value;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public E poll() {
        AtomicInteger atomicInteger = this.count;
        E e = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i = -1;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e = opQueue((Node) null);
                i = atomicInteger.getAndDecrement();
                if (i > 1) {
                    this.notEmpty.signal();
                }
            }
            reentrantLock.unlock();
            if (i == this.capacity) {
                signalNotFull();
            }
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        E opQueue = opQueue((Node) null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return opQueue;
    }

    public void put(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        Node node = new Node(e);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        opQueue(node);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        if (andIncrement == 0) {
            signalNotEmpty();
        }
    }

    public int remainingCapacity() {
        return this.capacity - this.count.get();
    }

    /* JADX INFO: finally extract failed */
    public boolean remove(Object obj) {
        Node<E> node;
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            Node<E> node2 = this.head;
            do {
                node = node2;
                node2 = node2.next;
                if (node2 == null) {
                    fullyUnlock();
                    return false;
                }
            } while (!obj.equals(node2.getValue()));
            unlink(node2, node);
            fullyUnlock();
            return true;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    public int size() {
        return this.count.get();
    }

    /* JADX INFO: finally extract failed */
    public E take() throws InterruptedException {
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E opQueue = opQueue((Node) null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return opQueue;
    }

    public Object[] toArray() {
        fullyLock();
        try {
            Object[] objArr = new Object[this.count.get()];
            int i = 0;
            Node<T> node = this.head.next;
            while (node != null) {
                int i2 = i + 1;
                objArr[i] = node.getValue();
                node = node.next;
                i = i2;
            }
            return objArr;
        } finally {
            fullyUnlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        fullyLock();
        try {
            int i = this.count.get();
            if (tArr.length < i) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            int i2 = 0;
            Node<T> node = this.head.next;
            while (node != null) {
                int i3 = i2 + 1;
                tArr[i2] = node.getValue();
                node = node.next;
                i2 = i3;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        } finally {
            fullyUnlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void unlink(Node<E> node, Node<E> node2) {
        node.setValue(null);
        node2.next = node.next;
        if (this.last == node) {
            this.last = node2;
        }
        if (this.count.getAndDecrement() == this.capacity) {
            this.notFull.signal();
        }
    }
}
