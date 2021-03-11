package com.basics.tutorial.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
	//Sort an array
	//Search the array
	//Return the result
	
	@Autowired
	private SortAlgorithm bubbleSortAlgorithm;

	public int binarySearch(int[] numbers, int searchedNum) {
		
		int [] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		System.out.println(bubbleSortAlgorithm);
		
		
		return 3;
	}
	
	
}
