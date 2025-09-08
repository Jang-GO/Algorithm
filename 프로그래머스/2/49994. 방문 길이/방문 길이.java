import java.util.*;

class Solution {
    private static Map<Character, int[]> map = new HashMap<>();
    
    public int solution(String dirs) {
        init();
        int y=5, x=5;
        Set<String> answer = new HashSet<>();
        
        for(char c : dirs.toCharArray()){
            int[] next = map.get(c);
            
            int ny = y + next[0];
            int nx = x + next[1];
            
            if(!isValid(ny,nx)) continue;
            
            answer.add(y+ " " + x + " " + ny + " " + nx);
            answer.add(ny + " " + nx + " " + y + " "+ x);
            y = ny;
            x = nx;
        }
        
        return answer.size()/2;
    }
    
    private void init(){
        map.put('U', new int[]{-1, 0});
        map.put('D', new int[]{1, 0});
        map.put('L', new int[]{0, -1});
        map.put('R', new int[]{0, 1});
    }
    
    private boolean isValid(int ny, int nx){
        return ny >= 0 && ny < 11 && nx>=0 && nx<11;
    }
}