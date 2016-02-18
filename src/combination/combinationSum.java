package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
	  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	       List<List<Integer>> res = new ArrayList<List<Integer>>();
	       if (candidates==null||candidates.length==0){
	           return res;
	       }
	       Arrays.sort(candidates);
	       helper(candidates,target,0, res, new ArrayList<Integer>());
	       return res;
	    }
	    
	  public static void helper(int[] candidates, int target,int start, List<List<Integer>> results,ArrayList<Integer> res){
	        if (start>=candidates.length){
	            return;
	        }
	        if (target==0){
	            results.add(new ArrayList<Integer>(res));
	            return;
	        }
	        for(int i=start;i<candidates.length;i++){
	           ArrayList<Integer> temp=res; 
	           int tempT=target;
	           while(tempT-candidates[i]>=0) {  
	             tempT-=candidates[i];
	             temp.add(candidates[i]);
	              
	             helper(candidates,tempT,i+1,results,temp); 
	           }  
	        }   
	    }
	    
	    public static void main(String[] args){
	    	int[] test={1};
	    	combinationSum(test,1);
	    }
}
