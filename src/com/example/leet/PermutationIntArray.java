package com.example.leet;
import java.util.ArrayList;
/**
 * The input is a int array. Write a program to generate ALL unique permutations of those characters. 
 * Unique. You may not store in an array or list, due to memory constraints. e.g. for input of abc your program should give 6 
 * permutations but for aba your program should give 3. Hint: make the list alphabetical.
 * 
 * this method assumes no duplicate elements in input array
 * 
 * @author bin zhou
 * @since 2016-01-29
 */
public class PermutationIntArray {
    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3, 3};
        ArrayList<ArrayList<Integer>>  result = new  ArrayList<ArrayList<Integer>>();
        
        permutation(input, null, result);

        System.out.println(result);
    }
    
    private static void permutation(int[] input, int[] sol,  ArrayList<ArrayList<Integer>> result) {
        if (input.length == 0) {
            //once input is empty, it's time to convert int array to arraylist
            ArrayList list = new ArrayList(sol.length); //convert int array to int arraylist
            for (int i=0; i<sol.length;i++){
                list.add(sol[i]);
            }
            result.add(list);
            
        } else {
            for (int i = 0; i < input.length; i++) {
                /*
                 * handle duplicate element
                 */
                if (duplicate(input, i)) continue;
                
                permutation(removeElement(input, i), concateArray(sol, input[i]), result);
            }            
        }
    }
        
    /**
     * Create new int array by removing value in index
     * @param input
     * @param index
     * @return
     */
    private static int[] removeElement(int[] input, int index){
        int[] output = new int[input.length-1];
        System.arraycopy(input, 0, output, 0, index);
        System.arraycopy(input, index+1, output, index, input.length-index-1);
        return output;
    }
    
    /**
     * Create new int array by appending newInt to the end of int array input
     * @param input
     * @param newVal
     * @return
     */
	private static int[] concateArray(int[] input, int newVal) {
		int[] output;

		if (input == null) {
			output = new int[] { newVal };

		} else {
			output = new int[input.length + 1];
			for (int i = 0; i < input.length; i++) {
				output[i] = input[i];
			}

			output[input.length] = newVal;
		}

		return output;
	}
	
	/**
	 * check whether the val exists in input int array
	 * @param val
	 * @param input
	 * @return
	 */
	private static boolean duplicate(int[] input, int index){
	    for (int i=index+1; i<input.length; i++){
	        if (input[i] == input[index])
	            return true;
	    }
	    return false;
	}

}
