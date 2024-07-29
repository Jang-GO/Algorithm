import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복신고 없애기
        Set<String> reportSet = new HashSet<>();
        for(int i=0;i<report.length;i++){
            reportSet.add(report[i]);
        }
        
        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, List<String>> reportMap = new HashMap<>();
        
        for(int i=0;i<id_list.length;i++){
            reportCnt.put(id_list[i], 0);
            reportMap.put(id_list[i], new ArrayList<>());
        }
        
        for(String ss:reportSet){
            String[] tmp = ss.split(" ");
            String giver = tmp[0];
            String receiver = tmp[1];
            reportCnt.put(receiver, reportCnt.get(receiver)+1);
            reportMap.get(giver).add(receiver);
        }
        // k번이상 신고당한 유저 찾기
        List<String> tmpList = new ArrayList<>();
        for(Map.Entry<String,Integer> aa:reportCnt.entrySet()){
            if(aa.getValue()>=k) tmpList.add(aa.getKey());
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0;i<answer.length;i++){
            String tar = id_list[i];
            int tt = 0;
            List<String> reportList = reportMap.get(tar);
            for(String a:reportList){
                for(String b:tmpList){
                    if(a.equals(b)) tt++;
                }
            }
            answer[i] = tt;
        }
        
        return answer;
    }
}