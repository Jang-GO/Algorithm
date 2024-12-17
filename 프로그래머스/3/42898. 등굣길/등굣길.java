import java.util.*;

class Solution {
    private final int[][] mem = new int[101][101];
    
    public int solution(int m, int n, int[][] puddles) {
        for(int[] row: mem){
            Arrays.fill(row, -1);
        }
        
        int[][] board = new int[n+1][m+1];
        for(int[] water:puddles){
            board[water[1]][water[0]] = -1;
        }
        
        return DFS(1,1,m,n,board);
        
    }
    
    public int DFS(int x, int y, int m, int n, int[][] board){
        if(y > n || x > m) return 0;
        if(board[y][x] == -1) return 0;
        
        if(mem[y][x] != -1) return mem[y][x];
        if(y == n && x == m) return 1;
        
        int total = DFS(x, y+1, m,n,board) + DFS(x+1, y, m,n,board);
        return mem[y][x] = (total % 1000000007);
    }
}