import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 조합의경우수 {
    static int[][] mem = new int[40][40];
    public int DFS(int n, int r){
        if(mem[n][r]>0) return mem[n][r];
        if(n==r || r==0) return 1;
        else{
            return mem[n][r] = DFS(n-1,r-1)+DFS(n-1,r);
        }
    }
    public static void main(String[] args) throws IOException{
        조합의경우수 T = new 조합의경우수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int r = Integer.parseInt(tmp[1]);
        System.out.println(T.DFS(n,r));
    }
}
