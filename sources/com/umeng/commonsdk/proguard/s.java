package com.umeng.commonsdk.proguard;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3816a = "um_pri";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3817b = "um_common_strength";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3818c = "um_common_battery";

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
        }
        if (UMUtils.checkPermission(context, "android.permission.BLUETOOTH")) {
            return BluetoothAdapter.getDefaultAdapter().getAddress();
        }
        return null;
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context != null && !TextUtils.isEmpty(str) && (sharedPreferences = context.getApplicationContext().getSharedPreferences(f3816a, 0)) != null) {
            sharedPreferences.edit().putString(f3817b, str).commit();
        }
    }

    public static String b(Context context) {
        if (context == null || !UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
    }

    public static void b(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context != null && !TextUtils.isEmpty(str) && (sharedPreferences = context.getApplicationContext().getSharedPreferences(f3816a, 0)) != null) {
            sharedPreferences.edit().putString(f3818c, str).commit();
        }
    }

    public static String c(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 23 || !UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Class<?> cls = telephonyManager.getClass();
            if (((Integer) cls.getMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue() != 2) {
                return null;
            }
            return (String) cls.getMethod("getDeviceId", new Class[]{Integer.TYPE}).invoke(telephonyManager, new Object[]{2});
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject;
        String str;
        long j;
        if (context == null || !UMUtils.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        CellLocation cellLocation = telephonyManager.getCellLocation();
        int phoneType = telephonyManager.getPhoneType();
        if (phoneType == 1 && (cellLocation instanceof GsmCellLocation)) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            int cid = gsmCellLocation.getCid();
            if (cid <= 0 || cid == 65535) {
                return null;
            }
            int lac = gsmCellLocation.getLac();
            jSONObject = new JSONObject();
            try {
                jSONObject.put("cid", cid);
                jSONObject.put("lacid", lac);
                str = "ts";
                j = System.currentTimeMillis();
            } catch (Exception unused) {
            }
        } else if (phoneType != 2 || !(cellLocation instanceof CdmaCellLocation)) {
            return null;
        } else {
            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
            int baseStationId = cdmaCellLocation.getBaseStationId();
            int networkId = cdmaCellLocation.getNetworkId();
            jSONObject = new JSONObject();
            jSONObject.put("cid", baseStationId);
            jSONObject.put("lacid", networkId);
            str = "ts";
            j = System.currentTimeMillis();
        }
        jSONObject.put(str, j);
        return jSONObject;
    }

    public static String e(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f3816a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f3817b, (String) null);
    }

    public static String f(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f3816a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f3818c, (String) null);
    }

    public static JSONArray g(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            for (Sensor next : ((SensorManager) context.getSystemService(v.W)).getSensorList(-1)) {
                if (next != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("a_type", next.getType());
                        jSONObject.put("a_ven", next.getVendor());
                        if (Build.VERSION.SDK_INT >= 24) {
                            jSONObject.put("a_id", next.getId());
                        }
                        jSONObject.put("a_na", next.getName());
                        jSONObject.put("a_ver", next.getVersion());
                        jSONObject.put("a_mar", (double) next.getMaximumRange());
                        jSONObject.put("a_ver", next.getVersion());
                        jSONObject.put("a_res", (double) next.getResolution());
                        jSONObject.put("a_po", (double) next.getPower());
                        if (Build.VERSION.SDK_INT >= 9) {
                            jSONObject.put("a_mid", next.getMinDelay());
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            jSONObject.put("a_mad", next.getMaxDelay());
                        }
                        jSONObject.put("ts", System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }
}
