//Works good
package com.gs.java.threads;

import java.util.Collections;
import java.util.TreeMap;

public class SlidingWindowMaxElement {
	public static void main(String[] args) {
		int arr[]={1,2,3,1,4,5,2,3,6};
		//int arr[]={1,2,3};
		int k=3;
		printMaxOfAllKWindows(arr,arr.length,k);		
	}

	private static void printMaxOfAllKWindows(int[] arr, int n, int k) {
		int i,wsize,value;
		TreeMap<Integer,Integer> tm;
		if(k>n || k<=0){
			System.out.println(-1);
			return;
		}
		if(n==1){
			System.out.println(arr[0]);
			return;
		}
		tm=new TreeMap<Integer,Integer>(Collections.reverseOrder());
		//insert first window
		for(i=0;i<k;i++){
			if(tm.containsKey(arr[i])){
				value=tm.get(arr[i])+1;
				tm.put(arr[i], value);
			}else{
				tm.put(arr[i],1);
			}
		}
		//max of first window		
		System.out.print(tm.firstKey()+" ");
		//find max for rest of windows
		wsize=(n-k+1)-1;
		for(i=0;i<wsize;i++){
			//remove start
			if(tm.get(arr[i])>1){
				value=tm.get(arr[i])-1;
				tm.put(arr[i], value);				
			}else{
				tm.remove(arr[i]);
			}
			//insert new window last element
			if(tm.containsKey(arr[i+k])){
				value=tm.get(arr[i+k])+1;
				tm.put(arr[i+k], value);
			}else{
				tm.put(arr[i+k],1);
			}
			//print max of cur window
			System.out.print(tm.firstKey()+" ");
		}
		System.out.println();
	}
}
