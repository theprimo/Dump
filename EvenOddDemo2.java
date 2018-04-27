package com.gs.java.threads;
class EvenThread1 implements Runnable{
	private final int size;
	private final Object lockObj;

	public EvenThread1(Object lock,int n){
		lockObj=lock;
		size=n;
	}
	
	public void run() {
		int i=0;
		synchronized(this.lockObj){
			try{
				while(i<=size){
					System.out.println(Thread.currentThread().getName()+": "+i);
					i+=2;
					lockObj.notify();
					if(i>size) break;
					lockObj.wait();
				}				
			}catch(InterruptedException e){
				System.out.println(e);
			}catch(Exception e){
				System.out.println(e);
			}			
		}
	}	
}

class OddThread1 implements Runnable{
	private final int size;
	private final Object lockObj;
	
	public OddThread1(Object lock,int n){
		lockObj=lock;
		size=n;
	}
	
	public void run(){
		int i=1;
		synchronized(this.lockObj){
			try{
				while(i<=size){
					System.out.println(Thread.currentThread().getName()+": "+i);
					i+=2;
					lockObj.notify();
					if(i>size)	break;
					lockObj.wait();
				}				
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

public class EvenOddDemo2 {
	public static void main(String[] args){
		int size=20;
		final Object lockObj=new Object();
		
		EvenThread1 et=new EvenThread1(lockObj,size);
		OddThread1 ot=new OddThread1(lockObj,size);
		Thread evenThread=new Thread(et,"Even thread");
		Thread oddThread=new Thread(ot,"Odd thread");
		evenThread.start();
		oddThread.start();		
	}
}
