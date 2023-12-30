import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복문자제거 {
    public static void main(String[] args) throws IOException{
        중복문자제거 T = new 중복문자제거();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
    public String solution(String input){
        String answer="";
        for(int i=0;i<input.length();i++){
            if(input.indexOf(input.charAt(i))==i) answer+=input.charAt(i);
        }
        return answer;
    }
}
