package com.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyClass {
    public static void main(String args[]){
        //System.out.println("test");
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).writeTimeout(20,TimeUnit.SECONDS).build();

        Request req = new Request.Builder().url("http://www.bilibili.com").build();
        Call call = client.newCall(req);
        try {
            Response response = call.execute();
            System.out.println("code = "+response.code());
            System.out.println("url = "+response.request().url());
            //System.out.println("msg = "+response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
