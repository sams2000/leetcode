package com.example.leet.todo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algorithm.datastructure.TreeNode;

public class UniqueBinaryTreeII {

	public static void main(String[] args) {
		int n = 3;
		ArrayList<TreeNode> result = generateTreesHelper(1, n);
		
		System.out.println("size of " + result.size());
		
		for (TreeNode node : result){
				System.out.println(levelOrder(node).toString());
		}
	}

    public static ArrayList<TreeNode> generateTreesHelper(int start, int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        
        if (start > end)
            result.add(null);
        else if (start==end)
            result.add(new TreeNode(start));
        else if (start < end){
            for (int i=start; i<=end; i++){
                ArrayList<TreeNode> leftTree = generateTreesHelper(start, i-1);
                ArrayList<TreeNode> rightTree = generateTreesHelper(i+1, end);
                for (int j=0; j<leftTree.size(); j++){
                    for (int k=0; k<rightTree.size(); k++){
                        TreeNode node = new TreeNode(i);
                        result.add(node);
                        node.left = leftTree.get(j);
                        node.right = rightTree.get(k);
                    }
                }
            }
        }
        return result;
    }	
    
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


