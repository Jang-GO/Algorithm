import java.util.*;
import java.io.*;

class Main{
    static boolean[][] visited;
    static String[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int n, normalAreaCounts, specialAreaCounts;

    public static void DFS(int x, int y){
        visited[x][y] = true;
        String target = board[x][y];
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny].equals(target)){
                DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new String[n][n];

        for(int i=0;i<n;i++){
            String[] ss = br.readLine().split("");
            for(int j=0;j<n;j++){
                board[i][j] = ss[j];
            }
        }
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    DFS(i,j);
                    normalAreaCounts++;
                }
            }
        }
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j].equals("R")){
                    board[i][j] = "G";
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    DFS(i,j);
                    specialAreaCounts++;
                }
            }
        }

        System.out.println(normalAreaCounts+ " " + specialAreaCounts);
    }
}