import java.io.*;
import java.util.*;

class Main{
    static int[] arr, dy;
    public int solution(){
        if(arr.length==1) return 1;
        int answer=0;
        dy[0]=1;
        for(int i=1;i<arr.length;i++){
            int max = 0;
            for(int j=i-1; j>=0;j--){
                if(arr[i]>arr[j] && dy[j]>max){
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(dy[i], answer);
        }
        
        return answer;
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dy = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution());
    }
}