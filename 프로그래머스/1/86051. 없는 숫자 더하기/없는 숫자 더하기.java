class Solution {
    public int solution(int[] numbers) {
        int sum=0;
        for(int i=1;i<10;i++){
            boolean flag = false;
            for(int ss:numbers){
                if(ss==i) flag = true;
            }
            if(!flag) sum+=i;
        }
        return sum;
    }
}