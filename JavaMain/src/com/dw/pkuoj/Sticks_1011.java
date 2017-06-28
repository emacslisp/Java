package com.dw.pkuoj;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


/*
 * Sample Input

9
5 2 1 5 2 1 5 2 1
4
1 2 3 4
0
Sample Output

6
5
 * */

public class Sticks_1011 {
	
	/*
	 * add psudocode here
	 * sum of all sticks
	 * 
	 * foo() {
	 * 
	 * 
	 * 		  
	 * }
	 * 
	 * Arrays.sort(array);
	 * 
	 * max = findMaxSize(array);
	 * 
	 * for(int i=max+1;i<=sum;i++) {
	 *    if(sum %i == 0) {
	 *       
	 *    }
	 * }
	 */
	
	public static int[] boolArray = new int[100];
	
	public static void reverse(int[] array) {
	    for(int i=0;i<=array.length/2-1;i++) {
	        int temp = array[i];
	        array[i]=array[array.length - 1 - i];
	        array[array.length - 1 - i] = temp;
	    }
	}
	
	public static void main(String[] args) {
		
        FileInputStream instream = null;
        PrintStream outstream = null;
        
        try{
            instream = new FileInputStream("/Users/ewu/data/1.txt");
            outstream = new PrintStream("/Users/ewu/data/1.out");
            System.setIn(instream);
            System.setOut(outstream);
        }
        catch(Exception e){
            System.err.println("Error Occurred");
        }

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0) {
	        int[] array = new int[T];
	        
	        
            for(int j=0;j<T;j++){
                array[j] = in.nextInt();
            }
            T = in.nextInt();
            
            int sum = 0;
            for(int i=0;i<array.length;i++) {
            	sum += array[i];
            	boolArray[i] = 0;
            }
            
            Arrays.sort(array);
            reverse(array);
            
            //for(int i=0;i<array.length;i++)
            //	System.out.print(array[i] + "\t");
            
            for(int i=array[0];i<=sum;i++) {
            	if(sum == i) {
            		System.out.println(i);
            		break;
            	}
            	if(sum%i == 0) {
            		for(int k=0;k<boolArray.length;k++) {
            			boolArray[k] = 0;
            		}
            		if(checkValid(array,i,0,0)) {
            			System.out.println(i);
            			break;
            		}
            	}
            }
        }
		
	}
	
	public static boolean checkValid(int array[], int remainLen,int startIndex,int level) {
		
		for(int i=startIndex;i<array.length;i++) {
			if(boolArray[i] == 1) continue;
			
			if(remainLen > array[i]) {
				boolArray[i] = 1;
				if(checkValid(array,remainLen - array[i],i, level + 1) == false)
					return false;
				
				if(level > 0) return true;
			}
			else if(remainLen == array[i]) {
				boolArray[i] = 1;
				return true;
			}
		}
		
		if(level == 0) {
			for(int i=0;i<array.length;i++)
				if(boolArray[i] == 0)
					return false;
			
			return true;
		}
		
		return false;
	}
}
