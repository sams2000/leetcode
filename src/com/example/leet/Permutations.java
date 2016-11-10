package com.example.leet;

import java.util.ArrayList;
import java.util.List;
/**
 * find all permutations for car registration.
 *  first letter can be "12"
 *  second letter can be "xyz"
 *  third letter can be "-+"
 * output all combinations: [1x-, 1x+, 1y-, 1y+, 1z-, 1z+, 2x-, 2x+, 2y-, 2y+, 2z-, 2z+]
 * 
 * @author bin zhou 
 *         Created on Mar 1, 2016
 *
 */
public class Permutations {
    public static void main(String[] args) {

        List<String> input = new ArrayList<String>();
        input.add("12");
        input.add("xyz");
        input.add("-+");
        
        List<String> result = permutations(input);
        
        System.out.println("all possible combinations : " + result);
       
    }
    
    /**
     * input "12", "xyz", "-+"
     * @param input
     * @return
     */
    public static List<String> permutations(List<String> input){
        List<String> result = new ArrayList<String>();
        
        permutationsHelper(input, 0, input.size(), "", result);
        
        return result;
        
    }
    
    public static void permutationsHelper(List<String> input, int start, int size, String sol, List<String> result){
        if (sol.length() == size){
            result.add(sol);
        } else {
            String str = input.get(start);
            
            for (int i = 0; i<str.length(); i++){
                                    
                permutationsHelper(input, start+1, size, sol+str.charAt(i), result);
                
            }
        }
    }
}
