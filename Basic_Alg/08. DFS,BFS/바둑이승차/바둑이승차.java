import java.io.*;

public class 바둑이승차 {
    static int[] arr;
    static int n, c, max = Integer.MIN_VALUE;
    public void DFS(int L, int sum){
        if(sum>c) return;
        if(L==n) max = Math.max(max, sum);
        else{
            DFS(L+1, sum+arr[L]);
            DFS(L+1, sum);
        }
    }
    public static void main(String[] args) throws IOException{
        바둑이승차 T = new 바둑이승차();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        c = Integer.parseInt(tmp[0]);
        n = Integer.parseInt(tmp[1]);
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        T.DFS(0,0);
        System.out.println(max);
    }
}
