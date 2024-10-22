class Solution {
    public long solution(int n) {
        long[] dy = new long[n+2];
        dy[1] = 1;
        dy[2] = 2;
        if(n==1) return dy[1];
        if(n==2) return dy[2];
        
        for(int i=3;i<=n;i++){
            dy[i] = (dy[i-1] + dy[i-2]) %1234567;
        }
        return dy[n];
    }
}