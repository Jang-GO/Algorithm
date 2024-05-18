class Solution {
    public int solution(int[] nums) {
        int answer=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])) answer++;
                }
            }
        }
        return answer;
    }
    public boolean isPrime(int n){
        int[] arr = new int[n+1];
        for(int i=2;i<n;i++){
            if(arr[i]==0){
                for(int j=i;j<=n;j+=i) arr[j] = 1;
            }
        }
        if(arr[n]==0) return true;
        else return false;
    }
}