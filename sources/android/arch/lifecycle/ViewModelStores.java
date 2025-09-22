package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class ViewModelStores {
    private ViewModelStores() {
    }

    @MainThread
    @NonNull
    public static ViewModelStore of(@NonNull Fragment fragment) {
        return fragment instanceof ViewModelStoreOwner ? fragment.getViewModelStore() : HolderFragment.holderFragmentFor(fragment).getViewModelStore();
    }

    @MainThread
    @NonNull
    public static ViewModelStore of(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity instanceof ViewModelStoreOwner ? fragmentActivity.getViewModelStore() : HolderFragment.holderFragmentFor(fragmentActivity).getViewModelStore();
    }
}
