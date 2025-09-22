package org.apache.commons.mail.a;

import java.io.IOException;
import javax.activation.DataSource;
import org.apache.commons.mail.DataSourceResolver;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private final DataSourceResolver[] f4283b;

    private c(DataSourceResolver[] dataSourceResolverArr) {
        this.f4283b = new DataSourceResolver[dataSourceResolverArr.length];
        System.arraycopy(dataSourceResolverArr, 0, this.f4283b, 0, dataSourceResolverArr.length);
    }

    private c(DataSourceResolver[] dataSourceResolverArr, boolean z) {
        super(z);
        this.f4283b = new DataSourceResolver[dataSourceResolverArr.length];
        System.arraycopy(dataSourceResolverArr, 0, this.f4283b, 0, dataSourceResolverArr.length);
    }

    private DataSourceResolver[] a() {
        DataSourceResolver[] dataSourceResolverArr = new DataSourceResolver[this.f4283b.length];
        System.arraycopy(this.f4283b, 0, dataSourceResolverArr, 0, this.f4283b.length);
        return dataSourceResolverArr;
    }

    public final DataSource resolve(String str) throws IOException {
        DataSource resolve = resolve(str, true);
        if (this.f4281a || resolve != null) {
            return resolve;
        }
        throw new IOException("The following resource was not found : " + str);
    }

    public final DataSource resolve(String str, boolean z) throws IOException {
        for (DataSourceResolver resolve : a()) {
            DataSource resolve2 = resolve.resolve(str, z);
            if (resolve2 != null) {
                return resolve2;
            }
        }
        if (z) {
            return null;
        }
        throw new IOException("The following resource was not found : " + str);
    }
}
