package android.support.transition;

import android.animation.LayoutTransition;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(14)
class ViewGroupUtilsApi14 implements ViewGroupUtilsImpl {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    ViewGroupUtilsApi14() {
    }

    private static void cancelLayoutTransition(LayoutTransition layoutTransition) {
        if (!sCancelMethodFetched) {
            try {
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                sCancelMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i(TAG, "Failed to access cancel method by reflection");
            }
            sCancelMethodFetched = true;
        }
        if (sCancelMethod != null) {
            try {
                sCancelMethod.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i(TAG, "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i(TAG, "Failed to invoke cancel method by reflection");
            }
        }
    }

    public ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return ViewGroupOverlayApi14.createFrom(viewGroup);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void suppressLayout(@android.support.annotation.NonNull android.view.ViewGroup r6, boolean r7) {
        /*
            r5 = this;
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x0028
            android.support.transition.ViewGroupUtilsApi14$1 r0 = new android.support.transition.ViewGroupUtilsApi14$1
            r0.<init>()
            sEmptyLayoutTransition = r0
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            r4 = 4
            r0.setAnimator(r4, r3)
        L_0x0028:
            if (r7 == 0) goto L_0x0048
            android.animation.LayoutTransition r7 = r6.getLayoutTransition()
            if (r7 == 0) goto L_0x0042
            boolean r0 = r7.isRunning()
            if (r0 == 0) goto L_0x0039
            cancelLayoutTransition(r7)
        L_0x0039:
            android.animation.LayoutTransition r0 = sEmptyLayoutTransition
            if (r7 == r0) goto L_0x0042
            int r0 = android.support.transition.R.id.transition_layout_save
            r6.setTag(r0, r7)
        L_0x0042:
            android.animation.LayoutTransition r7 = sEmptyLayoutTransition
            r6.setLayoutTransition(r7)
            return
        L_0x0048:
            r6.setLayoutTransition(r3)
            boolean r7 = sLayoutSuppressedFieldFetched
            if (r7 != 0) goto L_0x0066
            java.lang.Class<android.view.ViewGroup> r7 = android.view.ViewGroup.class
            java.lang.String r0 = "mLayoutSuppressed"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x005d }
            sLayoutSuppressedField = r7     // Catch:{ NoSuchFieldException -> 0x005d }
            r7.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x005d }
            goto L_0x0064
        L_0x005d:
            java.lang.String r7 = "ViewGroupUtilsApi14"
            java.lang.String r0 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r7, r0)
        L_0x0064:
            sLayoutSuppressedFieldFetched = r1
        L_0x0066:
            java.lang.reflect.Field r7 = sLayoutSuppressedField
            if (r7 == 0) goto L_0x0083
            java.lang.reflect.Field r7 = sLayoutSuppressedField     // Catch:{ IllegalAccessException -> 0x007c }
            boolean r7 = r7.getBoolean(r6)     // Catch:{ IllegalAccessException -> 0x007c }
            if (r7 == 0) goto L_0x007a
            java.lang.reflect.Field r0 = sLayoutSuppressedField     // Catch:{ IllegalAccessException -> 0x0078 }
            r0.setBoolean(r6, r2)     // Catch:{ IllegalAccessException -> 0x0078 }
            goto L_0x007a
        L_0x0078:
            r2 = r7
            goto L_0x007c
        L_0x007a:
            r2 = r7
            goto L_0x0083
        L_0x007c:
            java.lang.String r7 = "ViewGroupUtilsApi14"
            java.lang.String r0 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r7, r0)
        L_0x0083:
            if (r2 == 0) goto L_0x0088
            r6.requestLayout()
        L_0x0088:
            int r7 = android.support.transition.R.id.transition_layout_save
            java.lang.Object r7 = r6.getTag(r7)
            android.animation.LayoutTransition r7 = (android.animation.LayoutTransition) r7
            if (r7 == 0) goto L_0x009a
            int r0 = android.support.transition.R.id.transition_layout_save
            r6.setTag(r0, r3)
            r6.setLayoutTransition(r7)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewGroupUtilsApi14.suppressLayout(android.view.ViewGroup, boolean):void");
    }
}
