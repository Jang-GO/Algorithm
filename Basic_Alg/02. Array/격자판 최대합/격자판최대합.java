import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 격자판최대합 {
    public int solution(int[][] arr){
        int answer = 0;
        int sum1=0, sum2=0;
        //행,열의 합
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                sum1+=arr[i][j];
                sum2+=arr[j][i];
            }
            answer=Math.max(answer,Math.max(sum1 ,sum2));
            sum1 = sum2 = 0;
        }
        //대각선의 합
        for(int i=0;i<arr.length;i++){
            sum1+=arr[i][i];
            sum2+=arr[i][arr.length-i-1];
            answer=Math.max(answer,Math.max(sum1 ,sum2));
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        격자판최대합 T = new 격자판최대합();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0;i<arr.length;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        System.out.println(T.solution(arr));
    }
}
