package com.geek.nio.outbound;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpOutBoundHandler {
    private static OkHttpClient okHttpClient  = new OkHttpClient();

    public static void main(String[] args) {
        try {
            String resStr = run("http://localhost:8801");
            System.out.println(resStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
