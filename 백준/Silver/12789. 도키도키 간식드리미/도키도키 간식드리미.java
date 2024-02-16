import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.*;

public class Main {
    private static final String NICE = "Nice";
    private static final String SAD = "Sad";
    static int n;

    public static String solution(Stack<Integer> st){
        Stack<Integer> sideSt = new Stack<>();
        int target = 1;
        while(!st.isEmpty()){
            if(st.peek()==target){
                st.pop();
                target++;
            }else if(!sideSt.isEmpty() && sideSt.peek()==target){
                sideSt.pop();
                target++;
            }else{
                sideSt.push(st.pop());
            }
        }
        while(!sideSt.isEmpty()){
            int tmp = sideSt.pop();
            if(sideSt.isEmpty()) break;
            if(sideSt.peek()<tmp) return SAD;
        }
        return NICE;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer stn = new StringTokenizer(br.readLine());
        for(int i=arr.length-1;i>=0;i--){
            arr[i] = Integer.parseInt(stn.nextToken());
        }
        Stack<Integer> st = new Stack<>();
        for(int x:arr) st.push(x);
        System.out.println(solution(st));
    }
}
