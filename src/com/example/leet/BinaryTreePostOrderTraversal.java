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


public class BinaryTreePostOrderTraversal{
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

        System.out.println("post order traversal 1");
        System.out.println(postorderTraversal1(node1));

        System.out.println("post order traversal 2");
        System.out.println(postorderTraversal2(node1));

        System.out.println("post order traversal 3");
        System.out.println(postorderTraversal3(node1));

        System.out.println("post order traversal 4");
        System.out.println(postorderTraversal4(node1));        
    } 	
    
	/**
	 * RECURSIVE without return: post order travel without return
	 * @param root
	 * @return
	 */
	//recursive
	public static ArrayList<Integer> postorderTraversal1(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    postorderTraversalHelper1(root, result);
	    
	    return result;
	}
	
	public static void postorderTraversalHelper1(TreeNode cur, ArrayList<Integer> result){
	    if (cur == null) 
	        return;
	    
	    postorderTraversalHelper1(cur.left, result);
	    postorderTraversalHelper1(cur.right, result);
	    result.add(cur.val);
	}
    
    
	/**
	 * RECURSIVE with return: post order travel with return
	 * @param root
	 * @return
	 */
	public static ArrayList<Integer> postorderTraversal2(TreeNode root) {
	    
	    return postorderTraversalHelper2(root);
	}
	
	public static ArrayList<Integer> postorderTraversalHelper2(TreeNode cur){
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    if (cur == null) 
	        return result;
	    
	    result.addAll(postorderTraversalHelper2(cur.left));
	    result.addAll(postorderTraversalHelper2(cur.right));
	    result.add(cur.val);
	    
	    System.out.println(result);
	    
	    return result;
	}    
	
	/**
	 * ITERATIVE: post order travel with stack
	 * @param root
	 * @return
	 */
    public static ArrayList<Integer> postorderTraversal3(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<Integer>();
 
        if(root == null) return result; 
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode pre = null, cur = null;
 
        while(!stack.empty()){
            cur = stack.peek();
 
            //go down the tree.check if current node is leaf, if so, 
            //process it and pop stack, otherwise, keep going down
            //pre == null is the situation for the root node
            if(pre == null || pre.left == cur || pre.right == cur){
                if(cur.left != null){
                    stack.push(cur.left);
                }else if(cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();//reach leaf
                    result.add(cur.val);
                }
 
            //go up the tree from left node    
	        //need to check if there is a right child
	        //if yes, push it to stack
	        //otherwise, process parent and pop stack
            }else if(cur.left == pre){
                if(cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();
                    result.add(cur.val);
                }
 
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            }else if(cur.right == pre){
                stack.pop();
                result.add(cur.val);
            }
 
            pre = cur;
        }
 
        return result;

    }
    
    /**
     * post order is similar to preorder but using 2 stacks and push left first
     * @param node
     * @return
     */
    private static ArrayList<Integer> postorderTraversal4(TreeNode node){
    	ArrayList<Integer> result = new  ArrayList<Integer>();
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        left.push(node);
        while(left.size()>0){
        	TreeNode current = left.pop();
            right.push(current);
            if(current.left!=null)
                left.push(current.left);
            if(current.right!=null)
                left.push(current.right);
        }
        while(right.size()>0)
            //System.out.print(out.pop().val+ " ");
        	result.add(right.pop().val);
        
        return result;
        	
    }
    
}


