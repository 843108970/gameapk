package com.google.protobuf;

import android.support.v7.widget.ActivityChooserView;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

class RopeByteString extends ByteString {
    /* access modifiers changed from: private */
    public static final int[] minLengthByDepth;
    private int hash;
    /* access modifiers changed from: private */
    public final ByteString left;
    private final int leftLength;
    /* access modifiers changed from: private */
    public final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    private static class Balancer {
        private final Stack<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new Stack<>();
        }

        /* synthetic */ Balancer(Balancer balancer) {
            this();
        }

        /* access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop, (RopeByteString) null);
            }
            return pop;
        }

        private void doBalance(ByteString byteString) {
            while (!byteString.isBalanced()) {
                if (byteString instanceof RopeByteString) {
                    RopeByteString ropeByteString = (RopeByteString) byteString;
                    doBalance(ropeByteString.left);
                    byteString = ropeByteString.right;
                } else {
                    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
                }
            }
            insert(byteString);
        }

        private int getDepthBinForLength(int i) {
            int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void insert(ByteString byteString) {
            int depthBinForLength = getDepthBinForLength(byteString.size());
            int i = RopeByteString.minLengthByDepth[depthBinForLength + 1];
            if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= i) {
                this.prefixesStack.push(byteString);
                return;
            }
            int i2 = RopeByteString.minLengthByDepth[depthBinForLength];
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < i2) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop, (RopeByteString) null);
            }
            RopeByteString ropeByteString = new RopeByteString(pop, byteString, (RopeByteString) null);
            while (!this.prefixesStack.isEmpty()) {
                if (this.prefixesStack.peek().size() >= RopeByteString.minLengthByDepth[getDepthBinForLength(ropeByteString.size()) + 1]) {
                    break;
                }
                ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString, (RopeByteString) null);
            }
            this.prefixesStack.push(ropeByteString);
        }
    }

    private static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        private PieceIterator(ByteString byteString) {
            this.breadCrumbs = new Stack<>();
            this.next = getLeafByLeft(byteString);
        }

        /* synthetic */ PieceIterator(ByteString byteString, PieceIterator pieceIterator) {
            this(byteString);
        }

        private LiteralByteString getLeafByLeft(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (LiteralByteString) byteString;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
            while (!this.breadCrumbs.isEmpty()) {
                LiteralByteString leafByLeft = getLeafByLeft(this.breadCrumbs.pop().right);
                if (!leafByLeft.isEmpty()) {
                    return leafByLeft;
                }
            }
            return null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public LiteralByteString next() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            LiteralByteString literalByteString = this.next;
            this.next = getNextNonEmptyLeaf();
            return literalByteString;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeByteIterator implements ByteString.ByteIterator {
        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;

        private RopeByteIterator() {
            this.pieces = new PieceIterator(RopeByteString.this, (PieceIterator) null);
            this.bytes = this.pieces.next().iterator();
            this.bytesRemaining = RopeByteString.this.size();
        }

        /* synthetic */ RopeByteIterator(RopeByteString ropeByteString, RopeByteIterator ropeByteIterator) {
            this();
        }

        public boolean hasNext() {
            return this.bytesRemaining > 0;
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            if (!this.bytes.hasNext()) {
                this.bytes = this.pieces.next().iterator();
            }
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;

        public RopeInputStream() {
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece != null && this.currentPieceIndex == this.currentPieceSize) {
                this.currentPieceOffsetInRope += this.currentPieceSize;
                this.currentPieceIndex = 0;
                if (this.pieceIterator.hasNext()) {
                    this.currentPiece = this.pieceIterator.next();
                    this.currentPieceSize = this.currentPiece.size();
                    return;
                }
                this.currentPiece = null;
                this.currentPieceSize = 0;
            }
        }

        private void initialize() {
            this.pieceIterator = new PieceIterator(RopeByteString.this, (PieceIterator) null);
            this.currentPiece = this.pieceIterator.next();
            this.currentPieceSize = this.currentPiece.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] bArr, int i, int i2) {
            int i3 = i;
            int i4 = i2;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                advanceIfCurrentPieceFullyRead();
                if (this.currentPiece != null) {
                    int min = Math.min(this.currentPieceSize - this.currentPieceIndex, i4);
                    if (bArr != null) {
                        this.currentPiece.copyTo(bArr, this.currentPieceIndex, i3, min);
                        i3 += min;
                    }
                    this.currentPieceIndex += min;
                    i4 -= min;
                } else if (i4 == i2) {
                    return -1;
                }
            }
            return i2 - i4;
        }

        public int available() throws IOException {
            return RopeByteString.this.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
        }

