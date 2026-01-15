import java.util.*;
import java.io.*;

class Main{
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    private static int solution(int n, int[][] arr){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, arr[0][0]));
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = arr[0][0];

        while(!pq.isEmpty()){
            Point now = pq.poll();

            if(now.cost > dist[now.y][now.x]) continue;
            if(now.y == n-1 && now.x == n-1) return now.cost;

            for(int i=0;i<4;i++){
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(ny < 0 || ny >=n || nx < 0 || nx >=n) continue;

                if(dist[ny][nx] > dist[now.y][now.x] + arr[ny][nx]){
                    dist[ny][nx] = dist[now.y][now.x] + arr[ny][nx];
                    pq.offer(new Point(ny,nx,dist[ny][nx]));
                }
            }
        }

        return dist[n-1][n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t=1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
            }

            sb.append("Problem ").append(t++).append(": ").append(solution(n,arr)).append("\n");
        }

        System.out.println(sb);
    }

    static class Point implements Comparable<Point>{
        int y, x;
        int cost;

        Point(int y, int x, int cost){
            this.y=y;
            this.x=x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o){
            return this.cost - o.cost;
        }
    }
}