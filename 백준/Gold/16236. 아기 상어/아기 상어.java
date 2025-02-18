
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Shark[][] map;
    static int n;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static Shark hero;
    static PriorityQueue<int[]> pQ = new PriorityQueue<>((a,b) ->{
        if(a[2] != b[2]) return a[2] - b[2];
        else if(a[0] != b[0]) return a[0] - b[0];
        else return a[1] - b[1];
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new Shark[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp==9) {
                    hero = new Shark(i,j);
                } else if(tmp > 0) map[i][j] = new Shark(i, j, tmp);
            }
        }

        int time = 0;
        while (true) {
            // 탐색
            hero.search();

            int duringTime = hero.eat();

            // 0이면 못가거나 먹을 수 없는거
            if (duringTime == 0) break;

            time += duringTime;
        }

        System.out.println(time);
    }

    static class Shark {
        int y, x;
        int size;
        int cnt;
        boolean isHero;

        // 아기상어 생성자
        Shark(int y, int x) {
            this.y = y;
            this.x = x;
            size = 2;
            cnt = 0;
            isHero = true;
        }


        // 나머지 상어는 크기가 필요
        Shark(int y, int x, int size) {
            this.y = y;
            this.x = x;
            this.size = size;
        }


        public void search() {
            Queue<int[]> Q = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];
            Q.offer(new int[]{this.y, this.x, 0});
            visited[this.y][this.x] = true;
            pQ.clear();

            while (!Q.isEmpty()) {
                int[] shark_loc = Q.poll();
                int time = shark_loc[2];
                for (int i = 0; i < 4; i++) {
                    int ny = shark_loc[0] + dy[i];
                    int nx = shark_loc[1] + dx[i];
                    // 갈수 있을때
                    if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx]) {
                        // 빈공간이거나 같으면 지나갈 수 있음
                        if (map[ny][nx] == null || map[ny][nx].size == this.size) {
                            visited[ny][nx] = true;
                            Q.offer(new int[]{ny, nx, time + 1});

                        }
                        if (map[ny][nx] != null && map[ny][nx].size < this.size) {
                            // 먹을 수 있는 상어임
                            pQ.offer(new int[]{ny, nx, time + 1});
                        }
                    }
                }
            }
        }

        public int eat() {
            if (pQ.isEmpty()) return 0;

            int[] nextShark = pQ.poll();

            map[y][x] = null;
            y = nextShark[0];
            x = nextShark[1];

            map[y][x] = this;
            this.cnt++;

            if (this.cnt == this.size) {
                this.cnt = 0;
                this.size++;
            }

            return nextShark[2];
        }
    }
}
