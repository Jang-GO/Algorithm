import java.io.*;

class Main{
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int v,int L){
        if(L==m){
            for(int x:arr) sb.append(x).append(" ");
            sb.append("\n");
            return ;
        }else{
            for(int i=v;i<=n;i++){
                arr[L] = i;
                dfs(i,L+1);
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        arr = new int[m];
        dfs(1,0);

        System.out.println(sb.toString());
    }
}