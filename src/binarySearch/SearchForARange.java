package binarySearch;

import java.util.ArrayList;

public class SearchForARange {
	  public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
	        ArrayList<Integer> res=new ArrayList<Integer>();
	        res.add(-1);
	        res.add(-1);
	        if (A.size()==0) return res;
	        int l=0;
	        int r=A.size()-1;
	        while(l<=r){
	            int mid=l+(r-l)/2;
	            if (A.get(mid)==target){
	               l=mid;
	               while(l>1&&A.get(l)==A.get(l-1)){
	                   l--;
	               } 
	               r=mid;
	               while(r<A.size()-1&&A.get(r)==A.get(r+1)){
	                   r++;
	               }
	               res.set(0,l);
	               res.set(1,r);
	               return res;
	            }
	            if (A.get(mid)>target){
	                r=mid-1;
	            }else{
	                l=mid+1;
	            }
	         
	        }
	        return res;
	    }
	  
	  public static ArrayList<Integer> searchRange2(ArrayList<Integer> A, int target) {
	        ArrayList<Integer> res=new ArrayList<Integer>();
	        res.add(-1);
	        res.add(-1);
	        if (A.size()==0) return res;
	        int l=0;
	        int r=A.size()-1;
	        int mid=-1;
	        while(l+1<r){
	            mid=l+(r-l)/2;
	            if (A.get(mid)==target){
	               r=mid;
	            }else 
	            if (A.get(mid)>target){
	                r=mid; //r=mid+1;
	            }else{
	                l=mid; //l=mid-1; also works
	            }
	         
	        }
	        if (A.get(l)==target){
	            res.set(0,l);
	        }else if (A.get(r)==target){
	            res.set(0,r);
	        }else{
	            return res;
	        }
	        
	        l=0;
	        r=A.size()-1;
	        while(l+1<r){
	            mid=l+(r-l)/2;
	            if (A.get(mid)==target){
	               l=mid;
	            }else 
	            if (A.get(mid)>target){
	                r=mid;
	            }else{
	                l=mid;
	            } 
	        }
	       if (A.get(r)==target){
	            res.set(1,r);
	        }else if (A.get(r)==target){
	            res.set(1,l);
	        }else{
	            return res;
	        }
	        return res;
	    }
	  
	  public  static void main(String[] args){
		  ArrayList<Integer> test= new ArrayList<Integer>();
		  test.add(2);test.add(2);test.add(2);test.add(2);
		  test.add(2);test.add(2);test.add(2); 
		  System.out.println(searchRange2(test, 2));
		  
	  }
}
