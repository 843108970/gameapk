package mobi.oneway.export.feed;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mobi.oneway.export.AdListener.feed.OWFeedAdEventListener;
import mobi.oneway.export.AdListener.feed.OWFeedVideoAdListener;
import mobi.oneway.export.f.a.b;

public class a implements IFeedAd {

    /* renamed from: a  reason: collision with root package name */
    private IFeedAd f4206a;

    /* renamed from: b  reason: collision with root package name */
    private mobi.oneway.export.f.a f4207b;

    public a(IFeedAd iFeedAd, mobi.oneway.export.f.a aVar) {
        this.f4206a = iFeedAd;
        this.f4207b = aVar;
    }

    public String getIconImage() {
        return this.f4206a.getIconImage();
    }

    public List<String> getImages() {
        return this.f4206a.getImages();
    }

    public String getTitle() {
        return this.f4206a.getTitle();
    }

    public int getType() {
        return this.f4206a.getType();
    }

    public View getVideoView() {
        return this.f4206a.getVideoView();
    }

    public void handleAdEvent(ViewGroup viewGroup, OWFeedAdEventListener oWFeedAdEventListener) {
        this.f4206a.handleAdEvent(viewGroup, new b(this.f4207b, oWFeedAdEventListener));
    }

    public void setVideoAdListener(OWFeedVideoAdListener oWFeedVideoAdListener) {
    }
}
