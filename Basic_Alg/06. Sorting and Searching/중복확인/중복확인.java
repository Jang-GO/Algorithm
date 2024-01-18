import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 중복확인 {
    public String solution(int n, int[] arr){
        String answer="D";
        Set<Integer> set = new HashSet<>();
        for(int x:arr){
            set.add(x);
        }
        if(set.size()!=arr.length) return answer;
        else return "U";
    }
    public static void main(String[] args) throws IOException{
        중복확인 T = new 중복확인();
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
