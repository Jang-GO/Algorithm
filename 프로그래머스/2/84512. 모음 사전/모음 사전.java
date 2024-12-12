import java.util.*;

class Solution {
    private final static String[] mo = {"A", "E", "I", "O", "U"};
    private final static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        DFS("");
        return list.indexOf(word)+1;
    }
    
    private static void DFS(String str){
        if(!str.isBlank()) list.add(str);

        if(str.length()==5) return;
        else{
            for(int i=0;i<mo.length;i++){
                DFS(str+mo[i]);
            }
        }
    }
    
}