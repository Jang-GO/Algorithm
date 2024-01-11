import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된자연수의합 {
    public int solution(int N){
        int answer=0, cnt=1;
        N--;
        while(N>0){
            cnt++;
            N=N-cnt;
            if(N%cnt==0) answer++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        연속된자연수의합 T = new 연속된자연수의합();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(T.solution(N));
    }
}
