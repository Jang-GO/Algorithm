class Solution {
    public int solution(int n) {
        if(n==1) return 0;
        int[] arr = new int[n+1];
        int cnt =0;
        for(int i=2;i<=n;i++){
            if(arr[i]==0){
                cnt++;
                for(int j=i;j<=n;j+=i) arr[j]=1;
            }
        }
        return cnt;
    }
}