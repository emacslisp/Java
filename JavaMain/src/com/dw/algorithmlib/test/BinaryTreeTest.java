package com.dw.algorithmlib.test;

import com.dw.algorithmlib.BinaryTree;
import com.dw.algorithmlib.TreeNode;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		Integer[] a = {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
		TreeNode head = tree.arrayToTree(a);
	}

}
