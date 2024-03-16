import java.io.*;
import java.util.*;

class Main{
    static int n,m,day=0;
    static int[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(){
        Queue<Point> Q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1) Q.offer(new Point(i,j));
            }
        }

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                Point tmp = Q.poll();
                for(int j=0;j<4;j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=0 && nx<n && ny >=0 && ny<m && board[nx][ny]==0){
                        board[nx][ny]=1;
                        Q.offer(new Point(nx,ny));
                    }
                }
                
            }
            day++;
        }
        day--;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0){
                    day=-1;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        m = Integer.parseInt(ss[0]);
        n = Integer.parseInt(ss[1]);
        board = new int[n][m];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();
        System.out.println(day);
    }
}