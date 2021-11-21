package com.geek.nio.outbound;

import com.geek.nio.filter.HttpRequestFilter;
import io.netty.handler.codec.http.FullHttpRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpOutboundHandler {
    private static OkHttpClient okHttpClient  = new OkHttpClient();

    public static String handle(FullHttpRequest fullHttpRequest, HttpRequestFilter httpRequestFilter) throws IOException {

        String url = fullHttpRequest.uri();
        httpRequestFilter.filter(fullHttpRequest);

        Request request = new Request.Builder()
                .url(url)
                .header("customattr", fullHttpRequest.headers().get("customattr"))
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
