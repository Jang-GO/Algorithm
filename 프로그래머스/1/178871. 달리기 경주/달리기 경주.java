import java.util.*;
class Solution {
    // players의 길이는 50000, callings의 길이는 1000000
    // 처음에는 일일히 callings에 매칭되는 players 배열에 접근하여 앞의 인덱스와 swap
    // 탐색해야하는 범위가 너무 많으므로 map을 사용하기로 결정
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> reverseMap = new HashMap<>();
        // map에 {이름, 등수} 저장
        for(int i=0;i<players.length;i++){
            map.put(players[i], i+1);
            reverseMap.put(i+1, players[i]);
        }
        
        for(String called:callings){
            int rank = map.get(called);
            String tradeTarget = reverseMap.get(rank-1);
            
            map.put(called, rank-1);
            map.put(tradeTarget, rank);
            reverseMap.put(rank-1, called);
            reverseMap.put(rank, tradeTarget); 
        }
        
        String[] answer = new String[players.length];
        for(int i=0;i<players.length;i++){
            answer[i] = reverseMap.get(i+1);
        }
        return answer;
    }
}