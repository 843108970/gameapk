package b.a.f;

public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    
    public final int httpCode;

    private b(int i) {
        this.httpCode = i;
    }

    public static b fromHttp2(int i) {
        for (b bVar : values()) {
            if (bVar.httpCode == i) {
                return bVar;
            }
        }
        return null;
    }
}
