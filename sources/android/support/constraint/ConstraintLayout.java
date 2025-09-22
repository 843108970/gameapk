package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.Guideline;
import android.support.v4.internal.view.SupportMenu;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    static final boolean ALLOWS_EMBEDDED = false;
    private static final boolean CACHE_MEASURED_DIMENSION = false;
    private static final boolean DEBUG = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-1.1.3";
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    private boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int mMaxWidth = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOptimizationLevel = 7;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>(100);

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String dimensionRatio = null;
        int dimensionRatioSide = 1;
        float dimensionRatioValue = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean helped = false;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        boolean horizontalDimensionFixed = true;
        public float horizontalWeight = -1.0f;
        boolean isGuideline = false;
        boolean isHelper = false;
        boolean isInPlaceholder = false;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;
        boolean needsBaseline = false;
        public int orientation = -1;
        int resolveGoneLeftMargin = -1;
        int resolveGoneRightMargin = -1;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias = 0.5f;
        int resolvedLeftToLeft = -1;
        int resolvedLeftToRight = -1;
        int resolvedRightToLeft = -1;
        int resolvedRightToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        boolean verticalDimensionFixed = true;
        public float verticalWeight = -1.0f;
        ConstraintWidget widget = new ConstraintWidget();

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }

            private Table() {
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0217, code lost:
            android.util.Log.e(r4, r6);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LayoutParams(android.content.Context r10, android.util.AttributeSet r11) {
            /*
                r9 = this;
                r9.<init>(r10, r11)
                r0 = -1
                r9.guideBegin = r0
                r9.guideEnd = r0
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r9.guidePercent = r1
                r9.leftToLeft = r0
                r9.leftToRight = r0
                r9.rightToLeft = r0
                r9.rightToRight = r0
                r9.topToTop = r0
                r9.topToBottom = r0
                r9.bottomToTop = r0
                r9.bottomToBottom = r0
                r9.baselineToBaseline = r0
                r9.circleConstraint = r0
                r2 = 0
                r9.circleRadius = r2
                r3 = 0
                r9.circleAngle = r3
                r9.startToEnd = r0
                r9.startToStart = r0
                r9.endToStart = r0
                r9.endToEnd = r0
                r9.goneLeftMargin = r0
                r9.goneTopMargin = r0
                r9.goneRightMargin = r0
                r9.goneBottomMargin = r0
                r9.goneStartMargin = r0
                r9.goneEndMargin = r0
                r4 = 1056964608(0x3f000000, float:0.5)
                r9.horizontalBias = r4
                r9.verticalBias = r4
                r5 = 0
                r9.dimensionRatio = r5
                r9.dimensionRatioValue = r3
                r5 = 1
                r9.dimensionRatioSide = r5
                r9.horizontalWeight = r1
                r9.verticalWeight = r1
                r9.horizontalChainStyle = r2
                r9.verticalChainStyle = r2
                r9.matchConstraintDefaultWidth = r2
                r9.matchConstraintDefaultHeight = r2
                r9.matchConstraintMinWidth = r2
                r9.matchConstraintMinHeight = r2
                r9.matchConstraintMaxWidth = r2
                r9.matchConstraintMaxHeight = r2
                r1 = 1065353216(0x3f800000, float:1.0)
                r9.matchConstraintPercentWidth = r1
                r9.matchConstraintPercentHeight = r1
                r9.editorAbsoluteX = r0
                r9.editorAbsoluteY = r0
                r9.orientation = r0
                r9.constrainedWidth = r2
                r9.constrainedHeight = r2
                r9.horizontalDimensionFixed = r5
                r9.verticalDimensionFixed = r5
                r9.needsBaseline = r2
                r9.isGuideline = r2
                r9.isHelper = r2
                r9.isInPlaceholder = r2
                r9.resolvedLeftToLeft = r0
                r9.resolvedLeftToRight = r0
                r9.resolvedRightToLeft = r0
                r9.resolvedRightToRight = r0
                r9.resolveGoneLeftMargin = r0
                r9.resolveGoneRightMargin = r0
                r9.resolvedHorizontalBias = r4
                android.support.constraint.solver.widgets.ConstraintWidget r1 = new android.support.constraint.solver.widgets.ConstraintWidget
                r1.<init>()
                r9.widget = r1
                r9.helped = r2
                int[] r1 = android.support.constraint.R.styleable.ConstraintLayout_Layout
                android.content.res.TypedArray r10 = r10.obtainStyledAttributes(r11, r1)
                int r11 = r10.getIndexCount()
                r1 = 0
            L_0x009a:
                if (r1 >= r11) goto L_0x03de
                int r4 = r10.getIndex(r1)
                android.util.SparseIntArray r6 = android.support.constraint.ConstraintLayout.LayoutParams.Table.map
                int r6 = r6.get(r4)
                r7 = -2
                switch(r6) {
                    case 0: goto L_0x03da;
                    case 1: goto L_0x03d2;
                    case 2: goto L_0x03bf;
                    case 3: goto L_0x03b6;
                    case 4: goto L_0x039d;
                    case 5: goto L_0x0394;
                    case 6: goto L_0x038b;
                    case 7: goto L_0x0382;
                    case 8: goto L_0x036f;
                    case 9: goto L_0x035c;
                    case 10: goto L_0x0348;
                    case 11: goto L_0x0334;
                    case 12: goto L_0x0320;
                    case 13: goto L_0x030c;
                    case 14: goto L_0x02f8;
                    case 15: goto L_0x02e4;
                    case 16: goto L_0x02d0;
                    case 17: goto L_0x02bc;
                    case 18: goto L_0x02a8;
                    case 19: goto L_0x0294;
                    case 20: goto L_0x0280;
                    case 21: goto L_0x0276;
                    case 22: goto L_0x026c;
                    case 23: goto L_0x0262;
                    case 24: goto L_0x0258;
                    case 25: goto L_0x024e;
                    case 26: goto L_0x0244;
                    case 27: goto L_0x023a;
                    case 28: goto L_0x0230;
                    case 29: goto L_0x0226;
                    case 30: goto L_0x021c;
                    case 31: goto L_0x0209;
                    case 32: goto L_0x01fa;
                    case 33: goto L_0x01e4;
                    case 34: goto L_0x01ce;
                    case 35: goto L_0x01c0;
                    case 36: goto L_0x01aa;
                    case 37: goto L_0x0194;
                    case 38: goto L_0x0186;
                    default: goto L_0x00aa;
                }
            L_0x00aa:
                switch(r6) {
                    case 44: goto L_0x00e7;
                    case 45: goto L_0x00dd;
                    case 46: goto L_0x00d3;
                    case 47: goto L_0x00cb;
                    case 48: goto L_0x00c3;
                    case 49: goto L_0x00b9;
                    case 50: goto L_0x00af;
                    default: goto L_0x00ad;
                }
            L_0x00ad:
                goto L_0x03da
            L_0x00af:
                int r6 = r9.editorAbsoluteY
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.editorAbsoluteY = r4
                goto L_0x03da
            L_0x00b9:
                int r6 = r9.editorAbsoluteX
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.editorAbsoluteX = r4
                goto L_0x03da
            L_0x00c3:
                int r4 = r10.getInt(r4, r2)
                r9.verticalChainStyle = r4
                goto L_0x03da
            L_0x00cb:
                int r4 = r10.getInt(r4, r2)
                r9.horizontalChainStyle = r4
                goto L_0x03da
            L_0x00d3:
                float r6 = r9.verticalWeight
                float r4 = r10.getFloat(r4, r6)
                r9.verticalWeight = r4
                goto L_0x03da
            L_0x00dd:
                float r6 = r9.horizontalWeight
                float r4 = r10.getFloat(r4, r6)
                r9.horizontalWeight = r4
                goto L_0x03da
            L_0x00e7:
                java.lang.String r4 = r10.getString(r4)
                r9.dimensionRatio = r4
                r4 = 2143289344(0x7fc00000, float:NaN)
                r9.dimensionRatioValue = r4
                r9.dimensionRatioSide = r0
                java.lang.String r4 = r9.dimensionRatio
                if (r4 == 0) goto L_0x03da
                java.lang.String r4 = r9.dimensionRatio
                int r4 = r4.length()
                java.lang.String r6 = r9.dimensionRatio
                r7 = 44
                int r6 = r6.indexOf(r7)
                if (r6 <= 0) goto L_0x0129
                int r7 = r4 + -1
                if (r6 >= r7) goto L_0x0129
                java.lang.String r7 = r9.dimensionRatio
                java.lang.String r7 = r7.substring(r2, r6)
                java.lang.String r8 = "W"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x011c
                r9.dimensionRatioSide = r2
                goto L_0x0126
            L_0x011c:
                java.lang.String r8 = "H"
                boolean r7 = r7.equalsIgnoreCase(r8)
                if (r7 == 0) goto L_0x0126
                r9.dimensionRatioSide = r5
            L_0x0126:
                int r6 = r6 + 1
                goto L_0x012a
            L_0x0129:
                r6 = 0
            L_0x012a:
                java.lang.String r7 = r9.dimensionRatio
                r8 = 58
                int r7 = r7.indexOf(r8)
                if (r7 < 0) goto L_0x0175
                int r4 = r4 + -1
                if (r7 >= r4) goto L_0x0175
                java.lang.String r4 = r9.dimensionRatio
                java.lang.String r4 = r4.substring(r6, r7)
                java.lang.String r6 = r9.dimensionRatio
                int r7 = r7 + 1
                java.lang.String r6 = r6.substring(r7)
                int r7 = r4.length()
                if (r7 <= 0) goto L_0x03da
                int r7 = r6.length()
                if (r7 <= 0) goto L_0x03da
                float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x03da }
                float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ NumberFormatException -> 0x03da }
                int r7 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x03da
                int r7 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x03da
                int r7 = r9.dimensionRatioSide     // Catch:{ NumberFormatException -> 0x03da }
                if (r7 != r5) goto L_0x016f
                float r6 = r6 / r4
                float r4 = java.lang.Math.abs(r6)     // Catch:{ NumberFormatException -> 0x03da }
            L_0x016b:
                r9.dimensionRatioValue = r4     // Catch:{ NumberFormatException -> 0x03da }
                goto L_0x03da
            L_0x016f:
                float r4 = r4 / r6
                float r4 = java.lang.Math.abs(r4)     // Catch:{ NumberFormatException -> 0x03da }
                goto L_0x016b
            L_0x0175:
                java.lang.String r4 = r9.dimensionRatio
                java.lang.String r4 = r4.substring(r6)
                int r6 = r4.length()
                if (r6 <= 0) goto L_0x03da
                float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x03da }
                goto L_0x016b
            L_0x0186:
                float r6 = r9.matchConstraintPercentHeight
                float r4 = r10.getFloat(r4, r6)
                float r4 = java.lang.Math.max(r3, r4)
                r9.matchConstraintPercentHeight = r4
                goto L_0x03da
            L_0x0194:
                int r6 = r9.matchConstraintMaxHeight     // Catch:{ Exception -> 0x019e }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x019e }
                r9.matchConstraintMaxHeight = r6     // Catch:{ Exception -> 0x019e }
                goto L_0x03da
            L_0x019e:
                int r6 = r9.matchConstraintMaxHeight
                int r4 = r10.getInt(r4, r6)
                if (r4 != r7) goto L_0x03da
                r9.matchConstraintMaxHeight = r7
                goto L_0x03da
            L_0x01aa:
                int r6 = r9.matchConstraintMinHeight     // Catch:{ Exception -> 0x01b4 }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01b4 }
                r9.matchConstraintMinHeight = r6     // Catch:{ Exception -> 0x01b4 }
                goto L_0x03da
            L_0x01b4:
                int r6 = r9.matchConstraintMinHeight
                int r4 = r10.getInt(r4, r6)
                if (r4 != r7) goto L_0x03da
                r9.matchConstraintMinHeight = r7
                goto L_0x03da
            L_0x01c0:
                float r6 = r9.matchConstraintPercentWidth
                float r4 = r10.getFloat(r4, r6)
                float r4 = java.lang.Math.max(r3, r4)
                r9.matchConstraintPercentWidth = r4
                goto L_0x03da
            L_0x01ce:
                int r6 = r9.matchConstraintMaxWidth     // Catch:{ Exception -> 0x01d8 }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01d8 }
                r9.matchConstraintMaxWidth = r6     // Catch:{ Exception -> 0x01d8 }
                goto L_0x03da
            L_0x01d8:
                int r6 = r9.matchConstraintMaxWidth
                int r4 = r10.getInt(r4, r6)
                if (r4 != r7) goto L_0x03da
                r9.matchConstraintMaxWidth = r7
                goto L_0x03da
            L_0x01e4:
                int r6 = r9.matchConstraintMinWidth     // Catch:{ Exception -> 0x01ee }
                int r6 = r10.getDimensionPixelSize(r4, r6)     // Catch:{ Exception -> 0x01ee }
                r9.matchConstraintMinWidth = r6     // Catch:{ Exception -> 0x01ee }
                goto L_0x03da
            L_0x01ee:
                int r6 = r9.matchConstraintMinWidth
                int r4 = r10.getInt(r4, r6)
                if (r4 != r7) goto L_0x03da
                r9.matchConstraintMinWidth = r7
                goto L_0x03da
            L_0x01fa:
                int r4 = r10.getInt(r4, r2)
                r9.matchConstraintDefaultHeight = r4
                int r4 = r9.matchConstraintDefaultHeight
                if (r4 != r5) goto L_0x03da
                java.lang.String r4 = "ConstraintLayout"
                java.lang.String r6 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead."
                goto L_0x0217
            L_0x0209:
                int r4 = r10.getInt(r4, r2)
                r9.matchConstraintDefaultWidth = r4
                int r4 = r9.matchConstraintDefaultWidth
                if (r4 != r5) goto L_0x03da
                java.lang.String r4 = "ConstraintLayout"
                java.lang.String r6 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead."
            L_0x0217:
                android.util.Log.e(r4, r6)
                goto L_0x03da
            L_0x021c:
                float r6 = r9.verticalBias
                float r4 = r10.getFloat(r4, r6)
                r9.verticalBias = r4
                goto L_0x03da
            L_0x0226:
                float r6 = r9.horizontalBias
                float r4 = r10.getFloat(r4, r6)
                r9.horizontalBias = r4
                goto L_0x03da
            L_0x0230:
                boolean r6 = r9.constrainedHeight
                boolean r4 = r10.getBoolean(r4, r6)
                r9.constrainedHeight = r4
                goto L_0x03da
            L_0x023a:
                boolean r6 = r9.constrainedWidth
                boolean r4 = r10.getBoolean(r4, r6)
                r9.constrainedWidth = r4
                goto L_0x03da
            L_0x0244:
                int r6 = r9.goneEndMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneEndMargin = r4
                goto L_0x03da
            L_0x024e:
                int r6 = r9.goneStartMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneStartMargin = r4
                goto L_0x03da
            L_0x0258:
                int r6 = r9.goneBottomMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneBottomMargin = r4
                goto L_0x03da
            L_0x0262:
                int r6 = r9.goneRightMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneRightMargin = r4
                goto L_0x03da
            L_0x026c:
                int r6 = r9.goneTopMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneTopMargin = r4
                goto L_0x03da
            L_0x0276:
                int r6 = r9.goneLeftMargin
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.goneLeftMargin = r4
                goto L_0x03da
            L_0x0280:
                int r6 = r9.endToEnd
                int r6 = r10.getResourceId(r4, r6)
                r9.endToEnd = r6
                int r6 = r9.endToEnd
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.endToEnd = r4
                goto L_0x03da
            L_0x0294:
                int r6 = r9.endToStart
                int r6 = r10.getResourceId(r4, r6)
                r9.endToStart = r6
                int r6 = r9.endToStart
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.endToStart = r4
                goto L_0x03da
            L_0x02a8:
                int r6 = r9.startToStart
                int r6 = r10.getResourceId(r4, r6)
                r9.startToStart = r6
                int r6 = r9.startToStart
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.startToStart = r4
                goto L_0x03da
            L_0x02bc:
                int r6 = r9.startToEnd
                int r6 = r10.getResourceId(r4, r6)
                r9.startToEnd = r6
                int r6 = r9.startToEnd
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.startToEnd = r4
                goto L_0x03da
            L_0x02d0:
                int r6 = r9.baselineToBaseline
                int r6 = r10.getResourceId(r4, r6)
                r9.baselineToBaseline = r6
                int r6 = r9.baselineToBaseline
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.baselineToBaseline = r4
                goto L_0x03da
            L_0x02e4:
                int r6 = r9.bottomToBottom
                int r6 = r10.getResourceId(r4, r6)
                r9.bottomToBottom = r6
                int r6 = r9.bottomToBottom
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.bottomToBottom = r4
                goto L_0x03da
            L_0x02f8:
                int r6 = r9.bottomToTop
                int r6 = r10.getResourceId(r4, r6)
                r9.bottomToTop = r6
                int r6 = r9.bottomToTop
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.bottomToTop = r4
                goto L_0x03da
            L_0x030c:
                int r6 = r9.topToBottom
                int r6 = r10.getResourceId(r4, r6)
                r9.topToBottom = r6
                int r6 = r9.topToBottom
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.topToBottom = r4
                goto L_0x03da
            L_0x0320:
                int r6 = r9.topToTop
                int r6 = r10.getResourceId(r4, r6)
                r9.topToTop = r6
                int r6 = r9.topToTop
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.topToTop = r4
                goto L_0x03da
            L_0x0334:
                int r6 = r9.rightToRight
                int r6 = r10.getResourceId(r4, r6)
                r9.rightToRight = r6
                int r6 = r9.rightToRight
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.rightToRight = r4
                goto L_0x03da
            L_0x0348:
                int r6 = r9.rightToLeft
                int r6 = r10.getResourceId(r4, r6)
                r9.rightToLeft = r6
                int r6 = r9.rightToLeft
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.rightToLeft = r4
                goto L_0x03da
            L_0x035c:
                int r6 = r9.leftToRight
                int r6 = r10.getResourceId(r4, r6)
                r9.leftToRight = r6
                int r6 = r9.leftToRight
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.leftToRight = r4
                goto L_0x03da
            L_0x036f:
                int r6 = r9.leftToLeft
                int r6 = r10.getResourceId(r4, r6)
                r9.leftToLeft = r6
                int r6 = r9.leftToLeft
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.leftToLeft = r4
                goto L_0x03da
            L_0x0382:
                float r6 = r9.guidePercent
                float r4 = r10.getFloat(r4, r6)
                r9.guidePercent = r4
                goto L_0x03da
            L_0x038b:
                int r6 = r9.guideEnd
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.guideEnd = r4
                goto L_0x03da
            L_0x0394:
                int r6 = r9.guideBegin
                int r4 = r10.getDimensionPixelOffset(r4, r6)
                r9.guideBegin = r4
                goto L_0x03da
            L_0x039d:
                float r6 = r9.circleAngle
                float r4 = r10.getFloat(r4, r6)
                r6 = 1135869952(0x43b40000, float:360.0)
                float r4 = r4 % r6
                r9.circleAngle = r4
                float r4 = r9.circleAngle
                int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r4 >= 0) goto L_0x03da
                float r4 = r9.circleAngle
                float r4 = r6 - r4
                float r4 = r4 % r6
                r9.circleAngle = r4
                goto L_0x03da
            L_0x03b6:
                int r6 = r9.circleRadius
                int r4 = r10.getDimensionPixelSize(r4, r6)
                r9.circleRadius = r4
                goto L_0x03da
            L_0x03bf:
                int r6 = r9.circleConstraint
                int r6 = r10.getResourceId(r4, r6)
                r9.circleConstraint = r6
                int r6 = r9.circleConstraint
                if (r6 != r0) goto L_0x03da
                int r4 = r10.getInt(r4, r0)
                r9.circleConstraint = r4
                goto L_0x03da
            L_0x03d2:
                int r6 = r9.orientation
                int r4 = r10.getInt(r4, r6)
                r9.orientation = r4
            L_0x03da:
                int r1 = r1 + 1
                goto L_0x009a
            L_0x03de:
                r10.recycle()
                r9.validate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.LayoutParams.<init>(android.content.Context, android.util.AttributeSet):void");
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.widget = layoutParams.widget;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void reset() {
            if (this.widget != null) {
                this.widget.reset();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f6, code lost:
            if (r1 > 0) goto L_0x00f8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0107, code lost:
            if (r1 > 0) goto L_0x00f8;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x010e  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x011b  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r6) {
            /*
                r5 = this;
                int r0 = r5.leftMargin
                int r1 = r5.rightMargin
                super.resolveLayoutDirection(r6)
                r6 = -1
                r5.resolvedRightToLeft = r6
                r5.resolvedRightToRight = r6
                r5.resolvedLeftToLeft = r6
                r5.resolvedLeftToRight = r6
                r5.resolveGoneLeftMargin = r6
                r5.resolveGoneRightMargin = r6
                int r2 = r5.goneLeftMargin
                r5.resolveGoneLeftMargin = r2
                int r2 = r5.goneRightMargin
                r5.resolveGoneRightMargin = r2
                float r2 = r5.horizontalBias
                r5.resolvedHorizontalBias = r2
                int r2 = r5.guideBegin
                r5.resolvedGuideBegin = r2
                int r2 = r5.guideEnd
                r5.resolvedGuideEnd = r2
                float r2 = r5.guidePercent
                r5.resolvedGuidePercent = r2
                int r2 = r5.getLayoutDirection()
                r3 = 0
                r4 = 1
                if (r4 != r2) goto L_0x0036
                r2 = 1
                goto L_0x0037
            L_0x0036:
                r2 = 0
            L_0x0037:
                if (r2 == 0) goto L_0x00aa
                int r2 = r5.startToEnd
                if (r2 == r6) goto L_0x0043
                int r2 = r5.startToEnd
                r5.resolvedRightToLeft = r2
            L_0x0041:
                r3 = 1
                goto L_0x004c
            L_0x0043:
                int r2 = r5.startToStart
                if (r2 == r6) goto L_0x004c
                int r2 = r5.startToStart
                r5.resolvedRightToRight = r2
                goto L_0x0041
            L_0x004c:
                int r2 = r5.endToStart
                if (r2 == r6) goto L_0x0055
                int r2 = r5.endToStart
                r5.resolvedLeftToRight = r2
                r3 = 1
            L_0x0055:
                int r2 = r5.endToEnd
                if (r2 == r6) goto L_0x005e
                int r2 = r5.endToEnd
                r5.resolvedLeftToLeft = r2
                r3 = 1
            L_0x005e:
                int r2 = r5.goneStartMargin
                if (r2 == r6) goto L_0x0066
                int r2 = r5.goneStartMargin
                r5.resolveGoneRightMargin = r2
            L_0x0066:
                int r2 = r5.goneEndMargin
                if (r2 == r6) goto L_0x006e
                int r2 = r5.goneEndMargin
                r5.resolveGoneLeftMargin = r2
            L_0x006e:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x0078
                float r3 = r5.horizontalBias
                float r3 = r2 - r3
                r5.resolvedHorizontalBias = r3
            L_0x0078:
                boolean r3 = r5.isGuideline
                if (r3 == 0) goto L_0x00da
                int r3 = r5.orientation
                if (r3 != r4) goto L_0x00da
                float r3 = r5.guidePercent
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 == 0) goto L_0x0092
                float r3 = r5.guidePercent
                float r2 = r2 - r3
                r5.resolvedGuidePercent = r2
                r5.resolvedGuideBegin = r6
                r5.resolvedGuideEnd = r6
                goto L_0x00da
            L_0x0092:
                int r2 = r5.guideBegin
                if (r2 == r6) goto L_0x009f
                int r2 = r5.guideBegin
                r5.resolvedGuideEnd = r2
                r5.resolvedGuideBegin = r6
            L_0x009c:
                r5.resolvedGuidePercent = r4
                goto L_0x00da
            L_0x009f:
                int r2 = r5.guideEnd
                if (r2 == r6) goto L_0x00da
                int r2 = r5.guideEnd
                r5.resolvedGuideBegin = r2
                r5.resolvedGuideEnd = r6
                goto L_0x009c
            L_0x00aa:
                int r2 = r5.startToEnd
                if (r2 == r6) goto L_0x00b2
                int r2 = r5.startToEnd
                r5.resolvedLeftToRight = r2
            L_0x00b2:
                int r2 = r5.startToStart
                if (r2 == r6) goto L_0x00ba
                int r2 = r5.startToStart
                r5.resolvedLeftToLeft = r2
            L_0x00ba:
                int r2 = r5.endToStart
                if (r2 == r6) goto L_0x00c2
                int r2 = r5.endToStart
                r5.resolvedRightToLeft = r2
            L_0x00c2:
                int r2 = r5.endToEnd
                if (r2 == r6) goto L_0x00ca
                int r2 = r5.endToEnd
                r5.resolvedRightToRight = r2
            L_0x00ca:
                int r2 = r5.goneStartMargin
                if (r2 == r6) goto L_0x00d2
                int r2 = r5.goneStartMargin
                r5.resolveGoneLeftMargin = r2
            L_0x00d2:
                int r2 = r5.goneEndMargin
                if (r2 == r6) goto L_0x00da
                int r2 = r5.goneEndMargin
                r5.resolveGoneRightMargin = r2
            L_0x00da:
                int r2 = r5.endToStart
                if (r2 != r6) goto L_0x012b
                int r2 = r5.endToEnd
                if (r2 != r6) goto L_0x012b
                int r2 = r5.startToStart
                if (r2 != r6) goto L_0x012b
                int r2 = r5.startToEnd
                if (r2 != r6) goto L_0x012b
                int r2 = r5.rightToLeft
                if (r2 == r6) goto L_0x00fb
                int r2 = r5.rightToLeft
                r5.resolvedRightToLeft = r2
                int r2 = r5.rightMargin
                if (r2 > 0) goto L_0x010a
                if (r1 <= 0) goto L_0x010a
            L_0x00f8:
                r5.rightMargin = r1
                goto L_0x010a
            L_0x00fb:
                int r2 = r5.rightToRight
                if (r2 == r6) goto L_0x010a
                int r2 = r5.rightToRight
                r5.resolvedRightToRight = r2
                int r2 = r5.rightMargin
                if (r2 > 0) goto L_0x010a
                if (r1 <= 0) goto L_0x010a
                goto L_0x00f8
            L_0x010a:
                int r1 = r5.leftToLeft
                if (r1 == r6) goto L_0x011b
                int r6 = r5.leftToLeft
                r5.resolvedLeftToLeft = r6
                int r6 = r5.leftMargin
                if (r6 > 0) goto L_0x012b
                if (r0 <= 0) goto L_0x012b
                r5.leftMargin = r0
                return
            L_0x011b:
                int r1 = r5.leftToRight
                if (r1 == r6) goto L_0x012b
                int r6 = r5.leftToRight
                r5.resolvedLeftToRight = r6
                int r6 = r5.leftMargin
                if (r6 > 0) goto L_0x012b
                if (r0 <= 0) goto L_0x012b
                r5.leftMargin = r0
            L_0x012b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                this.matchConstraintDefaultWidth = 1;
            }
            if (this.height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                this.matchConstraintDefaultHeight = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.horizontalDimensionFixed = false;
                if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.verticalDimensionFixed = false;
                if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    private void init(AttributeSet attributeSet) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.mConstraintSet = new ConstraintSet();
                        this.mConstraintSet.load(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void internalMeasureChildren(int i, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int i3;
        int i4;
        ConstraintLayout constraintLayout = this;
        int i5 = i;
        int i6 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = constraintLayout.getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if (!layoutParams.isGuideline && !layoutParams.isHelper) {
                    constraintWidget.setVisibility(childAt.getVisibility());
                    int i8 = layoutParams.width;
                    int i9 = layoutParams.height;
                    if (layoutParams.horizontalDimensionFixed || layoutParams.verticalDimensionFixed || (!layoutParams.horizontalDimensionFixed && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1 || (!layoutParams.verticalDimensionFixed && (layoutParams.matchConstraintDefaultHeight == 1 || layoutParams.height == -1))) {
                        if (i8 == 0) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -2);
                            z2 = true;
                        } else if (i8 == -1) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = i8 == -2;
                            i3 = getChildMeasureSpec(i5, paddingLeft, i8);
                        }
                        if (i9 == 0) {
                            i4 = getChildMeasureSpec(i6, paddingTop, -2);
                            z = true;
                        } else if (i9 == -1) {
                            i4 = getChildMeasureSpec(i6, paddingTop, -1);
                            z = false;
                        } else {
                            z = i9 == -2;
                            i4 = getChildMeasureSpec(i6, paddingTop, i9);
                        }
                        childAt.measure(i3, i4);
                        if (constraintLayout.mMetrics != null) {
                            constraintLayout.mMetrics.measures++;
                        }
                        constraintWidget.setWidthWrapContent(i8 == -2);
                        constraintWidget.setHeightWrapContent(i9 == -2);
                        i8 = childAt.getMeasuredWidth();
                        i9 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    constraintWidget.setWidth(i8);
                    constraintWidget.setHeight(i9);
                    if (z2) {
                        constraintWidget.setWrapWidth(i8);
                    }
                    if (z) {
                        constraintWidget.setWrapHeight(i9);
                    }
                    if (layoutParams.needsBaseline && (baseline = childAt.getBaseline()) != -1) {
                        constraintWidget.setBaselineDistance(baseline);
                    }
                }
            }
            i7++;
            constraintLayout = this;
            i5 = i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void internalMeasureDimensions(int r27, int r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            int r3 = r26.getPaddingTop()
            int r4 = r26.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r26.getPaddingLeft()
            int r5 = r26.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r26.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 1
            r10 = 8
            r12 = -2
            if (r7 >= r5) goto L_0x00f6
            android.view.View r14 = r0.getChildAt(r7)
            int r15 = r14.getVisibility()
            if (r15 == r10) goto L_0x00e4
            android.view.ViewGroup$LayoutParams r10 = r14.getLayoutParams()
            android.support.constraint.ConstraintLayout$LayoutParams r10 = (android.support.constraint.ConstraintLayout.LayoutParams) r10
            android.support.constraint.solver.widgets.ConstraintWidget r15 = r10.widget
            boolean r6 = r10.isGuideline
            if (r6 != 0) goto L_0x00e4
            boolean r6 = r10.isHelper
            if (r6 != 0) goto L_0x00e4
            int r6 = r14.getVisibility()
            r15.setVisibility(r6)
            int r6 = r10.width
            int r13 = r10.height
            if (r6 == 0) goto L_0x00cf
            if (r13 != 0) goto L_0x004f
            goto L_0x00cf
        L_0x004f:
            if (r6 != r12) goto L_0x0054
            r16 = 1
            goto L_0x0056
        L_0x0054:
            r16 = 0
        L_0x0056:
            int r11 = getChildMeasureSpec(r1, r4, r6)
            if (r13 != r12) goto L_0x005f
            r17 = 1
            goto L_0x0061
        L_0x005f:
            r17 = 0
        L_0x0061:
            int r12 = getChildMeasureSpec(r2, r3, r13)
            r14.measure(r11, r12)
            android.support.constraint.solver.Metrics r11 = r0.mMetrics
            if (r11 == 0) goto L_0x007b
            android.support.constraint.solver.Metrics r11 = r0.mMetrics
            r19 = r3
            long r2 = r11.measures
            r20 = r4
            r21 = r5
            long r4 = r2 + r8
            r11.measures = r4
            goto L_0x0081
        L_0x007b:
            r19 = r3
            r20 = r4
            r21 = r5
        L_0x0081:
            r2 = -2
            if (r6 != r2) goto L_0x0086
            r3 = 1
            goto L_0x0087
        L_0x0086:
            r3 = 0
        L_0x0087:
            r15.setWidthWrapContent(r3)
            if (r13 != r2) goto L_0x008e
            r2 = 1
            goto L_0x008f
        L_0x008e:
            r2 = 0
        L_0x008f:
            r15.setHeightWrapContent(r2)
            int r2 = r14.getMeasuredWidth()
            int r3 = r14.getMeasuredHeight()
            r15.setWidth(r2)
            r15.setHeight(r3)
            if (r16 == 0) goto L_0x00a5
            r15.setWrapWidth(r2)
        L_0x00a5:
            if (r17 == 0) goto L_0x00aa
            r15.setWrapHeight(r3)
        L_0x00aa:
            boolean r4 = r10.needsBaseline
            if (r4 == 0) goto L_0x00b8
            int r4 = r14.getBaseline()
            r5 = -1
            if (r4 == r5) goto L_0x00b8
            r15.setBaselineDistance(r4)
        L_0x00b8:
            boolean r4 = r10.horizontalDimensionFixed
            if (r4 == 0) goto L_0x00ea
            boolean r4 = r10.verticalDimensionFixed
            if (r4 == 0) goto L_0x00ea
            android.support.constraint.solver.widgets.ResolutionDimension r4 = r15.getResolutionWidth()
            r4.resolve(r2)
            android.support.constraint.solver.widgets.ResolutionDimension r2 = r15.getResolutionHeight()
            r2.resolve(r3)
            goto L_0x00ea
        L_0x00cf:
            r19 = r3
            r20 = r4
            r21 = r5
            android.support.constraint.solver.widgets.ResolutionDimension r2 = r15.getResolutionWidth()
            r2.invalidate()
            android.support.constraint.solver.widgets.ResolutionDimension r2 = r15.getResolutionHeight()
            r2.invalidate()
            goto L_0x00ea
        L_0x00e4:
            r19 = r3
            r20 = r4
            r21 = r5
        L_0x00ea:
            int r7 = r7 + 1
            r3 = r19
            r4 = r20
            r5 = r21
            r2 = r28
            goto L_0x001d
        L_0x00f6:
            r19 = r3
            r20 = r4
            r21 = r5
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r2 = r0.mLayoutWidget
            r2.solveGraph()
            r2 = r21
            r3 = 0
        L_0x0104:
            if (r3 >= r2) goto L_0x0307
            android.view.View r4 = r0.getChildAt(r3)
            int r5 = r4.getVisibility()
            if (r5 == r10) goto L_0x02e9
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            android.support.constraint.ConstraintLayout$LayoutParams r5 = (android.support.constraint.ConstraintLayout.LayoutParams) r5
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r5.widget
            boolean r7 = r5.isGuideline
            if (r7 != 0) goto L_0x02e9
            boolean r7 = r5.isHelper
            if (r7 != 0) goto L_0x02e9
            int r7 = r4.getVisibility()
            r6.setVisibility(r7)
            int r7 = r5.width
            int r11 = r5.height
            if (r7 == 0) goto L_0x012f
            if (r11 != 0) goto L_0x02e9
        L_0x012f:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r12 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r12 = r6.getAnchor(r12)
            android.support.constraint.solver.widgets.ResolutionAnchor r12 = r12.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r13 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r13 = r6.getAnchor(r13)
            android.support.constraint.solver.widgets.ResolutionAnchor r13 = r13.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r6.getAnchor(r14)
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r14.getTarget()
            if (r14 == 0) goto L_0x015d
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r14 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r6.getAnchor(r14)
            android.support.constraint.solver.widgets.ConstraintAnchor r14 = r14.getTarget()
            if (r14 == 0) goto L_0x015d
            r14 = 1
            goto L_0x015e
        L_0x015d:
            r14 = 0
        L_0x015e:
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r15 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r15 = r6.getAnchor(r15)
            android.support.constraint.solver.widgets.ResolutionAnchor r15 = r15.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r10 = r6.getAnchor(r10)
            android.support.constraint.solver.widgets.ResolutionAnchor r10 = r10.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r6.getAnchor(r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.getTarget()
            if (r8 == 0) goto L_0x018c
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r6.getAnchor(r8)
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.getTarget()
            if (r8 == 0) goto L_0x018c
            r8 = 1
            goto L_0x018d
        L_0x018c:
            r8 = 0
        L_0x018d:
            if (r7 != 0) goto L_0x01a4
            if (r11 != 0) goto L_0x01a4
            if (r14 == 0) goto L_0x01a4
            if (r8 != 0) goto L_0x0196
            goto L_0x01a4
        L_0x0196:
            r22 = r2
            r23 = r3
            r10 = r19
            r24 = r20
            r0 = -2
            r2 = -1
            r18 = 1
            goto L_0x02f5
        L_0x01a4:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r9.getHorizontalDimensionBehaviour()
            r22 = r2
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 == r2) goto L_0x01b2
            r2 = 1
            goto L_0x01b3
        L_0x01b2:
            r2 = 0
        L_0x01b3:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r9.getVerticalDimensionBehaviour()
            r23 = r3
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r9 == r3) goto L_0x01c1
            r3 = 1
            goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r2 != 0) goto L_0x01cb
            android.support.constraint.solver.widgets.ResolutionDimension r9 = r6.getResolutionWidth()
            r9.invalidate()
        L_0x01cb:
            if (r3 != 0) goto L_0x01d4
            android.support.constraint.solver.widgets.ResolutionDimension r9 = r6.getResolutionHeight()
            r9.invalidate()
        L_0x01d4:
            if (r7 != 0) goto L_0x020b
            if (r2 == 0) goto L_0x0200
            boolean r9 = r6.isSpreadWidth()
            if (r9 == 0) goto L_0x0200
            if (r14 == 0) goto L_0x0200
            boolean r9 = r12.isResolved()
            if (r9 == 0) goto L_0x0200
            boolean r9 = r13.isResolved()
            if (r9 == 0) goto L_0x0200
            float r7 = r13.getResolvedValue()
            float r9 = r12.getResolvedValue()
            float r7 = r7 - r9
            int r7 = (int) r7
            android.support.constraint.solver.widgets.ResolutionDimension r9 = r6.getResolutionWidth()
            r9.resolve(r7)
            r9 = r20
            goto L_0x021c
        L_0x0200:
            r9 = r20
            r12 = -2
            int r2 = getChildMeasureSpec(r1, r9, r12)
            r13 = r2
            r2 = 0
            r12 = 1
            goto L_0x0221
        L_0x020b:
            r9 = r20
            r12 = -2
            r13 = -1
            if (r7 != r13) goto L_0x0218
            int r14 = getChildMeasureSpec(r1, r9, r13)
            r13 = r14
            r12 = 0
            goto L_0x0221
        L_0x0218:
            if (r7 != r12) goto L_0x021c
            r12 = 1
            goto L_0x021d
        L_0x021c:
            r12 = 0
        L_0x021d:
            int r13 = getChildMeasureSpec(r1, r9, r7)
        L_0x0221:
            if (r11 != 0) goto L_0x025c
            if (r3 == 0) goto L_0x024f
            boolean r14 = r6.isSpreadHeight()
            if (r14 == 0) goto L_0x024f
            if (r8 == 0) goto L_0x024f
            boolean r8 = r15.isResolved()
            if (r8 == 0) goto L_0x024f
            boolean r8 = r10.isResolved()
            if (r8 == 0) goto L_0x024f
            float r8 = r10.getResolvedValue()
            float r10 = r15.getResolvedValue()
            float r8 = r8 - r10
            int r11 = (int) r8
            android.support.constraint.solver.widgets.ResolutionDimension r8 = r6.getResolutionHeight()
            r8.resolve(r11)
            r10 = r19
            r8 = r28
            goto L_0x0270
        L_0x024f:
            r10 = r19
            r8 = r28
            r14 = -2
            int r3 = getChildMeasureSpec(r8, r10, r14)
            r15 = r3
            r3 = 0
            r14 = 1
            goto L_0x0275
        L_0x025c:
            r10 = r19
            r8 = r28
            r14 = -2
            r15 = -1
            if (r11 != r15) goto L_0x026c
            int r16 = getChildMeasureSpec(r8, r10, r15)
            r15 = r16
            r14 = 0
            goto L_0x0275
        L_0x026c:
            if (r11 != r14) goto L_0x0270
            r14 = 1
            goto L_0x0271
        L_0x0270:
            r14 = 0
        L_0x0271:
            int r15 = getChildMeasureSpec(r8, r10, r11)
        L_0x0275:
            r4.measure(r13, r15)
            android.support.constraint.solver.Metrics r13 = r0.mMetrics
            if (r13 == 0) goto L_0x0289
            android.support.constraint.solver.Metrics r13 = r0.mMetrics
            long r0 = r13.measures
            r24 = r9
            r18 = 1
            long r8 = r0 + r18
            r13.measures = r8
            goto L_0x028d
        L_0x0289:
            r24 = r9
            r18 = 1
        L_0x028d:
            r0 = -2
            if (r7 != r0) goto L_0x0292
            r1 = 1
            goto L_0x0293
        L_0x0292:
            r1 = 0
        L_0x0293:
            r6.setWidthWrapContent(r1)
            if (r11 != r0) goto L_0x029a
            r1 = 1
            goto L_0x029b
        L_0x029a:
            r1 = 0
        L_0x029b:
            r6.setHeightWrapContent(r1)
            int r1 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            r6.setWidth(r1)
            r6.setHeight(r7)
            if (r12 == 0) goto L_0x02b1
            r6.setWrapWidth(r1)
        L_0x02b1:
            if (r14 == 0) goto L_0x02b6
            r6.setWrapHeight(r7)
        L_0x02b6:
            if (r2 == 0) goto L_0x02c0
            android.support.constraint.solver.widgets.ResolutionDimension r2 = r6.getResolutionWidth()
            r2.resolve(r1)
            goto L_0x02c7
        L_0x02c0:
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r6.getResolutionWidth()
            r1.remove()
        L_0x02c7:
            if (r3 == 0) goto L_0x02d1
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r6.getResolutionHeight()
            r1.resolve(r7)
            goto L_0x02d8
        L_0x02d1:
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r6.getResolutionHeight()
            r1.remove()
        L_0x02d8:
            boolean r1 = r5.needsBaseline
            if (r1 == 0) goto L_0x02e7
            int r1 = r4.getBaseline()
            r2 = -1
            if (r1 == r2) goto L_0x02f5
            r6.setBaselineDistance(r1)
            goto L_0x02f5
        L_0x02e7:
            r2 = -1
            goto L_0x02f5
        L_0x02e9:
            r22 = r2
            r23 = r3
            r10 = r19
            r24 = r20
            r0 = -2
            r2 = -1
            r18 = r8
        L_0x02f5:
            int r3 = r23 + 1
            r8 = r18
            r2 = r22
            r20 = r24
            r0 = r26
            r1 = r27
            r19 = r10
            r10 = 8
            goto L_0x0104
        L_0x0307:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.internalMeasureDimensions(int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:147:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0241 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x039e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setChildrenConstraints() {
        /*
            r25 = this;
            r0 = r25
            boolean r1 = r25.isInEditMode()
            int r2 = r25.getChildCount()
            r3 = 0
            r4 = -1
            if (r1 == 0) goto L_0x0048
            r5 = 0
        L_0x000f:
            if (r5 >= r2) goto L_0x0048
            android.view.View r6 = r0.getChildAt(r5)
            android.content.res.Resources r7 = r25.getResources()     // Catch:{ NotFoundException -> 0x0045 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            java.lang.String r7 = r7.getResourceName(r8)     // Catch:{ NotFoundException -> 0x0045 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NotFoundException -> 0x0045 }
            r0.setDesignInformation(r3, r7, r8)     // Catch:{ NotFoundException -> 0x0045 }
            r8 = 47
            int r8 = r7.indexOf(r8)     // Catch:{ NotFoundException -> 0x0045 }
            if (r8 == r4) goto L_0x003a
            int r8 = r8 + 1
            java.lang.String r7 = r7.substring(r8)     // Catch:{ NotFoundException -> 0x0045 }
        L_0x003a:
            int r6 = r6.getId()     // Catch:{ NotFoundException -> 0x0045 }
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r0.getTargetWidget(r6)     // Catch:{ NotFoundException -> 0x0045 }
            r6.setDebugName(r7)     // Catch:{ NotFoundException -> 0x0045 }
        L_0x0045:
            int r5 = r5 + 1
            goto L_0x000f
        L_0x0048:
            r5 = 0
        L_0x0049:
            if (r5 >= r2) goto L_0x005b
            android.view.View r6 = r0.getChildAt(r5)
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r0.getViewWidget(r6)
            if (r6 == 0) goto L_0x0058
            r6.reset()
        L_0x0058:
            int r5 = r5 + 1
            goto L_0x0049
        L_0x005b:
            int r5 = r0.mConstraintSetId
            if (r5 == r4) goto L_0x007d
            r5 = 0
        L_0x0060:
            if (r5 >= r2) goto L_0x007d
            android.view.View r6 = r0.getChildAt(r5)
            int r7 = r6.getId()
            int r8 = r0.mConstraintSetId
            if (r7 != r8) goto L_0x007a
            boolean r7 = r6 instanceof android.support.constraint.Constraints
            if (r7 == 0) goto L_0x007a
            android.support.constraint.Constraints r6 = (android.support.constraint.Constraints) r6
            android.support.constraint.ConstraintSet r6 = r6.getConstraintSet()
            r0.mConstraintSet = r6
        L_0x007a:
            int r5 = r5 + 1
            goto L_0x0060
        L_0x007d:
            android.support.constraint.ConstraintSet r5 = r0.mConstraintSet
            if (r5 == 0) goto L_0x0086
            android.support.constraint.ConstraintSet r5 = r0.mConstraintSet
            r5.applyToInternal(r0)
        L_0x0086:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r5 = r0.mLayoutWidget
            r5.removeAllChildren()
            java.util.ArrayList<android.support.constraint.ConstraintHelper> r5 = r0.mConstraintHelpers
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00a4
            r6 = 0
        L_0x0094:
            if (r6 >= r5) goto L_0x00a4
            java.util.ArrayList<android.support.constraint.ConstraintHelper> r7 = r0.mConstraintHelpers
            java.lang.Object r7 = r7.get(r6)
            android.support.constraint.ConstraintHelper r7 = (android.support.constraint.ConstraintHelper) r7
            r7.updatePreLayout(r0)
            int r6 = r6 + 1
            goto L_0x0094
        L_0x00a4:
            r5 = 0
        L_0x00a5:
            if (r5 >= r2) goto L_0x00b7
            android.view.View r6 = r0.getChildAt(r5)
            boolean r7 = r6 instanceof android.support.constraint.Placeholder
            if (r7 == 0) goto L_0x00b4
            android.support.constraint.Placeholder r6 = (android.support.constraint.Placeholder) r6
            r6.updatePreLayout(r0)
        L_0x00b4:
            int r5 = r5 + 1
            goto L_0x00a5
        L_0x00b7:
            r5 = 0
        L_0x00b8:
            if (r5 >= r2) goto L_0x03d1
            android.view.View r6 = r0.getChildAt(r5)
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r0.getViewWidget(r6)
            if (r13 == 0) goto L_0x03cd
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            r14 = r7
            android.support.constraint.ConstraintLayout$LayoutParams r14 = (android.support.constraint.ConstraintLayout.LayoutParams) r14
            r14.validate()
            boolean r7 = r14.helped
            if (r7 == 0) goto L_0x00d5
            r14.helped = r3
            goto L_0x0105
        L_0x00d5:
            if (r1 == 0) goto L_0x0105
            android.content.res.Resources r7 = r25.getResources()     // Catch:{ NotFoundException -> 0x0105 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0105 }
            java.lang.String r7 = r7.getResourceName(r8)     // Catch:{ NotFoundException -> 0x0105 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0105 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NotFoundException -> 0x0105 }
            r0.setDesignInformation(r3, r7, r8)     // Catch:{ NotFoundException -> 0x0105 }
            java.lang.String r8 = "id/"
            int r8 = r7.indexOf(r8)     // Catch:{ NotFoundException -> 0x0105 }
            int r8 = r8 + 3
            java.lang.String r7 = r7.substring(r8)     // Catch:{ NotFoundException -> 0x0105 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0105 }
            android.support.constraint.solver.widgets.ConstraintWidget r8 = r0.getTargetWidget(r8)     // Catch:{ NotFoundException -> 0x0105 }
            r8.setDebugName(r7)     // Catch:{ NotFoundException -> 0x0105 }
        L_0x0105:
            int r7 = r6.getVisibility()
            r13.setVisibility(r7)
            boolean r7 = r14.isInPlaceholder
            if (r7 == 0) goto L_0x0115
            r7 = 8
            r13.setVisibility(r7)
        L_0x0115:
            r13.setCompanionWidget(r6)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r6 = r0.mLayoutWidget
            r6.add((android.support.constraint.solver.widgets.ConstraintWidget) r13)
            boolean r6 = r14.verticalDimensionFixed
            if (r6 == 0) goto L_0x0125
            boolean r6 = r14.horizontalDimensionFixed
            if (r6 != 0) goto L_0x012a
        L_0x0125:
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r6 = r0.mVariableDimensionsWidgets
            r6.add(r13)
        L_0x012a:
            boolean r6 = r14.isGuideline
            r7 = 17
            if (r6 == 0) goto L_0x015b
            android.support.constraint.solver.widgets.Guideline r13 = (android.support.constraint.solver.widgets.Guideline) r13
            int r6 = r14.resolvedGuideBegin
            int r8 = r14.resolvedGuideEnd
            float r9 = r14.resolvedGuidePercent
            int r10 = android.os.Build.VERSION.SDK_INT
            if (r10 >= r7) goto L_0x0142
            int r6 = r14.guideBegin
            int r8 = r14.guideEnd
            float r9 = r14.guidePercent
        L_0x0142:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x014d
            r13.setGuidePercent((float) r9)
            goto L_0x03cd
        L_0x014d:
            if (r6 == r4) goto L_0x0154
            r13.setGuideBegin(r6)
            goto L_0x03cd
        L_0x0154:
            if (r8 == r4) goto L_0x03cd
            r13.setGuideEnd(r8)
            goto L_0x03cd
        L_0x015b:
            int r6 = r14.leftToLeft
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.leftToRight
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.rightToLeft
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.rightToRight
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.startToStart
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.startToEnd
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.endToStart
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.endToEnd
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.topToTop
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.topToBottom
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.bottomToTop
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.bottomToBottom
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.baselineToBaseline
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.editorAbsoluteX
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.editorAbsoluteY
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.circleConstraint
            if (r6 != r4) goto L_0x01a3
            int r6 = r14.width
            if (r6 == r4) goto L_0x01a3
            int r6 = r14.height
            if (r6 != r4) goto L_0x03cd
        L_0x01a3:
            int r6 = r14.resolvedLeftToLeft
            int r8 = r14.resolvedLeftToRight
            int r9 = r14.resolvedRightToLeft
            int r10 = r14.resolvedRightToRight
            int r11 = r14.resolveGoneLeftMargin
            int r12 = r14.resolveGoneRightMargin
            float r15 = r14.resolvedHorizontalBias
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 >= r7) goto L_0x01e9
            int r3 = r14.leftToLeft
            int r6 = r14.leftToRight
            int r9 = r14.rightToLeft
            int r10 = r14.rightToRight
            int r7 = r14.goneLeftMargin
            int r8 = r14.goneRightMargin
            float r15 = r14.horizontalBias
            if (r3 != r4) goto L_0x01d4
            if (r6 != r4) goto L_0x01d4
            int r11 = r14.startToStart
            if (r11 == r4) goto L_0x01ce
            int r3 = r14.startToStart
            goto L_0x01d4
        L_0x01ce:
            int r11 = r14.startToEnd
            if (r11 == r4) goto L_0x01d4
            int r6 = r14.startToEnd
        L_0x01d4:
            if (r9 != r4) goto L_0x01e5
            if (r10 != r4) goto L_0x01e5
            int r11 = r14.endToStart
            if (r11 == r4) goto L_0x01df
            int r9 = r14.endToStart
            goto L_0x01e5
        L_0x01df:
            int r11 = r14.endToEnd
            if (r11 == r4) goto L_0x01e5
            int r10 = r14.endToEnd
        L_0x01e5:
            r12 = r7
            r16 = r8
            goto L_0x01ee
        L_0x01e9:
            r3 = r6
            r6 = r8
            r16 = r12
            r12 = r11
        L_0x01ee:
            r11 = r10
            r10 = r15
            r15 = r9
            int r7 = r14.circleConstraint
            if (r7 == r4) goto L_0x0206
            int r3 = r14.circleConstraint
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r0.getTargetWidget(r3)
            if (r3 == 0) goto L_0x031e
            float r6 = r14.circleAngle
            int r7 = r14.circleRadius
            r13.connectCircularConstraint(r3, r6, r7)
            goto L_0x031e
        L_0x0206:
            if (r3 == r4) goto L_0x021f
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r3)
            if (r9 == 0) goto L_0x021b
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            int r6 = r14.leftMargin
            r7 = r13
            r17 = r10
            r10 = r3
            r3 = r11
            r11 = r6
            goto L_0x0231
        L_0x021b:
            r17 = r10
            r3 = r11
            goto L_0x0234
        L_0x021f:
            r17 = r10
            r3 = r11
            if (r6 == r4) goto L_0x0234
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r6)
            if (r9 == 0) goto L_0x0234
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            int r11 = r14.leftMargin
            r7 = r13
        L_0x0231:
            r7.immediateConnect(r8, r9, r10, r11, r12)
        L_0x0234:
            if (r15 == r4) goto L_0x0241
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r15)
            if (r9 == 0) goto L_0x0255
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            goto L_0x024d
        L_0x0241:
            if (r3 == r4) goto L_0x0255
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r3)
            if (r9 == 0) goto L_0x0255
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
        L_0x024d:
            int r11 = r14.rightMargin
            r7 = r13
            r12 = r16
            r7.immediateConnect(r8, r9, r10, r11, r12)
        L_0x0255:
            int r3 = r14.topToTop
            if (r3 == r4) goto L_0x0266
            int r3 = r14.topToTop
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r3)
            if (r9 == 0) goto L_0x027e
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            goto L_0x0276
        L_0x0266:
            int r3 = r14.topToBottom
            if (r3 == r4) goto L_0x027e
            int r3 = r14.topToBottom
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r3)
            if (r9 == 0) goto L_0x027e
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
        L_0x0276:
            int r11 = r14.topMargin
            int r12 = r14.goneTopMargin
            r7 = r13
            r7.immediateConnect(r8, r9, r10, r11, r12)
        L_0x027e:
            int r3 = r14.bottomToTop
            if (r3 == r4) goto L_0x028f
            int r3 = r14.bottomToTop
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r3)
            if (r9 == 0) goto L_0x02a7
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            goto L_0x029f
        L_0x028f:
            int r3 = r14.bottomToBottom
            if (r3 == r4) goto L_0x02a7
            int r3 = r14.bottomToBottom
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r0.getTargetWidget(r3)
            if (r9 == 0) goto L_0x02a7
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r10 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
        L_0x029f:
            int r11 = r14.bottomMargin
            int r12 = r14.goneBottomMargin
            r7 = r13
            r7.immediateConnect(r8, r9, r10, r11, r12)
        L_0x02a7:
            int r3 = r14.baselineToBaseline
            if (r3 == r4) goto L_0x02fd
            android.util.SparseArray<android.view.View> r3 = r0.mChildrenByIds
            int r6 = r14.baselineToBaseline
            java.lang.Object r3 = r3.get(r6)
            android.view.View r3 = (android.view.View) r3
            int r6 = r14.baselineToBaseline
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r0.getTargetWidget(r6)
            if (r6 == 0) goto L_0x02fd
            if (r3 == 0) goto L_0x02fd
            android.view.ViewGroup$LayoutParams r7 = r3.getLayoutParams()
            boolean r7 = r7 instanceof android.support.constraint.ConstraintLayout.LayoutParams
            if (r7 == 0) goto L_0x02fd
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            android.support.constraint.ConstraintLayout$LayoutParams r3 = (android.support.constraint.ConstraintLayout.LayoutParams) r3
            r7 = 1
            r14.needsBaseline = r7
            r3.needsBaseline = r7
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE
            android.support.constraint.solver.widgets.ConstraintAnchor r18 = r13.getAnchor(r3)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BASELINE
            android.support.constraint.solver.widgets.ConstraintAnchor r19 = r6.getAnchor(r3)
            r20 = 0
            r21 = -1
            android.support.constraint.solver.widgets.ConstraintAnchor$Strength r22 = android.support.constraint.solver.widgets.ConstraintAnchor.Strength.STRONG
            r23 = 0
            r24 = 1
            r18.connect(r19, r20, r21, r22, r23, r24)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            r3.reset()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            r3.reset()
        L_0x02fd:
            r3 = 0
            r15 = r17
            int r6 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r6 < 0) goto L_0x030d
            int r6 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x030d
            r13.setHorizontalBiasPercent(r15)
        L_0x030d:
            float r6 = r14.verticalBias
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x031e
            float r3 = r14.verticalBias
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x031e
            float r3 = r14.verticalBias
            r13.setVerticalBiasPercent(r3)
        L_0x031e:
            if (r1 == 0) goto L_0x032f
            int r3 = r14.editorAbsoluteX
            if (r3 != r4) goto L_0x0328
            int r3 = r14.editorAbsoluteY
            if (r3 == r4) goto L_0x032f
        L_0x0328:
            int r3 = r14.editorAbsoluteX
            int r6 = r14.editorAbsoluteY
            r13.setOrigin(r3, r6)
        L_0x032f:
            boolean r3 = r14.horizontalDimensionFixed
            if (r3 != 0) goto L_0x0358
            int r3 = r14.width
            if (r3 != r4) goto L_0x0351
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r13.setHorizontalDimensionBehaviour(r3)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.LEFT
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            int r6 = r14.leftMargin
            r3.mMargin = r6
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            int r6 = r14.rightMargin
            r3.mMargin = r6
            goto L_0x0362
        L_0x0351:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r13.setHorizontalDimensionBehaviour(r3)
            r3 = 0
            goto L_0x035f
        L_0x0358:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13.setHorizontalDimensionBehaviour(r3)
            int r3 = r14.width
        L_0x035f:
            r13.setWidth(r3)
        L_0x0362:
            boolean r3 = r14.verticalDimensionFixed
            if (r3 != 0) goto L_0x038f
            int r3 = r14.height
            if (r3 != r4) goto L_0x0385
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            r13.setVerticalDimensionBehaviour(r3)
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.TOP
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            int r6 = r14.topMargin
            r3.mMargin = r6
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r3 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r13.getAnchor(r3)
            int r6 = r14.bottomMargin
            r3.mMargin = r6
            r3 = 0
            goto L_0x039a
        L_0x0385:
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r13.setVerticalDimensionBehaviour(r3)
            r3 = 0
            r13.setHeight(r3)
            goto L_0x039a
        L_0x038f:
            r3 = 0
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r13.setVerticalDimensionBehaviour(r6)
            int r6 = r14.height
            r13.setHeight(r6)
        L_0x039a:
            java.lang.String r6 = r14.dimensionRatio
            if (r6 == 0) goto L_0x03a3
            java.lang.String r6 = r14.dimensionRatio
            r13.setDimensionRatio(r6)
        L_0x03a3:
            float r6 = r14.horizontalWeight
            r13.setHorizontalWeight(r6)
            float r6 = r14.verticalWeight
            r13.setVerticalWeight(r6)
            int r6 = r14.horizontalChainStyle
            r13.setHorizontalChainStyle(r6)
            int r6 = r14.verticalChainStyle
            r13.setVerticalChainStyle(r6)
            int r6 = r14.matchConstraintDefaultWidth
            int r7 = r14.matchConstraintMinWidth
            int r8 = r14.matchConstraintMaxWidth
            float r9 = r14.matchConstraintPercentWidth
            r13.setHorizontalMatchStyle(r6, r7, r8, r9)
            int r6 = r14.matchConstraintDefaultHeight
            int r7 = r14.matchConstraintMinHeight
            int r8 = r14.matchConstraintMaxHeight
            float r9 = r14.matchConstraintPercentHeight
            r13.setVerticalMatchStyle(r6, r7, r8, r9)
        L_0x03cd:
            int r5 = r5 + 1
            goto L_0x00b8
        L_0x03d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.setChildrenConstraints():void");
    }

    private void setSelfDimensionBehaviour(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = Math.min(this.mMaxWidth, size) - paddingLeft;
            }
            size = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.mMaxHeight, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        this.mLayoutWidget.setMinWidth(0);
        this.mLayoutWidget.setMinHeight(0);
        this.mLayoutWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mLayoutWidget.setWidth(size);
        this.mLayoutWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
        this.mLayoutWidget.setHeight(size2);
        this.mLayoutWidget.setMinWidth((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
        this.mLayoutWidget.setMinHeight((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
    }

    private void updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.mVariableDimensionsWidgets.clear();
            setChildrenConstraints();
        }
    }

    private void updatePostMeasures() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePostMeasure(this);
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.mConstraintHelpers.get(i2).updatePostMeasure(this);
            }
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i2 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i3 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        float f = (float) i2;
                        float f2 = (float) i3;
                        float f3 = (float) (i2 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f4 = f2;
                        float f5 = f2;
                        float f6 = f3;
                        float f7 = f;
                        Paint paint2 = paint;
                        canvas2.drawLine(f, f4, f6, f5, paint);
                        float parseInt4 = (float) (i3 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f8 = f3;
                        float f9 = parseInt4;
                        canvas2.drawLine(f8, f5, f6, f9, paint);
                        float f10 = parseInt4;
                        float f11 = f7;
                        canvas2.drawLine(f8, f10, f11, f9, paint);
                        float f12 = f7;
                        canvas2.drawLine(f12, f10, f11, f5, paint);
                        paint.setColor(-16711936);
                        float f13 = f3;
                        Paint paint3 = paint;
                        canvas2.drawLine(f12, f5, f13, parseInt4, paint);
                        canvas2.drawLine(f12, parseInt4, f13, f5, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (this.mDesignIds == null || !this.mDesignIds.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || isInEditMode) && !layoutParams.isInPlaceholder) {
                int drawX = constraintWidget.getDrawX();
                int drawY = constraintWidget.getDrawY();
                int width = constraintWidget.getWidth() + drawX;
                int height = constraintWidget.getHeight() + drawY;
                childAt.layout(drawX, drawY, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(drawX, drawY, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r27, int r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            java.lang.System.currentTimeMillis()
            int r3 = android.view.View.MeasureSpec.getMode(r27)
            int r4 = android.view.View.MeasureSpec.getSize(r27)
            int r5 = android.view.View.MeasureSpec.getMode(r28)
            int r6 = android.view.View.MeasureSpec.getSize(r28)
            int r7 = r26.getPaddingLeft()
            int r8 = r26.getPaddingTop()
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            r9.setX(r7)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            r9.setY(r8)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r10 = r0.mMaxWidth
            r9.setMaxWidth(r10)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r10 = r0.mMaxHeight
            r9.setMaxHeight(r10)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 0
            r11 = 1
            r12 = 17
            if (r9 < r12) goto L_0x004f
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r12 = r26.getLayoutDirection()
            if (r12 != r11) goto L_0x004b
            r12 = 1
            goto L_0x004c
        L_0x004b:
            r12 = 0
        L_0x004c:
            r9.setRtl(r12)
        L_0x004f:
            r26.setSelfDimensionBehaviour(r27, r28)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r9 = r0.mLayoutWidget
            int r9 = r9.getWidth()
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r12 = r0.mLayoutWidget
            int r12 = r12.getHeight()
            boolean r13 = r0.mDirtyHierarchy
            if (r13 == 0) goto L_0x0069
            r0.mDirtyHierarchy = r10
            r26.updateHierarchy()
            r13 = 1
            goto L_0x006a
        L_0x0069:
            r13 = 0
        L_0x006a:
            int r14 = r0.mOptimizationLevel
            r15 = 8
            r14 = r14 & r15
            if (r14 != r15) goto L_0x0073
            r14 = 1
            goto L_0x0074
        L_0x0073:
            r14 = 0
        L_0x0074:
            if (r14 == 0) goto L_0x0084
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r15 = r0.mLayoutWidget
            r15.preOptimize()
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r15 = r0.mLayoutWidget
            r15.optimizeForDimensions(r9, r12)
            r26.internalMeasureDimensions(r27, r28)
            goto L_0x0087
        L_0x0084:
            r26.internalMeasureChildren(r27, r28)
        L_0x0087:
            r26.updatePostMeasures()
            int r15 = r26.getChildCount()
            if (r15 <= 0) goto L_0x0097
            if (r13 == 0) goto L_0x0097
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.Analyzer.determineGroups(r13)
        L_0x0097:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            boolean r13 = r13.mGroupsWrapOptimized
            if (r13 == 0) goto L_0x00db
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            boolean r13 = r13.mHorizontalWrapOptimized
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r13 == 0) goto L_0x00bd
            if (r3 != r15) goto L_0x00bd
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.mWrapFixedWidth
            if (r13 >= r4) goto L_0x00b6
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r11 = r0.mLayoutWidget
            int r11 = r11.mWrapFixedWidth
            r13.setWidth(r11)
        L_0x00b6:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r11 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r11.setHorizontalDimensionBehaviour(r13)
        L_0x00bd:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r11 = r0.mLayoutWidget
            boolean r11 = r11.mVerticalWrapOptimized
            if (r11 == 0) goto L_0x00db
            if (r5 != r15) goto L_0x00db
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r11 = r0.mLayoutWidget
            int r11 = r11.mWrapFixedHeight
            if (r11 >= r6) goto L_0x00d4
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r11 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.mWrapFixedHeight
            r11.setHeight(r13)
        L_0x00d4:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r11 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r11.setVerticalDimensionBehaviour(r13)
        L_0x00db:
            int r11 = r0.mOptimizationLevel
            r13 = 32
            r11 = r11 & r13
            r15 = 1073741824(0x40000000, float:2.0)
            if (r11 != r13) goto L_0x0137
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r11 = r0.mLayoutWidget
            int r11 = r11.getWidth()
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.getHeight()
            int r10 = r0.mLastMeasureWidth
            if (r10 == r11) goto L_0x00fe
            if (r3 != r15) goto L_0x00fe
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r10 = 0
            android.support.constraint.solver.widgets.Analyzer.setPosition(r3, r10, r11)
        L_0x00fe:
            int r3 = r0.mLastMeasureHeight
            if (r3 == r13) goto L_0x010c
            if (r5 != r15) goto L_0x010c
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r5 = 1
            android.support.constraint.solver.widgets.Analyzer.setPosition(r3, r5, r13)
        L_0x010c:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.mHorizontalWrapOptimized
            if (r3 == 0) goto L_0x0121
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.mWrapFixedWidth
            if (r3 <= r4) goto L_0x0121
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r10 = 0
            android.support.constraint.solver.widgets.Analyzer.setPosition(r3, r10, r4)
            goto L_0x0122
        L_0x0121:
            r10 = 0
        L_0x0122:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.mVerticalWrapOptimized
            if (r3 == 0) goto L_0x0137
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            int r3 = r3.mWrapFixedHeight
            if (r3 <= r6) goto L_0x0137
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            java.util.List<android.support.constraint.solver.widgets.ConstraintWidgetGroup> r3 = r3.mWidgetGroups
            r4 = 1
            android.support.constraint.solver.widgets.Analyzer.setPosition(r3, r4, r6)
            goto L_0x0138
        L_0x0137:
            r4 = 1
        L_0x0138:
            int r3 = r26.getChildCount()
            if (r3 <= 0) goto L_0x0143
            java.lang.String r3 = "First pass"
            r0.solveLinearSystem(r3)
        L_0x0143:
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r3 = r0.mVariableDimensionsWidgets
            int r3 = r3.size()
            int r5 = r26.getPaddingBottom()
            int r8 = r8 + r5
            int r5 = r26.getPaddingRight()
            int r7 = r7 + r5
            if (r3 <= 0) goto L_0x038e
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r6 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r6.getHorizontalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 != r11) goto L_0x0161
            r6 = 1
            goto L_0x0162
        L_0x0161:
            r6 = 0
        L_0x0162:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r11 = r0.mLayoutWidget
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r11.getVerticalDimensionBehaviour()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 != r13) goto L_0x016e
            r11 = 1
            goto L_0x016f
        L_0x016e:
            r11 = 0
        L_0x016f:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.getWidth()
            int r4 = r0.mMinWidth
            int r4 = java.lang.Math.max(r13, r4)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r13 = r0.mLayoutWidget
            int r13 = r13.getHeight()
            int r10 = r0.mMinHeight
            int r10 = java.lang.Math.max(r13, r10)
            r13 = r4
            r5 = r10
            r4 = 0
            r10 = 0
            r18 = 0
        L_0x018d:
            r16 = 1
            if (r4 >= r3) goto L_0x02e5
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r15 = r0.mVariableDimensionsWidgets
            java.lang.Object r15 = r15.get(r4)
            android.support.constraint.solver.widgets.ConstraintWidget r15 = (android.support.constraint.solver.widgets.ConstraintWidget) r15
            java.lang.Object r19 = r15.getCompanionWidget()
            r20 = r3
            r3 = r19
            android.view.View r3 = (android.view.View) r3
            if (r3 == 0) goto L_0x02c3
            android.view.ViewGroup$LayoutParams r19 = r3.getLayoutParams()
            r21 = r12
            r12 = r19
            android.support.constraint.ConstraintLayout$LayoutParams r12 = (android.support.constraint.ConstraintLayout.LayoutParams) r12
            r22 = r9
            boolean r9 = r12.isHelper
            if (r9 != 0) goto L_0x02bc
            boolean r9 = r12.isGuideline
            if (r9 != 0) goto L_0x02bc
            int r9 = r3.getVisibility()
            r23 = r10
            r10 = 8
            if (r9 == r10) goto L_0x02b7
            if (r14 == 0) goto L_0x01d9
            android.support.constraint.solver.widgets.ResolutionDimension r9 = r15.getResolutionWidth()
            boolean r9 = r9.isResolved()
            if (r9 == 0) goto L_0x01d9
            android.support.constraint.solver.widgets.ResolutionDimension r9 = r15.getResolutionHeight()
            boolean r9 = r9.isResolved()
            if (r9 != 0) goto L_0x02b7
        L_0x01d9:
            int r9 = r12.width
            r10 = -2
            if (r9 != r10) goto L_0x01e9
            boolean r9 = r12.horizontalDimensionFixed
            if (r9 == 0) goto L_0x01e9
            int r9 = r12.width
            int r9 = getChildMeasureSpec(r1, r7, r9)
            goto L_0x01f3
        L_0x01e9:
            int r9 = r15.getWidth()
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
        L_0x01f3:
            int r10 = r12.height
            r1 = -2
            if (r10 != r1) goto L_0x0203
            boolean r1 = r12.verticalDimensionFixed
            if (r1 == 0) goto L_0x0203
            int r1 = r12.height
            int r1 = getChildMeasureSpec(r2, r8, r1)
            goto L_0x020d
        L_0x0203:
            int r1 = r15.getHeight()
            r10 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
        L_0x020d:
            r3.measure(r9, r1)
            android.support.constraint.solver.Metrics r1 = r0.mMetrics
            if (r1 == 0) goto L_0x0221
            android.support.constraint.solver.Metrics r1 = r0.mMetrics
            long r9 = r1.additionalMeasures
            r25 = r7
            r24 = r8
            long r7 = r9 + r16
            r1.additionalMeasures = r7
            goto L_0x0225
        L_0x0221:
            r25 = r7
            r24 = r8
        L_0x0225:
            int r1 = r3.getMeasuredWidth()
            int r7 = r3.getMeasuredHeight()
            int r8 = r15.getWidth()
            if (r1 == r8) goto L_0x025d
            r15.setWidth(r1)
            if (r14 == 0) goto L_0x023f
            android.support.constraint.solver.widgets.ResolutionDimension r8 = r15.getResolutionWidth()
            r8.resolve(r1)
        L_0x023f:
            if (r6 == 0) goto L_0x025b
            int r1 = r15.getRight()
            if (r1 <= r13) goto L_0x025b
            int r1 = r15.getRight()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r8 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.RIGHT
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r15.getAnchor(r8)
            int r8 = r8.getMargin()
            int r1 = r1 + r8
            int r1 = java.lang.Math.max(r13, r1)
            r13 = r1
        L_0x025b:
            r23 = 1
        L_0x025d:
            int r1 = r15.getHeight()
            if (r7 == r1) goto L_0x028d
            r15.setHeight(r7)
            if (r14 == 0) goto L_0x026f
            android.support.constraint.solver.widgets.ResolutionDimension r1 = r15.getResolutionHeight()
            r1.resolve(r7)
        L_0x026f:
            if (r11 == 0) goto L_0x028b
            int r1 = r15.getBottom()
            if (r1 <= r5) goto L_0x028b
            int r1 = r15.getBottom()
            android.support.constraint.solver.widgets.ConstraintAnchor$Type r7 = android.support.constraint.solver.widgets.ConstraintAnchor.Type.BOTTOM
            android.support.constraint.solver.widgets.ConstraintAnchor r7 = r15.getAnchor(r7)
            int r7 = r7.getMargin()
            int r1 = r1 + r7
            int r1 = java.lang.Math.max(r5, r1)
            r5 = r1
        L_0x028b:
            r23 = 1
        L_0x028d:
            boolean r1 = r12.needsBaseline
            if (r1 == 0) goto L_0x02a3
            int r1 = r3.getBaseline()
            r7 = -1
            if (r1 == r7) goto L_0x02a3
            int r7 = r15.getBaselineDistance()
            if (r1 == r7) goto L_0x02a3
            r15.setBaselineDistance(r1)
            r23 = 1
        L_0x02a3:
            int r1 = android.os.Build.VERSION.SDK_INT
            r7 = 11
            if (r1 < r7) goto L_0x02b4
            int r1 = r3.getMeasuredState()
            r3 = r18
            int r18 = combineMeasuredStates(r3, r1)
            goto L_0x02d1
        L_0x02b4:
            r3 = r18
            goto L_0x02d1
        L_0x02b7:
            r25 = r7
            r24 = r8
            goto L_0x02cd
        L_0x02bc:
            r25 = r7
            r24 = r8
            r23 = r10
            goto L_0x02cd
        L_0x02c3:
            r25 = r7
            r24 = r8
            r22 = r9
            r23 = r10
            r21 = r12
        L_0x02cd:
            r3 = r18
            r18 = r3
        L_0x02d1:
            r10 = r23
            int r4 = r4 + 1
            r3 = r20
            r12 = r21
            r9 = r22
            r8 = r24
            r7 = r25
            r1 = r27
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x018d
        L_0x02e5:
            r20 = r3
            r25 = r7
            r24 = r8
            r22 = r9
            r23 = r10
            r21 = r12
            r3 = r18
            if (r23 == 0) goto L_0x0334
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r4 = r22
            r1.setWidth(r4)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r4 = r21
            r1.setHeight(r4)
            if (r14 == 0) goto L_0x030a
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.solveGraph()
        L_0x030a:
            java.lang.String r1 = "2nd pass"
            r0.solveLinearSystem(r1)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            int r1 = r1.getWidth()
            if (r1 >= r13) goto L_0x031e
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.setWidth(r13)
            r11 = 1
            goto L_0x031f
        L_0x031e:
            r11 = 0
        L_0x031f:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            int r1 = r1.getHeight()
            if (r1 >= r5) goto L_0x032d
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            r1.setHeight(r5)
            r11 = 1
        L_0x032d:
            if (r11 == 0) goto L_0x0334
            java.lang.String r1 = "3rd pass"
            r0.solveLinearSystem(r1)
        L_0x0334:
            r1 = r20
            r4 = 0
        L_0x0337:
            if (r4 >= r1) goto L_0x0393
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r5 = r0.mVariableDimensionsWidgets
            java.lang.Object r5 = r5.get(r4)
            android.support.constraint.solver.widgets.ConstraintWidget r5 = (android.support.constraint.solver.widgets.ConstraintWidget) r5
            java.lang.Object r6 = r5.getCompanionWidget()
            android.view.View r6 = (android.view.View) r6
            if (r6 == 0) goto L_0x0387
            int r7 = r6.getMeasuredWidth()
            int r8 = r5.getWidth()
            if (r7 != r8) goto L_0x035d
            int r7 = r6.getMeasuredHeight()
            int r8 = r5.getHeight()
            if (r7 == r8) goto L_0x0387
        L_0x035d:
            int r7 = r5.getVisibility()
            r8 = 8
            if (r7 == r8) goto L_0x0389
            int r7 = r5.getWidth()
            r9 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
            int r5 = r5.getHeight()
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r9)
            r6.measure(r7, r5)
            android.support.constraint.solver.Metrics r5 = r0.mMetrics
            if (r5 == 0) goto L_0x038b
            android.support.constraint.solver.Metrics r5 = r0.mMetrics
            long r6 = r5.additionalMeasures
            long r10 = r6 + r16
            r5.additionalMeasures = r10
            goto L_0x038b
        L_0x0387:
            r8 = 8
        L_0x0389:
            r9 = 1073741824(0x40000000, float:2.0)
        L_0x038b:
            int r4 = r4 + 1
            goto L_0x0337
        L_0x038e:
            r25 = r7
            r24 = r8
            r3 = 0
        L_0x0393:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r1 = r0.mLayoutWidget
            int r1 = r1.getWidth()
            int r1 = r1 + r25
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r4 = r0.mLayoutWidget
            int r4 = r4.getHeight()
            int r4 = r4 + r24
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 11
            if (r5 < r6) goto L_0x03e2
            r5 = r27
            int r1 = resolveSizeAndState(r1, r5, r3)
            int r3 = r3 << 16
            int r2 = resolveSizeAndState(r4, r2, r3)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r1 = r1 & r3
            r2 = r2 & r3
            int r3 = r0.mMaxWidth
            int r1 = java.lang.Math.min(r3, r1)
            int r3 = r0.mMaxHeight
            int r2 = java.lang.Math.min(r3, r2)
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.isWidthMeasuredTooSmall()
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            if (r3 == 0) goto L_0x03d1
            r1 = r1 | r4
        L_0x03d1:
            android.support.constraint.solver.widgets.ConstraintWidgetContainer r3 = r0.mLayoutWidget
            boolean r3 = r3.isHeightMeasuredTooSmall()
            if (r3 == 0) goto L_0x03da
            r2 = r2 | r4
        L_0x03da:
            r0.setMeasuredDimension(r1, r2)
            r0.mLastMeasureWidth = r1
            r0.mLastMeasureHeight = r2
            return
        L_0x03e2:
            r0.setMeasuredDimension(r1, r4)
            r0.mLastMeasureWidth = r1
            r0.mLastMeasureHeight = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.ConstraintLayout.onMeasure(int, int):void");
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.widget = new Guideline();
            layoutParams.isGuideline = true;
            ((Guideline) layoutParams.widget).setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.remove(viewWidget);
        this.mConstraintHelpers.remove(view);
        this.mVariableDimensionsWidgets.remove(viewWidget);
        this.mDirtyHierarchy = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void solveLinearSystem(String str) {
        this.mLayoutWidget.layout();
        if (this.mMetrics != null) {
            this.mMetrics.resolutions++;
        }
    }
}
