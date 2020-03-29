package com.dw.leetcode;

public class FindAllGoodStrings_5371 {
	public static int stringCompare(String str1, String str2) 
    { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
   
        if (l1 != l2) { 
            return l1 - l2; 
        }
        else { 
            return 0; 
        } 
    } 
	
	public static int[] reverse(int[] array) {
		for(int i=0; i<array.length/2; i++) { 
			int temp = array[i]; 
			array[i] = array[array.length -i -1]; 
			array[array.length -i -1] = temp; 
		}
		return array;
	}
	
	public int findGoodStrings(int n, String s1, String s2, String evil) {
		int p = 0;
		
        for(int i=0;i<n;i++) {
        	if(s2.charAt(i) > s1.charAt(i)) {
        		p = i;
        		break;
        	}
        }
        int[] array = new int[n-p];
        int counter = 0;
        for(int i = p;i<n;i++) {
        	array[counter++] = s2.charAt(i) - s1.charAt(i);
        }
        
        array = reverse(array);
        
        if(s1.substring(0, p).contains(evil)) {
        	return 0;
        }
        
        for(int i=0;i<n;i++) {
        	String prefix = s2.substring(0,i);
        	String mid = evil;
        	
        	if(n >= prefix.length() + mid.length()) {
        		String end = s2.substring(prefix.length() + mid.length(),n);
        		
        		String temp = prefix+mid+end;
        		if(stringCompare(s2, temp) < 0) {
        			prefix = s2.substring(0,i - 1);
        			prefix+=(char)(s2.charAt(i) - 1);
        		}
        		
        		if(stringCompare(s2, temp) > 0 && stringCompare(s1,temp) < 0) {
        			int tp = 0;
        			 for(int m=0;m<n;m++) {
        				 if(temp.charAt(i) > s1.charAt(i)) {
        					 tp = m;
        					 break;
        				 }
        			 }
        			 
        			 int[] tArray = new int[n-tp];
        			 counter = 0;
        			 for(int m=tp;m<n;m++) {
        				 tArray[counter++] = temp.charAt(m) - s1.charAt(m);
        			 }
        			 
        			 tArray = reverse(tArray);
        			 
        			 for(int m=0;m<tArray.length;m++) {
        				 array[m] -= tArray[m];
        			 }
        		}
        	}
        }
        
        int result = 0;
        int power = 1;
        for(int i=0;i<array.length;i++) {
        	result += array[i] * power;
        	power *= 26;
        	power %= ((int)Math.pow(10, 9) + 7);
        	
        	if(result > 0)
        		result = result%((int)Math.pow(10, 9) + 7);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllGoodStrings_5371 s = new FindAllGoodStrings_5371();
		
		System.out.println(s.findGoodStrings(3, "szc", "zyi", "p"));
	}

}
