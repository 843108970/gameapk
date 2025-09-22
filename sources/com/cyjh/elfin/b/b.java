package com.cyjh.elfin.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cyjh.common.f.a;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.http.bean.NotifyMsgBean;
import java.util.ArrayList;
import java.util.List;
import org.litepal.g.b;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final int f1849b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static b f1850c;

    /* renamed from: a  reason: collision with root package name */
    public a f1851a = new a(AppContext.a(), "MESSAGE.db");

    private b() {
    }

    public static b a() {
        if (f1850c == null) {
            synchronized (b.class) {
                if (f1850c == null) {
                    f1850c = new b();
                }
            }
        }
        return f1850c;
    }

    private void a(final a aVar) {
        com.cyjh.feedback.lib.d.b.a().a(new Runnable() {
            public final void run() {
                ArrayList arrayList = new ArrayList();
                SQLiteDatabase writableDatabase = b.this.f1851a.getWritableDatabase();
                Cursor query = writableDatabase.query(com.cyjh.elfin.a.b.d, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, "id desc");
                if (query.moveToFirst()) {
                    do {
                        NotifyMsgBean notifyMsgBean = new NotifyMsgBean();
                        notifyMsgBean.NoticeContent = query.getString(query.getColumnIndex(com.umeng.analytics.pro.b.W));
                        notifyMsgBean.DescriptionType = query.getString(query.getColumnIndex(b.c.f4839c));
                        notifyMsgBean.NoticeDescription = query.getString(query.getColumnIndex("description"));
                        notifyMsgBean.ID = query.getString(query.getColumnIndex("number"));
                        notifyMsgBean.NoticeTitle = query.getString(query.getColumnIndex("title"));
                        notifyMsgBean.NoticeTime = query.getString(query.getColumnIndex("time"));
                        arrayList.add(notifyMsgBean);
                    } while (query.moveToNext());
                }
                query.close();
                writableDatabase.close();
                aVar.a(arrayList);
            }
        });
    }

    private void a(List<NotifyMsgBean> list) {
        SQLiteDatabase writableDatabase = this.f1851a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int size = list.size() - 1; size >= 0; size--) {
            NotifyMsgBean notifyMsgBean = list.get(size);
            contentValues.clear();
            contentValues.put("number", notifyMsgBean.ID);
            contentValues.put("title", notifyMsgBean.NoticeTitle);
            contentValues.put("time", notifyMsgBean.NoticeTime);
            contentValues.put(com.umeng.analytics.pro.b.W, notifyMsgBean.NoticeContent);
            contentValues.put("description", notifyMsgBean.NoticeDescription);
            contentValues.put(b.c.f4839c, notifyMsgBean.DescriptionType);
            writableDatabase.insert(com.cyjh.elfin.a.b.d, (String) null, contentValues);
        }
        writableDatabase.close();
    }

    private void b() {
        this.f1851a.getWritableDatabase().delete(com.cyjh.elfin.a.b.d, (String) null, (String[]) null);
    }

    private void c() {
        this.f1851a.close();
    }
}
