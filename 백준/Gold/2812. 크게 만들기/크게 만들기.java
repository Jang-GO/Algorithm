import java.io.*;
import java.util.*;
public class Main {
    public static String solution(String arr, int n, int k) {
        StringBuilder answer = new StringBuilder();
        int cnt = k;
        Stack<Character> st = new Stack<>();
        st.push(arr.charAt(0));
        for (int i = 1; i < n; i++) {
            char tmp = arr.charAt(i);
            while (!st.isEmpty() && st.peek() < tmp && cnt > 0) {
                st.pop();
                cnt--;
            }
            st.push(tmp);
        }
        
        // 남은 제거 횟수로 스택에서 문자를 제거
        while (cnt > 0 && !st.isEmpty()) {
            st.pop();
            cnt--;
        }

        // 스택에서 문자열로 변환
        while (!st.isEmpty()) {
            answer.insert(0, st.pop());
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        String arr = br.readLine();
        bw.write(solution(arr, n, k));
        bw.flush();
        bw.close();
        br.close();
    }
}
