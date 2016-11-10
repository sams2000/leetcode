package com.example.leet;

/**
 * Given a set of distinct integers, S, return all possible subsets.
Note:
?Elements in a subset must be in non-descending order.
?The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 * @author bin zhou
 * @since 2016-02-01
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Subsets123 {
    public static void main(String[] args) {
        //way 1 : to initialize arraylist
//        ArrayList<Integer> input = new ArrayList<Integer>();
//        S.add(1);
//        S.add(2);
//        S.add(3);
        
        //way 2 : to initialize arraylist
        ArrayList<Integer> input = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        
        System.out.println("By getSubsetsI" + getAllSubsets(input));
        
        System.out.println("By getSubsetsI" + getAllSubsetsWithoutDup(new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(2);
        }}));
        
        System.out.println("By getBinaryRepresentations" + getBinaryRepresentations(3));
        
        
   }

    public static ArrayList<ArrayList<Integer>> getAllSubsets(
            ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int total = 1 << input.size(); // total number of sub sets is
                                   // pow(2,set.size());
        for (int i = 0; i < total; i++) {
            ArrayList<Integer> sol = new ArrayList<Integer>();
            int k = i; // k represents the integer value of bit
                       // representation.e.g 110 is 6
            int index = 0;// bit index of 1 to fetch element from original set
            while (k > 0) {
                if ((k & 1) > 0) // check last bit of current k
                    sol.add(input.get(index));

                k >>= 1; // move 1 bit right
                index++; // add 1 to index
            }
            result.add(sol);
        }

        return result;
    }
    
    /*
     * Given a collection of integers that might contain duplicates, S, return all possible subsets.
        Note:
        ?Elements in a subset must be in non-descending order.
        ?The solution set must not contain duplicate subsets.
        For example,
        If S = [1,2,2], a solution is:
        [
          [2],
          [1],
          [1,2,2],
          [2,2],
          [1,2],
          []
        ]

     */
    public static ArrayList<ArrayList<Integer>> getAllSubsetsWithoutDup(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int max = 1 << input.size(); //pow(2,num.length);
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> sol = new ArrayList<Integer>();//create a new subset
            int k = i; //k represents the integer value of bit representation.e.g 110 is 6
            int index = 0;//index to fetch from original set
            while (k > 0) {
                if ((k & 1) > 0) { //check last bit of current k 
                    sol.add(input.get(index));
                }
        
                k >>= 1; //move 1 bit right
                index++; //add 1 to index
            }
            //following code to elminate duplicates
            Collections.sort(sol); //sort elements
            if (!result.contains(sol)){ //only insert non-dup subset
                result.add(sol);
            }
        }
        
        return result;
    }
    
    /*
     * Given number of power of 2, display all binary representation of elements from 1 to pow(2,N).
        e.g N=3, 
        output: [[0, 0, 0], [1, 0, 0], [0, 1, 0], [1, 1, 0], [0, 0, 1], [1, 0, 1], [0, 1, 1], [1, 1, 1]]
     */
    public static ArrayList<ArrayList<Integer>> getBinaryRepresentations(int n){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> template = new ArrayList<Integer>();
        template.add(0);
        template.add(0);
        template.add(0);
        
        int max = 1 << n; //pow(2,num.length);
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> sol = (ArrayList<Integer>)template.clone();
            int k = i; //k represents the integer value of bit representation.e.g 110 is 6
            int index = 0;//index to fetch from original set
            while (k > 0) {
                if ((k & 1) > 0) { //check last bit of current k 
                    sol.set(index, 1);
                } 
        
                k >>= 1; //move 1 bit right
                index++; //add 1 to index
            }
            result.add(sol);
        }
        
        return result;        
    }

}
