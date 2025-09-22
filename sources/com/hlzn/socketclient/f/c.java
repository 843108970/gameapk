package com.hlzn.socketclient.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.hlzn.socketclient.b.a;
import com.hlzn.socketclient.bean.ServiceParam;
import com.hlzn.socketclient.service.SocketService;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3449a = "c";

    private static Intent a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        ResolveInfo resolveInfo = null;
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            return null;
        }
        if (queryIntentServices.size() > 1) {
            for (ResolveInfo next : queryIntentServices) {
                if (next.serviceInfo.packageName.equals(context.getPackageName())) {
                    resolveInfo = next;
                }
            }
        } else {
            resolveInfo = queryIntentServices.get(0);
        }
        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    public static void a(Context context, String str) {
        a(context, str, (ServiceParam) null);
    }

    public static void a(Context context, String str, ServiceParam serviceParam) {
        Intent intent = new Intent(a(context, new Intent(context, SocketService.class)));
        intent.putExtra(a.n, str);
        if (serviceParam != null) {
            intent.putExtra(a.o, serviceParam);
        }
        context.startService(intent);
        String str2 = f3449a;
        d.b(str2, "toSocketService --> serviceTag=" + str);
    }
}
