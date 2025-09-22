package com.cyjh.elfin.entity;

public class ElfinFloatViewEvent {
    private int type;

    public ElfinFloatViewEvent() {
    }

    public ElfinFloatViewEvent(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
