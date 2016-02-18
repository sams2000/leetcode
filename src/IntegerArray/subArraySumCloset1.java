package IntegerArray;
/*
 * https://github.com/shawnfan/LintCode/blob/master/Java/Subarray%20Sum%20Closest.java
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


	class CustomComparator implements Comparator<int[]> {
	    public int compare(int[] a, int[] b) {
	          return Integer.compare(a[0], b[0]);
	    //	return a[0]-b[0];
	    }
	}

	public class subArraySumCloset1{
	    
	    /**
	     * @param nums: A list of integers
	     * @return: A list of integers includes the index of the first number 
	     *          and the index of the last number
	     */
	   public   ArrayList<Integer> subarraySumClosest(int[] nums) {
	        ArrayList<Integer> rst = new ArrayList<Integer>();
	        if(nums == null || nums.length == 0) {
	            return rst;
	        }
	        if (nums.length == 1) {
	            rst.add(0); rst.add(0);
	            return rst;
	        }
	        int[][] culmulate = new int[nums.length][2];
	        culmulate[0][0] = nums[0];
	        culmulate[0][1] = 0;
	        for (int i = 1; i < nums.length; i++) {
	            culmulate[i][0] = culmulate[i - 1][0] + nums[i];
	            culmulate[i][1] = i;
	        }
	        //TEST:
	        for(int i =0 ; i < nums.length; i++) {
	            System.out.println("test:" + culmulate[i][0] + " " + culmulate[i][1]);
	        }
	        Arrays.sort(culmulate, new CustomComparator());
	        for(int i =0 ; i < nums.length; i++) {
	            System.out.println("test:" + culmulate[i][0] + " " + culmulate[i][1]);
	        }
	        int min = Integer.MAX_VALUE;
	        int start = 0;
	        int end = 0;
	        for (int i = 0; i < nums.length - 1; i++) {
	            int temp = culmulate[i + 1][0] - culmulate[i][0];
	            if (temp <= min) {
	                min = temp;
	                start = culmulate[i][1];
	                end = culmulate[i + 1][1];
	            }
	        }
	        System.out.println("min:" + min);
	         if (start < end) {
	            rst.add(start + 1);
	            rst.add(end);
	        } else {
	            rst.add(end + 1);
	            rst.add(start);
	        }
	        return rst;
	    }
	   
	   public static void main(String[] args){
	        int[] nums = {6,-4,-8,3,1,7};//{5,10,5,3,2,1,1,-2,-4,3};
	        subArraySumCloset1 t = new subArraySumCloset1();
	        ArrayList<Integer> rst = t.subarraySumClosest(nums);
	        System.out.println(rst.get(0) + " " + rst.get(1));
	    }
	}





	//I also had to run a little java program locally to test/debug:
	/*
	import java.lang.*;
	import java.util.*;
	class CustomComparator implements Comparator<int[]> {
	    public int compare(int[] a, int[] b) {
	        return Integer.compare(a[0], b[0]);
	    }
	}
	public class test {
	    public ArrayList<Integer> subarraySumClosest(int[] nums) {
	        ArrayList<Integer> rst = new ArrayList<Integer>();
	        if(nums == null || nums.length == 0) {
	            return rst;
	        }
	        int[][] culmulate = new int[nums.length][2];
	        culmulate[0][0] = nums[0];
	        culmulate[0][1] = 0;
	        for (int i = 1; i < nums.length; i++) {
	            culmulate[i][0] = culmulate[i - 1][0] + nums[i];
	            culmulate[i][1] = i;
	        }
	        //TEST:
	        for(int i =0 ; i < nums.length; i++) {
	            System.out.println("test:" + culmulate[i][0] + " " + culmulate[i][1]);
	        }
	        Arrays.sort(culmulate, new CustomComparator());
	        for(int i =0 ; i < nums.length; i++) {
	            System.out.println("sorted:" + culmulate[i][0] + " " + culmulate[i][1]);
	        }
	        int min = Integer.MAX_VALUE;
	        int start = 0;
	        int end = 0;
	        for (int i = 0; i < nums.length - 1; i++) {
	            int temp = culmulate[i + 1][0] - culmulate[i][0];
	            System.out.println(culmulate[i + 1][0] + " minus " + culmulate[i][0] + " = " + temp);
	            if (temp <= min) {
	                min = temp;
	                start = culmulate[i][1];
	                end = culmulate[i + 1][1];
	                System.out.println("record:" + start + " " + end );
	            }
	        }
	        System.out.println("min:" + min);
	        if (start < end) {
	            rst.add(start + 1);
	            rst.add(end);
	        } else {
	            rst.add(end + 1);
	            rst.add(start);
	        }
	        return rst;
	    }
	    public static void main(String[] args){
	        int[] nums = {6,-4,-8,3,1,7};//{5,10,5,3,2,1,1,-2,-4,3};
	        test t = new test();
	        ArrayList<Integer> rst = t.subarraySumClosest(nums);
	        System.out.println(rst.get(0) + " " + rst.get(1));
	    }
	}
	*/

 
