import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> boardList = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<board.length;i++){
            boardList.add(new Stack<>());
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    boardList.get(j).push(board[i][j]);
                }
            }
        }
    
        for(int ss:moves){
            Stack<Integer> tmpSt = boardList.get(ss-1);
            System.out.println(tmpSt);
            if(!tmpSt.isEmpty()){
                if(!st.isEmpty()){
                    int tmp = st.peek();
                    int stTmp = tmpSt.pop();
                    if(tmp==stTmp){
                        answer+=2;
                        st.pop();
                    }else{
                        st.push(stTmp);
                    }
                }else{
                    st.push(tmpSt.pop());
                }
            }
        }
        return answer;
    }
}