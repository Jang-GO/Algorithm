import java.util.*;
import java.io.*;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class 토마토 {
    static int n,m, day = 0;
    static int[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public void BFS(){
        Queue<Point> qu = new LinkedList<>();
        // 배열 탐색하여 일단 익은 토마토 위치를 큐에 넣기
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1) qu.offer(new Point(i, j));
            }
        }
        //큐 안에 토마토만큼 주변을 익게 만들어야함
        while(!qu.isEmpty()){
            int len = qu.size();
            for(int i=0;i<len;i++){
                Point tmp = qu.poll();
                for(int j=0;j<4;j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx <m && ny>=0 && ny<n && board[nx][ny]==0){
                        board[nx][ny]=1;
                        qu.offer(new Point(nx, ny));
                    }
                } 
            }
            day++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    day = 0;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        토마토 T = new 토마토();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] h = br.readLine().split(" ");
        n = Integer.parseInt(h[0]);
        m = Integer.parseInt(h[1]);
        board = new int[m][n];
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.BFS();
        System.out.println(day-1);
    }
}
