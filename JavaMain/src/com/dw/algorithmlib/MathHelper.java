package com.dw.algorithmlib;

public class MathHelper {
	
    public boolean isSquare(int n) {
    	int t = (int)Math.sqrt(n);
    	
    	return t*t == n;
    }
    
    public static int charToInt(char c) {
    	return c - '0';
    }
    
    // @todo: add two large number using String
    // num1 = 12345678
    // num2 = 34567890
    public String add(String num1, String num2) {
    	int first = charToInt(num1.charAt(num1.length() - 1));
    	int second = charToInt(num2.charAt(num2.length() - 1));
    	
    	ListNode num1Head = new ListNode(first);
    	ListNode num2Head = new ListNode(second);
    	ListNode p1 = num1Head;
		for (int i = num1.length() - 2; i >= 0; i--) {
			ListNode t = new ListNode(charToInt(num1.charAt(i)));
			p1.next = t;
			p1 = t;
		}
		
		ListNode p2 = num2Head;
		for (int i = num2.length() - 2; i >= 0; i--) {
			ListNode t = new ListNode(charToInt(num2.charAt(i)));
			p2.next = t;
			p2 = t;
		}
		
		p1 = num1Head;
		p2 = num2Head;
		
		ListNode target = num1.length() > num2.length()? p1 : p2;
		ListNode targetHead = target;
		ListNode prevTarget = target;
		int carry = 0;
		while (p1 != null & p2 != null) {
			target.val = p1.val + p2.val + carry;
			carry = target.val/10;
			target.val = target.val % 10;
			p1 = p1.next;
			p2 = p2.next;
			prevTarget = target;
			target = num1.length() > num2.length()? p1 : p2;
		}
		
		if(carry != 0) {
			if(target != null) {
				target.val = target.val + carry;
			}
			else if(target == null) {
				ListNode newNode = new ListNode(carry);
				prevTarget.next = newNode;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		p1 = targetHead;
		while(p1 != null) {
			sb.append(p1.val);
			p1 = p1.next;
		}
		
    	return sb.reverse().toString();
    }
    
    // @todo: multiply two large number using String
    public String Multiple(String num1, String num2) {
    	String result = "";
    	
    	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
