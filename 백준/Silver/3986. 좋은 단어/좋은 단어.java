import java.util.*;
import java.io.*;

class Main{
    private static int solution(int n, String[] arr){
        int answer = 0;
        Deque<Character> st = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            if(arr[i].length() % 2 != 0) continue;
            
            for(char c : arr[i].toCharArray()){
                if(st.isEmpty()){
                    st.push(c);
                    continue;
                }
                
                if(st.peek() == c) st.pop();
                else st.push(c);
            }
            if(st.isEmpty()) answer++;
            st.clear();
        }
        return answer;
    }
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
        
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = br.readLine();
        }
        
        System.out.println(solution(n, arr));
    }
}