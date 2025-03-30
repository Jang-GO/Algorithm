import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static Map<Integer, String> directionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 2;
        }
        int L = Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String v = st.nextToken();
            directionMap.put(k,v);
        }

        int answer = gameStart(1,1);
        System.out.println(answer);
    }

    private static int gameStart(int y, int x){
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{y, x});
        map[y][x] = 1;

        int sec = 0;
        int dir = 1;

        while(true){
            sec++;
            int ny = snake.peekLast()[0] + dy[dir];
            int nx = snake.peekLast()[1] + dx[dir];

            if(ny <= 0  ||  ny > n || nx <= 0 || nx > n || map[ny][nx] == 1) break;

            if(map[ny][nx] == 2){
                map[ny][nx] = 1;
                snake.offer(new int[]{ny,nx});
            }else{
                map[ny][nx] = 1;
                int[] poll = snake.poll();
                map[poll[0]][poll[1]] = 0;

                snake.offer(new int[]{ny,nx});
            }

            if(directionMap.containsKey(sec)){
                String next = directionMap.get(sec);
                if(next.equals("D")) dir = (dir + 1)%4;
                else dir = (dir+3)%4;
            }

        }

        return sec;
    }
}
