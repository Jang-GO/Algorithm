import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int S = 0; // 비트마스킹을 활용한 집합

        int M = Integer.parseInt(br.readLine()); // 연산 개수

        while (M-- > 0) {
            String[] command = br.readLine().split(" ");
            String op = command[0];

            if (op.equals("all")) {
                S = (1 << 20) - 1;
            } else if (op.equals("empty")) {
                S = 0;
            } else {
                int x = Integer.parseInt(command[1]) - 1; 
                switch (op) {
                    case "add":
                        S |= (1 << x);
                        break;
                    case "remove":
                        S &= ~(1 << x);
                        break;
                    case "check":
                        sb.append((S & (1 << x)) != 0 ? "1\n" : "0\n");
                        break;
                    case "toggle":
                        S ^= (1 << x);
                        break;
                }
            }
        }

        System.out.print(sb);
    }
}
