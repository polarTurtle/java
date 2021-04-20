package com.cache.cachingstring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cache", method = RequestMethod.GET)
public class CacheController {

	@Autowired
	CacheImplementation queueCache;

	@PostMapping("/store")
	public String store(@RequestParam("key") String key, @RequestParam("value") String value,
			@RequestParam(name = "time", required = false) String time) {
		// add new cache using http parameters
		// if time is empty, default time is 10 seconds
		// time to be given in milliseconds
		// http://localhost:8045/cache/store?key=a&value=b&time=10000
		try {
			queueCache.add(key, value, Long.parseLong(time));
		} catch (Exception e) {
			queueCache.add(key, value, (long) 10000);
		}
		return "Value Added";
	}
	
	@PostMapping("/get")
	public String get(@RequestParam("key") String key) {
		// check for cached value using key
		// http://localhost:8045/cache/get?key=a
		String value = queueCache.get(key);
		return value;
	}

}
