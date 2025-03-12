class Solution {
    static int answer = Integer.MAX_VALUE;
    // 루프 방지
    static boolean[] ch = new boolean[50];
    public int solution(String begin, String target, String[] words) {
        // 0번 인덱스를 시작으로 탐색 시작
        DFS(begin, target, words, 0);
        if(answer == Integer.MAX_VALUE) return 0;
        else return answer;
    }
    
    private void DFS(String begin, String target, String[] words, int cnt){
        // 가지치기 : 답보다 커지면 더 이상 볼 필요가 없음
        if(answer < cnt) return;
        
        if(begin.equals(target)) answer = Math.min(answer, cnt);
        else{
            for(int i=0;i<words.length;i++){
                if(diff1(begin, words[i]) && !ch[i]){
                    ch[i] = true;
                    DFS(words[i], target, words, cnt+1);
                    ch[i] = false;
                }
            }
        }
    }
    
    private boolean diff1(String begin, String target){
        int diffCnt = 0;
        for(int i=0;i<begin.length();i++){
            if(begin.charAt(i) != target.charAt(i)) diffCnt++;
        }
        return diffCnt == 1;
    }
}