package com.xinlan.okhttpclient;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private OkHttpClient mClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context c = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                Request req = new Request.Builder().url("https://www.baidu.com").build();
                Call call = mClient.newCall(req);
                try {
                    Response response  = call.execute();
//                    call.enqueue(new Callback(){
//
//                        @Override
//                        public void onFailure(Call call, IOException e) {
//
//                        }
//
//                        @Override
//                        public void onResponse(Call call, Response response) throws IOException {
//
//                        }
//                    });
                    System.out.println("protocol--->"+response.protocol());
                } catch (IOException e)  {
                    e.printStackTrace();
                }
            }
        }).start();

//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                System.out.println("Thread--->"+Thread.currentThread().getName());
//                //setTitle("haha");
//                System.out.println("--->"+response.body().string());
//            }
//        });
    }
}
