package com.lidroid.xutils.http.client;

import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.http.client.entity.UploadEntity;
import com.lidroid.xutils.http.client.util.URIBuilder;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.util.OtherUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.CloneUtils;

public class HttpRequest extends HttpRequestBase implements HttpEntityEnclosingRequest {
    private HttpEntity entity;
    private HttpMethod method;
    private URIBuilder uriBuilder;
    private Charset uriCharset;

    public enum HttpMethod {
        GET(com.github.kevinsawicki.http.HttpRequest.METHOD_GET),
        POST("POST"),
        PUT(com.github.kevinsawicki.http.HttpRequest.METHOD_PUT),
        HEAD("HEAD"),
        MOVE("MOVE"),
        COPY("COPY"),
        DELETE(com.github.kevinsawicki.http.HttpRequest.METHOD_DELETE),
        OPTIONS(com.github.kevinsawicki.http.HttpRequest.METHOD_OPTIONS),
        TRACE(com.github.kevinsawicki.http.HttpRequest.METHOD_TRACE),
        CONNECT("CONNECT");
        
        private final String value;

        private HttpMethod(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    public HttpRequest(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public HttpRequest(HttpMethod httpMethod, String str) {
        this.method = httpMethod;
        setURI(str);
    }

    public HttpRequest(HttpMethod httpMethod, URI uri) {
        this.method = httpMethod;
        setURI(uri);
    }

    public HttpRequest addQueryStringParameter(String str, String str2) {
        this.uriBuilder.addParameter(str, str2);
        return this;
    }

    public HttpRequest addQueryStringParameter(NameValuePair nameValuePair) {
        this.uriBuilder.addParameter(nameValuePair.getName(), nameValuePair.getValue());
        return this;
    }

    public HttpRequest addQueryStringParams(List<NameValuePair> list) {
        if (list == null) {
            return this;
        }
        for (NameValuePair next : list) {
            this.uriBuilder.addParameter(next.getName(), next.getValue());
        }
        return this;
    }

    public Object clone() throws CloneNotSupportedException {
        HttpRequest httpRequest = (HttpRequest) HttpRequest.super.clone();
        if (this.entity != null) {
            httpRequest.entity = (HttpEntity) CloneUtils.clone(this.entity);
        }
        return httpRequest;
    }

    public boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        return firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue());
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public String getMethod() {
        return this.method.toString();
    }

    public URI getURI() {
        try {
            if (this.uriCharset == null) {
                this.uriCharset = OtherUtils.getCharsetFromHttpRequest(this);
            }
            if (this.uriCharset == null) {
                this.uriCharset = Charset.forName("UTF-8");
            }
            return this.uriBuilder.build(this.uriCharset);
        } catch (URISyntaxException e) {
            LogUtils.e(e.getMessage(), e);
            return null;
        }
    }

    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
    }

    public void setRequestParams(RequestParams requestParams) {
        if (requestParams != null) {
            if (this.uriCharset == null) {
                this.uriCharset = Charset.forName(requestParams.getCharset());
            }
            List<RequestParams.HeaderItem> headers = requestParams.getHeaders();
            if (headers != null) {
                for (RequestParams.HeaderItem next : headers) {
                    if (next.overwrite) {
                        setHeader(next.header);
                    } else {
                        addHeader(next.header);
                    }
                }
            }
            addQueryStringParams(requestParams.getQueryStringParams());
            setEntity(requestParams.getEntity());
        }
    }

    public void setRequestParams(RequestParams requestParams, RequestCallBackHandler requestCallBackHandler) {
        if (requestParams != null) {
            if (this.uriCharset == null) {
                this.uriCharset = Charset.forName(requestParams.getCharset());
            }
            List<RequestParams.HeaderItem> headers = requestParams.getHeaders();
            if (headers != null) {
                for (RequestParams.HeaderItem next : headers) {
                    if (next.overwrite) {
                        setHeader(next.header);
                    } else {
                        addHeader(next.header);
                    }
                }
            }
            addQueryStringParams(requestParams.getQueryStringParams());
            UploadEntity entity2 = requestParams.getEntity();
            if (entity2 != null) {
                if (entity2 instanceof UploadEntity) {
                    entity2.setCallBackHandler(requestCallBackHandler);
                }
                setEntity(entity2);
            }
        }
    }

    public void setURI(String str) {
        this.uriBuilder = new URIBuilder(str);
    }

    public void setURI(URI uri) {
        this.uriBuilder = new URIBuilder(uri);
    }
}
