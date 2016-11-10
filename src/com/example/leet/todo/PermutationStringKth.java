package com.example.leet.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3..n] contains a total of n! unique permutations.
	By listing and labeling all of the permutations in order,
	We get the following sequence (ie, for n = 3):
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
 * 
 * @author bin zhou
 * @since 7/30/2013 
 * @since 2016-01-26
 */
public class PermutationStringKth{
    public static void main(String[] args){
        
    	System.out.println(getPermutation(5, 2));
    }

    public static String getPermutation(int n, int k) {
        boolean[] output = new boolean[n];
        StringBuilder buf = new StringBuilder("");
 
        int[] res = new int[n];
        res[0] = 1;
 
        for (int i = 1; i < n; i++)
            res[i] = res[i - 1] * i;
 
        for (int i = n - 1; i >= 0; i--) {
            int s = 1;
 
            while (k > res[i]) {
                s++;
                k = k - res[i];
            }
 
            for (int j = 0; j < n; j++) {
                if (j + 1 <= s && output[j]) {
                    s++;
                }
            }
 
            output[s - 1] = true;
            buf.append(Integer.toString(s));
        }
 
        return buf.toString();
    }
        
    public static String getPermutation2(int n, int k){
        int t = 1;
        List<Integer> numbers = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; i++) {
            t = t * i;
            numbers.add(i);
        }
        t /= n;
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 1; i--) {
            int p = k / t;
            int np = numbers.get(p);
            sb.append(String.valueOf(np));
            numbers.remove(p);
            k %= t;
            t /= i;
        }
        sb.append(String.valueOf(numbers.get(0)));
        return sb.toString();
    }

}
