package com.dw.leetcode;

public class DefangingAnIPAddress_1108 {
	public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefangingAnIPAddress_1108 s = new DefangingAnIPAddress_1108();
		System.out.println(s.defangIPaddr("1.1.1.1"));
	}

}
