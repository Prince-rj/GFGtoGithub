class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[]=new int[adj.size()];
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        q.add(0);
        while(!q.isEmpty()){
            int temp=q.poll();
            if(vis[temp]==0)arr.add(temp);
            vis[temp]=1;
            for(var i:adj.get(temp)){
                if(vis[i]==0){
                    q.add(i);
                }
            }
        }
        return arr;
    }
}