package com.dw.algorithmlib;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class StackHelper {
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		if(popped.length == 0) return true;
		Stack<Integer> stack = new Stack<Integer>();
		int index = 0;
		int i = 0;
		while(true) {
			if(stack.size() == 0) {
				stack.push(pushed[i++]);
				continue;
			}
			
			if(stack.peek() == popped[index]) {
				stack.pop();
				index++;
			} else {
				
				if(i >= pushed.length) break;
				
				stack.push(pushed[i++]);
			}
			
			if(index >= popped.length) {
				break;
			}
		}
		
		System.out.println(index);
		System.out.println(i);
		
		if(stack.size() == 0) return true;
		
		return false;
		
    }
	
	public void StackIterateExample() {
		Stack<String> stackOfPlates = new Stack<>();

        stackOfPlates.add("Plate 1");
        stackOfPlates.add("Plate 2");
        stackOfPlates.add("Plate 3");
        stackOfPlates.add("Plate 4");
        
        stackOfPlates.forEach(plate -> {
            System.out.println(plate);
        });
        
        System.out.println("\n=== Iterate over a Stack using iterator() ===");
        Iterator<String> platesIterator = stackOfPlates.iterator();
        while (platesIterator.hasNext()) {
            String plate = platesIterator.next();
            System.out.println(plate);
        }

        System.out.println("\n=== Iterate over a Stack using iterator() and Java 8 forEachRemaining() method ===");
        platesIterator = stackOfPlates.iterator();
        platesIterator.forEachRemaining(plate -> {
            System.out.println(plate);
        });
        
        System.out.println("\n=== Iterate over a Stack from TOP to BOTTOM using listIterator() ===");
        // ListIterator allows you to traverse in both forward and backward directions.
        // We'll start from the top of the stack and traverse backwards.
        ListIterator<String> platesListIterator = stackOfPlates.listIterator(stackOfPlates.size());
        while (platesListIterator.hasPrevious()) {
            String plate = platesListIterator.previous();
            System.out.println(plate);
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackHelper s = new StackHelper();
		s.StackIterateExample();
		
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,3,5,2,1};
		boolean result = s.validateStackSequences(pushed, popped);
		System.out.println(result);
	}

}
