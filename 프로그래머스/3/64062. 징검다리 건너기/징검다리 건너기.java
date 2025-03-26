class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int lt = 0;
        int rt = 200_000_000;
        
        while(lt<=rt){
            // 사람 수
            int mid = (lt+rt)/2;
            if(canAllGo(mid, stones, k)){
                answer = mid;
                lt = mid +1;
            }
            else rt = mid -1;
        }
        
        return answer;
    }
    
    private boolean canAllGo(int people, int[] stones, int k){
        int zeroCnt = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i] < people){
                zeroCnt++;
                if(zeroCnt >= k) return false;
            }
            else zeroCnt=0;
        }
        return true;
    }
}