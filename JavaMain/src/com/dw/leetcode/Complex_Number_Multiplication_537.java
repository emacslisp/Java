package com.dw.leetcode;

/*
 * nothing special in this problem
 * 
 * only remember input 1+0i, or 1+-1i is input and output format
 */
public class Complex_Number_Multiplication_537 {
	
	private class Complex {
		int real;
		int complex;
		Complex(int real, int complex) {
			this.real = real;
			this.complex = complex;
		}
	}
	
	public Complex parse(String a) {	
		String realPart = "";
		String complexPart = "";
		int i=0;
		if(a.charAt(0) == '-') {
			realPart+='-';
			i++;
		}
		
		for(;i<a.length();i++) {
			if(a.charAt(i) - '0' >= 0 && a.charAt(i) - '0' <= 9) {
				realPart += a.charAt(i);
			}
			else
				break;
		}
		
		if(a.charAt(i) == 'i') {
			return new Complex(0,Integer.parseInt(realPart));
		}
			
		i++;
		
		if(a.charAt(i) == '-') {
			complexPart+='-';
			i++;
		}
		
		for(;i<a.length();i++) {
			if(a.charAt(i) - '0' >= 0 && a.charAt(i) - '0' <= 9) {
				complexPart += a.charAt(i);
			}
			else
				break;
		}
		
		return new Complex(Integer.parseInt(realPart),Integer.parseInt(complexPart));
	}
    public String complexNumberMultiply(String a, String b) {
    	Complex x = parse(a);
    	Complex y = parse(b);
    	
    	int real = x.real * y.real - x.complex*y.complex;
    	int complex = x.real * y.complex + x.complex * y.real;
    	
    	return real + "+" + complex + "i";
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Complex_Number_Multiplication_537 s = new Complex_Number_Multiplication_537();
		System.out.println(s.complexNumberMultiply("1+-1i", "1+-1i"));
	}

}
