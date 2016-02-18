package bits;

public class fastPower {
	 public int fastPower(int a, int b, int n) {
	       return (int)getPower(a,b,n);
	  }
	  
	  public long getPower(int a, int b, int n){
	       if(a == 0) return 0;
	        if(n == 0) return 1 % b;
	        if(n == 1) return a % b;
	        long ret=getPower(a, b,n/2);
	       ret *= ret;
	        ret %= b;
	        if(n % 2 == 1){
	            ret = ret * (a % b);
	        }
	        return ret % b;
	  }
}
