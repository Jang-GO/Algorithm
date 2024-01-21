import java.util.LinkedList;
import java.util.Queue;

class Node{
    int value;
    Node lt, rt;
    Node(int value){
        this.value=value;
        lt=rt=null;
    }
}

public class 말단노드까지의가장짧은거리 {
    Node root;
    public int DFS(int L,Node root){
        if(root.lt==null && root.rt==null) return L;
        else{
            return Math.min(DFS(L+1, root.lt), DFS(L+1,root.rt));
        }
    }
    public static void main(String[] args) {
        말단노드까지의가장짧은거리 tree = new 말단노드까지의가장짧은거리();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.DFS(0,tree.root);
    }    
}
