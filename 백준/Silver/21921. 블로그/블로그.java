import java.util.*;
import java.io.*;

class Main{
    private static final String SAD = "SAD";
    
    private static String solution(int n, int x, int[] arr){
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int people = 1;
        
        for(int i=0;i<x;i++){
            sum+=arr[i];
        }
        max = sum;
        
        int lt = 0;
        
        for(int rt=x;rt<n;rt++){
            sum-=arr[lt++];
            sum+=arr[rt];
            
            if(sum > max){
                people = 1;
                max = sum;
            }else if(max == sum){
                people++;
            }
        }
        
        if(max==0) return SAD;
        else{
            sb.append(max).append("\n").append(people);
            return sb.toString();
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(solution(n,x,arr));
	}
}