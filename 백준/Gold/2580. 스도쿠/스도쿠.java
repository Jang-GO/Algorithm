import java.util.*;
import java.io.*;

class Main{
    static int[][] arr = new int[9][9];
    private static void DFS(int row, int col){
        if(row==9){
            DFS(0,col+1);
            return;
        }
        if(col==9){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }
        if(arr[row][col]==0){
            for(int i=1;i<=9;i++){
                if(isPossible(row,col,i)){
                    arr[row][col] = i;
                    DFS(row+1,col);
                }
            }
            arr[row][col]=0;
            return;
        }
        DFS(row+1,col);
    }
    private static boolean isPossible(int row, int col, int val){
        for(int i=0;i<9;i++){
            if(arr[i][col]==val) return false; 
        }
        for(int i=0;i<9;i++){
            if(arr[row][i]==val) return false;
        }
        int rect_x = (row/3) *3;
        int rect_y = (col/3) *3;
        for(int i=rect_x;i<rect_x+3;i++){
            for(int j=rect_y;j<rect_y+3;j++){
                if(arr[i][j]==val) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<9;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0,0);
    }
}