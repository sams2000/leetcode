package com.example.leet;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
    Note:
    ?   Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a �? b �? c �? d)
    ?   The solution set must not contain duplicate quadruplets.
        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
    
        A solution set is:
        (-1,  0, 0, 1)
        (-2, -1, 1, 2)
        (-2,  0, 0, 2)

 * @author bzhou
 * @since 2/3/2013 not finished
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SUM4
{
    public class TwoSum implements Comparable<TwoSum>{
        private int index1;
        private int index2;
        private int sumValue;
        
        public int getIndex1()
        {
            return index1;
        }

        public void setIndex1(int index1)
        {
            this.index1 = index1;
        }

        public int getIndex2()
        {
            return index2;
        }

        public void setIndex2(int index2)
        {
            this.index2 = index2;
        }

        public int getSumValue()
        {
            return sumValue;
        }

        public void setSumValue(int sumValue)
        {
            this.sumValue = sumValue;
        }


        public TwoSum(int a, int b, int value)
        {
            index1 = a;
            index2 = b;
            sumValue = value;
        }
        
        public int compareTo(TwoSum compareTwoSum) {
            
            int compareSumValue = ((TwoSum) compareTwoSum).getSumValue(); 
     
            //ascending order by sumvalue
            return this.sumValue - compareSumValue;
     
            //descending order by sumvalue
            //return compareSumValue - this.sumValue   
        }
    }
      
    public class TwoSumCompator implements Comparator<TwoSum>{
     
        public int compare(TwoSum ts1, TwoSum ts2) {
            if (ts1.sumValue == ts2.sumValue){
                if (ts1.index1 == ts2.index1)  
                    return (ts1.index2 - ts2.index2);
                else 
                    return (ts1.index1 - ts2.index1);       
            }
            else 
                return (ts1.sumValue - ts2.sumValue);  
        }
    }    

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int[] array = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        
        //ArrayList<ArrayList<Integer>> result = fourSum(array, target);
        //System.out.println("The closest sum to the target is: "+result);
    }
    
//    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        
//        ArrayList<TwoSum> twoSumList = new ArrayList<TwoSum>();
//        
//        for (int i=0; i<num.length; i++)
//        {
//            for (int j=i+1; j<num.length; j++)
//            {
//                TwoSum szTwoSum = new TwoSum(i, j, num[i]+num[j]);
//                twoSumList.add(szTwoSum);
//            }
//        }
//        
//        //TwoSum[] twoSumArray = twoSumList.toArray(new TwoSum());
//       // Arrays.sort(twoSumList.t, new TwoSumCompator());
//        
//    }    
    
}




