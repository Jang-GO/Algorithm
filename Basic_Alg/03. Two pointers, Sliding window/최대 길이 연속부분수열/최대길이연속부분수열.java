import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대길이연속부분수열 {
    public int solution(int N, int K, int[] arr){
        int cnt=0, answer=0, lt=0;
        for(int rt=0;rt<N;rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>K){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer=Math.max(answer, rt-lt+1);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        최대길이연속부분수열 T = new 최대길이연속부분수열();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        int N= Integer.parseInt(tmp1[0]);
        int K= Integer.parseInt(tmp1[1]);

        int[] arr = new int[N];
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(tmp2[i]);
        }
        System.out.println(T.solution(N,K,arr));
    }
}
