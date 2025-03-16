class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            String ss = i2bs(numbers[i]);
            if(canMakeTree(ss)) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
    
    private boolean canMakeTree(String str){
        return makeTree(str, 0, str.length()-1);
    }
    
    private boolean makeTree(String str, int lt, int rt){
        if(lt >= rt) return true;
        int mid = (lt + rt) / 2;
        if(str.charAt(mid) == '0'){
            for(int i=lt; i<=rt;i++){
                if(str.charAt(i) == '1') return false;
            }
        }
        
        return makeTree(str, lt, mid-1) && makeTree(str, mid+1, rt);
    }
    
    private String i2bs(long number){
        StringBuilder sb = new StringBuilder();
        while(number>0){
            sb.append(number%2);
            number/=2;
        }
        int length = sb.length();
        // 포화 이진트리 길이 찾고 맞춰주기
        int len = 1;
        while(len < length){
            len = len * 2 + 1;
        }
        sb.reverse();
        
        return "0".repeat(len-sb.length()) + sb.toString();
    }
}