package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class Barrier extends Helper {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private ArrayList<ResolutionAnchor> mNodes = new ArrayList<>(4);

    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor;
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        for (int i = 0; i < this.mListAnchors.length; i++) {
            this.mListAnchors[i].mSolverVariable = linearSystem.createObjectVariable(this.mListAnchors[i]);
        }
        if (this.mBarrierType >= 0 && this.mBarrierType < 4) {
            ConstraintAnchor constraintAnchor2 = this.mListAnchors[this.mBarrierType];
            int i2 = 0;
            while (true) {
                if (i2 >= this.mWidgetsCount) {
                    z = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i2];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && (((this.mBarrierType == 0 || this.mBarrierType == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || ((this.mBarrierType == 2 || this.mBarrierType == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                    z = true;
                } else {
                    i2++;
                }
            }
            z = true;
            if (this.mBarrierType == 0 || this.mBarrierType == 1 ? getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                z = false;
            }
            for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i3];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    constraintWidget2.mListAnchors[this.mBarrierType].mSolverVariable = createObjectVariable;
                    if (this.mBarrierType == 0 || this.mBarrierType == 2) {
                        linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, z);
                    } else {
                        linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, z);
                    }
                }
            }
            if (this.mBarrierType == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 6);
                if (!z) {
                    solverVariable = this.mLeft.mSolverVariable;
                    constraintAnchor = this.mParent.mRight;
                } else {
                    return;
                }
            } else if (this.mBarrierType == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 6);
                if (!z) {
                    solverVariable = this.mLeft.mSolverVariable;
                    constraintAnchor = this.mParent.mLeft;
                } else {
                    return;
                }
            } else if (this.mBarrierType == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 6);
                if (!z) {
                    solverVariable = this.mTop.mSolverVariable;
                    constraintAnchor = this.mParent.mBottom;
                } else {
                    return;
                }
            } else if (this.mBarrierType == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 6);
                if (!z) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 5);
                    return;
                }
                return;
            } else {
                return;
            }
            linearSystem.addEquality(solverVariable, constraintAnchor.mSolverVariable, 0, 5);
        }
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public void analyze(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ResolutionAnchor resolutionAnchor;
        ConstraintAnchor constraintAnchor3;
        if (this.mParent != null && ((ConstraintWidgetContainer) this.mParent).optimizeFor(2)) {
            switch (this.mBarrierType) {
                case 0:
                    constraintAnchor = this.mLeft;
                    break;
                case 1:
                    constraintAnchor = this.mRight;
                    break;
                case 2:
                    constraintAnchor = this.mTop;
                    break;
                case 3:
                    constraintAnchor = this.mBottom;
                    break;
                default:
                    return;
            }
            ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
            resolutionNode.setType(5);
            if (this.mBarrierType == 0 || this.mBarrierType == 1) {
                this.mTop.getResolutionNode().resolve((ResolutionAnchor) null, 0.0f);
                constraintAnchor2 = this.mBottom;
            } else {
                this.mLeft.getResolutionNode().resolve((ResolutionAnchor) null, 0.0f);
                constraintAnchor2 = this.mRight;
            }
            constraintAnchor2.getResolutionNode().resolve((ResolutionAnchor) null, 0.0f);
            this.mNodes.clear();
            for (int i2 = 0; i2 < this.mWidgetsCount; i2++) {
                ConstraintWidget constraintWidget = this.mWidgets[i2];
                if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                    switch (this.mBarrierType) {
                        case 0:
                            constraintAnchor3 = constraintWidget.mLeft;
                            break;
                        case 1:
                            constraintAnchor3 = constraintWidget.mRight;
                            break;
                        case 2:
                            constraintAnchor3 = constraintWidget.mTop;
                            break;
                        case 3:
                            constraintAnchor3 = constraintWidget.mBottom;
                            break;
                        default:
                            resolutionAnchor = null;
                            break;
                    }
                    resolutionAnchor = constraintAnchor3.getResolutionNode();
                    if (resolutionAnchor != null) {
                        this.mNodes.add(resolutionAnchor);
                        resolutionAnchor.addDependent(resolutionNode);
                    }
                }
            }
        }
    }

    public void resetResolutionNodes() {
        super.resetResolutionNodes();
        this.mNodes.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r4 >= r2) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r5 = r10.mNodes.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r5.state == 1) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r10.mBarrierType == 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r10.mBarrierType != 2) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r5.resolvedOffset <= r1) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r5.resolvedOffset >= r1) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        r1 = r5.resolvedOffset;
        r3 = r5.resolvedTarget;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (android.support.constraint.solver.LinearSystem.getMetrics() == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        android.support.constraint.solver.LinearSystem.getMetrics().barrierConnectionResolved++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        r0.resolvedTarget = r3;
        r0.resolvedOffset = r1;
        r0.didResolve();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
        switch(r10.mBarrierType) {
            case 0: goto L_0x0083;
            case 1: goto L_0x0080;
            case 2: goto L_0x007d;
            case 3: goto L_0x0073;
            default: goto L_0x0072;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
        r0 = r10.mTop;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0075, code lost:
        r0.getResolutionNode().resolve(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007d, code lost:
        r0 = r10.mBottom;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        r0 = r10.mLeft;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0083, code lost:
        r0 = r10.mRight;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r0.getResolutionNode();
        r1 = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r0 = r0.getResolutionNode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        r2 = r10.mNodes.size();
        r3 = null;
        r4 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resolve() {
        /*
            r10 = this;
            int r0 = r10.mBarrierType
            r1 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = 0
            switch(r0) {
                case 0: goto L_0x0018;
                case 1: goto L_0x0010;
                case 2: goto L_0x000d;
                case 3: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            return
        L_0x000a:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r10.mBottom
            goto L_0x0012
        L_0x000d:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r10.mTop
            goto L_0x001a
        L_0x0010:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r10.mRight
        L_0x0012:
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r1 = 0
            goto L_0x001e
        L_0x0018:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r10.mLeft
        L_0x001a:
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
        L_0x001e:
            java.util.ArrayList<android.support.constraint.solver.widgets.ResolutionAnchor> r2 = r10.mNodes
            int r2 = r2.size()
            r3 = 0
            r4 = 0
        L_0x0026:
            if (r4 >= r2) goto L_0x0054
            java.util.ArrayList<android.support.constraint.solver.widgets.ResolutionAnchor> r5 = r10.mNodes
            java.lang.Object r5 = r5.get(r4)
            android.support.constraint.solver.widgets.ResolutionAnchor r5 = (android.support.constraint.solver.widgets.ResolutionAnchor) r5
            int r6 = r5.state
            r7 = 1
            if (r6 == r7) goto L_0x0036
            return
        L_0x0036:
            int r6 = r10.mBarrierType
            if (r6 == 0) goto L_0x0047
            int r6 = r10.mBarrierType
            r7 = 2
            if (r6 != r7) goto L_0x0040
            goto L_0x0047
        L_0x0040:
            float r6 = r5.resolvedOffset
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0051
            goto L_0x004d
        L_0x0047:
            float r6 = r5.resolvedOffset
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x0051
        L_0x004d:
            float r1 = r5.resolvedOffset
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r5.resolvedTarget
        L_0x0051:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0054:
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.getMetrics()
            if (r2 == 0) goto L_0x0066
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.getMetrics()
            long r4 = r2.barrierConnectionResolved
            r6 = 1
            long r8 = r4 + r6
            r2.barrierConnectionResolved = r8
        L_0x0066:
            r0.resolvedTarget = r3
            r0.resolvedOffset = r1
            r0.didResolve()
            int r0 = r10.mBarrierType
            switch(r0) {
                case 0: goto L_0x0083;
                case 1: goto L_0x0080;
                case 2: goto L_0x007d;
                case 3: goto L_0x0073;
                default: goto L_0x0072;
            }
        L_0x0072:
            return
        L_0x0073:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r10.mTop
        L_0x0075:
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r0.resolve(r3, r1)
            return
        L_0x007d:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r10.mBottom
            goto L_0x0075
        L_0x0080:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r10.mLeft
            goto L_0x0075
        L_0x0083:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r10.mRight
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Barrier.resolve():void");
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }
}
