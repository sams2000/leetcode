package com.example.leet;
/**
 * Given two nodes of a tree,
 * method should return the deepest common ancestor of those nodes.
 *
 *          A
 *         / \
 *        B   C
 *       / \
 *      D   E
 *         / \
 *        G   F
 *
 *  commonAncestor(D, F) = B
 *  commonAncestor(C, G) = A
 *  
 *  @author bin zhou
 *  @since 2016-01-31
 */

import java.util.HashSet;
import java.util.Set;

class BackTreeNode {
	public String val;
	public BackTreeNode parent;
	
	public BackTreeNode(String str, BackTreeNode parent) {
		super();
		this.val = str;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "BackTreeNode [str=" + val + "]";
	}
}
    	

public class DeepestCommonAncestor {
	public static void main(String[] args) {
		
		BackTreeNode A = new BackTreeNode("A", null);
    	BackTreeNode B = new BackTreeNode("B", null);
    	BackTreeNode C = new BackTreeNode("C", null);
    	BackTreeNode D = new BackTreeNode("D", null);
    	BackTreeNode E = new BackTreeNode("E", null);
    	BackTreeNode F = new BackTreeNode("F", null);
    	BackTreeNode G = new BackTreeNode("G", null);    	
		G.parent = E;
		F.parent = E;
		D.parent = B;
		E.parent = B;
		B.parent = A;
		C.parent = A;
	    
		//System.out.println("DeepestCommonAncestorHelper : " + DeepestCommonAncestorHelper(D, F));
		System.out.println("DeepestCommonAncestorNoSpace : " + DeepestCommonAncestorNoSpace(C, G, A));
	}

	/**
	 * This solution uses extra space to save node and check node existance
	 * @param a
	 * @param b
	 * @return
	 */
	public static BackTreeNode DeepestCommonAncestorHelper(BackTreeNode a, BackTreeNode b){
		if (a==null || b==null)	return null; //if one input is null
		else if (a==b)	return a; //if two input nodes are same
	        
	    Set<BackTreeNode> aSet = new HashSet<BackTreeNode>();         
	    aSet.add(a);

	    Set<BackTreeNode> bSet = new HashSet<BackTreeNode>(); 
	    bSet.add(b);
	    
	    while (a!=null || b!=null){
	        if(a!= null){
	             if (bSet.contains(a))
	                 return a; 
	             else
	                aSet.add(a);  
	        }
	            
	        if(b!=null){
	            if (aSet.contains(b))
	                return b;
	            else
		            bSet.add(b); 
	        }
	       
	        if (a!=null) a=a.parent;
	        if (b!=null) b=b.parent;
	    }
	    
	    return null;		
	}
	
	/**
	 * first, move lower/deeper node up to the same level of another node, then move two nodes together back up to 
	 * same steps and get common ancestor. This solution, just uses a temp variable, no heap space is used.
	 * @param a
	 * @param b
	 * @param root
	 * @return
	 */
	public static BackTreeNode DeepestCommonAncestorNoSpace(BackTreeNode a, BackTreeNode b, BackTreeNode root){
		if (a==null || b==null)	return null; //if one input is null
		else if (a==b)	return a; //if two input nodes are same
	    
		BackTreeNode tmp = a;
		int aLevel = 1;
		while (!tmp.parent.val.equals(root.val)){
			aLevel++;
			tmp = tmp.parent;
		}
		
		int bLevel = 1;
		tmp = b;
		while (!tmp.parent.val.equals(root.val)){
			bLevel++;
			tmp = tmp.parent;
		}
		
		if (aLevel > bLevel){
			for (int i=0; i<aLevel-bLevel; i++) 
				a=a.parent;
		} else if (aLevel < bLevel){
			for (int i=0; i<bLevel-aLevel; i++) 
				b=b.parent;
		} 	
		
		if (a.val.equals(b.val)){	
			return a;
		} else {
			while(!a.val.equals(b.val)){
				a=a.parent;
				b=b.parent;
			}
			return a;
		}
		
	}	
	
}
