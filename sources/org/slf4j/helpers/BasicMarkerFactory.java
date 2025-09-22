package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.IMarkerFactory;
import org.slf4j.Marker;

public class BasicMarkerFactory implements IMarkerFactory {
    Map markerMap = new HashMap();

    public boolean detachMarker(String str) {
        return (str == null || this.markerMap.remove(str) == null) ? false : true;
    }

    public synchronized boolean exists(String str) {
        if (str == null) {
            return false;
        }
        return this.markerMap.containsKey(str);
    }

    public Marker getDetachedMarker(String str) {
        return new BasicMarker(str);
    }

    public synchronized Marker getMarker(String str) {
        Marker marker;
        if (str == null) {
            try {
                throw new IllegalArgumentException("Marker name cannot be null");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            marker = (Marker) this.markerMap.get(str);
            if (marker == null) {
                marker = new BasicMarker(str);
                this.markerMap.put(str, marker);
            }
        }
        return marker;
    }
}
