import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        int[] indeg = new int[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for(int j=0;j<people-1;j++){
                int after = Integer.parseInt(st.nextToken());
                graph.get(before).add(after);
                indeg[after]++;
                before = after;
            }
        }

        Queue<Integer> qu = new ArrayDeque<>();
        for(int i=1;i<=n;i++) if(indeg[i]==0) qu.offer(i);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        while(!qu.isEmpty()){
            int now = qu.poll();
            cnt++;
            sb.append(now).append("\n");
            
            for(int next : graph.get(now)){
                indeg[next]--;
                if(indeg[next]==0) qu.offer(next);
            }
        }
        
        if(cnt!=n){
            System.out.println(0);
        }else{
            System.out.println(sb);
        }
    }
}