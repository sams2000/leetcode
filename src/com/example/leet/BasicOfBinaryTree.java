package com.example.leet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree
 * e.g                  1
 *                   /    \
 *                  2      3
 *                 / \    /
 *                4   5  6
 *               /
 *              7
 *              
 * @author bz250056
 * @since 2014-04-01
 */
import algorithm.datastructure.TreeNode;

public class BasicOfBinaryTree {

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
        
        TreeNode root = node1;
        
        //test size()
        System.out.println("tree size is " + size(root));
        
        //test minDepth() 
        System.out.println("tree min depth is " + minDepth(root));        
                
        //test maxDepth() 
        System.out.println("tree max depth is " + maxDepth(root));
        
        //test minValue()
        System.out.println("tree min value via Up-Down is : " + minValueUpDown(root));
        System.out.println("tree min value via Down-up is : " + minValueDownUp(root));
        
        //test maxValue()
        System.out.println("tree max value via Up->Down is : " + maxValueUpDown(root));        
        System.out.println("tree max value via Down->Up is : " + maxValueDownUp(root));        
        
        
        //test nodeAtKdistancePrint 
        System.out.print("Print node at level of 2+1=3 via nodeAtKdistancePrint : ");
        nodeAtKdistancePrint(root, 2);
        System.out.println();
        //test nodeAtKdistanceList
        System.out.print("Print node at level of 2+1=3 via nodeAtKdistanceList : ");
        ArrayList<Integer> nodeAtKdistanceListResult = new ArrayList<Integer>();
        nodeAtKdistanceList(root, 2, nodeAtKdistanceListResult);
        for (Integer val : nodeAtKdistanceListResult)
        	System.out.print(val + " ");
        System.out.println();
        
        //print duplicates in tree
        System.out.print("Print duplicates in tree : ");
        DuplicatesInBST(root);
        System.out.println();
        
        //test printTree() pre order
        System.out.println("Pre order print tree is: " + printTreePreorder(root).toString());        
        
        //test printTree() in order
        System.out.println("In order print tree is: " + printTreeInorder(root).toString());
        
        //test printTree() post order
        System.out.println("post order print tree is: " + printTreePostorder(root).toString());     
        
        //test traversalByLevel
        System.out.print("Travelsal by level : ");
        traversalByLevel(root);
        System.out.println();
        
        //test traversalWithLevelSeparator
        System.out.print("Travelsal by level with separator : ");
        traversalWithLevelSeparator(root);
        System.out.println();
        
        //test traversalWithLevelByTwoQueue
        System.out.print("Travelsal by level with two queues : ");
        traversalWithLevelByTwoQueue(root);
        System.out.println();        
        
        //test hasPathSum()
        System.out.println("Has path sum to 7: " + hasPathSum(root, 7));   
        
        //test printHasPathSum()
        System.out.print("print path sum detail to 7 : ");
        ArrayList<ArrayList<Integer>> result = printHasPathSum(root, 7);
        if (result.size()>0){
            for (ArrayList<Integer> path : result)
            	System.out.print(path.toString() + "; ");          	
        } else {
        	System.out.print("NOT EXIST! \r\n");
        }
        
        System.out.print("print path sum detail to 8 : ");
        result = printHasPathSum(root, 8);
        if (result.size()>0){
            for (ArrayList<Integer> path : result)
            	System.out.print(path.toString() + "; ");          	
        } else {
        	System.out.print("NOT EXIST! \r");
        }        
        System.out.println();
        
        //test printPaths()
        System.out.println("print paths via int[] array: ");
        printPaths(root, 0);
      
        //test printPaths1()
        System.out.println("print paths in ArrayList<Integer>: ");
        result = printPathsInArrayList(root);
        for (ArrayList<Integer> path : result)
        	System.out.println(path.toString());
        
        //test printPaths2()
        System.out.println("print ONLY the first path in ArrayList<Integer>: ");
        result = printOnePaths(root);
        for (ArrayList<Integer> path : result)
        	System.out.println(path.toString());        
        
        //test longestPath
        longestPath(root);
        System.out.println("The longest (node) path is :"+  maxPath);
        
        //test isBST1
        System.out.println("Is this a binary search tree via isBST1 ? " + isBST1(root));
        
