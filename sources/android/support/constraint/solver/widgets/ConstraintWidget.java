package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v7.widget.ActivityChooserView;
import com.cyjh.common.util.s;
import java.util.ArrayList;

public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintWidgetGroup mBelongingGroup;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    boolean mOptimizerMeasured;
    ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    int[] mResolvedMatchConstraintDefault;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;
    protected int mX;
    protected int mY;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01e5, code lost:
        if (r33 != false) goto L_0x01d6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02dd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(android.support.constraint.solver.LinearSystem r32, boolean r33, android.support.constraint.solver.SolverVariable r34, android.support.constraint.solver.SolverVariable r35, android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour r36, boolean r37, android.support.constraint.solver.widgets.ConstraintAnchor r38, android.support.constraint.solver.widgets.ConstraintAnchor r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, int r47, int r48, int r49, float r50, boolean r51) {
        /*
            r31 = this;
            r0 = r31
            r10 = r32
            r12 = r34
            r13 = r35
            r14 = r38
            r15 = r39
            r1 = r42
            r2 = r43
            android.support.constraint.solver.SolverVariable r9 = r10.createObjectVariable(r14)
            android.support.constraint.solver.SolverVariable r8 = r10.createObjectVariable(r15)
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r38.getTarget()
            android.support.constraint.solver.SolverVariable r7 = r10.createObjectVariable(r6)
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r39.getTarget()
            android.support.constraint.solver.SolverVariable r6 = r10.createObjectVariable(r6)
            boolean r12 = r10.graphOptimizer
            r16 = 1
            r22 = r6
            if (r12 == 0) goto L_0x0069
            android.support.constraint.solver.widgets.ResolutionAnchor r12 = r38.getResolutionNode()
            int r12 = r12.state
            r6 = 1
            if (r12 != r6) goto L_0x0069
            android.support.constraint.solver.widgets.ResolutionAnchor r12 = r39.getResolutionNode()
            int r12 = r12.state
            if (r12 != r6) goto L_0x0069
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.getMetrics()
            if (r1 == 0) goto L_0x0051
            android.support.constraint.solver.Metrics r1 = android.support.constraint.solver.LinearSystem.getMetrics()
            long r2 = r1.resolvedWidgets
            long r5 = r2 + r16
            r1.resolvedWidgets = r5
        L_0x0051:
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r38.getResolutionNode()
            r1.addResolvedValue(r10)
            android.support.constraint.solver.widgets.ResolutionAnchor r1 = r39.getResolutionNode()
            r1.addResolvedValue(r10)
            if (r46 != 0) goto L_0x0068
            if (r33 == 0) goto L_0x0068
            r1 = 0
            r2 = 6
            r10.addGreaterThan(r13, r8, r1, r2)
        L_0x0068:
            return
        L_0x0069:
            android.support.constraint.solver.Metrics r6 = android.support.constraint.solver.LinearSystem.getMetrics()
            if (r6 == 0) goto L_0x0079
            android.support.constraint.solver.Metrics r6 = android.support.constraint.solver.LinearSystem.getMetrics()
            long r12 = r6.nonresolvedWidgets
            long r1 = r12 + r16
            r6.nonresolvedWidgets = r1
        L_0x0079:
            boolean r1 = r38.isConnected()
            boolean r2 = r39.isConnected()
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r0.mCenter
            boolean r6 = r6.isConnected()
            if (r1 == 0) goto L_0x008b
            r12 = 1
            goto L_0x008c
        L_0x008b:
            r12 = 0
        L_0x008c:
            if (r2 == 0) goto L_0x0090
            int r12 = r12 + 1
        L_0x0090:
            if (r6 == 0) goto L_0x0094
            int r12 = r12 + 1
        L_0x0094:
            if (r45 == 0) goto L_0x0098
            r13 = 3
            goto L_0x009a
        L_0x0098:
            r13 = r47
        L_0x009a:
            int[] r16 = android.support.constraint.solver.widgets.ConstraintWidget.AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour
            int r17 = r36.ordinal()
            r16 = r16[r17]
            r15 = 4
            switch(r16) {
                case 1: goto L_0x00a6;
                case 2: goto L_0x00a6;
                case 3: goto L_0x00a6;
                case 4: goto L_0x00a9;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            r16 = 0
            goto L_0x00ae
        L_0x00a9:
            if (r13 != r15) goto L_0x00ac
            goto L_0x00a6
        L_0x00ac:
            r16 = 1
        L_0x00ae:
            int r15 = r0.mVisibility
            r3 = 8
            if (r15 != r3) goto L_0x00b8
            r3 = 0
            r16 = 0
            goto L_0x00ba
        L_0x00b8:
            r3 = r41
        L_0x00ba:
            if (r51 == 0) goto L_0x00d7
            if (r1 != 0) goto L_0x00c8
            if (r2 != 0) goto L_0x00c8
            if (r6 != 0) goto L_0x00c8
            r15 = r40
            r10.addEquality(r9, r15)
            goto L_0x00d7
        L_0x00c8:
            if (r1 == 0) goto L_0x00d7
            if (r2 != 0) goto L_0x00d7
            int r15 = r38.getMargin()
            r23 = r6
            r6 = 6
            r10.addEquality(r9, r7, r15, r6)
            goto L_0x00da
        L_0x00d7:
            r23 = r6
            r6 = 6
        L_0x00da:
            if (r16 != 0) goto L_0x010a
            if (r37 == 0) goto L_0x00fa
            r6 = 3
            r15 = 0
            r10.addEquality(r8, r9, r15, r6)
            r6 = r42
            if (r6 <= 0) goto L_0x00ec
            r15 = 6
            r10.addGreaterThan(r8, r9, r6, r15)
            goto L_0x00ed
        L_0x00ec:
            r15 = 6
        L_0x00ed:
            r3 = 2147483647(0x7fffffff, float:NaN)
            r24 = r7
            r7 = r43
            if (r7 >= r3) goto L_0x0102
            r10.addLowerThan(r8, r9, r7, r15)
            goto L_0x0102
        L_0x00fa:
            r24 = r7
            r6 = r42
            r15 = 6
            r10.addEquality(r8, r9, r3, r15)
        L_0x0102:
            r6 = r48
            r15 = r49
            r25 = r13
            goto L_0x01c4
        L_0x010a:
            r24 = r7
            r6 = r42
            r15 = 6
            r7 = -2
            r15 = r48
            if (r15 != r7) goto L_0x0118
            r15 = r49
            r6 = r3
            goto L_0x011b
        L_0x0118:
            r6 = r15
            r15 = r49
        L_0x011b:
            if (r15 != r7) goto L_0x011e
            r15 = r3
        L_0x011e:
            if (r6 <= 0) goto L_0x0129
            r7 = 6
            r10.addGreaterThan(r8, r9, r6, r7)
            int r3 = java.lang.Math.max(r3, r6)
            goto L_0x012a
        L_0x0129:
            r7 = 6
        L_0x012a:
            if (r15 <= 0) goto L_0x0133
            r10.addLowerThan(r8, r9, r15, r7)
            int r3 = java.lang.Math.min(r3, r15)
        L_0x0133:
            r7 = 1
            if (r13 != r7) goto L_0x0144
            if (r33 == 0) goto L_0x013e
            r7 = 6
        L_0x0139:
            r10.addEquality(r8, r9, r3, r7)
            goto L_0x01ab
        L_0x013e:
            if (r46 == 0) goto L_0x0142
            r7 = 4
            goto L_0x0139
        L_0x0142:
            r7 = 1
            goto L_0x0139
        L_0x0144:
            r7 = 2
            if (r13 != r7) goto L_0x01ab
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r7 = r38.getType()
            r25 = r13
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r7 == r13) goto L_0x0179
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r7 = r38.getType()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r7 != r13) goto L_0x015a
            goto L_0x0179
        L_0x015a:
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r0.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.getAnchor(r13)
            android.support.constraint.solver.SolverVariable r7 = r10.createObjectVariable(r7)
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.mParent
            r26 = r7
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r7 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r13.getAnchor(r7)
            android.support.constraint.solver.SolverVariable r7 = r10.createObjectVariable(r7)
            r19 = r7
            r20 = r26
            goto L_0x0197
        L_0x0179:
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r0.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r7.getAnchor(r13)
            android.support.constraint.solver.SolverVariable r7 = r10.createObjectVariable(r7)
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.mParent
            r27 = r7
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r7 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r13.getAnchor(r7)
            android.support.constraint.solver.SolverVariable r7 = r10.createObjectVariable(r7)
            r19 = r7
            r20 = r27
        L_0x0197:
            android.support.constraint.solver.ArrayRow r16 = r32.createRow()
            r17 = r8
            r18 = r9
            r21 = r50
            android.support.constraint.solver.ArrayRow r7 = r16.createRowDimensionRatio(r17, r18, r19, r20, r21)
            r10.addConstraint(r7)
            r16 = 0
            goto L_0x01ad
        L_0x01ab:
            r25 = r13
        L_0x01ad:
            if (r16 == 0) goto L_0x01c4
            r7 = 2
            if (r12 == r7) goto L_0x01c4
            if (r45 != 0) goto L_0x01c4
            int r3 = java.lang.Math.max(r6, r3)
            if (r15 <= 0) goto L_0x01be
            int r3 = java.lang.Math.min(r15, r3)
        L_0x01be:
            r13 = 6
            r10.addEquality(r8, r9, r3, r13)
            r16 = 0
        L_0x01c4:
            if (r51 == 0) goto L_0x02ff
            if (r46 == 0) goto L_0x01ca
            goto L_0x02ff
        L_0x01ca:
            r12 = 5
            if (r1 != 0) goto L_0x01de
            if (r2 != 0) goto L_0x01de
            if (r23 != 0) goto L_0x01de
            if (r33 == 0) goto L_0x01d9
            r5 = 0
            r13 = r35
        L_0x01d6:
            r10.addGreaterThan(r13, r8, r5, r12)
        L_0x01d9:
            r1 = r8
        L_0x01da:
            r3 = 0
            r4 = 6
            goto L_0x02f7
        L_0x01de:
            r5 = 0
            r13 = r35
            if (r1 == 0) goto L_0x01e8
            if (r2 != 0) goto L_0x01e8
            if (r33 == 0) goto L_0x01d9
            goto L_0x01d6
        L_0x01e8:
            if (r1 != 0) goto L_0x0201
            if (r2 == 0) goto L_0x0201
            r4 = r39
            int r1 = r39.getMargin()
            int r1 = -r1
            r2 = r22
            r3 = 6
            r10.addEquality(r8, r2, r1, r3)
            if (r33 == 0) goto L_0x01d9
            r1 = r34
            r10.addGreaterThan(r9, r1, r5, r12)
            goto L_0x01d9
        L_0x0201:
            r12 = r22
            r3 = 4
            r4 = r39
            if (r1 == 0) goto L_0x01d9
            if (r2 == 0) goto L_0x01d9
            if (r16 == 0) goto L_0x026f
            if (r33 == 0) goto L_0x0217
            r1 = r42
            if (r1 != 0) goto L_0x0217
            r2 = 6
            r10.addGreaterThan(r8, r9, r5, r2)
            goto L_0x0218
        L_0x0217:
            r2 = 6
        L_0x0218:
            if (r25 != 0) goto L_0x0242
            if (r15 > 0) goto L_0x0222
            if (r6 <= 0) goto L_0x021f
            goto L_0x0222
        L_0x021f:
            r1 = 0
            r3 = 6
            goto L_0x0223
        L_0x0222:
            r1 = 1
        L_0x0223:
            int r7 = r38.getMargin()
            r13 = r24
            r10.addEquality(r9, r13, r7, r3)
            int r7 = r39.getMargin()
            int r7 = -r7
            r10.addEquality(r8, r12, r7, r3)
            if (r15 > 0) goto L_0x023b
            if (r6 <= 0) goto L_0x0239
            goto L_0x023b
        L_0x0239:
            r6 = 0
            goto L_0x023c
        L_0x023b:
            r6 = 1
        L_0x023c:
            r17 = r1
            r1 = r6
            r6 = 1
            r15 = 5
            goto L_0x0276
        L_0x0242:
            r13 = r24
            r1 = r25
            r6 = 1
            if (r1 != r6) goto L_0x024e
            r1 = 1
            r15 = 6
        L_0x024b:
            r17 = 1
            goto L_0x0276
        L_0x024e:
            r2 = 3
            if (r1 != r2) goto L_0x026d
            if (r45 != 0) goto L_0x025b
            int r1 = r0.mResolvedDimensionRatioSide
            r2 = -1
            if (r1 == r2) goto L_0x025b
            if (r15 > 0) goto L_0x025b
            r3 = 6
        L_0x025b:
            int r1 = r38.getMargin()
            r10.addEquality(r9, r13, r1, r3)
            int r1 = r39.getMargin()
            int r1 = -r1
            r10.addEquality(r8, r12, r1, r3)
            r1 = 1
            r15 = 5
            goto L_0x024b
        L_0x026d:
            r1 = 0
            goto L_0x0273
        L_0x026f:
            r13 = r24
            r6 = 1
            r1 = 1
        L_0x0273:
            r15 = 5
            r17 = 0
        L_0x0276:
            if (r1 == 0) goto L_0x02bc
            int r7 = r38.getMargin()
            int r18 = r39.getMargin()
            r1 = r10
            r19 = 6
            r2 = r9
            r3 = r13
            r0 = r4
            r4 = r7
            r7 = 0
            r5 = r44
            r29 = r13
            r13 = 6
            r19 = 1
            r6 = r12
            r13 = r29
            r7 = r8
            r11 = r8
            r8 = r18
            r30 = r11
            r11 = r9
            r9 = r15
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r14.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r1.mOwner
            boolean r1 = r1 instanceof android.support.constraint.solver.widgets.Barrier
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r2.mOwner
            boolean r2 = r2 instanceof android.support.constraint.solver.widgets.Barrier
            if (r1 == 0) goto L_0x02b4
            if (r2 != 0) goto L_0x02b4
            r19 = r33
            r1 = 1
            r6 = 5
            r28 = 6
            goto L_0x02c7
        L_0x02b4:
            if (r1 != 0) goto L_0x02c0
            if (r2 == 0) goto L_0x02c0
            r1 = r33
            r6 = 6
            goto L_0x02c5
        L_0x02bc:
            r0 = r4
            r30 = r8
            r11 = r9
        L_0x02c0:
            r1 = r33
            r19 = r1
            r6 = 5
        L_0x02c5:
            r28 = 5
        L_0x02c7:
            if (r17 == 0) goto L_0x02cc
            r2 = 6
            r6 = 6
            goto L_0x02ce
        L_0x02cc:
            r2 = r28
        L_0x02ce:
            if (r16 != 0) goto L_0x02d2
            if (r19 != 0) goto L_0x02d4
        L_0x02d2:
            if (r17 == 0) goto L_0x02db
        L_0x02d4:
            int r3 = r38.getMargin()
            r10.addGreaterThan(r11, r13, r3, r6)
        L_0x02db:
            if (r16 != 0) goto L_0x02df
            if (r1 != 0) goto L_0x02e1
        L_0x02df:
            if (r17 == 0) goto L_0x02ec
        L_0x02e1:
            int r0 = r39.getMargin()
            int r0 = -r0
            r1 = r30
            r10.addLowerThan(r1, r12, r0, r2)
            goto L_0x02ee
        L_0x02ec:
            r1 = r30
        L_0x02ee:
            if (r33 == 0) goto L_0x01da
            r2 = r34
            r3 = 0
            r4 = 6
            r10.addGreaterThan(r11, r2, r3, r4)
        L_0x02f7:
            if (r33 == 0) goto L_0x02fe
            r5 = r35
            r10.addGreaterThan(r5, r1, r3, r4)
        L_0x02fe:
            return
        L_0x02ff:
            r1 = r8
            r11 = r9
            r2 = r34
            r3 = 0
            r4 = 6
            r5 = r35
            r6 = 2
            if (r12 >= r6) goto L_0x0312
            if (r33 == 0) goto L_0x0312
            r10.addGreaterThan(r11, r2, r3, r4)
            r10.addGreaterThan(r5, r1, r3, r4)
        L_0x0312:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.applyConstraints(android.support.constraint.solver.LinearSystem, boolean, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, android.support.constraint.solver.widgets.ConstraintAnchor, android.support.constraint.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget == null || this.mListAnchors[i2].mTarget.mTarget == this.mListAnchors[i2]) {
            return false;
        }
        int i3 = i2 + 1;
        return this.mListAnchors[i3].mTarget != null && this.mListAnchors[i3].mTarget.mTarget == this.mListAnchors[i3];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01c3, code lost:
        if (r15.mResolvedDimensionRatioSide == -1) goto L_0x01c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0270 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(android.support.constraint.solver.LinearSystem r42) {
        /*
            r41 = this;
            r15 = r41
            r14 = r42
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mLeft
            android.support.constraint.solver.SolverVariable r21 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mRight
            android.support.constraint.solver.SolverVariable r13 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mTop
            android.support.constraint.solver.SolverVariable r12 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBottom
            android.support.constraint.solver.SolverVariable r11 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.SolverVariable r10 = r14.createObjectVariable(r0)
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            r1 = 8
            r9 = 1
            r8 = 0
            if (r0 == 0) goto L_0x00b7
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x003a
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r0 = r0[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r2) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.mParent
            if (r2 == 0) goto L_0x004b
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r2 = r2[r9]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r3) goto L_0x004b
            r2 = 1
            goto L_0x004c
        L_0x004b:
            r2 = 0
        L_0x004c:
            boolean r3 = r15.isChainHead(r8)
            if (r3 == 0) goto L_0x005b
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = (android.support.constraint.solver.widgets.ConstraintWidgetContainer) r3
            r3.addChain(r15, r8)
            r3 = 1
            goto L_0x005f
        L_0x005b:
            boolean r3 = r41.isInHorizontalChain()
        L_0x005f:
            boolean r4 = r15.isChainHead(r9)
            if (r4 == 0) goto L_0x006e
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r4 = (android.support.constraint.solver.widgets.ConstraintWidgetContainer) r4
            r4.addChain(r15, r9)
            r4 = 1
            goto L_0x0072
        L_0x006e:
            boolean r4 = r41.isInVerticalChain()
        L_0x0072:
            if (r0 == 0) goto L_0x008f
            int r5 = r15.mVisibility
            if (r5 == r1) goto L_0x008f
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x008f
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mRight
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x008f
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mRight
            android.support.constraint.solver.SolverVariable r5 = r14.createObjectVariable(r5)
            r14.addGreaterThan(r5, r13, r8, r9)
        L_0x008f:
            if (r2 == 0) goto L_0x00b0
            int r5 = r15.mVisibility
            if (r5 == r1) goto L_0x00b0
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x00b0
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mBottom
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 != 0) goto L_0x00b0
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r15.mBaseline
            if (r5 != 0) goto L_0x00b0
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r5.mBottom
            android.support.constraint.solver.SolverVariable r5 = r14.createObjectVariable(r5)
            r14.addGreaterThan(r5, r11, r8, r9)
        L_0x00b0:
            r7 = r2
            r16 = r3
            r22 = r4
            r2 = r0
            goto L_0x00bd
        L_0x00b7:
            r2 = 0
            r7 = 0
            r16 = 0
            r22 = 0
        L_0x00bd:
            int r0 = r15.mWidth
            int r3 = r15.mMinWidth
            if (r0 >= r3) goto L_0x00c5
            int r0 = r15.mMinWidth
        L_0x00c5:
            int r3 = r15.mHeight
            int r4 = r15.mMinHeight
            if (r3 >= r4) goto L_0x00cd
            int r3 = r15.mMinHeight
        L_0x00cd:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r15.mListDimensionBehaviors
            r4 = r4[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 == r5) goto L_0x00d7
            r4 = 1
            goto L_0x00d8
        L_0x00d7:
            r4 = 0
        L_0x00d8:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r15.mListDimensionBehaviors
            r5 = r5[r9]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 == r6) goto L_0x00e2
            r5 = 1
            goto L_0x00e3
        L_0x00e2:
            r5 = 0
        L_0x00e3:
            int r6 = r15.mDimensionRatioSide
            r15.mResolvedDimensionRatioSide = r6
            float r6 = r15.mDimensionRatio
            r15.mResolvedDimensionRatio = r6
            int r6 = r15.mMatchConstraintDefaultWidth
            int r9 = r15.mMatchConstraintDefaultHeight
            float r8 = r15.mDimensionRatio
            r17 = 0
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            r17 = 4
            if (r8 <= 0) goto L_0x01a4
            int r8 = r15.mVisibility
            r1 = 8
            if (r8 == r1) goto L_0x01a4
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r8 = 0
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r27 = r0
            r0 = 3
            if (r1 != r8) goto L_0x010e
            if (r6 != 0) goto L_0x010e
            r6 = 3
        L_0x010e:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r8 = 1
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r8) goto L_0x011a
            if (r9 != 0) goto L_0x011a
            r9 = 3
        L_0x011a:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r8 = 0
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r8) goto L_0x0135
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r8 = 1
            r1 = r1[r8]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r8) goto L_0x0135
            if (r6 != r0) goto L_0x0135
            if (r9 != r0) goto L_0x0135
            r15.setupDimensionRatio(r2, r7, r4, r5)
            goto L_0x0199
        L_0x0135:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r4 = 0
            r1 = r1[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r5) goto L_0x0163
            if (r6 != r0) goto L_0x0163
            r15.mResolvedDimensionRatioSide = r4
            float r0 = r15.mResolvedDimensionRatio
            int r1 = r15.mHeight
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r4 = 1
            r1 = r1[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r5) goto L_0x015a
            r18 = r0
            r28 = r3
            r25 = r9
            goto L_0x01ae
        L_0x015a:
            r18 = r0
            r28 = r3
            r17 = r6
            r25 = r9
            goto L_0x01a1
        L_0x0163:
            r4 = 1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r1 = r1[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r5) goto L_0x0199
            if (r9 != r0) goto L_0x0199
            r15.mResolvedDimensionRatioSide = r4
            int r0 = r15.mDimensionRatioSide
            r1 = -1
            if (r0 != r1) goto L_0x017c
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = r15.mResolvedDimensionRatio
            float r0 = r0 / r1
            r15.mResolvedDimensionRatio = r0
        L_0x017c:
            float r0 = r15.mResolvedDimensionRatio
            int r1 = r15.mWidth
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.mListDimensionBehaviors
            r3 = 0
            r1 = r1[r3]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 == r3) goto L_0x0196
            r28 = r0
            r17 = r6
            r18 = r27
            r25 = 4
            goto L_0x01ae
        L_0x0196:
            r28 = r0
            goto L_0x019b
        L_0x0199:
            r28 = r3
        L_0x019b:
            r17 = r6
            r25 = r9
            r18 = r27
        L_0x01a1:
            r27 = 1
            goto L_0x01b0
        L_0x01a4:
            r27 = r0
            r28 = r3
            r17 = r6
            r25 = r9
            r18 = r27
        L_0x01ae:
            r27 = 0
        L_0x01b0:
            int[] r0 = r15.mResolvedMatchConstraintDefault
            r1 = 0
            r0[r1] = r17
            int[] r0 = r15.mResolvedMatchConstraintDefault
            r1 = 1
            r0[r1] = r25
            if (r27 == 0) goto L_0x01ca
            int r0 = r15.mResolvedDimensionRatioSide
            if (r0 == 0) goto L_0x01c6
            int r0 = r15.mResolvedDimensionRatioSide
            r1 = -1
            if (r0 != r1) goto L_0x01cb
            goto L_0x01c7
        L_0x01c6:
            r1 = -1
        L_0x01c7:
            r19 = 1
            goto L_0x01cd
        L_0x01ca:
            r1 = -1
        L_0x01cb:
            r19 = 0
        L_0x01cd:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r3 = 0
            r0 = r0[r3]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x01dc
            boolean r0 = r15 instanceof android.support.constraint.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x01dc
            r6 = 1
            goto L_0x01dd
        L_0x01dc:
            r6 = 0
        L_0x01dd:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mCenter
            boolean r0 = r0.isConnected()
            r9 = 1
            r23 = r0 ^ 1
            int r0 = r15.mHorizontalResolution
            r8 = 2
            r26 = 0
            if (r0 == r8) goto L_0x0261
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x01fb
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mRight
            android.support.constraint.solver.SolverVariable r0 = r14.createObjectVariable(r0)
            r4 = r0
            goto L_0x01fd
        L_0x01fb:
            r4 = r26
        L_0x01fd:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x020b
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mLeft
            android.support.constraint.solver.SolverVariable r0 = r14.createObjectVariable(r0)
            r3 = r0
            goto L_0x020d
        L_0x020b:
            r3 = r26
        L_0x020d:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r20 = 0
            r5 = r0[r20]
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mLeft
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r15.mRight
            int r9 = r15.mX
            r31 = r11
            int r11 = r15.mMinWidth
            int[] r1 = r15.mMaxDimension
            r24 = r1[r20]
            float r1 = r15.mHorizontalBiasPercent
            r33 = r13
            int r13 = r15.mMatchConstraintMinWidth
            r34 = r13
            int r13 = r15.mMatchConstraintMaxWidth
            r35 = r13
            float r13 = r15.mMatchConstraintPercentWidth
            r36 = r0
            r0 = r15
            r32 = r1
            r1 = r14
            r37 = r7
            r7 = r36
            r38 = r10
            r10 = r18
            r29 = r31
            r39 = r12
            r12 = r24
            r30 = r13
            r24 = r33
            r18 = r34
            r20 = r35
            r13 = r32
            r14 = r19
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r20
            r19 = r30
            r20 = r23
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r15 = r41
            goto L_0x026b
        L_0x0261:
            r37 = r7
            r38 = r10
            r29 = r11
            r39 = r12
            r24 = r13
        L_0x026b:
            int r0 = r15.mVerticalResolution
            r1 = 2
            if (r0 != r1) goto L_0x0271
            return
        L_0x0271:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r14 = 1
            r0 = r0[r14]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r1) goto L_0x0280
            boolean r0 = r15 instanceof android.support.constraint.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0280
            r6 = 1
            goto L_0x0281
        L_0x0280:
            r6 = 0
        L_0x0281:
            if (r27 == 0) goto L_0x028f
            int r0 = r15.mResolvedDimensionRatioSide
            if (r0 == r14) goto L_0x028c
            int r0 = r15.mResolvedDimensionRatioSide
            r1 = -1
            if (r0 != r1) goto L_0x028f
        L_0x028c:
            r16 = 1
            goto L_0x0291
        L_0x028f:
            r16 = 0
        L_0x0291:
            int r0 = r15.mBaselineDistance
            if (r0 <= 0) goto L_0x02d0
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            int r0 = r0.state
            if (r0 != r14) goto L_0x02ad
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.widgets.ResolutionAnchor r0 = r0.getResolutionNode()
            r13 = r42
            r0.addResolvedValue(r13)
            r12 = r39
            goto L_0x02d4
        L_0x02ad:
            r13 = r42
            int r0 = r41.getBaselineDistance()
            r1 = 6
            r2 = r38
            r12 = r39
            r13.addEquality(r2, r12, r0, r1)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x02d4
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.mBaseline
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            android.support.constraint.solver.SolverVariable r0 = r13.createObjectVariable(r0)
            r3 = 0
            r13.addEquality(r2, r0, r3, r1)
            r20 = 0
            goto L_0x02d6
        L_0x02d0:
            r12 = r39
            r13 = r42
        L_0x02d4:
            r20 = r23
        L_0x02d6:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x02e4
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            android.support.constraint.solver.SolverVariable r0 = r13.createObjectVariable(r0)
            r4 = r0
            goto L_0x02e6
        L_0x02e4:
            r4 = r26
        L_0x02e6:
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            if (r0 == 0) goto L_0x02f4
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r15.mParent
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.mTop
            android.support.constraint.solver.SolverVariable r0 = r13.createObjectVariable(r0)
            r3 = r0
            goto L_0x02f6
        L_0x02f4:
            r3 = r26
        L_0x02f6:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.mListDimensionBehaviors
            r5 = r0[r14]
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r15.mTop
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r15.mBottom
            int r9 = r15.mY
            int r11 = r15.mMinHeight
            int[] r0 = r15.mMaxDimension
            r17 = r0[r14]
            float r10 = r15.mVerticalBiasPercent
            int r2 = r15.mMatchConstraintMinHeight
            int r1 = r15.mMatchConstraintMaxHeight
            float r0 = r15.mMatchConstraintPercentHeight
            r19 = r0
            r0 = r15
            r18 = r1
            r1 = r13
            r23 = r2
            r2 = r37
            r26 = r10
            r10 = r28
            r28 = r12
            r12 = r17
            r13 = r26
            r14 = r16
            r15 = r22
            r16 = r25
            r17 = r23
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            if (r27 == 0) goto L_0x0355
            r7 = r41
            int r0 = r7.mResolvedDimensionRatioSide
            r1 = 1
            if (r0 != r1) goto L_0x0347
            float r5 = r7.mResolvedDimensionRatio
            r6 = 6
            r0 = r42
            r1 = r29
            r2 = r28
            r3 = r24
            r4 = r21
        L_0x0343:
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x0357
        L_0x0347:
            float r5 = r7.mResolvedDimensionRatio
            r6 = 6
            r0 = r42
            r1 = r24
            r2 = r21
            r3 = r29
            r4 = r28
            goto L_0x0343
        L_0x0355:
            r7 = r41
        L_0x0357:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x037f
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            r3 = r42
            r3.addCenterPoint(r7, r0, r1, r2)
        L_0x037f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.addToSolver(android.support.constraint.solver.LinearSystem):void");
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void analyze(int i) {
        Optimizer.analyze(i, this);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        connect(type, constraintWidget, type2, i, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0254, code lost:
        if (r3.isConnected() != false) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x021f, code lost:
        if (r3.isConnected() != false) goto L_0x0221;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(android.support.constraint.solver.widgets.ConstraintAnchor.Type r16, android.support.constraint.solver.widgets.ConstraintWidget r17, android.support.constraint.solver.widgets.ConstraintAnchor.Type r18, int r19, android.support.constraint.solver.widgets.ConstraintAnchor.Strength r20, int r21) {
        /*
            r15 = this;
            r7 = r15
            r0 = r16
            r8 = r17
            r9 = r18
            r10 = r21
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            r11 = 0
            if (r0 != r1) goto L_0x0101
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            if (r9 != r0) goto L_0x00b2
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r7.getAnchor(r1)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r9 = r7.getAnchor(r2)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r7.getAnchor(r2)
            r13 = 1
            if (r0 == 0) goto L_0x0033
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L_0x003c
        L_0x0033:
            if (r1 == 0) goto L_0x003e
            boolean r0 = r1.isConnected()
            if (r0 != 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r14 = 0
            goto L_0x0053
        L_0x003e:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            r4 = 0
            r0 = r7
            r2 = r8
            r5 = r20
            r6 = r10
            r0.connect(r1, r2, r3, r4, r5, r6)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            r0.connect(r1, r2, r3, r4, r5, r6)
            r14 = 1
        L_0x0053:
            if (r9 == 0) goto L_0x005b
            boolean r0 = r9.isConnected()
            if (r0 != 0) goto L_0x0064
        L_0x005b:
            if (r12 == 0) goto L_0x0066
            boolean r0 = r12.isConnected()
            if (r0 != 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r13 = 0
            goto L_0x007a
        L_0x0066:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            r4 = 0
            r0 = r7
            r2 = r8
            r5 = r20
            r6 = r10
            r0.connect(r1, r2, r3, r4, r5, r6)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            r0.connect(r1, r2, r3, r4, r5, r6)
        L_0x007a:
            if (r14 == 0) goto L_0x008e
            if (r13 == 0) goto L_0x008e
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r8.getAnchor(r1)
            r0.connect(r1, r11, r10)
            return
        L_0x008e:
            if (r14 == 0) goto L_0x00a0
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r8.getAnchor(r1)
            r0.connect(r1, r11, r10)
            return
        L_0x00a0:
            if (r13 == 0) goto L_0x00b1
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r8.getAnchor(r1)
            r0.connect(r1, r11, r10)
        L_0x00b1:
            return
        L_0x00b2:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r9 == r0) goto L_0x00e2
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r9 != r0) goto L_0x00bb
            goto L_0x00e2
        L_0x00bb:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r9 == r0) goto L_0x00c3
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r9 != r0) goto L_0x0268
        L_0x00c3:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            r4 = 0
            r0 = r7
            r2 = r8
            r3 = r9
            r5 = r20
            r6 = r10
            r0.connect(r1, r2, r3, r4, r5, r6)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            r0.connect(r1, r2, r3, r4, r5, r6)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r17.getAnchor(r18)
            r0.connect(r1, r11, r10)
            return
        L_0x00e2:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            r4 = 0
            r0 = r7
            r2 = r8
            r3 = r9
            r5 = r20
            r6 = r10
            r0.connect(r1, r2, r3, r4, r5, r6)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            r0.connect(r1, r2, r3, r4, r5, r6)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r17.getAnchor(r18)
            r0.connect(r1, r11, r10)
            return
        L_0x0101:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            if (r0 != r1) goto L_0x012d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r9 == r1) goto L_0x010d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r9 != r1) goto L_0x012d
        L_0x010d:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r17.getAnchor(r18)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r2 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r7.getAnchor(r2)
            r0.connect(r1, r11, r10)
            r2.connect(r1, r11, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            r0.connect(r1, r11, r10)
            return
        L_0x012d:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r0 != r1) goto L_0x0159
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r9 == r1) goto L_0x0139
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r9 != r1) goto L_0x0159
        L_0x0139:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r17.getAnchor(r18)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r7.getAnchor(r1)
            r1.connect(r0, r11, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r7.getAnchor(r1)
            r1.connect(r0, r11, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r7.getAnchor(r1)
            r1.connect(r0, r11, r10)
            return
        L_0x0159:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            if (r0 != r1) goto L_0x018d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            if (r9 != r1) goto L_0x018d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r8.getAnchor(r1)
            r0.connect(r1, r11, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r8.getAnchor(r1)
            r0.connect(r1, r11, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r17.getAnchor(r18)
            r0.connect(r1, r11, r10)
            return
        L_0x018d:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r0 != r1) goto L_0x01c1
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r9 != r1) goto L_0x01c1
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r8.getAnchor(r1)
            r0.connect(r1, r11, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r1 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r8.getAnchor(r1)
            r0.connect(r1, r11, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r17.getAnchor(r18)
            r0.connect(r1, r11, r10)
            return
        L_0x01c1:
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r15.getAnchor(r16)
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r17.getAnchor(r18)
            boolean r3 = r1.isValidConnection(r2)
            if (r3 == 0) goto L_0x0268
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE
            if (r0 != r3) goto L_0x01ed
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r0 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r7.getAnchor(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            if (r0 == 0) goto L_0x01e4
            r0.reset()
        L_0x01e4:
            if (r3 == 0) goto L_0x01e9
            r3.reset()
        L_0x01e9:
            r0 = r20
            goto L_0x025a
        L_0x01ed:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            if (r0 == r3) goto L_0x0228
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r0 != r3) goto L_0x01f6
            goto L_0x0228
        L_0x01f6:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r0 == r3) goto L_0x01fe
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r0 != r3) goto L_0x0257
        L_0x01fe:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.getTarget()
            if (r4 == r2) goto L_0x020d
            r3.reset()
        L_0x020d:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.getAnchor(r16)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.getOpposite()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_X
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            boolean r4 = r3.isConnected()
            if (r4 == 0) goto L_0x0257
        L_0x0221:
            r0.reset()
            r3.reset()
            goto L_0x0257
        L_0x0228:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            if (r3 == 0) goto L_0x0233
            r3.reset()
        L_0x0233:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r3.getTarget()
            if (r4 == r2) goto L_0x0242
            r3.reset()
        L_0x0242:
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r15.getAnchor(r16)
            android.support.constraint.solver.widgets.ConstraintAnchor r0 = r0.getOpposite()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r7.getAnchor(r3)
            boolean r4 = r3.isConnected()
            if (r4 == 0) goto L_0x0257
            goto L_0x0221
        L_0x0257:
            r11 = r19
            goto L_0x01e9
        L_0x025a:
            r1.connect(r2, r11, r0, r10)
            android.support.constraint.solver.widgets.ConstraintWidget r0 = r2.getOwner()
            android.support.constraint.solver.widgets.ConstraintWidget r1 = r1.getOwner()
            r0.connectedTo(r1)
        L_0x0268:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.connect(android.support.constraint.solver.widgets.ConstraintAnchor$Type, android.support.constraint.solver.widgets.ConstraintWidget, android.support.constraint.solver.widgets.ConstraintAnchor$Type, int, android.support.constraint.solver.widgets.ConstraintAnchor$Strength, int):void");
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, ConstraintAnchor.Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f;
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void forceUpdateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = (this.mY + this.mHeight) - i2;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (type) {
            case LEFT:
                return this.mLeft;
            case TOP:
                return this.mTop;
            case RIGHT:
                return this.mRight;
            case BOTTOM:
                return this.mBottom;
            case BASELINE:
                return this.mBaseline;
            case CENTER:
                return this.mCenter;
            case CENTER_X:
                return this.mCenterX;
            case CENTER_Y:
                return this.mCenterY;
            case NONE:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawX() {
        return this.mDrawX;
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i2);
        } else if (this.mMatchConstraintMinHeight > 0) {
            i = this.mMatchConstraintMinHeight;
            this.mHeight = i;
        } else {
            i = 0;
        }
        return (this.mMatchConstraintMaxHeight <= 0 || this.mMatchConstraintMaxHeight >= i) ? i : this.mMatchConstraintMaxHeight;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i2);
        } else if (this.mMatchConstraintMinWidth > 0) {
            i = this.mMatchConstraintMinWidth;
            this.mWidth = i;
        } else {
            i = 0;
        }
        return (this.mMatchConstraintMaxWidth <= 0 || this.mMatchConstraintMaxWidth >= i) ? i : this.mMatchConstraintMaxWidth;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget constraintWidget = this;
        while (constraintWidget.getParent() != null) {
            constraintWidget = constraintWidget.getParent();
        }
        if (constraintWidget instanceof WidgetContainer) {
            return (WidgetContainer) constraintWidget;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public boolean isFullyResolved() {
        return this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRootContainer() {
        if (this instanceof ConstraintWidgetContainer) {
            return this.mParent == null || !(this.mParent instanceof ConstraintWidgetContainer);
        }
        return false;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        this.mHorizontalBiasPercent = DEFAULT_BIAS;
        this.mVerticalBiasPercent = DEFAULT_BIAS;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        this.mWeight[0] = -1.0f;
        this.mWeight[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMaxDimension[0] = Integer.MAX_VALUE;
        this.mMaxDimension[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMatchConstraintMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        if (this.mResolutionWidth != null) {
            this.mResolutionWidth.reset();
        }
        if (this.mResolutionHeight != null) {
            this.mResolutionHeight.reset();
        }
        this.mBelongingGroup = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
    }

    public void resetAllConstraints() {
        DimensionBehaviour dimensionBehaviour;
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (!(this instanceof ConstraintWidgetContainer)) {
            if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getWidth() == getWrapWidth()) {
                    dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                } else if (getWidth() > getMinWidth()) {
                    dimensionBehaviour = DimensionBehaviour.FIXED;
                }
                setHorizontalDimensionBehaviour(dimensionBehaviour);
            }
            if (getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
                return;
            }
            if (getHeight() == getWrapHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getHeight() > getMinHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else {
                if (constraintAnchor == anchor6) {
                    if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                        anchor.reset();
                        anchor2.reset();
                    }
                    this.mHorizontalBiasPercent = 0.5f;
                } else if (constraintAnchor == anchor7) {
                    if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                        anchor3.reset();
                        anchor4.reset();
                    }
                } else if (constraintAnchor == anchor || constraintAnchor == anchor2 ? !(!anchor.isConnected() || anchor.getTarget() != anchor2.getTarget()) : (constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor5.reset();
                }
                constraintAnchor.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintAnchor constraintAnchor = this.mAnchors.get(i2);
                if (i == constraintAnchor.getConnectionCreator()) {
                    if (constraintAnchor.isVerticalAnchor()) {
                        setVerticalBiasPercent(DEFAULT_BIAS);
                    } else {
                        setHorizontalBiasPercent(DEFAULT_BIAS);
                    }
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void resolve() {
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mHeight = i2;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDimensionRatio(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = 0
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.mDimensionRatio = r9
            r8.mDimensionRatioSide = r1
        L_0x008d:
            return
        L_0x008e:
            r8.mDimensionRatio = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.setDimensionRatio(java.lang.String):void");
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setDrawOrigin(int i, int i2) {
        this.mDrawX = i - this.mOffsetX;
        this.mDrawY = i2 - this.mOffsetY;
        this.mX = this.mDrawX;
        this.mY = this.mDrawY;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawX(int i) {
        this.mDrawX = i - this.mOffsetX;
        this.mX = this.mDrawX;
    }

    public void setDrawY(int i) {
        this.mDrawY = i - this.mOffsetY;
        this.mY = this.mDrawY;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
        this.mOptimizerMeasured = true;
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i5 < this.mWidth) {
            i5 = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i6 < this.mHeight) {
            i6 = this.mHeight;
        }
        this.mWidth = i5;
        this.mHeight = i6;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
        this.mOptimizerMeasured = true;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        ConstraintAnchor constraintAnchor;
        switch (type) {
            case LEFT:
                constraintAnchor = this.mLeft;
                break;
            case TOP:
                constraintAnchor = this.mTop;
                break;
            case RIGHT:
                constraintAnchor = this.mRight;
                break;
            case BOTTOM:
                this.mBottom.mGoneMargin = i;
                return;
            default:
                return;
        }
        constraintAnchor.mGoneMargin = i;
    }

    public void setHeight(int i) {
        this.mHeight = i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        this.mWidth = i2 - i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f;
        if (f < 1.0f && this.mMatchConstraintDefaultWidth == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        this.mHeight = i2 - i;
        if (this.mHeight < this.mMinHeight) {
            this.mHeight = this.mMinHeight;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f;
        if (f < 1.0f && this.mMatchConstraintDefaultHeight == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        if (this.mWidth < this.mMinWidth) {
            this.mWidth = this.mMinWidth;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1 && z && z2) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.mType != null) {
            str = "type: " + this.mType + s.a.f1696a;
        } else {
            str = "";
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + s.a.f1696a;
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    public void updateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = (this.mY + this.mHeight) - i2;
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }
}
