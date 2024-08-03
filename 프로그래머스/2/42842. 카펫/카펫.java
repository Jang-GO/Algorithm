class Solution {
    // yellow는 return 배열의 x-2 * y-2 값과 동일
    // brown + yellow가 x * y를 만족
    public int[] solution(int brown, int yellow) {
        int target = brown + yellow;
        
        for(int w = 1;w<target;w++){
            for(int h=1; h<target;h++){
                int tmp = (w-2)*(h-2);
                if(tmp==yellow && target==w*h){
                    return (w>h) ? new int[]{w,h} : new int []{h,w};
                }
            }
        }
        
        return new int[]{0};
    }
}