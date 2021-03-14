package com.basics.tutorial.steps.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.basics.tutorial.steps.BasicApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BasicApplication.class)
class BinarySearchTest {
	
	@Autowired
	BinarySearchImpl binarySearchImpl;
	
	@Test
	public void test2() {
		assertEquals(1, 1);
		assertEquals(binarySearchImpl, null);
	}

	@Test
	public void test() {
		int result = binarySearchImpl.binarySearch(new int[] {1, 2}, 5);
		System.out.println(result);
	}

}
