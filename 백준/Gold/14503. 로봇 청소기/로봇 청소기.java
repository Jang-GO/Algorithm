import java.util.*;
import java.io.*;

class Robot{
    int x;
    int y;
    int d;
    Robot(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d; 
    }
}

class Main{
    static int[][] arr;
    static int n,m,answer=1;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public void cleanRoom(Robot robot) throws IOException{
        arr[robot.x][robot.y] = -1;

        for(int i=0;i<4;i++){
            robot.d = (robot.d+3)%4;
            int nx = robot.x+dx[robot.d];
            int ny = robot.y+dy[robot.d];
            if(nx>=0 && nx<n &&ny>=0&& ny<m && arr[nx][ny]==0){
                answer++;
                robot.x = nx;
                robot.y = ny;
                cleanRoom(robot);
                return;
            }
        }

        //탈출하면 4칸 다 청소된거임 => 후진로직
        int dd = (robot.d+2)%4;
        int bx = robot.x + dx[dd];
        int by = robot.y + dy[dd];
        if(bx>=0 && bx<n && by>=0 && by<m && arr[bx][by]!=1){
            robot.x = bx;
            robot.y = by;
            cleanRoom(robot);
        }else return;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        arr = new int[n][m];
        String[] tmp1 = br.readLine().split(" ");
        int x = Integer.parseInt(tmp1[0]);
        int y = Integer.parseInt(tmp1[1]);
        int d = Integer.parseInt(tmp1[2]);
        for(int i=0;i<n;i++){
            String[] tmp2 = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(tmp2[j]);
            }
        }
        Robot robot = new Robot(x, y, d);

        T.cleanRoom(robot);
        System.out.println(answer);
    }
}