        //test isBST2
        System.out.println("Is this a binary search tree via isBST2 ? " + isBST2(root));      
        
        //test isSymmetric
        System.out.println("Is this a symmetric binary search tree ? " + isSymmetric(root));
        
        //test sameTree
        System.out.println("Are these same binary trees ? " + sameTree(root, root));
        
        //test mirror()
/*        System.out.println("preorder print tree before mirror is: " + printTreePreorder(root));
		mirror(root);
        System.out.println("preorder print tree after mirror is: " + printTreePreorder(root));*/
        
        //test doubleTree()
        System.out.println("preorder print tree before double is: " + printTreePreorder(root));
        doubleTree(root);
        System.out.println("preorder print tree after double is: " + printTreePreorder(root));          
    } 
    
    ////////////////////////////////////////////////////////////// Solutions
   
    /////////////////////////size() Solution 
    public static int size(TreeNode node){
    	if (node == null) return 0;
    	
    	return 1 + size(node.left) + size(node.right);
    }
    
    
    /////////////////////////minDepth() Solution
    public static int minDepth(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        if (node.left == null)
            return 1+minDepth(node.right);
        else if (node.right == null)
            return 1+minDepth(node.left);
        else
            return Math.min(1+minDepth(node.left), 1+minDepth(node.right));
    }

    /////////////////////////maxDepth() Solution
    public static int maxDepth(TreeNode node){
    	if (node == null) return 0;
    	
    	return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
    
    /////////////////////////minValue() Solution : up -> down
    public static int minValueUpDown(TreeNode root){
    	int min = Integer.MAX_VALUE;
    	return minValueUpDownHelper(root, min);
    }
    private static int minValueUpDownHelper(TreeNode node, int min){
    	if (node == null) return min;

    	min = Math.min(node.val, min);
    	
    	return Math.min(minValueUpDownHelper(node.left, min), minValueUpDownHelper(node.right, min));
    }
    
    /////////////////////////minValue() Solution : down -> up
    public static int minValueDownUp(TreeNode root){
    	int min = Integer.MAX_VALUE;
    	return minValueDownUpHelper(root, min);
    }
    
    private static int minValueDownUpHelper(TreeNode node, int min){
    	if (node == null) return min;
    	
    	int leftMin = minValueDownUpHelper(node.left, min);
    	int rightMin = minValueDownUpHelper(node.right, min);
    	
    	return Math.min(Math.min(leftMin, rightMin), node.val);
    }
    
    
    /////////////////////////maxValue() Solution : up -> down
    public static int maxValueUpDown(TreeNode root){
    	int max = Integer.MIN_VALUE;
    	return maxValueHelper(root, max);
    }
    private static int maxValueHelper(TreeNode node, int max){
    	if (node == null) return max;
    	
    	max = Math.max(node.val, max);
    	
    	return Math.max(maxValueHelper(node.left, max), maxValueHelper(node.right, max));
    }    
    
    /////////////////////////maxValue() Solution : down -> up
    public static int maxValueDownUp(TreeNode root){
    	int max = Integer.MIN_VALUE;
    	return maxValueDownUpHelper(root, max);
    }
    
    public static int maxValueDownUpHelper(TreeNode node, int max){
    	if (node == null) return max;
    	
    	int leftMax = maxValueDownUpHelper(node.left, max);
    	int rightMax = maxValueDownUpHelper(node.right, max);
    	
    	return Math.max(Math.max(leftMax, rightMax), node.val);
    	
    }
    
    
    /////////////////////////print node at k distance(levels)
    public static void nodeAtKdistancePrint(TreeNode node, int k){
        if(node==null) return;
        if(k==0)
            System.out.print(node.val +" ");
        nodeAtKdistancePrint(node.left, k-1);
        nodeAtKdistancePrint(node.right, k-1);
    }
    
    public static void nodeAtKdistanceList(TreeNode node, int k, ArrayList<Integer> result){
        if(node==null) return;
        if(k==0)
            result.add(node.val);
        nodeAtKdistanceList(node.left, k-1, result);
        nodeAtKdistanceList(node.right, k-1, result);
    }    
    
    /////////////////////////print out duplicates in BST
    static int prevVal, countDup=0;
    public static void DuplicatesInBST(TreeNode node){
        countDupInBST(node);
        System.out.print(prevVal + "/" + countDup + " time(s); ");
    }
    public static void countDupInBST(TreeNode node){
        if(node==null) return;
        countDupInBST(node.left);
        if(countDup==0){ 
        	countDup=1;
        } else if(prevVal!=node.val&& countDup!=0){
            System.out.print(prevVal + "/" + countDup + " time(s); ");
            countDup = 1;
        } else if(prevVal==node.val){
        	countDup++;
        }
        prevVal=node.val;
        countDupInBST(node.right);
    }    
    
    /////////////////////////printTree() "preorder" solution
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
    
    
    /////////////////////////printTree() "inorder" Solution
    public static ArrayList<Integer> printTreeInorder(TreeNode root){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	printTreeInorderHelper(root, result);
    	return result;
    }
    private static void printTreeInorderHelper(TreeNode node, ArrayList<Integer> result){
    	if (node == null) return;
    	
    	printTreeInorderHelper(node.left, result);
    	result.add(node.val);
    	printTreeInorderHelper(node.right, result);
    }
    
    /////////////////////////print Postorder() Solution
    public static ArrayList<Integer> printTreePostorder(TreeNode root){
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
    
    /////////////////////////BFS to print all nodes, level by level
    private static void traversalByLevel(TreeNode root) {
        //using Queue to store tree nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //using queue
        if (root != null) 
        	queue.offer(root); //store
 
        TreeNode curNode = null;
 
        while (!queue.isEmpty()) {
            curNode = queue.poll(); //fetch
             
            System.out.print(curNode.val + " ");  // print out current node value
 
            if (curNode.left != null)
                queue.offer(curNode.left);
            if (curNode.right != null)
                queue.offer(curNode.right);
        }
    }    
    
    /////////////////////////BFS to print all nodes with separator between each level 1, 2, 3, 4, etc
    private static void traversalWithLevelSeparator(TreeNode root) {
    	int level = 1;
        
    	//using Queue to store tree nodes
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode separatorNode = new TreeNode(0);
        if (root != null) {
        	queue.offer(root);
        	queue.offer(separatorNode);
        }
        	
        TreeNode curNode = null;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
             
            if (curNode.val == 0 ){
            	if (!queue.isEmpty()){
            		queue.offer(separatorNode);
            	}
            	System.out.println("Current Level " + level++);
            	continue;
            }
            
            // print out current node value
            System.out.println(curNode.val + " ");
 
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }
    }   
    
    //BFS to print all nodes with each level 1, 2, 3, 4, etc by two Queue's 
    private static void traversalWithLevelByTwoQueue(TreeNode root) {
    	int level = 1;
        
    	//using Queue to store tree nodes
    	Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
    	Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
    	Queue<TreeNode> temp = new LinkedList<TreeNode>();
        
    	if (root != null) 
        	queue1.offer(root);
        	
        TreeNode curNode = null;
        
        //pop all elements in queue1 and store all children to queue2
        while (!queue1.isEmpty()) {
            curNode = queue1.poll();

            while (curNode != null) {
                // print out current node value
                System.out.println(curNode.val + " ");
                
            	if (curNode.left != null)
                    queue2.add(curNode.left);
                if (curNode.right != null)
                    queue2.add(curNode.right);    
                
                curNode = queue1.poll();
            }
            
            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
            
            System.out.println("Current Level " + level++);
        }   
    }     
    
    /////////////////////////////////////////
    //hasPathSum() Solution
    public static boolean hasPathSum(TreeNode node, int sum) { 
    	if (node == null) return sum==0;
    	
    	sum = sum - node.val;
    	
    	return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
    } 
    
    /////////////////////////////////////////
    //printHasPathSum() solution
    public static ArrayList<ArrayList<Integer>>  printHasPathSum(TreeNode root, int sum){
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	printHasPathSumHelper(root, sum, new ArrayList<Integer>(), result);
    	return result;
    }

    public static void printHasPathSumHelper(TreeNode node, int sum, ArrayList<Integer> curPath, ArrayList<ArrayList<Integer>> result){
    	if (node == null) return;
    	
    	curPath.add(node.val);
    	
    	if (node.left == null && node.right == null){
    		if (node.val == sum){ 
    			//curPath.add(node.val);
    			result.add(curPath);
    		}
    		return;
    	}
    	
    	sum = sum - node.val;
    	//curPath.add(node.val);
    	//using clone
    	/*printHasPathSumHelper(node.left, sum, (ArrayList<Integer>)curPath.clone(), result);
    	printHasPathSumHelper(node.right, sum, (ArrayList<Integer>)curPath.clone(), result);*/
    	
    	//Or create new list
    	printHasPathSumHelper(node.left, sum, new ArrayList<Integer>(curPath), result);
    	printHasPathSumHelper(node.right, sum, new ArrayList<Integer>(curPath), result);
    }    

    /////////////////////////////////////////
    //printPaths() Solution Given a binary tree, prints out all of its root-to-leaf paths, one per line. Uses a recursive helper to do the work.
    public static int[] printPaths(TreeNode root, int pathLen){
    	int[] path = new int[10]; 
    	printPathsHelper(root, pathLen, path);
    	return path;
    }
    
    private static void printPathsHelper(TreeNode node, int pathLen, int[] path){
    	if (node == null) return;
    	
    	path[pathLen] = node.val;
    	pathLen++;
    	
    	if (node.left == null && node.right == null){
    		printArray(path, pathLen); 
    	} else {
    		printPathsHelper(node.left, pathLen, path);
    		printPathsHelper(node.right, pathLen, path);
    	}
    	
    }
     
    private static void printArray(int[] path, int len) { //Utility that prints ints from an array on one line.
    	for (int i=0; i<len; i++) { 
    		System.out.print(path[i] + " "); 
    	} 
    	System.out.println(); 
    } 
    
    /////////////////////////////////////////
    //printPaths() ArrayList Solution Given a binary tree, prints out all of its root-to-leaf paths, one per line. Uses a recursive helper to do the work.
    public static ArrayList<ArrayList<Integer>> printPathsInArrayList(TreeNode root){
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	printPathsHelper1(root, new ArrayList<Integer>(), result);
    	return result;
    }
    
    private static void printPathsHelper1(TreeNode node, ArrayList<Integer> curPath, ArrayList<ArrayList<Integer>> result){
    	if (node == null) return;
    	
    	curPath.add(node.val);
    	
    	if (node.left == null && node.right == null){
    		result.add(curPath);
    	} 
    		
    	printPathsHelper1(node.left, (ArrayList<Integer>)curPath.clone(), result);
    	printPathsHelper1(node.right, (ArrayList<Integer>)curPath.clone(), result);
    	
    }   

    /////////////////////////////////////////
    //printPaths() ArrayList Solution Given a binary tree, prints out ONLY the first root-to-leaf path
    public static ArrayList<ArrayList<Integer>> printOnePaths(TreeNode root){
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	printPathsHelper2(root, new ArrayList<Integer>(), result);
    	return result;
    }
    
    private static void printPathsHelper2(TreeNode node, ArrayList<Integer> curPath, ArrayList<ArrayList<Integer>> result){
    	if (node == null) return;
    	
    	curPath.add(node.val);
    	
    	if (node.left == null && node.right == null){
    		result.add(curPath);
    		return;
    	} 
    		
    	printPathsHelper2(node.left, (ArrayList<Integer>)curPath.clone(), result);
    	if (result.size()==0){
    		printPathsHelper2(node.right, (ArrayList<Integer>)curPath.clone(), result);
    	}
    }      
    
    /////////////////////////longest path
	/*    o
	    /  \
	  o      o
	          \
	           o
	
	  return 4*/
    static int maxPath=0;
    private static int longestPath(TreeNode node){
        if(node==null) return 0;
        int left = longestPath(node.left);
        int right = longestPath(node.right);
        maxPath = Math.max(1+left+right, maxPath);
        return Math.max(left, right)+1;
    }   
    
    /////////////////////////isBST1() Solution : Recursive helper -- checks if a tree is a BST using minValue() and maxValue() (not efficient).
	public static boolean isBST1(TreeNode node) {
		if (node == null) return (true);

		// do the subtrees contain values that do not agree with the node?
		if (node.left != null && maxValueUpDown(node.left) > node.val)
			return (false);
		if (node.right != null && minValueUpDown(node.right) <= node.val)
			return (false);

		// check that the subtrees themselves are ok
		return (isBST1(node.left) && isBST1(node.right));
	}    
    
    
    /////////////////////////isBST2() Solution : Uses the efficient recursive helper by passing down min and max
	public static boolean isBST2(TreeNode root) {
		return isBST2Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * Efficient BST helper -- Given a node, and min and max values, recurs down
	 * the tree to verify that it is a BST, and that all its nodes are within
	 * the min..max range. Works in O(n) time -- visits each node only once.
	 */
	private static boolean isBST2Helper(TreeNode node, int min, int max) {
		if (node == null) return true;
		if (min > node.val || node.val >= max) return false; 
		
		return isBST2Helper(node.left, min, node.val) && isBST2Helper(node.right, node.val + 1, max);
	}    
    
	/////////////////////////isSymmetric tree Solution: check whether tree is symmetric
    public static boolean isSymmetric(TreeNode node) { 
    	if (node == null){ 
    		return true;
    	} 
    	
    	return isSymmetricHelper(node.left, node.right);
    }      
    
	public static boolean isSymmetricHelper(TreeNode left, TreeNode right){
		if (left == null && right == null) return true;
		else if (left == null || right == null) return false;
		else if (left.val!=right.val) return false;
		else return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	}    
	
	/////////////////////////sameTree() Solution
    public static boolean sameTree(TreeNode a, TreeNode b) {
    	if (a == null && b == null) return true;
    	else if (a == null || b == null) return false;
    	
    	if (a.val == b.val)
    		return sameTree(a.left, b.left) && sameTree(a.right, b.right);
    	else
    		return false;
    
    }	
	
    
	/////////////////////////countTrees() Solution
    /** 
    For the key values 1...numKeys, how many structurally unique binary search trees are possible that store those keys?
    Strategy: consider that each value could be the root. Recursively find the size of the left and right subtrees. 
   */ 
	public static int countTrees(int numKeys) {
		if (numKeys <= 1) {
			return 1;
		} else {
			// there will be one value at the root, with whatever remains on the
			// left and right each forming their own subtrees.
			// Iterate through all the values that could be the root...
			int sum = 0;
			int left, right, root;

			for (root = 1; root <= numKeys; root++) {
				left = countTrees(root - 1);
				right = countTrees(numKeys - root);

				// number of possible trees with this root == left*right
				sum += left * right;
			}

			return (sum);
		}
	}      
    
    
    
    //mirror() Solution
    public static TreeNode mirror(TreeNode node) { 
    	if (node != null){
			// swap the left/right pointers 
			TreeNode temp = node.left; 
			node.left = node.right; 
			node.right = temp;
			
	    	// do the sub-trees 
			mirror(node.left); 
			mirror(node.right);
    		
/*    	    // OR do the sub-trees 
    	    mirror(node.left); 
    	    mirror(node.right);

    	    // swap the left/right pointers 
    	    TreeNode temp = node.left; 
    	    node.left = node.right; 
    	    node.right = temp;    */ 		
    	}
    	return node;
    } 
    
    
    /*doubleTree() Solution : Changes the tree by inserting a duplicate node on each nodes's .left
	    So the tree... 
	    2 
	   / \ 
	  1   3
	
	 Is changed to... 
	       2 
	      / \ 
	     2   3 
	    /   / 
	   1   3 
	  / 
	 1    
	 
	 */
    
    public static void doubleTree(TreeNode node) { 
    	if (node == null) return;

/*    	// (1) do the subtrees first
		doubleTree(node.left);//make sure to understand the recursive call sequence
		doubleTree(node.right);	//make sure to understand the recursive call sequence
	
		// duplicate this node to its left
		TreeNode oldLeft = node.left;
		node.left = new TreeNode(node.val);
		node.left.left = oldLeft;	*/
		
		// OR (2) do the subtrees last
		// duplicate this node to its left
		TreeNode oldLeft = node.left;
		node.left = new TreeNode(node.val);
		node.left.left = oldLeft;	
		
		// do the subtrees first
		doubleTree(node.left.left);//make sure to understand the recursive call sequence
		doubleTree(node.right);	//make sure to understand the recursive call sequence		
    }     
}
