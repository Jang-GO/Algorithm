import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class 쇠막대기{
    public int solution(String str){
        int cnt=0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') st.push('(');
            else{
                st.pop();
                if(str.charAt(i-1)=='(') cnt+=st.size();
                else cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException{
        쇠막대기 T = new 쇠막대기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
}