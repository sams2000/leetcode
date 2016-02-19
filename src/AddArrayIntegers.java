/**
 * Add two array represented integers
 * 
 * e.g input {1,2,3}
 *           {4,5,6}
 *           
 *     output 579
 * @author bin zhou 
 *         Created on Feb 17, 2016
 *
 */
public class AddArrayIntegers {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 4, 5, 7};
        
        System.out.println(addArrayIntegers(a, b));

    }
    
    public static int addArrayIntegers(int[] a, int[] b){
        int i=a.length, j=b.length;
        
        int d=1, carry=0, result=0;
        
        
        while(i>0 && j>0){
            int cur = a[i-1] + b[j-1] + carry;
            carry = cur/10;
            result += (cur % 10) * d;
            d *=10;
            i--;
            j--;
        }
        
        while (i>0){
            int cur = a[i-1] + carry;
            carry = cur/10;
            result += (cur % 10) * d;
            d *=10;
            i--;
        }
 
        while (j>0){
            int cur = b[j-1] + carry;
            carry = cur/10;
            result += (cur % 10) * d;
            d *=10;
            j--;
        }
        
        if (carry > 0){
            result += carry * d;
        }
        
        return result;
    }

}
