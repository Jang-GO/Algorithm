import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N, M;
    static int[] dis; // 거리 배열
    static List<ArrayList<Vertex>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 도시번호는 1부터 N까지 (0번 인덱스 사용 X)
        dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        // vertexes 그래프 초기화 (0번 인덱스 사용 X)
        for(int i=0;i<=N;i++) graph.add(new ArrayList<>());

        // graph 초기화
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src_vertex = Integer.parseInt(st.nextToken());
            int dst_vertex = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(src_vertex).add(new Vertex(dst_vertex, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        solution(start);

        System.out.println(dis[end]);
    }

    private static void solution(int start) {
        PriorityQueue<Vertex> pQ = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pQ.offer(new Vertex(start, 0));
        dis[start] = 0;

        while(!pQ.isEmpty()){
            Vertex now_vertex = pQ.poll();
            int now = now_vertex.ver;
            int now_cost = now_vertex.cost;

            // 원래의 길이보다 현재 더 길다면 pass
            if(dis[now] < now_cost) continue;
            for(Vertex canGoVertex : graph.get(now)){
                // 원래 값보다 canGoVertex를 경유하는게 더 가까운 경우
                if(dis[canGoVertex.ver] > now_cost + canGoVertex.cost){
                    dis[canGoVertex.ver] = now_cost + canGoVertex.cost;
                    pQ.offer(new Vertex(canGoVertex.ver, now_cost + canGoVertex.cost ));
                }
            }
        }
    }

    static class Vertex{
        int ver, cost;
        public Vertex(int v, int c){
            ver = v;
            cost = c;
        }
    }
}