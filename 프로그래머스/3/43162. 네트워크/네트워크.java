import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                BFS(i,n,visited,computers);
            }
        }
        return answer;
    }
    public void BFS(int i, int n, boolean[] visited, int[][] computers){
        visited[i]=true;
        Queue<Integer>  Q = new LinkedList<>();
        Q.offer(i);
        
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int j=0;j<n;j++){
                if(computers[tmp][j]==1 && !visited[j]){
                    visited[j] = true;
                    Q.offer(j);
                }
            }
        }
    }
}