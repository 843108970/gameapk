package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    /* access modifiers changed from: private */
    public final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public String get(int i) {
        return (String) this.list.get(i);
    }

    public ByteString getByteString(int i) {
        return this.list.getByteString(i);
    }

    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Iterator<String> iter;

            {
                this.iter = UnmodifiableLazyStringList.this.list.iterator();
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public String next() {
                return this.iter.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public ListIterator<String> listIterator(int i) {
        return new ListIterator<String>(i) {
            ListIterator<String> iter;

            {
                this.iter = UnmodifiableLazyStringList.this.list.listIterator(r2);
            }

            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public boolean hasPrevious() {
                return this.iter.hasPrevious();
            }

            public String next() {
                return this.iter.next();
            }

            public int nextIndex() {
                return this.iter.nextIndex();
            }

            public String previous() {
                return this.iter.previous();
            }

            public int previousIndex() {
                return this.iter.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size() {
        return this.list.size();
    }
}
