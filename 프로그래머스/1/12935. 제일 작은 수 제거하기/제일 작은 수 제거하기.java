import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1};
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min) min = arr[i];
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==min) continue;
            list.add(arr[i]);
        }
        return list.stream().mapToInt(x->x).toArray();
    }
}