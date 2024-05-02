import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] stu_1 = {1,2,3,4,5};
        int[] stu_2 = {2,1,2,3,2,4,2,5};
        int[] stu_3 = {3,3,1,1,2,2,4,4,5,5};
        int[] answer = new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==stu_1[i%5]) answer[0]++;
            if(answers[i]==stu_2[i%8]) answer[1]++;
            if(answers[i]==stu_3[i%10]) answer[2]++;
        }
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        for(int i=0;i<answer.length;i++){
            if(answer[i]==max) list.add(i+1);
        }
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}