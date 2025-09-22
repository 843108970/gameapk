package com.lidroid.xutils.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.lidroid.xutils.util.LogUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PriorityAsyncTask<Params, Progress, Result> implements TaskHandler {
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor sDefaultExecutor = new PriorityExecutor();
    private static final InternalHandler sHandler = new InternalHandler((InternalHandler) null);
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private volatile boolean mExecuteInvoked = false;
    private final FutureTask<Result> mFuture = new FutureTask<Result>(this.mWorker) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                PriorityAsyncTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e) {
                LogUtils.d(e.getMessage());
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException unused) {
                PriorityAsyncTask.this.postResultIfNotInvoked(null);
            }
        }
    };
    /* access modifiers changed from: private */
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final WorkerRunnable<Params, Result> mWorker = new WorkerRunnable<Params, Result>() {
        public Result call() throws Exception {
            PriorityAsyncTask.this.mTaskInvoked.set(true);
            Process.setThreadPriority(10);
            return PriorityAsyncTask.this.postResult(PriorityAsyncTask.this.doInBackground(this.mParams));
        }
    };
    private Priority priority;

    private static class AsyncTaskResult<Data> {
        final Data[] mData;
        final PriorityAsyncTask mTask;

        AsyncTaskResult(PriorityAsyncTask priorityAsyncTask, Data... dataArr) {
            this.mTask = priorityAsyncTask;
            this.mData = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        private InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* synthetic */ InternalHandler(InternalHandler internalHandler) {
            this();
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    asyncTaskResult.mTask.finish(asyncTaskResult.mData[0]);
                    return;
                case 2:
                    asyncTaskResult.mTask.onProgressUpdate(asyncTaskResult.mData);
                    return;
                default:
                    return;
            }
        }
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private WorkerRunnable() {
        }

        /* synthetic */ WorkerRunnable(WorkerRunnable workerRunnable) {
            this();
        }
    }

    public static void execute(Runnable runnable) {
        execute(runnable, Priority.DEFAULT);
    }

    public static void execute(Runnable runnable, Priority priority2) {
        sDefaultExecutor.execute(new PriorityRunnable(priority2, runnable));
    }

    /* access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
    }

    /* access modifiers changed from: private */
    public Result postResult(Result result) {
        sHandler.obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    public void postResultIfNotInvoked(Result result) {
        if (!this.mTaskInvoked.get()) {
            postResult(result);
        }
    }

    public void cancel() {
        cancel(true);
    }

    public final boolean cancel(boolean z) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    public abstract Result doInBackground(Params... paramsArr);

    public final PriorityAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final PriorityAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mExecuteInvoked) {
            throw new IllegalStateException("Cannot execute task: the task is already executed.");
        }
        this.mExecuteInvoked = true;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(new PriorityRunnable(this.priority, this.mFuture));
        return this;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    public Priority getPriority() {
        return this.priority;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public boolean isPaused() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
        onCancelled();
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    public void onProgressUpdate(Progress... progressArr) {
    }

    public void pause() {
    }

    /* access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            sHandler.obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
        }
    }

    public void resume() {
    }

    public void setPriority(Priority priority2) {
        this.priority = priority2;
    }

    public boolean supportCancel() {
        return true;
    }

    public boolean supportPause() {
        return false;
    }

    public boolean supportResume() {
        return false;
    }
}
