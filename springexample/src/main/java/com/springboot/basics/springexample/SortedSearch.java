package com.springboot.basics.springexample;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
		int len = sortedArray.length;
		if (sortedArray[0] >= lessThan)
			return 0;
		if (sortedArray[len - 1] < lessThan)
			return len;
		return findPoint(sortedArray, 0, len - 1, lessThan) + 1;
	}

	public static int findPoint(int[] sortedArray, int start, int end, int lessThan) {
		System.out.println(start + " " + end);
		if (end - start < 2)
			return start;
		int mid = Math.floorDiv(start+end, 2);
		if (lessThan <= sortedArray[mid]) {
			return findPoint(sortedArray, start, mid, lessThan);
		} else {
			return findPoint(sortedArray, mid, end, lessThan);
		}
		
    }
    
    public static void main(String[] args) {
		System.out.println(SortedSearch.countNumbers(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 7));
    }
}