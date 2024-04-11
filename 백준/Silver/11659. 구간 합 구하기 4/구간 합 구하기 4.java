import java.io.*;
import java.util.*;

class Main{
    static int n, m;
    static int[] arr;
    static long[] dy;
    static StringBuilder sb = new StringBuilder();
    
    public void solution(){
        dy[0]=0;
        dy[1] = arr[1];
        for(int i=2;i<=n;i++){
            dy[i] = dy[i-1] + arr[i];
        }
    }
    public long solution(int a, int b){
        return dy[b]-dy[a-1];
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        
        arr = new int[n+1];
        dy = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) arr[i] = Integer.parseInt(st.nextToken());


        T.solution();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(T.solution(a,b)).append("\n");
        }

        System.out.println(sb.toString());
    }
}