
import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point {
        int x, y, time;

        Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];
            Queue<Point> fireQ = new LinkedList<>();
            Queue<Point> personQ = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '*') fireQ.add(new Point(i, j, 0));
                    else if (map[i][j] == '@') {
                        personQ.add(new Point(i, j, 0));
                        visited[i][j] = true;
                    }
                }
            }

            int result = bfs(fireQ, personQ);
            sb.append(result == -1 ? "IMPOSSIBLE" : result).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(Queue<Point> fireQ, Queue<Point> personQ) {
        while (!personQ.isEmpty()) {
            // 1. 불 먼저 퍼짐
            int fireSize = fireQ.size();
            for (int i = 0; i < fireSize; i++) {
                Point fire = fireQ.poll();

                for (int d = 0; d < 4; d++) {
                    int ny = fire.y + dy[d];
                    int nx = fire.x + dx[d];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                    if (map[ny][nx] == '.' || map[ny][nx] == '@') {
                        map[ny][nx] = '*';
                        fireQ.add(new Point(ny, nx, fire.time + 1));
                    }
                }
            }

            // 2. 상근이 이동
            int personSize = personQ.size();
            for (int i = 0; i < personSize; i++) {
                Point p = personQ.poll();

                for (int d = 0; d < 4; d++) {
                    int ny = p.y + dy[d];
                    int nx = p.x + dx[d];

                    // 탈출 조건: 맵 밖으로 나가면
                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                        return p.time + 1;
                    }

                    // 이동 조건
                    if (!visited[ny][nx] && map[ny][nx] == '.') {
                        visited[ny][nx] = true;
                        personQ.add(new Point(ny, nx, p.time + 1));
                    }
                }
            }
        }

        return -1; // 탈출 못함
    }
}
