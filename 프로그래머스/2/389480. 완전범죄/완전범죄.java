import java.util.*;
class Solution {
    static int conA, conB;
    static int[][][] dy;
    public int solution(int[][] info, int n, int m) {
        conA = n;
        conB = m;
        dy = new int[40][120][120];
        for(int i=0;i<40;i++){
            for(int j=0;j<120;j++){
                Arrays.fill(dy[i][j], -1);
            }
        }
            
        int answer = DFS(0,0,0,info);
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
    
    private int DFS(int L, int sumA, int sumB,int[][] info){
        if(sumA >= conA || sumB >= conB) return Integer.MAX_VALUE;
    
        if(L==info.length) return sumA;
        
        if (dy[L][sumA][sumB] != -1) return dy[L][sumA][sumB];
        
        int resA = DFS(L+1, sumA+info[L][0], sumB,info);
        int resB = DFS(L+1, sumA, sumB+info[L][1],info);
        
        return dy[L][sumA][sumB] = Math.min(resA, resB);
    }
}