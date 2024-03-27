import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main{
    static int n, m, cnt;
    static StringBuilder sb = new StringBuilder();
    static int[][] board;
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static class Point{
        int x; int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void solution(int x, int y){
        board[x][y]=0;
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0;i<8;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && board[nx][ny]==1){
                    board[nx][ny]=0;
                    Q.offer(new Point(nx,ny));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            cnt=0;
            String[] tmp = br.readLine().split(" ");
            n = Integer.parseInt(tmp[0]);
            m = Integer.parseInt(tmp[1]);
            if(n==0 && m==0) break;
            board = new int[m][n];
            for(int i=0;i<m;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    board[i][j] = Integer.parseInt(st.nextToken()); 
                }
            }
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==1){
                        solution(i,j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}