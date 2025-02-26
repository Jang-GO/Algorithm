import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;st.hasMoreTokens();i++) arr[i] = Integer.parseInt(st.nextToken());

        solution(n,arr);

        StringBuilder sb = new StringBuilder();
        for(int a:answer) sb.append(a).append(" ");
        System.out.println(sb);
    }

    private static void solution(int n, int[] arr){
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(answer, -1);

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                answer[st.pop()] = arr[i];
            }
            st.push(i);
        }
    }
}
