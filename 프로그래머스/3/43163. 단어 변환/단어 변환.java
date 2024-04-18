class Solution {
    static int answer=Integer.MAX_VALUE;
    static int[] ch = new int[50];
    public int solution(String begin, String target, String[] words) {
        DFS(begin,target,words,0);
        if(answer==Integer.MAX_VALUE) return 0;
        else return answer;
    }
    public void DFS(String begin, String target, String[] words, int L){
        if(answer<L) return;
        if(begin.equals(target)){
            answer = Math.min(answer, L);
        }else{
            for(int i=0;i<words.length;i++){
                if(diff1(begin, words[i]) && ch[i]!=1){
                    ch[i]=1;
                    DFS(words[i], target, words, L+1);
                    ch[i]=0;
                }
            }
        }
    }
    public boolean diff1(String a, String b){
        int diff = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
        }
        return (diff==1) ? true : false;
    }
}