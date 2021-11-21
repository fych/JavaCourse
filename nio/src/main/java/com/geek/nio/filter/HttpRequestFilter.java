package com.geek.nio.filter;

import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRequestFilter {
    void filter(FullHttpRequest fullHttpRequest);
}
