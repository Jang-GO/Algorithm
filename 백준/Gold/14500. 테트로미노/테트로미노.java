import java.io.*;
import java.util.*;

class Main{
    static StringTokenizer st;
    static int n,m, answer=0;
    static int[][] board;
    static boolean[][] ch;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public void solution(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!ch[i][j]){
                    ch[i][j] = true;
                    DFS(i,j,board[i][j], 1);
                    ch[i][j] = false;
                    otherSum(i,j);
                }
            }
        }
    }

    public void DFS(int x, int y, int sum, int L){
        if(L==4){
            answer = Math.max(answer, sum);
            return;
        }else{
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !ch[nx][ny]){
                    ch[nx][ny]=true;
                    DFS(nx,ny,sum+board[nx][ny], L+1);
                    ch[nx][ny] = false;
                }
            }
        }
    }
    public void otherSum(int x, int y){
        int sum;
        // ㅗ
        if(x>=1 && y>=1 && y+1<m){
            sum = board[x][y] + board[x-1][y] + board[x][y-1] + board[x][y+1];
            answer = Math.max(answer, sum);
        }
        // ㅜ
        if(x+1<n && y>=1 && y+1<m){
            sum = board[x][y] + board[x+1][y] + board[x][y-1] + board[x][y+1];
            answer = Math.max(answer, sum);
        }
        // ㅏ
        if(x>=1 && x+1<n && y+1<m){
            sum = board[x][y] + board[x+1][y] + board[x-1][y] + board[x][y+1];
            answer = Math.max(answer, sum);
        }
        // ㅓ
        if(x>=1 && x+1<n && y-1>=0){
            sum = board[x][y] + board[x+1][y] + board[x-1][y] + board[x][y-1];
            answer = Math.max(answer, sum);
        }
    }
    
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        ch = new boolean[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.solution();
        System.out.println(answer);
    }
}