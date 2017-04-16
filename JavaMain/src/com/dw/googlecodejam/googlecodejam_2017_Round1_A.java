package com.dw.googlecodejam;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class googlecodejam_2017_Round1_A {
	public static int R,C;
	public static boolean isEnd;
	public static ArrayList<Character> p;
		
	public static boolean validationCheck(char[][] array,int k,int m) {
		boolean result = false;
		char c = array[k][m];
		
		if(array[k-1][m] == c && k-1 >=0) 
		{
			for(int i=k-1;i<k+1;i++) {
				for(int j=m-1;j<m+1;j++){
					if(array[i][j]!=c) {
						break;
					}
				}
			}
			
			for(int i=k-1;i<k+1;i++) {
				for(int j=m;j<=m+1;j++){
					if(array[i][j]!=c) {
						break;
					}
				}
			}
		}
		
		if((array[k+1][m] == c && k+1 < R)) {
			
		}
		
		if(array[k][m - 1] == c && m - 1 >=0) {
			
		}
		
		if(array[k][m + 1] == c && m + 1 < C) {
			
		}
		
		return result;
	}
	
	public static void foo(char[][] array) {
		boolean isfull = true;
	     for(int k=0;k<R;k++) {
	        for(int m=0;m<C;m++) {
	            if(array[k][m] == '?') {
	                isfull = false;
	                for(char x : p) {
	                    array[k][m] = x;

	                    if(!validationCheck(array,k,m)) {
	                    	continue;
	                    }
	                    
	                    foo(array);
	                    if(isEnd) return;
	                    array[k][m]='?';
	                }
	            }
	        }
	     }

	     if(isfull) {
	         print(array);
	         isEnd = true;
	         return;
	     }

	}
	
	public static void print(char[][] array) {
		for(int k=0;k<R;k++){
    		for(int m=0;m<C;m++){
    			System.out.print(array[k][m]);
    		}
    		System.out.println();
    	}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        FileInputStream instream = null;
        PrintStream outstream = null;
        
        try{
            instream = new FileInputStream("D:/test/0.txt");
            outstream = new PrintStream("D:/test/0.out");
            System.setIn(instream);
            System.setOut(outstream);
        }
        catch(Exception e){
            System.err.println("Error Occurred");
        }
        


        Scanner in = new Scanner(System.in);
        String strT = in.nextLine();
        int T = Integer.parseInt(strT);
        
        for(int i=0;i<T;i++) {
        	System.out.print(String.format("Case #%d: ",(i+1)));
        	System.out.println();
        	
        	p.clear();
        	
        	strT = in.nextLine();
        	String[] strTArray = strT.split(" ");
        	R = Integer.parseInt(strTArray[0]);
        	C = Integer.parseInt(strTArray[1]);
        	
        	char[][] array = new char[R][C];
        	for(int k=0;k<R;k++) {
        		strT = in.nextLine();
        		for(int m=0;m<C;m++) {
        			array[k][m] = strT.charAt(m);
        			
        			if(array[k][m] != '?' && !p.contains(array[k][m])) {
        				p.add(array[k][m]);
        			}
        		}
        	}
        	
        	
        	foo(array);
        	/*for(int k=0;k<R;k++){
        		for(int m=0;m<C;m++){
        			System.out.print(array[k][m]);
        		}
        		System.out.println();
        	}*/
        	
        	
        }
		
	}

}
