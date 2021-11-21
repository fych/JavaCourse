package com.geek.nio.client;

import com.geek.nio.filter.HeaderHttpRequestFilter;
import com.geek.nio.outbound.HttpOutboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class OkHttpClientUtil {

    private static HeaderHttpRequestFilter headerHttpRequestFilter = new HeaderHttpRequestFilter();

    public static void main(String[] args) {
        try {
            FullHttpRequest fullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_0, HttpMethod.GET, "http://localhost:8801");
            String resStr = HttpOutboundHandler.handle(fullHttpRequest, headerHttpRequestFilter);
            System.out.println(resStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
