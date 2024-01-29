import java.util.*;
import java.io.*;

public class 피자배달거리{
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    }
    static int n,m,len, answer=Integer.MAX_VALUE;
    static int[][] board;
    static ArrayList<Point> pizzaList;
    static ArrayList<Point> houseList;
    static int[] combi;
    public void DFS(int L, int idx){
        if(L==m){
            int sum=0;
            for(Point h:houseList){
                int dis = Integer.MAX_VALUE;
                for(int i:combi){
                    dis = Math.min(dis, Math.abs(pizzaList.get(i).x-h.x)+Math.abs(pizzaList.get(i).y-h.y));
                }
                sum+=dis;
            }
            answer = Math.min(answer, sum);
        }else{
            for(int i = idx;i<len;i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        피자배달거리 T = new 피자배달거리();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        board = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            String[] tmp1 = br.readLint().split(" ");
            for(int j=1;j<=n;j++){
                board[i][j] = Integer.parseInt(tmp[j]);
                if(board[i][j]==1) houseList.add(new Point(i, j));
                else if(board[i][j]==2) pizzaList.add(new Point(i,j));
            }
        }
        len = pizzaList.size();
        combi = new int[m];
        T.DFS(0,0);
        System.out.println(answer);
    }
}