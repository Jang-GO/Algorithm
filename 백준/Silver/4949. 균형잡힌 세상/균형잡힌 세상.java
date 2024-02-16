import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.*;

public class Main {
    private static final String YES = "yes";
    private static final String NO = "no";

    public static String solution(String str){
        Stack<Character> st = new Stack<>();
        for(char ss:str.toCharArray()){
            if(ss=='(' || ss=='[') st.push(ss);
            else if(ss==')'){
                if(st.isEmpty() || st.pop()!='(') return NO;
            }else if(ss==']') 
                if(st.isEmpty() || st.pop()!='[') return NO;
        }
        if(!st.isEmpty()) return NO;
        else return YES;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String tmp;
        while(!(tmp = br.readLine()).equals(".")){
            list.add(tmp);
        }
        for(String ss:list) System.out.println(solution(ss));
    }
}
