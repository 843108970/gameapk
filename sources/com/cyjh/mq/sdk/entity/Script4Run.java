package com.cyjh.mq.sdk.entity;

import android.text.TextUtils;
import com.cyjh.mobileanjian.ipc.share.proto.Ipc;
import com.cyjh.mq.sdk.inf.IScript;
import com.cyjh.mq.sdk.inf.d;

public class Script4Run implements IScript, d, Cloneable {
    public static final int IGNORE_REPEAT = -1;
    public static final int IGNORE_TIME = -2;
    public static final int LOOP = 0;
    public static final int ONE_TIME = 1;
    public String appId = "";
    public String atcPath = "";
    public int duration = -2;
    public boolean encrypt = false;
    public long encryptKey = 0;
    public boolean isFengwoScript = false;
    public String lcPath = "";
    public int repeat = 1;
    public String scriptEncryptKey = "";
    public int trialTime = 0;
    public String uiCfgPath = "";
    public String username = "";

    public Script4Run() {
    }

    public Script4Run(String str, String str2, String str3) {
        this.lcPath = str;
        this.atcPath = str2;
        this.uiCfgPath = str3;
    }

    public static Script4Run parseFromMessage(Ipc.IpcMessage ipcMessage) {
        Script4Run script4Run = new Script4Run();
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    script4Run.setTrialTime(ipcMessage.getArg1(i)).setLcPath(ipcMessage.getArg2(i)).setEncryptKey(ipcMessage.getArg4(i));
                    break;
                case 1:
                    script4Run.setRepeat(ipcMessage.getArg1(i)).setAtcPath(ipcMessage.getArg2(i));
                    break;
                case 2:
                    script4Run.setTimeInMinutes(ipcMessage.getArg1(i)).setConfigPath(ipcMessage.getArg2(i));
                    break;
                case 3:
                    script4Run.setEncrypt(ipcMessage.getArg1(i) != 0).setAppId(ipcMessage.getArg2(i));
                    break;
                case 4:
                    script4Run.setUserName(ipcMessage.getArg2(i));
                    break;
                case 5:
                    String arg2 = ipcMessage.getArg2(i);
                    if (TextUtils.isEmpty(arg2)) {
                        break;
                    } else {
                        script4Run.setScriptEncryptKey(arg2);
                        break;
                    }
            }
        }
        script4Run.setEncrypt(ipcMessage.getEncrypt());
        return script4Run;
    }

    public Script4Run clone() {
        try {
            return (Script4Run) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAtcPath() {
        return this.atcPath;
    }

    public String getConfigPath() {
        return this.uiCfgPath;
    }

    public long getEncryptKey() {
        return this.encryptKey;
    }

    public String getLcPath() {
        return this.lcPath;
    }

    public int getRepeat() {
        return this.repeat;
    }

    public String getScriptEncryptKey() {
        return this.scriptEncryptKey;
    }

    public int getTimeInMinutes() {
        return this.duration;
    }

    public int getTrialTime() {
        return this.trialTime;
    }

    public String getUserName() {
        return this.username;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public boolean isFengwoScript() {
        return this.isFengwoScript;
    }

    public IScript setAppId(String str) {
        this.appId = str;
        return this;
    }

    public IScript setAtcPath(String str) {
        this.atcPath = str;
        return this;
    }

    public IScript setConfigPath(String str) {
        this.uiCfgPath = str;
        return this;
    }

    public IScript setEncrypt(boolean z) {
        this.encrypt = z;
        return this;
    }

    public IScript setEncryptKey(long j) {
        this.encryptKey = j;
        return this;
    }

    public IScript setIsFengwoScript(boolean z) {
        this.isFengwoScript = z;
        return this;
    }

    public IScript setLcPath(String str) {
        this.lcPath = str;
        return this;
    }

    public IScript setRepeat(int i) {
        if (i >= 0) {
            this.repeat = i;
            this.duration = -2;
        }
        return this;
    }

    public IScript setScriptEncryptKey(String str) {
        this.scriptEncryptKey = str;
        return this;
    }

    public IScript setTimeInMinutes(int i) {
        if (i > 0) {
            this.duration = i;
            this.repeat = -1;
        }
        return this;
    }

    public IScript setTrialTime(int i) {
        this.trialTime = i;
        return this;
    }

    public IScript setUserName(String str) {
        this.username = str;
        return this;
    }

    public Ipc.IpcMessage toMessage(int i) {
        String str;
        Ipc.IpcMessage.Builder cmd = Ipc.IpcMessage.newBuilder().setCmd(i);
        for (int i2 = 0; i2 < 6; i2++) {
            switch (i2) {
                case 0:
                    cmd.addArg1(this.trialTime);
                    cmd.addArg2(this.lcPath);
                    cmd.addArg4(this.encryptKey);
                    continue;
                case 1:
                    cmd.addArg1(this.repeat);
                    str = this.atcPath;
                    break;
                case 2:
                    cmd.addArg1(this.duration);
                    str = this.uiCfgPath;
                    break;
                case 3:
                    cmd.addArg1(this.isFengwoScript ? 1 : 0);
                    str = this.appId;
                    break;
                case 4:
                    str = this.username;
                    break;
                case 5:
                    if (TextUtils.isEmpty(this.scriptEncryptKey)) {
                        this.scriptEncryptKey = "";
                    }
                    str = this.scriptEncryptKey;
                    break;
            }
            cmd.addArg2(str);
        }
        cmd.setEncrypt(this.encrypt);
        return cmd.build();
    }

    public String toString() {
        return "lcPath=" + getLcPath() + 10 + "atcPath=" + getAtcPath() + 10 + "uiCfgPath=" + getConfigPath() + 10 + "appId=" + getAppId() + 10 + "username=" + getUserName() + 10 + "trialTime=" + getTrialTime() + 10 + "repeat=" + getRepeat() + 10 + "duration=" + getTimeInMinutes() + 10 + "encryptKey=" + getEncryptKey() + 10 + "encrypt=" + isEncrypt() + 10;
    }
}