        public void mark(int i) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            if (this.currentPiece == null) {
                return -1;
            }
            LiteralByteString literalByteString = this.currentPiece;
            int i = this.currentPieceIndex;
            this.currentPieceIndex = i + 1;
            return literalByteString.byteAt(i) & 255;
        }

        public int read(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new NullPointerException();
            } else if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return readSkipInternal(bArr, i, i2);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public synchronized void reset() {
            initialize();
            readSkipInternal((byte[]) null, 0, this.mark);
        }

        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) readSkipInternal((byte[]) null, 0, (int) j);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        minLengthByDepth = new int[arrayList.size()];
        for (int i4 = 0; i4 < minLengthByDepth.length; i4++) {
            minLengthByDepth[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.hash = 0;
        this.left = byteString;
        this.right = byteString2;
        this.leftLength = byteString.size();
        this.totalLength = this.leftLength + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, RopeByteString ropeByteString) {
        this(byteString, byteString2);
    }

    static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString = byteString instanceof RopeByteString ? (RopeByteString) byteString : null;
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() != 0) {
            int size = byteString.size() + byteString2.size();
            if (size < 128) {
                return concatenateBytes(byteString, byteString2);
            }
            if (ropeByteString != null && ropeByteString.right.size() + byteString2.size() < 128) {
                byteString2 = new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            } else if (ropeByteString == null || ropeByteString.left.getTreeDepth() <= ropeByteString.right.getTreeDepth() || ropeByteString.getTreeDepth() <= byteString2.getTreeDepth()) {
                return size >= minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1] ? new RopeByteString(byteString, byteString2) : new Balancer((Balancer) null).balance(byteString, byteString2);
            } else {
                byteString2 = new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        return byteString2;
    }

    private static LiteralByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new LiteralByteString(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        PieceIterator pieceIterator = new PieceIterator(this, (PieceIterator) null);
        LiteralByteString literalByteString = (LiteralByteString) pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString, (PieceIterator) null);
        LiteralByteString literalByteString2 = (LiteralByteString) pieceIterator2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = literalByteString.size() - i;
            int size2 = literalByteString2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? literalByteString.equalsRange(literalByteString2, i2, min) : literalByteString2.equalsRange(literalByteString, i, min))) {
                return false;
            }
            i3 += min;
            if (i3 < this.totalLength) {
                if (min == size) {
                    literalByteString = (LiteralByteString) pieceIterator.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    literalByteString2 = (LiteralByteString) pieceIterator2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == this.totalLength) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this, (PieceIterator) null);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    public byte byteAt(int i) {
        ByteString byteString;
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        } else if (i > this.totalLength) {
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + this.totalLength);
        } else {
            if (i < this.leftLength) {
                byteString = this.left;
            } else {
                byteString = this.right;
                i -= this.leftLength;
            }
            return byteString.byteAt(i);
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.leftLength) {
            this.left.copyToInternal(bArr, i, i2, i3);
        } else if (i >= this.leftLength) {
            this.right.copyToInternal(bArr, i - this.leftLength, i2, i3);
        } else {
            int i4 = this.leftLength - i;
            this.left.copyToInternal(bArr, i, i2, i4);
            this.right.copyToInternal(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    public boolean equals(Object obj) {
        int peekCachedHashCode;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        if (this.hash == 0 || (peekCachedHashCode = byteString.peekCachedHashCode()) == 0 || this.hash == peekCachedHashCode) {
            return equalsFragments(byteString);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int getTreeDepth() {
        return this.treeDepth;
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            i = partialHash(this.totalLength, 0, this.totalLength);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public boolean isBalanced() {
        return this.totalLength >= minLengthByDepth[this.treeDepth];
    }

    public boolean isValidUtf8() {
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(0, 0, this.leftLength), 0, this.right.size()) == 0;
    }

    public ByteString.ByteIterator iterator() {
        return new RopeByteIterator(this, (RopeByteIterator) null);
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance((InputStream) new RopeInputStream());
    }

    public InputStream newInput() {
        return new RopeInputStream();
    }

    /* access modifiers changed from: protected */
    public int partialHash(int i, int i2, int i3) {
        if (i2 + i3 <= this.leftLength) {
            return this.left.partialHash(i, i2, i3);
        }
        if (i2 >= this.leftLength) {
            return this.right.partialHash(i, i2 - this.leftLength, i3);
        }
        int i4 = this.leftLength - i2;
        return this.right.partialHash(this.left.partialHash(i, i2, i4), 0, i3 - i4);
    }

    /* access modifiers changed from: protected */
    public int partialIsValidUtf8(int i, int i2, int i3) {
        if (i2 + i3 <= this.leftLength) {
            return this.left.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= this.leftLength) {
            return this.right.partialIsValidUtf8(i, i2 - this.leftLength, i3);
        }
        int i4 = this.leftLength - i2;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i, i2, i4), 0, i3 - i4);
    }

    /* access modifiers changed from: protected */
    public int peekCachedHashCode() {
        return this.hash;
    }

    public int size() {
        return this.totalLength;
    }

    public ByteString substring(int i, int i2) {
        ByteString byteString;
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 > this.totalLength) {
            throw new IndexOutOfBoundsException("End index: " + i2 + " > " + this.totalLength);
        } else {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
            } else if (i3 == 0) {
                return ByteString.EMPTY;
            } else {
                if (i3 == this.totalLength) {
                    return this;
                }
                if (i2 <= this.leftLength) {
                    byteString = this.left;
                } else if (i < this.leftLength) {
                    return new RopeByteString(this.left.substring(i), this.right.substring(0, i2 - this.leftLength));
                } else {
                    byteString = this.right;
                    i -= this.leftLength;
                    i2 -= this.leftLength;
                }
                return byteString.substring(i, i2);
            }
        }
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }
}
