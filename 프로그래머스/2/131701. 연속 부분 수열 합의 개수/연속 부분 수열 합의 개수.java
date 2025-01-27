import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a:elements){
            map.put(a,1);
        }
        int[] newArr = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
            newArr[i + elements.length] = elements[i];
        }
        
        for(int i=1;i<=elements.length;i++){
            for(int j=0;j<elements.length;j++){
                int sum = 0;
                for(int k=0;k<i;k++){
                    sum += newArr[j + k];
                }
                map.put(sum,1);
            }
        }
        
        int sum = 0;
        for(int a:map.values()){
            sum+=a;
        }
        return sum;
    }
}