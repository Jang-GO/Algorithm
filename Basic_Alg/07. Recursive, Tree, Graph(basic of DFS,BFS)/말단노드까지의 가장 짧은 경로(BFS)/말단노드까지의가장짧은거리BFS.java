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

// public class 말단노드까지의가장짧은거리BFS {
//     Node root;
//     public int BFS(Node root){
//         Queue<Node> qu = new LinkedList<>();
//         qu.offer(root);
//         int L=0;
//         while(!qu.isEmpty()){
//             int len=qu.size();
//             for(int i=0;i<len;i++){
//                 Node tmp = qu.poll();
//                 if(tmp.rt==null && tmp.lt==null) return L;
//                 if(tmp.rt!=null) qu.offer(tmp.rt);
//                 if(tmp.lt!=null) qu.offer(tmp.lt);
//             }
//             L++;
//         }
//         return -1;
//     }
//     public static void main(String[] args) {
//         말단노드까지의가장짧은거리BFS tree = new 말단노드까지의가장짧은거리BFS();
//         tree.root = new Node(1);
//         tree.root.lt = new Node(2);
//         tree.root.rt = new Node(3);
//         tree.root.lt.lt = new Node(4);
//         tree.root.lt.rt = new Node(5);
//         System.out.println(tree.BFS(tree.root));
//     }    
// }
