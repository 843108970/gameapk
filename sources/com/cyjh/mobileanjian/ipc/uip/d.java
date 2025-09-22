package com.cyjh.mobileanjian.ipc.uip;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public final class d extends EditText {
    private d(Context context) {
        super(context);
        setLongClickable(false);
        setTextIsSelectable(false);
        setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public final void onDestroyActionMode(ActionMode actionMode) {
            }

            public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
    }

    public final boolean onTextContextMenuItem(int i) {
        return true;
    }
}
