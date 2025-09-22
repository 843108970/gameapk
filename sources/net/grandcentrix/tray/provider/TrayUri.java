package net.grandcentrix.tray.provider;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import net.grandcentrix.tray.core.TrayStorage;

class TrayUri {
    /* access modifiers changed from: private */
    public final Uri mContentUri;
    /* access modifiers changed from: private */
    public final Uri mContentUriInternal;
    /* access modifiers changed from: private */
    public Context mContext;

    public final class Builder {
        private boolean mInternal;
        private String mKey;
        private String mModule;
        private TrayStorage.Type mType = TrayStorage.Type.UNDEFINED;

        public Builder(Context context) {
            Context unused = TrayUri.this.mContext = context.getApplicationContext();
        }

        public final Uri build() {
            Uri.Builder buildUpon = (this.mInternal ? TrayUri.this.mContentUriInternal : TrayUri.this.mContentUri).buildUpon();
            if (this.mModule != null) {
                buildUpon.appendPath(this.mModule);
            }
            if (this.mKey != null) {
                buildUpon.appendPath(this.mKey);
            }
            if (this.mType != TrayStorage.Type.UNDEFINED) {
                buildUpon.appendQueryParameter("backup", TrayStorage.Type.USER.equals(this.mType) ? "true" : "false");
            }
            return buildUpon.build();
        }

        public final Builder setInternal(boolean z) {
            this.mInternal = z;
            return this;
        }

        public final Builder setKey(String str) {
            this.mKey = str;
            return this;
        }

        public final Builder setModule(String str) {
            this.mModule = str;
            return this;
        }

        public final Builder setType(TrayStorage.Type type) {
            this.mType = type;
            return this;
        }
    }

    public TrayUri(@NonNull Context context) {
        this.mContext = context;
        this.mContentUri = TrayContract.generateContentUri(context);
        this.mContentUriInternal = TrayContract.generateInternalContentUri(context);
    }

    public Builder builder() {
        return new Builder(this.mContext);
    }

    public Uri get() {
        return this.mContentUri;
    }

    public Uri getInternal() {
        return this.mContentUriInternal;
    }
}
