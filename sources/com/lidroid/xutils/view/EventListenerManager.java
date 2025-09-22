package com.lidroid.xutils.view;

import android.view.View;
import com.lidroid.xutils.util.DoubleKeyValueMap;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.event.EventBase;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class EventListenerManager {
    private static final DoubleKeyValueMap<ViewInjectInfo, Class<?>, Object> listenerCache = new DoubleKeyValueMap<>();

    public static class DynamicHandler implements InvocationHandler {
        private WeakReference<Object> handlerRef;
        private final HashMap<String, Method> methodMap = new HashMap<>(1);

        public DynamicHandler(Object obj) {
            this.handlerRef = new WeakReference<>(obj);
        }

        public void addMethod(String str, Method method) {
            this.methodMap.put(str, method);
        }

        public Object getHandler() {
            return this.handlerRef.get();
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Method method2;
            Object obj2 = this.handlerRef.get();
            if (obj2 == null || (method2 = this.methodMap.get(method.getName())) == null) {
                return null;
            }
            return method2.invoke(obj2, objArr);
        }

        public void setHandler(Object obj) {
            this.handlerRef = new WeakReference<>(obj);
        }
    }

    private EventListenerManager() {
    }

    public static void addEventMethod(ViewFinder viewFinder, ViewInjectInfo viewInjectInfo, Annotation annotation, Object obj, Method method) {
        boolean z;
        try {
            View findViewByInfo = viewFinder.findViewByInfo(viewInjectInfo);
            if (findViewByInfo != null) {
                EventBase eventBase = (EventBase) annotation.annotationType().getAnnotation(EventBase.class);
                Class<?> listenerType = eventBase.listenerType();
                String listenerSetter = eventBase.listenerSetter();
                String methodName = eventBase.methodName();
                Object obj2 = listenerCache.get(viewInjectInfo, listenerType);
                if (obj2 != null) {
                    DynamicHandler dynamicHandler = (DynamicHandler) Proxy.getInvocationHandler(obj2);
                    z = obj.equals(dynamicHandler.getHandler());
                    if (z) {
                        dynamicHandler.addMethod(methodName, method);
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    DynamicHandler dynamicHandler2 = new DynamicHandler(obj);
                    dynamicHandler2.addMethod(methodName, method);
                    obj2 = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class[]{listenerType}, dynamicHandler2);
                    listenerCache.put(viewInjectInfo, listenerType, obj2);
                }
                findViewByInfo.getClass().getMethod(listenerSetter, new Class[]{listenerType}).invoke(findViewByInfo, new Object[]{obj2});
            }
        } catch (Throwable th) {
            LogUtils.e(th.getMessage(), th);
        }
    }
}
