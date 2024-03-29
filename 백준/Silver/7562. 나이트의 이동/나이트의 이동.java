import java.util.*;
import java.io.*;

class Main{
    static int l, tar_x, tar_y;
    static int[][] board;
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    static int[] answer;

    static class Point{
        int x, y, cnt;
        Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y, 0));
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            if(tmp.x == tar_x && tmp.y == tar_y) return tmp.cnt;
            for(int i=0;i<8;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >= 0 && nx < l && ny >= 0 && ny < l && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny, tmp.cnt + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        answer = new int[T];
        for(int i=0; i<T; i++){
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            String[] night = br.readLine().split(" ");
            int ni_x = Integer.parseInt(night[0]);
            int ni_y = Integer.parseInt(night[1]);
            String[] tar = br.readLine().split(" ");
            tar_x = Integer.parseInt(tar[0]);
            tar_y = Integer.parseInt(tar[1]);
            if(ni_x == tar_x && ni_y == tar_y) continue;
            board[ni_x][ni_y] = 1;
            answer[i] = BFS(ni_x, ni_y);
        }
        for(int i=0;i<T;i++) System.out.println(answer[i]);
    }
}
