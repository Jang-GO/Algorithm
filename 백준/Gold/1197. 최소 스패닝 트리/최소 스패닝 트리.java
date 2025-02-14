
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 프림 - 인접리스트
    static int V, sum;
    static List<ArrayList<Vertex>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        visited = new boolean[V+1];

        for(int i=0;i<=V;i++) graph.add(new ArrayList<>());

        for(int i=1;i<=e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Vertex(b,c));
            graph.get(b).add(new Vertex(a,c));
        }

        solution();
        System.out.println(sum);
    }
    private static void solution(){
        PriorityQueue<Vertex> pQ = new PriorityQueue<>();
        int cnt = 0;
        pQ.offer(new Vertex(1,0));

        while(!pQ.isEmpty()){
            Vertex ver = pQ.poll();
            if(visited[ver.v]) continue;

            visited[ver.v] = true;
            sum+=ver.c;
            cnt++;

            if(cnt == V) continue;

            for(Vertex now_v: graph.get(ver.v)){
                if(visited[now_v.v]) continue;
                pQ.offer(new Vertex(now_v.v, now_v.c));
            }
        }
    }

    static class Vertex implements Comparable<Vertex>{
        int v, c;
        Vertex(int v, int c){
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(Vertex o){
            return this.c - o.c;
        }
    }
}
