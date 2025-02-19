//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return Double.compare((double)b[0]/b[1],(double)a[0]/a[1]);
        });
        for(int i=0;i<val.size();i++){
            pq.add(new int[]{val.get(i),wt.get(i)});
        }
        double ans=0;
        // for(var i:pq)System.out.println(Arrays.toString(i));
        while(!pq.isEmpty()&&capacity>0){
            int[] temp=pq.poll();
            int w=Math.min(capacity,temp[1]);
            double v=((double)temp[0]/temp[1])*w;
            ans+=v;
            capacity-=w;
        }
        return ans;
    }
}