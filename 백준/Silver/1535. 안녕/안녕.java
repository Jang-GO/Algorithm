
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sad = new int[n];
        int[] happy = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++) sad[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++) happy[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[100];

        for(int i=0;i<n;i++){
            for(int j=99;j>=sad[i];j--){
                dp[j] = Math.max(dp[j],dp[j-sad[i]]+happy[i]);
            }
        }
        System.out.println(dp[99]);
    }
}
