class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long aa = x;
        int idx=0;
        while(idx<n){
            answer[idx]=aa;
            aa+=x;
            idx++;
        }
        return answer;
    }
}