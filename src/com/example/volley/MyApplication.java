package com.example.volley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application {
	//在清单文件中创建
	public static RequestQueue queue;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		queue = Volley.newRequestQueue(getApplicationContext());
	}

	public static RequestQueue getHttpQueues() {
		return queue;
	}
}
