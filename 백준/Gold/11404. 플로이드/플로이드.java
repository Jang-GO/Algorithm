
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge>{
    int vex;
    int cost;
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}
public class Main {
    static ArrayList<ArrayList<Edge>> graph;
    static int[][] dis;
    public void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v,0));
        dis[v][v] = 0;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(dis[v][now] < nowCost) continue;
            for(Edge ob:graph.get(now)){
                if(dis[v][ob.vex] > nowCost + ob.cost){
                    dis[v][ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            graph.get(a).add(new Edge(b,c));
        }
        dis = new int[n+1][n+1];
        for(int i=1;i<=n;i++) Arrays.fill(dis[i], Integer.MAX_VALUE);

        for(int i=1;i<=n;i++){
            T.solution(i);
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dis[i][j] == Integer.MAX_VALUE) System.out.print(0 + " ");
                else System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }
    }
}
