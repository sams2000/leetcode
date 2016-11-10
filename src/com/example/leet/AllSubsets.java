package com.example.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to return all subsets of a set, refer to 150-9.4
 * e.g input: [1,2,3]
 *     output: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
 * @author Bin Zhou
 * @since 2016-08-08
 */
public class AllSubsets{
    public static void main(String[] args){
        List<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
                
        genAllSubsets(input, result);
        
        System.out.println(result);
    }
    
    /**
     * Generating all subsets, then really just comes down to generating all binary
     * numbers(that is, all integers). We iterate through all numbers from 1 to 2^N 
     * and translate the binary representation of the numbers into a set.
     * e.g [1,2,3]
     */
    public static void genAllSubsets(List<Integer> input, List<List<Integer>> result) {
        //the number of combination is 2^n
        int max = 1<<input.size();
        
        for (int i=0; i<max; i++){
            System.out.println(convertIntToSet(i, input));
            result.add(convertIntToSet(i, input));
        }
    }


    /**
     * convert particular number to binary, then Integer list
     * @param k
     * @param set
     * @return
     */
    public static List<Integer> convertIntToSet(int k, List<Integer> input){
        List<Integer> result = new ArrayList<Integer>();
        
        int index=0;
        while(k>0){
            if ((k&1) == 1){
                result.add(input.get(index));
            }
            k>>=1;
            index++;
        }
        
        return result;
    }
}
