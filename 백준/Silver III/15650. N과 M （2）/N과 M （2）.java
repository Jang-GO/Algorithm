import java.util.*;
import java.io.*;

class Main {
    static int n,m;
    static int[] arr, ch;
    public static void DFS(int L,int start){
        if(L==m){
            for(int i=0;i<m;i++) System.out.print(arr[i] + " ");
            System.out.println(); 
        }else{
            for(int i=start;i<n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    arr[L]=i+1;
                    DFS(L+1,i);
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
        DFS(0,0);
    }
}
