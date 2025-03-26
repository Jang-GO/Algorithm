import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memArr = new int[n];
        int[] costArr = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            memArr[i] = Integer.parseInt(st1.nextToken());
            costArr[i] = Integer.parseInt(st2.nextToken());
        }

        int costSum = Arrays.stream(costArr).sum();
        int[] dp = new int[costSum+1];

        for(int i=0;i<n;i++){
            int mem = memArr[i];
            int cost = costArr[i];
            for(int j=costSum; j>=cost;j--){
                dp[j] = Math.max(dp[j], dp[j-cost]+mem);
            }
        }

        int answer = -1;
        for(int i=0;i<dp.length;i++){
            if(dp[i] >= m){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
