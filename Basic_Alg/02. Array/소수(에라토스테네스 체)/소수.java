import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수 {
    public static void main(String[] args) throws IOException {
        소수 T = new 소수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(T.solution(N));
    }
    public int solution(int N){
        int[] arr = new int[N+1];
        int cnt=0;
        for(int i=2;i<=N;i++){
            if(arr[i]==0){
                cnt++;
                for(int j=i;j<=N;j+=i) arr[j] = j;
            }
        }
        return cnt;
    }
}
