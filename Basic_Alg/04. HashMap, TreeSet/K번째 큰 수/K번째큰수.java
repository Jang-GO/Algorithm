import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class K번째큰수 {
    public int solution(int n, int k, int[] arr){
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int answer=-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int l=j+1;l<n;l++){
                    set.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt=0;
        for(int ss:set){
            ++cnt;
            if(cnt==k) answer=ss;
        } 
        return answer;
    }
    public static void main(String[] args) throws IOException{
        K번째큰수 T = new K번째큰수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp1 = br.readLine().split(" ");
        int n = Integer.parseInt(tmp1[0]);
        int k = Integer.parseInt(tmp1[1]);
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(n,k,arr));
    }
}
