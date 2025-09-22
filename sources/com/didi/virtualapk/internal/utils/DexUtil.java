package com.didi.virtualapk.internal.utils;

import android.app.ActivityThread;
import android.os.Build;
import com.didi.virtualapk.internal.Constants;
import com.didi.virtualapk.utils.Reflector;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;

public class DexUtil {
    private static boolean sHasInsertedNativeLibrary = false;

    private static Object combineArray(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Object newInstance = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    private static Object getDexElements(Object obj) throws Exception {
        return Reflector.with(obj).field("dexElements").get();
    }

    private static Object getPathList(ClassLoader classLoader) throws Exception {
        return Reflector.with(classLoader).field("pathList").get();
    }

    public static void insertDex(DexClassLoader dexClassLoader, ClassLoader classLoader, File file) throws Exception {
        Reflector.with(getPathList(classLoader)).field("dexElements").set(combineArray(getDexElements(getPathList(classLoader)), getDexElements(getPathList(dexClassLoader))));
        insertNativeLibrary(dexClassLoader, classLoader, file);
    }

    private static synchronized void insertNativeLibrary(DexClassLoader dexClassLoader, ClassLoader classLoader, File file) throws Exception {
        synchronized (DexUtil.class) {
            if (!sHasInsertedNativeLibrary) {
                sHasInsertedNativeLibrary = true;
                ActivityThread.currentApplication();
                Object pathList = getPathList(classLoader);
                int i = 0;
                if (Build.VERSION.SDK_INT > 22) {
                    Reflector with = Reflector.with(pathList);
                    ((List) with.field("nativeLibraryDirectories").get()).add(file);
                    Object obj = with.field("nativeLibraryPathElements").get();
                    int length = Array.getLength(obj);
                    Object obj2 = with.get(getPathList(dexClassLoader));
                    Class<?> componentType = obj2.getClass().getComponentType();
                    Object newInstance = Array.newInstance(componentType, length + 1);
                    System.arraycopy(obj, 0, newInstance, 0, length);
                    Field declaredField = componentType.getDeclaredField(Build.VERSION.SDK_INT >= 26 ? "path" : "dir");
                    declaredField.setAccessible(true);
                    int length2 = Array.getLength(obj2);
                    while (true) {
                        if (i >= length2) {
                            break;
                        }
                        Object obj3 = Array.get(obj2, i);
                        if (((File) declaredField.get(obj3)).getAbsolutePath().contains(Constants.NATIVE_DIR)) {
                            Array.set(newInstance, length, obj3);
                            break;
                        }
                        i++;
                    }
                    with.set(newInstance);
                    return;
                }
                Reflector field = Reflector.with(pathList).field("nativeLibraryDirectories");
                File[] fileArr = (File[]) field.get();
                int length3 = fileArr.length;
                File[] fileArr2 = new File[(length3 + 1)];
                System.arraycopy(fileArr, 0, fileArr2, 0, length3);
                fileArr2[length3] = file;
                field.set(fileArr2);
            }
        }
    }
}
