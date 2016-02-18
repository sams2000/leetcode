package IntegerArray;

import java.util.ArrayList;
import java.util.Arrays;

public class threeSUm {
	  public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
	       ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	       if (numbers.length==1) return res;
	       Arrays.sort(numbers);
	       for(int i=0;i<numbers.length;i++){
	           int j=i+1;
	           int k=numbers.length-1;
	           int temp=0-numbers[i];
	           while(j<k){
	               if (numbers[k]+numbers[j]==temp){
	                   ArrayList<Integer> tmp= new ArrayList<Integer>();
	                   tmp.add(numbers[i]);
	                   tmp.add(numbers[j]);
	                   tmp.add(numbers[k]);
	                   if (!res.contains(tmp)){
	                        res.add(tmp);
	                   }
	               }
	               if (numbers[k]+numbers[j]>temp){k--;
	                   
	               }else{ j++; }
	           }
	       }
	       return res;
	    }
}
