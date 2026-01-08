import java.util.*;
import java.io.*;

class Main{
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static StringBuilder dfsBuilder = new StringBuilder();
    static StringBuilder bfsBuilder = new StringBuilder();
    static boolean[] dfsChk;
    static boolean[] bfsChk;

    private static void DFS(int v){
        dfsBuilder.append(v+ " ");
        dfsChk[v] = true;

        for(int next : list.get(v)){
            if(!dfsChk[next]){
                DFS(next);
            }
        }
    }

    private static void BFS(int v){
        Queue<Integer> qu = new ArrayDeque<>();
        bfsChk[v] = true;
        qu.offer(v);


        while(!qu.isEmpty()){
            int now = qu.poll();
            bfsBuilder.append(now+ " ");

            for(int next : list.get(now)){
                if(!bfsChk[next]) {
                    bfsChk[next] = true;
                    qu.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i=0;i<=n;i++) list.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1;i<=n;i++) list.get(i).sort(null);

        dfsChk = new boolean[n+1];
        bfsChk = new boolean[n+1];
        DFS(v);
        BFS(v);

        System.out.println(dfsBuilder);
        System.out.println(bfsBuilder);
    }
}