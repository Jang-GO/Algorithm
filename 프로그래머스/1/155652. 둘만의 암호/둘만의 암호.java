class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0;i<s.length();i++){
            char ss = s.charAt(i);
            for(int j=0;j<index;j++){
                ss++;
                if(ss>'z') ss-=26;
                if(skip.contains(String.valueOf(ss))) j--;
            }
            answer+=ss;
        }
        
        return answer;
    }
}