package com.springboot.basics.springexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringexampleApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test1() {
		OptimizedDiskCache optimisedDiskCache = new OptimizedDiskCache();
		Cache cache = (Cache) optimisedDiskCache;
	}

	@Test
	public void test2() {
		MemoryCache memoryCache = new MemoryCache();
		Cache cache = (Cache) memoryCache;
		DiskCache diskCache = (DiskCache) cache;
	}

	@Test
	public void test3() {
		DiskCache diskCache = new DiskCache();
		OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;
	}

	@Test
	public void test4() {
		OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
		DiskCache diskCache = (DiskCache) optimizedDiskCache;
	}

	@Test
	public void test5() {
		Cache cache = new Cache();
		MemoryCache memoryCache = (MemoryCache) cache;
	}

	@Test
	public void test6() {
		OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
		Cache cache = (Cache) optimizedDiskCache;
		DiskCache diskCache = (DiskCache) cache;
	}
}
