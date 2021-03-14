package com.main.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	@Test
	void sum3() {
		MyMath myMath = new MyMath();
		assert(myMath.sum(new int[] {1, 2, 3}) == 6);
		assertEquals(6, myMath.sum(new int[] {1, 2, 3}));
	}

}