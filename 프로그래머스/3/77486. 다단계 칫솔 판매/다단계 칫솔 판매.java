import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> tree = new HashMap<>();
        Map<String, Integer> profit = new HashMap<>();
        
        for(int i=0;i<enroll.length;i++){
            tree.put(enroll[i], referral[i]);
        }        
        
        for(int i=0;i<seller.length;i++){
            int money = amount[i]*100;
            String curName = seller[i];
            
            while(money > 0 && !curName.equals("-")){
                profit.put(curName, profit.getOrDefault(curName, 0) + (money - (money/10)));
                curName = tree.get(curName);
                money /= 10;
            }
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0;i<answer.length;i++){
            if(!profit.containsKey(enroll[i])) answer[i] = 0;
            else answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
}