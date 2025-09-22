package org.apache.commons.io.serialization;

import java.util.regex.Pattern;

final class RegexpClassNameMatcher implements ClassNameMatcher {
    private final Pattern pattern;

    public RegexpClassNameMatcher(String str) {
        this(Pattern.compile(str));
    }

    public RegexpClassNameMatcher(Pattern pattern2) {
        if (pattern2 == null) {
            throw new IllegalArgumentException("Null pattern");
        }
        this.pattern = pattern2;
    }

    public final boolean matches(String str) {
        return this.pattern.matcher(str).matches();
    }
}
