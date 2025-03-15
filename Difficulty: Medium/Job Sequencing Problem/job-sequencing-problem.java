//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
        int arr[][]=new int[id.length][2];
        for(var i=0;i<id.length;i++){
            arr[i][0]=deadline[i];
            arr[i][1]=profit[i];
        }
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return (b[1]-a[1]==0)?a[0]-b[0]:b[1]-a[1];
            }
        });
        
        int b[]=new int[id.length];
        for(int i=0;i<id.length;i++){
            int c=Math.min((id.length-1),arr[i][0]-1);
            for(int j=c;j>=0;j--){
                if(b[j]==0){
                    b[j]=arr[i][1];
                    break;
                }
            }
        }
        int val=0;
        // for(var i:arr)System.out.println(Arrays.toString(i));
        // System.out.println(Arrays.toString(b));
        int cnt=0;
        for(var i:b){
            if(i!=0){
                cnt++;
                val+=i;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(cnt);
        ans.add(val);
        return ans;
    }
}
