//Working good
package com.gs.java.threads;

public class PrintSpiralMatrix {
	public static void main(String[] args) {
		int arr[][]={{1},{2},{3},{4}};
		/*{5,6,7,8},
		{9,10,11,12},
		{13,14,15,16}};*/
		int r,c;
		r=4; c=1;
		printSpiralMatrix(arr,r,c);
	}

	private static void printSpiralMatrix(int[][] arr,int r,int c) {
		//corner cases
		if(r==1&&c==1){
			System.out.println(arr[0][0]);
			return;
		}
		if(r==1&&c>1){
			for(int j=0;j<c;j++)
				System.out.print(arr[0][j]+" ");
			System.out.println();
			return;
		}
		if(r>1&&c==1){
			for(int i=0;i<r;i++)
				System.out.print(arr[i][0]+" ");
			System.out.println();
			return;
		}
		//multiple rows & columns
		int rs,re,cs,ce,i,j;
		rs=cs=0;
		re=r-1; ce=c-1;
		while(true){
			if((rs>re)||(cs>ce)){
				break;
			}
			for(i=rs,j=cs;j<=ce;j++)
				System.out.print(arr[i][j]+" ");
			rs++;
			if((rs>re)||(cs>ce)){
				break;
			}
			for(i=rs,j=ce;i<=re;i++)
				System.out.print(arr[i][j]+" ");
			ce--;
			if((rs>re)||(cs>ce)){
				break;
			}
			for(i=re,j=ce;j>=cs;j--)
				System.out.print(arr[i][j]+" ");
			re--;
			if((rs>re)||(cs>ce)){
				break;
			}
			for(i=re,j=cs;i>=rs;i--)
				System.out.print(arr[i][j]+" ");
			cs++;
			//System.out.println(rs+" "+re+" "+cs+" "+ce);
		}
	}
}
