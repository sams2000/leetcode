package IntegerArray;

import java.util.ArrayList;
/*
 * Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.

Have you met this question in a real interview? Yes
Example
For A = [1, 2, 3], return [6, 3, 2].
 * 
 */
public class ProductofArrayExclude {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> res=new ArrayList<Long>();
        if (A.size()==0) return res;
        ArrayList<Long> left=new ArrayList<Long>();
         ArrayList<Long> right=new ArrayList<Long>();
         Long lefSum=1L;
         Long rSum=1L;
         int len=A.size();
        left.add(1L);
        right.add(1L);
        
         for(int i=0;i<len-1;i++){ 
                  lefSum=lefSum*A.get(i);
                   left.add(lefSum);
                   rSum=rSum*A.get(len-i-1);
                  right.add(rSum); 
         }
         for(int i=0;i<len;i++){
              
             Long tmp=left.get(i)*right.get(len-i-1);
             left.set(i,tmp);
         }
         return left;
    }
}
