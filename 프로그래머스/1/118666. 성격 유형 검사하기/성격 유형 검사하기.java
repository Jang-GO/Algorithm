import java.util.*;

class Solution {
    // 1, 7 => 3
    // 2, 6 => 2
    // 3, 5 => 1
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        String[] alphaSet = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> map = new HashMap<>();
        for(String s:alphaSet){
            map.put(s,0);
        }
        for(int i=0;i<survey.length;i++){
            String[] tmp = survey[i].split("");
            if(choices[i]>4){
                map.put(tmp[1], map.get(tmp[1])+choices[i]-4);
            }else if(choices[i]<4){
                int[] score = {0,3,2,1};
                map.put(tmp[0], map.get(tmp[0])+score[choices[i]]);
            }
        }
        
        for(int i=0;i<8;i+=2){
            if(map.get(alphaSet[i])>map.get(alphaSet[i+1])){
                sb.append(alphaSet[i]);
            }else if(map.get(alphaSet[i])<map.get(alphaSet[i+1])){
                sb.append(alphaSet[i+1]);
            }else{
                if(alphaSet[i].compareTo(alphaSet[i+1])>0) sb.append(alphaSet[i+1]);
                else sb.append(alphaSet[i]);
            }
        }
        
        return sb.toString();
    }
}