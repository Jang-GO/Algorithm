import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;


class Main{
    static int n;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public void BFS(int x, int y){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x);
        Q.offer(y);
        arr[x][y]=0;
        int cnt=1;
        while(!Q.isEmpty()){
            int a = Q.poll();
            int b = Q.poll();
            for(int i=0;i<4;i++){
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(nx>=0 && ny >=0 && nx<n && ny<n && arr[nx][ny]==1){
                    
                    arr[nx][ny]=0;
                    Q.offer(nx);
                    Q.offer(ny);
                    cnt++;
                }
            }
        }
        list.add(cnt);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split("");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    T.BFS(i,j);
                }
            }
        }
        
        System.out.println(list.size());
        Collections.sort(list);
        for(int x:list) System.out.println(x);
    }
}