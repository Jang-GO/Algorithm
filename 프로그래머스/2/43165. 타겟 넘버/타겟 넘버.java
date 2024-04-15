class Solution {
    static int cnt=0;
    static int tar;
    static int[] arr;
    public int solution(int[] numbers, int target) {
        tar = target;
        arr = numbers;
        DFS(0,0);
        int answer = cnt;
        return answer;
    }
    public static void DFS(int sum, int L){
        if(L==arr.length){
            if(sum==tar) cnt++;
        }else{
            DFS(sum+arr[L], L+1);
            DFS(sum-arr[L], L+1);
        }
        
    }
}