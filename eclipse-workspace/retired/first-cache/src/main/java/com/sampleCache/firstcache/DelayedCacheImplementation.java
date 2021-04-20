package com.sampleCache.firstcache;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelayedCacheImplementation implements InterfaceCache {

	private final ConcurrentHashMap<String, SoftReference<Object>> cache = new ConcurrentHashMap<String, SoftReference<Object>>();

	private final DelayQueue<DelayedCacheObject> cleaningQueue = new DelayQueue<DelayedCacheObject>();

	@Autowired
	private DelayRunnable delayRunnable;

	public DelayedCacheImplementation() {
		Thread thread = new Thread(delayRunnable);
		thread.start();
	}

	@Override
	public void add(String key, Object value, long period) {
		if (key == null) {
			return;
		}
		if (value == null) {
			cache.remove(key);
		} else {
			long expiryTime = System.currentTimeMillis() + period;
			SoftReference<Object> reference = new SoftReference<Object>(value);
			cache.put(key, reference);
			cleaningQueue.put(new DelayedCacheObject(key, reference, expiryTime));
		}
		
	}

	@Override
	public void remove(String key) {
		cache.remove(key);

	}

	@Override
	public Object get(String key) {
		return cache.get(key);
	}

	@Override
	public void clear() {
		cache.clear();

	}

	@Override
	public long size() {
		return cache.size();
	}

	@Component
	private class DelayRunnable implements Runnable {

		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()) {
				try {
					DelayedCacheObject delayedCacheObject = cleaningQueue.take();
					cache.remove(delayedCacheObject.getKey());
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}

		}
	}

}
