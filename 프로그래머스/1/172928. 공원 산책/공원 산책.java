import java.util.*;
class Solution {
    static int[] answer = new int[2];
    public int[] solution(String[] park, String[] routes) {
        // board 초기화
        String[][] board = new String[park.length][park[0].length()];
        for(int i=0;i<park.length;i++){
            board[i] = park[i].split("");
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j].equals("S")){
                    BFS(i,j,board,routes);
                    break;
                }
            }
        }
        return answer;
    }
    
    private void BFS(int startX, int startY, String[][] board, String[] routes) {
        int curX = startX;
        int curY = startY;

        for (String route : routes) {
            String[] tmp = route.split(" ");
            String dir = tmp[0];
            int dist = Integer.parseInt(tmp[1]);

            int nextX = curX;
            int nextY = curY;
            boolean canMove = true;

            for (int i = 0; i < dist; i++) {
                switch (dir) {
                    case "N": nextX--; break;
                    case "S": nextX++; break;
                    case "W": nextY--; break;
                    case "E": nextY++; break;
                }

                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length 
                    || board[nextX][nextY].equals("X")) {
                    canMove = false;
                    break;
                }
            }

            // 이동이 가능한 경우에만 현재 위치 업데이트
            if (canMove) {
                curX = nextX;
                curY = nextY;
            }
        }

        answer[0] = curX;
        answer[1] = curY;
    }
}