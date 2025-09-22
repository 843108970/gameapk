package android.databinding;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.internal.LoadedPlugin;
import java.util.LinkedList;
import org.apache.commons.io.FilenameUtils;

public class DataBinderMapperProxy extends DataBinderMapper implements PluginManager.Callback {
    public static final String TAG = "VA.DataBinderMapperProxy";
    private DataBinderMapper[] mCache;
    private final LinkedList<DataBinderMapper> mMappers = new LinkedList<>();

    public DataBinderMapperProxy(@NonNull Object obj) {
        addMapper((DataBinderMapper) obj);
    }

    private void addMapper(DataBinderMapper dataBinderMapper) {
        int size;
        synchronized (this.mMappers) {
            this.mMappers.add(dataBinderMapper);
            this.mCache = null;
            size = this.mMappers.size();
        }
        Log.d(TAG, "Added mapper: " + dataBinderMapper + ", size: " + size);
    }

    private DataBinderMapper[] getCache() {
        DataBinderMapper[] dataBinderMapperArr;
        synchronized (this.mMappers) {
            if (this.mCache == null) {
                this.mCache = (DataBinderMapper[]) this.mMappers.toArray(new DataBinderMapper[this.mMappers.size()]);
            }
            dataBinderMapperArr = this.mCache;
        }
        return dataBinderMapperArr;
    }

    public String convertBrIdToString(int i) {
        for (DataBinderMapper convertBrIdToString : getCache()) {
            String convertBrIdToString2 = convertBrIdToString.convertBrIdToString(i);
            if (convertBrIdToString2 != null) {
                return convertBrIdToString2;
            }
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        for (DataBinderMapper dataBinder : getCache()) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(dataBindingComponent, view, i);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        for (DataBinderMapper dataBinder : getCache()) {
            ViewDataBinding dataBinder2 = dataBinder.getDataBinder(dataBindingComponent, viewArr, i);
            if (dataBinder2 != null) {
                return dataBinder2;
            }
        }
        return null;
    }

    public int getLayoutId(String str) {
        for (DataBinderMapper layoutId : getCache()) {
            int layoutId2 = layoutId.getLayoutId(str);
            if (layoutId2 != 0) {
                return layoutId2;
            }
        }
        return 0;
    }

    public void onAddedLoadedPlugin(LoadedPlugin loadedPlugin) {
        try {
            String str = "android.databinding.DataBinderMapper_" + loadedPlugin.getPackageName().replace(FilenameUtils.EXTENSION_SEPARATOR, '_');
            Log.d(TAG, "Try to find the class: " + str);
            addMapper(Class.forName(str, true, loadedPlugin.getClassLoader()).newInstance());
        } catch (Exception e) {
            Log.w(TAG, e);
        }
    }
}
