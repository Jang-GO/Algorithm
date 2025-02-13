
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n,m,answer = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(arr[i][j] == 0){
                    answer = -1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static void BFS() {
        Queue<Point> qu = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1) qu.offer(new Point(i,j));
            }
        }
        if(qu.isEmpty()) return;
        while(!qu.isEmpty()){
            int len = qu.size();
            for(int i=0;i<len;i++){
                Point now_p = qu.poll();
                for(int j=0;j<4;j++){
                    int ny = now_p.y + dy[j];
                    int nx = now_p.x + dx[j];
                    if(ny >=0 && ny < m && nx >=0 && nx < n && arr[ny][nx]==0){
                        arr[ny][nx] = 1;
                        qu.offer(new Point(ny,nx));
                    }
                }
            }
            if(qu.isEmpty()) break;
            answer++;
        }
    }

    static class Point{
        int y, x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
