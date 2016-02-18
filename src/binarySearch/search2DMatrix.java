package binarySearch;


public class search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length;
	           if (m==0) return false;
	           int n=matrix[0].length;
	           if (n==0) return false;
	           int last= m*n -1;
	           int start=0;
	           while(start<=last){
	               int mid = (start+last)/2;
		    int row=mid/n;
	               int col=mid%n;
	               if (matrix[row][col]==target) return true;
	              if (matrix[row][col]> target) {
	 		last=mid-1;
	              }
	              if (matrix[row][col]< target) {
	 		start=mid+1;
	              }
	           }
	return false;
	}
}
