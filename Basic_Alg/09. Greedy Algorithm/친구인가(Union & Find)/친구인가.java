import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 친구인가 {
    static int[] unf;
    private static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    private static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException {
        친구인가 T = new 친구인가();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        unf = new int[n+1];
        for(int i=1;i<=n;i++) unf[i]=i;
        for(int i=1;i<=m;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            Union(a,b);
        }
        
        String[] tmp = br.readLine().split(" ");
        int a = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[1]);
        System.out.println((Find(a)==Find(b) ? "YES" : "NO"));
    }
}
