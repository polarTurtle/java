package com.cache.cachingstring;

public interface CacheImplementation {
	public void add(String key, String value, Long expirationTime);

	public String get(String key);
}
