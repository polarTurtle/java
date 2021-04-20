package com.cache.cachingstring;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class CacheObject implements Delayed{
	
	// object to be placed into delayqueue, used to measure how long until the cache
	// is suppose to be deleted

	private final String key; // key correlation to the key of the concurrenthashmap
	private final long expirationTime;
	
	public CacheObject(String key, long expirationTime) {
		super();
		this.key = key;
		this.expirationTime = expirationTime;
	}

	public long getExpirationTime() {
		return expirationTime;
	}

	public String getKey() {
		return key;
	}

	@Override
	public int compareTo(Delayed o) {
		Long.compare(expirationTime, ((CacheObject) o).getExpirationTime());
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(expirationTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}
	
}
