import java.util.*;
class Solution {
    public int solution(int n) {
        if(n==1) return 1;
        else if(n==2) return 1;
        int[] arr = new int[n/2+1];
        for(int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        int sum=0;
        int cnt=0;
        int lt =0;
        for(int rt=0;rt<arr.length;rt++){
            sum+=arr[rt];
            if(sum==n) cnt++;
            while(sum>=n){
                sum-=arr[lt++];
                if(sum==n) cnt++;
            }
        }
        
        return cnt+1;
    }
}