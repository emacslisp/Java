package com.dw.lib;

//@example: Java Thread - Notify and Wait
public class OutputThread implements Runnable {

    private int num;
    private Object lock;
    private int count = 0;
    
    public OutputThread(int num, Object lock) {
        super();
        this.num = num;
        this.lock = lock;
    }

    public void run() {
        try {
            while(count++<10){
                synchronized(lock){
                    lock.notifyAll();
                    lock.wait();
                    System.out.println(num);
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        final Object lock = new Object();
        
        Thread thread1 = new Thread(new OutputThread(1,lock));
        Thread thread2 = new Thread(new OutputThread(2, lock));
        
        thread1.start();
        thread2.start();
    }

}
