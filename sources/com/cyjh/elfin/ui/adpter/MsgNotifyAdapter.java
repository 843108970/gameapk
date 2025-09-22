package com.cyjh.elfin.ui.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.h;
import com.bumptech.glide.f;
import com.cyjh.common.util.q;
import com.cyjh.http.bean.NotifyMsgBean;
import com.ywfzjbcy.R;

public class MsgNotifyAdapter extends BGARecyclerViewAdapter<NotifyMsgBean> {
    public MsgNotifyAdapter(RecyclerView recyclerView) {
        super(recyclerView);
    }

    private void a(h hVar, NotifyMsgBean notifyMsgBean) {
        if (notifyMsgBean != null) {
            TextView textView = (TextView) hVar.b(R.id.id_tv_msg_des);
            ImageView imageView = (ImageView) hVar.b(R.id.id_img_msg);
            hVar.a((int) R.id.id_tv_msg_title, (CharSequence) notifyMsgBean.NoticeTitle);
            hVar.a((int) R.id.id_tv_msg_time, (CharSequence) notifyMsgBean.NoticeTime);
            if (notifyMsgBean.DescriptionType.equals("1")) {
                hVar.a((int) R.id.id_tv_msg_des, (CharSequence) notifyMsgBean.NoticeDescription);
                imageView.setVisibility(8);
                textView.setVisibility(0);
            } else if (notifyMsgBean.DescriptionType.equals("2")) {
                textView.setVisibility(8);
                imageView.setVisibility(0);
                Context context = this.f440b;
                String str = notifyMsgBean.NoticeDescription;
                if (q.a(context)) {
                    f.c(context).a(str).a(q.a()).a(imageView);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(h hVar, Object obj) {
        NotifyMsgBean notifyMsgBean = (NotifyMsgBean) obj;
        if (notifyMsgBean != null) {
            TextView textView = (TextView) hVar.b(R.id.id_tv_msg_des);
            ImageView imageView = (ImageView) hVar.b(R.id.id_img_msg);
            hVar.a((int) R.id.id_tv_msg_title, (CharSequence) notifyMsgBean.NoticeTitle);
            hVar.a((int) R.id.id_tv_msg_time, (CharSequence) notifyMsgBean.NoticeTime);
            if (notifyMsgBean.DescriptionType.equals("1")) {
                hVar.a((int) R.id.id_tv_msg_des, (CharSequence) notifyMsgBean.NoticeDescription);
                imageView.setVisibility(8);
                textView.setVisibility(0);
            } else if (notifyMsgBean.DescriptionType.equals("2")) {
                textView.setVisibility(8);
                imageView.setVisibility(0);
                Context context = this.f440b;
                String str = notifyMsgBean.NoticeDescription;
                if (q.a(context)) {
                    f.c(context).a(str).a(q.a()).a(imageView);
                }
            }
        }
    }
}
