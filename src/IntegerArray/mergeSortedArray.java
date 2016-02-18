package IntegerArray;

import java.util.ArrayList;


public class mergeSortedArray {
	 public static void   mergeSortedArray(int[] A, int m, int[] B, int n) {
		  
		  int lenA=m-1;
          int lenB=n-1;
          int len=m+n-1;
       
        
         for(int i=len; i>=0;i--){
             if (lenB>=0&& lenA>=0){
                     if (A[lenA]>=B[lenB]){
                         A[i]=A[lenA];
                         lenA--;
                     }else{
                         A[i]=B[lenB];
                         lenB--;
                     }
              }else if (lenB<0){
                    A[i]=A[lenA];
                      lenA--;
             }else 
             if (lenA<0){
                    A[i]=B[lenB];
                     lenB--;
              }
         }
	 }
	   
	   public   static void main(String[] args){
		   int[] A={1,2,4,9,9};
		  int[] B={2,3};
		  mergeSortedArray(A,3,B,2);
		   System.out.println(A);
	   }
}
