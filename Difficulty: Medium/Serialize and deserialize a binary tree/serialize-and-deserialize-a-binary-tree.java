//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void deletetree(Node root) {
        if (root == null) return;
        deletetree(root.left);
        deletetree(root.right);
        root.left = null;
        root.right = null;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Tree tr = new Tree();
            ArrayList<Integer> A = tr.serialize(root);
            deletetree(root);
            root = null;

            Node getRoot = tr.deSerialize(A);
            printInorder(getRoot);
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    
    public ArrayList<Integer> serialize(Node root) {
        // code here
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        ArrayList<Integer> arr=new ArrayList<>();
        while(!q.isEmpty()){
            Node val=q.poll();
            if(val==null){
                arr.add(-1);
                continue;
            }
            arr.add(val.data);
            q.add(val.left);
            q.add(val.right);
        }
        return arr;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        Node ans=null;
        Queue<Node> q=new LinkedList<>();
        // Queue<Integer> ind=new LinkedList<>();
        if(arr.size()==0)return null;
        q.add(new Node(arr.get(0)));
        ans=q.peek();
        // ind.add(0);
        // System.out.println(arr);
        for(int i=0;i<arr.size();i++){
            Node root=q.poll();
            // int i=ind.poll();
            int left=2*i+1;
            int right=2*i+2;
            if(left<arr.size()){
                if(arr.get(left)!=-1){
                    root.left=new Node(arr.get(left));
                    q.add(root.left);
                    // ind.add(left);
                }
            }
            if(right<arr.size()){
                if(arr.get(right)!=-1){
                    root.right=new Node(arr.get(right));
                    q.add(root.right);
                    // ind.add(right);
                }
            }
        }
        // inorder(ans);
        return ans;
    }
    // public void inorder(Node root){
    //     if(root==null)return;
    //     inorder(root.left);
    //     System.out.println(root.data);
    //     inorder(root.right);
    // }
    
};