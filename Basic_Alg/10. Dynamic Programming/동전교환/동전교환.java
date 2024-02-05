import java.io.*;
import java.util.*;

public class 동전교환 {
    static int n,m;
    static int[] dy;
    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i=0;i<n;i++){
            for(int j=coin[i]; j<=m;j++){
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }
    public static void main(String[] args) throws IOException{
        동전교환 T = new 동전교환();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }
        m = Integer.parseInt(br.readLine());
        dy = new int[m+1];
        System.out.println(T.solution(arr));
    }
}
