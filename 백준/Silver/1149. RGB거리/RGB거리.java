import java.io.*;
import java.util.StringTokenizer;
import static java.lang.Math.*;
class Main{
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        arr = new int[n+1][3];

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=2;i<=n;i++){
            arr[i][0] += min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += min(arr[i-1][0], arr[i-1][1]);
        }

        System.out.println(min(min(arr[n][0],arr[n][1]),arr[n][2]));
    }
}