import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 합이같은부분집합{
    static int n, total=0;
    static int[] arr;
    static String answer = "NO";
    static boolean isExist = false;
    public void DFS(int L, int sum){
        if(isExist) return;
        if(sum>(total-sum)) return;
        if(L==n){
            if((total-sum)==sum){
                isExist=true;
                answer = "YES";
            }
        }else{
            DFS(L+1, sum+arr[L]);
            DFS(L+1, sum);
        }
    }
    public static void main(String[] args) throws IOException{
        합이같은부분집합 T = new 합이같은부분집합();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp[i]);
            total += arr[i];
        }
        
        T.DFS(0,0);
        System.out.println(answer);
    }
}