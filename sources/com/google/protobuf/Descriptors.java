package com.google.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.TextFormat;
import com.google.protobuf.WireFormat;
import com.lidroid.xutils.util.CharsetUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FilenameUtils;

public final class Descriptors {

    public static final class Descriptor implements GenericDescriptor {
        private final Descriptor containingType;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final Descriptor[] nestedTypes;
        private DescriptorProtos.DescriptorProto proto;

        private Descriptor(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i) throws DescriptorValidationException {
            this.index = i;
            this.proto = descriptorProto;
            this.fullName = Descriptors.computeFullName(fileDescriptor, descriptor, descriptorProto.getName());
            this.file = fileDescriptor;
            this.containingType = descriptor;
            this.nestedTypes = new Descriptor[descriptorProto.getNestedTypeCount()];
            for (int i2 = 0; i2 < descriptorProto.getNestedTypeCount(); i2++) {
                this.nestedTypes[i2] = new Descriptor(descriptorProto.getNestedType(i2), fileDescriptor, this, i2);
            }
            this.enumTypes = new EnumDescriptor[descriptorProto.getEnumTypeCount()];
            for (int i3 = 0; i3 < descriptorProto.getEnumTypeCount(); i3++) {
                this.enumTypes[i3] = new EnumDescriptor(descriptorProto.getEnumType(i3), fileDescriptor, this, i3, (EnumDescriptor) null);
            }
            this.fields = new FieldDescriptor[descriptorProto.getFieldCount()];
            for (int i4 = 0; i4 < descriptorProto.getFieldCount(); i4++) {
                this.fields[i4] = new FieldDescriptor(descriptorProto.getField(i4), fileDescriptor, this, i4, false, (FieldDescriptor) null);
            }
            this.extensions = new FieldDescriptor[descriptorProto.getExtensionCount()];
            for (int i5 = 0; i5 < descriptorProto.getExtensionCount(); i5++) {
                this.extensions[i5] = new FieldDescriptor(descriptorProto.getExtension(i5), fileDescriptor, this, i5, true, (FieldDescriptor) null);
            }
            fileDescriptor.pool.addSymbol(this);
        }

        /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, Descriptor descriptor2) throws DescriptorValidationException {
            this(descriptorProto, fileDescriptor, descriptor, i);
        }

        /* access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            for (Descriptor crossLink : this.nestedTypes) {
                crossLink.crossLink();
            }
            for (FieldDescriptor access$4 : this.fields) {
                access$4.crossLink();
            }
            for (FieldDescriptor access$42 : this.extensions) {
                access$42.crossLink();
            }
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.DescriptorProto descriptorProto) {
            this.proto = descriptorProto;
            for (int i = 0; i < this.nestedTypes.length; i++) {
                this.nestedTypes[i].setProto(descriptorProto.getNestedType(i));
            }
            for (int i2 = 0; i2 < this.enumTypes.length; i2++) {
                this.enumTypes[i2].setProto(descriptorProto.getEnumType(i2));
            }
            for (int i3 = 0; i3 < this.fields.length; i3++) {
                this.fields[i3].setProto(descriptorProto.getField(i3));
            }
            for (int i4 = 0; i4 < this.extensions.length; i4++) {
                this.extensions[i4].setProto(descriptorProto.getExtension(i4));
            }
        }

        public final EnumDescriptor findEnumTypeByName(String str) {
            DescriptorPool access$0 = this.file.pool;
            GenericDescriptor findSymbol = access$0.findSymbol(String.valueOf(this.fullName) + FilenameUtils.EXTENSION_SEPARATOR + str);
            if (findSymbol == null || !(findSymbol instanceof EnumDescriptor)) {
                return null;
            }
            return (EnumDescriptor) findSymbol;
        }

        public final FieldDescriptor findFieldByName(String str) {
            DescriptorPool access$0 = this.file.pool;
            GenericDescriptor findSymbol = access$0.findSymbol(String.valueOf(this.fullName) + FilenameUtils.EXTENSION_SEPARATOR + str);
            if (findSymbol == null || !(findSymbol instanceof FieldDescriptor)) {
                return null;
            }
            return (FieldDescriptor) findSymbol;
        }

        public final FieldDescriptor findFieldByNumber(int i) {
            return (FieldDescriptor) this.file.pool.fieldsByNumber.get(new DescriptorPool.DescriptorIntPair(this, i));
        }

        public final Descriptor findNestedTypeByName(String str) {
            DescriptorPool access$0 = this.file.pool;
            GenericDescriptor findSymbol = access$0.findSymbol(String.valueOf(this.fullName) + FilenameUtils.EXTENSION_SEPARATOR + str);
            if (findSymbol == null || !(findSymbol instanceof Descriptor)) {
                return null;
            }
            return (Descriptor) findSymbol;
        }

        public final Descriptor getContainingType() {
            return this.containingType;
        }

        public final List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public final List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public final List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public final FileDescriptor getFile() {
            return this.file;
        }

        public final String getFullName() {
            return this.fullName;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.proto.getName();
        }

        public final List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public final DescriptorProtos.MessageOptions getOptions() {
            return this.proto.getOptions();
        }

        public final boolean isExtensionNumber(int i) {
            for (DescriptorProtos.DescriptorProto.ExtensionRange next : this.proto.getExtensionRangeList()) {
                if (next.getStart() <= i && i < next.getEnd()) {
                    return true;
                }
            }
            return false;
        }

        public final DescriptorProtos.DescriptorProto toProto() {
            return this.proto;
        }
    }

    private static final class DescriptorPool {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Set<FileDescriptor> dependencies = new HashSet();
        private final Map<String, GenericDescriptor> descriptorsByName = new HashMap();
        /* access modifiers changed from: private */
        public final Map<DescriptorIntPair, EnumValueDescriptor> enumValuesByNumber = new HashMap();
        /* access modifiers changed from: private */
        public final Map<DescriptorIntPair, FieldDescriptor> fieldsByNumber = new HashMap();

        private static final class DescriptorIntPair {
            private final GenericDescriptor descriptor;
            private final int number;

