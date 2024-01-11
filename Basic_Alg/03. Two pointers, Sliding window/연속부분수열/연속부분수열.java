import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속부분수열 {
    public int solution(int N, int M, int[] arr){
        int cnt=0;
        int lt=0;
        int tmp=0;
        for(int rt=0;rt<N;rt++){
            tmp+=arr[rt];
            if(tmp==M) cnt++;
            while(tmp>=M){
                tmp-=arr[lt];
                lt++;
                if(tmp==M) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        연속부분수열 T = new 연속부분수열();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp1 = br.readLine().split(" ");
        int N = Integer.parseInt(tmp1[0]);
        int M = Integer.parseInt(tmp1[1]);
        int[] arr = new int[N];
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(tmp2[i]);
        }
        System.out.println(T.solution(N,M,arr));
    }
}
