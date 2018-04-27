package com.gs.java.threads;

public class MaxArrayRotationSum {
	public static void main(String[] args) {
		int arr[]={8,3,1,2};
		System.out.println("Ans: "+printMaxRotationSum(arr,arr.length));
	}

	private static int printMaxRotationSum(int[] arr, int n) {
		int max,i,rotSum,sum;
		max=0;
		if(n==1){
			return arr[0];
		}
		rotSum=sum=0;
		for(i=0;i<n;i++){
			sum+=arr[i];
			rotSum+=(arr[i]*i);
		}
		max=rotSum;
		System.out.println(rotSum);
		for(i=1;i<n;i++){
			rotSum=rotSum+sum-(arr[n-i]*n);
			System.out.println(rotSum);
			if(max<rotSum)
				max=rotSum;
		}
		return max;
	}	
}
