import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k, w, h;
    static int[][] map;
    static int[][] visited;
    static int[] jump_y = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] jump_x = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Point> qu = new ArrayDeque<>();
        qu.offer(new Point(0, 0, 0, 0));
        visited[0][0] = 0;

        while (!qu.isEmpty()) {
            Point now = qu.poll();

            if (now.y == h - 1 && now.x == w - 1) return now.move_count;

            // 점프 가능 횟수 남아 있을 때
            if (now.jump_cnt < k) {
                for (int j = 0; j < 8; j++) {
                    int ny = now.y + jump_y[j];
                    int nx = now.x + jump_x[j];

                    if (ny >= 0 && ny < h && nx >= 0 && nx < w && map[ny][nx] == 0) {
                        if (visited[ny][nx] > now.jump_cnt + 1) { // 더 적은 점프 횟수로 방문 가능할 때만 방문
                            visited[ny][nx] = now.jump_cnt + 1;
                            qu.offer(new Point(ny, nx, now.jump_cnt + 1, now.move_count + 1));
                        }
                    }
                }
            }

            // 일반 이동
            for (int j = 0; j < 4; j++) {
                int ny = now.y + dy[j];
                int nx = now.x + dx[j];

                if (ny >= 0 && ny < h && nx >= 0 && nx < w && map[ny][nx] == 0) {
                    if (visited[ny][nx] > now.jump_cnt) { // 기존보다 적은 점프 횟수로 방문 가능할 때만 방문
                        visited[ny][nx] = now.jump_cnt;
                        qu.offer(new Point(ny, nx, now.jump_cnt, now.move_count + 1));
                    }
                }
            }
        }
        return -1;
    }

    static class Point {
        int y, x, jump_cnt, move_count;

        Point(int y, int x, int jump_cnt, int move_cnt) {
            this.y = y;
            this.x = x;
            this.jump_cnt = jump_cnt;
            this.move_count = move_cnt;
        }
    }
}
