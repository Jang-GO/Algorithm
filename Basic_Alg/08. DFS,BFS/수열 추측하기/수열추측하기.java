import java.util.*;
import java.io.*;

class 수열추측하기{
    static int n, f;
    static int[] com, tmp, ch;
    int[][] mem = new int[35][35];
    static boolean flag = false;

    public int combination(int n, int r){
        if(mem[n][r]>0) return mem[n][r];
        if(n==r|| r==0) return 1;
        else{
            return mem[n][r] = combination(n-1, r-1) + combination(n-1, r);
        }
    }

    public void DFS(int L, int sum){
        if(flag) return;
        if(L==n){
            if(sum==f){ 
                for(int x:tmp) System.out.print(x + " ");
                flag = true;
            }
        }else{
            for(int i=1;i<=n;i++){
                if(ch[i]==0){
                    ch[i] = 1;
                    tmp[L] = i;
                    DFS(L+1, sum+(com[L]*tmp[L]));
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        수열추측하기 T = new 수열추측하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tt = br.readLine().split(" ");
        n = Integer.parseInt(tt[0]);
        f = Integer.parseInt(tt[1]);
        com = new int[n];
        tmp = new int[n];
        ch = new int[n+1];
        for(int i=0;i<n;i++){
            com[i] = T.combination(n-1, i);
        }
        T.DFS(0,0);
    }
}