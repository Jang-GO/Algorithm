
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }

        System.out.println(T.solution(n,arr));
    }

    private int solution(int n, int[] arr) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j-1]);
            }
        }
        return dp[n];
    }
}