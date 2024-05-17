import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.charAt(n)==s2.charAt(n)){
                    for(int i=0;i<s1.length();i++){
                        if(s1.charAt(i)>s2.charAt(i)) return 1;
                        else if(s1.charAt(i)<s2.charAt(i)) return -1;
                    }
                }
                if(s1.charAt(n)>s2.charAt(n)){
                    return 1;
                }else return -1;
            }
        });
        return strings;
    }
}