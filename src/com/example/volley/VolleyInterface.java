package com.example.volley;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import android.content.Context;

public abstract class VolleyInterface {
	public Context context;
	public static Listener<String> mlListener;
	public static ErrorListener errorListener;

	public VolleyInterface(Context context) {
		this.context = context;
	}

	public abstract void onMySuccess(String str);

	public abstract void onMyError(VolleyError error);

	public Listener<String> loadinglistent() {
		mlListener = new Listener<String>() {

			@Override
			public void onResponse(String arg0) {
				// TODO Auto-generated method stub
				onMySuccess(arg0);
			}
		};
		return mlListener;
	}

	public ErrorListener errorListent() {
		errorListener = new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				// TODO Auto-generated method stub
				onMyError(arg0);
			}
		};
		return errorListener;
	}
}
