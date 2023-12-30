import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호 {
    public static void main(String[] args) throws IOException{
        암호 T = new 암호();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int letter = Integer.parseInt(br.readLine());
        String input = br.readLine();
        System.out.println(T.solution(letter, input));
    }
    public String solution(int letter, String input){
        String answer="";
        for(int i=0;i<letter;i++){
            String tmp = input.substring(0,7).replace("#","1").replace("*","0");
            int ss = Integer.parseInt(tmp,2);
            answer+=(char)ss;
            input = input.substring(7);
        }
        return answer;
    }
}
