import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        List<String> path = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        // 티켓을 도착지 알파벳 순서로 먼저 정렬
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        path.add("ICN"); // 항상 ICN에서 출발
        dfs("ICN", tickets, visited, path);

        return path.toArray(new String[0]);
    }

    private boolean dfs(String start, String[][] tickets, boolean[] visited, List<String> path) {
        // 모든 티켓을 사용한 경우, 경로를 구성 완료
        if (path.size() == tickets.length + 1) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets, visited, path)) {
                    return true;
                }
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}