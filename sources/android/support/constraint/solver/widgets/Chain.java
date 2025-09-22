package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            int i5 = constraintWidgetContainer.mVerticalChainsSize;
            i2 = i5;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            ChainHead chainHead = chainHeadArr[i6];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4) || !Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x0033;
     */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0358 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x044d  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0506  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x050b  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r44, android.support.constraint.solver.LinearSystem r45, int r46, int r47, android.support.constraint.solver.widgets.ChainHead r48) {
        /*
            r0 = r44
            r9 = r45
            r1 = r48
            android.support.constraint.solver.widgets.ConstraintWidget r11 = r1.mFirst
            android.support.constraint.solver.widgets.ConstraintWidget r12 = r1.mLast
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r1.mFirstVisibleWidget
            android.support.constraint.solver.widgets.ConstraintWidget r14 = r1.mLastVisibleWidget
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r46]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x001d
            r4 = 1
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            r5 = 2
            if (r46 != 0) goto L_0x003e
            int r8 = r2.mHorizontalChainStyle
            if (r8 != 0) goto L_0x0027
            r8 = 1
            goto L_0x0028
        L_0x0027:
            r8 = 0
        L_0x0028:
            int r6 = r2.mHorizontalChainStyle
            if (r6 != r7) goto L_0x002e
            r6 = 1
            goto L_0x002f
        L_0x002e:
            r6 = 0
        L_0x002f:
            int r7 = r2.mHorizontalChainStyle
            if (r7 != r5) goto L_0x0035
        L_0x0033:
            r5 = 1
            goto L_0x0036
        L_0x0035:
            r5 = 0
        L_0x0036:
            r7 = r5
            r18 = r6
            r17 = r8
            r5 = r11
            r6 = 0
            goto L_0x0052
        L_0x003e:
            int r6 = r2.mVerticalChainStyle
            if (r6 != 0) goto L_0x0044
            r8 = 1
            goto L_0x0045
        L_0x0044:
            r8 = 0
        L_0x0045:
            int r6 = r2.mVerticalChainStyle
            r7 = 1
            if (r6 != r7) goto L_0x004c
            r6 = 1
            goto L_0x004d
        L_0x004c:
            r6 = 0
        L_0x004d:
            int r7 = r2.mVerticalChainStyle
            if (r7 != r5) goto L_0x0035
            goto L_0x0033
        L_0x0052:
            r21 = 0
            if (r6 != 0) goto L_0x013a
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r5.mListAnchors
            r8 = r8[r47]
            if (r4 != 0) goto L_0x0062
            if (r7 == 0) goto L_0x005f
            goto L_0x0062
        L_0x005f:
            r22 = 4
            goto L_0x0064
        L_0x0062:
            r22 = 1
        L_0x0064:
            int r23 = r8.getMargin()
            r24 = r3
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r8.mTarget
            if (r3 == 0) goto L_0x0078
            if (r5 == r11) goto L_0x0078
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r8.mTarget
            int r3 = r3.getMargin()
            int r23 = r23 + r3
        L_0x0078:
            r3 = r23
            if (r7 == 0) goto L_0x0086
            if (r5 == r11) goto L_0x0086
            if (r5 == r13) goto L_0x0086
            r26 = r2
            r25 = r6
            r6 = 6
            goto L_0x0096
        L_0x0086:
            if (r17 == 0) goto L_0x0090
            if (r4 == 0) goto L_0x0090
            r26 = r2
            r25 = r6
            r6 = 4
            goto L_0x0096
        L_0x0090:
            r26 = r2
            r25 = r6
            r6 = r22
        L_0x0096:
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r8.mTarget
            if (r2 == 0) goto L_0x00c3
            if (r5 != r13) goto L_0x00ab
            android.support.constraint.solver.SolverVariable r2 = r8.mSolverVariable
            r27 = r11
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r8.mTarget
            android.support.constraint.solver.SolverVariable r11 = r11.mSolverVariable
            r28 = r7
            r7 = 5
            r9.addGreaterThan(r2, r11, r3, r7)
            goto L_0x00b9
        L_0x00ab:
            r28 = r7
            r27 = r11
            android.support.constraint.solver.SolverVariable r2 = r8.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r8.mTarget
            android.support.constraint.solver.SolverVariable r7 = r7.mSolverVariable
            r11 = 6
            r9.addGreaterThan(r2, r7, r3, r11)
        L_0x00b9:
            android.support.constraint.solver.SolverVariable r2 = r8.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r8.mTarget
            android.support.constraint.solver.SolverVariable r7 = r7.mSolverVariable
            r9.addEquality(r2, r7, r3, r6)
            goto L_0x00c7
        L_0x00c3:
            r28 = r7
            r27 = r11
        L_0x00c7:
            if (r4 == 0) goto L_0x00fe
            int r2 = r5.getVisibility()
            r3 = 8
            if (r2 == r3) goto L_0x00ed
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r5.mListDimensionBehaviors
            r2 = r2[r46]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00ed
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r5.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            r3 = r3[r47]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            r6 = 0
            r7 = 5
            r9.addGreaterThan(r2, r3, r6, r7)
            goto L_0x00ee
        L_0x00ed:
            r6 = 0
        L_0x00ee:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r5.mListAnchors
            r2 = r2[r47]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r47]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            r7 = 6
            r9.addGreaterThan(r2, r3, r6, r7)
        L_0x00fe:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r5.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x011f
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.mOwner
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x011f
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r5) goto L_0x011d
            goto L_0x011f
        L_0x011d:
            r21 = r2
        L_0x011f:
            if (r21 == 0) goto L_0x012f
            r5 = r21
            r3 = r24
            r6 = r25
            r2 = r26
            r11 = r27
            r7 = r28
            goto L_0x0052
        L_0x012f:
            r3 = r24
            r2 = r26
            r11 = r27
            r7 = r28
            r6 = 1
            goto L_0x0052
        L_0x013a:
            r26 = r2
            r24 = r3
            r28 = r7
            r27 = r11
            if (r14 == 0) goto L_0x0166
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0166
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            r2 = r2[r3]
            android.support.constraint.solver.SolverVariable r5 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r3 = r6[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r8 = 5
            r9.addLowerThan(r5, r3, r2, r8)
            goto L_0x0167
        L_0x0166:
            r8 = 5
        L_0x0167:
            if (r4 == 0) goto L_0x0183
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r2 = r47 + 1
            r0 = r0[r2]
            android.support.constraint.solver.SolverVariable r0 = r0.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r12.mListAnchors
            r3 = r3[r2]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r2 = r4[r2]
            int r2 = r2.getMargin()
            r4 = 6
            r9.addGreaterThan(r0, r3, r2, r4)
        L_0x0183:
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r0 = r1.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x0233
            int r2 = r0.size()
            r7 = 1
            if (r2 <= r7) goto L_0x0233
            boolean r3 = r1.mHasUndefinedWeights
            if (r3 == 0) goto L_0x019b
            boolean r3 = r1.mHasComplexMatchWeights
            if (r3 != 0) goto L_0x019b
            int r3 = r1.mWidgetsMatchCount
            float r3 = (float) r3
            r24 = r3
        L_0x019b:
            r3 = 0
            r5 = r21
            r4 = 0
            r30 = 0
        L_0x01a1:
            if (r4 >= r2) goto L_0x0233
            java.lang.Object r6 = r0.get(r4)
            android.support.constraint.solver.widgets.ConstraintWidget r6 = (android.support.constraint.solver.widgets.ConstraintWidget) r6
            float[] r11 = r6.mWeight
            r11 = r11[r46]
            int r16 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r16 >= 0) goto L_0x01d1
            boolean r11 = r1.mHasComplexMatchWeights
            if (r11 == 0) goto L_0x01cb
            android.support.constraint.solver.widgets.ConstraintAnchor[] r11 = r6.mListAnchors
            int r16 = r47 + 1
            r11 = r11[r16]
            android.support.constraint.solver.SolverVariable r11 = r11.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r6.mListAnchors
            r6 = r6[r47]
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r7 = 0
            r8 = 4
            r9.addEquality(r11, r6, r7, r8)
            r8 = 6
            r11 = 0
            goto L_0x01e9
        L_0x01cb:
            r8 = 4
            r7 = 1065353216(0x3f800000, float:1.0)
            r11 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01d2
        L_0x01d1:
            r8 = 4
        L_0x01d2:
            int r7 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x01ec
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            int r11 = r47 + 1
            r7 = r7[r11]
            android.support.constraint.solver.SolverVariable r7 = r7.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r6.mListAnchors
            r6 = r6[r47]
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r8 = 6
            r11 = 0
            r9.addEquality(r7, r6, r11, r8)
        L_0x01e9:
            r38 = r0
            goto L_0x022a
        L_0x01ec:
            r7 = 0
            r8 = 6
            if (r5 == 0) goto L_0x0225
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            r3 = r3[r47]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r5.mListAnchors
            int r15 = r47 + 1
            r5 = r5[r15]
            android.support.constraint.solver.SolverVariable r5 = r5.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            r7 = r7[r47]
            android.support.constraint.solver.SolverVariable r7 = r7.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r6.mListAnchors
            r8 = r8[r15]
            android.support.constraint.solver.SolverVariable r8 = r8.mSolverVariable
            r38 = r0
            android.support.constraint.solver.ArrayRow r0 = r45.createRow()
            r29 = r0
            r31 = r24
            r32 = r11
            r33 = r3
            r34 = r5
            r35 = r7
            r36 = r8
            r29.createRowEqualMatchDimensions(r30, r31, r32, r33, r34, r35, r36)
            r9.addConstraint(r0)
            goto L_0x0227
        L_0x0225:
            r38 = r0
        L_0x0227:
            r5 = r6
            r30 = r11
        L_0x022a:
            int r4 = r4 + 1
            r0 = r38
            r3 = 0
            r7 = 1
            r8 = 5
            goto L_0x01a1
        L_0x0233:
            if (r13 == 0) goto L_0x029f
            if (r13 == r14) goto L_0x0239
            if (r28 == 0) goto L_0x029f
        L_0x0239:
            r11 = r27
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r11.mListAnchors
            r0 = r0[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0256
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0258
        L_0x0256:
            r3 = r21
        L_0x0258:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x026a
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.SolverVariable r4 = r4.mSolverVariable
            r5 = r4
            goto L_0x026c
        L_0x026a:
            r5 = r21
        L_0x026c:
            if (r13 != r14) goto L_0x0276
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r2]
        L_0x0276:
            if (r3 == 0) goto L_0x04e7
            if (r5 == 0) goto L_0x04e7
            if (r46 != 0) goto L_0x0282
            r2 = r26
            float r2 = r2.mHorizontalBiasPercent
        L_0x0280:
            r4 = r2
            goto L_0x0287
        L_0x0282:
            r2 = r26
            float r2 = r2.mVerticalBiasPercent
            goto L_0x0280
        L_0x0287:
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            android.support.constraint.solver.SolverVariable r2 = r0.mSolverVariable
            android.support.constraint.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04e7
        L_0x029f:
            r11 = r27
            if (r17 == 0) goto L_0x03b7
            if (r13 == 0) goto L_0x03b7
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02b2
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x02b2
            r37 = 1
            goto L_0x02b4
        L_0x02b2:
            r37 = 0
        L_0x02b4:
            r7 = r13
            r8 = r7
        L_0x02b6:
            if (r8 == 0) goto L_0x04e7
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r0 = r0[r46]
            r6 = r0
        L_0x02bd:
            if (r6 == 0) goto L_0x02cc
            int r0 = r6.getVisibility()
            r5 = 8
            if (r0 != r5) goto L_0x02ce
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r6.mNextChainWidget
            r6 = r0[r46]
            goto L_0x02bd
        L_0x02cc:
            r5 = 8
        L_0x02ce:
            if (r6 != 0) goto L_0x02e3
            if (r8 != r14) goto L_0x02d3
            goto L_0x02e3
        L_0x02d3:
            r20 = r6
            r41 = r7
            r42 = r11
            r40 = r12
            r11 = 8
            r15 = 6
            r19 = 4
            r12 = r8
            goto L_0x03a5
        L_0x02e3:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            r0 = r0[r47]
            android.support.constraint.solver.SolverVariable r1 = r0.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x02f2
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x02f4
        L_0x02f2:
            r2 = r21
        L_0x02f4:
            if (r7 == r8) goto L_0x02ff
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
        L_0x02fc:
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0314
        L_0x02ff:
            if (r8 != r13) goto L_0x0314
            if (r7 != r8) goto L_0x0314
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0312
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            goto L_0x02fc
        L_0x0312:
            r2 = r21
        L_0x0314:
            int r0 = r0.getMargin()
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r8.mListAnchors
            int r4 = r47 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r6 == 0) goto L_0x032f
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r6.mListAnchors
            r5 = r5[r47]
            r39 = r6
        L_0x032a:
            android.support.constraint.solver.SolverVariable r6 = r5.mSolverVariable
            r40 = r12
            goto L_0x033e
        L_0x032f:
            r39 = r6
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r12.mListAnchors
            r5 = r5[r4]
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x033a
            goto L_0x032a
        L_0x033a:
            r40 = r12
            r6 = r21
        L_0x033e:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r12 = r8.mListAnchors
            r12 = r12[r4]
            android.support.constraint.solver.SolverVariable r12 = r12.mSolverVariable
            if (r5 == 0) goto L_0x034b
            int r5 = r5.getMargin()
            int r3 = r3 + r5
        L_0x034b:
            if (r7 == 0) goto L_0x0356
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            int r0 = r0 + r5
        L_0x0356:
            if (r1 == 0) goto L_0x0399
            if (r2 == 0) goto L_0x0399
            if (r6 == 0) goto L_0x0399
            if (r12 == 0) goto L_0x0399
            if (r8 != r13) goto L_0x0368
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r47]
            int r0 = r0.getMargin()
        L_0x0368:
            r5 = r0
            if (r8 != r14) goto L_0x0375
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r15 = r0
            goto L_0x0376
        L_0x0375:
            r15 = r3
        L_0x0376:
            if (r37 == 0) goto L_0x037b
            r16 = 6
            goto L_0x037d
        L_0x037b:
            r16 = 4
        L_0x037d:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r9
            r3 = r5
            r19 = 8
            r5 = r6
            r20 = r39
            r6 = r12
            r12 = r7
            r7 = r15
            r42 = r11
            r41 = r12
            r11 = 8
            r15 = 6
            r19 = 4
            r12 = r8
            r8 = r16
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x03a5
        L_0x0399:
            r41 = r7
            r12 = r8
            r42 = r11
            r20 = r39
            r11 = 8
            r15 = 6
            r19 = 4
        L_0x03a5:
            int r0 = r12.getVisibility()
            if (r0 == r11) goto L_0x03ad
            r7 = r12
            goto L_0x03af
        L_0x03ad:
            r7 = r41
        L_0x03af:
            r8 = r20
            r12 = r40
            r11 = r42
            goto L_0x02b6
        L_0x03b7:
            r42 = r11
            r40 = r12
            r11 = 8
            r15 = 6
            r19 = 4
            if (r18 == 0) goto L_0x04e5
            if (r13 == 0) goto L_0x04e5
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x03d1
            int r0 = r1.mWidgetsCount
            int r1 = r1.mWidgetsMatchCount
            if (r0 != r1) goto L_0x03d1
            r37 = 1
            goto L_0x03d3
        L_0x03d1:
            r37 = 0
        L_0x03d3:
            r8 = r13
            r12 = r8
        L_0x03d5:
            if (r12 == 0) goto L_0x0482
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r12.mNextChainWidget
            r0 = r0[r46]
        L_0x03db:
            if (r0 == 0) goto L_0x03e8
            int r1 = r0.getVisibility()
            if (r1 != r11) goto L_0x03e8
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r46]
            goto L_0x03db
        L_0x03e8:
            if (r12 == r13) goto L_0x046d
            if (r12 == r14) goto L_0x046d
            if (r0 == 0) goto L_0x046d
            if (r0 != r14) goto L_0x03f3
            r7 = r21
            goto L_0x03f4
        L_0x03f3:
            r7 = r0
        L_0x03f4:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r47]
            android.support.constraint.solver.SolverVariable r1 = r0.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r47 + 1
            r2 = r2[r3]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x0420
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r47]
            android.support.constraint.solver.SolverVariable r6 = r5.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.mTarget
            if (r11 == 0) goto L_0x041d
            android.support.constraint.solver.widgets.ConstraintAnchor r11 = r5.mTarget
            goto L_0x0431
        L_0x041d:
            r11 = r21
            goto L_0x0433
        L_0x0420:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r12.mListAnchors
            r5 = r5[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x042b
            android.support.constraint.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x042d
        L_0x042b:
            r6 = r21
        L_0x042d:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r11 = r12.mListAnchors
            r11 = r11[r3]
        L_0x0431:
            android.support.constraint.solver.SolverVariable r11 = r11.mSolverVariable
        L_0x0433:
            if (r5 == 0) goto L_0x043a
            int r5 = r5.getMargin()
            int r4 = r4 + r5
        L_0x043a:
            r16 = r4
            if (r8 == 0) goto L_0x0447
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r8.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r0 = r0 + r3
        L_0x0447:
            r3 = r0
            if (r37 == 0) goto L_0x044d
            r20 = 6
            goto L_0x044f
        L_0x044d:
            r20 = 4
        L_0x044f:
            if (r1 == 0) goto L_0x0468
            if (r2 == 0) goto L_0x0468
            if (r6 == 0) goto L_0x0468
            if (r11 == 0) goto L_0x0468
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r9
            r5 = r6
            r6 = r11
            r11 = r7
            r7 = r16
            r16 = r8
            r10 = 5
            r8 = r20
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0471
        L_0x0468:
            r11 = r7
            r16 = r8
            r10 = 5
            goto L_0x0471
        L_0x046d:
            r16 = r8
            r10 = 5
            r11 = r0
        L_0x0471:
            int r0 = r12.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x047b
            r8 = r12
            goto L_0x047d
        L_0x047b:
            r8 = r16
        L_0x047d:
            r12 = r11
            r11 = 8
            goto L_0x03d5
        L_0x0482:
            r10 = 5
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r47]
            r1 = r42
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r1.mListAnchors
            r1 = r1[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r3 = r47 + 1
            r11 = r2[r3]
            r12 = r40
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r2.mTarget
            if (r1 == 0) goto L_0x04d2
            if (r13 == r14) goto L_0x04ad
            android.support.constraint.solver.SolverVariable r2 = r0.mSolverVariable
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r9.addEquality(r2, r1, r0, r10)
            goto L_0x04d2
        L_0x04ad:
            if (r8 == 0) goto L_0x04d2
            android.support.constraint.solver.SolverVariable r2 = r0.mSolverVariable
            android.support.constraint.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            r5 = 1056964608(0x3f000000, float:0.5)
            android.support.constraint.solver.SolverVariable r6 = r11.mSolverVariable
            android.support.constraint.solver.SolverVariable r7 = r8.mSolverVariable
            int r15 = r11.getMargin()
            r16 = 5
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r15
            r10 = r8
            r8 = r16
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04d3
        L_0x04d2:
            r10 = r8
        L_0x04d3:
            if (r10 == 0) goto L_0x04e7
            if (r13 == r14) goto L_0x04e7
            android.support.constraint.solver.SolverVariable r0 = r11.mSolverVariable
            android.support.constraint.solver.SolverVariable r1 = r10.mSolverVariable
            int r2 = r11.getMargin()
            int r2 = -r2
            r3 = 5
            r9.addEquality(r0, r1, r2, r3)
            goto L_0x04e7
        L_0x04e5:
            r12 = r40
        L_0x04e7:
            if (r17 != 0) goto L_0x04eb
            if (r18 == 0) goto L_0x054e
        L_0x04eb:
            if (r13 == 0) goto L_0x054e
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            int r2 = r47 + 1
            r1 = r1[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            if (r3 == 0) goto L_0x0500
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0502
        L_0x0500:
            r3 = r21
        L_0x0502:
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x050b
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            android.support.constraint.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x050d
        L_0x050b:
            r4 = r21
        L_0x050d:
            if (r12 == r14) goto L_0x051e
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r12.mListAnchors
            r4 = r4[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x051c
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x051e
        L_0x051c:
            r4 = r21
        L_0x051e:
            r5 = r4
            if (r13 != r14) goto L_0x0529
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r2]
        L_0x0529:
            if (r3 == 0) goto L_0x054e
            if (r5 == 0) goto L_0x054e
            int r4 = r0.getMargin()
            if (r14 != 0) goto L_0x0534
            goto L_0x0535
        L_0x0534:
            r12 = r14
        L_0x0535:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r2 = r6[r2]
            int r7 = r2.getMargin()
            android.support.constraint.solver.SolverVariable r2 = r0.mSolverVariable
            r6 = 1056964608(0x3f000000, float:0.5)
            android.support.constraint.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 5
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x054e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):void");
    }
}
