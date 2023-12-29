import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 단어뒤집기 {
    public static void main(String[] args) throws IOException{
        단어뒤집기 T = new 단어뒤집기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        for(int i=0;i<input.length;i++){
            input[i] = br.readLine();
        }
        for(String ss:T.solution(input)){
            System.out.println(ss);
        }
    }
    public List<String> solution(String[] str){
        // 1번방식 풀이
        // List<String> list = new ArrayList<>();
        // for(String ss:str){
        //     String tmp = new StringBuilder(ss).reverse().toString();
        //     list.add(tmp);
        // }
        // return list;
        
        //2번방식 풀이
        List<String> list = new ArrayList<>();
        for(String ss:str){
            int lt=0;
            int rt=ss.length()-1;
            String[] ssArr = ss.split("");
            while(lt<rt){
                String tmp = ssArr[lt];
                ssArr[lt] = ssArr[rt];
                ssArr[rt] = tmp;
                lt++;
                rt--;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<ssArr.length;i++){
                sb.append(ssArr[i]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
