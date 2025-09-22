package net.sourceforge.zbar;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d implements Iterator<Symbol> {

    /* renamed from: a  reason: collision with root package name */
    private Symbol f4241a;

    d(Symbol symbol) {
        this.f4241a = symbol;
    }

    private Symbol a() {
        if (this.f4241a == null) {
            throw new NoSuchElementException("access past end of SymbolIterator");
        }
        Symbol symbol = this.f4241a;
        long next = this.f4241a.next();
        if (next != 0) {
            this.f4241a = new Symbol(next);
            return symbol;
        }
        this.f4241a = null;
        return symbol;
    }

    public final boolean hasNext() {
        return this.f4241a != null;
    }

    public final /* synthetic */ Object next() {
        if (this.f4241a == null) {
            throw new NoSuchElementException("access past end of SymbolIterator");
        }
        Symbol symbol = this.f4241a;
        long next = this.f4241a.next();
        if (next != 0) {
            this.f4241a = new Symbol(next);
            return symbol;
        }
        this.f4241a = null;
        return symbol;
    }

    public final void remove() {
        throw new UnsupportedOperationException("SymbolIterator is immutable");
    }
}
