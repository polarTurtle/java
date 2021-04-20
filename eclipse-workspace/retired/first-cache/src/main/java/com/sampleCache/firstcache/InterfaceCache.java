package com.sampleCache.firstcache;

public interface InterfaceCache {
	void add(String key, Object value, long period);

	void remove(String key);

	Object get(String key);

	void clear();

	long size();
}
