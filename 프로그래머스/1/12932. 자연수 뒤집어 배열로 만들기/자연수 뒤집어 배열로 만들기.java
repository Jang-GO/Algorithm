import java.util.*;
class Solution {
    public long[] solution(long n) {
        List<Long> answer = new ArrayList<>();
        while(n>0){
            answer.add(n%10);
            n/=10;
        }
        
        return answer.stream().mapToLong(Long::longValue).toArray();
    }
}