class Solution {
    public String solution(String s) {
        String answer = "";
        int aa = s.length();
        boolean isEven = (aa%2==0)? true : false;
        if(isEven){
            answer+= s.charAt(aa/2-1);
            answer+=s.charAt(aa/2);
        }else{
            answer+=s.charAt(aa/2);
        }
        return answer;
    }
}