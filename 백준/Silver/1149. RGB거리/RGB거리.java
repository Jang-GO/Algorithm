import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n,arr));
    }

    private static int solution(int n,int[][] arr){
        for(int i=1;i<arr.length;i++){
            arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
        }

        return Arrays.stream(arr[n-1]).min().getAsInt();
    }
}
