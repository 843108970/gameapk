package android.support.constraint.solver;

import java.util.Arrays;

public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId = -1;
    public int id = -1;
    ArrayRow[] mClientEquations = new ArrayRow[8];
    int mClientEquationsCount = 0;
    private String mName;
    Type mType;
    public int strength = 0;
    float[] strengthVector = new float[7];
    public int usageInRowCount = 0;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.mType = type;
    }

    public SolverVariable(String str, Type type) {
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        StringBuilder sb;
        int i;
        if (str != null) {
            sb = new StringBuilder();
            sb.append(str);
            i = uniqueErrorId;
        } else {
            switch (type) {
                case UNRESTRICTED:
                    sb = new StringBuilder("U");
                    i = uniqueUnrestrictedId + 1;
                    uniqueUnrestrictedId = i;
                    break;
                case CONSTANT:
                    sb = new StringBuilder("C");
                    i = uniqueConstantId + 1;
                    uniqueConstantId = i;
                    break;
                case SLACK:
                    sb = new StringBuilder("S");
                    i = uniqueSlackId + 1;
                    uniqueSlackId = i;
                    break;
                case ERROR:
                    sb = new StringBuilder("e");
                    i = uniqueErrorId + 1;
                    uniqueErrorId = i;
                    break;
                case UNKNOWN:
                    sb = new StringBuilder("V");
                    i = uniqueId + 1;
                    uniqueId = i;
                    break;
                default:
                    throw new AssertionError(type.name());
            }
        }
        sb.append(i);
        return sb.toString();
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (i < this.mClientEquationsCount) {
            if (this.mClientEquations[i] != arrayRow) {
                i++;
            } else {
                return;
            }
        }
        if (this.mClientEquationsCount >= this.mClientEquations.length) {
            this.mClientEquations = (ArrayRow[]) Arrays.copyOf(this.mClientEquations, this.mClientEquations.length * 2);
        }
        this.mClientEquations[this.mClientEquationsCount] = arrayRow;
        this.mClientEquationsCount++;
    }

    /* access modifiers changed from: package-private */
    public void clearStrengths() {
        for (int i = 0; i < 7; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mClientEquations[i2] == arrayRow) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    int i4 = i2 + i3;
                    this.mClientEquations[i4] = this.mClientEquations[i4 + 1];
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    /* access modifiers changed from: package-private */
    public String strengthsToString() {
        StringBuilder sb;
        String str;
        String str2 = this + "[";
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < this.strengthVector.length; i++) {
            String str3 = str2 + this.strengthVector[i];
            if (this.strengthVector[i] > 0.0f) {
                z = false;
            } else if (this.strengthVector[i] < 0.0f) {
                z = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                z2 = false;
            }
            if (i < this.strengthVector.length - 1) {
                sb = new StringBuilder();
                sb.append(str3);
                str = ", ";
            } else {
                sb = new StringBuilder();
                sb.append(str3);
                str = "] ";
            }
            sb.append(str);
            str2 = sb.toString();
        }
        if (z) {
            str2 = str2 + " (-)";
        }
        if (!z2) {
            return str2;
        }
        return str2 + " (*)";
    }

    public String toString() {
        return "" + this.mName;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.mClientEquations[i2].variables.updateFromRow(this.mClientEquations[i2], arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }
}
