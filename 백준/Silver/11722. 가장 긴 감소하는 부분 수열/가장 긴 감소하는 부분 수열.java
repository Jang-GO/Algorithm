import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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

        System.out.println(T.solution(arr, n));
    }

    private int solution(int[] arr, int n) {
        int answer = 1;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(arr[j] > arr[i] && dp[j] > max) max = dp[j];
            }
            dp[i] = max+1;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}