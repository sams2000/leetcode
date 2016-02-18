package DP;

public class trapRainWatering {
	   public static int trapRainWater(int[] heights) {
		      if (heights.length==0) return 0;
		      int sum=0;
		      int len=heights.length;
		      int[] left=new int[len];
		      int[] right=new int[len];
		      left[0]=heights[0];
		      right[len-1]=heights[len-1];
		      int max=left[0];
		      for(int i=1;i<len;i++){
		    	 max=Math.max(max,heights[i]);
		         left[i]=max;
		      }
		      for(int i=0;i<len;i++){
		    	  System.out.print(left[i]+ " ");
		      }System.out.println("======");
		      max=heights[len-1];
		      for(int i=len-2;i>=0;i--){
		    	  max=Math.max(max,heights[i]);
			      right[i]=max;
		      }
		      for(int i=0;i<len;i++){
		    	  System.out.print(right[i]+ " ");
		      }System.out.println("======");
		       
		      for(int i=1;i<len-1;i++){
		          sum+=Math.min(left[i],right[i])-heights[i];
		          System.out.print(sum+" ");
		      }
		      
		      return sum;
		    }
	   
	   public static void main(String[] args){
		   int[] test={0,1,0,2,1,0,1,3,2,1,2,1};
		   trapRainWater(test);
	   }
}
