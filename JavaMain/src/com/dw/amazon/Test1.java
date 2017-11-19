package com.dw.amazon;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Test1 {
	
	List<Integer> subSequenceTags(List<String> targetList, 
              List<String> availableTagList)
	{
	// WRITE YOUR CODE HERE
		  List<Integer> result = new ArrayList<>();
		  
		  HashMap<String, Integer> map = new HashMap<String, Integer>();
		  

		  
		  int m = targetList.size();
		  int n = availableTagList.size();
		  for(int k = m - 1;k<n;k++) 
			  for(int length = k;length<n;length++) {
				  
				  for(int i=0;i<targetList.size();i++) {
						  map.put(targetList.get(i).toLowerCase(), 0);
				  }
				  
				  boolean isTrue = true;
				  
				  for(int i= length - k;i<=length;i++) {
					  if(map.get(availableTagList.get(i).toLowerCase()) != null) {
						  Integer tempInteger = map.get(availableTagList.get(i).toLowerCase());
						  map.put(availableTagList.get(i).toLowerCase(),tempInteger+1);
					  }
				  }
				  
				  for(int i=0;i<targetList.size();i++) {
					  Integer tempInteger = map.get(targetList.get(i).toLowerCase());
					  if(tempInteger != 1) {
						  isTrue = false;
						  break;
					  }
				  }
				  
				  if(isTrue) {
					  result.add(length - k);
					  result.add(length);
					  return result;
				  }
			  }  
		  // no match
		  result.add(0);
		  
		  return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] a = {"made","in","Spain"};
		//String[] b = {"made","weather","forecast","says","that","made","rain","in","spain","stays"};
		
		//String[] a = {"2abc","bcd","cab"};
		//String[] b = {"dbc","2abc","cab","bcd","bcb"};
		
		String[] a = {"in","the","spain"};
		String[] b = {"the","spain","that","the","rail","in","spain","stays","forecast","in","the"};
		
		
		List<String> targetList = new ArrayList<String>();
		List<String> availableTagList = new ArrayList<String>();
		
		for(String s :a) {
			targetList.add(s);
		}
		
		for(String s :b) {
			availableTagList.add(s);
		}

		Test1 t = new Test1();
		
		List<Integer> result = t.subSequenceTags(targetList, availableTagList);
		
		for(Integer i:result) {
			System.out.println(i);
		}
		
	}

}
