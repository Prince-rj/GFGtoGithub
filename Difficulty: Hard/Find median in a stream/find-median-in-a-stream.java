//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        min=new PriorityQueue<>();
        max=new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Double> ans=new ArrayList<>();
        for(var i:arr){
            add(i);
            ans.add(get());
        }
        return ans;
    }
    public void add(int num){
        if(min.isEmpty()||num>min.peek()){
            min.add(num);
            if(Math.abs(min.size()-max.size())>1){
                max.add(min.poll());
            }
        }
        else{
            max.add(num);
            if(Math.abs(min.size()-max.size())>1){
                min.add(max.poll());
            }
        }
        // System.out.println(max);
        // System.out.println(min);
        
    }
    public double get(){
       if(min.size()>max.size()) return min.peek();
       else if(max.size()>min.size())return max.peek();
       else return (double)(max.peek()+min.peek())/2;
    }
}