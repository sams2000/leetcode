package IntegerArray;

import java.util.HashMap;

public class twoSum {
	   public int[] twoSum(int[] numbers, int target) {
	        int[] res=new int[2];
	        if (numbers.length==0){
	            return res;
	        }
	        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	        for(int i=0;i<numbers.length;i++){
	            if (map.containsKey(numbers[i])){
	                res[0]=map.get(numbers[i])+1;
	                res[1]=i+1;
	                return res;
	            }
	            map.put(target-numbers[i],i);
	        }
	        return res;
	    }
	
}
