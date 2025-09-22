package c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public interface e extends y {
    int a(q qVar) throws IOException;

    int a(byte[] bArr) throws IOException;

    int a(byte[] bArr, int i, int i2) throws IOException;

    long a(byte b2) throws IOException;

    long a(byte b2, long j) throws IOException;

    long a(byte b2, long j, long j2) throws IOException;

    long a(f fVar, long j) throws IOException;

    long a(x xVar) throws IOException;

    c a();

    String a(long j, Charset charset) throws IOException;

    String a(Charset charset) throws IOException;

    void a(long j) throws IOException;

    boolean a(f fVar, int i) throws IOException;

    long b(f fVar) throws IOException;

    long b(f fVar, long j) throws IOException;

    void b(c cVar, long j) throws IOException;

    void b(byte[] bArr) throws IOException;

    boolean b(long j) throws IOException;

    long c(f fVar) throws IOException;

    f d(long j) throws IOException;

    boolean d() throws IOException;

    boolean d(f fVar) throws IOException;

    InputStream e();

    String e(long j) throws IOException;

    byte g() throws IOException;

    byte[] g(long j) throws IOException;

    short h() throws IOException;

    void h(long j) throws IOException;

    int i() throws IOException;

    long j() throws IOException;

    short k() throws IOException;

    int l() throws IOException;

    long m() throws IOException;

    long n() throws IOException;

    long o() throws IOException;

    f p() throws IOException;

    String q() throws IOException;

    @Nullable
    String r() throws IOException;

    String s() throws IOException;

    String t() throws IOException;

    int u() throws IOException;

    byte[] v() throws IOException;
}
