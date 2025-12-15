import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] used;

    private static void dfs(int L, int cnt){
        if(cnt == n/2){
            int start = 0;
            int link = 0;

            for(int i=1;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    if(used[i] && used[j]){
                        start+=(arr[i][j] + arr[j][i]);
                    }else if(!used[i] && !used[j]){
                        link += arr[i][j] + arr[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(start-link));
            return;
        }

        for(int i=L;i<=n;i++){
            if(!used[i]) {
                used[i] = true;
                dfs(i+1,cnt+1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        used = new boolean[n+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0);
        System.out.println(answer);
    }
}
