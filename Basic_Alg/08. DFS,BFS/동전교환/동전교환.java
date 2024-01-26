import java.io.*;

public class 동전교환 {
    static int n, answer=Integer.MAX_VALUE;
    static int[] coin;
    public void DFS(int L,int remain){
        if(remain<0) return;
        if(answer<L) return;
        if(remain==0){
            answer = Math.min(L, answer);
        }else{
            for(int i=coin.length-1;i>=0;i--){
                DFS(L+1, remain-coin[i]);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        동전교환 T = new 동전교환();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coin = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(tmp[i]);
        }
        int remain = Integer.parseInt(br.readLine());

        T.DFS(0,remain);
        System.out.println(answer);
    }
}
