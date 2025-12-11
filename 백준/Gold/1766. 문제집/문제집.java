import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] deg;

    private static String solution(int n, int m){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<=n;i++) if(deg[i]==0) pq.offer(i);

        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for(int next : graph.get(cur)){
                deg[next]--;
                if(deg[next]==0) pq.offer(next);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       deg = new int[n+1];
       for(int i=0;i<=n;i++) graph.add(new ArrayList<>());

       for(int i=0;i<m;i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           graph.get(a).add(b);
           deg[b]++;
       }

       System.out.println(solution(n,m));
    }
}