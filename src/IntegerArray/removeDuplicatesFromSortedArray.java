package IntegerArray;

public class removeDuplicatesFromSortedArray {
	  public static int removeDuplicates(int[] nums) {
	        if (nums==null || nums.length==0) return 0;
	        int pre=0;
	        int curr=1;
	        System.out.println("len="+nums.length);
	        while(curr<nums.length){
	            while(curr<nums.length&&nums[curr]==nums[pre]){
	                curr++; 
	               
	            }
	            if (curr>=nums.length){break;}
	            //move curr to pre+1
	            System.out.print("pre="+pre+ "    ");
	            pre++;
	            System.out.println("pre="+pre);
	            if (pre!=curr)nums[pre]=nums[curr];
	            System.out.print("curr="+curr+ "    ");
	            curr++;
	            System.out.println("curr="+curr+ "    ");
	        }
	        return pre+1;
	    }
	  
	  //simple 
	  public int removeDuplicates2(int[] nums) {
	        if (nums==null || nums.length==0) return 0;
	        int pre=0;
	        int curr=1;
	      for(int i=0;i<nums.length;i++){
	          if (nums[i]!=nums[pre]){
	              nums[++pre]=nums[i];
	          }
	      }
	        return pre+1;
	    }
	  
	  public static void main(String[] args){
		  int[] nums={-14,-14,-13,-13,-13,-13,-13,-13,-13,-12,-12,-12,-12,-11,-10,-9,-9,-9,-8,-7,-5,-5,-5,-5,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,7,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,14,14,14,14,15,16,16,16,18,18,18,19,19,19,19,20,20,20,21,21,21,21,21,21,22,22,22,22,22,23,23,24,25,25};
		//  int[] nums={-14,-14,-13,-13,-13,-13,-13,-13};
		  int res=removeDuplicates(nums);
		  System.out.println(res);
		  
	  }
}
