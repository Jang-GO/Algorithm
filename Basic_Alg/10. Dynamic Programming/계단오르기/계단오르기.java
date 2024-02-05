import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 계단오르기{
    static int[] dy;
    
    public int solution(int n){
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=n;i++) dy[i] = dy[i-1] + dy[i-2];
        return dy[n];
    }
    public static void main(String[] args) throws IOException{
        계단오르기 T = new 계단오르기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dy = new int[n+1];
        System.out.println(T.solution(n));
    }
}