import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n,m;
    static int[] unf;

    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        unf = new int[n+1];
        for(int i=1;i<=n;i++) unf[i] = i;
        for(int i=1;i<=n;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                if(tmp[j].equals("1")){
                    // j+1번 도시와 i번 도시는 연결
                    Union(i,j+1);
                }
            }
        }
        String[] ss = br.readLine().split(" ");
        int[] answer= new int[ss.length];
        int ch = 0;
        for(int i=0;i<ss.length;i++){
            int a = Integer.parseInt(ss[i]);
            answer[i] = Find(a);
        }

        boolean flag = false;
        for(int i=0;i<answer.length-1;i++){
            if(answer[i]!=answer[i+1]) flag = true;
        }
        System.out.println(flag ? "NO" : "YES");
    }
}