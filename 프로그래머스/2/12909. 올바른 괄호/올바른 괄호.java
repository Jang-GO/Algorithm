import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        if(s.charAt(0)==')') return false;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') st.push(s.charAt(i));
            else{
                if(st.isEmpty()) return false;
                st.pop();
            }
        }
        
        return (st.size()==0) ? true : false;
    }
}