import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장난꾸러기 {
    public String solution(int n, int[] arr){
        String answer="";
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        
        for(int i=0;i<n;i++){
            if(arr[i]!=tmp[i]){
                answer+=i+1;
                answer+=" ";
            }
        }
        return answer.trim();
    }
    public static void main(String[] args) throws IOException{
        장난꾸러기 T = new 장난꾸러기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n,arr));     
    }
    
}
