package mobi.oneway.export.AdListener.feed;

import java.util.List;
import mobi.oneway.export.enums.OnewaySdkError;
import mobi.oneway.export.feed.IFeedAd;

public interface OWFeedAdListener {
    void onAdLoad(List<IFeedAd> list);

    void onError(OnewaySdkError onewaySdkError, String str);
}
