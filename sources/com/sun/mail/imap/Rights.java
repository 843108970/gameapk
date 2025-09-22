package com.sun.mail.imap;

import java.util.Vector;

public class Rights implements Cloneable {
    private boolean[] rights = new boolean[128];

    public static final class Right {
        public static final Right ADMINISTER = getInstance('a');
        public static final Right CREATE = getInstance('c');
        public static final Right DELETE = getInstance('d');
        public static final Right INSERT = getInstance('i');
        public static final Right KEEP_SEEN = getInstance('s');
        public static final Right LOOKUP = getInstance('l');
        public static final Right POST = getInstance('p');
        public static final Right READ = getInstance('r');
        public static final Right WRITE = getInstance('w');
        private static Right[] cache = new Right[128];
        char right;

        private Right(char c2) {
            if (c2 >= 128) {
                throw new IllegalArgumentException("Right must be ASCII");
            }
            this.right = c2;
        }

        public static synchronized Right getInstance(char c2) {
            Right right2;
            synchronized (Right.class) {
                if (c2 >= 128) {
                    try {
                        throw new IllegalArgumentException("Right must be ASCII");
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (cache[c2] == null) {
                        cache[c2] = new Right(c2);
                    }
                    right2 = cache[c2];
                }
            }
            return right2;
        }

        public final String toString() {
            return String.valueOf(this.right);
        }
    }

    public Rights() {
    }

    public Rights(Right right) {
        this.rights[right.right] = true;
    }

    public Rights(Rights rights2) {
        System.arraycopy(rights2.rights, 0, this.rights, 0, this.rights.length);
    }

    public Rights(String str) {
        for (int i = 0; i < str.length(); i++) {
            add(Right.getInstance(str.charAt(i)));
        }
    }

    public void add(Right right) {
        this.rights[right.right] = true;
    }

    public void add(Rights rights2) {
        for (int i = 0; i < rights2.rights.length; i++) {
            if (rights2.rights[i]) {
                this.rights[i] = true;
            }
        }
    }

    public Object clone() {
        try {
            Rights rights2 = (Rights) super.clone();
            try {
                rights2.rights = new boolean[128];
                System.arraycopy(this.rights, 0, rights2.rights, 0, this.rights.length);
                return rights2;
            } catch (CloneNotSupportedException unused) {
                return rights2;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public boolean contains(Right right) {
        return this.rights[right.right];
    }

    public boolean contains(Rights rights2) {
        for (int i = 0; i < rights2.rights.length; i++) {
            if (rights2.rights[i] && !this.rights[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rights)) {
            return false;
        }
        Rights rights2 = (Rights) obj;
        for (int i = 0; i < rights2.rights.length; i++) {
            if (rights2.rights[i] != this.rights[i]) {
                return false;
            }
        }
        return true;
    }

    public Right[] getRights() {
        Vector vector = new Vector();
        for (int i = 0; i < this.rights.length; i++) {
            if (this.rights[i]) {
                vector.addElement(Right.getInstance((char) i));
            }
        }
        Right[] rightArr = new Right[vector.size()];
        vector.copyInto(rightArr);
        return rightArr;
    }

    public int hashCode() {
        int i = 0;
        for (boolean z : this.rights) {
            if (z) {
                i++;
            }
        }
        return i;
    }

    public void remove(Right right) {
        this.rights[right.right] = false;
    }

    public void remove(Rights rights2) {
        for (int i = 0; i < rights2.rights.length; i++) {
            if (rights2.rights[i]) {
                this.rights[i] = false;
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.rights.length; i++) {
            if (this.rights[i]) {
                stringBuffer.append((char) i);
            }
        }
        return stringBuffer.toString();
    }
}
