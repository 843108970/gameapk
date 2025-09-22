package com.iflytek.voiceads.conn;

import com.iflytek.voiceads.bean.AdAudio;
import com.iflytek.voiceads.bean.AudioMonitor;
import java.util.ArrayList;
import java.util.List;

public abstract class NativeDataRef extends BaseDataRef {
    public abstract AdAudio getAdAudio();

    public abstract String getAddress();

    public abstract String getAppName();

    public abstract double getAppSize();

    public abstract String getAppVer();

    public abstract AudioMonitor getAudioMonitor();

    public abstract double getCurrentPrice();

    public abstract ArrayList<String> getDisplayLabels();

    public abstract int getDownloads();

    public abstract List<String> getImgList();

    public abstract int getLikes();

    public abstract double getOriginalPrice();

    public abstract String getPhone();

    public abstract String getRating();

    public abstract String getSponsored();
}
