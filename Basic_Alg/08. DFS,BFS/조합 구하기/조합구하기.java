import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 조합구하기 {
    static int n,m;
    static int[] combi;
    public void DFS(int L, int s){
        if(L==m){
            for(int x:combi) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=s;i<=n;i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        조합구하기 T = new 조합구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        combi = new int[m];
        T.DFS(0,1);
    }
}
