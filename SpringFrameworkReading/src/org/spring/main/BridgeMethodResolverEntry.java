package org.spring.main;

import java.lang.reflect.Method;

import org.springframework.core.BridgeMethodResolver;

public class BridgeMethodResolverEntry {

	public class Node<T> {

	    public T data;

	    public Node(T data) { this.data = data; }

	    public void setData(T data) {
	        System.out.println("Node.setData");
	        this.data = data;
	    }
	}

	public class MyNode extends Node<Integer> {

	    public MyNode(Integer data) { super(data); }

	    @Override
	    public void setData(Integer data) {
	        System.out.println("MyNode.setData");
	        super.setData(data);
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BridgeMethodResolverEntry x = new BridgeMethodResolverEntry();
		MyNode resolver = x.new MyNode(5);
		Method[] declaredMethods = resolver.getClass().getDeclaredMethods();
		
		for (int i = 0; i < declaredMethods.length; i++) {
		            Method declaredMethod = declaredMethods[i];
		            String methodName = declaredMethod.getName();
		            Class<?> returnType = declaredMethod.getReturnType();
		            Class<?> declaringClass = declaredMethod.getDeclaringClass();
		            boolean bridge = declaredMethod.isBridge();
		            System.out.print((i+1) + " method name is" + methodName + ", return type is " + returnType + "  ");
		            System.out.print(bridge ? " is Bridge Method" : " is not Bridge Method");
		            System.out.println("  it is declared at "+declaringClass.getSimpleName()+"");            
		}                        

	}

}
