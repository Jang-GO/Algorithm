import java.util.*;
import java.io.*;
class Main{
    static int[] coins;

    public int solution(int n, int m){
        int answer=0;
        int now = m;
        for(int x:coins){
            if(x>now) continue;
            else{
                answer+= now/x;
                now= now%x;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        coins = new int[n];

        for(int i=n-1;i>=0;i--){
            int ss = Integer.parseInt(br.readLine());
            coins[i] = ss;
        }

        System.out.println(T.solution(n,m));
    }
}