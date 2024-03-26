import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;

    public void fibo(int n) {
        dp = new int[41][2];
        if(n >= 0) dp[0][0] = 1;
        if(n >= 1) dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0]; 
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        sb.append(dp[n][0] + " " + dp[n][1]).append("\n");
    }

    public static void main(String[] args) throws IOException {
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            M.fibo(n);
        }
        System.out.println(sb.toString());
    }
}
