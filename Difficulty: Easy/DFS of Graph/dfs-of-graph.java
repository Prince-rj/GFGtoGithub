class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis=new int[adj.size()];
        ArrayList<Integer> arr=new ArrayList<>();
        help(0,adj,arr,vis);
        return arr;
        
    }
    public void help(int i,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> arr,int vis[]){
        if(vis[i]==1)return;
        arr.add(i);
        vis[i]=1;
        for(var x:adj.get(i)){
            if(vis[x]==0){
                help(x,adj,arr,vis);
            }
        }
    }
}