import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;
    static int ch[];
     
    public static void BFS(int v){
        Queue<Integer> Q = new LinkedList<>();
        ch[v]=1;
        Q.offer(v);
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int nx:graph.get(tmp)){
                 if(ch[nx]==0){
                    ch[nx]=1;
                    Q.offer(nx);
                 }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        BFS(1);
        int answer=0;
        for(int i=1;i<=n;i++){
            if(ch[i]==1) answer++;
        }
        System.out.println(answer-1);
    }
}