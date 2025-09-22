package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] flags = new boolean[3];

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (r6 != false) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e9, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010f, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void analyze(int r17, android.support.constraint.solver.widgets.ConstraintWidget r18) {
        /*
            r0 = r18
            r18.updateResolutionNodes()
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mLeft
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r1.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r0.mTop
            android.support.constraint.solver.widgets.ResolutionAnchor r2 = r2.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mRight
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r3.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r0.mBottom
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r4.getResolutionNode()
            r5 = 8
            r6 = r17 & 8
            r7 = 0
            r8 = 1
            if (r6 != r5) goto L_0x0027
            r6 = 1
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r9 = r0.mListDimensionBehaviors
            r9 = r9[r7]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r10) goto L_0x0038
            boolean r9 = optimizableMatchConstraint(r0, r7)
            if (r9 == 0) goto L_0x0038
            r9 = 1
            goto L_0x0039
        L_0x0038:
            r9 = 0
        L_0x0039:
            int r10 = r1.type
            r11 = 3
            r12 = 4
            r13 = 0
            r14 = -1
            r15 = 2
            if (r10 == r12) goto L_0x0181
            int r10 = r3.type
            if (r10 == r12) goto L_0x0181
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r0.mListDimensionBehaviors
            r10 = r10[r7]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r10 == r7) goto L_0x00d7
            if (r9 == 0) goto L_0x0058
            int r7 = r18.getVisibility()
            if (r7 != r5) goto L_0x0058
            goto L_0x00d7
        L_0x0058:
            if (r9 == 0) goto L_0x0181
            int r7 = r18.getWidth()
            r1.setType(r8)
            r3.setType(r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 != 0) goto L_0x0074
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 != 0) goto L_0x0074
            if (r6 == 0) goto L_0x00f8
            goto L_0x00eb
        L_0x0074:
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 == 0) goto L_0x0083
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 != 0) goto L_0x0083
            if (r6 == 0) goto L_0x00f8
            goto L_0x00eb
        L_0x0083:
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 != 0) goto L_0x0093
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 == 0) goto L_0x0093
            if (r6 == 0) goto L_0x013a
            goto L_0x012e
        L_0x0093:
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 == 0) goto L_0x0181
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r0.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 == 0) goto L_0x0181
            if (r6 == 0) goto L_0x00af
            android.support.constraint.solver.widgets.ResolutionDimension r9 = r18.getResolutionWidth()
            r9.addDependent(r1)
            android.support.constraint.solver.widgets.ResolutionDimension r9 = r18.getResolutionWidth()
            r9.addDependent(r3)
        L_0x00af:
            float r9 = r0.mDimensionRatio
            int r9 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r9 != 0) goto L_0x00c3
            r1.setType(r11)
            r3.setType(r11)
            r1.setOpposite(r3, r13)
            r3.setOpposite(r1, r13)
            goto L_0x0181
        L_0x00c3:
            r1.setType(r15)
            r3.setType(r15)
            int r9 = -r7
            float r9 = (float) r9
            r1.setOpposite(r3, r9)
            float r9 = (float) r7
            r3.setOpposite(r1, r9)
            r0.setWidth(r7)
            goto L_0x0181
        L_0x00d7:
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 != 0) goto L_0x00fd
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 != 0) goto L_0x00fd
            r1.setType(r8)
            r3.setType(r8)
            if (r6 == 0) goto L_0x00f4
        L_0x00eb:
            android.support.constraint.solver.widgets.ResolutionDimension r7 = r18.getResolutionWidth()
            r3.dependsOn((android.support.constraint.solver.widgets.ResolutionAnchor) r1, (int) r8, (android.support.constraint.solver.widgets.ResolutionDimension) r7)
            goto L_0x0181
        L_0x00f4:
            int r7 = r18.getWidth()
        L_0x00f8:
            r3.dependsOn(r1, r7)
            goto L_0x0181
        L_0x00fd:
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x0112
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 != 0) goto L_0x0112
            r1.setType(r8)
            r3.setType(r8)
            if (r6 == 0) goto L_0x00f4
            goto L_0x00eb
        L_0x0112:
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 != 0) goto L_0x013f
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x013f
            r1.setType(r8)
            r3.setType(r8)
            int r7 = r18.getWidth()
            int r7 = -r7
            r1.dependsOn(r3, r7)
            if (r6 == 0) goto L_0x0136
        L_0x012e:
            android.support.constraint.solver.widgets.ResolutionDimension r7 = r18.getResolutionWidth()
            r1.dependsOn((android.support.constraint.solver.widgets.ResolutionAnchor) r3, (int) r14, (android.support.constraint.solver.widgets.ResolutionDimension) r7)
            goto L_0x0181
        L_0x0136:
            int r7 = r18.getWidth()
        L_0x013a:
            int r7 = -r7
            r1.dependsOn(r3, r7)
            goto L_0x0181
        L_0x013f:
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x0181
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r0.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x0181
            r1.setType(r15)
            r3.setType(r15)
            if (r6 == 0) goto L_0x0170
            android.support.constraint.solver.widgets.ResolutionDimension r7 = r18.getResolutionWidth()
            r7.addDependent(r1)
            android.support.constraint.solver.widgets.ResolutionDimension r7 = r18.getResolutionWidth()
            r7.addDependent(r3)
            android.support.constraint.solver.widgets.ResolutionDimension r7 = r18.getResolutionWidth()
            r1.setOpposite(r3, r14, r7)
            android.support.constraint.solver.widgets.ResolutionDimension r7 = r18.getResolutionWidth()
            r3.setOpposite(r1, r8, r7)
            goto L_0x0181
        L_0x0170:
            int r7 = r18.getWidth()
            int r7 = -r7
            float r7 = (float) r7
            r1.setOpposite(r3, r7)
            int r7 = r18.getWidth()
            float r7 = (float) r7
            r3.setOpposite(r1, r7)
        L_0x0181:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r0.mListDimensionBehaviors
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r3) goto L_0x0192
            boolean r1 = optimizableMatchConstraint(r0, r8)
            if (r1 == 0) goto L_0x0192
            r16 = 1
            goto L_0x0194
        L_0x0192:
            r16 = 0
        L_0x0194:
            int r1 = r2.type
            if (r1 == r12) goto L_0x0351
            int r1 = r4.type
            if (r1 == r12) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r0.mListDimensionBehaviors
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r1 == r3) goto L_0x025a
            if (r16 == 0) goto L_0x01ae
            int r1 = r18.getVisibility()
            if (r1 != r5) goto L_0x01ae
            goto L_0x025a
        L_0x01ae:
            if (r16 == 0) goto L_0x0351
            int r1 = r18.getHeight()
            r2.setType(r8)
            r4.setType(r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x01d4
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x01d4
            if (r6 == 0) goto L_0x01d0
            android.support.constraint.solver.widgets.ResolutionDimension r0 = r18.getResolutionHeight()
            r4.dependsOn((android.support.constraint.solver.widgets.ResolutionAnchor) r2, (int) r8, (android.support.constraint.solver.widgets.ResolutionDimension) r0)
            return
        L_0x01d0:
            r4.dependsOn(r2, r1)
            return
        L_0x01d4:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x01ee
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x01ee
            if (r6 == 0) goto L_0x01ea
            android.support.constraint.solver.widgets.ResolutionDimension r0 = r18.getResolutionHeight()
            r4.dependsOn((android.support.constraint.solver.widgets.ResolutionAnchor) r2, (int) r8, (android.support.constraint.solver.widgets.ResolutionDimension) r0)
            return
        L_0x01ea:
            r4.dependsOn(r2, r1)
            return
        L_0x01ee:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0209
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0209
            if (r6 == 0) goto L_0x0204
            android.support.constraint.solver.widgets.ResolutionDimension r0 = r18.getResolutionHeight()
            r2.dependsOn((android.support.constraint.solver.widgets.ResolutionAnchor) r4, (int) r14, (android.support.constraint.solver.widgets.ResolutionDimension) r0)
            return
        L_0x0204:
            int r0 = -r1
            r2.dependsOn(r4, r0)
            return
        L_0x0209:
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r0.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0351
            if (r6 == 0) goto L_0x0225
            android.support.constraint.solver.widgets.ResolutionDimension r3 = r18.getResolutionHeight()
            r3.addDependent(r2)
            android.support.constraint.solver.widgets.ResolutionDimension r3 = r18.getResolutionWidth()
            r3.addDependent(r4)
        L_0x0225:
            float r3 = r0.mDimensionRatio
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x0238
            r2.setType(r11)
            r4.setType(r11)
            r2.setOpposite(r4, r13)
            r4.setOpposite(r2, r13)
            return
        L_0x0238:
            r2.setType(r15)
            r4.setType(r15)
            int r3 = -r1
            float r3 = (float) r3
            r2.setOpposite(r4, r3)
            float r3 = (float) r1
            r4.setOpposite(r2, r3)
            r0.setHeight(r1)
            int r1 = r0.mBaselineDistance
            if (r1 <= 0) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r1.getResolutionNode()
            int r0 = r0.mBaselineDistance
            r1.dependsOn((int) r8, (android.support.constraint.solver.widgets.ResolutionAnchor) r2, (int) r0)
            return
        L_0x025a:
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 != 0) goto L_0x0299
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 != 0) goto L_0x0299
            r2.setType(r8)
            r4.setType(r8)
            if (r6 == 0) goto L_0x0276
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r18.getResolutionHeight()
            r4.dependsOn((android.support.constraint.solver.widgets.ResolutionAnchor) r2, (int) r8, (android.support.constraint.solver.widgets.ResolutionDimension) r1)
            goto L_0x027d
        L_0x0276:
            int r1 = r18.getHeight()
            r4.dependsOn(r2, r1)
        L_0x027d:
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBaseline
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r1.getResolutionNode()
            r1.setType(r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r1.getResolutionNode()
            int r0 = r0.mBaselineDistance
            int r0 = -r0
            r2.dependsOn((int) r8, (android.support.constraint.solver.widgets.ResolutionAnchor) r1, (int) r0)
            return
        L_0x0299:
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x02cc
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 != 0) goto L_0x02cc
            r2.setType(r8)
            r4.setType(r8)
            if (r6 == 0) goto L_0x02b5
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r18.getResolutionHeight()
            r4.dependsOn((android.support.constraint.solver.widgets.ResolutionAnchor) r2, (int) r8, (android.support.constraint.solver.widgets.ResolutionDimension) r1)
            goto L_0x02bc
        L_0x02b5:
            int r1 = r18.getHeight()
            r4.dependsOn(r2, r1)
        L_0x02bc:
            int r1 = r0.mBaselineDistance
            if (r1 <= 0) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r1.getResolutionNode()
            int r0 = r0.mBaselineDistance
            r1.dependsOn((int) r8, (android.support.constraint.solver.widgets.ResolutionAnchor) r2, (int) r0)
            return
        L_0x02cc:
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 != 0) goto L_0x0300
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0300
            r2.setType(r8)
            r4.setType(r8)
            if (r6 == 0) goto L_0x02e8
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r18.getResolutionHeight()
            r2.dependsOn((android.support.constraint.solver.widgets.ResolutionAnchor) r4, (int) r14, (android.support.constraint.solver.widgets.ResolutionDimension) r1)
            goto L_0x02f0
        L_0x02e8:
            int r1 = r18.getHeight()
            int r1 = -r1
            r2.dependsOn(r4, r1)
        L_0x02f0:
            int r1 = r0.mBaselineDistance
            if (r1 <= 0) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r1.getResolutionNode()
            int r0 = r0.mBaselineDistance
            r1.dependsOn((int) r8, (android.support.constraint.solver.widgets.ResolutionAnchor) r2, (int) r0)
            return
        L_0x0300:
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0351
            r2.setType(r15)
            r4.setType(r15)
            if (r6 == 0) goto L_0x0331
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r18.getResolutionHeight()
            r2.setOpposite(r4, r14, r1)
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r18.getResolutionHeight()
            r4.setOpposite(r2, r8, r1)
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r18.getResolutionHeight()
            r1.addDependent(r2)
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r18.getResolutionWidth()
            r1.addDependent(r4)
            goto L_0x0342
        L_0x0331:
            int r1 = r18.getHeight()
            int r1 = -r1
            float r1 = (float) r1
            r2.setOpposite(r4, r1)
            int r1 = r18.getHeight()
            float r1 = (float) r1
            r4.setOpposite(r2, r1)
        L_0x0342:
            int r1 = r0.mBaselineDistance
            if (r1 <= 0) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r0.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r1.getResolutionNode()
            int r0 = r0.mBaselineDistance
            r1.dependsOn((int) r8, (android.support.constraint.solver.widgets.ResolutionAnchor) r2, (int) r0)
        L_0x0351:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.analyze(int, android.support.constraint.solver.widgets.ConstraintWidget):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r7.mHorizontalChainStyle == 2) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r7.mVerticalChainStyle == 2) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean applyChainOptimized(android.support.constraint.solver.widgets.ConstraintWidgetContainer r23, android.support.constraint.solver.LinearSystem r24, int r25, int r26, android.support.constraint.solver.widgets.ChainHead r27) {
        /*
            r0 = r24
            r1 = r25
            r2 = r27
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r2.mFirst
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r2.mLast
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r2.mFirstVisibleWidget
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r2.mLastVisibleWidget
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r2.mHead
            float r2 = r2.mTotalWeight
            r8 = r23
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r8.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8 = 2
            r10 = 1
            if (r1 != 0) goto L_0x0032
            int r11 = r7.mHorizontalChainStyle
            if (r11 != 0) goto L_0x0022
            r11 = 1
            goto L_0x0023
        L_0x0022:
            r11 = 0
        L_0x0023:
            int r12 = r7.mHorizontalChainStyle
            if (r12 != r10) goto L_0x0029
            r12 = 1
            goto L_0x002a
        L_0x0029:
            r12 = 0
        L_0x002a:
            int r7 = r7.mHorizontalChainStyle
            if (r7 != r8) goto L_0x0030
        L_0x002e:
            r7 = 1
            goto L_0x0045
        L_0x0030:
            r7 = 0
            goto L_0x0045
        L_0x0032:
            int r11 = r7.mVerticalChainStyle
            if (r11 != 0) goto L_0x0038
            r11 = 1
            goto L_0x0039
        L_0x0038:
            r11 = 0
        L_0x0039:
            int r12 = r7.mVerticalChainStyle
            if (r12 != r10) goto L_0x003f
            r12 = 1
            goto L_0x0040
        L_0x003f:
            r12 = 0
        L_0x0040:
            int r7 = r7.mVerticalChainStyle
            if (r7 != r8) goto L_0x0030
            goto L_0x002e
        L_0x0045:
            r14 = r3
            r8 = 0
            r10 = 0
            r13 = 0
            r15 = 0
            r17 = 0
        L_0x004c:
            r9 = 8
            if (r13 != 0) goto L_0x0105
            r18 = r13
            int r13 = r14.getVisibility()
            if (r13 == r9) goto L_0x009a
            int r10 = r10 + 1
            if (r1 != 0) goto L_0x0063
            int r13 = r14.getWidth()
        L_0x0060:
            float r13 = (float) r13
            float r15 = r15 + r13
            goto L_0x0068
        L_0x0063:
            int r13 = r14.getHeight()
            goto L_0x0060
        L_0x0068:
            if (r14 == r5) goto L_0x0074
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            r13 = r13[r26]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r15 = r15 + r13
        L_0x0074:
            if (r14 == r6) goto L_0x0082
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            int r19 = r26 + 1
            r13 = r13[r19]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r15 = r15 + r13
        L_0x0082:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            r13 = r13[r26]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r17 = r17 + r13
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            int r19 = r26 + 1
            r13 = r13[r19]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r17 = r17 + r13
        L_0x009a:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r14.mListAnchors
            int r13 = r14.getVisibility()
            if (r13 == r9) goto L_0x00d6
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r9 = r14.mListDimensionBehaviors
            r9 = r9[r1]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r13) goto L_0x00d6
            int r8 = r8 + 1
            if (r1 != 0) goto L_0x00be
            int r9 = r14.mMatchConstraintDefaultWidth
            if (r9 == 0) goto L_0x00b4
            r9 = 0
            return r9
        L_0x00b4:
            r9 = 0
            int r13 = r14.mMatchConstraintMinWidth
            if (r13 != 0) goto L_0x00bd
            int r13 = r14.mMatchConstraintMaxWidth
            if (r13 == 0) goto L_0x00cd
        L_0x00bd:
            return r9
        L_0x00be:
            r9 = 0
            int r13 = r14.mMatchConstraintDefaultHeight
            if (r13 == 0) goto L_0x00c4
            return r9
        L_0x00c4:
            int r13 = r14.mMatchConstraintMinHeight
            if (r13 != 0) goto L_0x00d5
            int r13 = r14.mMatchConstraintMaxHeight
            if (r13 == 0) goto L_0x00cd
            return r9
        L_0x00cd:
            float r13 = r14.mDimensionRatio
            r16 = 0
            int r13 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r13 == 0) goto L_0x00d6
        L_0x00d5:
            return r9
        L_0x00d6:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r14.mListAnchors
            int r13 = r26 + 1
            r9 = r9[r13]
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 == 0) goto L_0x00f8
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r9.mOwner
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r9.mListAnchors
            r13 = r13[r26]
            android.support.constraint.solver.widgets.ConstraintAnchor r13 = r13.mTarget
            if (r13 == 0) goto L_0x00f8
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r9.mListAnchors
            r13 = r13[r26]
            android.support.constraint.solver.widgets.ConstraintAnchor r13 = r13.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r13.mOwner
            if (r13 == r14) goto L_0x00f5
            goto L_0x00f8
        L_0x00f5:
            r20 = r9
            goto L_0x00fa
        L_0x00f8:
            r20 = 0
        L_0x00fa:
            if (r20 == 0) goto L_0x0102
            r13 = r18
            r14 = r20
            goto L_0x004c
        L_0x0102:
            r13 = 1
            goto L_0x004c
        L_0x0105:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r3.mListAnchors
            r13 = r13[r26]
            android.support.constraint.solver.widgets.ResolutionAnchor r13 = r13.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r4.mListAnchors
            int r18 = r26 + 1
            r9 = r9[r18]
            android.support.constraint.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            r21 = r3
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r13.target
            if (r3 == 0) goto L_0x0391
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r9.target
            if (r3 != 0) goto L_0x0123
            goto L_0x0391
        L_0x0123:
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r13.target
            int r3 = r3.state
            r0 = 1
            if (r3 != r0) goto L_0x038f
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r9.target
            int r3 = r3.state
            if (r3 == r0) goto L_0x0132
            goto L_0x038f
        L_0x0132:
            if (r8 <= 0) goto L_0x0138
            if (r8 == r10) goto L_0x0138
            r0 = 0
            return r0
        L_0x0138:
            if (r7 != 0) goto L_0x0141
            if (r11 != 0) goto L_0x0141
            if (r12 == 0) goto L_0x013f
            goto L_0x0141
        L_0x013f:
            r0 = 0
            goto L_0x015a
        L_0x0141:
            if (r5 == 0) goto L_0x014d
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r5.mListAnchors
            r0 = r0[r26]
            int r0 = r0.getMargin()
            float r0 = (float) r0
            goto L_0x014e
        L_0x014d:
            r0 = 0
        L_0x014e:
            if (r6 == 0) goto L_0x015a
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r18]
            int r3 = r3.getMargin()
            float r3 = (float) r3
            float r0 = r0 + r3
        L_0x015a:
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r13.target
            float r3 = r3.resolvedOffset
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r9.target
            float r6 = r6.resolvedOffset
            int r9 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0169
            float r6 = r6 - r3
        L_0x0167:
            float r6 = r6 - r15
            goto L_0x016c
        L_0x0169:
            float r6 = r3 - r6
            goto L_0x0167
        L_0x016c:
            r19 = 1
            if (r8 <= 0) goto L_0x0225
            if (r8 != r10) goto L_0x0225
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r14.getParent()
            if (r0 == 0) goto L_0x0186
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r14.getParent()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r0 = r0[r1]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r5) goto L_0x0186
            r0 = 0
            return r0
        L_0x0186:
            float r6 = r6 + r15
            float r6 = r6 - r17
            r0 = r21
        L_0x018b:
            if (r0 == 0) goto L_0x0223
            android.support.constraint.solver.Metrics r5 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r5 == 0) goto L_0x01a9
            android.support.constraint.solver.Metrics r5 = android.support.constraint.solver.LinearSystem.sMetrics
            long r9 = r5.nonresolvedWidgets
            long r11 = r9 - r19
            r5.nonresolvedWidgets = r11
            android.support.constraint.solver.Metrics r5 = android.support.constraint.solver.LinearSystem.sMetrics
            long r9 = r5.resolvedWidgets
            long r11 = r9 + r19
            r5.resolvedWidgets = r11
            android.support.constraint.solver.Metrics r5 = android.support.constraint.solver.LinearSystem.sMetrics
            long r9 = r5.chainConnectionResolved
            long r11 = r9 + r19
            r5.chainConnectionResolved = r11
        L_0x01a9:
            android.support.constraint.solver.widgets.ConstraintWidget[] r5 = r0.mNextChainWidget
            r5 = r5[r1]
            if (r5 != 0) goto L_0x01b5
            if (r0 != r4) goto L_0x01b2
            goto L_0x01b5
        L_0x01b2:
            r9 = r24
            goto L_0x0220
        L_0x01b5:
            float r7 = (float) r8
            float r7 = r6 / r7
            r9 = 0
            int r10 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x01d0
            float[] r7 = r0.mWeight
            r7 = r7[r1]
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x01c9
            r7 = 0
            goto L_0x01d0
        L_0x01c9:
            float[] r7 = r0.mWeight
            r7 = r7[r1]
            float r7 = r7 * r6
            float r7 = r7 / r2
        L_0x01d0:
            int r9 = r0.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x01d9
            r7 = 0
        L_0x01d9:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r0.mListAnchors
            r9 = r9[r26]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r3 = r3 + r9
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r0.mListAnchors
            r9 = r9[r26]
            android.support.constraint.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r10 = r13.resolvedTarget
            r9.resolve(r10, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r0.mListAnchors
            r9 = r9[r18]
            android.support.constraint.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r10 = r13.resolvedTarget
            float r3 = r3 + r7
            r9.resolve(r10, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r0.mListAnchors
            r7 = r7[r26]
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r7.getResolutionNode()
            r9 = r24
            r7.addResolvedValue(r9)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r0.mListAnchors
            r7 = r7[r18]
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r7.getResolutionNode()
            r7.addResolvedValue(r9)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            r0 = r0[r18]
            int r0 = r0.getMargin()
            float r0 = (float) r0
            float r3 = r3 + r0
        L_0x0220:
            r0 = r5
            goto L_0x018b
        L_0x0223:
            r0 = 1
            return r0
        L_0x0225:
            r9 = r24
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x022f
            r7 = 1
            r11 = 0
            r12 = 0
        L_0x022f:
            if (r7 == 0) goto L_0x02b7
            float r6 = r6 - r0
            r2 = r21
            float r0 = r2.getBiasPercent(r1)
            float r6 = r6 * r0
            float r3 = r3 + r6
        L_0x023b:
            if (r2 == 0) goto L_0x02b5
            android.support.constraint.solver.Metrics r0 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r0 == 0) goto L_0x0259
            android.support.constraint.solver.Metrics r0 = android.support.constraint.solver.LinearSystem.sMetrics
            long r5 = r0.nonresolvedWidgets
            long r7 = r5 - r19
            r0.nonresolvedWidgets = r7
            android.support.constraint.solver.Metrics r0 = android.support.constraint.solver.LinearSystem.sMetrics
            long r5 = r0.resolvedWidgets
            long r7 = r5 + r19
            r0.resolvedWidgets = r7
            android.support.constraint.solver.Metrics r0 = android.support.constraint.solver.LinearSystem.sMetrics
            long r5 = r0.chainConnectionResolved
            long r7 = r5 + r19
            r0.chainConnectionResolved = r7
        L_0x0259:
            android.support.constraint.solver.widgets.ConstraintWidget[] r0 = r2.mNextChainWidget
            r0 = r0[r1]
            if (r0 != 0) goto L_0x0261
            if (r2 != r4) goto L_0x02b3
        L_0x0261:
            if (r1 != 0) goto L_0x0269
            int r5 = r2.getWidth()
        L_0x0267:
            float r5 = (float) r5
            goto L_0x026e
        L_0x0269:
            int r5 = r2.getHeight()
            goto L_0x0267
        L_0x026e:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r26]
            int r6 = r6.getMargin()
            float r6 = (float) r6
            float r3 = r3 + r6
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r26]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r13.resolvedTarget
            r6.resolve(r7, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r18]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r13.resolvedTarget
            float r3 = r3 + r5
            r6.resolve(r7, r3)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r2.mListAnchors
            r5 = r5[r26]
            android.support.constraint.solver.widgets.ResolutionAnchor r5 = r5.getResolutionNode()
            r5.addResolvedValue(r9)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r2.mListAnchors
            r5 = r5[r18]
            android.support.constraint.solver.widgets.ResolutionAnchor r5 = r5.getResolutionNode()
            r5.addResolvedValue(r9)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r2.mListAnchors
            r2 = r2[r18]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r3 = r3 + r2
        L_0x02b3:
            r2 = r0
            goto L_0x023b
        L_0x02b5:
            r0 = 1
            return r0
        L_0x02b7:
            r2 = r21
            if (r11 != 0) goto L_0x02bd
            if (r12 == 0) goto L_0x02b5
        L_0x02bd:
            if (r11 == 0) goto L_0x02c1
        L_0x02bf:
            float r6 = r6 - r0
            goto L_0x02c4
        L_0x02c1:
            if (r12 == 0) goto L_0x02c4
            goto L_0x02bf
        L_0x02c4:
            int r0 = r10 + 1
            float r0 = (float) r0
            float r0 = r6 / r0
            if (r12 == 0) goto L_0x02d7
            r7 = 1
            if (r10 <= r7) goto L_0x02d4
            int r0 = r10 + -1
            float r0 = (float) r0
        L_0x02d1:
            float r0 = r6 / r0
            goto L_0x02d7
        L_0x02d4:
            r0 = 1073741824(0x40000000, float:2.0)
            goto L_0x02d1
        L_0x02d7:
            int r6 = r2.getVisibility()
            r7 = 8
            if (r6 == r7) goto L_0x02e2
            float r6 = r3 + r0
            goto L_0x02e3
        L_0x02e2:
            r6 = r3
        L_0x02e3:
            if (r12 == 0) goto L_0x02f2
            r7 = 1
            if (r10 <= r7) goto L_0x02f2
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r5.mListAnchors
            r6 = r6[r26]
            int r6 = r6.getMargin()
            float r6 = (float) r6
            float r6 = r6 + r3
        L_0x02f2:
            if (r11 == 0) goto L_0x0300
            if (r5 == 0) goto L_0x0300
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            r3 = r3[r26]
            int r3 = r3.getMargin()
            float r3 = (float) r3
            float r6 = r6 + r3
        L_0x0300:
            if (r2 == 0) goto L_0x02b5
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r3 == 0) goto L_0x031e
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            long r7 = r3.nonresolvedWidgets
            long r10 = r7 - r19
            r3.nonresolvedWidgets = r10
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            long r7 = r3.resolvedWidgets
            long r10 = r7 + r19
            r3.resolvedWidgets = r10
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            long r7 = r3.chainConnectionResolved
            long r10 = r7 + r19
            r3.chainConnectionResolved = r10
        L_0x031e:
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r2.mNextChainWidget
            r3 = r3[r1]
            if (r3 != 0) goto L_0x032a
            if (r2 != r4) goto L_0x0327
            goto L_0x032a
        L_0x0327:
            r7 = 8
            goto L_0x038b
        L_0x032a:
            if (r1 != 0) goto L_0x0332
            int r7 = r2.getWidth()
        L_0x0330:
            float r7 = (float) r7
            goto L_0x0337
        L_0x0332:
            int r7 = r2.getHeight()
            goto L_0x0330
        L_0x0337:
            if (r2 == r5) goto L_0x0343
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r26]
            int r8 = r8.getMargin()
            float r8 = (float) r8
            float r6 = r6 + r8
        L_0x0343:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r26]
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r10 = r13.resolvedTarget
            r8.resolve(r10, r6)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r18]
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r10 = r13.resolvedTarget
            float r11 = r6 + r7
            r8.resolve(r10, r11)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r26]
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            r8.addResolvedValue(r9)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r18]
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            r8.addResolvedValue(r9)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r2.mListAnchors
            r2 = r2[r18]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r7 = r7 + r2
            float r6 = r6 + r7
            if (r3 == 0) goto L_0x0327
            int r2 = r3.getVisibility()
            r7 = 8
            if (r2 == r7) goto L_0x038b
            float r6 = r6 + r0
        L_0x038b:
            r2 = r3
            goto L_0x0300
            return r0
        L_0x038f:
            r0 = 0
            return r0
        L_0x0391:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.applyChainOptimized(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):boolean");
    }

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i2, height);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003d A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean optimizableMatchConstraint(android.support.constraint.solver.widgets.ConstraintWidget r3, int r4) {
        /*
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r3.mListDimensionBehaviors
            r0 = r0[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r3.mDimensionRatio
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x001f
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r3.mListDimensionBehaviors
            if (r4 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r3 = r3[r1]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x001e
        L_0x001e:
            return r2
        L_0x001f:
            if (r4 != 0) goto L_0x002f
            int r4 = r3.mMatchConstraintDefaultWidth
            if (r4 == 0) goto L_0x0026
            return r2
        L_0x0026:
            int r4 = r3.mMatchConstraintMinWidth
            if (r4 != 0) goto L_0x002e
            int r3 = r3.mMatchConstraintMaxWidth
            if (r3 == 0) goto L_0x003d
        L_0x002e:
            return r2
        L_0x002f:
            int r4 = r3.mMatchConstraintDefaultHeight
            if (r4 == 0) goto L_0x0034
            return r2
        L_0x0034:
            int r4 = r3.mMatchConstraintMinHeight
            if (r4 != 0) goto L_0x003e
            int r3 = r3.mMatchConstraintMaxHeight
            if (r3 == 0) goto L_0x003d
            return r2
        L_0x003d:
            return r1
        L_0x003e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.optimizableMatchConstraint(android.support.constraint.solver.widgets.ConstraintWidget, int):boolean");
    }

    static void setOptimizedWidget(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedTarget = constraintWidget.getParent().mLeft.getResolutionNode();
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset = (float) i2;
        constraintWidget.mListAnchors[i3].getResolutionNode().state = 1;
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedTarget = constraintWidget.mListAnchors[i3].getResolutionNode();
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset = (float) constraintWidget.getLength(i);
        constraintWidget.mListAnchors[i4].getResolutionNode().state = 1;
    }
}
