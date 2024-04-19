import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer="";
        for(int i=0;i<participant.length;i++){
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        for(int i=0;i<completion.length;i++){
            if(map.get(completion[i])>0){
                map.put(completion[i],map.get(completion[i])-1);
            }
        }
        for(String ss:map.keySet()){
            if(map.get(ss)==1) answer=ss;
        }
        return answer;
    }
}