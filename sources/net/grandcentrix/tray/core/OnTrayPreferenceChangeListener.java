package net.grandcentrix.tray.core;

import java.util.Collection;

public interface OnTrayPreferenceChangeListener {
    void onTrayPreferenceChanged(Collection<TrayItem> collection);
}
