import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void BFS(int[][] board,int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        board[x][y]=0;
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0;i<4;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx < n && ny>=0 && ny<m && board[nx][ny]==1){
                    board[nx][ny]=0;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int cnt=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] board = new int[n][m];
            for(int j=0;j<k;j++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st1.nextToken());
                int y = Integer.parseInt(st1.nextToken());
                board[y][x] = 1;
            }
            
            for(int j=0;j<n;j++){
                for(int l=0;l<m;l++){
                    if(board[j][l]==1){
                        BFS(board,j,l);
                        cnt++;
                    }
                }  
            }
            System.out.println(cnt);
        }
    }
}