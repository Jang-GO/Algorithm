import java.util.*;
import java.io.*;

class Main{
    private static int solution(int n, int k, int[] arr){
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for(int i=0;i<k;i++) answer+=arr[i];
        sum = answer;
        
        for(int rt = k;rt<n;rt++){
            sum-=arr[lt++];
            sum+=arr[rt];
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++) arr[i] = Integer.parseInt(st.nextToken());
        
        System.out.println(solution(n,k,arr));
	}
}