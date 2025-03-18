//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int pages[]= new int[N];
            for(int i = 0; i < N; i++)
                pages[i] = Integer.parseInt(input_line[i]);
            int C = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.pageFaults(N, C, pages));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    static int pageFaults(int N, int C, int pages[]){
        int[]freq=new int[1001];
        int l=0,faults=0,count=0;
        
        for(int i:pages){
            
            while(freq[pages[l]]>1)
                freq[pages[l++]]--;
                
            if(freq[i]==0){
                faults++;
                count++;
            }
                
            freq[i]++;
            
            if(count>C){
                count--;
                freq[pages[l++]]--;
            }
        }
        return faults;

    }
}