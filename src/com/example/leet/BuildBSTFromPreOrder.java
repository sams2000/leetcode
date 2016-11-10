package com.example.leet;

import java.io.IOException;
import java.util.ArrayList;

import algorithm.datastructure.TreeNode;

/**
 * Given preorder traversal array of a BST, reconstruct the BST. 
 * @author bin zhou
 * @since 2016-02-01
 */
public class BuildBSTFromPreOrder {
    static int index=0;
    
    public static void main(String[] ars) throws IOException {
        int input[] ={5,3,1,4,7,6,8};
        TreeNode root = preOrderBuild(input);
        
        System.out.println(printTreePreorder(root));
    }

	//can be used for BST de-serialization
    public static TreeNode preOrderBuild(int[] input){
        TreeNode root = preOrderBuild(input,  Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }

    private static TreeNode preOrderBuild(int[] input, int min, int max){
        if(index>=input.length) return null;
        if(input[index]>max || input[index]<min) return null;
        TreeNode node = new TreeNode(input[index++]);
        node.left=preOrderBuild(input, min, node.val);
        node.right= preOrderBuild(input, node.val, max);
        return node;
    }

    /**
     * recursive to print preorder
     * @param root
     * @return
     */
    public static ArrayList<Integer> printTreePreorder(TreeNode root){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	printTreePreorderHelper(root, result);
    	
    	return result;
    }
    private static void printTreePreorderHelper(TreeNode node, ArrayList<Integer> result){
    	if (node == null) return;
    	result.add(node.val);
    	printTreePreorderHelper(node.left, result);
    	printTreePreorderHelper(node.right, result);
    }    
}




