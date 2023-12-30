import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유효한팰린드롬 {
    public static void main(String[] args) throws IOException{
        유효한팰린드롬 T = new 유효한팰린드롬();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
    public String solution(String input){
        String answer="YES";
        String ss = input.toUpperCase().replaceAll("[^A-Z]","");
        StringBuilder sb = new StringBuilder(ss);
        if(ss.equals(sb.reverse().toString())) return answer;
        else return "NO";
    }
}
