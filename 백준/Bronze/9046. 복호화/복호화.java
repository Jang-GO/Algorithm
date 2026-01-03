import java.util.*;
import java.io.*;

class Main{
    private static char solution(String str){
        int[] alpha = new int[26];
        
        int max = 0;
        for(char c: str.toCharArray()){
            if(c==' ') continue;
            alpha[c-'a']++;
            max = Math.max(max, alpha[c-'a']);
        }
        
        int cnt = 0;
        char answer = ' ';
        for(int i=0;i<26;i++){
            if(max==alpha[i]){
                cnt++;
                answer=(char)('a'+i);
            }
        }
        
        return cnt==1 ? answer : '?'; 
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t=1;t<=T;t++) {
            String str = br.readLine();
            sb.append(solution(str)).append("\n");
        }
        System.out.println(sb);
    }
}