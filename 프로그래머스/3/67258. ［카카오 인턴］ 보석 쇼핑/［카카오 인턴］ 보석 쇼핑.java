import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, gems.length-1};
        
        Set<String> jewelryType = new HashSet<>();
        for(String ss:gems) jewelryType.add(ss);
            
        int target = jewelryType.size();
        
        int lt = 0, rt = 0;
        int min = Integer.MAX_VALUE;
        Map<String, Integer> cntMap = new HashMap<>();  
        
        for(;rt<gems.length;rt++){
            cntMap.put(gems[rt], cntMap.getOrDefault(gems[rt], 0)+1);
            
            for (; cntMap.size() == target; lt++) {
                if (rt - lt < min) {
                    min = rt - lt;
                    answer[0] = lt + 1; 
                    answer[1] = rt + 1;
                }

                cntMap.put(gems[lt], cntMap.get(gems[lt]) - 1);
                if (cntMap.get(gems[lt]) == 0) cntMap.remove(gems[lt]); 
            }
            
        }
        
        return answer;
    }
}