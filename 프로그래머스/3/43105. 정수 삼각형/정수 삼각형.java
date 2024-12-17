import java.util.*;

class Solution {
    private final int[][] mem = new int[501][501];
    public int solution(int[][] triangle) {
        for(int[] arr:mem){
            Arrays.fill(arr, -1);            
        }
        return DFS(0,0, triangle);
    }
    
    public int DFS(int x, int y, int[][] triangle){
        if(mem[y][x] != -1) return mem[y][x];
        if(y==triangle.length) return 0;
        
        return mem[y][x] = triangle[y][x] + Math.max(DFS(x, y+1,triangle), DFS(x+1, y+1, triangle));
    } 
}