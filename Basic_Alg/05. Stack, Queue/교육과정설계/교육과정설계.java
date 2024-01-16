import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정설계 {
    public String solution(String necessary, String sub){
        String answer ="YES";
        Queue<Character> qu = new LinkedList<>();
        String tmp = "";
        for(char ss:sub.toCharArray()){
            qu.offer(ss);
        }
        for(char ss:sub.toCharArray()){
            if(necessary.indexOf(ss)!=-1){
                qu.offer(qu.poll());
            } else qu.poll();
        }
        for(char ss:qu){
            tmp+=ss;
        }
        if(!tmp.equals(necessary)) answer="NO";
        return answer;
    }
    public static void main(String[] args) throws IOException{
        교육과정설계 T = new 교육과정설계();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String necessary = br.readLine();
        String sub = br.readLine();
        System.out.println(T.solution(necessary, sub));
    }
}
