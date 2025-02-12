//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int i=0;
        int j=0;
        int ans=-1;
        while(i<s.length()){
            hm.put(s.charAt(i),i);
            if(hm.size()==k){
                int len=i-j+1;
                ans=Math.max(len,ans);
            }
            else if(hm.size()>k){
                while(j<s.length()&&hm.size()!=k){
                    char x=s.charAt(j);
                    if(hm.get(x)==j)hm.remove(x);
                    j++;
                }
                if(hm.size()==k){
                    int len=i-j+1;
                    ans=Math.max(len,ans);
                }
            }
            i++;
        }
        return ans;
    }
}