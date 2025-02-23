import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dy = new int[10001];
        int[] coins = new int[n];


        for(int i=0;i<n;i++) coins[i] = Integer.parseInt(br.readLine());

        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=k;j++){
                if(dy[j-coins[i]] != Integer.MAX_VALUE){
                    dy[j] = Math.min(dy[j], dy[j-coins[i]]+1);
                }
            }
        }
        if(dy[k] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dy[k]);
    }
}
