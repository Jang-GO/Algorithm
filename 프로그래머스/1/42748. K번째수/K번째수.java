import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();
        for(int a=0;a<commands.length;a++){
            int i = commands[a][0];
            int j = commands[a][1];
            
            for(int b = i;b<=j;b++){
                list.add(array[b-1]);
            }
            Collections.sort(list);
            answer[a] = list.get(commands[a][2]-1);
            list.clear();
        }
        return answer;
    }
}