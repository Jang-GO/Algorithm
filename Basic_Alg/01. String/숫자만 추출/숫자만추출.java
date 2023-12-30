import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 숫자만추출{
    public static void main(String[] args) throws IOException {
        숫자만추출 T = new 숫자만추출();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
    public int solution(String str){
        String answer="";
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                answer+=str.charAt(i);
            }
        }
        return Integer.parseInt(answer);
    }
    
}