import java.util.*;
import java.io.*;

class Main{
    private static String solution(int n, int[] arr){
        Deque<Integer> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int num = 1;
        
        while(idx < n){
            if(st.isEmpty() || arr[idx] >= num){
                st.push(num++);
                sb.append("+").append("\n");
            }else if(st.peek() != null && arr[idx] == st.peek()){
                st.pop();
                sb.append("-").append("\n");
                idx++;
            }else{
                return "NO";
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(br.readLine());
        System.out.println(solution(n, arr));
    }
}