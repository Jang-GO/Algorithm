import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100_001];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        
        int[] coins = {2,5};
        
        for(int coin : coins){
            for(int i=coin; i<=n;i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        if(dp[n]==n+1) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}