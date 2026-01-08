import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
    static BigInteger[][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        mem = new BigInteger[n + 1][m + 1];

        System.out.println(combi(n, m));
    }

    private static BigInteger combi(int n, int r) {
        if (mem[n][r] != null) return mem[n][r];
        if (n == r || r == 0) return mem[n][r] = BigInteger.ONE;

        return mem[n][r] =
                combi(n - 1, r).add(combi(n - 1, r - 1));
    }
}
