package org.apache.commons.mail;

import java.io.IOException;
import javax.activation.DataSource;

public interface DataSourceResolver {
    DataSource resolve(String str) throws IOException;

    DataSource resolve(String str, boolean z) throws IOException;
}
