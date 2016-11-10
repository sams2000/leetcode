package com.example.leet;

/**
 * return the number from int array that is closest to zero. If there are two
 * equally close to zero elements like 2 and -2, consider the positive element
 * to be "closer" to zero. 1. loop through array elements and fetch min diff
 * with 0 2. return the value in that index
 * 
 * @author bzhou
 * @since 2/3/2013
 */
public class ClosestToZero {
	public static void main(String args[]) {

		int values[] = { -8, -5, -4, -3, -2, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
				31, 37, 41, 43, 47, 53, 59, 61 };

		if (values.length > 0) {
			int closestIndex = getClosestToZero(values);
			System.out.println("The closest to zero is : " + values[closestIndex]);
		}
	}
	
    public static int getClosestToZero(int[] num) {
        int minValue = Math.abs(num[0]);
        int returnIndex = 0;

        for (int i = 1; i < num.length; i++) {
            if (Math.abs(num[i]) < minValue) {
                minValue = Math.abs(num[i]);
                returnIndex = i;
            } else if (Math.abs(num[i]) == minValue) {
                //if there are two equally close to zero elements like 2 and -2, consider the positive element
                if (num[i] > 0 && num[returnIndex] < 0) {
                    returnIndex = i;
                }
            }
        }

        return returnIndex;
    }
}
