import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 아나그램 {
    public String solution(String str1, String str2){
        String answer="YES";
        Map<Character, Integer> map = new HashMap<>();
        for(char ss:str1.toCharArray()){
            map.put(ss, map.getOrDefault(ss, 0)+1);
        }
        for(char ss:str2.toCharArray()){
            if(!map.containsKey(ss) || map.get(ss)==0) answer="NO";
            else{
                map.put(ss, map.get(ss)-1);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        아나그램 T = new 아나그램();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(T.solution(str1, str2));
    }
}
