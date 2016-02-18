package IntegerArray;

public class partitionArray {
	public static int partitionArray(int[] nums, int k) {
	    if (nums.length==0){
	        return 0;
	    }
	    int last=nums.length-1;
	    int i=0;
	    while(i<last){
	        while(i<last&&nums[i]>=k){
	            int tmp=nums[i];
	            nums[i]=nums[last];
	            nums[last]=tmp;
	            last--;
	        }
	        i++;
	    }
	    i=0;
	    while(i<nums.length&&nums[i]<k){
	        i++;
	    }
	    if (i>nums.length-1) return nums.length;
	    if (i==0&&nums[0]>=k) return 0;
	    return i;
    } 

	  public static void main(String[] args){
		  int[] nums={9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};
		  System.out.println(partitionArray(nums,10));
	  }
	  
	  //solution 2-- use quick sort
}
