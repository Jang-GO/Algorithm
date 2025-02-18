import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n, m, answer = 0;
    static int r, c, d = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1은 벽, 0은 청소 안됨, -1은 청소됨으로
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = -1;
                answer++;
            }

            if (check4way()) {
                d = (d + 3) % 4;
                int ny = r + dy[d];
                int nx = c + dx[d];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 0) {
                    r = ny;
                    c = nx;
                }
            } else {
                int dd = (d + 2) % 4;
                int by = r + dy[dd];
                int bx = c + dx[dd];
                if (by >= 0 && by < n && bx >= 0 && bx < m && map[by][bx] != 1) {
                    r = by;
                    c = bx;
                } else break;
            }
        }

        System.out.println(answer);
    }

    // 청소되지 않은 칸이 있나 확인
    private static boolean check4way() {
        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 0) {
                return true;
            }
        }
        return false;
    }
}
