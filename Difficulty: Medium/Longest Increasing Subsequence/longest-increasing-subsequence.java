//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int lis(int arr[]) {
        // code here
        int[][] dp=new int[arr.length][arr.length+1];
        for(var i:dp)Arrays.fill(i,-1);
        return help(arr,-1,0,dp);
        
    }
    static int help(int[] arr,int prev,int i,int[][] dp){
        if(i==arr.length)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int op1=0,op2=0;
        if(prev==-1||arr[prev]<arr[i]){
            op1=1+help(arr,i,i+1,dp);
        }
        op2=help(arr,prev,i+1,dp);
        return dp[i][prev+1]=Math.max(op1,op2);
        
    }
}