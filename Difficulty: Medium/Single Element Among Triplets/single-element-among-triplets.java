//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr,N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int singleElement(int[] arr , int N) {
        // code here
        int val=0;
        int msk[]=new int[32];
        for(int j=0;j<32;j++){
            for(int i=0;i<arr.length;i++){
                msk[j]+=(arr[i]>>j)&1;
            }
            val+=(msk[j]%3)<<j;
        }
        return val;
    }
}