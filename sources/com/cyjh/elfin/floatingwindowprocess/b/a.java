package com.cyjh.elfin.floatingwindowprocess.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.commonsdk.proguard.v;

public final class a implements SensorEventListener {

    /* renamed from: c  reason: collision with root package name */
    private static final int f2001c = 3000;
    private static final int d = 100;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f2002a;

    /* renamed from: b  reason: collision with root package name */
    public C0027a f2003b;
    private Sensor e;
    private Context f;
    private float g;
    private float h;
    private float i;
    private long j;

    /* renamed from: com.cyjh.elfin.floatingwindowprocess.b.a$a  reason: collision with other inner class name */
    public interface C0027a {
        void a();
    }

    public a(Context context) {
        this.f = context;
        a();
    }

    private void a(C0027a aVar) {
        this.f2003b = aVar;
    }

    private void b() {
        this.f2002a.unregisterListener(this);
    }

    public final void a() {
        this.f2002a = (SensorManager) this.f.getSystemService(v.W);
        if (this.f2002a != null) {
            this.e = this.f2002a.getDefaultSensor(1);
        }
        if (this.e != null) {
            this.f2002a.registerListener(this, this.e, 1);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.j;
        if (j2 >= 100) {
            this.j = currentTimeMillis;
            float f2 = sensorEvent.values[0];
            float f3 = sensorEvent.values[1];
            float f4 = sensorEvent.values[2];
            float f5 = f2 - this.g;
            float f6 = f3 - this.h;
            float f7 = f4 - this.i;
            this.g = f2;
            this.h = f3;
            this.i = f4;
            if ((Math.sqrt((double) (((f5 * f5) + (f6 * f6)) + (f7 * f7))) / ((double) j2)) * 10000.0d >= 3000.0d) {
                this.f2003b.a();
            }
        }
    }
}
