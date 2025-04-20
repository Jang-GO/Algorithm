import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;st.hasMoreTokens();j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int money = Integer.parseInt(br.readLine());
            int[] dy = new int[money+1];

            dy[0] = 1;
            for(int coin: arr){
                for(int j=coin;j<=money;j++){
                    dy[j] += dy[j-coin];
                }
            }
            sb.append(dy[money]).append("\n");
        }
        System.out.println(sb);
    }
}