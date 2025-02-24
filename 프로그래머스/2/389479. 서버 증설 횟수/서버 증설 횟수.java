import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int plusServer = 0;
        List<int[]> server = new ArrayList<>();
        
        for(int i=0;i<24;i++){
            for(int j=server.size()-1;j>=0;j--){
                if(server.get(j)[1] == i) server.remove(j);
            }
            
            int condition = players[i] / m; // 현재 서버의 개수도 고려해야 함
            if(server.size() >= condition) continue;
            
            int pl = condition - server.size();
            for(int j=0;j<pl;j++){ 
                server.add(new int[]{i,i+k});
                plusServer++;
            }
        }
        
        return plusServer;
    }
}