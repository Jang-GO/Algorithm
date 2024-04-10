import java.util.*;
import java.io.*;

class Main{
    static int n,m,start_x,start_y;
    static int[] dice = new int[7];
    static int[][] board;
    static int[] dx ={0,0,-1,1};
    static int[] dy ={1,-1,0,0};

    public static void solution(int go){
        int nx = start_x+dx[go-1];
        int ny = start_y+dy[go-1];
        if(nx>=0 && nx<n && ny>=0 && ny<m){
            rollDice(go,nx, ny);
        }else{
            return;
        }
        start_x = nx;
        start_y = ny;
    }

    public static void rollDice(int go,int x, int y){
        int tmp = dice[1];
        switch(go){
            case 1:
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;
            case 3:
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
            default:
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
        }
        if(board[x][y] == 0){
            board[x][y] = dice[6];
        } else {
            dice[6] = board[x][y];
            board[x][y] = 0;
        }
        
        System.out.println(dice[1]);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        board = new int[n][m];
        start_x = Integer.parseInt(tmp[2]);
        start_y = Integer.parseInt(tmp[3]);
        int k = Integer.parseInt(tmp[4]);

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        String[] tt = br.readLine().split(" ");
        for(int i=0;i<k;i++){
            int go = Integer.parseInt(tt[i]);
            solution(go);
        }
    }
}