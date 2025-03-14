import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    // 트리 레벨과 중위순회 결과가 주어졌을 때 트리 생긴거 구하기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        // 가운데 왼쪽 오른쪽 나눠서 분할정복
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(;st.hasMoreTokens();) list.add(Integer.parseInt(st.nextToken()));

        Node tree = makeTree(list);

        BFS(tree);
        System.out.println(sb);
    }

    private static void BFS(Node root) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0;i<size;i++){
                Node cur = qu.poll();
                sb.append(cur.val).append(" ");
                if(cur.lt != null) qu.offer(cur.lt);
                if(cur.rt != null) qu.offer(cur.rt);
            }
            sb.append("\n");
        }
    }

    private static Node makeTree(List<Integer> list) {
        if(list.isEmpty()) return null;

        int size = list.size();
        int mid = size / 2;

        Node root = new Node(list.get(mid));

        root.lt = makeTree(list.subList(0, mid));
        root.rt = makeTree(list.subList(mid + 1, size));

        return root;
    }

    static class Node{
        int val;
        Node lt;
        Node rt;
        Node(int val){
            this.val = val;
            lt = null;
            rt = null;
        }
    }
}
