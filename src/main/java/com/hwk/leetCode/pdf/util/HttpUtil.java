package com.hwk.leetCode.pdf.util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIUtils;

public class HttpUtil {


    public static InputStream downFile(String src) throws IOException {
        return downFile(URI.create(src));
    }

    /**
     * 从网络上下载文件
     *
     * @param uri
     * @return
     * @throws IOException
     */
    public static InputStream downFile(URI uri) throws IOException {
        HttpResponse httpResponse;
        try {
            Request request = Request.Get(uri);
            HttpHost httpHost = URIUtils.extractHost(uri);
            if (StringUtils.isNotEmpty(httpHost.getHostName())) {
                request.setHeader("Host", httpHost.getHostName());
            }
            request.addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");

            httpResponse = request.execute().returnResponse();
        } catch (Exception e) {
            throw new FileNotFoundException();
        }

        int code = httpResponse.getStatusLine().getStatusCode();
        if (code != 200) {
            throw new FileNotFoundException();
        }

        return httpResponse.getEntity().getContent();
    }
}
