class Solution {
    public int solution(int n) {
        int answer=0;
        int nCnt = count1(n);
        while(true){
            int tar = ++n;
            if(count1(tar)==nCnt) return tar;
        }
    }
    
    private int count1(int n){
        int result = 0;
        while(n>=1){
            int rest = n%2;
            if(rest==1) result++;
            n/=2;
        }
        return result;
    }
}