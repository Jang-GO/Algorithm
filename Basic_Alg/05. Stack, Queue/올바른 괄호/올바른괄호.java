import java.io.*;
import java.util.*;

class 올바른괄호{
    public String solution(String str){
        Stack<Character> st = new Stack<>();
        String answer="YES";

        for(char x:str.toCharArray()){
            if(x=='(') st.push(x);
            else{
                if(st.isEmpty()) {
                    answer="NO";
                    break;
                }
                st.pop();
            }
        }
        if(!st.isEmpty()) answer = "NO";
        return answer;
    }
    public static void main(String[] args) throws IOException {
        올바른괄호 T = new 올바른괄호();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
 }