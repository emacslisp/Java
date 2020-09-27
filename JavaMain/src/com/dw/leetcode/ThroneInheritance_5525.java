package com.dw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Tree {
	String parent;
	List<Tree> children;
	boolean isAlive;
	public Tree(String parent) {
		this.parent = parent;
		children = new ArrayList<Tree>();
		isAlive = true;
	}
	
	public List<String> inOrder() {
		List<String> result = new ArrayList<String>();
		if (isAlive) {
			result.add(parent);
		}
		
		for(Tree child: children) {
			List<String> t = child.inOrder();
			if(t != null) {
				for(String a: t) {
					result.add(a);
				}
			}
		}
		return result;
	}
}

public class ThroneInheritance_5525 {
	
	Tree root;
	HashMap<String, Tree> map = new HashMap<String, Tree>();
	
	public ThroneInheritance_5525(String kingName) {
		root = new Tree(kingName);
		map.put(kingName, root);
    }
    
    public void birth(String parentName, String childName) {
        Tree node = map.get(parentName);
        Tree t = new Tree(childName);
        node.children.add(t);
        map.put(childName, t);
    }
    
    public void death(String name) {
    	Tree node = map.get(name);
    	node.isAlive = false;
    }
    
    public List<String> getInheritanceOrder() {
    	List<String> result = root.inOrder();
    	
    	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThroneInheritance_5525 t= new ThroneInheritance_5525("king"); 
		t.birth("king", "andy");
		t.birth("king", "bob");
		t.birth("king", "catherine");
		t.birth("andy", "matthew");
		t.birth("bob", "alex");
		t.birth("bob", "asha");
		List<String> result = t.getInheritanceOrder();
		for(String x: result) {
			System.out.println(x + "\t");
		}
		System.out.println();
		
		t.death("bob");
		result = t.getInheritanceOrder();
		for(String x: result) {
			System.out.println(x + "\t");
		}
		System.out.println();
	}

}
