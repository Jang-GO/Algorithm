import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Problem{
    int score;
    int time;
    Problem(int score, int time){
        this.score = score;
        this.time = time;
    }
}

public class 최대점수구하기 {
    static int n, m, maxScore=Integer.MIN_VALUE;
    static Problem[] arr;
    public void DFS(int L, int scoreSum, int remain){
        if(remain<0) return;
        if(L==n){
            maxScore = Math.max(scoreSum, maxScore);
        }else{
            DFS(L+1, scoreSum+arr[L].score, remain-arr[L].time);
            DFS(L+1, scoreSum, remain);
        }
    }
    public static void main(String[] args) throws IOException{
        최대점수구하기 T = new 최대점수구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        arr = new Problem[n];
        for(int i=0;i<n;i++){
            String[] tmp1 = br.readLine().split(" ");
            int a = Integer.parseInt(tmp1[0]);
            int b = Integer.parseInt(tmp1[1]);
            arr[i] = new Problem(a,b);
        }
        T.DFS(0,0,m);
        System.out.println(maxScore);
    }
}
