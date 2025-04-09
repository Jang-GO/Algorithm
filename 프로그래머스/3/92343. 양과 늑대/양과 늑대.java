import java.util.*;

class Solution {
    static int answer = Integer.MIN_VALUE;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] infoCopy;
    public int solution(int[] info, int[][] edges) {
        // 그래프 초기화
        infoCopy = info;
        for(int i=0;i<info.length;i++) graph.add(new ArrayList<>());
        for(int[] edge: edges) graph.get(edge[0]).add(edge[1]);

        
        DFS(0, 0, 0, new HashSet<Integer>());
        
        return answer;
    }
    
    private void DFS(int ver, int sheep, int wolf, Set<Integer> set){
        for(int canGo: graph.get(ver)) set.add(canGo);
        if(infoCopy[ver] == 0) sheep++;
        else wolf++;
        
        if(wolf >= sheep) return;
        
        answer = Math.max(answer, sheep);
        
        for(int next : set){
            Set<Integer> nextSet = new HashSet<>(set);
            nextSet.remove(next);
            for(int aa : graph.get(next)) nextSet.add(aa);
            
             DFS(next, sheep, wolf, nextSet);
        }
    }
}