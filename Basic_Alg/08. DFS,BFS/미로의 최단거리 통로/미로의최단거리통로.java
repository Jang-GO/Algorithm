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

public class 미로의최단거리통로 {
    static int[][] graph = new int[8][8], dis= new int[8][8];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public void BFS(int x, int y){
        Queue<Point> qu = new LinkedList<>();
        qu.offer(new Point(x, y));
        graph[x][y]=1;
        while(!qu.isEmpty()){
            Point tmp = qu.poll();
            for(int i=0;i<4;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && graph[nx][ny]==0){
                    graph[nx][ny] = 1;
                    qu.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        미로의최단거리통로 T = new 미로의최단거리통로();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=7;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=7;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.BFS(1,1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
