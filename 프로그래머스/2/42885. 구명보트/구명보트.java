import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0;
        
        for(int rt = people.length-1;lt<=rt; rt--){
            if(people[lt] + people[rt] <= limit) lt++;
            answer++;
        }
        
        
        return answer;
    }
}