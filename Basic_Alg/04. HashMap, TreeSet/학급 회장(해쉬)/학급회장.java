import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 학급회장 {
    public char solution(int N, String str){
        char answer=' ';
        Map<Character, Integer> map = new HashMap<>();
        for(char ss:str.toCharArray()){
            map.put(ss, map.getOrDefault(ss, 0)+1);
        }
        int max=Integer.MIN_VALUE;
        for(char key:map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
                answer = key;
            }
        }
    
        return answer;
        
    }
    public static void main(String[] args) throws IOException{
        학급회장 T = new 학급회장();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(T.solution(N,str));
    }
}
