import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축 {
    public static void main(String[] args) throws IOException {
        문자열압축 T = new 문자열압축();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
    public String solution(String str){
        String answer="";
        String s = str;
        // 마지막 원소의 비교를 위한 공백추가
        s= s+" ";
        int cnt=1;
        for(int i=0;i<str.length();i++){
            if(s.charAt(i)==s.charAt(i+1)) cnt++;
            else{
                answer+=s.charAt(i);
                if(cnt!=1) answer+=cnt;
                cnt=1;
            }
        }
        return answer;
    }
}
