import java.util.*;
import java.io.*;

public class 후위식연산 {
    public int solution(String str){
        int answer=0;
        Stack<Integer> st = new Stack<>();
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)) {
                st.push(x-'0');
            }
            else{
                int t1 = st.pop();
                int t2 = st.pop();
                if(x=='+') st.push(t2+t1);
                else if(x=='-') st.push(t2-t1);
                else if(x=='*') st.push(t2*t1);
                else if(x=='/') st.push(t2/t1);
            }
        }
        answer=st.pop();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        후위식연산 T = new 후위식연산();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        System.out.println(T.solution(input));
    }   
}