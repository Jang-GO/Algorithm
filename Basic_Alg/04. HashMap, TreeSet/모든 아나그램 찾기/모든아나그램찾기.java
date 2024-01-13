import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 모든아나그램찾기 {
    public int solution(String str1, String str2){
        int answer=0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char ss:str2.toCharArray()) map2.put(ss, map2.getOrDefault(ss, 0)+1);
        for(int i=0;i<str2.length()-1;i++){
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0)+1);
        }
        int lt=0;
        for(int rt=str2.length()-1;rt<str1.length();rt++){
            map1.put(str1.charAt(rt),map1.getOrDefault(str1.charAt(rt),0)+1);
            if(map1.equals(map2)) answer++;
            map1.put(str1.charAt(lt), map1.get(str1.charAt(lt))-1);
            if(map1.get(str1.charAt(lt))==0) map1.remove(str1.charAt(lt));
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        모든아나그램찾기 T = new 모든아나그램찾기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(T.solution(str1, str2));
    }
}
