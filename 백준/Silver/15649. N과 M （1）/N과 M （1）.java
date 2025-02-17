import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        arr = new int[m];
        ch = new boolean[n];

        perm(0, 0);
    }

    private static void perm(int L, int count) {
        // 가지치기: 남은 숫자의 개수가 부족하면 탐색 중단
        if (n - count < m - L) return;

        if (L == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                ch[i] = true;
                arr[L] = i + 1;
                perm(L + 1, count + 1);
                ch[i] = false;
            }
        }
    }
}
