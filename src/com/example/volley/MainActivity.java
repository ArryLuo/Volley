package com.example.volley;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {

	// private String url =
	// "http://apis.juhe.cn/mobile/get?phone=13429667914&key=6bdc7d77f58686ca26c65b792a119f48";

	private String url = "http://apis.juhe.cn/mobile/get?";
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 字符串的获取
		// VolleyGet();
		// getjson();
		// postVolley();
		// volleyUtil();
		img = (ImageView) findViewById(R.id.img);
		// volleyPostUtil();
		// volleyImg();
		// getImgUtil();
		loadimg();
	}

	// 同过volley下载图片
	private void volleyImg() {
		String url = "http://img.mukewang.com/5458464a00013eb602200220-100-100.jpg";
		ImageRequest request = new ImageRequest(url, new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap arg0) {
				// TODO Auto-generated method stub
				img.setImageBitmap(arg0);
			}
		}, 100, 100, ScaleType.CENTER, Config.RGB_565,
				new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub

					}
				});
		request.setTag("ds");
		MyApplication.getHttpQueues().add(request);
	}

	// 加缓存的
	private void loadimg() {
		String url = "http://img.mukewang.com/5458464a00013eb602200220-100-100.jpg";
		ImageLoader loader = new ImageLoader(MyApplication.getHttpQueues(),
				new ImgCache());
		ImageListener listener = ImageLoader.getImageListener(img,
				R.drawable.ic_launcher, R.drawable.ic_launcher);
		loader.get(url, listener);
	}

	// 封装后的img
	private void getImgUtil() {
		String url = "http://img.mukewang.com/5458464a00013eb602200220-100-100.jpg";
		VolleyRequest.getImg(this, "ds", url, new VolleyImg(this) {

			@Override
			public void mySuccss(Bitmap bitmap) {
				// TODO Auto-generated method stub
				img.setImageBitmap(bitmap);
			}

			@Override
			public void myError(VolleyError error) {
				// TODO Auto-generated method stub

			}
		}, 100, 100, ScaleType.CENTER);
	}

	private void postVolley() {
		// TODO Auto-generated method stub
		StringRequest request = new StringRequest(Method.POST, url,
				new Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						// TODO Auto-generated method stub
						Log.v("TAG", arg0 + "归属地查询成功");
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub

					}
				}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				// TODO Auto-generated method stub
				Map<String, String> hasMap = new HashMap<String, String>();
				hasMap.put("phone", "13429667914");
				hasMap.put("key", "6bdc7d77f58686ca26c65b792a119f48");
				return hasMap;

			}
		};
		request.setTag("sd");
		MyApplication.getHttpQueues().add(request);
	}

	private void VolleyGet() {
		// TODO Auto-generated method stub
		StringRequest request = new StringRequest(Method.GET, url,
				new Listener<String>() {

					@Override
					public void onResponse(String arg0) {
						// TODO Auto-generated method stub
						Log.v("TAG", arg0 + "归属地查询成功");
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
						Log.v("TAG", arg0 + "归属地查询失败");
					}
				});
		request.setTag("abcGet");
		// 将请求对象加入队列中
		MyApplication.getHttpQueues().add(request);
	}

	// json的获取
	private void getjson() {
		HashMap<String, String> hasMap = new HashMap<String, String>();
		hasMap.put("phone", "13429467914");
		hasMap.put("key", "6bdc7d77f58686ca26c65b792a119f48");
		JSONObject object = new JSONObject(hasMap);

		JsonObjectRequest request = new JsonObjectRequest(Method.POST, url,
				object, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject arg0) {
						// TODO Auto-generated method stub
						Log.v("TAG", arg0.toString() + "归属地查询成功");
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub

					}
				});
		request.setTag("abcposts");
		// 将请求对象加入队列中
		MyApplication.getHttpQueues().add(request);
	}

	// 封装后的get写法
	private void volleyUtil() {
		VolleyRequest.requestGet(this, url, "sd", new VolleyInterface(this) {

			@Override
			public void onMySuccess(String str) {
				Log.v("TAG", str + "归属地查询成功");
			}

			@Override
			public void onMyError(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});
	}

	// 封装后的post写法
	private void volleyPostUtil() {
		Map<String, String> hasMap = new HashMap<String, String>();
		hasMap.put("phone", "13429667914");
		hasMap.put("key", "6bdc7d77f58686ca26c65b792a119f48");
		VolleyRequest.requestPost(this, url, "dd", new VolleyInterface(this) {

			@Override
			public void onMySuccess(String str) {
				// TODO Auto-generated method stub
				Log.v("TAG", str + "归属地查询成功");
			}

			@Override
			public void onMyError(VolleyError error) {
				// TODO Auto-generated method stub

			}
		}, hasMap);
	}
}
