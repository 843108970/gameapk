package com.hlzn.socketclient;

import android.text.TextUtils;
import com.hlzn.socketclient.f.d;
import com.hlzn.socketclient.service.SocketService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f3441a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, d> f3442b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public SocketService f3443c;

    public e(SocketService socketService) {
        this.f3443c = socketService;
    }

    private void b(String str) {
        if (str != null) {
            if (!this.f3442b.containsKey(str)) {
                this.f3442b.put(str, new d(this.f3443c, str));
            }
            String str2 = this.f3441a;
            d.b(str2, "add --> 添加消息到发送超时管理器 rpcId=" + str);
        }
    }

    public final synchronized void a() {
        for (Map.Entry<String, d> value : this.f3442b.entrySet()) {
            ((d) value.getValue()).cancel();
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f3441a;
            d.b(str2, "remove --> 从发送消息管理器移除消息 rpcId=" + str);
            d remove = this.f3442b.remove(str);
            if (remove != null) {
                remove.cancel();
            }
        }
    }
}
