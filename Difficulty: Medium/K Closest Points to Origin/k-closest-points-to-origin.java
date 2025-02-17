//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->{
            return Double.compare(a[0],b[0]);
        });
        for(var i:points){
            double val=Math.sqrt(i[0]*i[0]+i[1]*i[1]);
            pq.add(new double[]{val,i[0],i[1]});
        }
        int[][] ans=new int[k][2];
        int ind=0;
        while(k>0){
            k--;
            double[] temp=pq.poll();
            ans[ind][0]=(int)temp[1];
            ans[ind][1]=(int)temp[2];
            ind++;
        }
        return ans;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] points = new int[n][2];
            for (int i = 0; i < n; i++) {
                points[i][0] = scanner.nextInt();
                points[i][1] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int[][] ans = solution.kClosest(points, k);

            Arrays.sort(ans, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });
            for (int[] point : ans) {
                System.out.println(point[0] + " " + point[1]);
            }
            System.out.println("~");
        }

        scanner.close();
    }
}
// } Driver Code Ends