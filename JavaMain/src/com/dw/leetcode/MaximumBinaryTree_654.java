package com.dw.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MaximumBinaryTree_654 {

	private class NumIndex {
		public int index;
		public int value;
		NumIndex(int index,int value) {
			this.index = index;
			this.value = value;
		}
	}
	
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        
        int max = 0;
        int max_i = 0;
        
        NumIndex[] ni = new NumIndex[nums.length];
        
        for(int i=0;i<nums.length;i++) {
        	ni[i] = new NumIndex(i,nums[i]);
        }
        
        Comparator<NumIndex> comparator = new Comparator<NumIndex>() {
        	@Override
			public int compare(NumIndex ni1, NumIndex ni2) {
        		if(ni1.value > ni2.value)
        			return -1;
        		if(ni1.value < ni2.value)
        			return 1;
        		
        		return 0;
        	}
        };
        
        Arrays.sort(ni,comparator);
        
        int div = ni[0].index;
        TreeNode root = new TreeNode(ni[0].value);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<ni.length;i++) {
        	System.out.println(ni[i].index + " " + ni[i].value);
        	map.put(ni[i].value,ni[i].index);
        } 
        
        for(int i=1;i<ni.length;i++) {
        	foo(root,map,ni[i]);
        }
    	
    	return root;
    }
    
    public void foo(TreeNode root,HashMap<Integer,Integer> map, NumIndex ni) {
    	if(map.get(root.val) < ni.index) {
    		if(root.right == null)
    			root.right = new TreeNode(ni.value);
    		else
    			foo(root.right,map,ni);
    	}
    	else if(map.get(root.val) > ni.index) {
    		if(root.left == null)
    			root.left = new TreeNode(ni.value);
    		else
    			foo(root.left,map,ni);
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,6,0,5};
		MaximumBinaryTree_654 s = new MaximumBinaryTree_654();
		TreeNode root = s.constructMaximumBinaryTree(nums);
	}

}
