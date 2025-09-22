package com.alibaba.sdk.android.oss.internal;

import b.ae;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.io.IOException;

public interface ResponseParser<T extends OSSResult> {
    T parse(ae aeVar) throws IOException;
}
