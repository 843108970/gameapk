package com.cyjh.event.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.cyjh.event.accessibility.a;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;

public class Cservice extends AccessibilityService {

    /* renamed from: a  reason: collision with root package name */
    public static Cservice f2360a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2361b = getClass().getName();

    @RequiresApi(api = 14)
    private static AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, @NonNull a... aVarArr) {
        boolean z;
        if (accessibilityNodeInfo == null) {
            return null;
        }
        if (aVarArr.length == 0) {
            throw new InvalidParameterException("AbstractTF不允许传空");
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if (child != null) {
                int length = aVarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    } else if (!aVarArr[i2].a(child)) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return child;
                }
                AccessibilityNodeInfo a2 = a(child, aVarArr);
                child.recycle();
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    @Nullable
    @RequiresApi(api = 16)
    private AccessibilityNodeInfo a(@NonNull a... aVarArr) {
        AccessibilityNodeInfo a2;
        boolean z;
        if (aVarArr.length == 0) {
            throw new InvalidParameterException("AbstractTF不允许传空");
        }
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        if (rootInActiveWindow == null) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            if (aVarArr[i3] instanceof a.d) {
                i++;
                i2 = i3;
            }
        }
        switch (i) {
            case 0:
                a2 = a(rootInActiveWindow, aVarArr);
                break;
            case 1:
                if (aVarArr.length == 1) {
                    a2 = ((a.d) aVarArr[i2]).b(rootInActiveWindow);
                    break;
                } else {
                    List<AccessibilityNodeInfo> c2 = ((a.d) aVarArr[i2]).c(rootInActiveWindow);
                    if (c2 == null || c2.size() == 0) {
                        rootInActiveWindow.recycle();
                        return null;
                    }
                    for (AccessibilityNodeInfo next : c2) {
                        if (accessibilityNodeInfo == null) {
                            int length = aVarArr.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= length) {
                                    z = true;
                                } else if (!aVarArr[i4].a(next)) {
                                    z = false;
                                } else {
                                    i4++;
                                }
                            }
                            if (z) {
                                accessibilityNodeInfo = next;
                            }
                        }
                        next.recycle();
                    }
                    rootInActiveWindow.recycle();
                    return accessibilityNodeInfo;
                }
                break;
            default:
                throw new RuntimeException("由于时间有限，并且多了也没什么用，所以IdTF和TextTF只能有一个");
        }
        rootInActiveWindow.recycle();
        return a2;
    }

    public static String a(int i) {
        return (i < 7 || i > 16) ? (i < 29 || i > 54) ? i == 17 ? Marker.ANY_MARKER : i == 18 ? "#" : i == 55 ? "," : i == 56 ? "." : i == 68 ? "`" : i == 69 ? "-" : i == 70 ? "=" : i == 71 ? "[" : i == 72 ? "]" : i == 73 ? "\\" : i == 74 ? ";" : i == 75 ? "'" : i == 76 ? "/" : i == 77 ? "@" : "" : String.valueOf((char) (i + 36)) : Integer.toString(i - 7);
    }

    @RequiresApi(24)
    private void a(int i, int i2) {
        Path path = new Path();
        float f = (float) (i - 1);
        float f2 = (float) (i2 - 1);
        path.moveTo(f, f2);
        float f3 = (float) i;
        path.lineTo(f3, f2);
        float f4 = (float) i2;
        path.lineTo(f3, f4);
        path.lineTo(f, f4);
        dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0, 1000)).build(), (AccessibilityService.GestureResultCallback) null, (Handler) null);
    }

    @RequiresApi(api = 24)
    private void a(int i, int i2, int i3, int i4, int i5) {
        Path path = new Path();
        path.moveTo((float) i, (float) i2);
        path.lineTo((float) i3, (float) i4);
        a(path, (long) i5);
    }

    private void a(int i, Context context) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (i != 26) {
            switch (i) {
                case 3:
                    performGlobalAction(2);
                    return;
                case 4:
                    performGlobalAction(1);
                    return;
                default:
                    if (!a(i).isEmpty()) {
                        a(a(i), context);
                        return;
                    }
                    return;
            }
        } else {
            performGlobalAction(6);
        }
    }

    @RequiresApi(api = 14)
    private static void a(List<AccessibilityNodeInfo> list) {
        if (list != null && list.size() != 0) {
            for (AccessibilityNodeInfo recycle : list) {
                recycle.recycle();
            }
        }
    }

    @RequiresApi(api = 14)
    private static void a(List<AccessibilityNodeInfo> list, AccessibilityNodeInfo accessibilityNodeInfo, @NonNull a... aVarArr) {
        boolean z;
        if (accessibilityNodeInfo != null && list != null) {
            if (aVarArr.length == 0) {
                throw new InvalidParameterException("AbstractTF不允许传空");
            }
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
                if (child != null) {
                    int length = aVarArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (!aVarArr[i2].a(child)) {
                            z = false;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z) {
                        list.add(child);
                    } else {
                        a(list, child, aVarArr);
                        child.recycle();
                    }
                }
            }
        }
    }

    public static boolean a() {
        return f2360a != null;
    }

    @RequiresApi(api = 14)
    private static boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            accessibilityNodeInfo.performAction(16);
            return true;
        }
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        if (parent == null) {
            return false;
        }
        boolean a2 = a(parent);
        parent.recycle();
        return a2;
    }

    @RequiresApi(api = 14)
    private boolean a(AccessibilityNodeInfo accessibilityNodeInfo, String str, Context context) {
        if (accessibilityNodeInfo.getChildCount() != 0) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null) {
                    a(accessibilityNodeInfo.getChild(i), str, context);
                }
            }
        } else if (accessibilityNodeInfo != null && accessibilityNodeInfo.isFocused() && accessibilityNodeInfo.getClassName().toString().compareTo(a.i) == 0) {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("复制", str));
            accessibilityNodeInfo.performAction(1);
            accessibilityNodeInfo.performAction(32768);
            accessibilityNodeInfo.recycle();
            return true;
        }
        return false;
    }

    @RequiresApi(api = 16)
    @NonNull
    private List<AccessibilityNodeInfo> b(@NonNull a... aVarArr) {
        boolean z;
        if (aVarArr.length == 0) {
            throw new InvalidParameterException("AbstractTF不允许传空");
        }
        ArrayList arrayList = new ArrayList();
        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return arrayList;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            if (aVarArr[i3] instanceof a.d) {
                i++;
                i2 = i3;
            }
        }
        switch (i) {
            case 0:
                a((List<AccessibilityNodeInfo>) arrayList, rootInActiveWindow, aVarArr);
                break;
            case 1:
                List<AccessibilityNodeInfo> c2 = ((a.d) aVarArr[i2]).c(rootInActiveWindow);
                if (!(c2 == null || c2.size() == 0)) {
                    if (aVarArr.length != 1) {
                        for (AccessibilityNodeInfo next : c2) {
                            int length = aVarArr.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= length) {
                                    z = true;
                                } else if (!aVarArr[i4].a(next)) {
                                    z = false;
                                } else {
                                    i4++;
                                }
                            }
                            if (z) {
                                arrayList.add(next);
                            } else {
                                next.recycle();
                            }
                        }
                        break;
                    } else {
                        arrayList.addAll(c2);
                        break;
                    }
                }
            default:
                throw new RuntimeException("由于时间有限，并且多了也没什么用，所以IdTF和TextTF只能有一个");
        }
        rootInActiveWindow.recycle();
        return arrayList;
    }

    @RequiresApi(24)
    private void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = a.f2362c;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        a(rect.centerX(), rect.centerY(), 100);
    }

    private AccessibilityNodeInfo[] b() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            for (AccessibilityWindowInfo root : getWindows()) {
                AccessibilityNodeInfo root2 = root.getRoot();
                if (root2 != null) {
                    arrayList.add(root2);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 16) {
            arrayList.add(getRootInActiveWindow());
        }
        return (AccessibilityNodeInfo[]) arrayList.toArray(new AccessibilityNodeInfo[arrayList.size()]);
    }

    @RequiresApi(24)
    public final void a(int i, int i2, int i3) {
        Path path = new Path();
        path.moveTo((float) (i - 1), (float) (i2 - 1));
        path.lineTo((float) (i + 1), (float) (i2 + 1));
        dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 50, (long) i3)).build(), (AccessibilityService.GestureResultCallback) null, (Handler) null);
    }

    @RequiresApi(24)
    public final void a(Path path, long j) {
        dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0, j)).build(), (AccessibilityService.GestureResultCallback) null, (Handler) null);
    }

    public final void a(String str, Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21) {
                for (AccessibilityWindowInfo root : getWindows()) {
                    AccessibilityNodeInfo root2 = root.getRoot();
                    if (root2 != null) {
                        arrayList.add(root2);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                arrayList.add(getRootInActiveWindow());
            }
            AccessibilityNodeInfo[] accessibilityNodeInfoArr = (AccessibilityNodeInfo[]) arrayList.toArray(new AccessibilityNodeInfo[arrayList.size()]);
            int length = accessibilityNodeInfoArr.length;
            int i = 0;
            while (i < length && !a(accessibilityNodeInfoArr[i], str, context)) {
                i++;
            }
        }
    }

    @RequiresApi(api = 16)
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    public void onDestroy() {
        super.onDestroy();
        f2360a = null;
    }

    public void onInterrupt() {
        f2360a = null;
    }

    /* access modifiers changed from: protected */
    public boolean onKeyEvent(KeyEvent keyEvent) {
        PrintStream printStream = System.out;
        printStream.println("哈哈哈哈" + keyEvent);
        return super.onKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onServiceConnected() {
        super.onServiceConnected();
        f2360a = this;
    }
}
