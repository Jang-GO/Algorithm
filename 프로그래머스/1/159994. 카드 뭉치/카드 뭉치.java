import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> qu = new ArrayDeque<>();
        for(String ss:goal) qu.offer(ss);
        
        int len = qu.size();
        int c1Idx = 0;
        int c2Idx = 0;
        
        for(int i=0;i<len;i++){
            String tmp = qu.poll();
            if(c1Idx < cards1.length && tmp.equals(cards1[c1Idx])) c1Idx++;
            else if (c2Idx < cards2.length && tmp.equals(cards2[c2Idx])) c2Idx ++;
            else return "No";
        }
        
        return "Yes";
        
        // int c1Idx = 0;
        // int c2Idx = 0;
        // for(String ss: goal){
        //     if(c1Idx<cards1.length && cards1[c1Idx].equals(ss)) c1Idx++;
        //     else if(c2Idx<cards2.length && cards2[c2Idx].equals(ss)) c2Idx++;
        //     else return "No";
        // }
        // return "Yes";
    }
}