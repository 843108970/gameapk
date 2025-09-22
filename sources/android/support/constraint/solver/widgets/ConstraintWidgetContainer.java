package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount = 0;
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    private int mOptimizationLevel = 7;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList();
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public ConstraintWidgetContainer() {
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        if (this.mHorizontalChainsSize + 1 >= this.mHorizontalChainsArray.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(this.mHorizontalChainsArray, this.mHorizontalChainsArray.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        if (this.mVerticalChainsSize + 1 >= this.mVerticalChainsArray.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(this.mVerticalChainsArray, this.mVerticalChainsArray.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.mChildren.get(i2)).analyze(i);
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARNING: type inference failed for: r8v10, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout() {
        /*
            r23 = this;
            r1 = r23
            int r2 = r1.mX
            int r3 = r1.mY
            int r4 = r23.getWidth()
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            int r6 = r23.getHeight()
            int r6 = java.lang.Math.max(r5, r6)
            r1.mWidthMeasuredTooSmall = r5
            r1.mHeightMeasuredTooSmall = r5
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r1.mParent
            if (r7 == 0) goto L_0x0046
            android.support.constraint.solver.widgets.Snapshot r7 = r1.mSnapshot
            if (r7 != 0) goto L_0x002a
            android.support.constraint.solver.widgets.Snapshot r7 = new android.support.constraint.solver.widgets.Snapshot
            r7.<init>(r1)
            r1.mSnapshot = r7
        L_0x002a:
            android.support.constraint.solver.widgets.Snapshot r7 = r1.mSnapshot
            r7.updateFrom(r1)
            int r7 = r1.mPaddingLeft
            r1.setX(r7)
            int r7 = r1.mPaddingTop
            r1.setY(r7)
            r23.resetAnchors()
            android.support.constraint.solver.LinearSystem r7 = r1.mSystem
            android.support.constraint.solver.Cache r7 = r7.getCache()
            r1.resetSolverVariables(r7)
            goto L_0x004a
        L_0x0046:
            r1.mX = r5
            r1.mY = r5
        L_0x004a:
            int r7 = r1.mOptimizationLevel
            r8 = 32
            r9 = 8
            r10 = 1
            if (r7 == 0) goto L_0x006a
            boolean r7 = r1.optimizeFor(r9)
            if (r7 != 0) goto L_0x005c
            r23.optimizeReset()
        L_0x005c:
            boolean r7 = r1.optimizeFor(r8)
            if (r7 != 0) goto L_0x0065
            r23.optimize()
        L_0x0065:
            android.support.constraint.solver.LinearSystem r7 = r1.mSystem
            r7.graphOptimizer = r10
            goto L_0x006e
        L_0x006a:
            android.support.constraint.solver.LinearSystem r7 = r1.mSystem
            r7.graphOptimizer = r5
        L_0x006e:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            r7 = r7[r10]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r11 = r1.mListDimensionBehaviors
            r11 = r11[r5]
            r23.resetChains()
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r12 = r1.mWidgetGroups
            int r12 = r12.size()
            if (r12 != 0) goto L_0x0092
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r12 = r1.mWidgetGroups
            r12.clear()
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r12 = r1.mWidgetGroups
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r13 = new android.support.constraint.solver.widgets.ConstraintWidgetGroup
            java.util.ArrayList r14 = r1.mChildren
            r13.<init>(r14)
            r12.add(r5, r13)
        L_0x0092:
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r12 = r1.mWidgetGroups
            int r12 = r12.size()
            java.util.ArrayList r13 = r1.mChildren
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = r23.getHorizontalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r14 == r15) goto L_0x00ad
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = r23.getVerticalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r14 != r15) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r14 = 0
            goto L_0x00ae
        L_0x00ad:
            r14 = 1
        L_0x00ae:
            r15 = 0
            r16 = 0
        L_0x00b1:
            if (r15 >= r12) goto L_0x0300
            boolean r9 = r1.mSkipSolver
            if (r9 != 0) goto L_0x0300
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r9 = r1.mWidgetGroups
            java.lang.Object r9 = r9.get(r15)
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r9 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r9
            boolean r9 = r9.mSkipSolver
            if (r9 != 0) goto L_0x02ee
            boolean r9 = r1.optimizeFor(r8)
            if (r9 == 0) goto L_0x00f4
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r23.getHorizontalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r9 != r8) goto L_0x00e6
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r23.getVerticalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r8 != r9) goto L_0x00e6
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r8 = r1.mWidgetGroups
            java.lang.Object r8 = r8.get(r15)
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r8 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r8
            java.util.List r8 = r8.getWidgetsToSolve()
            goto L_0x00f0
        L_0x00e6:
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r8 = r1.mWidgetGroups
            java.lang.Object r8 = r8.get(r15)
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r8 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r8
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidget> r8 = r8.mConstrainedGroup
        L_0x00f0:
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            r1.mChildren = r8
        L_0x00f4:
            r23.resetChains()
            java.util.ArrayList r8 = r1.mChildren
            int r8 = r8.size()
            r9 = 0
        L_0x00fe:
            if (r9 >= r8) goto L_0x0116
            java.util.ArrayList r5 = r1.mChildren
            java.lang.Object r5 = r5.get(r9)
            android.support.constraint.solver.widgets.ConstraintWidget r5 = (android.support.constraint.solver.widgets.ConstraintWidget) r5
            boolean r10 = r5 instanceof android.support.constraint.solver.widgets.WidgetContainer
            if (r10 == 0) goto L_0x0111
            android.support.constraint.solver.widgets.WidgetContainer r5 = (android.support.constraint.solver.widgets.WidgetContainer) r5
            r5.layout()
        L_0x0111:
            int r9 = r9 + 1
            r5 = 0
            r10 = 1
            goto L_0x00fe
        L_0x0116:
            r10 = r16
            r5 = 1
            r9 = 0
        L_0x011a:
            if (r5 == 0) goto L_0x02da
            r16 = 1
            int r9 = r9 + 1
            r17 = r5
            android.support.constraint.solver.LinearSystem r5 = r1.mSystem     // Catch:{ Exception -> 0x0169 }
            r5.reset()     // Catch:{ Exception -> 0x0169 }
            r23.resetChains()     // Catch:{ Exception -> 0x0169 }
            android.support.constraint.solver.LinearSystem r5 = r1.mSystem     // Catch:{ Exception -> 0x0169 }
            r1.createObjectVariables(r5)     // Catch:{ Exception -> 0x0169 }
            r5 = 0
        L_0x0130:
            if (r5 >= r8) goto L_0x014c
            r18 = r10
            java.util.ArrayList r10 = r1.mChildren     // Catch:{ Exception -> 0x014a }
            java.lang.Object r10 = r10.get(r5)     // Catch:{ Exception -> 0x014a }
            android.support.constraint.solver.widgets.ConstraintWidget r10 = (android.support.constraint.solver.widgets.ConstraintWidget) r10     // Catch:{ Exception -> 0x014a }
            r19 = r12
            android.support.constraint.solver.LinearSystem r12 = r1.mSystem     // Catch:{ Exception -> 0x0167 }
            r10.createObjectVariables(r12)     // Catch:{ Exception -> 0x0167 }
            int r5 = r5 + 1
            r10 = r18
            r12 = r19
            goto L_0x0130
        L_0x014a:
            r0 = move-exception
            goto L_0x016c
        L_0x014c:
            r18 = r10
            r19 = r12
            android.support.constraint.solver.LinearSystem r5 = r1.mSystem     // Catch:{ Exception -> 0x0167 }
            boolean r5 = r1.addChildrenToSolver(r5)     // Catch:{ Exception -> 0x0167 }
            if (r5 == 0) goto L_0x0162
            android.support.constraint.solver.LinearSystem r10 = r1.mSystem     // Catch:{ Exception -> 0x015e }
            r10.minimize()     // Catch:{ Exception -> 0x015e }
            goto L_0x0162
        L_0x015e:
            r0 = move-exception
            r17 = r5
            goto L_0x016e
        L_0x0162:
            r20 = r3
            r17 = r5
            goto L_0x0187
        L_0x0167:
            r0 = move-exception
            goto L_0x016e
        L_0x0169:
            r0 = move-exception
            r18 = r10
        L_0x016c:
            r19 = r12
        L_0x016e:
            r5 = r0
            r5.printStackTrace()
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r20 = r3
            java.lang.String r3 = "EXCEPTION : "
            r12.<init>(r3)
            r12.append(r5)
            java.lang.String r3 = r12.toString()
            r10.println(r3)
        L_0x0187:
            if (r17 == 0) goto L_0x0192
            android.support.constraint.solver.LinearSystem r5 = r1.mSystem
            boolean[] r10 = android.support.constraint.solver.widgets.Optimizer.flags
            r1.updateChildrenFromSolver(r5, r10)
        L_0x0190:
            r10 = 2
            goto L_0x01db
        L_0x0192:
            android.support.constraint.solver.LinearSystem r5 = r1.mSystem
            r1.updateFromSolver(r5)
            r5 = 0
        L_0x0198:
            if (r5 >= r8) goto L_0x0190
            java.util.ArrayList r10 = r1.mChildren
            java.lang.Object r10 = r10.get(r5)
            android.support.constraint.solver.widgets.ConstraintWidget r10 = (android.support.constraint.solver.widgets.ConstraintWidget) r10
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r12 = r10.mListDimensionBehaviors
            r16 = 0
            r12 = r12[r16]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r12 != r3) goto L_0x01bd
            int r3 = r10.getWidth()
            int r12 = r10.getWrapWidth()
            if (r3 >= r12) goto L_0x01bd
            boolean[] r3 = android.support.constraint.solver.widgets.Optimizer.flags
            r5 = 2
            r12 = 1
            r3[r5] = r12
            goto L_0x0190
        L_0x01bd:
            r12 = 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r10.mListDimensionBehaviors
            r3 = r3[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r12) goto L_0x01d7
            int r3 = r10.getHeight()
            int r10 = r10.getWrapHeight()
            if (r3 >= r10) goto L_0x01d7
            boolean[] r3 = android.support.constraint.solver.widgets.Optimizer.flags
            r5 = 1
            r10 = 2
            r3[r10] = r5
            goto L_0x01db
        L_0x01d7:
            r10 = 2
            int r5 = r5 + 1
            goto L_0x0198
        L_0x01db:
            if (r14 == 0) goto L_0x0253
            r3 = 8
            if (r9 >= r3) goto L_0x0253
            boolean[] r5 = android.support.constraint.solver.widgets.Optimizer.flags
            boolean r5 = r5[r10]
            if (r5 == 0) goto L_0x0253
            r5 = 0
            r10 = 0
            r12 = 0
        L_0x01ea:
            if (r5 >= r8) goto L_0x0214
            java.util.ArrayList r3 = r1.mChildren
            java.lang.Object r3 = r3.get(r5)
            android.support.constraint.solver.widgets.ConstraintWidget r3 = (android.support.constraint.solver.widgets.ConstraintWidget) r3
            r21 = r8
            int r8 = r3.mX
            int r16 = r3.getWidth()
            int r8 = r8 + r16
            int r10 = java.lang.Math.max(r10, r8)
            int r8 = r3.mY
            int r3 = r3.getHeight()
            int r8 = r8 + r3
            int r12 = java.lang.Math.max(r12, r8)
            int r5 = r5 + 1
            r8 = r21
            r3 = 8
            goto L_0x01ea
        L_0x0214:
            r21 = r8
            int r3 = r1.mMinWidth
            int r3 = java.lang.Math.max(r3, r10)
            int r5 = r1.mMinHeight
            int r5 = java.lang.Math.max(r5, r12)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 != r8) goto L_0x0239
            int r8 = r23.getWidth()
            if (r8 >= r3) goto L_0x0239
            r1.setWidth(r3)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r10 = 0
            r3[r10] = r8
            r3 = 1
            r10 = 1
            goto L_0x023c
        L_0x0239:
            r10 = r18
            r3 = 0
        L_0x023c:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r8) goto L_0x0258
            int r8 = r23.getHeight()
            if (r8 >= r5) goto L_0x0258
            r1.setHeight(r5)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8 = 1
            r3[r8] = r5
            r3 = 1
            r10 = 1
            goto L_0x0258
        L_0x0253:
            r21 = r8
            r10 = r18
            r3 = 0
        L_0x0258:
            int r5 = r1.mMinWidth
            int r8 = r23.getWidth()
            int r5 = java.lang.Math.max(r5, r8)
            int r8 = r23.getWidth()
            if (r5 <= r8) goto L_0x0274
            r1.setWidth(r5)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 0
            r3[r8] = r5
            r3 = 1
            r10 = 1
        L_0x0274:
            int r5 = r1.mMinHeight
            int r8 = r23.getHeight()
            int r5 = java.lang.Math.max(r5, r8)
            int r8 = r23.getHeight()
            if (r5 <= r8) goto L_0x0291
            r1.setHeight(r5)
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = 1
            r3[r8] = r5
            r3 = 1
            r10 = 1
            goto L_0x0292
        L_0x0291:
            r8 = 1
        L_0x0292:
            if (r10 != 0) goto L_0x02d1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            r12 = 0
            r5 = r5[r12]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r12) goto L_0x02b3
            if (r4 <= 0) goto L_0x02b3
            int r5 = r23.getWidth()
            if (r5 <= r4) goto L_0x02b3
            r1.mWidthMeasuredTooSmall = r8
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10 = 0
            r3[r10] = r5
            r1.setWidth(r4)
            r3 = 1
            r10 = 1
        L_0x02b3:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.mListDimensionBehaviors
            r5 = r5[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r12) goto L_0x02d1
            if (r6 <= 0) goto L_0x02d1
            int r5 = r23.getHeight()
            if (r5 <= r6) goto L_0x02d1
            r1.mHeightMeasuredTooSmall = r8
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.mListDimensionBehaviors
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r3[r8] = r5
            r1.setHeight(r6)
            r5 = 1
            r10 = 1
            goto L_0x02d2
        L_0x02d1:
            r5 = r3
        L_0x02d2:
            r12 = r19
            r3 = r20
            r8 = r21
            goto L_0x011a
        L_0x02da:
            r20 = r3
            r18 = r10
            r19 = r12
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r3 = r1.mWidgetGroups
            java.lang.Object r3 = r3.get(r15)
            android.support.constraint.solver.widgets.ConstraintWidgetGroup r3 = (android.support.constraint.solver.widgets.ConstraintWidgetGroup) r3
            r3.updateUnresolvedWidgets()
            r16 = r18
            goto L_0x02f2
        L_0x02ee:
            r20 = r3
            r19 = r12
        L_0x02f2:
            int r15 = r15 + 1
            r12 = r19
            r3 = r20
            r5 = 0
            r8 = 32
            r9 = 8
            r10 = 1
            goto L_0x00b1
        L_0x0300:
            r20 = r3
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            r1.mChildren = r13
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r1.mParent
            if (r3 == 0) goto L_0x0336
            int r2 = r1.mMinWidth
            int r3 = r23.getWidth()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.mMinHeight
            int r4 = r23.getHeight()
            int r3 = java.lang.Math.max(r3, r4)
            android.support.constraint.solver.widgets.Snapshot r4 = r1.mSnapshot
            r4.applyTo(r1)
            int r4 = r1.mPaddingLeft
            int r2 = r2 + r4
            int r4 = r1.mPaddingRight
            int r2 = r2 + r4
            r1.setWidth(r2)
            int r2 = r1.mPaddingTop
            int r3 = r3 + r2
            int r2 = r1.mPaddingBottom
            int r3 = r3 + r2
            r1.setHeight(r3)
            goto L_0x033c
        L_0x0336:
            r1.mX = r2
            r2 = r20
            r1.mY = r2
        L_0x033c:
            if (r16 == 0) goto L_0x0348
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r1.mListDimensionBehaviors
            r3 = 0
            r2[r3] = r11
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r1.mListDimensionBehaviors
            r3 = 1
            r2[r3] = r7
        L_0x0348:
            android.support.constraint.solver.LinearSystem r2 = r1.mSystem
            android.support.constraint.solver.Cache r2 = r2.getCache()
            r1.resetSolverVariables(r2)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r2 = r23.getRootConstraintContainer()
            if (r1 != r2) goto L_0x035a
            r23.updateDrawPosition()
        L_0x035a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    public void optimizeForDimensions(int i, int i2) {
        if (!(this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.mResolutionWidth == null)) {
            this.mResolutionWidth.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.mResolutionHeight != null) {
            this.mResolutionHeight.resolve(i2);
        }
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetResolutionNodes();
        }
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
        }
    }
}
