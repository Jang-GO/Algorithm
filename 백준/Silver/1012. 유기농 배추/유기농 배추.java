import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    private static void DFS(int y, int x, int[][] arr){
        arr[y][x] = 0;

        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[0].length && arr[ny][nx]==1){
                DFS(ny,nx,arr);
            }
        }
    }

    private static int solution(int[][] arr){
        int answer = 0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1){
                    DFS(i, j, arr);
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][M];

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[Y][X] = 1;
            }

            sb.append(solution(arr)).append("\n");
        }

        System.out.println(sb);
    }
}
