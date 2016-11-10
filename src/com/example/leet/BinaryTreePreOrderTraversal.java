package com.example.leet;
/**
 * Definition for binary tree
 * e.g                  1
 *                   /    \
 *                  2      3
 *                 / \    /
 *                4   5  6
 *               /
 *              7
 * @author bin zhou
 * @since 2014-03-18 
 */
import java.util.ArrayList;
import java.util.Stack;

import algorithm.datastructure.TreeNode;


public class BinaryTreePreOrderTraversal{
    public static void main(String[] args){
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
        
        System.out.println(preorderTraversal2(node1).toString());
        
    } 	
	
    /**
     * RECURSIVE : pre order travel without return
     * @param root
     * @return
     */
    //recursive
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        preorderTraversalHelper(root, result);
        
        return result;
        
    }
    
    public static void preorderTraversalHelper(TreeNode cur, ArrayList<Integer> result){
        if (cur == null) 
            return;
        
        result.add(cur.val);
        preorderTraversalHelper(cur.left, result);
        preorderTraversalHelper(cur.right, result);
    }
    
    
    /**
     * RECURSIVE : pre order travel with return
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        
        return preorderTraversalHelper(root);
    }
    
    public ArrayList<Integer> preorderTraversalHelper(TreeNode cur){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (cur == null) 
            return result;
        
        result.add(cur.val);
        result.addAll(preorderTraversalHelper(cur.left));
        result.addAll(preorderTraversalHelper(cur.right));
        
        return result;
    }

    
    
    /**
     * ITERATIVE: with stack
     * @param root
     * @return
     */
    public static ArrayList<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        
        //using stack to store intermediate nodes
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = null;
        
        stack.push(root);
        while(!stack.isEmpty()){
        	cur = stack.pop();
            result.add(cur.val);
            if (cur.right!=null)
                stack.push(cur.right);
            if (cur.left!=null)
                stack.push(cur.left);
        }
        
        return result;
    }    
}


