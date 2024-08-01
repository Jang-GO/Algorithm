import java.util.*;

class Solution{
    public int solution(String s){
        Stack<String> st = new Stack<>();
        int answer=0;
        
        for(String ss:s.split("")){
            if(st.isEmpty()) st.push(ss);
            else{
                String tar = st.peek();
                if(tar.equals(ss)) st.pop();
                else st.push(ss);
            }
        }
        
        if(st.isEmpty()) answer = 1;
        return answer;
    }
}