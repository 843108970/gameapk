package com.cyjh.elfin.entity;

import java.io.File;

public class Script {
    public static final int SCRIPT_STATE_FREE = 0;
    public static final int SCRIPT_STATE_LOAD = 1;
    public static final int SCRIPT_STATE_PAUSE = 3;
    public static final int SCRIPT_STATE_PAUSE_BY_HEART_BEAT_VERIFI_ERR = 4;
    public static final int SCRIPT_STATE_RUNING = 2;
    private String appId;
    private File atcFile;
    private BestResolution bestResolution;
    private File cfgFile;
    private int changeFileList;
    private String description;
    private FileVersion fileVersion;
    private String id;
    private File lcFile;
    private String name;
    private File propFile;
    private File rtdFile;
    private String selId;
    private String size;
    private File uiFile;
    private File uipFile;
    private String version;

    public String getAppId() {
        return this.appId;
    }

    public File getAtcFile() {
        return this.atcFile;
    }

    public BestResolution getBestResolution() {
        return this.bestResolution;
    }

    public File getCfgFile() {
        return this.cfgFile;
    }

    public int getChangeFileList() {
        return this.changeFileList;
    }

    public String getDescription() {
        return this.description;
    }

    public FileVersion getFileVersion() {
        return this.fileVersion;
    }

    public String getId() {
        return this.id;
    }

    public File getLcFile() {
        return this.lcFile;
    }

    public String getName() {
        return this.name;
    }

    public File getPropFile() {
        return this.propFile;
    }

    public File getRtdFile() {
        return this.rtdFile;
    }

    public String getSelId() {
        return this.selId;
    }

    public String getSize() {
        return this.size;
    }

    public File getUiFile() {
        return this.uiFile;
    }

    public File getUipFile() {
        return this.uipFile;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAtcFile(File file) {
        this.atcFile = file;
    }

    public void setBestResolution(BestResolution bestResolution2) {
        this.bestResolution = bestResolution2;
    }

    public void setCfgFile(File file) {
        this.cfgFile = file;
    }

    public void setChangeFileList(int i) {
        this.changeFileList = i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setFileVersion(FileVersion fileVersion2) {
        this.fileVersion = fileVersion2;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLcFile(File file) {
        this.lcFile = file;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPropFile(File file) {
        this.propFile = file;
    }

    public void setRtdFile(File file) {
        this.rtdFile = file;
    }

    public void setSelId(String str) {
        this.selId = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setUiFile(File file) {
        this.uiFile = file;
    }

    public void setUipFile(File file) {
        this.uipFile = file;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "Script{changeFileList=" + this.changeFileList + ", name='" + this.name + '\'' + ", id='" + this.id + '\'' + ", description='" + this.description + '\'' + ", size='" + this.size + '\'' + ", appId='" + this.appId + '\'' + ", version='" + this.version + '\'' + ", selId='" + this.selId + '\'' + ", lcFile=" + this.lcFile + ", propFile=" + this.propFile + ", atcFile=" + this.atcFile + ", uiFile=" + this.uiFile + ", uipFile=" + this.uipFile + ", rtdFile=" + this.rtdFile + ", cfgFile=" + this.cfgFile + ", fileVersion=" + this.fileVersion + ", bestResolution=" + this.bestResolution + '}';
    }
}
