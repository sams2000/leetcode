package com.example.leet;
/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 * @author bin zhou
 * @since 2014-08-06
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algorithm.datastructure.TreeNode;

public class BuildTreeFromPreAndInOrder {

	public static void main(String[] args) {
    	int[] preorder ={1, 2, 3};
    	int[] inorder ={2, 1, 3};
    	
    	TreeNode root= buildTree(preorder, inorder);
    	
    	System.out.println(inOrderTravel(root));
	}
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length-1);        
    }
    
    public static TreeNode helper(int[] preorder, int i, int[] inorder, int inorderStart, int inorderEnd){
    	if (inorderStart>inorderEnd || inorderEnd<0 || i>preorder.length-1) 
    		return null;
    	
    	TreeNode node = new TreeNode(preorder[i]);
    	int index = find(preorder[i], inorder, inorderStart, inorderEnd);
    	node.left = helper(preorder, i+1, inorder, inorderStart, index-1);
    	node.right = helper(preorder, i+1 + index-inorderStart, inorder, index+1, inorderEnd);
    	
    	return node;
    }
    
    public static int find(int val, int[] array, int start, int end){
    	int result=-1;
    	for(int i=start; i<=end; i++){
    		if (array[i] == val){
    			result = i;
    			break;
    		}
    	}
    	
    	return result;
    }
    
    public static ArrayList<Integer> inOrderTravel(TreeNode node){
        
        ArrayList<Integer> result = new ArrayList<Integer>();
                
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            result.add(curNode.val);
            
            if (curNode.left != null) 
                queue.add(curNode.left);
            
            if (curNode.right!= null) 
                queue.add(curNode.right);
        }
        
        return result;
    }
}
