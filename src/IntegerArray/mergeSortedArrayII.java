package IntegerArray;

import java.util.ArrayList;


public class mergeSortedArrayII {
	   public static ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
	        if (A.size()==0) return B;
	        if (B.size()==0) return A;
	        ArrayList<Integer> res= new ArrayList<Integer>();
	        int idxA=0; int idxB=0;
	        while(idxA<A.size()&&idxB<B.size()){
	            if (A.get(idxA)<=B.get(idxB)){
	            	
	                res.add(A.get(idxA));
	                System.out.println(A.get(idxA));
	                idxA++;
	            }else{
	                res.add(B.get(idxB));
	                System.out.println(B.get(idxB));
	                idxB++;
	            }
	        }
	        if (idxA==A.size()){
	            res.addAll(B.subList(idxB,B.size()));
	        }
	        if (idxB==B.size()){
	            res.addAll(A.subList(idxA,A.size()));
	        }
	        return res; 
	    }
	   
	   public   static void main(String[] args){
		   ArrayList<Integer> A=new ArrayList<Integer>();
		   ArrayList<Integer> B=new ArrayList<Integer>();
		   A.add(7);B.add(5);B.add(7);
		   ArrayList<Integer> res=mergeSortedArray(A,B);
		   System.out.println(res);
	   }
}
