package android.support.v7.util;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import com.cyjh.common.util.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() {
        public final int compare(Snake snake, Snake snake2) {
            int i = snake.x - snake2.x;
            return i == 0 ? snake.y - snake2.y : i;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(this.mOldItemStatuses, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake == null || snake.x != 0 || snake.y != 0) {
                Snake snake2 = new Snake();
                snake2.x = 0;
                snake2.y = 0;
                snake2.removal = false;
                snake2.size = 0;
                snake2.reverse = false;
                this.mSnakes.add(0, snake2);
            }
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.mNewItemStatuses[i5] & 31;
                if (i6 == 0) {
                    listUpdateCallback.onInserted(i, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.currentPos++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.mNewItemStatuses[i5] >> 5;
                    listUpdateCallback.onMoved(removePostponedUpdate(list, i7, true).currentPos, i);
                    if (i6 == 4) {
                        listUpdateCallback.onChanged(i, 1, this.mCallback.getChangePayload(i7, i5));
                    }
                } else if (i6 != 16) {
                    throw new IllegalStateException("unknown flag for pos " + i5 + s.a.f1696a + Long.toBinaryString((long) i6));
                } else {
                    list.add(new PostponedUpdate(i5, i, false));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i, int i2, int i3) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.mOldItemStatuses[i5] & 31;
                if (i6 == 0) {
                    listUpdateCallback.onRemoved(i + i4, 1);
                    for (PostponedUpdate postponedUpdate : list) {
                        postponedUpdate.currentPos--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.mOldItemStatuses[i5] >> 5;
                    PostponedUpdate removePostponedUpdate = removePostponedUpdate(list, i7, false);
                    listUpdateCallback.onMoved(i + i4, removePostponedUpdate.currentPos - 1);
                    if (i6 == 4) {
                        listUpdateCallback.onChanged(removePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i5, i7));
                    }
                } else if (i6 != 16) {
                    throw new IllegalStateException("unknown flag for pos " + i5 + s.a.f1696a + Long.toBinaryString((long) i6));
                } else {
                    list.add(new PostponedUpdate(i5, i + i4, true));
                }
            }
        }

        private void findAddition(int i, int i2, int i3) {
            if (this.mOldItemStatuses[i - 1] == 0) {
                findMatchingItem(i, i2, i3, false);
            }
        }

        private boolean findMatchingItem(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i5 = i;
                i4 = i2;
            } else {
                i5 = i - 1;
                i4 = i5;
            }
            while (i3 >= 0) {
                Snake snake = this.mSnakes.get(i3);
                int i6 = snake.x + snake.size;
                int i7 = snake.y + snake.size;
                int i8 = 4;
                if (z) {
                    for (int i9 = i5 - 1; i9 >= i6; i9--) {
                        if (this.mCallback.areItemsTheSame(i9, i4)) {
                            if (this.mCallback.areContentsTheSame(i9, i4)) {
                                i8 = 8;
                            }
                            this.mNewItemStatuses[i4] = (i9 << 5) | 16;
                            this.mOldItemStatuses[i9] = (i4 << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i10 = i2 - 1; i10 >= i7; i10--) {
                        if (this.mCallback.areItemsTheSame(i4, i10)) {
                            if (this.mCallback.areContentsTheSame(i4, i10)) {
                                i8 = 8;
                            }
                            int i11 = i - 1;
                            this.mOldItemStatuses[i11] = (i10 << 5) | 16;
                            this.mNewItemStatuses[i10] = (i11 << 5) | i8;
                            return true;
                        }
                    }
                    continue;
                }
                i5 = snake.x;
                i2 = snake.y;
                i3--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i3 = snake.x + snake.size;
                int i4 = snake.y + snake.size;
                if (this.mDetectMoves) {
                    while (i > i3) {
                        findAddition(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        findRemoval(i, i2, size);
                        i2--;
                    }
                }
                for (int i5 = 0; i5 < snake.size; i5++) {
                    int i6 = snake.x + i5;
                    int i7 = snake.y + i5;
                    int i8 = this.mCallback.areContentsTheSame(i6, i7) ? 1 : 2;
                    this.mOldItemStatuses[i6] = (i7 << 5) | i8;
                    this.mNewItemStatuses[i7] = (i6 << 5) | i8;
                }
                i = snake.x;
                i2 = snake.y;
            }
        }

        private void findRemoval(int i, int i2, int i3) {
            if (this.mNewItemStatuses[i2 - 1] == 0) {
                findMatchingItem(i, i2, i3, true);
            }
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).currentPos += z ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            ArrayList arrayList = new ArrayList();
            int i = this.mOldListSize;
            int i2 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i3 = snake.size;
                int i4 = snake.x + i3;
                int i5 = snake.y + i3;
                if (i4 < i) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.mOldItemStatuses[snake.x + i6] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(snake.x + i6, 1, this.mCallback.getChangePayload(snake.x + i6, snake.y + i6));
                    }
                }
                i = snake.x;
                i2 = snake.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        public void dispatchUpdatesTo(RecyclerView.Adapter adapter) {
            dispatchUpdatesTo((ListUpdateCallback) new AdapterListUpdateCallback(adapter));
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public List<Snake> getSnakes() {
            return this.mSnakes;
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(T t, T t2);

        public abstract boolean areItemsTheSame(T t, T t2);

        public Object getChangePayload(T t, T t2) {
            return null;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i, int i2, boolean z) {
            this.posInOwnerList = i;
            this.currentPos = i2;
            this.removal = z;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i, int i2, int i3, int i4) {
            this.oldListStart = i;
            this.oldListEnd = i2;
            this.newListStart = i3;
            this.newListEnd = i4;
        }
    }

    static class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int x;
        int y;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    public static DiffResult calculateDiff(Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v7.util.DiffUtil.DiffResult calculateDiff(android.support.v7.util.DiffUtil.Callback r15, boolean r16) {
        /*
            int r0 = r15.getOldListSize()
            int r1 = r15.getNewListSize()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.support.v7.util.DiffUtil$Range r3 = new android.support.v7.util.DiffUtil$Range
            r5 = 0
            r3.<init>(r5, r0, r5, r1)
            r2.add(r3)
            int r3 = r0 + r1
            int r0 = r0 - r1
            int r0 = java.lang.Math.abs(r0)
            int r0 = r0 + r3
            int r1 = r0 * 2
            int[] r13 = new int[r1]
            int[] r1 = new int[r1]
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L_0x002e:
            boolean r5 = r2.isEmpty()
            if (r5 != 0) goto L_0x00e1
            int r5 = r2.size()
            int r5 = r5 + -1
            java.lang.Object r5 = r2.remove(r5)
            r14 = r5
            android.support.v7.util.DiffUtil$Range r14 = (android.support.v7.util.DiffUtil.Range) r14
            int r6 = r14.oldListStart
            int r7 = r14.oldListEnd
            int r8 = r14.newListStart
            int r9 = r14.newListEnd
            r5 = r15
            r10 = r13
            r11 = r1
            r12 = r0
            android.support.v7.util.DiffUtil$Snake r5 = diffPartial(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r5 == 0) goto L_0x00dc
            int r6 = r5.size
            if (r6 <= 0) goto L_0x005a
            r4.add(r5)
        L_0x005a:
            int r6 = r5.x
            int r7 = r14.oldListStart
            int r6 = r6 + r7
            r5.x = r6
            int r6 = r5.y
            int r7 = r14.newListStart
            int r6 = r6 + r7
            r5.y = r6
            boolean r6 = r3.isEmpty()
            if (r6 == 0) goto L_0x0074
            android.support.v7.util.DiffUtil$Range r6 = new android.support.v7.util.DiffUtil$Range
            r6.<init>()
            goto L_0x0080
        L_0x0074:
            int r6 = r3.size()
            int r6 = r6 + -1
            java.lang.Object r6 = r3.remove(r6)
            android.support.v7.util.DiffUtil$Range r6 = (android.support.v7.util.DiffUtil.Range) r6
        L_0x0080:
            int r7 = r14.oldListStart
            r6.oldListStart = r7
            int r7 = r14.newListStart
            r6.newListStart = r7
            boolean r7 = r5.reverse
            if (r7 == 0) goto L_0x0095
            int r7 = r5.x
        L_0x008e:
            r6.oldListEnd = r7
            int r7 = r5.y
        L_0x0092:
            r6.newListEnd = r7
            goto L_0x00a7
        L_0x0095:
            boolean r7 = r5.removal
            if (r7 == 0) goto L_0x009e
            int r7 = r5.x
            int r7 = r7 + -1
            goto L_0x008e
        L_0x009e:
            int r7 = r5.x
            r6.oldListEnd = r7
            int r7 = r5.y
            int r7 = r7 + -1
            goto L_0x0092
        L_0x00a7:
            r2.add(r6)
            boolean r6 = r5.reverse
            if (r6 == 0) goto L_0x00c9
            boolean r6 = r5.removal
            if (r6 == 0) goto L_0x00ba
            int r6 = r5.x
            int r7 = r5.size
            int r6 = r6 + r7
            int r6 = r6 + 1
            goto L_0x00ce
        L_0x00ba:
            int r6 = r5.x
            int r7 = r5.size
            int r6 = r6 + r7
            r14.oldListStart = r6
            int r6 = r5.y
            int r5 = r5.size
            int r6 = r6 + r5
            int r6 = r6 + 1
            goto L_0x00d5
        L_0x00c9:
            int r6 = r5.x
            int r7 = r5.size
            int r6 = r6 + r7
        L_0x00ce:
            r14.oldListStart = r6
            int r6 = r5.y
            int r5 = r5.size
            int r6 = r6 + r5
        L_0x00d5:
            r14.newListStart = r6
            r2.add(r14)
            goto L_0x002e
        L_0x00dc:
            r3.add(r14)
            goto L_0x002e
        L_0x00e1:
            java.util.Comparator<android.support.v7.util.DiffUtil$Snake> r0 = SNAKE_COMPARATOR
            java.util.Collections.sort(r4, r0)
            android.support.v7.util.DiffUtil$DiffResult r0 = new android.support.v7.util.DiffUtil$DiffResult
            r2 = r0
            r3 = r15
            r5 = r13
            r6 = r1
            r7 = r16
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.util.DiffUtil.calculateDiff(android.support.v7.util.DiffUtil$Callback, boolean):android.support.v7.util.DiffUtil$DiffResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r3[r15 - 1] < r3[r15 + r9]) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dd, code lost:
        if (r4[r9 - 1] < r4[r9 + 1]) goto L_0x00ee;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0 A[LOOP:1: B:10:0x0033->B:34:0x00b0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0095 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.support.v7.util.DiffUtil.Snake diffPartial(android.support.v7.util.DiffUtil.Callback r22, int r23, int r24, int r25, int r26, int[] r27, int[] r28, int r29) {
        /*
            r0 = r22
            r3 = r27
            r4 = r28
            int r5 = r24 - r23
            int r6 = r26 - r25
            if (r5 <= 0) goto L_0x0156
            if (r6 > 0) goto L_0x0010
            goto L_0x0156
        L_0x0010:
            int r7 = r5 - r6
            int r8 = r5 + r6
            r9 = 1
            int r8 = r8 + r9
            int r8 = r8 / 2
            int r10 = r29 - r8
            int r10 = r10 - r9
            int r11 = r29 + r8
            int r11 = r11 + r9
            r12 = 0
            java.util.Arrays.fill(r3, r10, r11, r12)
            int r10 = r10 + r7
            int r11 = r11 + r7
            java.util.Arrays.fill(r4, r10, r11, r5)
            int r10 = r7 % 2
            if (r10 == 0) goto L_0x002d
            r10 = 1
            goto L_0x002e
        L_0x002d:
            r10 = 0
        L_0x002e:
            r11 = 0
        L_0x002f:
            if (r11 > r8) goto L_0x014e
            int r13 = -r11
            r14 = r13
        L_0x0033:
            if (r14 > r11) goto L_0x00bd
            if (r14 == r13) goto L_0x0051
            if (r14 == r11) goto L_0x0045
            int r15 = r29 + r14
            int r16 = r15 + -1
            r12 = r3[r16]
            int r15 = r15 + r9
            r9 = r3[r15]
            if (r12 >= r9) goto L_0x0045
            goto L_0x0051
        L_0x0045:
            int r9 = r29 + r14
            r17 = 1
            int r9 = r9 + -1
            r9 = r3[r9]
            int r9 = r9 + 1
            r12 = 1
            goto L_0x005a
        L_0x0051:
            r17 = 1
            int r9 = r29 + r14
            int r9 = r9 + 1
            r9 = r3[r9]
            r12 = 0
        L_0x005a:
            int r15 = r9 - r14
            r18 = r8
            r8 = r15
        L_0x005f:
            if (r9 >= r5) goto L_0x007a
            if (r8 >= r6) goto L_0x007a
            r19 = r5
            int r5 = r23 + r9
            r20 = r6
            int r6 = r25 + r8
            boolean r5 = r0.areItemsTheSame(r5, r6)
            if (r5 == 0) goto L_0x007e
            int r9 = r9 + 1
            int r8 = r8 + 1
            r5 = r19
            r6 = r20
            goto L_0x005f
        L_0x007a:
            r19 = r5
            r20 = r6
        L_0x007e:
            int r5 = r29 + r14
            r3[r5] = r9
            if (r10 == 0) goto L_0x00b0
            int r6 = r7 - r11
            r8 = 1
            int r6 = r6 + r8
            if (r14 < r6) goto L_0x00b0
            int r6 = r7 + r11
            int r6 = r6 - r8
            if (r14 > r6) goto L_0x00b0
            r6 = r3[r5]
            r8 = r4[r5]
            if (r6 < r8) goto L_0x00b0
            android.support.v7.util.DiffUtil$Snake r0 = new android.support.v7.util.DiffUtil$Snake
            r0.<init>()
            r1 = r4[r5]
            r0.x = r1
            int r1 = r0.x
            int r1 = r1 - r14
            r0.y = r1
            r1 = r3[r5]
            r2 = r4[r5]
            int r1 = r1 - r2
            r0.size = r1
            r0.removal = r12
            r5 = 0
            r0.reverse = r5
            return r0
        L_0x00b0:
            r5 = 0
            int r14 = r14 + 2
            r8 = r18
            r5 = r19
            r6 = r20
            r9 = 1
            r12 = 0
            goto L_0x0033
        L_0x00bd:
            r19 = r5
            r20 = r6
            r18 = r8
            r5 = 0
            r6 = r13
        L_0x00c5:
            if (r6 > r11) goto L_0x0141
            int r8 = r6 + r7
            int r9 = r11 + r7
            if (r8 == r9) goto L_0x00ec
            int r9 = r13 + r7
            if (r8 == r9) goto L_0x00e0
            int r9 = r29 + r8
            int r12 = r9 + -1
            r12 = r4[r12]
            r17 = 1
            int r9 = r9 + 1
            r9 = r4[r9]
            if (r12 >= r9) goto L_0x00e2
            goto L_0x00ee
        L_0x00e0:
            r17 = 1
        L_0x00e2:
            int r9 = r29 + r8
            int r9 = r9 + 1
            r9 = r4[r9]
            int r9 = r9 + -1
            r12 = 1
            goto L_0x00f5
        L_0x00ec:
            r17 = 1
        L_0x00ee:
            int r9 = r29 + r8
            int r9 = r9 + -1
            r9 = r4[r9]
            r12 = 0
        L_0x00f5:
            int r14 = r9 - r8
        L_0x00f7:
            if (r9 <= 0) goto L_0x0111
            if (r14 <= 0) goto L_0x0111
            int r15 = r23 + r9
            int r5 = r15 + -1
            int r15 = r25 + r14
            int r1 = r15 + -1
            boolean r1 = r0.areItemsTheSame(r5, r1)
            if (r1 == 0) goto L_0x0111
            int r9 = r9 + -1
            int r14 = r14 + -1
            r5 = 0
            r17 = 1
            goto L_0x00f7
        L_0x0111:
            int r1 = r29 + r8
            r4[r1] = r9
            if (r10 != 0) goto L_0x013c
            if (r8 < r13) goto L_0x013c
            if (r8 > r11) goto L_0x013c
            r5 = r3[r1]
            r9 = r4[r1]
            if (r5 < r9) goto L_0x013c
            android.support.v7.util.DiffUtil$Snake r0 = new android.support.v7.util.DiffUtil$Snake
            r0.<init>()
            r2 = r4[r1]
            r0.x = r2
            int r2 = r0.x
            int r2 = r2 - r8
            r0.y = r2
            r2 = r3[r1]
            r1 = r4[r1]
            int r2 = r2 - r1
            r0.size = r2
            r0.removal = r12
            r1 = 1
            r0.reverse = r1
            return r0
        L_0x013c:
            r1 = 1
            int r6 = r6 + 2
            r5 = 0
            goto L_0x00c5
        L_0x0141:
            r1 = 1
            int r11 = r11 + 1
            r8 = r18
            r5 = r19
            r6 = r20
            r9 = 1
            r12 = 0
            goto L_0x002f
        L_0x014e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation."
            r0.<init>(r1)
            throw r0
        L_0x0156:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.util.DiffUtil.diffPartial(android.support.v7.util.DiffUtil$Callback, int, int, int, int, int[], int[], int):android.support.v7.util.DiffUtil$Snake");
    }
}
