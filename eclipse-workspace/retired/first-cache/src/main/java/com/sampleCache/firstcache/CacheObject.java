package com.sampleCache.firstcache;

public class CacheObject {
	private Object value;
	private long expirationTime;

	public CacheObject(Object value, long expirationTime) {
		super();
		this.value = value;
		this.expirationTime = expirationTime;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public long getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(long expirationTime) {
		this.expirationTime = expirationTime;
	}

	boolean isExpired() {
		return System.currentTimeMillis() > expirationTime;
	}
}
