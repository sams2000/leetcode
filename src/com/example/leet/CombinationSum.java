package com.example.leet;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * input int array and a target, find the all possible combinations to reach target
 * note: element can be reused multiple times
 * @author bin zhou
 * @since 2016-01-30
 */
public class CombinationSum {
    public static void main(String[] args){
//        int[] input= {2,3,6,7};
        int[] input= {2,2,3,6,7};
        int target = 7;
    	
        ArrayList<ArrayList<Integer>> result=combinationSumHelper1(input,target);
        System.out.println(result);

    }	
	
    /////////////////////////////////////////////////////// DUPLICATE is allowed
    /**
     * recursive solution, element can be reused
     * @param input
     * @param target
     * @return
     */
	public static ArrayList<ArrayList<Integer>> combinationSumHelper(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        //corner cases, to return directly
        if (input.length==0 || target<0){
            return result;
        }
        
        //sort input array first
        Arrays.sort(input);
        helper(input, 0, new ArrayList<Integer>(), target, result);
        
        return result;
    }
    
	/**
	 * element can be reused
	 * @param input
	 * @param start
	 * @param sol
	 * @param target
	 * @param result
	 */
    private static void helper(int[] input, int start, ArrayList<Integer> sol, int target, ArrayList<ArrayList<Integer>> result){
        
        if (target==0){
            result.add(sol);
        } 
        
        //since the element can be reused, for loop needs starts with the first element
        for (int i=start; i<input.length; i++){
            if (input[i] <= target){
                ArrayList<Integer> tmp = new ArrayList<Integer>(sol);
                tmp.add(input[i]);
                helper(input, i, tmp, target-input[i], result);
            }
             
        }
    }
    
    /////////////////////////////////////////////////////// NO DUPLICATE
    
    /**
     * recursive solution, element can NOT be reused
     * @param input
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> combinationSumHelper1(int[] input, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        //corner cases
        if (input.length==0 || target<0){
            return result;
        }
        
        //sort input array first
        Arrays.sort(input);
        helper1(input, 0, new ArrayList<Integer>(), target, result);
        
        return result;
    }
    
    /**
     * element can NOT be reused
     * @param input
     * @param start
     * @param sol
     * @param target
     * @param result
     */
    private static void helper1(int[] input, int start, ArrayList<Integer> sol, int target, ArrayList<ArrayList<Integer>> result){
        
        if (target==0){
            result.add(sol);
        } 
        
        //since the element can NOT be reused, for loop needs starts with the SECOND element
        for (int i=start; i<input.length; i++){
            if (input[i] <= target){
                ArrayList<Integer> tmp = new ArrayList<Integer>(sol);
                tmp.add(input[i]);
                helper1(input, i+1, tmp, target-input[i], result);
            }
             
        }
    }
    
}
