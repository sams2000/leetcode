package com.example.leet;

import java.util.ArrayList;
import algorithm.datastructure.TreeNode;
/**
 * Given a binary tree, flatten it to a linked list in-place.

    For example,
    Given
    
             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
 * @author bin zhou
 * @since 2016-02-01
 */
public class FlattenBinaryTreeToLinkedList {
	
	public static TreeNode  res = null;//must global
	public static void main(String[] args){
/*    	TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        
        node1.left = node2;
        node1.right = node3;
        flatten(node1);
        System.out.println(printTreePreorder(node1).toString());*/
        
    	TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        
        System.out.println(postOrderTraversal(node1));       
        
        TreeNode root = node1;        
        flatten(root);
        System.out.println(postOrderTraversal(root)); 
	}
	
    public static void flatten(TreeNode root) {
        
        flattenHelper(root);
        root = res;
    }

    static void  flattenHelper(TreeNode node) {
        if (node == null) return;
        
        TreeNode leftSub = node.left;
        node.left = null;
        TreeNode rightSub = node.right;
        node.right = null;
        
        if (res == null) 
            res = node;
        else {
            res.right = node;
            res = res.right;
        }
        flattenHelper(leftSub);
        flattenHelper(rightSub);
    }
    
    /**
     * print tree in PostOrder
     * @param root
     * @return
     */
    public static ArrayList<Integer> postOrderTraversal(TreeNode root){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	printTreePostorderHelper(root, result);
    	
    	return result;
    }
    
    private static void printTreePostorderHelper(TreeNode node, ArrayList<Integer> result){
    	if (node == null) return;
    	printTreePostorderHelper(node.left, result);
    	printTreePostorderHelper(node.right, result);
    	result.add(node.val);
    }
}
