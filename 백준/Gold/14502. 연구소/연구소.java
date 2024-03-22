import java.io.*;
import java.util.*;
class Main{
    static int n,m, safeCount=Integer.MIN_VALUE;
    static int[][] board;
    static int[][] tmpboard;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void BFS(){
        Queue<Point> Q = new LinkedList<>();
        tmpboard = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tmpboard[i][j] = board[i][j];
                if(board[i][j]==2){
                    Q.offer(new Point(i, j));
                } 
            }
        }
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0;i<4;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&&tmpboard[nx][ny]==0){
                    tmpboard[nx][ny]=2;
                    Q.offer(new Point(nx, ny));
                }
            }
        }

        int atmp=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(tmpboard[i][j]==0){
                    atmp++;
                }
            }
        }
        safeCount = Math.max(atmp, safeCount);
    }

    public static void DFS(int wallCount){
        if(wallCount==3){
            BFS();
        }else{
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]==0){
                        board[i][j]=1;
                        DFS(wallCount+1);
                        board[i][j]=0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0);

        System.out.println(safeCount);
    }

}