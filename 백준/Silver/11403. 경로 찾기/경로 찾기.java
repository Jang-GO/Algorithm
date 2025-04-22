import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        answer = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) graph.get(i).add(j);
            }
        }

        for(int i=0;i<n;i++){
            BFS(i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void BFS(int start) {
        Queue<Integer> qu = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        qu.offer(start);

        while(!qu.isEmpty()){
            int now = qu.poll();
            for(int next: graph.get(now)){
                if(visited[next]) continue;
                visited[next] = true;
                answer[start][next]=1;
                qu.offer(next);
            }
        }
    }
}