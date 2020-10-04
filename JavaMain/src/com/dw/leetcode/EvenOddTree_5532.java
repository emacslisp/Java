package com.dw.leetcode;

import java.util.*;

import com.dw.algorithmlib.TreeNode;

public class EvenOddTree_5532 {
	HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	public int treeHigh(TreeNode node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = treeHigh(node.left); 
            int rDepth = treeHigh(node.right); 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    }
	
	public void inDepth(TreeNode node, int level) {
		if(node == null)
			return;
		else {
			
			if(map.get(level) == null) {
				map.put(level, new ArrayList<Integer>());
			}
			
			List<Integer> x = map.get(level);
			x.add(node.val);
			inDepth(node.left, level +1);
			inDepth(node.right, level + 1);
		}
	}
	
	public boolean isEvenOddTree(TreeNode root) {
        int maxHeight = this.treeHigh(root);
        inDepth(root, 0);
        if(root.val % 2== 0) return false;
        
        for(int i=1;i<maxHeight;i++) {
        	List<Integer> x = map.get(i);
        	if(x== null)
        		return false;
        	
        	if(i%2 == 0) {
        		if(x.size() == 1) {
        			if(!(x.get(0)%2 == 1)) {
        				return false;
        			}
        		}
        		for(int j=0;j<x.size()-1;j++) {
        			int m = x.get(j);
        			int n = x.get(j+1);
        			if(!(m%2 == 1  && n%2 ==1 && n>m)) {
        				return false;
        			}
        		}
        	} else {
        		if(x.size() == 1) {
        			if(!(x.get(0)%2 == 0)) {
        				return false;
        			}
        		}
        		for(int j=0;j<x.size()-1;j++) {
        			int m = x.get(j);
        			int n = x.get(j+1);
        			if(!(m%2 == 0 && n%2 == 0 && m>n)) {
        				return false;
        			}
        		}
        	}
        }
        
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
