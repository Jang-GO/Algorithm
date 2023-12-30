import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문문자열 {
    public static void main(String[] args) throws IOException{
        회문문자열 T = new 회문문자열();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
    public String solution(String input){
        String answer="NO";
        String sb = new StringBuilder(input).reverse().toString();
        if(input.equalsIgnoreCase(sb)) answer="YES";
        return answer;
    }
}
