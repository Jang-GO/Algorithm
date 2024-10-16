import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n,m, answer = 0;
    static String[][] graph;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public void DFS(int x, int y){
        graph[x][y] = "D";
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx <n && ny >=0 && ny < m && !graph[nx][ny].equals("D") &&!graph[nx][ny].equals("X")){
                if(graph[nx][ny].equals("P")){
                    answer++;
                }
                DFS(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new String[n][m];
        for(int i=0;i<n;i++){
            graph[i] = br.readLine().split("");
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(graph[i][j].equals("I")){
                    T.DFS(i,j);
                    break;
                }
            }
        }
        if(answer==0) System.out.println("TT");
        else System.out.println(answer);
    }
}