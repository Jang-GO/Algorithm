import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        
        // 도착지를 기준으로 사전순 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        sb.append("ICN "); // 시작점인 "ICN"을 StringBuilder에 추가
        DFS("ICN", visited, tickets, 0);
        
        // 결과 문자열을 배열로 변환 (공백 기준 분리)
        String[] answer = sb.toString().trim().split(" ");
        return answer;
    }
    
    private boolean DFS(String start, boolean[] visited, String[][] tickets, int cnt) {
        // 모든 티켓을 사용했다면 경로 완성
        if (cnt == tickets.length) {
            return true;
        }

        // 가능한 다음 공항 찾기
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) { // 아직 사용하지 않은 티켓인지 확인
                visited[i] = true;
                sb.append(tickets[i][1]).append(" "); // 다음 공항 추가
                
                // 다음 경로 탐색
                if (DFS(tickets[i][1], visited, tickets, cnt + 1)) return true;

                // 탐색 실패 시 상태 복구
                sb.delete(sb.length() - (tickets[i][1].length() + 1), sb.length());
                visited[i] = false;
            }
        }

        // 가능한 경로가 없을 경우
        return false;
    }
}