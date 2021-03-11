package com.basics.tutorial.steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm{
	
	public int[] sort(int [] numbers) {
		return numbers;
	}
}
