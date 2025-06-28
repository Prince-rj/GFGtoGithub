/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    class Pair{
        Node root;
        int horlev;
        int verlev;
        Pair(Node root,int horlev,int verlev){
            this.root=root;
            this.horlev=horlev;
            this.verlev=verlev;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0,0));
        
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node tem=q.peek().root;
                int horlev=q.peek().horlev;
                int verlev=q.peek().verlev;
                q.poll();
                if(tem.left!=null)q.add(new Pair(tem.left,horlev-1,verlev+1));
                if(tem.right!=null)q.add(new Pair(tem.right,horlev+1,verlev+1));
                hm.put(horlev,tem.data);
            }
            
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(var i:hm.entrySet()){
            arr.add(i.getValue());
        }
        return arr;
        
        
        
    }
}