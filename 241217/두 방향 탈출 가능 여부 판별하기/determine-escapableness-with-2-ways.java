import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static int n, m, answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];

        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        DFS(0,0);

        System.out.println(answer);
    }

    public static void DFS(int x, int y){
        if(answer==1) return;
        if(y == n-1 && x == m-1){
            answer = 1;
            return;
        }else{
            for(int i=0;i<2;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<m & ny >=0 && ny<n && board[ny][nx] !=0 ){
                    DFS(nx,ny);
                }
            }
        }
    }
}