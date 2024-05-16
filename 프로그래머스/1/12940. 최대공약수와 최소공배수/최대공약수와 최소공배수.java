class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n<m){
            int tmp = n;
            n = m;
            m = tmp;
        }
        answer[0] = GCD(n,m);
        answer[1] = LCM(n,m);
        
        return answer;
    }
    public int GCD(int n, int m){
        if(n%m==0) return m;
        return GCD(m, n%m);
    }
    
    public int LCM(int n, int m){
        return n*m/GCD(n, m);
    }
}