class Node{
    int value;
    Node lt; Node rt;
    public Node(int value){
        this.value = value;
        lt = rt = null;
    }
}

public class 이진트리순회 {
    Node root;
    public void DFS(Node root){
        if(root==null) return;
        else{
            System.out.print(root.value + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }
    public static void main(String[] args) {
        이진트리순회 tree = new 이진트리순회();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);
    }
}
