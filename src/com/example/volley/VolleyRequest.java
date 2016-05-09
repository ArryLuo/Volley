package com.example.volley;

import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.widget.ImageView.ScaleType;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

public class VolleyRequest {
	public static StringRequest request;
	public static Context context;

	public static void requestGet(Context context, String url, String tag,
			VolleyInterface it) {
		MyApplication.getHttpQueues().cancelAll(tag);
		request = new StringRequest(Method.GET, url, it.loadinglistent(),
				it.errorListent()) {

		};
		request.setTag(tag);
		MyApplication.getHttpQueues().add(request);
		MyApplication.getHttpQueues().start();
	}

	public static void requestPost(Context context, String url, String tag,
			VolleyInterface it, final Map<String, String> map) {
		MyApplication.getHttpQueues().cancelAll(tag);
		StringRequest request = new StringRequest(Method.POST, url,
				it.loadinglistent(), it.errorListent()) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				return map;
			}
		};
		request.setTag(tag);
		MyApplication.getHttpQueues().add(request);
		MyApplication.getHttpQueues().start();
	}

	public static void getImg(Context context, String tag, String url,
			VolleyImg img, int wight, int height, ScaleType type) {
		MyApplication.getHttpQueues().cancelAll(tag);
		ImageRequest request = new ImageRequest(url, img.loadListener(), wight,
				height, type, Config.RGB_565, img.errorListener());
		MyApplication.getHttpQueues().add(request);
		request.setTag(tag);
		MyApplication.getHttpQueues().add(request);
		MyApplication.getHttpQueues().start();
	}
}
