import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점수계산 {
    public static void main(String[] args) throws IOException{
        점수계산 T = new 점수계산();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(arr));
    }
    public int solution(int[] arr){
        int answer=0;
        int score=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                score++;
                answer+=score;
            }else score=0;
        }
        
        return answer;
    }
}
