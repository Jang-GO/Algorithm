class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt =0;
        String[] tmp = s.split("");
        
        int idx=0;
        for(String ss:tmp){
            if(ss.equals(" ")){
                idx=0;
                answer+=" ";
                continue;
            }
            if(idx%2==0) {
                answer+=ss.toUpperCase();
                idx++;
            }
            else {
                answer+= ss.toLowerCase();
                idx++;
            }
        }
        return answer;
    }
}