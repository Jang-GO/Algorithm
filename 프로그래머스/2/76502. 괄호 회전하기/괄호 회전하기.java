import java.util.*;

class Solution {
    public int solution(String s) {
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(isCorrect(s, i)) cnt++; 
        }
        return cnt;
    }
    
    public boolean isCorrect(String str, int offset){
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt((i+offset) %str.length());
            switch(tmp){
                case '(' -> st.push(')');
                case '{' -> st.push('}');
                case '[' -> st.push(']');
                case ')', ']', '}' -> {
                    if(st.isEmpty()) return false;
                    if(st.pop() != tmp) return false;
                }
            }
        }
        return st.isEmpty();
    }
}