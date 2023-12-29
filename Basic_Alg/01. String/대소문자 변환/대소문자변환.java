import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대소문자변환 {
    public static void main(String[] args) throws IOException {
        대소문자변환 T = new 대소문자변환();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
    public String solution(String str){
        // 1번방식
        // char[] a = str.toCharArray();
        // for(int i=0;i<a.length;i++){
        //     if(Character.isUpperCase(a[i])) a[i]=Character.toLowerCase(a[i]);
        //     else a[i]=Character.toUpperCase(a[i]);
        // }
        // String answer = new String(a);
        // return answer;
        
        // 2번방식
        String answer="";
        for(char ss:str.toCharArray()){
            if(ss>=65&& ss<=90){
                answer+=(char)(ss+32);
            } else answer+=(char)(ss-32);
        }
        return answer;

    }
}
