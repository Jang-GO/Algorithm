import java.util.*;
import java.io.*;

class Main {
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void DFS(int L){
        if(L==m){
            for(int x:arr) sb.append(x).append(" ");
            sb.append('\n');
            return;
        }
        for(int i=1;i<=n;i++){
            arr[L]=i;
            DFS(L+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        DFS(0);
        System.out.println(sb.toString());
    }
}
