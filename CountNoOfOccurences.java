//works good
package com.gs.java.threads;

public class CountNoOfOccurences {

	public static void main(String[] args) {
		int arr[]={1,1,1,2,2,2,3,3,4,4,4,4,5,5,6,8,10,13,13,13,15,20,20,25,25};
		int k=222;
		System.out.println(countOccurences(arr,arr.length,k));
	}

	private static int countOccurences(int[] arr,int n, int k) {
		int res,si,ei;
		res=-1;
		if(n==1){
			if(arr[0]==k){
				res=1;
			}
		}
		else if((arr[0]==k)&&(arr[n-1]==k)){
			res=n;
		}else{
			si=getElementStartIndex(arr,0,n-1,k);
			ei=getElementEndIndex(arr,0,n-1,k);
			System.out.println(si+"  "+ei);
			if(si==-1 || ei==-1){
				res=-1;
			}else{
				res=ei-si+1;
			}
			
		}		
		return res;
	}
	private static int getElementEndIndex(int[] arr, int s, int e, int k) {
		int m,res,n;
		m=(s+e)/2;
		n=e+1;
		res=-1;
		while((s>=0)&&(s<=e)&&(e>=0)&&(e<n)&&(m>=s)&&(m<=e)){
			if(res!=-1) break;
			if((s>e) || (m>e)) break;
			if(s==e){
				if(arr[s]==k)
					res=s;
				break;
			}
			if(arr[m]<k){
				s=m+1;
			}else if(arr[m]>k){
				e=m-1;
			}else{
				if(m==(n-1)){
					res=n-1;
				}else if(m==0){
					res=0;
				}else{
					if(arr[m+1]==arr[m]){
						s=m+1;
					}else{
						res=m;
					}
				}
			}
			m=(s+e)/2;			
		}
		return res;
	}
	
	private static int getElementStartIndex(int[] arr, int s, int e, int k) {
		int m,res,n;
		m=(s+e)/2;
		n=e+1;
		res=-1;
		while((s>=0)&&(s<=e)&&(e>=0)&&(e<n)&&(m>=s)&&(m<=e)){
			if(res!=-1) break;
			if((s>e) || (m>e)) break;
			if(s==e){
				if(arr[s]==k)
					res=s;
				break;
			}
			if(arr[m]<k){
				s=m+1;
			}else if(arr[m]>k){
				e=m-1;
			}else{
				if(m==(n-1)){
					res=n-1;
				}else if(m==0){
					res=0;
				}else{
					if(arr[m-1]==arr[m]){
						e=m-1;
					}else{
						res=m;
					}
				}
			}
			m=(s+e)/2;			
		}
		return res;
	}
	
}
