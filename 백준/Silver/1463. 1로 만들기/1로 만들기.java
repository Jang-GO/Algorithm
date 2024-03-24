import java.util.*;
import java.io.*;

class Main{
    static int[] dy;
    public int solution(int n){
        dy[1] = 0;
        dy[2] = 1;
        dy[3] = 1;
        for(int i=4;i<=n;i++){
            dy[i] = dy[i-1] +1;
            if(i%2==0) dy[i] = Math.min(dy[i], dy[i/2]+1);
            if(i%3==0) dy[i] = Math.min(dy[i], dy[i/3]+1);
        }
        return dy[n];
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n<=3) dy = new int[4];
        else dy = new int[n+1];
        System.out.println(T.solution(n));
    }
}