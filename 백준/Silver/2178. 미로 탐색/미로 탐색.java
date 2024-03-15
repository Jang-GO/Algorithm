import java.util.*;
import java.io.*;

class Main{
    static int n,m;
    static int[][] arr, dis;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0;i<4;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=1 && nx<=n && ny>=1 && ny<=m && arr[nx][ny]==1 && dis[nx][ny]==0){
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }       
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        arr = new int[n+1][m+1];
        dis = new int[n+1][m+1];
        dis[1][1] = 1;
        for(int i=1;i<=n;i++){
            String ss = br.readLine();
            String[] tmpp = ss.split(""); 
            for(int j=1;j<=m;j++){
                arr[i][j] = Integer.parseInt(tmpp[j-1]);
            }
        }
        BFS(1,1);
        System.out.println(dis[n][m]);
    }
}