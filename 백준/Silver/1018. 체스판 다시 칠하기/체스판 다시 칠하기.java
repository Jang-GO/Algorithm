import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    static int answer=Integer.MAX_VALUE;
    static String startB = "BWBWBWBW";
    static String startW = "WBWBWBWB";

    public static void solution(int n, int m) {
        for(int i=0; i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                find(i,j); 
            }
        }
    }
    public static void find(int x, int y){
        int cnt1=0;
        int cnt2=0;
        
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if((i-x)%2 == 0){
                    if((j-y)%2 == 0 && arr[i][j] != 'W') cnt1++;
                    if((j-y)%2 == 1 && arr[i][j] != 'B') cnt1++;
                } else {
                    if((j-y)%2 == 0 && arr[i][j] != 'B') cnt1++;
                    if((j-y)%2 == 1 && arr[i][j] != 'W') cnt1++;
                }
            }
        }
        
        for(int i=x;i<x+8;i++){
            for(int j=y;j<y+8;j++){
                if((i-x)%2 == 0){
                    if((j-y)%2 == 0 && arr[i][j] != 'B') cnt2++;
                    if((j-y)%2 == 1 && arr[i][j] != 'W') cnt2++;
                } else {
                    if((j-y)%2 == 0 && arr[i][j] != 'W') cnt2++;
                    if((j-y)%2 == 1 && arr[i][j] != 'B') cnt2++;
                }
            }
        }
        
        answer = Math.min(answer, Math.min(cnt1, cnt2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n =Integer.parseInt(tmp[0]);
        int m =Integer.parseInt(tmp[1]);
        arr = new char[n][m];
        for(int i=0;i<n;i++){
            String ss = br.readLine();
            arr[i] = ss.toCharArray();
        }
        solution(n,m);
        System.out.println(answer);
    }
}
