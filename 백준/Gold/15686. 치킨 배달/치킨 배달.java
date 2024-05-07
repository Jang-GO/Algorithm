import java.util.*;
import java.io.*;

class Main{
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,m, answer = Integer.MAX_VALUE;
    static ArrayList<Point> houseList = new ArrayList<>();
    static ArrayList<Point> pizzaList = new ArrayList<>();
    static int[][] board;
    static int[] combi;

    public void DFS(int L, int idx){
        if(L==m){
            int sum=0;
            for(Point p:houseList){
                int dis = Integer.MAX_VALUE;
                for(int i:combi){
                    dis = Math.min(dis, Math.abs(pizzaList.get(i).x -p.x)+Math.abs(pizzaList.get(i).y - p.y));
                }
                sum+=dis;
            }
            answer = Math.min(answer,sum);
        }else{
            for(int i=idx;i<pizzaList.size();i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        n = Integer.parseInt(ss[0]);
        m = Integer.parseInt(ss[1]);
        board = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) houseList.add(new Point(i,j));
                else if(board[i][j]==2) pizzaList.add(new Point(i,j));
            }
        }
        combi = new int[m];
        T.DFS(0,0);
        System.out.println(answer);
    }
}