package com.cyjh.mq.sdk.inf;

public interface IScript {
    String getAppId();

    String getAtcPath();

    String getConfigPath();

    long getEncryptKey();

    String getLcPath();

    int getRepeat();

    String getScriptEncryptKey();

    int getTimeInMinutes();

    int getTrialTime();

    String getUserName();

    boolean isEncrypt();

    boolean isFengwoScript();

    IScript setAppId(String str);

    IScript setAtcPath(String str);

    IScript setConfigPath(String str);

    IScript setEncrypt(boolean z);

    IScript setEncryptKey(long j);

    IScript setIsFengwoScript(boolean z);

    IScript setLcPath(String str);

    IScript setRepeat(int i);

    IScript setScriptEncryptKey(String str);

    IScript setTimeInMinutes(int i);

    IScript setTrialTime(int i);

    IScript setUserName(String str);
}
