package com.cache.cachingstring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ComponentScan("com.cache.cachingstring")
class CacheTest {

	@Autowired
	QueueCache cache;

	@Test
	void basicTest() {
		assertNotEquals(cache, null);
	}

	@Test
	void storageTest() {
		cache.add("key1", "value1", Long.valueOf(1000));
		cache.add("key2", "value2", Long.valueOf(1000));
		assertEquals(cache.get("key1"), "value1");
		assertEquals(cache.get("key2"), "value2");
		assertNotEquals(cache.get("key1"), "value2");
	}

	@Test
	void timingTest() throws InterruptedException {
		cache.add("key1", "value1", Long.valueOf(1000));
		assertEquals(cache.get("key1"), "value1");
		TimeUnit.MILLISECONDS.sleep(1000);
		assertNotEquals(cache.get("key1"), "value1");
	}

}
