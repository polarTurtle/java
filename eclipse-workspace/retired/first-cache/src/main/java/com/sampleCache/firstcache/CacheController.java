package com.sampleCache.firstcache;

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
	private InterfaceCache delayedCacheImplementation;

	@PostMapping("/add")
	public String add(@RequestParam("key") String key, @RequestParam("value") String value) {
		System.out.println(delayedCacheImplementation);
		delayedCacheImplementation.add(key, value, 10000);
		System.out.println(key);
		System.out.println(value);
		return "success";
	}
}
