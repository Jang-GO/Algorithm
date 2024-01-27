import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열구하기 {
    static int n,m;
    static int[] pm, ch, arr;
    public void DFS(int L){
        if(L==m){
            for(int x:pm) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i=0;i<n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        순열구하기 T = new 순열구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        pm = new int[m];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ch = new int[n];
        T.DFS(0);
    }
}
