import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int cnt=0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0;i<queue1.length;i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        if((sum1+sum2)%2==1) return -1;
        
        while(sum1!=sum2){
            if(cnt>(queue1.length+queue2.length) * 2) return -1;
            int tmp=0;
            if(sum1>sum2){
                tmp = q1.poll();
                q2.offer(tmp);
                sum1-=tmp;
                sum2+=tmp;
            }else{
                tmp = q2.poll();
                q1.offer(tmp);
                sum2-=tmp;
                sum1+=tmp;
            }
            cnt++;
        }
        return cnt;
    }
}