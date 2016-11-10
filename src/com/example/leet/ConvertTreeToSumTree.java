package com.example.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algorithm.datastructure.TreeNode;
/**
 * Given a Binary Tree where each node has positive and negative values. 
 * Convert this to a tree where each node contains the sum of the left 
 * and right sub trees in the original tree. The values of leaf nodes 
 * are changed to 0.
 * 
 * For example, the following tree 
	                  10
	                /     \
	              -2        6
	            /   \      /  \ 
	          8     -4    7    5
	
	should be changed to
	                 20(4-2+12+6)
	               /      \
	            4(8-4)      12(7+5)
	           /   \      /  \ 
	         0      0    0    0
 * @author bin zhou
 * @since 2016-02-01
 *
 */
public class ConvertTreeToSumTree {
	public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(-4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        
        TreeNode root = node1;   
        
        ArrayList<Integer> result = levelOrder(root);
        System.out.println(result);
        
        System.out.println();
        convertSumTree(root);
        result = levelOrder(root);
       	System.out.print(result);
        
     
	}

	/**
	 * Given a Binary Tree where each node has positive and negative values. 
	 * Convert this to a tree where each node contains the sum of  
	 * the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.
	 * @param node
	 * @return
	 */
    public static int convertSumTree(TreeNode node){
        if(node == null) return 0;
        int result = node.val;
        int left = convertSumTree(node.left);
        int right = convertSumTree(node.right);
        node.val=left+right;
        
        return result+left+right;
    }	
    
    /**
     * BFS: return all levels together in one print
     * @param root
     * @return
     */
	public static ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) 
        	return result;

        //using Queue to store tree nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode curNode = null;
 
        while (!queue.isEmpty()) {
            curNode = queue.poll();
             
            // print out current node value
            //System.out.println(curNode.val + " ");
            result.add(curNode.val);
 
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }
        
        return result;        
    }    
}
