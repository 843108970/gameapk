package com.didi.virtualapk.internal.utils;

import android.content.Context;
import android.content.pm.PackageParser;
import android.os.Build;
import com.didi.virtualapk.utils.Reflector;
import com.umeng.analytics.pro.b;
import java.io.File;

public final class PackageParserCompat {

    private static final class PackageParserLegacy {
        private PackageParserLegacy() {
        }

        static final PackageParser.Package parsePackage(Context context, File file, int i) throws Throwable {
            PackageParser packageParser = new PackageParser(file.getAbsolutePath());
            PackageParser.Package parsePackage = packageParser.parsePackage(file, file.getAbsolutePath(), context.getResources().getDisplayMetrics(), i);
            Reflector.with(packageParser).method("collectCertificates", PackageParser.Package.class, Integer.TYPE).call(parsePackage, Integer.valueOf(i));
            return parsePackage;
        }
    }

    private static final class PackageParserLollipop {
        private PackageParserLollipop() {
        }

        static final PackageParser.Package parsePackage(Context context, File file, int i) throws Throwable {
            PackageParser packageParser = new PackageParser();
            PackageParser.Package parsePackage = packageParser.parsePackage(file, i);
            packageParser.collectCertificates(parsePackage, i);
            return parsePackage;
        }
    }

    private static final class PackageParserPPreview {
        private PackageParserPPreview() {
        }

        static final PackageParser.Package parsePackage(Context context, File file, int i) throws Throwable {
            PackageParser packageParser = new PackageParser();
            PackageParser.Package parsePackage = packageParser.parsePackage(file, i);
            Reflector.with(packageParser).method("collectCertificates", PackageParser.Package.class, Boolean.TYPE).call(parsePackage, false);
            return parsePackage;
        }
    }

    private static final class PackageParserV24 {
        private PackageParserV24() {
        }

        static final PackageParser.Package parsePackage(Context context, File file, int i) throws Throwable {
            PackageParser packageParser = new PackageParser();
            PackageParser.Package parsePackage = packageParser.parsePackage(file, i);
            Reflector.with(packageParser).method("collectCertificates", PackageParser.Package.class, Integer.TYPE).call(parsePackage, Integer.valueOf(i));
            return parsePackage;
        }
    }

    public static final PackageParser.Package parsePackage(Context context, File file, int i) {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                if (Build.VERSION.SDK_INT != 27 || Build.VERSION.PREVIEW_SDK_INT == 0) {
                    return Build.VERSION.SDK_INT >= 24 ? PackageParserV24.parsePackage(context, file, i) : Build.VERSION.SDK_INT >= 21 ? PackageParserLollipop.parsePackage(context, file, i) : PackageParserLegacy.parsePackage(context, file, i);
                }
            }
            return PackageParserPPreview.parsePackage(context, file, i);
        } catch (Throwable th) {
            throw new RuntimeException(b.J, th);
        }
    }
}
