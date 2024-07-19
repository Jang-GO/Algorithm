import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> Xcnt = new HashMap<>();
        Map<String, Integer> Ycnt = new HashMap<>();
        
        String[] Xarr = X.split("");
        String[] Yarr = Y.split("");
        
        for(int i=0;i<X.length();i++){
            Xcnt.put(Xarr[i], Xcnt.getOrDefault(Xarr[i],0) +1);
        }
        for(int i=0;i<Y.length();i++){
            Ycnt.put(Yarr[i], Ycnt.getOrDefault(Yarr[i],0) +1);
        }
        
        for(int i=9;i>=0;i--){
            String tmp = String.valueOf(i);
            if(Xcnt.containsKey(tmp) && Ycnt.containsKey(tmp)){
                int min = Math.min(Xcnt.get(tmp), Ycnt.get(tmp));
                for(int j=0;j<min;j++){
                    sb.append(i);
                }
            }
        }
        String answer = sb.toString();
        if(answer.length()==0) return "-1";
        if(allZero(answer)) return "0";
        return answer;
    } 
    
    private static boolean allZero(String answer){
        for(int i=0;i<answer.length();i++){
            char tt = answer.charAt(i);
            if(tt!='0'){
                return false;
            }
        }
        return true;
    }
}