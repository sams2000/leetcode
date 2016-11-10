package com.example.leet;
/**
 * Definition for binary tree
 * @author bin zhou
 * @since 2014-03-18 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algorithm.datastructure.TreeNode;

public class BinaryTreeLevelOrderTraversal{
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
        
        System.out.println(levelOrder(node1));
        
        
        System.out.println(eachLevelOrder(node1));
    }   
	
    /**
     * BFS: return all levels together in one print
     * @param root
     * @return
     */
	public static ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        //using Queue to store tree nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) 
        	return result;

        queue.add(root);
        TreeNode curNode = null;
 
        while (!queue.isEmpty()) {
            curNode = queue.poll();
             
            result.add(curNode.val);
 
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }
        
        return result;        
    }
	
	/**
	 * BFS: level by level print
	 * @param root
	 * @return
	 */
    public static ArrayList<ArrayList<Integer>> eachLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //using Queue to store tree nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if (root == null) 
            return result;
        
        queue.add(root);
        TreeNode curNode = null;
        
        ArrayList<Integer> curLevelNodes = new ArrayList<Integer>();
        int nodeCountCurrentLevel = 1;
        int nodesNextLevel = 0;
        
        while(!queue.isEmpty()) {
            curNode = queue.poll();
            nodeCountCurrentLevel --;
            
            curLevelNodes.add(curNode.val);
            
            if (curNode.left != null) {
                queue.add(curNode.left);
                nodesNextLevel++;
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
                nodesNextLevel++;
            }
            //reset next level
            if (nodeCountCurrentLevel == 0){
                nodeCountCurrentLevel = nodesNextLevel;
                nodesNextLevel = 0;
                //remember to use clone to avoid clear() function in next statement
                result.add((ArrayList<Integer>)curLevelNodes.clone());
                curLevelNodes.clear();
            }
        }
        return result;
    }
}
