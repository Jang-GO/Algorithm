import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] deg = new int[n+1];

        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            deg[b]++;
        }

        Queue<Integer> qu = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            if(deg[i] == 0) qu.offer(i);
        }

        while(!qu.isEmpty()){
            int now = qu.poll();
            sb.append(now).append(" ");
            for(int b: graph.get(now)){
                deg[b]-=1;
                if(deg[b] == 0) qu.offer(b);
            }
        }

        System.out.println(sb);
    }
}
