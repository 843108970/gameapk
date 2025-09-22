package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {
    private List<SingleFieldBuilder<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List<MType> messages;
    private GeneratedMessage.BuilderParent parent;

    private static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> repeatedFieldBuilder) {
            this.builder = repeatedFieldBuilder;
        }

        public BType get(int i) {
            return this.builder.getBuilder(i);
        }

        /* access modifiers changed from: package-private */
        public void incrementModCount() {
            this.modCount++;
        }

        public int size() {
            return this.builder.getCount();
        }
    }

    private static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> repeatedFieldBuilder) {
            this.builder = repeatedFieldBuilder;
        }

        public MType get(int i) {
            return this.builder.getMessage(i);
        }

        /* access modifiers changed from: package-private */
        public void incrementModCount() {
            this.modCount++;
        }

        public int size() {
            return this.builder.getCount();
        }
    }

    private static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> repeatedFieldBuilder) {
            this.builder = repeatedFieldBuilder;
        }

        public IType get(int i) {
            return this.builder.getMessageOrBuilder(i);
        }

        /* access modifiers changed from: package-private */
        public void incrementModCount() {
            this.modCount++;
        }

        public int size() {
            return this.builder.getCount();
        }
    }

    public RepeatedFieldBuilder(List<MType> list, boolean z, GeneratedMessage.BuilderParent builderParent, boolean z2) {
        this.messages = list;
        this.isMessagesListMutable = z;
        this.parent = builderParent;
        this.isClean = z2;
    }

    private void ensureBuilders() {
        if (this.builders == null) {
            this.builders = new ArrayList(this.messages.size());
            for (int i = 0; i < this.messages.size(); i++) {
                this.builders.add((Object) null);
            }
        }
    }

    private void ensureMutableMessageList() {
        if (!this.isMessagesListMutable) {
            this.messages = new ArrayList(this.messages);
            this.isMessagesListMutable = true;
        }
    }

    private MType getMessage(int i, boolean z) {
        SingleFieldBuilder singleFieldBuilder;
        return (this.builders == null || (singleFieldBuilder = this.builders.get(i)) == null) ? (GeneratedMessage) this.messages.get(i) : z ? singleFieldBuilder.build() : singleFieldBuilder.getMessage();
    }

    private void incrementModCounts() {
        if (this.externalMessageList != null) {
            this.externalMessageList.incrementModCount();
        }
        if (this.externalBuilderList != null) {
            this.externalBuilderList.incrementModCount();
        }
        if (this.externalMessageOrBuilderList != null) {
            this.externalMessageOrBuilderList.incrementModCount();
        }
    }

    private void onChanged() {
        if (this.isClean && this.parent != null) {
            this.parent.markDirty();
            this.isClean = false;
        }
    }

    public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> iterable) {
        Iterator<? extends MType> it = iterable.iterator();
        while (it.hasNext()) {
            if (((GeneratedMessage) it.next()) == null) {
                throw new NullPointerException();
            }
        }
        if (!(iterable instanceof Collection)) {
            ensureMutableMessageList();
            Iterator<? extends MType> it2 = iterable.iterator();
            while (it2.hasNext()) {
                addMessage((GeneratedMessage) it2.next());
            }
        } else if (((Collection) iterable).size() == 0) {
            return this;
        } else {
            ensureMutableMessageList();
            Iterator<? extends MType> it3 = iterable.iterator();
            while (it3.hasNext()) {
                addMessage((GeneratedMessage) it3.next());
            }
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public BType addBuilder(int i, MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder(mtype, this, this.isClean);
        this.messages.add(i, (Object) null);
        this.builders.add(i, singleFieldBuilder);
        onChanged();
        incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }

    public BType addBuilder(MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder singleFieldBuilder = new SingleFieldBuilder(mtype, this, this.isClean);
        this.messages.add((Object) null);
        this.builders.add(singleFieldBuilder);
        onChanged();
        incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(int i, MType mtype) {
        if (mtype == null) {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        this.messages.add(i, mtype);
        if (this.builders != null) {
            this.builders.add(i, (Object) null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType mtype) {
        if (mtype == null) {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        this.messages.add(mtype);
        if (this.builders != null) {
            this.builders.add((Object) null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public List<MType> build() {
        boolean z;
        this.isClean = true;
        if (!this.isMessagesListMutable && this.builders == null) {
            return this.messages;
        }
        if (!this.isMessagesListMutable) {
            int i = 0;
            while (true) {
                if (i < this.messages.size()) {
                    Message message = (Message) this.messages.get(i);
                    SingleFieldBuilder singleFieldBuilder = this.builders.get(i);
                    if (singleFieldBuilder != null && singleFieldBuilder.build() != message) {
                        z = false;
                        break;
                    }
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                return this.messages;
            }
        }
        ensureMutableMessageList();
        for (int i2 = 0; i2 < this.messages.size(); i2++) {
            this.messages.set(i2, getMessage(i2, true));
        }
        this.messages = Collections.unmodifiableList(this.messages);
        this.isMessagesListMutable = false;
        return this.messages;
    }

    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        if (this.builders != null) {
            for (SingleFieldBuilder next : this.builders) {
                if (next != null) {
                    next.dispose();
                }
            }
            this.builders = null;
        }
        onChanged();
        incrementModCounts();
    }

    public void dispose() {
        this.parent = null;
    }

    public BType getBuilder(int i) {
        ensureBuilders();
        SingleFieldBuilder singleFieldBuilder = this.builders.get(i);
        if (singleFieldBuilder == null) {
            SingleFieldBuilder singleFieldBuilder2 = new SingleFieldBuilder((GeneratedMessage) this.messages.get(i), this, this.isClean);
            this.builders.set(i, singleFieldBuilder2);
            singleFieldBuilder = singleFieldBuilder2;
        }
        return singleFieldBuilder.getBuilder();
    }

    public List<BType> getBuilderList() {
        if (this.externalBuilderList == null) {
            this.externalBuilderList = new BuilderExternalList<>(this);
        }
        return this.externalBuilderList;
    }

    public int getCount() {
        return this.messages.size();
    }

    public MType getMessage(int i) {
        return getMessage(i, false);
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList == null) {
            this.externalMessageList = new MessageExternalList<>(this);
        }
        return this.externalMessageList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r0 = r1.builders.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IType getMessageOrBuilder(int r2) {
        /*
            r1 = this;
            java.util.List<com.google.protobuf.SingleFieldBuilder<MType, BType, IType>> r0 = r1.builders
            if (r0 != 0) goto L_0x000d
        L_0x0004:
            java.util.List<MType> r0 = r1.messages
            java.lang.Object r2 = r0.get(r2)
            com.google.protobuf.MessageOrBuilder r2 = (com.google.protobuf.MessageOrBuilder) r2
            return r2
        L_0x000d:
            java.util.List<com.google.protobuf.SingleFieldBuilder<MType, BType, IType>> r0 = r1.builders
            java.lang.Object r0 = r0.get(r2)
            com.google.protobuf.SingleFieldBuilder r0 = (com.google.protobuf.SingleFieldBuilder) r0
            if (r0 != 0) goto L_0x0018
            goto L_0x0004
        L_0x0018:
            com.google.protobuf.MessageOrBuilder r2 = r0.getMessageOrBuilder()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.RepeatedFieldBuilder.getMessageOrBuilder(int):com.google.protobuf.MessageOrBuilder");
    }

    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList == null) {
            this.externalMessageOrBuilderList = new MessageOrBuilderExternalList<>(this);
        }
        return this.externalMessageOrBuilderList;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public void markDirty() {
        onChanged();
    }

    public void remove(int i) {
        SingleFieldBuilder remove;
        ensureMutableMessageList();
        this.messages.remove(i);
        if (!(this.builders == null || (remove = this.builders.remove(i)) == null)) {
            remove.dispose();
        }
        onChanged();
        incrementModCounts();
    }

    public RepeatedFieldBuilder<MType, BType, IType> setMessage(int i, MType mtype) {
        SingleFieldBuilder singleFieldBuilder;
        if (mtype == null) {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        this.messages.set(i, mtype);
        if (!(this.builders == null || (singleFieldBuilder = this.builders.set(i, (Object) null)) == null)) {
            singleFieldBuilder.dispose();
        }
        onChanged();
        incrementModCounts();
        return this;
    }
}
