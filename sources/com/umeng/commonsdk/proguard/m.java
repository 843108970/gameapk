package com.umeng.commonsdk.proguard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class m {

    public enum a {
        check_su_binary(new String[]{"/system/xbin/which", "su"});
        

        /* renamed from: b  reason: collision with root package name */
        String[] f3798b;

        private a(String[] strArr) {
            this.f3798b = strArr;
        }
    }

    public ArrayList a(a aVar) {
        ArrayList arrayList = new ArrayList();
        try {
            Process exec = Runtime.getRuntime().exec(aVar.f3798b);
            new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }
}
