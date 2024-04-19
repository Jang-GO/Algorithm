import java.util.*;
import java.io.*;

class Main{
    static int[] dy;
    public int solution(int n, int[] arr){
        if(n==1) return arr[0];
        int answer=0;
        dy = new int[n];
        dy[0] = arr[0];
        if (n > 1) {
            dy[1] = Math.max(dy[0] + arr[1], arr[1]);
        }
        
        for(int i=2; i<n; i++){
            dy[i] = Math.max(dy[i-1] + arr[i], arr[i]);
        }
        answer = Arrays.stream(dy).max().getAsInt();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }
        System.out.println(T.solution(n, arr));
        
    }
}
