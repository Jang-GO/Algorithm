class Solution {
    // 1+2+4+5
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i=0;i<targets.length;i++){
            int cnt=0;
            char[] tarArr = targets[i].toCharArray();
            for(char ss:tarArr){
                int min = Integer.MAX_VALUE;
                for(String str:keymap){
                    int ii = str.indexOf(ss);
                    if(ii!=-1 && (ii+1<min)) min = (ii+1);
                }
                if(min == Integer.MAX_VALUE){
                    cnt= -1;
                    break;
                }
                else cnt+=min;
            }
            answer[i] = cnt;
            cnt=0;
        }
        
        return answer;
    }
}