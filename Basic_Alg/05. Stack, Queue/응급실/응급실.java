import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 응급실 {
    public int solution(int n, int m, int[] arr){
        int answer=0;
        Queue<Integer> qu = new LinkedList<>();
        for(int x:arr) qu.offer(x);
        
        return answer;
    }
    public static void main(String[] args) throws IOException{
        응급실 T = new 응급실();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] arr = new int[n];
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp2[i]);
        }
        System.out.println(T.solution(n,m,arr));
    } 
}
