import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        
        int idx = 0;
        int bridgeWeight = 0;
        int time = 0;
        
        while(idx<truck_weights.length){
            bridgeWeight -= bridge.poll();
            
            int now = truck_weights[idx];
            if(bridgeWeight + now <= weight){
                bridge.offer(now);
                bridgeWeight+=now;
                idx++;
            }else{
                bridge.offer(0);
            }
    
            time++;
        }
        
        while(bridgeWeight > 0){
            bridgeWeight -= bridge.poll();
            time++;
        }
        
        return time;
    }
}