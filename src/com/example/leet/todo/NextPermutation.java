package com.example.leet.todo;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] num = {1, 5, 1};
		nextPermutation(num);
		//Arrays.sort(num, 0, num.length);
		
		for (int n : num)
			System.out.print("-> " + n);

	}
    public static void nextPermutation(int[] num) {
        if (num.length <= 1) return;
        int i = num.length-2;
        while (i >=0 && num[i] >= num[i+1]) i--;
        if (i<0)
        {
            Arrays.sort(num, 0, num.length);
            return;
        }
        
        //find the first element from back which is greater than num[i]
        int j = num.length -1;
        while (j>=i && num[i]>=num[j]) j--;
        assert(j>i);
        //swap num[i], num[j] in place
        num[i] += num[j];
        num[j] = num[i] - num[j];
        num[i] = num[i] - num[j];
/*        int tmp = num[j];
        num[j] = num[i];
        num[i] = tmp;*/
        //sort the remaining part in natural ascending order
        //from i+1(inclusive) to num.length(exclusive)
        Arrays.sort(num, i+1, num.length);
        
    }
}


