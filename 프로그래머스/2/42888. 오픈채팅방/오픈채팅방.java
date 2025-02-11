import java.util.*;

class Solution {
    public List<String >solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        
        for(String str: record){
            String[] strArr = str.split(" ");
            String command = strArr[0];
            if(command.equals("Enter") || command.equals("Change")){
                map.put(strArr[1], strArr[2]);    
            }
        }
        
        for (String str : record) {
            String[] strArr = str.split(" ");
            String command = strArr[0];
            
            if (command.equals("Enter")) {
                answer.add(map.get(strArr[1]) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                answer.add(map.get(strArr[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer;
    }
}