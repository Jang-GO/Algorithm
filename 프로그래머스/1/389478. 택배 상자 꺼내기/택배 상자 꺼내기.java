import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int height = n/w+1;
        int[][] arr = new int[height][w];
        boolean forward = true;
        int tmp = 1;
        
        for(int i=height-1;i>=0;i--){
            // 정방향
            if(forward){
                for(int j=0;j<w;j++){
                    arr[i][j] = tmp++;
                }
                forward = !forward;
            }else{
                for(int j=w-1;j>=0;j--){
                    arr[i][j] = tmp++;
                }
                forward = !forward;
            }
        }
        for(int i=0;i<w;i++){
            int cnt = 0;
            for(int j=0;j<height;j++){
                if(arr[j][i]>n) continue;
                
                if(arr[j][i] == num) return cnt+1;
                else cnt++;
            }
        }
        return -1;
    }
}