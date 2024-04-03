import java.io.*;
import java.util.*;

class Main{
    static int n,m;
    static int[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static Queue<Point> minusQ = new LinkedList<>();
    static class Point{
        int x, y;
        int cnt;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        Point(int x, int y, int cnt){
            this(x,y);
            this.cnt = cnt;
        }
    }

    public static int solution(){
        int year = 0;
    
        while(true){
            boolean[][] visited = new boolean[n][m];
            int ice = 0; 
    
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]>0 && !visited[i][j]){
                        dfs(i, j, visited);
                        ice++;
                    }
                }
            }
            if(ice >= 2) return year; 
            else if(ice == 0) return 0; 
            
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]>0) melt(i,j); 
                }
            }
    
            while(!minusQ.isEmpty()){
                Point tmp = minusQ.poll();
                board[tmp.x][tmp.y] = Math.max(0, board[tmp.x][tmp.y] - tmp.cnt);
            }
    
            year++;
        }
    }
    
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        board = new int[n][m];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution());
    }

    public static void melt(int x, int y){
        int cnt=0;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
                cnt++;
            }
        }
        minusQ.offer(new Point(x,y,cnt));
    }
    
    public static void dfs(int x, int y, boolean[][] visited){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && board[nx][ny] > 0){
                dfs(nx, ny, visited);
            }
        }
    }
    
}