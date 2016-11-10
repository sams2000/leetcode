package com.example.leet.todo;

import com.example.leet.BinaryTreeInOrderTraversal;

import algorithm.datastructure.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * ??? revisit
 * @author bzhou3
 * @since 2016-02-03
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        /*
         * TreeNode node3 = new TreeNode(3); TreeNode node4 = new TreeNode(4);
         * TreeNode node5 = new TreeNode(5); TreeNode node6 = new TreeNode(6);
         * TreeNode node7 = new TreeNode(7);
         */
        node1.left = node2;

        /*
         * node1.right = node3; node2.left = node4; node2.right = node5;
         * node3.left = node6; node4.left = node7;
         */

        System.out.println("before"
                + BinaryTreeInOrderTraversal.inorderTraversalRecursive1(node1));

        recoverTree(node1);

        System.out.println("after"
                + BinaryTreeInOrderTraversal.inorderTraversalRecursive1(node1));
    }

    //////////////////////////////////////////////// recursive accepted solution
    //////////////////////////////////////////////// in O(n) space
    static TreeNode node1 = null;
    static TreeNode node2 = null;
    static TreeNode prev = null;

    /**
     * We can use in-order traverse to find the swapped element. During the
     * traverse, we can find the element that is smaller than the previous node.
     * Using this method we can find the swapped node. Save it and swap them.
     * Done.
     * 
     * @param root
     */
    public static void recoverTreeRecursive(TreeNode root) {
        inorderTraverse(root);
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    private static void inorderTraverse(TreeNode root) {
        if (root == null)
            return;
        inorderTraverse(root.left);
        if (prev != null) {
            if (root.val <= prev.val) {
                if (node1 == null)
                    node1 = prev;
                node2 = root;
            }
        }
        prev = root;
        inorderTraverse(root.right);
    }

    /**
     * After searching, I found there is a way to use O(1)O(1) space to do the
     * in-order traverse, which is called Morris traverse.
     * 
     * The Morris traverse is like the following.
     * 
     * Firstly, take the root node as current node.
     * 
     * Then there are two possibilities.
     * 
     * If current node doesn’t have left child, output the value. And current =
     * current.right. If current node has left child, try to find the precursor
     * node of current node, which is the right-most node of the left child of
     * current. If the right child of it is null (If we don’t modify the tree,
     * it should be null), set current as its right child, and current =
     * current.left. Otherwise (It means that we have modify the tree and we
     * have traverse all nodes in the left subtree of current node), set it to
     * null, output current. And current = current.right. During the traverse,
     * we can find the nodes which are needed to be swapped.
     * 
     * @param root
     */
    public static void recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
        while (current != null) {
            if (current.left == null) {
                if (prev != null) {
                    if (prev.val >= current.val) {
                        if (node1 == null)
                            node1 = prev;
                        node2 = current;
                    }
                }
                prev = current;
                current = current.right;
            } else {
                TreeNode t = current.left;
                while (t.right != null && t.right != current)
                    t = t.right;
                if (t.right == null) {
                    t.right = current;
                    current = current.left;
                } else {
                    t.right = null;
                    if (prev != null) {
                        if (prev.val >= current.val) {
                            if (node1 == null)
                                node1 = prev;
                            node2 = current;
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;

    }

}
