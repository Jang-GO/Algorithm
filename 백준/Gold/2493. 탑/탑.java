import java.util.*;
import java.io.*;

public class Main {
    static int[] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[n];
        answer = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }

        System.out.println(solution(arr));
    }

    private static String solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty()){
                int peekIdx = stack.peek();
                if(arr[peekIdx]<arr[i]) stack.pop();
                else break;
            }
            if(stack.isEmpty()){
                answer[i] = 0;
            }else{
                answer[i] = stack.peek()+1;
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int ss: answer){
            sb.append(ss).append(" ");
        }
        return sb.toString();
    }
}
