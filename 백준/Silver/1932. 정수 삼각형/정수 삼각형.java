import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[][] arr,dy;
    public static int DFS(int L, int idx){
        if(L == n-1) return dy[L][idx];
        else{
            if(dy[L][idx]==0){
                dy[L][idx] = Math.max(DFS(L+1, idx), DFS(L+1, idx+1)) + arr[L][idx];
            }
        }
        return dy[L][idx];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dy = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;st.hasMoreTokens();j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            dy[n-1][i] = arr[n-1][i];
        }

        System.out.println(DFS(0,0));
    }
}