import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> cntMap = new HashMap<>();
        String tmp =""; 
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='}') continue;
            else if(s.charAt(i)==','){
                cntMap.put(tmp, cntMap.getOrDefault(tmp, 0) + 1);
                tmp = "";
            }else{
                tmp+=s.charAt(i);
            }
        }
        cntMap.put(tmp, cntMap.getOrDefault(tmp, 0)+1);
        
        int max = cntMap.size();
        int[] answer = new int[max];
        
        for(int i=0;i<answer.length;i++){
            for(String ss: cntMap.keySet()){
                if(cntMap.get(ss) == max) answer[i] = Integer.parseInt(ss);
            }          
            max--;
        }
        
        return answer;
    }
}