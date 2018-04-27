package com.gs.java.threads;
import java.util.concurrent.atomic.AtomicInteger;
class EvenThread implements Runnable{
	private final AtomicInteger atomInt;
	private final int size;
	
	public EvenThread(AtomicInteger ai,int size){
		atomInt=ai;
		this.size=size;
	}
	public void run(){
		synchronized(this.atomInt){
			try{
				while(atomInt.get()<=size){
					if(atomInt.get()%2 == 0){
						System.out.println(Thread.currentThread().getName()+": "+atomInt.get());
						atomInt.incrementAndGet();
					}
					atomInt.notify();
					if(atomInt.get()>size) break;
					atomInt.wait();
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
	}
}

class OddThread implements Runnable{
	private final AtomicInteger atomInt;
	private final int size;
	
	public OddThread(AtomicInteger ai,int size){
		atomInt=ai;
		this.size=size;
	}
	public void run(){
		synchronized(this.atomInt){
			try{
				while(atomInt.get()<=10){
					if(atomInt.get()%2 == 1){
						System.out.println(Thread.currentThread().getName()+": "+atomInt.get());
						atomInt.incrementAndGet();
					}
					atomInt.notify();
					if(atomInt.get()>(size-1)) break;
					atomInt.wait();
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
	}
}

public class EvenOddDemo1 {
	 
	public static void main(String[] args){
		final AtomicInteger ai=new AtomicInteger(1);
		final int size=10;
		EvenThread et=new EvenThread(ai,size);
		OddThread ot=new OddThread(ai,size);
		Thread t1=new Thread(et,"Even thread");
		Thread t2=new Thread(ot,"Odd thread");
		t1.start();
		t2.start();		
	}
}
