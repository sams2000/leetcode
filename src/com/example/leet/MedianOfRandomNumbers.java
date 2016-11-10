package com.example.leet;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Numbers are randomly generated and passed to a method. Write a program to find and maintain the median value as new values are generated.
 * One solution is to use two priority heaps: a below heap for the values below the median, and a above heap for the values above the median. 
 * The median will be largest value of the below heap. When a new value arrives it is placed in the below heap if the value is less than 
 * or equal to the median, otherwise it is placed into the above heap. The heap sizes can be equal or the below heap has one extra. 
 * This constraint can easily be restored by shifting an element from one heap to the other. The median is available in constant time, 
 * so updates are O(logN).
 * refer to (150-20.9)
 * @author bin zhou
 * @since 2016-02-02
 */
public class MedianOfRandomNumbers {
    //natural order will keep small value on top
	private static PriorityQueue<Integer> smallNumHeap = new PriorityQueue<Integer>(); 
	//natural order will keep large value on top
	private static PriorityQueue<Integer> largeNumHeap = new PriorityQueue<Integer>();
	
	public static void main(String[] args) {
		MedianOfRandomNumbers medianOfRandomNumbers = new MedianOfRandomNumbers();
		for (int i=0; i<10; i++){
			Random random = new Random();
			int randomNumber = random.nextInt(100);
			medianOfRandomNumbers.addNewNumber(randomNumber);
			System.out.println("Current Median for Step " + i + " is : " + getMedian());
		}
		
		while (!smallNumHeap.isEmpty()) System.out.print(smallNumHeap.poll() + ", ");
		System.out.println("\n");	
		
		while (!largeNumHeap.isEmpty()) System.out.print(largeNumHeap.poll() + ", ");
	}
	
	
	public void addNewNumber(int num) {
		if (smallNumHeap.size() == largeNumHeap.size()) { //when small number heap has same size of large number heap
			if ((largeNumHeap.peek() != null) && num > largeNumHeap.peek()) {
				smallNumHeap.offer(largeNumHeap.poll());
				largeNumHeap.offer(num);
			} else {
				smallNumHeap.offer(num);
			}
		} else if (smallNumHeap.size() > largeNumHeap.size()){ //more nums in small heap 
			if(num < smallNumHeap.peek()){
				largeNumHeap.offer(smallNumHeap.poll());
				smallNumHeap.offer(num);
			}
			else {
				largeNumHeap.offer(num);
			}
		} else {
		    if (num > largeNumHeap.peek()){
		        smallNumHeap.offer(largeNumHeap.poll());
		        largeNumHeap.offer(num);
		    } else {
		        smallNumHeap.offer(num);
		    }
		}
	}
	
	public static double getMedian() {
		if (smallNumHeap.isEmpty()) 
			return largeNumHeap.peek();
		else if (largeNumHeap.isEmpty()) 
			return smallNumHeap.peek();
	
		if (smallNumHeap.size() == largeNumHeap.size()) {
			return (largeNumHeap.peek() + smallNumHeap.peek()) / 2;
		} else if (smallNumHeap.size() > largeNumHeap.size()) {
			return smallNumHeap.peek();
		} else {
			return largeNumHeap.peek();
		}
	}	
	
}
