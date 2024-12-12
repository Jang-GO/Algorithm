class Solution {
    public int[] solution(int n) {
        int[][] board = new int[n][n];
        
        int tar = 1;
        int x=0; 
        int y=0;
        
        while(true){
            // 아래로 이동
            while(true){
                board[y][x] = tar++;
                if(y+1 == n || board[y+1][x] != 0) break;
                y+=1;
            }
            if(x+1 == n || board[y][x+1] !=0) break;
            x+=1;
            // 오른쪽
            while(true){
                board[y][x] = tar++;
                if(x+1 == n || board[y][x+1] != 0) break;
                x+=1;
            }
            if(board[y-1][x-1] != 0) break;
            y-=1;
            x-=1;
            // 왼쪽
            while(true){
                board[y][x] = tar++;
                if(board[y-1][x-1] !=0) break;
                y-=1;
                x-=1;
            }
            if(y+1 ==n || board[y+1][x] != 0) break;
            y+=1;
        }
        
        int[] answer = new int[tar-1];
        int index = 0;
    
        for(int i=0; i<n;i++){
            for(int j=0;j<=i;j++){
                answer[index++] = board[i][j];            
            }
        }
        
        return answer;
    }
}