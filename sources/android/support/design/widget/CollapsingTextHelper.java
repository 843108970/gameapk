package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.v4.math.MathUtils;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import com.cyjh.mobileanjian.ipc.share.proto.a;

final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final boolean USE_SCALING_TEXTURE = (Build.VERSION.SDK_INT < 18);
    private boolean mBoundsChanged;
    private final Rect mCollapsedBounds;
    private float mCollapsedDrawX;
    private float mCollapsedDrawY;
    private int mCollapsedShadowColor;
    private float mCollapsedShadowDx;
    private float mCollapsedShadowDy;
    private float mCollapsedShadowRadius;
    private ColorStateList mCollapsedTextColor;
    private int mCollapsedTextGravity = 16;
    private float mCollapsedTextSize = 15.0f;
    private Typeface mCollapsedTypeface;
    private final RectF mCurrentBounds;
    private float mCurrentDrawX;
    private float mCurrentDrawY;
    private float mCurrentTextSize;
    private Typeface mCurrentTypeface;
    private boolean mDrawTitle;
    private final Rect mExpandedBounds;
    private float mExpandedDrawX;
    private float mExpandedDrawY;
    private float mExpandedFraction;
    private int mExpandedShadowColor;
    private float mExpandedShadowDx;
    private float mExpandedShadowDy;
    private float mExpandedShadowRadius;
    private ColorStateList mExpandedTextColor;
    private int mExpandedTextGravity = 16;
    private float mExpandedTextSize = 15.0f;
    private Bitmap mExpandedTitleTexture;
    private Typeface mExpandedTypeface;
    private boolean mIsRtl;
    private Interpolator mPositionInterpolator;
    private float mScale;
    private int[] mState;
    private CharSequence mText;
    private final TextPaint mTextPaint;
    private Interpolator mTextSizeInterpolator;
    private CharSequence mTextToDraw;
    private float mTextureAscent;
    private float mTextureDescent;
    private Paint mTexturePaint;
    private boolean mUseTexture;
    private final View mView;

    public CollapsingTextHelper(View view) {
        this.mView = view;
        this.mTextPaint = new TextPaint(a.aG);
        this.mCollapsedBounds = new Rect();
        this.mExpandedBounds = new Rect();
        this.mCurrentBounds = new RectF();
    }

    private boolean areTypefacesDifferent(Typeface typeface, Typeface typeface2) {
        if (typeface == null || typeface.equals(typeface2)) {
            return typeface == null && typeface2 != null;
        }
        return true;
    }

    private static int blendColors(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void calculateBaseOffsets() {
        /*
            r11 = this;
            float r0 = r11.mCurrentTextSize
            float r1 = r11.mCollapsedTextSize
            r11.calculateUsingTextSize(r1)
            java.lang.CharSequence r1 = r11.mTextToDraw
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x001c
            android.text.TextPaint r1 = r11.mTextPaint
            java.lang.CharSequence r4 = r11.mTextToDraw
            java.lang.CharSequence r5 = r11.mTextToDraw
            int r5 = r5.length()
            float r1 = r1.measureText(r4, r3, r5)
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r4 = r11.mCollapsedTextGravity
            boolean r5 = r11.mIsRtl
            int r4 = android.support.v4.view.GravityCompat.getAbsoluteGravity(r4, r5)
            r5 = r4 & 112(0x70, float:1.57E-43)
            r6 = 80
            r7 = 48
            r8 = 1073741824(0x40000000, float:2.0)
            if (r5 == r7) goto L_0x0057
            if (r5 == r6) goto L_0x0051
            android.text.TextPaint r5 = r11.mTextPaint
            float r5 = r5.descent()
            android.text.TextPaint r9 = r11.mTextPaint
            float r9 = r9.ascent()
            float r5 = r5 - r9
            float r5 = r5 / r8
            android.text.TextPaint r9 = r11.mTextPaint
            float r9 = r9.descent()
            float r5 = r5 - r9
            android.graphics.Rect r9 = r11.mCollapsedBounds
            int r9 = r9.centerY()
            float r9 = (float) r9
            float r9 = r9 + r5
            r11.mCollapsedDrawY = r9
            goto L_0x0065
        L_0x0051:
            android.graphics.Rect r5 = r11.mCollapsedBounds
            int r5 = r5.bottom
            float r5 = (float) r5
            goto L_0x0063
        L_0x0057:
            android.graphics.Rect r5 = r11.mCollapsedBounds
            int r5 = r5.top
            float r5 = (float) r5
            android.text.TextPaint r9 = r11.mTextPaint
            float r9 = r9.ascent()
            float r5 = r5 - r9
        L_0x0063:
            r11.mCollapsedDrawY = r5
        L_0x0065:
            r5 = 8388615(0x800007, float:1.1754953E-38)
            r4 = r4 & r5
            r9 = 5
            r10 = 1
            if (r4 == r10) goto L_0x007d
            if (r4 == r9) goto L_0x0077
            android.graphics.Rect r1 = r11.mCollapsedBounds
            int r1 = r1.left
            float r1 = (float) r1
            r11.mCollapsedDrawX = r1
            goto L_0x0088
        L_0x0077:
            android.graphics.Rect r4 = r11.mCollapsedBounds
            int r4 = r4.right
            float r4 = (float) r4
            goto L_0x0085
        L_0x007d:
            android.graphics.Rect r4 = r11.mCollapsedBounds
            int r4 = r4.centerX()
            float r4 = (float) r4
            float r1 = r1 / r8
        L_0x0085:
            float r4 = r4 - r1
            r11.mCollapsedDrawX = r4
        L_0x0088:
            float r1 = r11.mExpandedTextSize
            r11.calculateUsingTextSize(r1)
            java.lang.CharSequence r1 = r11.mTextToDraw
            if (r1 == 0) goto L_0x009f
            android.text.TextPaint r1 = r11.mTextPaint
            java.lang.CharSequence r2 = r11.mTextToDraw
            java.lang.CharSequence r4 = r11.mTextToDraw
            int r4 = r4.length()
            float r2 = r1.measureText(r2, r3, r4)
        L_0x009f:
            int r1 = r11.mExpandedTextGravity
            boolean r3 = r11.mIsRtl
            int r1 = android.support.v4.view.GravityCompat.getAbsoluteGravity(r1, r3)
            r3 = r1 & 112(0x70, float:1.57E-43)
            if (r3 == r7) goto L_0x00d3
            if (r3 == r6) goto L_0x00cd
            android.text.TextPaint r3 = r11.mTextPaint
            float r3 = r3.descent()
            android.text.TextPaint r4 = r11.mTextPaint
            float r4 = r4.ascent()
            float r3 = r3 - r4
            float r3 = r3 / r8
            android.text.TextPaint r4 = r11.mTextPaint
            float r4 = r4.descent()
            float r3 = r3 - r4
            android.graphics.Rect r4 = r11.mExpandedBounds
            int r4 = r4.centerY()
            float r4 = (float) r4
            float r4 = r4 + r3
            r11.mExpandedDrawY = r4
            goto L_0x00e1
        L_0x00cd:
            android.graphics.Rect r3 = r11.mExpandedBounds
            int r3 = r3.bottom
            float r3 = (float) r3
            goto L_0x00df
        L_0x00d3:
            android.graphics.Rect r3 = r11.mExpandedBounds
            int r3 = r3.top
            float r3 = (float) r3
            android.text.TextPaint r4 = r11.mTextPaint
            float r4 = r4.ascent()
            float r3 = r3 - r4
        L_0x00df:
            r11.mExpandedDrawY = r3
        L_0x00e1:
            r1 = r1 & r5
            if (r1 == r10) goto L_0x00f4
            if (r1 == r9) goto L_0x00ee
            android.graphics.Rect r1 = r11.mExpandedBounds
            int r1 = r1.left
            float r1 = (float) r1
        L_0x00eb:
            r11.mExpandedDrawX = r1
            goto L_0x00fe
        L_0x00ee:
            android.graphics.Rect r1 = r11.mExpandedBounds
            int r1 = r1.right
            float r1 = (float) r1
            goto L_0x00fc
        L_0x00f4:
            android.graphics.Rect r1 = r11.mExpandedBounds
            int r1 = r1.centerX()
            float r1 = (float) r1
            float r2 = r2 / r8
        L_0x00fc:
            float r1 = r1 - r2
            goto L_0x00eb
        L_0x00fe:
            r11.clearTexture()
            r11.setInterpolatedTextSize(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CollapsingTextHelper.calculateBaseOffsets():void");
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.mExpandedFraction);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        boolean z = true;
        if (ViewCompat.getLayoutDirection(this.mView) != 1) {
            z = false;
        }
        return (z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private void calculateOffsets(float f) {
        TextPaint textPaint;
        int currentCollapsedTextColor;
        interpolateBounds(f);
        this.mCurrentDrawX = lerp(this.mExpandedDrawX, this.mCollapsedDrawX, f, this.mPositionInterpolator);
        this.mCurrentDrawY = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f, this.mPositionInterpolator);
        setInterpolatedTextSize(lerp(this.mExpandedTextSize, this.mCollapsedTextSize, f, this.mTextSizeInterpolator));
        if (this.mCollapsedTextColor != this.mExpandedTextColor) {
            textPaint = this.mTextPaint;
            currentCollapsedTextColor = blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f);
        } else {
            textPaint = this.mTextPaint;
            currentCollapsedTextColor = getCurrentCollapsedTextColor();
        }
        textPaint.setColor(currentCollapsedTextColor);
        this.mTextPaint.setShadowLayer(lerp(this.mExpandedShadowRadius, this.mCollapsedShadowRadius, f, (Interpolator) null), lerp(this.mExpandedShadowDx, this.mCollapsedShadowDx, f, (Interpolator) null), lerp(this.mExpandedShadowDy, this.mCollapsedShadowDy, f, (Interpolator) null), blendColors(this.mExpandedShadowColor, this.mCollapsedShadowColor, f));
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private void calculateUsingTextSize(float f) {
        boolean z;
        float f2;
        boolean z2;
        if (this.mText != null) {
            float width = (float) this.mCollapsedBounds.width();
            float width2 = (float) this.mExpandedBounds.width();
            boolean z3 = true;
            if (isClose(f, this.mCollapsedTextSize)) {
                float f3 = this.mCollapsedTextSize;
                this.mScale = 1.0f;
                if (areTypefacesDifferent(this.mCurrentTypeface, this.mCollapsedTypeface)) {
                    this.mCurrentTypeface = this.mCollapsedTypeface;
                    z2 = true;
                } else {
                    z2 = false;
                }
                f2 = f3;
                z = z2;
            } else {
                f2 = this.mExpandedTextSize;
                if (areTypefacesDifferent(this.mCurrentTypeface, this.mExpandedTypeface)) {
                    this.mCurrentTypeface = this.mExpandedTypeface;
                    z = true;
                } else {
                    z = false;
                }
                if (isClose(f, this.mExpandedTextSize)) {
                    this.mScale = 1.0f;
                } else {
                    this.mScale = f / this.mExpandedTextSize;
                }
                float f4 = this.mCollapsedTextSize / this.mExpandedTextSize;
                width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
            }
            if (width > 0.0f) {
                z = this.mCurrentTextSize != f2 || this.mBoundsChanged || z;
                this.mCurrentTextSize = f2;
                this.mBoundsChanged = false;
            }
            if (this.mTextToDraw == null || z) {
                this.mTextPaint.setTextSize(this.mCurrentTextSize);
                this.mTextPaint.setTypeface(this.mCurrentTypeface);
                TextPaint textPaint = this.mTextPaint;
                if (this.mScale == 1.0f) {
                    z3 = false;
                }
                textPaint.setLinearText(z3);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.mTextPaint, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.mTextToDraw)) {
                    this.mTextToDraw = ellipsize;
                    this.mIsRtl = calculateIsRtl(this.mTextToDraw);
                }
            }
        }
    }

    private void clearTexture() {
        if (this.mExpandedTitleTexture != null) {
            this.mExpandedTitleTexture.recycle();
            this.mExpandedTitleTexture = null;
        }
    }

    private void ensureExpandedTexture() {
        if (this.mExpandedTitleTexture == null && !this.mExpandedBounds.isEmpty() && !TextUtils.isEmpty(this.mTextToDraw)) {
            calculateOffsets(0.0f);
            this.mTextureAscent = this.mTextPaint.ascent();
            this.mTextureDescent = this.mTextPaint.descent();
            int round = Math.round(this.mTextPaint.measureText(this.mTextToDraw, 0, this.mTextToDraw.length()));
            int round2 = Math.round(this.mTextureDescent - this.mTextureAscent);
            if (round > 0 && round2 > 0) {
                this.mExpandedTitleTexture = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                new Canvas(this.mExpandedTitleTexture).drawText(this.mTextToDraw, 0, this.mTextToDraw.length(), 0.0f, ((float) round2) - this.mTextPaint.descent(), this.mTextPaint);
                if (this.mTexturePaint == null) {
                    this.mTexturePaint = new Paint(3);
                }
            }
        }
    }

    @ColorInt
    private int getCurrentCollapsedTextColor() {
        return this.mState != null ? this.mCollapsedTextColor.getColorForState(this.mState, 0) : this.mCollapsedTextColor.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return this.mState != null ? this.mExpandedTextColor.getColorForState(this.mState, 0) : this.mExpandedTextColor.getDefaultColor();
    }

    private void interpolateBounds(float f) {
        this.mCurrentBounds.left = lerp((float) this.mExpandedBounds.left, (float) this.mCollapsedBounds.left, f, this.mPositionInterpolator);
        this.mCurrentBounds.top = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f, this.mPositionInterpolator);
        this.mCurrentBounds.right = lerp((float) this.mExpandedBounds.right, (float) this.mCollapsedBounds.right, f, this.mPositionInterpolator);
        this.mCurrentBounds.bottom = lerp((float) this.mExpandedBounds.bottom, (float) this.mCollapsedBounds.bottom, f, this.mPositionInterpolator);
    }

    private static boolean isClose(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static float lerp(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return AnimationUtils.lerp(f, f2, f3);
    }

    private Typeface readFontFamilyTypeface(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static boolean rectEquals(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    private void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f);
        this.mUseTexture = USE_SCALING_TEXTURE && this.mScale != 1.0f;
        if (this.mUseTexture) {
            ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    public final void draw(Canvas canvas) {
        float f;
        int save = canvas.save();
        if (this.mTextToDraw != null && this.mDrawTitle) {
            float f2 = this.mCurrentDrawX;
            float f3 = this.mCurrentDrawY;
            boolean z = this.mUseTexture && this.mExpandedTitleTexture != null;
            if (z) {
                f = this.mTextureAscent * this.mScale;
            } else {
                this.mTextPaint.ascent();
                f = 0.0f;
                this.mTextPaint.descent();
            }
            if (z) {
                f3 += f;
            }
            float f4 = f3;
            if (this.mScale != 1.0f) {
                canvas.scale(this.mScale, this.mScale, f2, f4);
            }
            if (z) {
                canvas.drawBitmap(this.mExpandedTitleTexture, f2, f4, this.mTexturePaint);
            } else {
                canvas.drawText(this.mTextToDraw, 0, this.mTextToDraw.length(), f2, f4, this.mTextPaint);
            }
        }
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList getCollapsedTextColor() {
        return this.mCollapsedTextColor;
    }

    /* access modifiers changed from: package-private */
    public final int getCollapsedTextGravity() {
        return this.mCollapsedTextGravity;
    }

    /* access modifiers changed from: package-private */
    public final float getCollapsedTextSize() {
        return this.mCollapsedTextSize;
    }

    /* access modifiers changed from: package-private */
    public final Typeface getCollapsedTypeface() {
        return this.mCollapsedTypeface != null ? this.mCollapsedTypeface : Typeface.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList getExpandedTextColor() {
        return this.mExpandedTextColor;
    }

    /* access modifiers changed from: package-private */
    public final int getExpandedTextGravity() {
        return this.mExpandedTextGravity;
    }

    /* access modifiers changed from: package-private */
    public final float getExpandedTextSize() {
        return this.mExpandedTextSize;
    }

    /* access modifiers changed from: package-private */
    public final Typeface getExpandedTypeface() {
        return this.mExpandedTypeface != null ? this.mExpandedTypeface : Typeface.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    public final float getExpansionFraction() {
        return this.mExpandedFraction;
    }

    /* access modifiers changed from: package-private */
    public final CharSequence getText() {
        return this.mText;
    }

    /* access modifiers changed from: package-private */
    public final boolean isStateful() {
        if (this.mCollapsedTextColor == null || !this.mCollapsedTextColor.isStateful()) {
            return this.mExpandedTextColor != null && this.mExpandedTextColor.isStateful();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void onBoundsChanged() {
        this.mDrawTitle = this.mCollapsedBounds.width() > 0 && this.mCollapsedBounds.height() > 0 && this.mExpandedBounds.width() > 0 && this.mExpandedBounds.height() > 0;
    }

    public final void recalculate() {
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            calculateBaseOffsets();
            calculateCurrentOffsets();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setCollapsedBounds(int i, int i2, int i3, int i4) {
        if (!rectEquals(this.mCollapsedBounds, i, i2, i3, i4)) {
            this.mCollapsedBounds.set(i, i2, i3, i4);
            this.mBoundsChanged = true;
            onBoundsChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setCollapsedTextAppearance(int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            this.mCollapsedTextColor = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            this.mCollapsedTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int) this.mCollapsedTextSize);
        }
        this.mCollapsedShadowColor = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        this.mCollapsedShadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.mCollapsedShadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.mCollapsedShadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mCollapsedTypeface = readFontFamilyTypeface(i);
        }
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public final void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.mCollapsedTextColor != colorStateList) {
            this.mCollapsedTextColor = colorStateList;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setCollapsedTextGravity(int i) {
        if (this.mCollapsedTextGravity != i) {
            this.mCollapsedTextGravity = i;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setCollapsedTextSize(float f) {
        if (this.mCollapsedTextSize != f) {
            this.mCollapsedTextSize = f;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setCollapsedTypeface(Typeface typeface) {
        if (areTypefacesDifferent(this.mCollapsedTypeface, typeface)) {
            this.mCollapsedTypeface = typeface;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setExpandedBounds(int i, int i2, int i3, int i4) {
        if (!rectEquals(this.mExpandedBounds, i, i2, i3, i4)) {
            this.mExpandedBounds.set(i, i2, i3, i4);
            this.mBoundsChanged = true;
            onBoundsChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setExpandedTextAppearance(int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            this.mExpandedTextColor = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            this.mExpandedTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int) this.mExpandedTextSize);
        }
        this.mExpandedShadowColor = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        this.mExpandedShadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.mExpandedShadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.mExpandedShadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mExpandedTypeface = readFontFamilyTypeface(i);
        }
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public final void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.mExpandedTextColor != colorStateList) {
            this.mExpandedTextColor = colorStateList;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setExpandedTextGravity(int i) {
        if (this.mExpandedTextGravity != i) {
            this.mExpandedTextGravity = i;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setExpandedTextSize(float f) {
        if (this.mExpandedTextSize != f) {
            this.mExpandedTextSize = f;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setExpandedTypeface(Typeface typeface) {
        if (areTypefacesDifferent(this.mExpandedTypeface, typeface)) {
            this.mExpandedTypeface = typeface;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setExpansionFraction(float f) {
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (clamp != this.mExpandedFraction) {
            this.mExpandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setPositionInterpolator(Interpolator interpolator) {
        this.mPositionInterpolator = interpolator;
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public final boolean setState(int[] iArr) {
        this.mState = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.mTextToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public final void setTextSizeInterpolator(Interpolator interpolator) {
        this.mTextSizeInterpolator = interpolator;
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public final void setTypefaces(Typeface typeface) {
        this.mExpandedTypeface = typeface;
        this.mCollapsedTypeface = typeface;
        recalculate();
    }
}
