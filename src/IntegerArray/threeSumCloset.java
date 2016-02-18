package IntegerArray;

import java.util.Arrays;

public class threeSumCloset {
	  public int threeSumClosest(int[] numbers ,int target) {
	        if (numbers.length==0) return 0;
	        int res=0;
	        if (numbers.length<3){
	            for(int s:numbers){
	                res+=s;
	            }
	            return res;
	        }
	        Arrays.sort(numbers);
	        int sum=Integer.MAX_VALUE;
	        for(int i=0;i<numbers.length-2;i++){
	            int j=i+1;
	            int k=numbers.length-1;
	            int temp=numbers[i];
	          
	            while(j<k){
	                sum=Math.abs(temp+numbers[j]+numbers[k]-target)<Math.abs(sum-target)?(temp+numbers[j]+numbers[k]):sum;
	                if (numbers[j]+numbers[k]<target-temp){
	                    j++;
	                }else{k--;}
	                
	            }
	        }
	        return sum;
	    }
}
