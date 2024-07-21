import java.util.*;
class Solution {
    static int[] targetArr = {1,2,3,1}; 
    public int solution(int[] ingredient) {
        Stack<Integer> st = new Stack<>();
        int answer = 0;
        for(int ss:ingredient){
            st.push(ss);
            if(st.size() >=4){
                int s4 = st.get(st.size()-1);
                int s3 = st.get(st.size()-2);
                int s2 = st.get(st.size()-3);
                int s1 = st.get(st.size()-4);
                if(s1 == 1 && s2 == 2 && s3 == 3 && s4 ==1){
                    answer++;
                    for(int i=0;i<4;i++) st.pop();
                }
            }
        }
        return answer;
    }
}