import java.util.*;
import java.io.*;

class Main{
    static int n, m, t;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    static int gramY, gramX;
    static int[][] map;

    // 그냥 가는게 빠르나 vs 그람을 먹고 최소경로로 가는게 빠르냐를 구해서 비교
    // 용사(1,1) 공주(n,m)

    private static int solution(){
        int answer = -1;
        int just = go(1,1,n,m);
        int gram = go(1,1,gramY,gramX);
        if(gram != -1) gram +=  + goFast(gramY, gramX, n,m);

        if(just == -1 && gram == -1) answer = -1;
        else if(just == -1) answer = gram;
        else if(gram == -1) answer = just;
        else answer = Math.min(gram, just);

        if(answer > t) return -1;
        return answer;
    }

    private static int goFast(int startY, int startX, int endY, int endX){
        return Math.abs(endY-startY) + Math.abs(endX-startX);
    }

    private static int go(int startY, int startX, int endY, int endX){
        boolean[][] visited = new boolean[n+1][m+1];
        Queue<Point> qu = new ArrayDeque<>();
        qu.offer(new Point(startY, startX, 0));
        visited[startY][startX] = true;

        while(!qu.isEmpty()){
            Point now = qu.poll();

            for(int d=0;d<4;d++){
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];

                if(ny < 1 || ny > n || nx < 1 || nx > m) continue;
                if(map[ny][nx] == 1) continue;
                if(visited[ny][nx]) continue;
                if(now.sec+1 > t) continue;

                if(ny == endY && nx == endX) return now.sec+1;

                visited[ny][nx] = true;
                qu.offer(new Point(ny, nx, now.sec+1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                int val = Integer.parseInt(st.nextToken());
                if(val==2){
                    gramY = i;
                    gramX = j;
                }
                map[i][j] = val;
            }
        }

        int answer = solution();
        if(answer==-1) System.out.println("Fail");
        else System.out.println(answer);
    }

    static class Point{
        int y;
        int x;
        int sec;

        Point(int y, int x, int sec){
            this.y = y;
            this.x = x;
            this.sec = sec;
        }
    }
}