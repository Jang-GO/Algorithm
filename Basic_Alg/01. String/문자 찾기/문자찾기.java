import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자찾기 {
    public static void main(String[] args) throws IOException{
        문자찾기 T = new 문자찾기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(T.solution(s,t));
    }
    public int solution(String s, String t){
        s = s.toUpperCase();
        t = t.toUpperCase();
        
        int cnt=0;
        for(String ss:s.split("")){
            if(ss.equals(t)) cnt++;
        }
        return cnt;
    }
}
