package com.example.sort;

/**
 * Quicksort sorts by employing a divide and conquer strategy to divide a list
 * into two sub-lists.
 *
 * The steps are:
 *
 * 1) Pick an element, called a pivot, from the list. 2) Reorder the list so
 * that all elements which are less than the pivot come before the pivot and so
 * that all elements greater than the pivot come after it (equal values can go
 * either way). After this partitioning, the pivot is in its final position.
 * This is called the partition operation. 3) Recursively sort the sub-list of
 * lesser elements and the sub-list of greater elements.
 *
 * The base case of the recursion are lists of size zero or one, which are
 * always sorted. The algorithm always terminates because it puts at least one
 * element in its final place on each iteration (the loop invariant).
 * 
 * @author bin zhou
 * @since 2016-02-07
 */
public class QuickSortImp {
	private static long comparisons = 0;
	private static long exchanges = 0;

	public static void quicksort(int[] a) {
		//shuffle(a); // optional as initialization step
		quicksort(a, 0, a.length - 1);
	}

	public static void quicksort(int[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		int i = partition(a, left, right);
		quicksort(a, left, i - 1);
		quicksort(a, i + 1, right);
	}

	/**
	 * pick the most right element as pivot for this round, 
	 * move index i from left forward, and index j from right -1 backward,
	 * until i>=j, swap the most right element to index i and partition 
	 * the array to two parts, one [left, i-1] and [i+1, right]
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition(int[] a, int left, int right) {
		int i = left;
		int j = right -1;
		while (true) {
			while (less(a[i], a[right])) {
			    i++; // find item on left to swap a[right] acts as sentinel
			}
			
			while (less(a[right], a[j])) {
			    // find item on right to swap
			    j--;
			    
				if (j <= i) {
					break; // don't go out-of-bounds
				}
			}
			
			if (i >= j) {
				break; // check if pointers cross
			}
			
			exch(a, i, j); // swap two elements into place
		}
		
		exch(a, i, right); // swap with partition element
		
		return i;
	}

	// is x < y ?
	private static boolean less(double x, double y) {
		comparisons++;
		return (x < y);
	}

	// exchange a[i] and a[j]
	private static void exch(int[] a, int i, int j) {
		exchanges++;
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// shuffle the array a by same chance
	private static void shuffle(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int j = i + (int) (Math.random() * (N - i)); // between i and N-1
			exch(a, i, j);
		}
	}

	public static void main(String[] args) {
		int N = 10;

		// generate N random elements between 0 and 100
		long start = System.currentTimeMillis();

		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = (int) (Math.random() * 100);
		}

		long stop = System.currentTimeMillis();

		double elapsed = (stop - start) / 1000.0;
		System.out.println("Generating input:  " + elapsed + " seconds");

		// print out pre-sort elements
		System.out.print("pre-sort/raw elements: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] +", ");
		}
		System.out.println();

		// sort elements
		start = System.currentTimeMillis();

		quicksort(a);

		stop = System.currentTimeMillis();

		elapsed = (stop - start) / 1000.0;
		System.out.println("Quicksort:   " + elapsed + " seconds");

		// print out post-sort elements
		System.out.print("post-sort/sorted elements: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();

		// print statistics
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Exchanges:   " + exchanges);
	}
}