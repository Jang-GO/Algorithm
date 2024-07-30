import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] tmp = s.split(" ");
        
        if(tmp.length==2) return sb.append(tmp[0]).append(" ").append(tmp[1]).toString();
        
        int max = Arrays.stream(tmp).mapToInt(Integer::parseInt).max().getAsInt();
        int min = Arrays.stream(tmp).mapToInt(Integer::parseInt).min().getAsInt();        
        
        return min + " " +  max;
    }
}