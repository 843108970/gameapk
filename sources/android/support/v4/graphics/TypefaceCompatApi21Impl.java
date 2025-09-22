package android.support.v4.graphics;

import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String TAG = "TypefaceCompatApi21Impl";

    TypefaceCompatApi21Impl() {
    }

    private File getFile(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0049, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004a, code lost:
        r2 = r7;
        r7 = r4;
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005c, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005d, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0061, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0062, code lost:
        r2 = r6;
        r6 = r4;
        r4 = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x005c A[ExcHandler: all (th java.lang.Throwable)] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r4, android.os.CancellationSignal r5, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] r6, int r7) {
        /*
            r3 = this;
            int r0 = r6.length
            r1 = 0
            if (r0 > 0) goto L_0x0005
            return r1
        L_0x0005:
            android.support.v4.provider.FontsContractCompat$FontInfo r6 = r3.findBestInfo(r6, r7)
            android.content.ContentResolver r7 = r4.getContentResolver()
            android.net.Uri r6 = r6.getUri()     // Catch:{ IOException -> 0x0076 }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r5 = r7.openFileDescriptor(r6, r0, r5)     // Catch:{ IOException -> 0x0076 }
            java.io.File r6 = r3.getFile(r5)     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            if (r6 == 0) goto L_0x002e
            boolean r7 = r6.canRead()     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            if (r7 != 0) goto L_0x0024
            goto L_0x002e
        L_0x0024:
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromFile(r6)     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            if (r5 == 0) goto L_0x002d
            r5.close()     // Catch:{ IOException -> 0x0076 }
        L_0x002d:
            return r4
        L_0x002e:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            java.io.FileDescriptor r7 = r5.getFileDescriptor()     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            r6.<init>(r7)     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            android.graphics.Typeface r4 = super.createFromInputStream(r4, r6)     // Catch:{ Throwable -> 0x0047, all -> 0x0044 }
            r6.close()     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            if (r5 == 0) goto L_0x0043
            r5.close()     // Catch:{ IOException -> 0x0076 }
        L_0x0043:
            return r4
        L_0x0044:
            r4 = move-exception
            r7 = r1
            goto L_0x004d
        L_0x0047:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r7 = move-exception
            r2 = r7
            r7 = r4
            r4 = r2
        L_0x004d:
            if (r7 == 0) goto L_0x0058
            r6.close()     // Catch:{ Throwable -> 0x0053, all -> 0x005c }
            goto L_0x005b
        L_0x0053:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
            goto L_0x005b
        L_0x0058:
            r6.close()     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
        L_0x005b:
            throw r4     // Catch:{ Throwable -> 0x005f, all -> 0x005c }
        L_0x005c:
            r4 = move-exception
            r6 = r1
            goto L_0x0065
        L_0x005f:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r6 = move-exception
            r2 = r6
            r6 = r4
            r4 = r2
        L_0x0065:
            if (r5 == 0) goto L_0x0075
            if (r6 == 0) goto L_0x0072
            r5.close()     // Catch:{ Throwable -> 0x006d }
            goto L_0x0075
        L_0x006d:
            r5 = move-exception
            r6.addSuppressed(r5)     // Catch:{ IOException -> 0x0076 }
            goto L_0x0075
        L_0x0072:
            r5.close()     // Catch:{ IOException -> 0x0076 }
        L_0x0075:
            throw r4     // Catch:{ IOException -> 0x0076 }
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }
}
