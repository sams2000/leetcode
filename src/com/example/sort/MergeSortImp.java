package com.example.sort;

/**
 * Conceptually, merge sort works as follows: 1) Divide the unsorted list into
 * two sublists of about half the size 2) Divide each of the two sublists
 * recursively until we have list sizes of length 1, in which case the list
 * itself is returned 3) Merge the two sorted sublists back into one sorted
 * list.
 *
 * Mergesort incorporates two main ideas to improve its runtime: 1) A small list
 * will take fewer steps to sort than a large list. 2) Fewer steps are required
 * to construct a sorted list from two sorted lists than two unsorted lists. For
 * example, you only have to traverse each list once if they're already sorted
 * 
 * @author bin zhou
 * @since 2016-01-10
 */

class DataArray {
	private long[] array; // ref to array in long type
	private int num; // number of data items

	public DataArray(int max) {
		array = new long[max];
		num = 0;//start with index 0
	}

	/*
	 * put element into array
	 */
	public void insert(long value){
		array[num] = value; // insert it
		num++; // increment size
	}

	/*
	 * displays array contents
	 */
	public void display(){
		for (int j = 0; j < num; j++){
			System.out.print(array[j] + " ");
		}
		System.out.println("");
	}

	public void mergeSort(){
		long[] workSpace = new long[num];
		recMergeSort(workSpace, 0, num-1);
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return; // no sorting
		} else { // find midpoint
			int mid = (lowerBound + upperBound) / 2;
			// sort low half
			recMergeSort(workSpace, lowerBound, mid);
			// sort high half
			recMergeSort(workSpace, mid + 1, upperBound);
			// merge them
			merge(workSpace, lowerBound, mid + 1, upperBound);
		}
	}

	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0; // workspace index
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1; // # of items

		while (lowPtr <= mid && highPtr <= upperBound) {
			if (array[lowPtr] < array[highPtr]) {
				workSpace[j++] = array[lowPtr++];
			} else {
				workSpace[j++] = array[highPtr++];
			}
		}

		while (lowPtr <= mid) {
			workSpace[j++] = array[lowPtr++];
		}

		while (highPtr <= upperBound) {
			workSpace[j++] = array[highPtr++];
		}

		for (j = 0; j < n; j++) {
			array[lowerBound + j] = workSpace[j];
		}
	} 

}

class MergeSortImp {
	public static void main(String[] args) {
		int maxSize = 20; // max array size
		DataArray dataArray = new DataArray(maxSize); // create the array

		dataArray.insert(64); // insert items
		dataArray.insert(21);
		dataArray.insert(33);
		dataArray.insert(70);
		dataArray.insert(12);
		dataArray.insert(85);
		dataArray.insert(44);
		dataArray.insert(3);
		dataArray.insert(99);
		dataArray.insert(0);
		dataArray.insert(108);
		dataArray.insert(36);

		dataArray.display(); // display items

		dataArray.mergeSort(); // merge sort the array

		dataArray.display(); // display items again
	}
}