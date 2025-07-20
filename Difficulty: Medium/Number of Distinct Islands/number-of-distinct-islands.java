// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<List<String>> hs=new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    List<String> li=new ArrayList<>();
                    help(i,j,i,j,grid,li);
                    hs.add(li);
                }
            }
        }
        return hs.size();
    }
    void help(int i,int j,int x,int y,int[][] grid,List<String> li){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)return;
        if(grid[i][j]==1){
            int u=i-x;
            int v=j-y;
            String s=Integer.toString(u)+" "+Integer.toString(v);
            li.add(s);
            grid[i][j]=2;
            help(i+1,j,x,y,grid,li);
            help(i-1,j,x,y,grid,li);
            help(i,j+1,x,y,grid,li);
            help(i,j-1,x,y,grid,li);
        }
    }
    
}
