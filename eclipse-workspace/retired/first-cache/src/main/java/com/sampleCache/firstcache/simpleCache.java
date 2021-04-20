package com.sampleCache.firstcache;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class simpleCache implements InterfaceCache {

	private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

	public simpleCache() {
	}

	@Override
	public void add(String key, Object value, long period) {
		if (key == null) {
			return;
		}
		if (value == null) {
			cache.remove(key);
		} else {
			cache.put(key, value.toString());
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

}
