import java.io.*;
import java.util.*;

public class Main {
    static int[] unf;

    private static int find(int v){
        if(unf[v]==v) return v;
        return unf[v] = find(unf[v]);
    }

    private static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Edge> edges = new ArrayList<>();
        unf = new int[n+1];
        for(int i=0;i<=n;i++) unf[i] = i;

        for(int i=1;i<=n;i++){
            int cost = Integer.parseInt(br.readLine());
            edges.add(new Edge(i, 0, cost));
        }

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int cost = Integer.parseInt(st.nextToken());
                if(i==j) continue;
                edges.add(new Edge(i,j,cost));
            }
        }

        edges.sort(null);

        int answer = 0;
        for(Edge o : edges){
            int fv1 = find(o.v1);
            int fv2 = find(o.v2);
            if(fv1 == fv2) continue;
            union(fv1,fv2);
            answer+=o.cost;
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;

        Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
}