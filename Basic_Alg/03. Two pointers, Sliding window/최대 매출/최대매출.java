import java.io.*;

public class 최대매출 {
    public int solution(int N, int K, int[] arr){
        int answer, sum=0;
        for(int i=0;i<K;i++) sum+=arr[i];
        answer=sum;
        for(int i=K;i<N;i++){
            sum+=(arr[i]-arr[i-K]);
            if(sum>answer) answer = sum;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        최대매출 T = new 최대매출();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int K = Integer.parseInt(tmp[1]);

        String[] ttmp = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i=0;i<N; i++){
            arr[i] = Integer.parseInt(ttmp[i]);
        }

        System.out.println(T.solution(N,K,arr));
    }
}
