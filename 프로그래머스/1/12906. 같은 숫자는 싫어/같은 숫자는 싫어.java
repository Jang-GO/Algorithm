import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int x:arr){
            if(st.peek()!=x) st.push(x);
        }
        for(int i=0;i<st.size();i++){
            list.add(st.get(i));
        }
        return list.stream().mapToInt(x->x).toArray();
    }
}