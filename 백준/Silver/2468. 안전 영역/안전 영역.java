import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n, answer=0,maxheight=0;
    static int[][] board;
    static boolean[][] visited;
    static boolean[][] ddd;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static void DFS(int x, int y){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && !ddd[nx][ny]){
                DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int tmp = Integer.parseInt(st.nextToken());
                maxheight = Math.max(tmp, maxheight);
                board[i][j] = tmp;
            }
        }
        

        for(int i=0;i<=maxheight;i++){
            ddd = new boolean[n][n];
            visited = new boolean[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(board[j][k]<=i){
                        ddd[j][k] = true;
                    }
                }
            }
            int atmp=0;
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(!ddd[j][k] && !visited[j][k]){
                        DFS(j,k);
                        atmp++;
                    }
                }
            }
            answer = Math.max(atmp, answer);
        }
        
        System.out.println(answer);
    }
}