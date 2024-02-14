import java.util.*;
import java.io.*;

class Main {
    static boolean flag = false;

    public static String solution(String str, String bomb) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            st.push(ch);
            if (st.size() >= bomb.length() && ch == bomb.charAt(bomb.length() - 1)) {
                boolean isBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (st.get(st.size() - (j + 1)) != bomb.charAt(bomb.length() - (j + 1))) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) {
                    for (int j = 0; j < bomb.length(); j++) {
                        st.pop();
                    }
                }
            }
        }

        for (char ch : st) {
            sb.append(ch);
        }

        if (sb.length() == 0) return "FRULA";
        else return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String bomb = br.readLine();
        bw.write(solution(str, bomb));
        bw.flush();
        bw.close();
    }
}
