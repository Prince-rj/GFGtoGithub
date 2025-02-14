//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		
System.out.println("~");
}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        int prev[]=arr[0];
        for(int i=1;i<arr.length;i++){
            prev=mergeArrays(prev,arr[i]);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(var i:prev)ans.add(i);
        return ans;
    }
    public static int[] mergeArrays(int[] arr1,int[] arr2){
        int i=0;
        int j=0;
        int ans[]=new int[arr1.length+arr2.length];
        int ind=0;
        while(i<arr1.length&&j<arr2.length){
            if(arr1[i]<=arr2[j]){
                ans[ind++]=arr1[i];
                i++;
            }
            else{
                ans[ind++]=arr2[j];
                j++;
            }
        }
        while(i<arr1.length){
            ans[ind++]=arr1[i];
            i++;
        }
        while(j<arr2.length){
            ans[ind++]=arr2[j];
            j++;
        }
        return ans;
    }
}