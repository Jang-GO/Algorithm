import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        
        for(int i=1;i<len;i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int j = stack.pop();
                answer[j] = i-j;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int remain = stack.pop();
            answer[remain] = len - remain - 1;
        }
        
        return answer;
    }
}