
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++)adj[i]=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        int[] vis=new int[V];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            ArrayList<Integer> li=new ArrayList<>();
            dfs(i,V,li,adj,vis);
            if(li.size()!=0)ans.add(li);
        }
        return ans;
        
    }
    public void dfs(int i,int V,ArrayList<Integer> arr,ArrayList<Integer>[] adj,int[] vis){
        if(vis[i]==1)return;
        vis[i]=1;
        arr.add(i);
        for(var x:adj[i]){
            if(vis[x]==0){
                dfs(x,V,arr,adj,vis);
            }
        }
    }
}