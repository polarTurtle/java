package com.cache.cachingstring;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ThreadCache implements CacheImplementation {

	private ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
	private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<String, String>();
	
	private void deleteCache(String key, Long expirationTime) {
		Runnable deleteTask = () -> cache.remove(key);
		ses.schedule(deleteTask, expirationTime, TimeUnit.MILLISECONDS);
	}

	@Override
	public void add(String key, String value, Long expirationTime) {
		if (key == null) {
			return;
		}
		if (value == null) {
			cache.remove(key);
		} else {
			expirationTime += System.currentTimeMillis();
			cache.put(key, value);
			deleteCache(key, expirationTime);
		}
	}

	@Override
	public String get(String key) {
		return cache.get(key);
	}

}
