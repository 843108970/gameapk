package com.cyjh.elfin.a;

import android.content.Context;
import android.os.Environment;
import com.cyjh.common.util.a;
import com.cyjh.elfin.base.AppContext;
import java.io.File;
import java.io.IOException;

public final class b {
    public static final String A = "network_file_is_exist";
    public static final String B = "template_apk_req";
    public static final String C = "single_apk_req";
    public static final String D = "server_time";
    public static final String E = "server_time_successful";
    public static final String F = "last_ad_id";
    public static final String G = "last_ad_link_url";
    public static final String H = "last_ad_link_type";
    public static final String I = "last_ad_jump_linkurl";
    public static final String J = "last_ad_title";
    public static final String K = "5000820";
    public static final boolean L = true;
    public static final boolean M = false;
    public static final String N = "1031278";
    public static final String O = "andzjjlkp01";
    public static final String P = "ANDFZLBDAPI816";
    public static final String Q = "RBKOKIXWV";
    public static final String R = "com.cyjh.mobileanjian";
    public static final String S = "redirect";
    public static final String T = "download";
    public static final String U = "redownload";
    public static final String V = "SDK20191519030326wbwdvdccwn8sye8";
    public static final String W = "POSIDe5v7yvk0jx0m";
    public static final String X = ".gif";
    public static final String Y = "http";
    public static final String Z = "1";

    /* renamed from: a  reason: collision with root package name */
    public static final String f1841a = "APP";
    public static final String aa = "2";
    public static final String ab = a.c(AppContext.a());
    public static final String ac = "deviceid";
    public static final String ad = "5e1f6df6cc024c80b7e8b86dc670c100";
    public static final String ae = "101477";
    public static final String af = "101478";
    public static final String ag = "589ac20e";
    public static final String ah = "F4F04588C1076DA9017964B229D657DA";
    public static final String ai = "94CCB814573108BFBD19D8E2BB45AEE0";
    public static final String aj = "9312C6DA2448C84DB3C4FE8F66E2B394";
    public static final int ak = 10000;
    public static final String al = "has_load_splash_first_ad";
    public static final String am = "has_load_splash_second_ad";
    public static final String an = "has_load_bottom_ad";
    public static final String ao = "2xg8d8ga3z";
    public static final String ap = "b1214d0324681928";
    public static final String aq = "9292308";
    public static final String ar = "9732310";
    public static String as = "script";
    public static String at = ".config";
    public static String au = "assets";
    public static int av = 60;
    public static final int aw = 36;
    public static final String ax = "110";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1842b = "android";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1843c = "msg_data";
    public static final String d = "Message";
    public static final String e = "red_dot_flag";
    public static final String f = "small_red_dot";
    public static final int g = 1;
    public static final int h = 2;
    public static int i = 2;
    public static final String j = "ad_old_id";
    public static final String k = "ad_new_id";
    public static final String l = "new_jump_link";
    public static final String m = "old_jump_link";
    public static final String n = "ad_is_first";
    public static final String o = "is_touch_clicker";
    public static final String p = "is_touch_clicker";
    public static final String q = "id_description";
    public static final String r = "is_clicker_description";
    public static final String s = "default_entry_games";
    public static final String t = "recommend_games_link";
    public static final String u = "app-release.apk";
    public static final int v = 1;
    public static final String w = "com.cyjh.gundam";
    public static final String x = "http://down.nishuoa.com/fengwocps.apk";
    public static final String y = "youxifengwo.apk";
    public static final String z = "save_network_message";

    private static File a() {
        File file = new File(a(AppContext.a()), "NetworkMessage");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "NetworkReqLog.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
                return file2;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return file2;
    }

    public static final String a(Context context) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getPackageName();
    }

    private static File b() {
        File file = new File(a(AppContext.a()), "ErrorMessage");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "xiaomi4.txt");
    }

    private static File b(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        File file = new File(a(context), "adimg");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "pic");
    }

    private static File c(Context context) {
        File file = new File(a(context), "Info");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "device_id");
    }
}
