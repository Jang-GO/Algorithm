import java.io.*;

public class 중복순열구하기 {
    static int n, m;
    public void DFS(int L, int[] pm){
        if(L==m){
            for(int i=0;i<pm.length;i++){
                System.out.print(pm[i]+ " ");
            }
            System.out.println();
        }else{
            for(int i=1;i<=n;i++){
                pm[L] = i;
                DFS(L+1, pm);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        중복순열구하기 T = new 중복순열구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        int[] pm = new int[m];
        T.DFS(0,pm);
    }
}
