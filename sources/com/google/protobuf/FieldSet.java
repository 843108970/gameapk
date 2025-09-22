package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType;
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    private final SmallSortedMap<FieldDescriptorType, Object> fields = SmallSortedMap.newFieldMap(16);
    private boolean hasLazyField = false;
    private boolean isImmutable;

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(38:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|(2:38|39)|40|42) */
    /* JADX WARNING: Can't wrap try/catch for region: R(39:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0033 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0045 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0061 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x006a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0074 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0088 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0092 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00a6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00b0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0016 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType() {
        /*
            int[] r0 = $SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0016 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0016 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
        L_0x0016:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x0020 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0020 }
            r2 = 12
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0020 }
        L_0x0020:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0029 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
            r2 = 14
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
        L_0x0033:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x003c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003c }
        L_0x003c:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0045 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
        L_0x0045:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x004e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
        L_0x004e:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x0058 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
            r2 = 10
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
        L_0x0058:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0061 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0061 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0061 }
        L_0x0061:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x006a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006a }
        L_0x006a:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0074 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
            r2 = 11
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
        L_0x0074:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x007e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
            r2 = 15
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
        L_0x007e:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0088 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
            r2 = 16
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
        L_0x0088:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0092 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
            r2 = 17
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
        L_0x0092:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
            r2 = 18
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
        L_0x009c:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00a6 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
            r2 = 9
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a6 }
        L_0x00a6:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x00b0 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
            r2 = 13
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b0 }
        L_0x00b0:
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x00b9 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
        L_0x00b9:
            $SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.FieldSet.$SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType():int[]");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(21:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0043 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType() {
        /*
            int[] r0 = $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.google.protobuf.WireFormat$JavaType[] r0 = com.google.protobuf.WireFormat.JavaType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x0031 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0031 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0031 }
        L_0x0031:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.FLOAT     // Catch:{ NoSuchFieldError -> 0x003a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003a }
        L_0x003a:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.INT     // Catch:{ NoSuchFieldError -> 0x0043 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
        L_0x0043:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.LONG     // Catch:{ NoSuchFieldError -> 0x004c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
        L_0x004c:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0056 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 9
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x005f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
        L_0x005f:
            $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.FieldSet.$SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType():int[]");
    }

    private FieldSet() {
    }

    private FieldSet(boolean z) {
        makeImmutable();
    }

    private void cloneFieldEntry(Map<FieldDescriptorType, Object> map, Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            map.put(fieldDescriptorLite, ((LazyField) value).getValue());
        } else {
            map.put(fieldDescriptorLite, value);
        }
    }

    private static int computeElementSize(WireFormat.FieldType fieldType, int i, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i);
        if (fieldType == WireFormat.FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + computeElementSizeNoTag(fieldType, obj);
    }

    private static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType()[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 10:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 11:
                return obj instanceof LazyField ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 12:
                return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber());
            case 15:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 16:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 17:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 18:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, obj);
        }
        int i = 0;
        if (fieldDescriptorLite.isPacked()) {
            for (Object computeElementSizeNoTag : (List) obj) {
                i += computeElementSizeNoTag(liteType, computeElementSizeNoTag);
            }
            return CodedOutputStream.computeTagSize(number) + i + CodedOutputStream.computeRawVarint32Size(i);
        }
        for (Object computeElementSize : (List) obj) {
            i += computeElementSize(liteType, number, computeElementSize);
        }
        return i;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        return (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) ? computeFieldSize(fieldDescriptorLite, value) : value instanceof LazyField ? CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (LazyField) value) : CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) value);
    }

    static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (fieldDescriptorLite.isRepeated()) {
                for (MessageLite isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }
            Object value = entry.getValue();
            if (value instanceof MessageLite) {
                if (!((MessageLite) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof LazyField) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (fieldDescriptorLite.isRepeated()) {
            Object field = getField(fieldDescriptorLite);
            if (field == null) {
                this.fields.put(fieldDescriptorLite, new ArrayList((List) value));
            } else {
                ((List) field).addAll((List) value);
            }
        } else if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object field2 = getField(fieldDescriptorLite);
            if (field2 == null) {
                this.fields.put(fieldDescriptorLite, value);
            } else {
                this.fields.put(fieldDescriptorLite, fieldDescriptorLite.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
            }
        } else {
            this.fields.put(fieldDescriptorLite, value);
        }
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType) throws IOException {
        switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType()[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.readDouble());
            case 2:
                return Float.valueOf(codedInputStream.readFloat());
            case 3:
                return Long.valueOf(codedInputStream.readInt64());
            case 4:
                return Long.valueOf(codedInputStream.readUInt64());
            case 5:
                return Integer.valueOf(codedInputStream.readInt32());
            case 6:
                return Long.valueOf(codedInputStream.readFixed64());
            case 7:
                return Integer.valueOf(codedInputStream.readFixed32());
            case 8:
                return Boolean.valueOf(codedInputStream.readBool());
            case 9:
                return codedInputStream.readString();
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 11:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 12:
                return codedInputStream.readBytes();
            case 13:
                return Integer.valueOf(codedInputStream.readUInt32());
            case 14:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 15:
                return Integer.valueOf(codedInputStream.readSFixed32());
            case 16:
                return Long.valueOf(codedInputStream.readSFixed64());
            case 17:
                return Integer.valueOf(codedInputStream.readSInt32());
            case 18:
                return Long.valueOf(codedInputStream.readSInt64());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static void verifyType(WireFormat.FieldType fieldType, Object obj) {
        boolean z;
        if (obj == null) {
            throw new NullPointerException();
        }
        boolean z2 = false;
        switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType()[fieldType.getJavaType().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                z = obj instanceof ByteString;
                break;
            case 8:
                z = obj instanceof Internal.EnumLite;
                break;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                    z2 = true;
                    break;
                }
        }
        z2 = z;
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i, (MessageLite) obj);
            return;
        }
        codedOutputStream.writeTag(i, getWireFormatForFieldType(fieldType, false));
        writeElementNoTag(codedOutputStream, fieldType, obj);
    }

    private static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$FieldType()[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.writeStringNoTag((String) obj);
                return;
            case 10:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                return;
            case 11:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                return;
            case 12:
                codedOutputStream.writeBytesNoTag((ByteString) obj);
                return;
            case 13:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                return;
            case 15:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                return;
            case 16:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                return;
            case 17:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                return;
            case 18:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                return;
            default:
                return;
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.isRepeated()) {
            List<Object> list = (List) obj;
            if (fieldDescriptorLite.isPacked()) {
                codedOutputStream.writeTag(number, 2);
                int i = 0;
                for (Object computeElementSizeNoTag : list) {
                    i += computeElementSizeNoTag(liteType, computeElementSizeNoTag);
                }
                codedOutputStream.writeRawVarint32(i);
                for (Object writeElementNoTag : list) {
                    writeElementNoTag(codedOutputStream, liteType, writeElementNoTag);
                }
                return;
            }
            for (Object writeElement : list) {
                writeElement(codedOutputStream, liteType, number, writeElement);
            }
        } else if (obj instanceof LazyField) {
            writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
        } else {
            writeElement(codedOutputStream, liteType, number, obj);
        }
    }

    private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
            writeField(fieldDescriptorLite, entry.getValue(), codedOutputStream);
        } else {
            codedOutputStream.writeMessageSetExtension(((FieldDescriptorLite) entry.getKey()).getNumber(), (MessageLite) entry.getValue());
        }
    }

    public final void addRepeatedField(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(fielddescriptortype.getLiteType(), obj);
        Object field = getField(fielddescriptortype);
        if (field == null) {
            list = new ArrayList();
            this.fields.put(fielddescriptortype, list);
        } else {
            list = (List) field;
        }
        list.add(obj);
    }

    public final void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public final void clearField(FieldDescriptorType fielddescriptortype) {
        this.fields.remove(fielddescriptortype);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    public final FieldSet<FieldDescriptorType> clone() {
        FieldSet<FieldDescriptorType> newFieldSet = newFieldSet();
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<FieldDescriptorType, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            newFieldSet.setField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry next : this.fields.getOverflowEntries()) {
            newFieldSet.setField((FieldDescriptorLite) next.getKey(), next.getValue());
        }
        newFieldSet.hasLazyField = this.hasLazyField;
        return newFieldSet;
    }

    public final Map<FieldDescriptorType, Object> getAllFields() {
        if (!this.hasLazyField) {
            return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
        }
        SmallSortedMap newFieldMap = SmallSortedMap.newFieldMap(16);
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            cloneFieldEntry(newFieldMap, this.fields.getArrayEntryAt(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> cloneFieldEntry : this.fields.getOverflowEntries()) {
            cloneFieldEntry(newFieldMap, cloneFieldEntry);
        }
        if (this.fields.isImmutable()) {
            newFieldMap.makeImmutable();
        }
        return newFieldMap;
    }

    public final Object getField(FieldDescriptorType fielddescriptortype) {
        Object obj = this.fields.get(fielddescriptortype);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    public final int getMessageSetSerializedSize() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            i += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> messageSetSerializedSize : this.fields.getOverflowEntries()) {
            i += getMessageSetSerializedSize(messageSetSerializedSize);
        }
        return i;
    }

    public final Object getRepeatedField(FieldDescriptorType fielddescriptortype, int i) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field != null) {
            return ((List) field).get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int getRepeatedFieldCount(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field == null) {
            return 0;
        }
        return ((List) field).size();
    }

    public final int getSerializedSize() {
        int i = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            Map.Entry<FieldDescriptorType, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            i += computeFieldSize((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry next : this.fields.getOverflowEntries()) {
            i += computeFieldSize((FieldDescriptorLite) next.getKey(), next.getValue());
        }
        return i;
    }

    public final boolean hasField(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            return this.fields.get(fielddescriptortype) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public final boolean isImmutable() {
        return this.isImmutable;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> isInitialized : this.fields.getOverflowEntries()) {
            if (!isInitialized(isInitialized)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.hasLazyField ? new LazyField.LazyIterator(this.fields.entrySet().iterator()) : this.fields.entrySet().iterator();
    }

    public final void makeImmutable() {
        if (!this.isImmutable) {
            this.fields.makeImmutable();
            this.isImmutable = true;
        }
    }

    public final void mergeFrom(FieldSet<FieldDescriptorType> fieldSet) {
        for (int i = 0; i < fieldSet.fields.getNumArrayEntries(); i++) {
            mergeFromField(fieldSet.fields.getArrayEntryAt(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> mergeFromField : fieldSet.fields.getOverflowEntries()) {
            mergeFromField(mergeFromField);
        }
    }

    public final void setField(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            verifyType(fielddescriptortype.getLiteType(), obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.addAll((List) obj);
            for (Object verifyType : arrayList) {
                verifyType(fielddescriptortype.getLiteType(), verifyType);
            }
            obj = arrayList;
        }
        if (obj instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put(fielddescriptortype, obj);
    }

    public final void setRepeatedField(FieldDescriptorType fielddescriptortype, int i, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(fielddescriptortype.getLiteType(), obj);
        ((List) field).set(i, obj);
    }

    public final void writeMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i), codedOutputStream);
        }
        for (Map.Entry<FieldDescriptorType, Object> writeMessageSetTo : this.fields.getOverflowEntries()) {
            writeMessageSetTo(writeMessageSetTo, codedOutputStream);
        }
    }

    public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
            Map.Entry<FieldDescriptorType, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
            writeField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
        }
        for (Map.Entry next : this.fields.getOverflowEntries()) {
            writeField((FieldDescriptorLite) next.getKey(), next.getValue(), codedOutputStream);
        }
    }
}
