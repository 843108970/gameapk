package mobi.oneway.export.f;

import java.util.HashMap;
import java.util.Map;

public class f {
    public static String a() {
        HashMap hashMap = new HashMap();
        hashMap.put("2", "com.qq.e.ads.ADActivity");
        hashMap.put("3", "com.baidu.mobads.AppActivity");
        hashMap.put("4", "com.bytedance.sdk.openadsdk.multipro.TTMultiProvider");
        hashMap.put("5", "com.yomob.tgsdklib.TGVideoActivity");
        hashMap.put("6", "com.mintegral.msdk.activity.MTGCommonActivity");
        hashMap.put("7", "com.shenqi.sdk.AdActivity");
        hashMap.put("8", "com.sigmob.sdk.base.common.AdActivity");
        hashMap.put("9", "com.vungle.warren.ui.VungleActivity");
        hashMap.put("10", "com.yomob.yomobads.AdActivity");
        hashMap.put("11", "com.kwad.sdk.api.proxy.app.KsRewardVideoActivity");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                Class.forName((String) entry.getValue());
                sb.append(((String) entry.getKey()) + ",");
            } catch (ClassNotFoundException unused) {
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
