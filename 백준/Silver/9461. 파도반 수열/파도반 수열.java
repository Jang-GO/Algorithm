import java.io.*;
import java.util.Arrays;
class Main{
    static long[] dy = new long[101]; 
    public long solution(int n){
        Arrays.fill(dy, -1);
        dy[0]=1;
        dy[1]=1;
        dy[2]=1;
        for(int i=3;i<=n;i++){
            if(dy[i]==-1){
                dy[i] = dy[i-2] + dy[i-3];
            }
        }
        return dy[n-1];
    }
    public static void main(String[] args) throws IOException{
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(M.solution(n));
        }
    }
}