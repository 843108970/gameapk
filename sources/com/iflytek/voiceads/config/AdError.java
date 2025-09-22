package com.iflytek.voiceads.config;

import com.iflytek.voiceads.a.a;

public class AdError extends Exception {
    private static final int TIP_ACTIVITY_FINISH = 12;
    private static final int TIP_INVALID_AD_UNIT_ID = 5;
    private static final int TIP_INVALID_REQUEST = 3;
    private static final int TIP_NETWORK_ERROR = 1;
    private static final int TIP_NO_FILL = 4;
    private static final int TIP_OVER_REQUEST_NUM = 8;
    private static final int TIP_PAGE_LOAD_ERROR = 10;
    private static final int TIP_PAGE_LOAD_TIMEOUT = 9;
    private static final int TIP_PERMISSION_ERROR = 6;
    private static final int TIP_SERVER_ERROR = 2;
    private static final int TIP_SUCCESS = 0;
    private static final int TIP_UNKNOWN_ERROR = 7;
    private static final int TIP_VIDEO_CACHE = 11;
    private String mDescription = "";
    private int mErrorCode;

    public AdError(int i) {
        int i2;
        this.mErrorCode = i;
        int i3 = this.mErrorCode;
        if (i3 == 70200) {
            i2 = 0;
        } else if (i3 != 70204) {
            if (i3 != 70400) {
                if (i3 == 70403) {
                    i2 = 8;
                } else if (i3 != 70500) {
                    switch (i3) {
                        case ErrorCode.ERROR_INVALID_REQUEST /*71002*/:
                            i2 = 3;
                            break;
                        case ErrorCode.ERROR_NETWORK /*71003*/:
                            i2 = 1;
                            break;
                        case ErrorCode.ERROR_PERMISSION_NOT_SET /*71004*/:
                            i2 = 6;
                            break;
                        case ErrorCode.ERROR_EMPTY_ADUNITID /*71005*/:
                            break;
                        case ErrorCode.ERROR_PAGE_LOAD_TIMEOUT /*71006*/:
                            i2 = 9;
                            break;
                        case ErrorCode.ERROR_PAGE_LOAD_ERROR /*71007*/:
                            i2 = 10;
                            break;
                        case ErrorCode.ERROR_VIDEO_CACHE /*71008*/:
                            i2 = 11;
                            break;
                        case ErrorCode.ERROR_ACTIVITY_FINISH /*71009*/:
                            i2 = 12;
                            break;
                        default:
                            i2 = 7;
                            break;
                    }
                } else {
                    i2 = 2;
                }
            }
            i2 = 5;
        } else {
            i2 = 4;
        }
        this.mDescription = a.a(i2);
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDescription() {
        return this.mDescription;
    }
}
