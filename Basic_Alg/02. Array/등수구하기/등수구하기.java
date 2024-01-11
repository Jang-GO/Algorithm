import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 등수구하기 {
    public int[] solution(int[] arr){
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[arr.length];
        for(int ss:arr){
            list.add(ss);
        }
        list.sort(Comparator.reverseOrder());

        for(int i=0;i<answer.length;i++){
            answer[i] =list.indexOf(arr[i])+1; 
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        등수구하기 T = new 등수구하기();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int i=0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        
        for(int ss:T.solution(arr)){
            System.out.print(ss + " ");
        }
    }
}
