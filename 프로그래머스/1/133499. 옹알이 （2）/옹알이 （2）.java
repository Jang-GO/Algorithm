import java.util.*;
class Solution {
    private static String[] joka = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String baba:babbling){
            for(String jo:joka){
                if(baba.contains(jo+jo)) continue;
                else baba = baba.replace(jo," ");
            }
            baba = baba.replace(" ", "");
            if(baba.equals("")) answer++;
        }
        return answer;
    }
}