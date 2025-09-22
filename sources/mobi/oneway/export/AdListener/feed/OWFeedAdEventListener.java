package mobi.oneway.export.AdListener.feed;

import mobi.oneway.export.feed.IFeedAd;

public interface OWFeedAdEventListener {
    void onClicked(IFeedAd iFeedAd);

    void onExposured(IFeedAd iFeedAd);
}
