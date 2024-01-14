import java.util.*;
import java.io.*;

public class 괄호문자제거 {
    public String solution(String str){
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char x:str.toCharArray()){
            if(x==')'){
                while(st.pop()!='(');
            }
            else st.push(x);
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) throws IOException {
        괄호문자제거 T = new 괄호문자제거();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
}
