class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(count(i)%2==0) answer+=i;
            else answer-=i;
        }
        return answer;
    }
    public int count(int ss){
        if(ss==1) return 1;
        int cnt=2;
        for(int i=2;i<=ss/2;i++){
            if(ss%i==0) cnt++;
        }
        return cnt;
    }
}