            DescriptorIntPair(GenericDescriptor genericDescriptor, int i) {
                this.descriptor = genericDescriptor;
                this.number = i;
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof DescriptorIntPair)) {
                    return false;
                }
                DescriptorIntPair descriptorIntPair = (DescriptorIntPair) obj;
                return this.descriptor == descriptorIntPair.descriptor && this.number == descriptorIntPair.number;
            }

            public final int hashCode() {
                return (this.descriptor.hashCode() * 65535) + this.number;
            }
        }

        private static final class PackageDescriptor implements GenericDescriptor {
            private final FileDescriptor file;
            private final String fullName;
            private final String name;

            PackageDescriptor(String str, String str2, FileDescriptor fileDescriptor) {
                this.file = fileDescriptor;
                this.fullName = str2;
                this.name = str;
            }

            public final FileDescriptor getFile() {
                return this.file;
            }

            public final String getFullName() {
                return this.fullName;
            }

            public final String getName() {
                return this.name;
            }

            public final Message toProto() {
                return this.file.toProto();
            }
        }

        enum SearchFilter {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        static {
            Class<Descriptors> cls = Descriptors.class;
        }

        DescriptorPool(FileDescriptor[] fileDescriptorArr) {
            for (int i = 0; i < fileDescriptorArr.length; i++) {
                this.dependencies.add(fileDescriptorArr[i]);
                importPublicDependencies(fileDescriptorArr[i]);
            }
            for (FileDescriptor next : this.dependencies) {
                try {
                    addPackage(next.getPackage(), next);
                } catch (DescriptorValidationException unused) {
                }
            }
        }

        private void importPublicDependencies(FileDescriptor fileDescriptor) {
            for (FileDescriptor next : fileDescriptor.getPublicDependencies()) {
                if (this.dependencies.add(next)) {
                    importPublicDependencies(next);
                }
            }
        }

        static void validateSymbolName(GenericDescriptor genericDescriptor) throws DescriptorValidationException {
            String name = genericDescriptor.getName();
            if (name.length() == 0) {
                throw new DescriptorValidationException(genericDescriptor, "Missing name.", (DescriptorValidationException) null);
            }
            boolean z = true;
            for (int i = 0; i < name.length(); i++) {
                char charAt = name.charAt(i);
                if (charAt >= 128) {
                    z = false;
                }
                if (!Character.isLetter(charAt) && charAt != '_' && (!Character.isDigit(charAt) || i <= 0)) {
                    z = false;
                }
            }
            if (!z) {
                throw new DescriptorValidationException(genericDescriptor, "\"" + name + "\" is not a valid identifier.", (DescriptorValidationException) null);
            }
        }

        /* access modifiers changed from: package-private */
        public final void addEnumValueByNumber(EnumValueDescriptor enumValueDescriptor) {
            DescriptorIntPair descriptorIntPair = new DescriptorIntPair(enumValueDescriptor.getType(), enumValueDescriptor.getNumber());
            EnumValueDescriptor put = this.enumValuesByNumber.put(descriptorIntPair, enumValueDescriptor);
            if (put != null) {
                this.enumValuesByNumber.put(descriptorIntPair, put);
            }
        }

        /* access modifiers changed from: package-private */
        public final void addFieldByNumber(FieldDescriptor fieldDescriptor) throws DescriptorValidationException {
            DescriptorIntPair descriptorIntPair = new DescriptorIntPair(fieldDescriptor.getContainingType(), fieldDescriptor.getNumber());
            FieldDescriptor put = this.fieldsByNumber.put(descriptorIntPair, fieldDescriptor);
            if (put != null) {
                this.fieldsByNumber.put(descriptorIntPair, put);
                throw new DescriptorValidationException((GenericDescriptor) fieldDescriptor, "Field number " + fieldDescriptor.getNumber() + "has already been used in \"" + fieldDescriptor.getContainingType().getFullName() + "\" by field \"" + put.getName() + "\".", (DescriptorValidationException) null);
            }
        }

        /* access modifiers changed from: package-private */
        public final void addPackage(String str, FileDescriptor fileDescriptor) throws DescriptorValidationException {
            String str2;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str2 = str;
            } else {
                addPackage(str.substring(0, lastIndexOf), fileDescriptor);
                str2 = str.substring(lastIndexOf + 1);
            }
            GenericDescriptor put = this.descriptorsByName.put(str, new PackageDescriptor(str2, str, fileDescriptor));
            if (put != null) {
                this.descriptorsByName.put(str, put);
                if (!(put instanceof PackageDescriptor)) {
                    throw new DescriptorValidationException(fileDescriptor, "\"" + str2 + "\" is already defined (as something other than a package) in file \"" + put.getFile().getName() + "\".", (DescriptorValidationException) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void addSymbol(GenericDescriptor genericDescriptor) throws DescriptorValidationException {
            validateSymbolName(genericDescriptor);
            String fullName = genericDescriptor.getFullName();
            int lastIndexOf = fullName.lastIndexOf(46);
            GenericDescriptor put = this.descriptorsByName.put(fullName, genericDescriptor);
            if (put != null) {
                this.descriptorsByName.put(fullName, put);
                if (genericDescriptor.getFile() != put.getFile()) {
                    throw new DescriptorValidationException(genericDescriptor, "\"" + fullName + "\" is already defined in file \"" + put.getFile().getName() + "\".", (DescriptorValidationException) null);
                } else if (lastIndexOf == -1) {
                    throw new DescriptorValidationException(genericDescriptor, "\"" + fullName + "\" is already defined.", (DescriptorValidationException) null);
                } else {
                    throw new DescriptorValidationException(genericDescriptor, "\"" + fullName.substring(lastIndexOf + 1) + "\" is already defined in \"" + fullName.substring(0, lastIndexOf) + "\".", (DescriptorValidationException) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final GenericDescriptor findSymbol(String str) {
            return findSymbol(str, SearchFilter.ALL_SYMBOLS);
        }

        /* access modifiers changed from: package-private */
        public final GenericDescriptor findSymbol(String str, SearchFilter searchFilter) {
            GenericDescriptor genericDescriptor = this.descriptorsByName.get(str);
            if (genericDescriptor != null && (searchFilter == SearchFilter.ALL_SYMBOLS || ((searchFilter == SearchFilter.TYPES_ONLY && isType(genericDescriptor)) || (searchFilter == SearchFilter.AGGREGATES_ONLY && isAggregate(genericDescriptor))))) {
                return genericDescriptor;
            }
            for (FileDescriptor access$0 : this.dependencies) {
                GenericDescriptor genericDescriptor2 = access$0.pool.descriptorsByName.get(str);
                if (genericDescriptor2 != null && (searchFilter == SearchFilter.ALL_SYMBOLS || ((searchFilter == SearchFilter.TYPES_ONLY && isType(genericDescriptor2)) || (searchFilter == SearchFilter.AGGREGATES_ONLY && isAggregate(genericDescriptor2))))) {
                    return genericDescriptor2;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final boolean isAggregate(GenericDescriptor genericDescriptor) {
            return (genericDescriptor instanceof Descriptor) || (genericDescriptor instanceof EnumDescriptor) || (genericDescriptor instanceof PackageDescriptor) || (genericDescriptor instanceof ServiceDescriptor);
        }

        /* access modifiers changed from: package-private */
        public final boolean isType(GenericDescriptor genericDescriptor) {
            return (genericDescriptor instanceof Descriptor) || (genericDescriptor instanceof EnumDescriptor);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0076 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.protobuf.Descriptors.GenericDescriptor lookupSymbol(java.lang.String r9, com.google.protobuf.Descriptors.GenericDescriptor r10, com.google.protobuf.Descriptors.DescriptorPool.SearchFilter r11) throws com.google.protobuf.Descriptors.DescriptorValidationException {
            /*
                r8 = this;
                java.lang.String r0 = "."
                boolean r0 = r9.startsWith(r0)
                if (r0 == 0) goto L_0x0012
                r0 = 1
                java.lang.String r0 = r9.substring(r0)
            L_0x000d:
                com.google.protobuf.Descriptors$GenericDescriptor r11 = r8.findSymbol(r0, r11)
                goto L_0x005a
            L_0x0012:
                r0 = 46
                int r0 = r9.indexOf(r0)
                r1 = -1
                if (r0 != r1) goto L_0x001d
                r2 = r9
                goto L_0x0022
            L_0x001d:
                r2 = 0
                java.lang.String r2 = r9.substring(r2, r0)
            L_0x0022:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = r10.getFullName()
                r3.<init>(r4)
            L_0x002b:
                java.lang.String r4 = "."
                int r4 = r3.lastIndexOf(r4)
                if (r4 != r1) goto L_0x0038
                com.google.protobuf.Descriptors$GenericDescriptor r11 = r8.findSymbol(r9, r11)
                goto L_0x005a
            L_0x0038:
                int r5 = r4 + 1
                r3.setLength(r5)
                r3.append(r2)
                java.lang.String r6 = r3.toString()
                com.google.protobuf.Descriptors$DescriptorPool$SearchFilter r7 = com.google.protobuf.Descriptors.DescriptorPool.SearchFilter.AGGREGATES_ONLY
                com.google.protobuf.Descriptors$GenericDescriptor r6 = r8.findSymbol(r6, r7)
                if (r6 == 0) goto L_0x0077
                if (r0 == r1) goto L_0x0059
                r3.setLength(r5)
                r3.append(r9)
                java.lang.String r0 = r3.toString()
                goto L_0x000d
            L_0x0059:
                r11 = r6
            L_0x005a:
                if (r11 != 0) goto L_0x0076
                com.google.protobuf.Descriptors$DescriptorValidationException r11 = new com.google.protobuf.Descriptors$DescriptorValidationException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "\""
                r0.<init>(r1)
                r0.append(r9)
                java.lang.String r9 = "\" is not defined."
                r0.append(r9)
                java.lang.String r9 = r0.toString()
                r0 = 0
                r11.<init>((com.google.protobuf.Descriptors.GenericDescriptor) r10, (java.lang.String) r9, (com.google.protobuf.Descriptors.DescriptorValidationException) r0)
                throw r11
            L_0x0076:
                return r11
            L_0x0077:
                r3.setLength(r4)
                goto L_0x002b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Descriptors.DescriptorPool.lookupSymbol(java.lang.String, com.google.protobuf.Descriptors$GenericDescriptor, com.google.protobuf.Descriptors$DescriptorPool$SearchFilter):com.google.protobuf.Descriptors$GenericDescriptor");
        }
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final Message proto;

        private DescriptorValidationException(FileDescriptor fileDescriptor, String str) {
            super(String.valueOf(fileDescriptor.getName()) + ": " + str);
            this.name = fileDescriptor.getName();
            this.proto = fileDescriptor.toProto();
            this.description = str;
        }

        /* synthetic */ DescriptorValidationException(FileDescriptor fileDescriptor, String str, DescriptorValidationException descriptorValidationException) {
            this(fileDescriptor, str);
        }

        private DescriptorValidationException(GenericDescriptor genericDescriptor, String str) {
            super(String.valueOf(genericDescriptor.getFullName()) + ": " + str);
            this.name = genericDescriptor.getFullName();
            this.proto = genericDescriptor.toProto();
            this.description = str;
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor genericDescriptor, String str, DescriptorValidationException descriptorValidationException) {
            this(genericDescriptor, str);
        }

        private DescriptorValidationException(GenericDescriptor genericDescriptor, String str, Throwable th) {
            this(genericDescriptor, str);
            initCause(th);
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor genericDescriptor, String str, Throwable th, DescriptorValidationException descriptorValidationException) {
            this(genericDescriptor, str, th);
        }

        public String getDescription() {
            return this.description;
        }

        public Message getProblemProto() {
            return this.proto;
        }

        public String getProblemSymbolName() {
            return this.name;
        }
    }

    public static final class EnumDescriptor implements GenericDescriptor, Internal.EnumLiteMap<EnumValueDescriptor> {
        private final Descriptor containingType;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private DescriptorProtos.EnumDescriptorProto proto;
        private EnumValueDescriptor[] values;

        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i) throws DescriptorValidationException {
            this.index = i;
            this.proto = enumDescriptorProto;
            this.fullName = Descriptors.computeFullName(fileDescriptor, descriptor, enumDescriptorProto.getName());
            this.file = fileDescriptor;
            this.containingType = descriptor;
            if (enumDescriptorProto.getValueCount() == 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Enums must contain at least one value.", (DescriptorValidationException) null);
            }
            this.values = new EnumValueDescriptor[enumDescriptorProto.getValueCount()];
            for (int i2 = 0; i2 < enumDescriptorProto.getValueCount(); i2++) {
                this.values[i2] = new EnumValueDescriptor(enumDescriptorProto.getValue(i2), fileDescriptor, this, i2, (EnumValueDescriptor) null);
            }
            fileDescriptor.pool.addSymbol(this);
        }

        /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, EnumDescriptor enumDescriptor) throws DescriptorValidationException {
            this(enumDescriptorProto, fileDescriptor, descriptor, i);
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.EnumDescriptorProto enumDescriptorProto) {
            this.proto = enumDescriptorProto;
            for (int i = 0; i < this.values.length; i++) {
                this.values[i].setProto(enumDescriptorProto.getValue(i));
            }
        }

        public final EnumValueDescriptor findValueByName(String str) {
            DescriptorPool access$0 = this.file.pool;
            GenericDescriptor findSymbol = access$0.findSymbol(String.valueOf(this.fullName) + FilenameUtils.EXTENSION_SEPARATOR + str);
            if (findSymbol == null || !(findSymbol instanceof EnumValueDescriptor)) {
                return null;
            }
            return (EnumValueDescriptor) findSymbol;
        }

        public final EnumValueDescriptor findValueByNumber(int i) {
            return (EnumValueDescriptor) this.file.pool.enumValuesByNumber.get(new DescriptorPool.DescriptorIntPair(this, i));
        }

        public final Descriptor getContainingType() {
            return this.containingType;
        }

        public final FileDescriptor getFile() {
            return this.file;
        }

        public final String getFullName() {
            return this.fullName;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.proto.getName();
        }

        public final DescriptorProtos.EnumOptions getOptions() {
            return this.proto.getOptions();
        }

        public final List<EnumValueDescriptor> getValues() {
            return Collections.unmodifiableList(Arrays.asList(this.values));
        }

        public final DescriptorProtos.EnumDescriptorProto toProto() {
            return this.proto;
        }
    }

    public static final class EnumValueDescriptor implements GenericDescriptor, Internal.EnumLite {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private DescriptorProtos.EnumValueDescriptorProto proto;
        private final EnumDescriptor type;

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, int i) throws DescriptorValidationException {
            this.index = i;
            this.proto = enumValueDescriptorProto;
            this.file = fileDescriptor;
            this.type = enumDescriptor;
            this.fullName = String.valueOf(enumDescriptor.getFullName()) + FilenameUtils.EXTENSION_SEPARATOR + enumValueDescriptorProto.getName();
            fileDescriptor.pool.addSymbol(this);
            fileDescriptor.pool.addEnumValueByNumber(this);
        }

        /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, int i, EnumValueDescriptor enumValueDescriptor) throws DescriptorValidationException {
            this(enumValueDescriptorProto, fileDescriptor, enumDescriptor, i);
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto) {
            this.proto = enumValueDescriptorProto;
        }

        public final FileDescriptor getFile() {
            return this.file;
        }

        public final String getFullName() {
            return this.fullName;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.proto.getName();
        }

        public final int getNumber() {
            return this.proto.getNumber();
        }

        public final DescriptorProtos.EnumValueOptions getOptions() {
            return this.proto.getOptions();
        }

        public final EnumDescriptor getType() {
            return this.type;
        }

        public final DescriptorProtos.EnumValueDescriptorProto toProto() {
            return this.proto;
        }
    }

    public static final class FieldDescriptor implements GenericDescriptor, FieldSet.FieldDescriptorLite<FieldDescriptor>, Comparable<FieldDescriptor> {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
        private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type;
        private static final WireFormat.FieldType[] table = WireFormat.FieldType.values();
        private Descriptor containingType;
        private Object defaultValue;
        private EnumDescriptor enumType;
        private final Descriptor extensionScope;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor messageType;
        private DescriptorProtos.FieldDescriptorProto proto;
        private Type type;

        public enum JavaType {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(0.0f)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(false),
            STRING(""),
            BYTE_STRING(ByteString.EMPTY),
            ENUM((String) null),
            MESSAGE((String) null);
            
            /* access modifiers changed from: private */
            public final Object defaultDefault;

            private JavaType(Object obj) {
                this.defaultDefault = obj;
            }
        }

        public enum Type {
            DOUBLE(JavaType.DOUBLE),
            FLOAT(JavaType.FLOAT),
            INT64(JavaType.LONG),
            UINT64(JavaType.LONG),
            INT32(JavaType.INT),
            FIXED64(JavaType.LONG),
            FIXED32(JavaType.INT),
            BOOL(JavaType.BOOLEAN),
            STRING(JavaType.STRING),
            GROUP(JavaType.MESSAGE),
            MESSAGE(JavaType.MESSAGE),
            BYTES(JavaType.BYTE_STRING),
            UINT32(JavaType.INT),
            ENUM(JavaType.ENUM),
            SFIXED32(JavaType.INT),
            SFIXED64(JavaType.LONG),
            SINT32(JavaType.INT),
            SINT64(JavaType.LONG);
            
            private JavaType javaType;

            private Type(JavaType javaType2) {
                this.javaType = javaType2;
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type type) {
                return values()[type.getNumber() - 1];
            }

            public final JavaType getJavaType() {
                return this.javaType;
            }

            public final DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.valueOf(ordinal() + 1);
            }
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
        static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType() {
            /*
                int[] r0 = $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType
                if (r0 == 0) goto L_0x0005
                return r0
            L_0x0005:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0015 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x001e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0031 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.FLOAT     // Catch:{ NoSuchFieldError -> 0x003a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003a }
            L_0x003a:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.INT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.LONG     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Descriptors.FieldDescriptor.$SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType():int[]");
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
        static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type() {
            /*
                int[] r0 = $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type
                if (r0 == 0) goto L_0x0005
                return r0
            L_0x0005:
                com.google.protobuf.Descriptors$FieldDescriptor$Type[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BOOL     // Catch:{ NoSuchFieldError -> 0x0016 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BYTES     // Catch:{ NoSuchFieldError -> 0x0020 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0020 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0020 }
            L_0x0020:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0029 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED32     // Catch:{ NoSuchFieldError -> 0x003c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED64     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FLOAT     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT32     // Catch:{ NoSuchFieldError -> 0x0061 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT64     // Catch:{ NoSuchFieldError -> 0x006a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED32     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT32     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.STRING     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT32     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT64     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Descriptors.FieldDescriptor.$SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type():int[]");
        }

        static {
            if (Type.values().length != DescriptorProtos.FieldDescriptorProto.Type.values().length) {
                throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
            }
        }

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, boolean z) throws DescriptorValidationException {
            this.index = i;
            this.proto = fieldDescriptorProto;
            this.fullName = Descriptors.computeFullName(fileDescriptor, descriptor, fieldDescriptorProto.getName());
            this.file = fileDescriptor;
            if (fieldDescriptorProto.hasType()) {
                this.type = Type.valueOf(fieldDescriptorProto.getType());
            }
            if (getNumber() <= 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Field numbers must be positive integers.", (DescriptorValidationException) null);
            } else if (!fieldDescriptorProto.getOptions().getPacked() || isPackable()) {
                if (z) {
                    if (!fieldDescriptorProto.hasExtendee()) {
                        throw new DescriptorValidationException((GenericDescriptor) this, "FieldDescriptorProto.extendee not set for extension field.", (DescriptorValidationException) null);
                    }
                    this.containingType = null;
                    if (descriptor != null) {
                        this.extensionScope = descriptor;
                        fileDescriptor.pool.addSymbol(this);
                    }
                } else if (fieldDescriptorProto.hasExtendee()) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "FieldDescriptorProto.extendee set for non-extension field.", (DescriptorValidationException) null);
                } else {
                    this.containingType = descriptor;
                }
                this.extensionScope = null;
                fileDescriptor.pool.addSymbol(this);
            } else {
                throw new DescriptorValidationException((GenericDescriptor) this, "[packed = true] can only be specified for repeated primitive fields.", (DescriptorValidationException) null);
            }
        }

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, boolean z, FieldDescriptor fieldDescriptor) throws DescriptorValidationException {
            this(fieldDescriptorProto, fileDescriptor, descriptor, i, z);
        }

        /* access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            Object obj;
            Object valueOf;
            Type type2;
            if (this.proto.hasExtendee()) {
                GenericDescriptor lookupSymbol = this.file.pool.lookupSymbol(this.proto.getExtendee(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
                if (!(lookupSymbol instanceof Descriptor)) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "\"" + this.proto.getExtendee() + "\" is not a message type.", (DescriptorValidationException) null);
                }
                this.containingType = (Descriptor) lookupSymbol;
                if (!getContainingType().isExtensionNumber(getNumber())) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "\"" + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", (DescriptorValidationException) null);
                }
            }
            if (this.proto.hasTypeName()) {
                GenericDescriptor lookupSymbol2 = this.file.pool.lookupSymbol(this.proto.getTypeName(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
                if (!this.proto.hasType()) {
                    if (lookupSymbol2 instanceof Descriptor) {
                        type2 = Type.MESSAGE;
                    } else if (lookupSymbol2 instanceof EnumDescriptor) {
                        type2 = Type.ENUM;
                    } else {
                        throw new DescriptorValidationException((GenericDescriptor) this, "\"" + this.proto.getTypeName() + "\" is not a type.", (DescriptorValidationException) null);
                    }
                    this.type = type2;
                }
                if (getJavaType() == JavaType.MESSAGE) {
                    if (!(lookupSymbol2 instanceof Descriptor)) {
                        throw new DescriptorValidationException((GenericDescriptor) this, "\"" + this.proto.getTypeName() + "\" is not a message type.", (DescriptorValidationException) null);
                    }
                    this.messageType = (Descriptor) lookupSymbol2;
                    if (this.proto.hasDefaultValue()) {
                        throw new DescriptorValidationException((GenericDescriptor) this, "Messages can't have default values.", (DescriptorValidationException) null);
                    }
                } else if (getJavaType() != JavaType.ENUM) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "Field with primitive type has type_name.", (DescriptorValidationException) null);
                } else if (!(lookupSymbol2 instanceof EnumDescriptor)) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "\"" + this.proto.getTypeName() + "\" is not an enum type.", (DescriptorValidationException) null);
                } else {
                    this.enumType = (EnumDescriptor) lookupSymbol2;
                }
            } else if (getJavaType() == JavaType.MESSAGE || getJavaType() == JavaType.ENUM) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Field with message or enum type missing type_name.", (DescriptorValidationException) null);
            }
            if (!this.proto.hasDefaultValue()) {
                if (!isRepeated()) {
                    switch ($SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType()[getJavaType().ordinal()]) {
                        case 8:
                            obj = this.enumType.getValues().get(0);
                            break;
                        case 9:
                            this.defaultValue = null;
                            break;
                        default:
                            obj = getJavaType().defaultDefault;
                            break;
                    }
                } else {
                    obj = Collections.emptyList();
                }
                this.defaultValue = obj;
            } else if (isRepeated()) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Repeated fields cannot have default values.", (DescriptorValidationException) null);
            } else {
                try {
                    switch ($SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type()[getType().ordinal()]) {
                        case 1:
                            if (!this.proto.getDefaultValue().equals("inf")) {
                                if (!this.proto.getDefaultValue().equals("-inf")) {
                                    if (!this.proto.getDefaultValue().equals("nan")) {
                                        valueOf = Double.valueOf(this.proto.getDefaultValue());
                                        break;
                                    } else {
                                        valueOf = Double.valueOf(Double.NaN);
                                        break;
                                    }
                                } else {
                                    valueOf = Double.valueOf(Double.NEGATIVE_INFINITY);
                                    break;
                                }
                            } else {
                                valueOf = Double.valueOf(Double.POSITIVE_INFINITY);
                                break;
                            }
                        case 2:
                            if (!this.proto.getDefaultValue().equals("inf")) {
                                if (!this.proto.getDefaultValue().equals("-inf")) {
                                    if (!this.proto.getDefaultValue().equals("nan")) {
                                        valueOf = Float.valueOf(this.proto.getDefaultValue());
                                        break;
                                    } else {
                                        valueOf = Float.valueOf(Float.NaN);
                                        break;
                                    }
                                } else {
                                    valueOf = Float.valueOf(Float.NEGATIVE_INFINITY);
                                    break;
                                }
                            } else {
                                valueOf = Float.valueOf(Float.POSITIVE_INFINITY);
                                break;
                            }
                        case 3:
                        case 16:
                        case 18:
                            valueOf = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));
                            break;
                        case 4:
                        case 6:
                            valueOf = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));
                            break;
                        case 5:
                        case 15:
                        case 17:
                            valueOf = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));
                            break;
                        case 7:
                        case 13:
                            valueOf = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));
                            break;
                        case 8:
                            valueOf = Boolean.valueOf(this.proto.getDefaultValue());
                            break;
                        case 9:
                            valueOf = this.proto.getDefaultValue();
                            break;
                        case 10:
                        case 11:
                            throw new DescriptorValidationException((GenericDescriptor) this, "Message type had default value.", (DescriptorValidationException) null);
                        case 12:
                            this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());
                            break;
                        case 14:
                            this.defaultValue = this.enumType.findValueByName(this.proto.getDefaultValue());
                            if (this.defaultValue == null) {
                                throw new DescriptorValidationException((GenericDescriptor) this, "Unknown enum default value: \"" + this.proto.getDefaultValue() + '\"', (DescriptorValidationException) null);
                            }
                            break;
                    }
                    this.defaultValue = valueOf;
                } catch (TextFormat.InvalidEscapeSequenceException e) {
                    throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, (DescriptorValidationException) null);
                } catch (NumberFormatException e2) {
                    throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.proto.getDefaultValue() + '\"', e2, (DescriptorValidationException) null);
                }
            }
            if (!isExtension()) {
                this.file.pool.addFieldByNumber(this);
            }
            if (this.containingType != null && this.containingType.getOptions().getMessageSetWireFormat()) {
                if (!isExtension()) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "MessageSets cannot have fields, only extensions.", (DescriptorValidationException) null);
                } else if (!isOptional() || getType() != Type.MESSAGE) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "Extensions of MessageSets must be optional messages.", (DescriptorValidationException) null);
                }
            }
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto) {
            this.proto = fieldDescriptorProto;
        }

        public final int compareTo(FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.containingType == this.containingType) {
                return getNumber() - fieldDescriptor.getNumber();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        public final Descriptor getContainingType() {
            return this.containingType;
        }

        public final Object getDefaultValue() {
            if (getJavaType() != JavaType.MESSAGE) {
                return this.defaultValue;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public final EnumDescriptor getEnumType() {
            if (getJavaType() == JavaType.ENUM) {
                return this.enumType;
            }
            throw new UnsupportedOperationException("This field is not of enum type.");
        }

        public final Descriptor getExtensionScope() {
            if (isExtension()) {
                return this.extensionScope;
            }
            throw new UnsupportedOperationException("This field is not an extension.");
        }

        public final FileDescriptor getFile() {
            return this.file;
        }

        public final String getFullName() {
            return this.fullName;
        }

        public final int getIndex() {
            return this.index;
        }

        public final JavaType getJavaType() {
            return this.type.getJavaType();
        }

        public final WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        public final WireFormat.FieldType getLiteType() {
            return table[this.type.ordinal()];
        }

        public final Descriptor getMessageType() {
            if (getJavaType() == JavaType.MESSAGE) {
                return this.messageType;
            }
            throw new UnsupportedOperationException("This field is not of message type.");
        }

        public final String getName() {
            return this.proto.getName();
        }

        public final int getNumber() {
            return this.proto.getNumber();
        }

        public final DescriptorProtos.FieldOptions getOptions() {
            return this.proto.getOptions();
        }

        public final Type getType() {
            return this.type;
        }

        public final boolean hasDefaultValue() {
            return this.proto.hasDefaultValue();
        }

        public final MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Message.Builder) builder).mergeFrom((Message) messageLite);
        }

        public final boolean isExtension() {
            return this.proto.hasExtendee();
        }

        public final boolean isOptional() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
        }

        public final boolean isPackable() {
            return isRepeated() && getLiteType().isPackable();
        }

        public final boolean isPacked() {
            return getOptions().getPacked();
        }

        public final boolean isRepeated() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
        }

        public final boolean isRequired() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED;
        }

        public final DescriptorProtos.FieldDescriptorProto toProto() {
            return this.proto;
        }
    }

    public static final class FileDescriptor {
        private final FileDescriptor[] dependencies;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final Descriptor[] messageTypes;
        /* access modifiers changed from: private */
        public final DescriptorPool pool;
        private DescriptorProtos.FileDescriptorProto proto;
        private final FileDescriptor[] publicDependencies;
        private final ServiceDescriptor[] services;

        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor fileDescriptor);
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, DescriptorPool descriptorPool) throws DescriptorValidationException {
            this.pool = descriptorPool;
            this.proto = fileDescriptorProto;
            this.dependencies = (FileDescriptor[]) fileDescriptorArr.clone();
            this.publicDependencies = new FileDescriptor[fileDescriptorProto.getPublicDependencyCount()];
            for (int i = 0; i < fileDescriptorProto.getPublicDependencyCount(); i++) {
                int publicDependency = fileDescriptorProto.getPublicDependency(i);
                if (publicDependency < 0 || publicDependency >= this.dependencies.length) {
                    throw new DescriptorValidationException(this, "Invalid public dependency index.", (DescriptorValidationException) null);
                }
                this.publicDependencies[i] = this.dependencies[fileDescriptorProto.getPublicDependency(i)];
            }
            descriptorPool.addPackage(getPackage(), this);
            this.messageTypes = new Descriptor[fileDescriptorProto.getMessageTypeCount()];
            for (int i2 = 0; i2 < fileDescriptorProto.getMessageTypeCount(); i2++) {
                this.messageTypes[i2] = new Descriptor(fileDescriptorProto.getMessageType(i2), this, (Descriptor) null, i2, (Descriptor) null);
            }
            this.enumTypes = new EnumDescriptor[fileDescriptorProto.getEnumTypeCount()];
            for (int i3 = 0; i3 < fileDescriptorProto.getEnumTypeCount(); i3++) {
                this.enumTypes[i3] = new EnumDescriptor(fileDescriptorProto.getEnumType(i3), this, (Descriptor) null, i3, (EnumDescriptor) null);
            }
            this.services = new ServiceDescriptor[fileDescriptorProto.getServiceCount()];
            for (int i4 = 0; i4 < fileDescriptorProto.getServiceCount(); i4++) {
                this.services[i4] = new ServiceDescriptor(fileDescriptorProto.getService(i4), this, i4, (ServiceDescriptor) null);
            }
            this.extensions = new FieldDescriptor[fileDescriptorProto.getExtensionCount()];
            for (int i5 = 0; i5 < fileDescriptorProto.getExtensionCount(); i5++) {
                this.extensions[i5] = new FieldDescriptor(fileDescriptorProto.getExtension(i5), this, (Descriptor) null, i5, true, (FieldDescriptor) null);
            }
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr) throws DescriptorValidationException {
            FileDescriptor fileDescriptor = new FileDescriptor(fileDescriptorProto, fileDescriptorArr, new DescriptorPool(fileDescriptorArr));
            if (fileDescriptorArr.length != fileDescriptorProto.getDependencyCount()) {
                throw new DescriptorValidationException(fileDescriptor, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", (DescriptorValidationException) null);
            }
            for (int i = 0; i < fileDescriptorProto.getDependencyCount(); i++) {
                if (!fileDescriptorArr[i].getName().equals(fileDescriptorProto.getDependency(i))) {
                    throw new DescriptorValidationException(fileDescriptor, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", (DescriptorValidationException) null);
                }
            }
            fileDescriptor.crossLink();
            return fileDescriptor;
        }

        private void crossLink() throws DescriptorValidationException {
            for (Descriptor access$2 : this.messageTypes) {
                access$2.crossLink();
            }
            for (ServiceDescriptor access$22 : this.services) {
                access$22.crossLink();
            }
            for (FieldDescriptor access$4 : this.extensions) {
                access$4.crossLink();
            }
        }

        public static void internalBuildGeneratedFileFrom(String[] strArr, FileDescriptor[] fileDescriptorArr, InternalDescriptorAssigner internalDescriptorAssigner) {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
            }
            try {
                byte[] bytes = sb.toString().getBytes(CharsetUtils.DEFAULT_ENCODING_CHARSET);
                try {
                    DescriptorProtos.FileDescriptorProto parseFrom = DescriptorProtos.FileDescriptorProto.parseFrom(bytes);
                    try {
                        FileDescriptor buildFrom = buildFrom(parseFrom, fileDescriptorArr);
                        ExtensionRegistry assignDescriptors = internalDescriptorAssigner.assignDescriptors(buildFrom);
                        if (assignDescriptors != null) {
                            try {
                                buildFrom.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(bytes, (ExtensionRegistryLite) assignDescriptors));
                            } catch (InvalidProtocolBufferException e) {
                                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
                            }
                        }
                    } catch (DescriptorValidationException e2) {
                        throw new IllegalArgumentException("Invalid embedded descriptor for \"" + parseFrom.getName() + "\".", e2);
                    }
                } catch (InvalidProtocolBufferException e3) {
                    throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e3);
                }
            } catch (UnsupportedEncodingException e4) {
                throw new RuntimeException("Standard encoding ISO-8859-1 not supported by JVM.", e4);
            }
        }

        private void setProto(DescriptorProtos.FileDescriptorProto fileDescriptorProto) {
            this.proto = fileDescriptorProto;
            for (int i = 0; i < this.messageTypes.length; i++) {
                this.messageTypes[i].setProto(fileDescriptorProto.getMessageType(i));
            }
            for (int i2 = 0; i2 < this.enumTypes.length; i2++) {
                this.enumTypes[i2].setProto(fileDescriptorProto.getEnumType(i2));
            }
            for (int i3 = 0; i3 < this.services.length; i3++) {
                this.services[i3].setProto(fileDescriptorProto.getService(i3));
            }
            for (int i4 = 0; i4 < this.extensions.length; i4++) {
                this.extensions[i4].setProto(fileDescriptorProto.getExtension(i4));
            }
        }

        public final EnumDescriptor findEnumTypeByName(String str) {
            if (str.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                str = String.valueOf(getPackage()) + FilenameUtils.EXTENSION_SEPARATOR + str;
            }
            GenericDescriptor findSymbol = this.pool.findSymbol(str);
            if (findSymbol == null || !(findSymbol instanceof EnumDescriptor) || findSymbol.getFile() != this) {
                return null;
            }
            return (EnumDescriptor) findSymbol;
        }

        public final FieldDescriptor findExtensionByName(String str) {
            if (str.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                str = String.valueOf(getPackage()) + FilenameUtils.EXTENSION_SEPARATOR + str;
            }
            GenericDescriptor findSymbol = this.pool.findSymbol(str);
            if (findSymbol == null || !(findSymbol instanceof FieldDescriptor) || findSymbol.getFile() != this) {
                return null;
            }
            return (FieldDescriptor) findSymbol;
        }

        public final Descriptor findMessageTypeByName(String str) {
            if (str.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                str = String.valueOf(getPackage()) + FilenameUtils.EXTENSION_SEPARATOR + str;
            }
            GenericDescriptor findSymbol = this.pool.findSymbol(str);
            if (findSymbol == null || !(findSymbol instanceof Descriptor) || findSymbol.getFile() != this) {
                return null;
            }
            return (Descriptor) findSymbol;
        }

        public final ServiceDescriptor findServiceByName(String str) {
            if (str.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                str = String.valueOf(getPackage()) + FilenameUtils.EXTENSION_SEPARATOR + str;
            }
            GenericDescriptor findSymbol = this.pool.findSymbol(str);
            if (findSymbol == null || !(findSymbol instanceof ServiceDescriptor) || findSymbol.getFile() != this) {
                return null;
            }
            return (ServiceDescriptor) findSymbol;
        }

        public final List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        public final List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public final List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public final List<Descriptor> getMessageTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
        }

        public final String getName() {
            return this.proto.getName();
        }

        public final DescriptorProtos.FileOptions getOptions() {
            return this.proto.getOptions();
        }

        public final String getPackage() {
            return this.proto.getPackage();
        }

        public final List<FileDescriptor> getPublicDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
        }

        public final List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        public final DescriptorProtos.FileDescriptorProto toProto() {
            return this.proto;
        }
    }

    private interface GenericDescriptor {
        FileDescriptor getFile();

        String getFullName();

        String getName();

        Message toProto();
    }

    public static final class MethodDescriptor implements GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor inputType;
        private Descriptor outputType;
        private DescriptorProtos.MethodDescriptorProto proto;
        private final ServiceDescriptor service;

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, ServiceDescriptor serviceDescriptor, int i) throws DescriptorValidationException {
            this.index = i;
            this.proto = methodDescriptorProto;
            this.file = fileDescriptor;
            this.service = serviceDescriptor;
            this.fullName = String.valueOf(serviceDescriptor.getFullName()) + FilenameUtils.EXTENSION_SEPARATOR + methodDescriptorProto.getName();
            fileDescriptor.pool.addSymbol(this);
        }

        /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, ServiceDescriptor serviceDescriptor, int i, MethodDescriptor methodDescriptor) throws DescriptorValidationException {
            this(methodDescriptorProto, fileDescriptor, serviceDescriptor, i);
        }

        /* access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            GenericDescriptor lookupSymbol = this.file.pool.lookupSymbol(this.proto.getInputType(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (!(lookupSymbol instanceof Descriptor)) {
                throw new DescriptorValidationException((GenericDescriptor) this, "\"" + this.proto.getInputType() + "\" is not a message type.", (DescriptorValidationException) null);
            }
            this.inputType = (Descriptor) lookupSymbol;
            GenericDescriptor lookupSymbol2 = this.file.pool.lookupSymbol(this.proto.getOutputType(), this, DescriptorPool.SearchFilter.TYPES_ONLY);
            if (!(lookupSymbol2 instanceof Descriptor)) {
                throw new DescriptorValidationException((GenericDescriptor) this, "\"" + this.proto.getOutputType() + "\" is not a message type.", (DescriptorValidationException) null);
            }
            this.outputType = (Descriptor) lookupSymbol2;
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.MethodDescriptorProto methodDescriptorProto) {
            this.proto = methodDescriptorProto;
        }

        public final FileDescriptor getFile() {
            return this.file;
        }

        public final String getFullName() {
            return this.fullName;
        }

        public final int getIndex() {
            return this.index;
        }

        public final Descriptor getInputType() {
            return this.inputType;
        }

        public final String getName() {
            return this.proto.getName();
        }

        public final DescriptorProtos.MethodOptions getOptions() {
            return this.proto.getOptions();
        }

        public final Descriptor getOutputType() {
            return this.outputType;
        }

        public final ServiceDescriptor getService() {
            return this.service;
        }

        public final DescriptorProtos.MethodDescriptorProto toProto() {
            return this.proto;
        }
    }

    public static final class ServiceDescriptor implements GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private MethodDescriptor[] methods;
        private DescriptorProtos.ServiceDescriptorProto proto;

        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i) throws DescriptorValidationException {
            this.index = i;
            this.proto = serviceDescriptorProto;
            this.fullName = Descriptors.computeFullName(fileDescriptor, (Descriptor) null, serviceDescriptorProto.getName());
            this.file = fileDescriptor;
            this.methods = new MethodDescriptor[serviceDescriptorProto.getMethodCount()];
            for (int i2 = 0; i2 < serviceDescriptorProto.getMethodCount(); i2++) {
                this.methods[i2] = new MethodDescriptor(serviceDescriptorProto.getMethod(i2), fileDescriptor, this, i2, (MethodDescriptor) null);
            }
            fileDescriptor.pool.addSymbol(this);
        }

        /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i, ServiceDescriptor serviceDescriptor) throws DescriptorValidationException {
            this(serviceDescriptorProto, fileDescriptor, i);
        }

        /* access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            for (MethodDescriptor access$2 : this.methods) {
                access$2.crossLink();
            }
        }

        /* access modifiers changed from: private */
        public void setProto(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto) {
            this.proto = serviceDescriptorProto;
            for (int i = 0; i < this.methods.length; i++) {
                this.methods[i].setProto(serviceDescriptorProto.getMethod(i));
            }
        }

        public final MethodDescriptor findMethodByName(String str) {
            DescriptorPool access$0 = this.file.pool;
            GenericDescriptor findSymbol = access$0.findSymbol(String.valueOf(this.fullName) + FilenameUtils.EXTENSION_SEPARATOR + str);
            if (findSymbol == null || !(findSymbol instanceof MethodDescriptor)) {
                return null;
            }
            return (MethodDescriptor) findSymbol;
        }

        public final FileDescriptor getFile() {
            return this.file;
        }

        public final String getFullName() {
            return this.fullName;
        }

        public final int getIndex() {
            return this.index;
        }

        public final List<MethodDescriptor> getMethods() {
            return Collections.unmodifiableList(Arrays.asList(this.methods));
        }

        public final String getName() {
            return this.proto.getName();
        }

        public final DescriptorProtos.ServiceOptions getOptions() {
            return this.proto.getOptions();
        }

        public final DescriptorProtos.ServiceDescriptorProto toProto() {
            return this.proto;
        }
    }

    /* access modifiers changed from: private */
    public static String computeFullName(FileDescriptor fileDescriptor, Descriptor descriptor, String str) {
        if (descriptor != null) {
            return String.valueOf(descriptor.getFullName()) + FilenameUtils.EXTENSION_SEPARATOR + str;
        } else if (fileDescriptor.getPackage().length() <= 0) {
            return str;
        } else {
            return String.valueOf(fileDescriptor.getPackage()) + FilenameUtils.EXTENSION_SEPARATOR + str;
        }
    }
}
