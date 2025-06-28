/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        help(root,arr,new ArrayList<>());
        return arr;
        
    }
    public static void help(Node root,ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> li){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            ArrayList<Integer> temp=new ArrayList<>();
            for(var i:li)temp.add(i);
            temp.add(root.data);
            arr.add(temp);
            return;
        }
        li.add(root.data);
        help(root.left,arr,li);
        help(root.right,arr,li);
        li.remove(li.size()-1);
    }
}










