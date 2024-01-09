import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 멘토링{
    public int solution(int N, int M,int[][] arr){
        int answer=0;
        for(int i=1;i<=N;i++){ 
            for(int j=1;j<=N;j++){ 
                int cnt=0;
                int iRank =0;
                int jRank =0;
                for(int k=0;k<M;k++){
                    for(int s=0;s<N;s++){
                        if(arr[k][s]==i) iRank=s; 
                        if(arr[k][s]==j) jRank=s;
                    }
                    if(iRank<jRank) cnt++;
                }
                if(cnt==M) answer++;
            }
        }
        return answer;        
    }
    public static void main(String[] args) throws IOException {
        멘토링 T = new 멘토링();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] intInput = new int[input.length];
        for(int i=0;i<input.length;i++){
            intInput[i] = Integer.parseInt(input[i]);
        }
        int N = intInput[0];
        int M = intInput[1];
        int[][] arr = new int[M][N];

        for(int i=0;i<M;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        System.out.println(T.solution(N,M,arr));
    }
}