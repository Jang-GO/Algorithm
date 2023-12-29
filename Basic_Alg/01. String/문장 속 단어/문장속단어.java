import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문장속단어 {
    public static void main(String[] args) throws IOException {
        문장속단어 T = new 문장속단어();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }
    public String solution(String str){
        String[] arr = str.split(" ");
        String answer="";
        int maxLength = 0;
        for(String ss:arr){
            if(ss.length()>maxLength){
                maxLength=ss.length();
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()==maxLength) return arr[i];
        }
        return answer;
    }
}
