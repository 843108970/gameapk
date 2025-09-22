package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FragmentTransition {
    private static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final FragmentTransitionImpl PLATFORM_IMPL = (Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null);
    private static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();

    static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
        if (r6.mAdded != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0064, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
        r8 = r12;
        r12 = true;
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0080, code lost:
        if (r6.mHidden == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0082, code lost:
        r12 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void addToFirstInLastOut(android.support.v4.app.BackStackRecord r11, android.support.v4.app.BackStackRecord.Op r12, android.util.SparseArray<android.support.v4.app.FragmentTransition.FragmentContainerTransition> r13, boolean r14, boolean r15) {
        /*
            android.support.v4.app.Fragment r6 = r12.fragment
            if (r6 != 0) goto L_0x0005
            return
        L_0x0005:
            int r7 = r6.mContainerId
            if (r7 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r14 == 0) goto L_0x0013
            int[] r0 = INVERSE_OPS
            int r12 = r12.cmd
            r12 = r0[r12]
            goto L_0x0015
        L_0x0013:
            int r12 = r12.cmd
        L_0x0015:
            r0 = 0
            r1 = 1
            if (r12 == r1) goto L_0x0075
            switch(r12) {
                case 3: goto L_0x004b;
                case 4: goto L_0x0033;
                case 5: goto L_0x0021;
                case 6: goto L_0x004b;
                case 7: goto L_0x0075;
                default: goto L_0x001c;
            }
        L_0x001c:
            r12 = 0
            r1 = 0
        L_0x001e:
            r8 = 0
            goto L_0x0088
        L_0x0021:
            if (r15 == 0) goto L_0x0030
            boolean r12 = r6.mHiddenChanged
            if (r12 == 0) goto L_0x0084
            boolean r12 = r6.mHidden
            if (r12 != 0) goto L_0x0084
            boolean r12 = r6.mAdded
            if (r12 == 0) goto L_0x0084
            goto L_0x0082
        L_0x0030:
            boolean r12 = r6.mHidden
            goto L_0x0085
        L_0x0033:
            if (r15 == 0) goto L_0x0042
            boolean r12 = r6.mHiddenChanged
            if (r12 == 0) goto L_0x0066
            boolean r12 = r6.mAdded
            if (r12 == 0) goto L_0x0066
            boolean r12 = r6.mHidden
            if (r12 == 0) goto L_0x0066
        L_0x0041:
            goto L_0x0064
        L_0x0042:
            boolean r12 = r6.mAdded
            if (r12 == 0) goto L_0x0066
            boolean r12 = r6.mHidden
            if (r12 != 0) goto L_0x0066
            goto L_0x0041
        L_0x004b:
            if (r15 == 0) goto L_0x0068
            boolean r12 = r6.mAdded
            if (r12 != 0) goto L_0x0066
            android.view.View r12 = r6.mView
            if (r12 == 0) goto L_0x0066
            android.view.View r12 = r6.mView
            int r12 = r12.getVisibility()
            if (r12 != 0) goto L_0x0066
            float r12 = r6.mPostponedAlpha
            r2 = 0
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x0066
        L_0x0064:
            r12 = 1
            goto L_0x0071
        L_0x0066:
            r12 = 0
            goto L_0x0071
        L_0x0068:
            boolean r12 = r6.mAdded
            if (r12 == 0) goto L_0x0066
            boolean r12 = r6.mHidden
            if (r12 != 0) goto L_0x0066
            goto L_0x0064
        L_0x0071:
            r8 = r12
            r12 = 1
            r1 = 0
            goto L_0x0088
        L_0x0075:
            if (r15 == 0) goto L_0x007a
            boolean r12 = r6.mIsNewlyAdded
            goto L_0x0085
        L_0x007a:
            boolean r12 = r6.mAdded
            if (r12 != 0) goto L_0x0084
            boolean r12 = r6.mHidden
            if (r12 != 0) goto L_0x0084
        L_0x0082:
            r12 = 1
            goto L_0x0085
        L_0x0084:
            r12 = 0
        L_0x0085:
            r0 = r12
            r12 = 0
            goto L_0x001e
        L_0x0088:
            java.lang.Object r2 = r13.get(r7)
            android.support.v4.app.FragmentTransition$FragmentContainerTransition r2 = (android.support.v4.app.FragmentTransition.FragmentContainerTransition) r2
            if (r0 == 0) goto L_0x009a
            android.support.v4.app.FragmentTransition$FragmentContainerTransition r2 = ensureContainer(r2, r13, r7)
            r2.lastIn = r6
            r2.lastInIsPop = r14
            r2.lastInTransaction = r11
        L_0x009a:
            r9 = r2
            r10 = 0
            if (r15 != 0) goto L_0x00c1
            if (r1 == 0) goto L_0x00c1
            if (r9 == 0) goto L_0x00a8
            android.support.v4.app.Fragment r0 = r9.firstOut
            if (r0 != r6) goto L_0x00a8
            r9.firstOut = r10
        L_0x00a8:
            android.support.v4.app.FragmentManagerImpl r0 = r11.mManager
            int r1 = r6.mState
            if (r1 > 0) goto L_0x00c1
            int r1 = r0.mCurState
            if (r1 <= 0) goto L_0x00c1
            boolean r1 = r11.mReorderingAllowed
            if (r1 != 0) goto L_0x00c1
            r0.makeActive(r6)
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
            r1 = r6
            r0.moveToState(r1, r2, r3, r4, r5)
        L_0x00c1:
            if (r8 == 0) goto L_0x00d3
            if (r9 == 0) goto L_0x00c9
            android.support.v4.app.Fragment r0 = r9.firstOut
            if (r0 != 0) goto L_0x00d3
        L_0x00c9:
            android.support.v4.app.FragmentTransition$FragmentContainerTransition r9 = ensureContainer(r9, r13, r7)
            r9.firstOut = r6
            r9.firstOutIsPop = r14
            r9.firstOutTransaction = r11
        L_0x00d3:
            if (r15 != 0) goto L_0x00df
            if (r12 == 0) goto L_0x00df
            if (r9 == 0) goto L_0x00df
            android.support.v4.app.Fragment r11 = r9.lastIn
            if (r11 != r6) goto L_0x00df
            r9.lastIn = r10
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentTransition.addToFirstInLastOut(android.support.v4.app.BackStackRecord, android.support.v4.app.BackStackRecord$Op, android.util.SparseArray, boolean, boolean):void");
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(i), sparseArray, false, z);
        }
    }

    private static ArrayMap<String, String> calculateNameOverrides(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (backStackRecord.mSharedElementSourceNames != null) {
                    int size = backStackRecord.mSharedElementSourceNames.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        ArrayList<String> arrayList5 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.mManager.mContainer.onHasView()) {
            for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
                addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(size), sparseArray, true, z);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback = z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.keyAt(i));
                arrayList.add(arrayMap.valueAt(i));
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, (List<View>) null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    private static boolean canHandleAll(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        String findKeyForValue;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (fragmentContainerTransition.lastInIsPop) {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String findKeyForValue2 = findKeyForValue(arrayMap, str);
                    if (findKeyForValue2 != null) {
                        arrayMap.remove(findKeyForValue2);
                    }
                } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (findKeyForValue = findKeyForValue(arrayMap, str)) != null) {
                    arrayMap.put(findKeyForValue, ViewCompat.getTransitionName(view2));
                }
            }
        } else {
            retainValues(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.findNamedViews(arrayMap2, fragment.getView());
        BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
        if (fragmentContainerTransition.firstOutIsPop) {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.mSharedElementTargetNames;
        } else {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.mSharedElementSourceNames;
        }
        arrayMap2.retainAll(arrayList);
        if (sharedElementCallback != null) {
            sharedElementCallback.onMapSharedElements(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                    arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    private static FragmentTransitionImpl chooseImpl(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (PLATFORM_IMPL != null && canHandleAll(PLATFORM_IMPL, arrayList)) {
            return PLATFORM_IMPL;
        }
        if (SUPPORT_IMPL != null && canHandleAll(SUPPORT_IMPL, arrayList)) {
            return SUPPORT_IMPL;
        }
        if (PLATFORM_IMPL == null && SUPPORT_IMPL == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* access modifiers changed from: private */
    public static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.captureTransitioningViews(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    private static Object configureSharedElementsOrdered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Object obj4;
        Rect rect;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        final ArrayList<View> arrayList3 = arrayList;
        final Object obj5 = obj;
        Fragment fragment = fragmentContainerTransition2.lastIn;
        Fragment fragment2 = fragmentContainerTransition2.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition2.lastInIsPop;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            obj3 = null;
        } else {
            obj3 = getSharedElementTransition(fragmentTransitionImpl2, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl2, arrayMap2, obj3, fragmentContainerTransition2);
        if (arrayMap.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(captureOutSharedElements.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj4 != null) {
            rect = new Rect();
            fragmentTransitionImpl2.setSharedElementTargets(obj4, view, arrayList3);
            setOutEpicenter(fragmentTransitionImpl2, obj4, obj2, captureOutSharedElements, fragmentContainerTransition2.firstOutIsPop, fragmentContainerTransition2.firstOutTransaction);
            if (obj5 != null) {
                fragmentTransitionImpl2.setEpicenter(obj5, rect);
            }
        } else {
            rect = null;
        }
        final FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        final ArrayMap<String, String> arrayMap3 = arrayMap2;
        final Object obj6 = obj4;
        final FragmentContainerTransition fragmentContainerTransition3 = fragmentContainerTransition2;
        AnonymousClass4 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final Rect rect2 = rect;
        AnonymousClass4 r0 = new Runnable() {
            public final void run() {
                ArrayMap access$300 = FragmentTransition.captureInSharedElements(fragmentTransitionImpl3, arrayMap3, obj6, fragmentContainerTransition3);
                if (access$300 != null) {
                    arrayList4.addAll(access$300.values());
                    arrayList4.add(view2);
                }
                FragmentTransition.callSharedElementStartEnd(fragment3, fragment4, z2, access$300, false);
                if (obj6 != null) {
                    fragmentTransitionImpl3.swapSharedElementTargets(obj6, arrayList3, arrayList4);
                    View access$400 = FragmentTransition.getInEpicenterView(access$300, fragmentContainerTransition3, obj5, z2);
                    if (access$400 != null) {
                        fragmentTransitionImpl3.getBoundsOnScreen(access$400, rect2);
                    }
                }
            }
        };
        OneShotPreDrawListener.add(viewGroup, r13);
        return obj4;
    }

    private static Object configureSharedElementsReordered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View view2;
        final FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        View view3 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj4 = obj;
        Fragment fragment = fragmentContainerTransition2.lastIn;
        Fragment fragment2 = fragmentContainerTransition2.firstOut;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = fragmentContainerTransition2.lastInIsPop;
        Object sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragmentTransitionImpl2, fragment, fragment2, z);
        ArrayMap<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl2, arrayMap2, sharedElementTransition, fragmentContainerTransition2);
        ArrayMap<String, View> captureInSharedElements = captureInSharedElements(fragmentTransitionImpl2, arrayMap2, sharedElementTransition, fragmentContainerTransition2);
        if (arrayMap.isEmpty()) {
            if (captureOutSharedElements != null) {
                captureOutSharedElements.clear();
            }
            if (captureInSharedElements != null) {
                captureInSharedElements.clear();
            }
            obj3 = null;
        } else {
            addSharedElementsWithMatchingNames(arrayList3, captureOutSharedElements, arrayMap.keySet());
            addSharedElementsWithMatchingNames(arrayList4, captureInSharedElements, arrayMap.values());
            obj3 = sharedElementTransition;
        }
        if (obj4 == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z, captureOutSharedElements, true);
        if (obj3 != null) {
            arrayList4.add(view3);
            fragmentTransitionImpl2.setSharedElementTargets(obj3, view3, arrayList3);
            setOutEpicenter(fragmentTransitionImpl2, obj3, obj2, captureOutSharedElements, fragmentContainerTransition2.firstOutIsPop, fragmentContainerTransition2.firstOutTransaction);
            Rect rect2 = new Rect();
            View inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition2, obj4, z);
            if (inEpicenterView != null) {
                fragmentTransitionImpl2.setEpicenter(obj4, rect2);
            }
            rect = rect2;
            view2 = inEpicenterView;
        } else {
            view2 = null;
            rect = null;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final ArrayMap<String, View> arrayMap3 = captureInSharedElements;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            public final void run() {
                FragmentTransition.callSharedElementStartEnd(fragment3, fragment4, z2, arrayMap3, false);
                if (view2 != null) {
                    fragmentTransitionImpl2.getBoundsOnScreen(view2, rect);
                }
            }
        });
        return obj3;
    }

    private static void configureTransitionsOrdered(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl chooseImpl;
        Object obj;
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        ViewGroup viewGroup = fragmentManagerImpl2.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl2.mContainer.onFindViewById(i) : null;
        if (viewGroup != null && (chooseImpl = chooseImpl(fragment2, fragment)) != null) {
            boolean z = fragmentContainerTransition2.lastInIsPop;
            boolean z2 = fragmentContainerTransition2.firstOutIsPop;
            Object enterTransition = getEnterTransition(chooseImpl, (fragment = fragmentContainerTransition2.lastIn), z);
            Object exitTransition = getExitTransition(chooseImpl, (fragment2 = fragmentContainerTransition2.firstOut), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = exitTransition;
            FragmentTransitionImpl fragmentTransitionImpl = chooseImpl;
            Object configureSharedElementsOrdered = configureSharedElementsOrdered(chooseImpl, viewGroup, view2, arrayMap2, fragmentContainerTransition2, arrayList, arrayList2, enterTransition, obj2);
            Object obj3 = enterTransition;
            if (obj3 == null && configureSharedElementsOrdered == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(fragmentTransitionImpl, obj, fragment2, arrayList3, view2);
            Object obj4 = (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) ? null : obj;
            fragmentTransitionImpl.addTarget(obj3, view2);
            Object mergeTransitions = mergeTransitions(fragmentTransitionImpl, obj3, obj4, configureSharedElementsOrdered, fragment, fragmentContainerTransition2.lastInIsPop);
            if (mergeTransitions != null) {
                ArrayList arrayList4 = new ArrayList();
                FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
                fragmentTransitionImpl2.scheduleRemoveTargets(mergeTransitions, obj3, arrayList4, obj4, configureEnteringExitingViews, configureSharedElementsOrdered, arrayList2);
                scheduleTargetChange(fragmentTransitionImpl2, viewGroup, fragment, view2, arrayList2, obj3, arrayList4, obj4, configureEnteringExitingViews);
                ArrayList arrayList5 = arrayList2;
                fragmentTransitionImpl.setNameOverridesOrdered(viewGroup, arrayList5, arrayMap2);
                fragmentTransitionImpl.beginDelayedTransition(viewGroup, mergeTransitions);
                fragmentTransitionImpl.scheduleNameReset(viewGroup, arrayList5, arrayMap2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r11 = r4.lastIn;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void configureTransitionsReordered(android.support.v4.app.FragmentManagerImpl r19, int r20, android.support.v4.app.FragmentTransition.FragmentContainerTransition r21, android.view.View r22, android.support.v4.util.ArrayMap<java.lang.String, java.lang.String> r23) {
        /*
            r0 = r19
            r4 = r21
            r9 = r22
            android.support.v4.app.FragmentContainer r1 = r0.mContainer
            boolean r1 = r1.onHasView()
            if (r1 == 0) goto L_0x0019
            android.support.v4.app.FragmentContainer r0 = r0.mContainer
            r1 = r20
            android.view.View r0 = r0.onFindViewById(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r10 = r0
            if (r10 != 0) goto L_0x001e
            return
        L_0x001e:
            android.support.v4.app.Fragment r11 = r4.lastIn
            android.support.v4.app.Fragment r12 = r4.firstOut
            android.support.v4.app.FragmentTransitionImpl r13 = chooseImpl(r12, r11)
            if (r13 != 0) goto L_0x0029
            return
        L_0x0029:
            boolean r14 = r4.lastInIsPop
            boolean r0 = r4.firstOutIsPop
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.Object r7 = getEnterTransition(r13, r11, r14)
            java.lang.Object r6 = getExitTransition(r13, r12, r0)
            r0 = r13
            r1 = r10
            r2 = r9
            r3 = r23
            r5 = r8
            r16 = r6
            r6 = r15
            r17 = r7
            r18 = r10
            r10 = r8
            r8 = r16
            java.lang.Object r8 = configureSharedElementsReordered(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r17
            if (r6 != 0) goto L_0x005e
            if (r8 != 0) goto L_0x005e
            r7 = r16
            if (r7 != 0) goto L_0x0060
            return
        L_0x005e:
            r7 = r16
        L_0x0060:
            java.util.ArrayList r5 = configureEnteringExitingViews(r13, r7, r12, r10, r9)
            java.util.ArrayList r9 = configureEnteringExitingViews(r13, r6, r11, r15, r9)
            r0 = 4
            setViewVisibility(r9, r0)
            r0 = r13
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r11
            r11 = r5
            r5 = r14
            java.lang.Object r14 = mergeTransitions(r0, r1, r2, r3, r4, r5)
            if (r14 == 0) goto L_0x00a1
            replaceHide(r13, r7, r12, r11)
            java.util.ArrayList r12 = r13.prepareSetNameOverridesReordered(r15)
            r0 = r13
            r1 = r14
            r2 = r6
            r3 = r9
            r4 = r7
            r5 = r11
            r6 = r8
            r7 = r15
            r0.scheduleRemoveTargets(r1, r2, r3, r4, r5, r6, r7)
            r0 = r18
            r13.beginDelayedTransition(r0, r14)
            r1 = r13
            r2 = r0
            r3 = r10
            r4 = r15
            r5 = r12
            r6 = r23
            r1.setNameOverridesReordered(r2, r3, r4, r5, r6)
            r0 = 0
            setViewVisibility(r9, r0)
            r13.swapSharedElementTargets(r8, r10, r15)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentTransition.configureTransitionsReordered(android.support.v4.app.FragmentManagerImpl, int, android.support.v4.app.FragmentTransition$FragmentContainerTransition, android.view.View, android.support.v4.util.ArrayMap):void");
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    private static String findKeyForValue(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    private static Object getEnterTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object getExitTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return fragmentTransitionImpl.cloneTransition(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    /* access modifiers changed from: private */
    public static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || backStackRecord.mSharedElementSourceNames == null || backStackRecord.mSharedElementSourceNames.isEmpty()) {
            return null;
        }
        return arrayMap.get((z ? backStackRecord.mSharedElementSourceNames : backStackRecord.mSharedElementTargetNames).get(0));
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    private static Object mergeTransitions(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3) : fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    private static void replaceHide(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() {
                public final void run() {
                    FragmentTransition.setViewVisibility(arrayList, 4);
                }
            });
        }
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            return (FragmentTransitionImpl) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    private static void scheduleTargetChange(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        OneShotPreDrawListener.add(viewGroup, new Runnable() {
            public final void run() {
                if (obj3 != null) {
                    fragmentTransitionImpl2.removeTarget(obj3, view2);
                    arrayList5.addAll(FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl2, obj3, fragment2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        fragmentTransitionImpl2.replaceTargets(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static void setOutEpicenter(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        if (backStackRecord.mSharedElementSourceNames != null && !backStackRecord.mSharedElementSourceNames.isEmpty()) {
            View view = arrayMap.get((z ? backStackRecord.mSharedElementTargetNames : backStackRecord.mSharedElementSourceNames).get(0));
            fragmentTransitionImpl.setEpicenter(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.setEpicenter(obj2, view);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    static void startTransitions(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.mCurState > 0) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                BackStackRecord backStackRecord = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    calculatePopFragments(backStackRecord, sparseArray, z);
                } else {
                    calculateFragments(backStackRecord, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl.mHost.getContext());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    ArrayMap<String, String> calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i, i2);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i4);
                    if (z) {
                        configureTransitionsReordered(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    } else {
                        configureTransitionsOrdered(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, calculateNameOverrides);
                    }
                }
            }
        }
    }

    static boolean supportsTransition() {
        return (PLATFORM_IMPL == null && SUPPORT_IMPL == null) ? false : true;
    }
}
