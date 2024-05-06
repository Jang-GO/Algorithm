import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
            
        for(int i=0;i<progresses.length;i++){
            int tmp=0;
            if((100-progresses[i])%speeds[i]!=0){
                tmp = (100 - progresses[i])/speeds[i]+1;
            }else tmp = (100-progresses[i])/speeds[i];
            Q.offer(tmp);
        }

        int cnt=1;
        int max = Integer.MIN_VALUE;
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            if(Q.isEmpty()){
                answer.add(cnt);
                break;
            }
            if(tmp>max) max = tmp;
            if(Q.peek()<=max) cnt++;
            else{
                answer.add(cnt);
                max = Integer.MIN_VALUE;
                cnt=1;
            }
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
}