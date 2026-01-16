import java.util.*;
import java.io.*;

class Main {
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    // 공기청정기 y1,x1 y2,x2
    static int[] point = new int[4];

    private static int solution(int r, int c, int t, int[][] map){
        int answer = 0;

        for(int sec=0;sec<t;sec++){
            // 확산
            spread(r,c,map);

            // 공기청정기 작동
            wind(r,c,map);
        }

        // 공기청정기 제외 모든 합 구하기
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j] == -1) continue;
                answer+=map[i][j];
            }
        }
        return answer;
    }

    private static void wind(int r, int c, int[][] map) {
        int y1 = point[0];
        int y2 = point[2];

        for(int i=y1;i>0;i--) map[i][0] = map[i-1][0];
        for(int i=0;i<c-1;i++) map[0][i] = map[0][i+1];
        for(int i=0;i<y1;i++) map[i][c-1] = map[i+1][c-1];
        for(int i=c-1;i>1;i--) map[y1][i] = map[y1][i-1];
        map[y1][1] = 0;

        for(int i=y2+1;i<r-1;i++) map[i][0] = map[i+1][0];
        for(int j=0;j<c-1;j++) map[r-1][j] = map[r-1][j+1];
        for(int i=r-1;i>y2;i--) map[i][c-1] = map[i-1][c-1];
        for(int j=c-1;j>1;j--) map[y2][j] = map[y2][j-1];
        map[y2][1] = 0;

        map[y1][0] = -1;
        map[y2][0] = -1;
    }

    private static void spread(int r, int c, int[][] map) {
        int[][] tmp = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j] < 0) continue;
                int cnt = 0;

                for(int d=0;d<4;d++){
                    int ny = i+dy[d];
                    int nx = j+dx[d];

                    if(ny<0 || ny>=r || nx<0 || nx >=c) continue;
                    if(map[ny][nx] == -1) continue;

                    cnt++;
                    tmp[ny][nx] += map[i][j]/5;
                }
                if(cnt==0) continue;

                tmp[i][j] -= (map[i][j]/5*cnt);
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) map[i][j] += tmp[i][j];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        int a = 0;

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == -1){
                    point[a] = i;
                    point[a+1] = j;
                    a+=2;
                }
                map[i][j] = val;
            }
        }

        System.out.println(solution(r,c,t,map));
    }
}