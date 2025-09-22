package com.b.a.a.a;

import com.b.a.ao;
import com.b.a.as;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final ao f571a;

    /* renamed from: b  reason: collision with root package name */
    public final as f572b;

    d(ao aoVar, as asVar) {
        this.f571a = aoVar;
        this.f572b = asVar;
    }

    public static boolean a(as asVar, ao aoVar) {
        switch (asVar.b()) {
            case 200:
            case SET_BOTTON_VALUE:
            case SET_RADIO_GROUP_VALUE:
            case 300:
            case SET_ENABLED_VALUE:
            case 308:
            case GET_TEXT_VALUE:
            case GET_BACKCOLOR_VALUE:
            case GET_FW_VISIBLE_VALUE:
            case 414:
            case SET_WINDOW_GRAVITY_VALUE:
                break;
            case SET_VISIBLE_VALUE:
            case 307:
                if (asVar.a("Expires") == null && asVar.g().c() == -1 && !asVar.g().e() && !asVar.g().d()) {
                    return false;
                }
            default:
                return false;
        }
        return !asVar.g().b() && !aoVar.f().b();
    }
}
