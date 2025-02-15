//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
     PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
         return a[0]-b[0];
     });
     for(var i=0;i<arr.length;i++)pq.add(new int[]{arr[i],i});
     int val=0;
     int prev=0;
     while(!pq.isEmpty()){
         int[] temp=pq.poll();
         if(prev!=temp[0])val++;
         prev=temp[0];
         arr[temp[1]]=val;
     }
     return arr;
  }
}
     