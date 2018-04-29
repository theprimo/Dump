package com.gs.java.threads;

public class LargestSubarraySum {
	public static void main(String[] args) {
		int arr[]={2,-3,4,-1,-2,1,5,-3, };
		
		printMaxSubarraySum(arr);
		
	}

	private static void printMaxSubarraySum(int[] arr) {
		int i,j,n,maxsum,cursum;
		n=arr.length;
		if(n==1){
			System.out.println(arr[0]);
			return;
		}
		cursum=maxsum=arr[0];
		for(i=1;i<n;i++){
			if((cursum+arr[i])>0){
				cursum+=arr[i];				
			}else{
				cursum=0;
				//cursum=((cursum>arr[i])?cursum:arr[i]);
			}
			maxsum=((maxsum>cursum)?maxsum:cursum);
		}
		System.out.println(maxsum);
	}
}
