package com.goldcoast.sdk.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

public final class f {
    public static String a(InputStream inputStream, Map map) {
        String trim;
        String trim2;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        boolean z = map != null && map.size() > 0;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (map != null && readLine.contains(":")) {
                        String[] split = readLine.split(":");
                        if (z) {
                            a(map, split[0], split[1]);
                        } else {
                            if (split[0].trim().equals("processor")) {
                                if (split.length > 1) {
                                    trim = "processorcnt";
                                    trim2 = split[1].trim();
                                } else {
                                    trim = "processorcnt";
                                    trim2 = split[0].trim();
                                }
                            } else if (split.length > 1) {
                                trim = split[0].trim();
                                trim2 = split[1].trim();
                            } else {
                                trim = split[0].trim();
                                trim2 = split[0].trim();
                            }
                            map.put(trim, trim2);
                        }
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                throw th;
            }
            try {
                break;
            } catch (IOException unused2) {
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    private static void a(Map<String, String> map, String str, String str2) {
        String trim = str.replace("[", "").replace("]", "").trim();
        String trim2 = str2.replace("[", "").replace("]", "").trim();
        Iterator<String> it = map.keySet().iterator();
        if (it != null && it.hasNext()) {
            while (it.hasNext()) {
                String next = it.next();
                if (next.equals(trim)) {
                    map.put(next, trim2);
                    return;
                }
            }
        }
    }
}
