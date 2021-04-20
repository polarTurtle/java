package com.cache.cachingstring;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

import org.springframework.stereotype.Component;

@Component
public class QueueCache implements CacheImplementation {

	private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<String, String>();
	private final DelayQueue<CacheObject> cleaningQueue = new DelayQueue<CacheObject>();

	public QueueCache() {
		Runnable runnable = new Runnable() {
			// simple anonymous runnable that removes outdated cached values in another
			// thread

			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					try {
						CacheObject cacheObject = cleaningQueue.take();
						cache.remove(cacheObject.getKey());
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	@Override
	public void add(String key, String value, Long expirationTime) { // expirationTime in milliseconds
		if (key == null) {
			return;
		}
		if (value == null) {
			cache.remove(key);
		} else {
			expirationTime += System.currentTimeMillis();
			cache.put(key, value);
			cleaningQueue.put(new CacheObject(key, expirationTime));
		}
	}

	@Override
	public String get(String key) {
		return cache.get(key);
	}
}
