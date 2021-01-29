/*
Find Pair Given Difference 
Given an unsorted array Arr[] and a number N. You need to write a program to find if there exists a pair of 
elements in the array whose difference is N.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int i=0;i<T;i++)
		{
			int n=s.nextInt();
			int[] arr=new int[n];
			int x=s.nextInt();
			for(int j=0;j<n;j++)
			{
				arr[j]=s.nextInt();
			}
			System.out.println(pair(arr,x));
	    }
	}
	
	public static int pair(int[] arr,int l){
	    
	    if(arr.length == 0){
	        return -1;
	    }
	    
	    Arrays.sort(arr);
	    
	    int i = 0 , j=1;
	    
	    while(i<arr.length && j<arr.length){
	        if(i!=j && arr[j]-arr[i] == l){
	            return 1;
	        }else if(arr[j]-arr[i] <l){
	            j++;
	        }else{
	            i++;
	        }
	    }
	    
	    return -1;
	}
}