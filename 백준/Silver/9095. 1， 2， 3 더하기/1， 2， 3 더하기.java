import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static int[] dy;
    public void solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for(int i=4;i<=n;i++){
            dy[i] = dy[i-1] + dy[i-2] + dy[i-3];
        }
        sb.append(dy[n]).append("\n");
    }
    public static void main(String[] args) throws IOException{
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            if(n<4) dy = new int[4];
            else dy = new int[n+1];
            M.solution(n);
        }
        System.out.println(sb.toString());
    }
}