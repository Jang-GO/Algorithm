import java.util.*;
import java.io.*;

class Main {
    static int n,m;
    static int[] arr, ch;
    public static void DFS(int L){
        if(L==m){
            for(int x:arr) System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=0;i<n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    arr[L]=i+1;
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        ch = new int[n];
        DFS(0);
    }
}
