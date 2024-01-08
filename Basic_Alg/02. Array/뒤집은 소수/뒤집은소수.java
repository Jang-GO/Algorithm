import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집은소수 {
    public static void main(String[] args) throws IOException{
        뒤집은소수 T = new 뒤집은소수();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] =Integer.parseInt(tmp[i]);
        }
        System.out.println(T.solution(arr));
    }
    public String solution(int[] arr){
        String answer="";
        for(int i=0;i<arr.length;i++){
            int t=0;
            int x = arr[i];
            while(x!=0){
                t = t*10 + x%10;
                x/=10;
            }
            if(isPrime(t)){
                answer+=t;
                answer+=" ";
            }
        }
        return answer;
    }
    private static boolean isPrime(int t){
        if(t==1) return false;
        for(int i=2;i<t;i++){
            if(t%i==0) return false;
        }
        return true;
    }
}
