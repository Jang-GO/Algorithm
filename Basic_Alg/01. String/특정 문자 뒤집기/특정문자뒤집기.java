import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 특정문자뒤집기 {
    public static void main(String[] args) throws IOException{
        특정문자뒤집기 T = new 특정문자뒤집기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
    public String solution(String input){
        String answer="";
        char[] arr = input.toCharArray();
        int lt=0, rt=input.length()-1;
        while(lt<rt){
            if(!Character.isAlphabetic(arr[lt])) lt++;
            else if(!Character.isAlphabetic(arr[rt])) rt--;
            else{
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                rt--;
                lt++;
            }
        }
        answer=new String(arr);
        return answer;
    }
}
