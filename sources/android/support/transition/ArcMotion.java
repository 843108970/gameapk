package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = ((float) Math.tan(Math.toRadians(35.0d)));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
    private float mMaximumTangent = DEFAULT_MAX_TANGENT;
    private float mMinimumHorizontalAngle = 0.0f;
    private float mMinimumHorizontalTangent = 0.0f;
    private float mMinimumVerticalAngle = 0.0f;
    private float mMinimumVerticalTangent = 0.0f;

    public ArcMotion() {
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }

    private static float toTangent(float f) {
        if (f >= 0.0f && f <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    public Path getPath(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Path path = new Path();
        path.moveTo(f, f2);
        float f11 = f3 - f;
        float f12 = f4 - f2;
        float f13 = (f11 * f11) + (f12 * f12);
        float f14 = (f + f3) / 2.0f;
        float f15 = (f2 + f4) / 2.0f;
        float f16 = 0.25f * f13;
        boolean z = f2 > f4;
        if (Math.abs(f11) < Math.abs(f12)) {
            float abs = Math.abs(f13 / (f12 * 2.0f));
            if (z) {
                f5 = abs + f4;
                f6 = f3;
            } else {
                f5 = abs + f2;
                f6 = f;
            }
            f7 = this.mMinimumVerticalTangent * f16;
            f8 = this.mMinimumVerticalTangent;
        } else {
            float f17 = f13 / (f11 * 2.0f);
            if (z) {
                f10 = f2;
                f9 = f17 + f;
            } else {
                f9 = f3 - f17;
                f10 = f4;
            }
            f7 = this.mMinimumHorizontalTangent * f16;
            f8 = this.mMinimumHorizontalTangent;
        }
        float f18 = f7 * f8;
        float f19 = f14 - f6;
        float f20 = f15 - f5;
        float f21 = (f19 * f19) + (f20 * f20);
        float f22 = f16 * this.mMaximumTangent * this.mMaximumTangent;
        if (f21 >= f18) {
            f18 = f21 > f22 ? f22 : 0.0f;
        }
        if (f18 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f18 / f21));
            f6 = ((f6 - f14) * sqrt) + f14;
            f5 = f15 + (sqrt * (f5 - f15));
        }
        path.cubicTo((f + f6) / 2.0f, (f2 + f5) / 2.0f, (f6 + f3) / 2.0f, (f5 + f4) / 2.0f, f3, f4);
        return path;
    }

    public void setMaximumAngle(float f) {
        this.mMaximumAngle = f;
        this.mMaximumTangent = toTangent(f);
    }

    public void setMinimumHorizontalAngle(float f) {
        this.mMinimumHorizontalAngle = f;
        this.mMinimumHorizontalTangent = toTangent(f);
    }

    public void setMinimumVerticalAngle(float f) {
        this.mMinimumVerticalAngle = f;
        this.mMinimumVerticalTangent = toTangent(f);
    }
}
