package com.cyjh.elfin.entity;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.ywfzjbcy.R;

public class FloatEditBean implements Parcelable {
    public static final Parcelable.Creator<FloatEditBean> CREATOR = new Parcelable.Creator<FloatEditBean>() {
        public final FloatEditBean createFromParcel(Parcel parcel) {
            return new FloatEditBean(parcel);
        }

        public final FloatEditBean[] newArray(int i) {
            return new FloatEditBean[i];
        }
    };
    public String intentContent;
    public String intentTtile;
    public boolean isCancle;
    public String leftContent;
    public String rightContent;
    public ActionBarOperaEnum type;

    public FloatEditBean() {
    }

    protected FloatEditBean(Parcel parcel) {
        this.intentTtile = parcel.readString();
        this.intentContent = parcel.readString();
        this.leftContent = parcel.readString();
        this.rightContent = parcel.readString();
        this.isCancle = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.type = readInt == -1 ? null : ActionBarOperaEnum.values()[readInt];
    }

    public static FloatEditBean getDeleteFloatBean(Context context, String str) {
        FloatEditBean floatEditBean = new FloatEditBean();
        floatEditBean.intentTtile = context.getString(R.string.menu_delete);
        floatEditBean.intentContent = str;
        floatEditBean.leftContent = context.getString(R.string.btn_cancle);
        floatEditBean.rightContent = context.getString(R.string.btn_ok);
        floatEditBean.isCancle = true;
        floatEditBean.type = ActionBarOperaEnum.DELETE;
        return floatEditBean;
    }

    public static FloatEditBean getEditFlloatBean(Context context, String str) {
        FloatEditBean floatEditBean = new FloatEditBean();
        floatEditBean.intentTtile = context.getString(R.string.menu_rename);
        floatEditBean.intentContent = str;
        floatEditBean.leftContent = context.getString(R.string.btn_cancle);
        floatEditBean.rightContent = context.getString(R.string.btn_ok);
        floatEditBean.isCancle = true;
        floatEditBean.type = ActionBarOperaEnum.RENAME;
        return floatEditBean;
    }

    public static FloatEditBean getNewCreateFlloatBean(Context context, String str) {
        FloatEditBean floatEditBean = new FloatEditBean();
        floatEditBean.intentTtile = context.getString(R.string.create_new_file);
        floatEditBean.intentContent = str;
        floatEditBean.leftContent = context.getString(R.string.btn_cancle);
        floatEditBean.rightContent = context.getString(R.string.btn_ok);
        floatEditBean.isCancle = true;
        floatEditBean.type = ActionBarOperaEnum.CREATE_NEW_FILE;
        return floatEditBean;
    }

    public static FloatEditBean getSaveFloatBean(Context context) {
        FloatEditBean floatEditBean = new FloatEditBean();
        floatEditBean.intentTtile = context.getString(R.string.save_script_title);
        floatEditBean.intentContent = context.getString(R.string.tips);
        floatEditBean.rightContent = context.getString(R.string.save);
        floatEditBean.leftContent = context.getString(R.string.cancel);
        floatEditBean.type = ActionBarOperaEnum.SAVE;
        return floatEditBean;
    }

    public static FloatEditBean getStartDownloadFlloatBean(Context context, String str) {
        FloatEditBean floatEditBean = new FloatEditBean();
        floatEditBean.intentTtile = context.getString(R.string.user_permission);
        floatEditBean.intentContent = str;
        floatEditBean.leftContent = context.getString(R.string.btn_cancle);
        floatEditBean.rightContent = context.getString(R.string.btn_down);
        floatEditBean.isCancle = true;
        floatEditBean.type = ActionBarOperaEnum.START_DOWNLOAD;
        return floatEditBean;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.intentTtile);
        parcel.writeString(this.intentContent);
        parcel.writeString(this.leftContent);
        parcel.writeString(this.rightContent);
        parcel.writeByte(this.isCancle ? (byte) 1 : 0);
        parcel.writeInt(this.type == null ? -1 : this.type.ordinal());
    }
}
