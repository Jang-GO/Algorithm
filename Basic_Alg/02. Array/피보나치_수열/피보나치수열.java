package 피보나치_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 피보나치수열 {
    public static void main(String[] args) throws IOException{
        피보나치수열 T = new 피보나치수열();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(T.solution(N));
    }
    public String solution(int n){
        StringBuilder sb = new StringBuilder();
        int[] fibo = new int[n];
        fibo[0] = fibo[1] = 1;
        for(int i=2;i<n;i++){
            fibo[i] = fibo[i-1]+ fibo[i-2];
        }
        for(int i=0;i<fibo.length;i++){
            sb.append(fibo[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
