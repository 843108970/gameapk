package com.lidroid.xutils.view;

public class ViewInjectInfo {
    public int parentId;
    public Object value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInjectInfo)) {
            return false;
        }
        ViewInjectInfo viewInjectInfo = (ViewInjectInfo) obj;
        if (this.parentId != viewInjectInfo.parentId) {
            return false;
        }
        return this.value == null ? viewInjectInfo.value == null : this.value.equals(viewInjectInfo.value);
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.parentId;
    }
}
