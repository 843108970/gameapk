package mobi.oneway.export.feed;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mobi.oneway.export.AdListener.feed.OWFeedAdEventListener;
import mobi.oneway.export.AdListener.feed.OWFeedVideoAdListener;

public interface IFeedAd {
    String getIconImage();

    List<String> getImages();

    String getTitle();

    int getType();

    View getVideoView();

    void handleAdEvent(ViewGroup viewGroup, OWFeedAdEventListener oWFeedAdEventListener);

    void setVideoAdListener(OWFeedVideoAdListener oWFeedVideoAdListener);
}
