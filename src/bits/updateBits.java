package bits;

public class updateBits {
	   public static int updateBits(int n, int m, int i, int j) {
	        if (m==0) return n;
	        long left=~(~0<<i);
	        long right=~0<<(j+1);
	        long mask=left&right;
	        long res=n | mask;
	        m=m<<i;
	       return  (int) (res | m);
	    }
	   
	   public static void main(String[] args){
		   System.out.println((int)~0);
	   }
}
