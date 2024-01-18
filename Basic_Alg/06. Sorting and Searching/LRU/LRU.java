import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LRU {
    public int[] solution(int s, int n, int[] arr){
        int[] cache = new int[s];
        for(int x : arr){
            boolean con = false;
            for(int i=0;i<s;i++){
                if(cache[i]==x){
                    con = true;
                    break;
                }
            }
            if(con){ // cache hit
                int idx=-1;
                for(int i=0;i<s;i++){
                    if(x==cache[i]){
                        idx = i;
                    }
                }
                for(int i=idx-1;i>=0;i--){
                    cache[i+1] = cache[i];
                }
                cache[0] = x;
            } 
            else{ // cache miss
                for(int i=s-2;i>=0;i--){
                    cache[i+1] = cache[i];
                }
                cache[0] = x;
            }
        }
        return cache;
    }
    public static void main(String[] args) throws IOException {
        LRU T = new LRU();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0;st1.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        for(int x:T.solution(s,n,arr)){
            System.out.print(x + " ");
        }
    }
}
