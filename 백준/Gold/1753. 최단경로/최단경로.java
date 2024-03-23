import java.util.*;
import java.io.*;

class Main{
    static int v,e,k;
    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    static class Edge implements Comparable<Edge>{
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
    public void solution(int k){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(k,0));
        dis[k]=0;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>dis[now]) continue;
            for(Edge ob:graph.get(now)){
                if(dis[ob.vex]>nowCost+ob.cost){
                    dis[ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex,nowCost+ob.cost));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        k = Integer.parseInt(br.readLine());

        dis = new int[v+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,c));
        }
        T.solution(k);

        for(int i=1;i<=v;i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(dis[i]);
            else System.out.println("INF");
        }
    }
}