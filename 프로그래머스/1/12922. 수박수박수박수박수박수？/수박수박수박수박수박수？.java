class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        boolean isSu = true;
        for(int i=0;i<n;i++){
            if(isSu){
                sb.append("수");
                isSu = !isSu;
            }else{
                sb.append("박");
                isSu= !isSu;
            }
        }
        return sb.toString();
    }
}