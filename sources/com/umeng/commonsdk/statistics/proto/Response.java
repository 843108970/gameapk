package com.umeng.commonsdk.statistics.proto;

import android.support.v4.app.NotificationCompat;
import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ag;
import com.umeng.commonsdk.proguard.ah;
import com.umeng.commonsdk.proguard.am;
import com.umeng.commonsdk.proguard.an;
import com.umeng.commonsdk.proguard.ar;
import com.umeng.commonsdk.proguard.at;
import com.umeng.commonsdk.proguard.au;
import com.umeng.commonsdk.proguard.az;
import com.umeng.commonsdk.proguard.be;
import com.umeng.commonsdk.proguard.bf;
import com.umeng.commonsdk.proguard.bh;
import com.umeng.commonsdk.proguard.bi;
import com.umeng.commonsdk.proguard.bj;
import com.umeng.commonsdk.proguard.bk;
import com.umeng.commonsdk.proguard.bl;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.proguard.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Response implements aa<Response, e>, Serializable, Cloneable {
    /* access modifiers changed from: private */
    public static final au IMPRINT_FIELD_DESC = new au(v.Q, (byte) 12, 3);
    /* access modifiers changed from: private */
    public static final au MSG_FIELD_DESC = new au(NotificationCompat.CATEGORY_MESSAGE, (byte) 11, 2);
    /* access modifiers changed from: private */
    public static final au RESP_CODE_FIELD_DESC = new au("resp_code", (byte) 8, 1);
    /* access modifiers changed from: private */
    public static final be STRUCT_DESC = new be("Response");
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, am> metaDataMap;
    private static final Map<Class<? extends bh>, bi> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;

    private static class a extends bj<Response> {
        private a() {
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.umeng.commonsdk.proguard.az r5, com.umeng.commonsdk.statistics.proto.Response r6) throws com.umeng.commonsdk.proguard.ag {
            /*
                r4 = this;
                r5.j()
            L_0x0003:
                com.umeng.commonsdk.proguard.au r0 = r5.l()
                byte r1 = r0.f3725b
                if (r1 == 0) goto L_0x0050
                short r1 = r0.f3726c
                r2 = 1
                switch(r1) {
                    case 1: goto L_0x003d;
                    case 2: goto L_0x002d;
                    case 3: goto L_0x0017;
                    default: goto L_0x0011;
                }
            L_0x0011:
                byte r0 = r0.f3725b
                com.umeng.commonsdk.proguard.bc.a((com.umeng.commonsdk.proguard.az) r5, (byte) r0)
                goto L_0x004c
            L_0x0017:
                byte r1 = r0.f3725b
                r3 = 12
                if (r1 != r3) goto L_0x0011
                com.umeng.commonsdk.statistics.proto.d r0 = new com.umeng.commonsdk.statistics.proto.d
                r0.<init>()
                r6.imprint = r0
                com.umeng.commonsdk.statistics.proto.d r0 = r6.imprint
                r0.read(r5)
                r6.setImprintIsSet(r2)
                goto L_0x004c
            L_0x002d:
                byte r1 = r0.f3725b
                r3 = 11
                if (r1 != r3) goto L_0x0011
                java.lang.String r0 = r5.z()
                r6.msg = r0
                r6.setMsgIsSet(r2)
                goto L_0x004c
            L_0x003d:
                byte r1 = r0.f3725b
                r3 = 8
                if (r1 != r3) goto L_0x0011
                int r0 = r5.w()
                r6.resp_code = r0
                r6.setResp_codeIsSet(r2)
            L_0x004c:
                r5.m()
                goto L_0x0003
            L_0x0050:
                r5.k()
                boolean r5 = r6.isSetResp_code()
                if (r5 != 0) goto L_0x0071
                com.umeng.commonsdk.proguard.ba r5 = new com.umeng.commonsdk.proguard.ba
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r0 = "Required field 'resp_code' was not found in serialized data! Struct: "
                r6.<init>(r0)
                java.lang.String r0 = r4.toString()
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                r5.<init>((java.lang.String) r6)
                throw r5
            L_0x0071:
                r6.validate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.proto.Response.a.b(com.umeng.commonsdk.proguard.az, com.umeng.commonsdk.statistics.proto.Response):void");
        }

        /* renamed from: b */
        public void a(az azVar, Response response) throws ag {
            response.validate();
            azVar.a(Response.STRUCT_DESC);
            azVar.a(Response.RESP_CODE_FIELD_DESC);
            azVar.a(response.resp_code);
            azVar.c();
            if (response.msg != null && response.isSetMsg()) {
                azVar.a(Response.MSG_FIELD_DESC);
                azVar.a(response.msg);
                azVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                azVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(azVar);
                azVar.c();
            }
            azVar.d();
            azVar.b();
        }
    }

    private static class b implements bi {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    private static class c extends bk<Response> {
        private c() {
        }

        public void a(az azVar, Response response) throws ag {
            bf bfVar = (bf) azVar;
            bfVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            bfVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                bfVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(bfVar);
            }
        }

        public void b(az azVar, Response response) throws ag {
            bf bfVar = (bf) azVar;
            response.resp_code = bfVar.w();
            response.setResp_codeIsSet(true);
            BitSet b2 = bfVar.b(2);
            if (b2.get(0)) {
                response.msg = bfVar.z();
                response.setMsgIsSet(true);
            }
            if (b2.get(1)) {
                response.imprint = new d();
                response.imprint.read(bfVar);
                response.setImprintIsSet(true);
            }
        }
    }

    private static class d implements bi {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    public enum e implements ah {
        RESP_CODE(1, "resp_code"),
        MSG(2, NotificationCompat.CATEGORY_MESSAGE),
        IMPRINT(3, v.Q);
        
        private static final Map<String, e> d = null;
        private final short e;
        private final String f;

        static {
            d = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        private e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return RESP_CODE;
                case 2:
                    return MSG;
                case 3:
                    return IMPRINT;
                default:
                    return null;
            }
        }

        public static e a(String str) {
            return d.get(str);
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public final short a() {
            return this.e;
        }

        public final String b() {
            return this.f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        hashMap.put(bj.class, new b());
        schemes.put(bk.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.RESP_CODE, new am("resp_code", (byte) 1, new an((byte) 8)));
        enumMap.put(e.MSG, new am(NotificationCompat.CATEGORY_MESSAGE, (byte) 2, new an((byte) 11)));
        enumMap.put(e.IMPRINT, new am(v.Q, (byte) 2, new ar((byte) 12, d.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        am.a(Response.class, metaDataMap);
    }

    public Response() {
        this.__isset_bitfield = 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new d(response.imprint);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = 0;
            read(new at(new bl((InputStream) objectInputStream)));
        } catch (ag e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new at(new bl((OutputStream) objectOutputStream)));
        } catch (ag e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public Response deepCopy() {
        return new Response(this);
    }

    public e fieldForId(int i) {
        return e.a(i);
    }

    public d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return x.a(this.__isset_bitfield, 0);
    }

    public void read(az azVar) throws ag {
        schemes.get(azVar.D()).b().b(azVar, this);
    }

    public Response setImprint(d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (!z) {
            this.imprint = null;
        }
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (!z) {
            this.msg = null;
        }
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = x.a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            sb.append(this.msg == null ? "null" : this.msg);
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            if (this.imprint == null) {
                sb.append("null");
            } else {
                sb.append(this.imprint);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = x.b(this.__isset_bitfield, 0);
    }

    public void validate() throws ag {
        if (this.imprint != null) {
            this.imprint.l();
        }
    }

    public void write(az azVar) throws ag {
        schemes.get(azVar.D()).b().a(azVar, this);
    }
}
