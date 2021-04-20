package com.sampleCache.firstcache;

import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class CacheImplementation implements InterfaceCache {

	private ConcurrentHashMap<String, SoftReference<CacheObject>> cache = new ConcurrentHashMap<>();

	public CacheImplementation() {
		Thread cleanerThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(5000);
					cache.entrySet().removeIf(
							entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get)
									.map(CacheObject::isExpired).orElse(false));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});
		cleanerThread.isDaemon();
		cleanerThread.start();
	}

	@Override
	public void add(String key, Object value, long period) {
		if (key == null) {
			return;
		}
		if (value == null) {
			cache.remove(key);
		} else {
			long expiration = System.currentTimeMillis() + period;
			cache.put(key, new SoftReference<>(new CacheObject(value, expiration)));
		}

	}

	@Override
	public void remove(String key) {
		cache.remove(key);

	}

	@Override
	public Object get(String key) {
		return Optional.ofNullable(cache.get(key)).map(SoftReference::get)
				.filter(cacheObject -> cacheObject.isExpired()).map(CacheObject::getValue).orElse(null);
	}

	@Override
	public void clear() {
		cache.clear();

	}

	@Override
	public long size() {
		return cache.entrySet().stream().filter(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get)
				.map(cacheObject -> !cacheObject.isExpired()).orElse(false)).count();
	}

}
