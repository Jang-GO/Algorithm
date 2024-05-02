import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int[] todayArr = new int[3];
        HashMap<String, Integer> termsMap = new HashMap<>();
        String[][] privaciesArr = new String[privacies.length][4];
        
        String[] tt = today.split("\\.");
        for(int i=0;i<tt.length;i++) todayArr[i] = Integer.parseInt(tt[i]);
        for(int i=0;i<terms.length;i++){
            String[] ss = terms[i].split(" ");
            termsMap.put(ss[0], Integer.parseInt(ss[1]));
        }
        for(int i=0;i<privacies.length;i++){
            String[] arr = privacies[i].split(" ");
            privaciesArr[i][3] = arr[1];
            String[] arr2 = arr[0].split("\\.");
            for(int j=0;j<3;j++){
                privaciesArr[i][j] = arr2[j];
            }   
        }
        for(int i=0;i<privacies.length;i++){
            int year = Integer.parseInt(privaciesArr[i][0]);
            int month = Integer.parseInt(privaciesArr[i][1]);
            int day = Integer.parseInt(privaciesArr[i][2]);
            int plusMonth = termsMap.get(privaciesArr[i][3]);
            
            if(month+plusMonth>12){
                month += plusMonth;
                while (month > 12) {
                    year++;
                    month -= 12;
                }
                if(day==1){
                    month-=1;
                    day=28;
                }else{
                    day-=1;
                } 
            }else{
                month+=plusMonth;
                if(day==1){
                    month-=1;
                    day=28;
                }else{
                    day-=1;
                }
            }
            if (todayArr[0] > year || 
                (todayArr[0] == year && todayArr[1] > month) || 
                (todayArr[0] == year && todayArr[1] == month && todayArr[2] > day)) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}