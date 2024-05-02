import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String,Integer> fMap = new HashMap<>();
        int[][] giftMap = new int[friends.length][friends.length];
        int[] giftPoint = new int[friends.length];
        int[] takeGift = new int[friends.length];
        
        for(int i=0;i<friends.length;i++){
            fMap.put(friends[i], i);
        }
        
        for(int i=0;i<gifts.length;i++){
            String[] ss = gifts[i].split(" ");
            int giver = fMap.get(ss[0]);
            int receiver = fMap.get(ss[1]);
            
            giftMap[giver][receiver]++;
            giftPoint[giver]++;
            giftPoint[receiver]--;
        }
        
        for(int i=1;i<friends.length;i++){
            for(int j=0;j<i;j++){
                if(i==j) continue;
                if(giftMap[i][j]>giftMap[j][i]) takeGift[i]++;
                else if(giftMap[i][j]<giftMap[j][i]) takeGift[j]++;
                else{
                    if(giftPoint[i]>giftPoint[j]) takeGift[i]++;
                    else if(giftPoint[i]<giftPoint[j]) takeGift[j]++;
                }
            }
        }
        Arrays.sort(takeGift);
        return takeGift[takeGift.length-1];
    }
}