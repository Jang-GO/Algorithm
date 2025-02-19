import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int max_area = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
                if(map[i][j] == 1) max_area=1;
            }
        }
        solution();
        System.out.println(max_area);
    }

    private static void solution() {
        for (int y = 1; y < n; y++) {
            for (int x = 1; x < m; x++) {
                if (map[y][x] != 0) {
                    map[y][x] = Math.min(map[y - 1][x], Math.min(map[y][x - 1], map[y - 1][x - 1])) + 1;
                    max_area = Math.max(max_area, map[y][x] * map[y][x]);
                }
            }
        }
    }
}
