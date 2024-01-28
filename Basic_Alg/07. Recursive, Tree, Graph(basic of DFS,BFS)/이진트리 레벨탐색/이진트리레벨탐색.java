// import java.util.LinkedList;
// import java.util.Queue;

// class Node{
//     int value;
//     Node lt, rt;
//     Node(int value){
//         this.value=value;
//         lt=rt=null;
//     }
// }

// public class 이진트리레벨탐색 {
//     Node root;
//     public void BFS(Node root){
//         Queue<Node> qu = new LinkedList<>();
//         qu.offer(root);
//         int L=0;
//         while(!qu.isEmpty()){
//             int len = qu.size();
//             System.out.print(L + " : ");
//             for(int i=0;i<len;i++){
//                 Node cur = qu.poll();
//                 System.out.print(cur.value+" ");
//                 if(cur.lt!=null) qu.offer(cur.lt);
//                 if(cur.rt!=null) qu.offer(cur.rt); 
//             }
//             L++;
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//         이진트리레벨탐색 tree = new 이진트리레벨탐색();
//         tree.root = new Node(1);
//         tree.root.lt = new Node(2);
//         tree.root.rt = new Node(3);
//         tree.root.lt.lt = new Node(4);
//         tree.root.lt.rt = new Node(5);
//         tree.root.rt.lt = new Node(6);
//         tree.root.rt.rt = new Node(7);

//         tree.BFS(tree.root);
//     }    
// }
