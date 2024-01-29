import java.util.*;
import java.io.*;

public class 섬나라아일랜드 {
    static int[][] board;
    static int n, answer=0;
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public void BFS(Point point){
        Queue<Point> qu = new LinkedList<>();
        qu.offer(point);
        while(!qu.isEmpty()){
            Point tmp = qu.poll();
            for(int i=0;i<8;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx<n && ny >=0 && ny<n && board[nx][ny]==1){
                    board[nx][ny]=0;
                    qu.offer(new Point(nx,ny));
                }
            }
        }

    }
    public void DFS(int x, int y){
         for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny >=0 && ny<n && board[nx][ny]==1){
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public void solution(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0;
                    // DFS(i,j);
                    BFS(new Point(i,j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        섬나라아일랜드 T = new 섬나라아일랜드();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        T.solution();
        System.out.println(answer);
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
