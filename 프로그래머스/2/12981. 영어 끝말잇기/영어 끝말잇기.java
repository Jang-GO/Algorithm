import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        
        int cnt = 1;
        int turn = 1;
        char tmp = words[0].charAt(0);
        for(String ss:words){
            if(ss.charAt(0) != tmp) break;
            else{
                tmp = ss.charAt(ss.length()-1);
            }
            if(list.contains(ss)) break;
            else list.add(ss);
            cnt++;
            if(cnt > n){
                cnt = 1;
                turn++;
            }
        }
        answer[0] = cnt;
        answer[1] = turn;
        
        if(list.size() == words.length) return new int[]{0,0};
        return answer;
    }
}