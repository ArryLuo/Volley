package com.example.volley;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import android.content.Context;
import android.graphics.Bitmap;

public abstract class VolleyImg {
	private Context context;
	private static Listener<Bitmap> mlListener;
	private static ErrorListener mErrorListener;

	public VolleyImg(Context context) {
		this.context = context;
	}

	public abstract void mySuccss(Bitmap bitmap);

	public abstract void myError(VolleyError error);

	public Listener<Bitmap> loadListener() {
		mlListener = new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap arg0) {
				// TODO Auto-generated method stub
				mySuccss(arg0);
			}
		};
		return mlListener;

	}

	public ErrorListener errorListener() {
		mErrorListener = new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				myError(arg0);
			}
		};
		return mErrorListener;
	}
}
