package com.sampleCache.firstcache;

import java.lang.ref.SoftReference;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedCacheObject implements Delayed {

	private final String key;
	private final SoftReference<Object> reference;
	private final long expiryTime;

	public DelayedCacheObject(String key, SoftReference<Object> reference, long expiryTime) {
		super();
		this.key = key;
		this.reference = reference;
		this.expiryTime = expiryTime;
	}

	public String getKey() {
		return key;
	}

	public SoftReference<Object> getReference() {
		return reference;
	}

	@Override
	public int compareTo(Delayed o) {
		return Long.compare(expiryTime, ((DelayedCacheObject) o).expiryTime);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

}
