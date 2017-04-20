package com.dw.lib.test;

interface Executable {
	void execute();
}

class Runner {
	public void run(Executable e) {
		System.out.println("Executing code block ...");
		e.execute();
	}
}

public class JavaInterfaceTest {
    public static void main(String[] args) {
        Runner runner = new Runner();
        
        runner.run(new Executable(){
			public void execute() {
				System.out.println("Hello There");
			}
        });
        
        //@example: lambda
        System.out.println("=====================");
        
        runner.run(()-> System.out.println("Hello There."));
        
        System.out.println("=====================");
        
        runner.run(()-> {
        	
        	System.out.println("Hello There.");
        	System.out.println("Hello There.");
        });
    }
}
