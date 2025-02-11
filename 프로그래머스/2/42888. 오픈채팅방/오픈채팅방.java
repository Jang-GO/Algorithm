import java.util.*;

class Solution {
    // 리팩토링
    // 1. foreach -> for with index
    // 2. StringTokenier, StringBuilder
    // 3. msg HashMap 제거
    // 4. 무조건 split() -> 선택적 처리
    public String[] solution(String[] record) {
        HashMap<String, String> uid = new HashMap<>();
        
        for(int i=0;i<record.length;i++){
            char first = record[i].charAt(0);
            if(first == 'E' || first == 'C'){
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken(); // 첫번쨰껀 버림
                uid.put(st.nextToken(), st.nextToken());
            } 
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<record.length;i++){
            char first = record[i].charAt(0);
            if(first == 'E' || first == 'L'){
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                sb.append(uid.get(st.nextToken())).append( first == 'E' ? "님이 들어왔습니다.,":"님이 나갔습니다.,");
            }
        }
         sb.setLength(sb.length() -1); // 전체 문자열 마지막 콤마 제거
        
        return sb.toString().split(",");
    }
    
//     public List<String >solution(String[] record) {
//         List<String> answer = new ArrayList<>();
//         Map<String, String> map = new HashMap<>();
        
//         for(String str: record){
//             String[] strArr = str.split(" ");
//             String command = strArr[0];
//             if(command.equals("Enter") || command.equals("Change")){
//                 map.put(strArr[1], strArr[2]);    
//             }
//         }
        
//         for (String str : record) {
//             String[] strArr = str.split(" ");
//             String command = strArr[0];
            
//             if (command.equals("Enter")) {
//                 answer.add(map.get(strArr[1]) + "님이 들어왔습니다.");
//             } else if (command.equals("Leave")) {
//                 answer.add(map.get(strArr[1]) + "님이 나갔습니다.");
//             }
//         }
        
//         return answer;
//     }
}