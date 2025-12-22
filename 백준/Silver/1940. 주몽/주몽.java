import java.util.*;
import java.io.*;

class Main{
    
    private static int solution(int n, int m, int[] arr){
        Arrays.sort(arr);
        int lt=0, rt = n-1;
        int cnt = 0;
        
        while(lt<rt){
            int tmp = arr[lt] + arr[rt];
            if(tmp > m) rt--;
            else if(tmp < m) lt++;
            else{
                cnt++;
                rt--;
                lt++;
            }
        }
        
        return cnt;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(solution(n,m,arr));
    }
}