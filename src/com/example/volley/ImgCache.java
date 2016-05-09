package com.example.volley;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.SizeF;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class ImgCache implements ImageCache {
	private LruCache<String, Bitmap> cache;
	int max = 10 * 1024 * 1024;

	public ImgCache() {
		cache = new LruCache<String, Bitmap>(max) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				// TODO Auto-generated method stub
				return value.getRowBytes() * value.getHeight();
			}
		};

	}

	@Override
	public Bitmap getBitmap(String arg0) {
		// TODO Auto-generated method stub
		return cache.get(arg0);
	}

	@Override
	public void putBitmap(String arg0, Bitmap arg1) {
		// TODO Auto-generated method stub
		cache.put(arg0, arg1);
	}

}
