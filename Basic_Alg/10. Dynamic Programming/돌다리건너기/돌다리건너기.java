import java.io.*;

public class 돌다리건너기 {
    static int[] dy;
    public int solution(int n){
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=n;i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n] + dy[n-1];
    }
    public static void main(String[] args) throws IOException{
        돌다리건너기 T = new 돌다리건너기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dy = new int[n+1];
        System.out.println(T.solution(n));
    }
}
