import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        List<Deque<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<board.length;i++){
            Deque<Integer> target = new ArrayDeque<>();
            list.add(target);
            for(int j=board[i].length-1;j>=0;j--){
                if(board[j][i] != 0) target.push(board[j][i]);
            }
        }
        
        
        for(int i=0;i<moves.length;i++){
            int targetIdx = moves[i]-1;
            Deque<Integer> target = list.get(targetIdx);
            if(target.isEmpty()) continue;
            int next = target.pop();
            
            if(!dq.isEmpty() && next == dq.peek()){
                dq.pop(); answer+=2;
            }else dq.push(next);
        
        }
        
        return answer;
    }
}