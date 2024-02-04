import java.util.*;
import java.io.*;
class Edge implements Comparable<Edge>{
    int ver;
    int cost;
    Edge(int ver, int cost){
        this.ver = ver;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

public class 원더랜드2 {
    static int[] ch;
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0; i<=n;i++){
            graph.add(new ArrayList<Edge>());
        }
        ch = new int[n+1];
        for(int i=1;i<m;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a,c));
        }
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1,0));
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int ev = tmp.ver;
            if(ch[ev]==0){
                ch[ev]=1;
                answer+=tmp.cost;
                for(Edge ob:graph.get(ev)){
                    if(ch[ob.ver]==0) pQ.offer(new Edge(ob.ver, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }
}
