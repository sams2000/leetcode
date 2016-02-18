package bits;

/**
 * 
 * @author bin zhou Created on Feb 17, 2016
 *
 */
public class flipBit {
    public static int bitSwapRequired(int a, int b) {
	         
	        int res=0;
	        int temp=a^b;
	        int num=32;
	        while(num>0){
	           res+=temp&1;
	           temp=temp>>1;
	           num--;
	        }
	        return res;
    }

    public static void main(String[] args) {
        System.out.println(bitSwapRequired(14, 31));
    }
}
