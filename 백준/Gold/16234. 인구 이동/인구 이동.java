import java.io.*;
import java.util.*;

class Main{
    static int n, l ,r;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] board;
    static int[][] ch;
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(){
        int day = 0;
        boolean moved = true;
        while(moved){ 
            ch = new int[n][n];
            moved = false; 
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(ch[i][j]==0) {
                        if(BFS(i,j)) moved = true;
                    }
                }
            }
            if(moved){
                day++;
            }
        }
        return day;
    }
    public static boolean BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        List<Point> union = new ArrayList<>();
        ch[x][y] = 1;
        Q.offer(new Point(x, y));
        union.add(new Point(x, y));
        int sum = 0;
        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            sum += board[tmp.x][tmp.y];
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && ch[nx][ny] == 0) {
                    int diff = Math.abs(board[tmp.x][tmp.y] - board[nx][ny]);
                    if (diff >= l && diff <= r) {
                        ch[nx][ny] = 1;
                        Q.offer(new Point(nx, ny));
                        union.add(new Point(nx, ny));
                    }
                }
            }
        }
        if (union.size() > 1) {
            int avgPopulation = sum / union.size();
            for (Point p : union) {
                board[p.x][p.y] = avgPopulation;
            }
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        ch = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution());
    }
}
