package com.lidroid.xutils.task;

class Node<T> {
    Node<T> next;
    private PriorityObject<?> value;
    private boolean valueAsT = false;

    Node(T t) {
        setValue(t);
    }

    public Priority getPriority() {
        return this.value.priority;
    }

    public T getValue() {
        if (this.value == null) {
            return null;
        }
        return this.valueAsT ? this.value : this.value.obj;
    }

    public void setValue(T t) {
        if (t == null) {
            this.value = null;
        } else if (t instanceof PriorityObject) {
            this.value = (PriorityObject) t;
            this.valueAsT = true;
        } else {
            this.value = new PriorityObject<>(Priority.DEFAULT, t);
        }
    }
}
