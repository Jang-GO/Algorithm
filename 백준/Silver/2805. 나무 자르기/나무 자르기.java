import java.util.*;
import java.io.*;

class Main{
    private static int solution(int n, int m, int[] arr){
        Arrays.sort(arr);
        int answer = 0;
        int lt = 0;
        int rt = arr[n-1];
        
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(cut(mid, arr) >= m){
                answer = mid;
                lt = mid+1;
            }else{
                rt = mid-1;
            }
        }
        
        return answer;
    }
    
    private static long cut(int mid, int[] arr){
        long sum = 0;
        for(int target : arr) if(target > mid) sum+=(target-mid);
        return sum;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        
        for(int i=0;st.hasMoreTokens();i++) arr[i] = Integer.parseInt(st.nextToken());
        
        System.out.println(solution(n,m,arr));
    }
}