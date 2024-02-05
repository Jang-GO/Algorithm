import java.io.*;

public class 최대부분증가수열 {
    static int[] dy;
    public int solution(int[] arr){
        int answer=0;
        dy[0]=1;
        for(int i=1;i<arr.length;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i] && dy[j]>max){
                    max = dy[j];
                }
            }
            dy[i] = max +1;
            answer= Math.max(answer, dy[i]);
        }

        return answer;
    }
    public static void main(String[] args) throws IOException{
        최대부분증가수열 T = new 최대부분증가수열();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }
        dy = new int[n];
        System.out.println(T.solution(arr));
    }
}
