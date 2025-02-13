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
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
    // code here
    for(int i=arr.length/2+1;i>=0;i--){
        maxHeapify(i,arr);
    }

  }
  static void maxHeapify(int i,int arr[]){
      int l=2*i+1;
      int r=l+1;
      int lar=l;
      if(l>=arr.length&&r>=arr.length)return;
      if((l>=arr.length&&r<arr.length)||(r<arr.length&&arr[l]<arr[r]))lar=r;
      if(arr[i]<arr[lar]){
          int t=arr[i];
          arr[i]=arr[lar];
          arr[lar]=t;
          maxHeapify(lar,arr);
      }
  }
}
     