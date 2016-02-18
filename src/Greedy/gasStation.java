package Greedy;

public class gasStation {
	   public int canCompleteCircuit(int[] gas, int[] cost) {
	        if (gas.length==0) return -1;
	        int total=0;
	        int sum=0; int remaining=0; int start=0;
	        for(int i=0;i<gas.length;i++){
	             remaining=gas[i]-cost[i];
	            total+=  remaining;
	            if (sum<0){
	                sum=remaining;
	                start = i;
	            }else{
	                sum+=remaining;
	            }
	        }
	        if (total>=0) return start;
	        else return -1;
	    }
}
