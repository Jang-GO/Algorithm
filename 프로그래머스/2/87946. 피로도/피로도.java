class Solution {
    static int answer = -1;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        DFS(k, dungeons,visited, 0);
        return answer;
    }
    
    private void DFS(int k, int[][] arr, boolean[] visited,int L){
        answer = Math.max(answer, L);

        for (int i = 0; i < arr.length; i++) {
            int req = arr[i][0];
            int con = arr[i][1];

            if (!visited[i] && k >= req) {
                visited[i] = true;
                DFS(k - con, arr, visited, L + 1);
                visited[i] = false;
            }
        }
    }
}