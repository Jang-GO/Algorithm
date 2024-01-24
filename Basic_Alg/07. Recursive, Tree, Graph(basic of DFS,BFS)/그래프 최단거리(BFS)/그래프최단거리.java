import java.util.*;
import java.io.*;

public class 그래프최단거리 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v){
        Queue<Integer> qu = new LinkedList<>();
        ch[v]=1;
        dis[v]=0;
        qu.offer(v);
        while(!qu.isEmpty()){
            int tmp = qu.poll();
            for(int nv:graph.get(tmp)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    qu.offer(nv);
                    dis[nv]=dis[tmp]+1;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        그래프최단거리 T = new 그래프최단거리();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        dis = new int[n+1];

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        T.BFS(1);
        for(int i=2;i<dis.length;i++){
            System.out.println(i + " : "+ dis[i]);
        }
    }
}
