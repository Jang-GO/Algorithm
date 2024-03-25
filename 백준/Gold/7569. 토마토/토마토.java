import java.util.*;
import java.io.*;

class Main{
    static class Point{
        int h;
        int x;
        int y;

        Point(int h, int x, int y){
            this. h = h;
            this.x=x;
            this.y=y;
        }
    }
    static int n,m,h,day=0;
    static int[][][] arr;
    static int[] dh = {0,0,0,0,1,-1};
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,-1,0,1,0,0};

    public void BFS(){
        Queue<Point> Q = new LinkedList<>();
        int cnt=0;
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(arr[i][j][k]==1 || arr[i][j][k]==-1) cnt++;
                }
            }
        }
        if(cnt==(n*m*h)){
            day=1;
            return;
        }
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(arr[i][j][k]==1) Q.offer(new Point(i,j,k));
                }
            }
        }

        while(!Q.isEmpty()){
            int ss = Q.size();
            for(int s=0;s<ss;s++){
                Point tmp = Q.poll();
                for(int i=0;i<6;i++){
                    int nh = tmp.h + dh[i];
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nh >=0 && nh < h &&nx >=0 && nx < n && ny >=0 && ny < m && arr[nh][nx][ny]==0){
                        arr[nh][nx][ny] = 1;
                        Q.offer(new Point(nh,nx,ny));
                    }
                }
            }
            day++;
        }

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(arr[i][j][k]==0){
                        day = 0;
                        return ;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);
        arr = new int[h][n][m];

        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        T.BFS();
        System.out.println(day-1);
    }
}