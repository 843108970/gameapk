package com.elfin.ad.f;

import android.content.Context;
import android.content.Intent;
import com.elfin.ad.activity.FullScreenTwoAdActivity;

public final class a {
    private static void a(Context context) {
        Intent intent = new Intent(context, FullScreenTwoAdActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private static void a(Context context, String str, String str2) {
        try {
            Intent intent = new Intent(context, Class.forName("com.cyjh.elfin.ui.activity.H5LinkJumpPageActivity"));
            intent.addFlags(268435456);
            intent.putExtra("com.cyjh.elfin.ui.activity.H5LinkJumpPageActivity", str);
            intent.putExtra("H5LinkJumpPageActivity", str2);
            context.startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void b(Context context) {
        try {
            Intent intent = new Intent(context, Class.forName("com.cyjh.elfin.ui.activity.ElfinFreeActivity"));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
