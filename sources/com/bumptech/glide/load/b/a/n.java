package com.bumptech.glide.load.b.a;

import java.util.Map;
import java.util.TreeMap;

final class n<K, V> extends TreeMap<K, V> {
    n() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        for (Map.Entry entry : entrySet()) {
            sb.append('{');
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(entry.getValue());
            sb.append("}, ");
        }
        if (!isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(" )");
        return sb.toString();
    }
}
