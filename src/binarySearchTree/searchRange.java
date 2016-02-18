package binarySearchTree;

import java.util.ArrayList;

import model.TreeNode;

/**
 * 
 * @author bin zhou 
 *         Created on Feb 17, 2016
 *
 */
public class searchRange {
	public class Solution {
	    /**
	     * @param root: The root of the binary search tree.
	     * @param k1 and k2: range k1 to k2.
	     * @return: Return all keys that k1<=key<=k2 in ascending order.
	     */
	  
	    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
	       ArrayList<Integer> res= new ArrayList<Integer>();
	       if (root==null) return res;
	       searchTree(res,root,k1,k2);
	      
	       return res;
	    }
	    
	    public void searchTree(ArrayList<Integer> res,TreeNode root, int k1,int k2){
	        if (root==null) return;
	        if (root.val>=k1&&root.val<=k2){
	            
	             searchTree(res,root.left,k1,k2);
	             res.add(root.val);
	              searchTree(res,root.right,k1,k2);
	        }
	       
	        if (root.val>k2){
	             searchTree(res,root.left,k1,k2);
	        }
	         if (root.val<k1){
	           searchTree(res,root.right,k1,k2);
	        }
	       
	    }
	}

}
