package com.lidroid.xutils.task;

public class PriorityObject<E> {
    public final E obj;
    public final Priority priority;

    public PriorityObject(Priority priority2, E e) {
        this.priority = priority2 == null ? Priority.DEFAULT : priority2;
        this.obj = e;
    }
}
