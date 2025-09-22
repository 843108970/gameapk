package com.lidroid.xutils;

import android.app.Activity;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.view.View;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.EventListenerManager;
import com.lidroid.xutils.view.ResLoader;
import com.lidroid.xutils.view.ViewFinder;
import com.lidroid.xutils.view.ViewInjectInfo;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.PreferenceInject;
import com.lidroid.xutils.view.annotation.ResInject;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.EventBase;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewUtils {
    private ViewUtils() {
    }

    public static void inject(Activity activity) {
        injectObject(activity, new ViewFinder(activity));
    }

    public static void inject(PreferenceActivity preferenceActivity) {
        injectObject(preferenceActivity, new ViewFinder(preferenceActivity));
    }

    public static void inject(View view) {
        injectObject(view, new ViewFinder(view));
    }

    public static void inject(Object obj, Activity activity) {
        injectObject(obj, new ViewFinder(activity));
    }

    public static void inject(Object obj, PreferenceActivity preferenceActivity) {
        injectObject(obj, new ViewFinder(preferenceActivity));
    }

    public static void inject(Object obj, PreferenceGroup preferenceGroup) {
        injectObject(obj, new ViewFinder(preferenceGroup));
    }

    public static void inject(Object obj, View view) {
        injectObject(obj, new ViewFinder(view));
    }

    private static void injectObject(Object obj, ViewFinder viewFinder) {
        int i;
        Method[] methodArr;
        Method method;
        ViewInjectInfo viewInjectInfo;
        Object obj2 = obj;
        ViewFinder viewFinder2 = viewFinder;
        Class<?> cls = obj.getClass();
        ContentView contentView = (ContentView) cls.getAnnotation(ContentView.class);
        boolean z = true;
        int i2 = 0;
        if (contentView != null) {
            try {
                cls.getMethod("setContentView", new Class[]{Integer.TYPE}).invoke(obj2, new Object[]{Integer.valueOf(contentView.value())});
            } catch (Throwable th) {
                Throwable th2 = th;
                LogUtils.e(th2.getMessage(), th2);
            }
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                ViewInject viewInject = (ViewInject) field.getAnnotation(ViewInject.class);
                if (viewInject != null) {
                    try {
                        View findViewById = viewFinder2.findViewById(viewInject.value(), viewInject.parentId());
                        if (findViewById != null) {
                            field.setAccessible(true);
                            field.set(obj2, findViewById);
                        }
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        LogUtils.e(th4.getMessage(), th4);
                    }
                } else {
                    ResInject resInject = (ResInject) field.getAnnotation(ResInject.class);
                    if (resInject != null) {
                        Object loadRes = ResLoader.loadRes(resInject.type(), viewFinder.getContext(), resInject.id());
                        if (loadRes != null) {
                            field.setAccessible(true);
                            field.set(obj2, loadRes);
                        }
                    } else {
                        PreferenceInject preferenceInject = (PreferenceInject) field.getAnnotation(PreferenceInject.class);
                        if (preferenceInject != null) {
                            Preference findPreference = viewFinder2.findPreference(preferenceInject.value());
                            if (findPreference != null) {
                                field.setAccessible(true);
                                field.set(obj2, findPreference);
                            }
                        }
                    }
                }
            }
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (declaredMethods != null && declaredMethods.length > 0) {
            int length = declaredMethods.length;
            int i3 = 0;
            while (i3 < length) {
                Method method2 = declaredMethods[i3];
                Annotation[] declaredAnnotations = method2.getDeclaredAnnotations();
                if (declaredAnnotations != null && declaredAnnotations.length > 0) {
                    int length2 = declaredAnnotations.length;
                    int i4 = 0;
                    while (i4 < length2) {
                        Annotation annotation = declaredAnnotations[i4];
                        Class<? extends Annotation> annotationType = annotation.annotationType();
                        if (annotationType.getAnnotation(EventBase.class) != null) {
                            method2.setAccessible(z);
                            try {
                                Method declaredMethod = annotationType.getDeclaredMethod("value", new Class[i2]);
                                try {
                                    method = annotationType.getDeclaredMethod("parentId", new Class[i2]);
                                } catch (Throwable unused) {
                                    method = null;
                                }
                                Object invoke = declaredMethod.invoke(annotation, new Object[i2]);
                                Object invoke2 = method == null ? null : method.invoke(annotation, new Object[i2]);
                                int length3 = invoke2 == null ? 0 : Array.getLength(invoke2);
                                int length4 = Array.getLength(invoke);
                                while (i2 < length4) {
                                    methodArr = declaredMethods;
                                    try {
                                        viewInjectInfo = new ViewInjectInfo();
                                        i = length;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i = length;
                                        Throwable th6 = th;
                                        LogUtils.e(th6.getMessage(), th6);
                                        i4++;
                                        declaredMethods = methodArr;
                                        length = i;
                                        z = true;
                                        i2 = 0;
                                    }
                                    try {
                                        viewInjectInfo.value = Array.get(invoke, i2);
                                        viewInjectInfo.parentId = length3 > i2 ? ((Integer) Array.get(invoke2, i2)).intValue() : 0;
                                        EventListenerManager.addEventMethod(viewFinder2, viewInjectInfo, annotation, obj2, method2);
                                        i2++;
                                        declaredMethods = methodArr;
                                        length = i;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        Throwable th62 = th;
                                        LogUtils.e(th62.getMessage(), th62);
                                        i4++;
                                        declaredMethods = methodArr;
                                        length = i;
                                        z = true;
                                        i2 = 0;
                                    }
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                methodArr = declaredMethods;
                                i = length;
                                Throwable th622 = th;
                                LogUtils.e(th622.getMessage(), th622);
                                i4++;
                                declaredMethods = methodArr;
                                length = i;
                                z = true;
                                i2 = 0;
                            }
                        }
                        methodArr = declaredMethods;
                        i = length;
                        i4++;
                        declaredMethods = methodArr;
                        length = i;
                        z = true;
                        i2 = 0;
                    }
                }
                i3++;
                declaredMethods = declaredMethods;
                length = length;
                z = true;
                i2 = 0;
            }
        }
    }
}
