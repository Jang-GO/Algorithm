import java.io.*;
import java.util.StringTokenizer;

class Main{
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    static int[] unf;

    public static int Find(int v){
        if(unf[v]==v) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] = fb;
    }

    public void solution(int ss, int a, int b){
        if(ss==1){
            if(Find(a)!=Find(b)) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }else{
            Union(a,b);
        }
    }
    public static void main(String[] args) throws IOException{
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        unf = new int[n+1];
        for(int i=0;i<=n;i++){
            unf[i] = i;
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ss = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            M.solution(ss,a,b);
        }

        System.out.println(sb.toString());
    }
}