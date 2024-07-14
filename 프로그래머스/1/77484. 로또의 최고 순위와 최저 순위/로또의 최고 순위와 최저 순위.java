class Solution { 
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt=0;
        int zeroCnt = 0;
        
        for(int ss:lottos){
            for(int i=0;i<win_nums.length;i++){
                if(ss==0){
                    zeroCnt++;
                    break;
                }
                else if(win_nums[i]==ss) cnt++;
            }
        }
        
        int max = cnt+zeroCnt;
        
        answer[0]=7-max;
        if(answer[0]==7) answer[0]=6;
        answer[1] = 7 - cnt;
        if(answer[1]==7) answer[1]=6;
        
        return answer;
    }
}