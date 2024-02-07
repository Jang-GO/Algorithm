import java.util.*;
import java.io.*;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Main{
    static int m,n,k, answer=0;
    static int[][] arr;
    static List<Integer> list = new ArrayList<>();
    static int[] dx= {1,0,-1,0};
    static int[] dy={0,1,0,-1};

    public void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        arr[x][y] = 1;
        while(!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i=0;i<4;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&arr[nx][ny]==0){
                    arr[nx][ny]=1;
                    answer++;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];

        for(int i=0;i<k;i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            int d = Integer.parseInt(tmp[3]);
            for(int j=b;j<d;j++){
                for(int k=a;k<c;k++){
                    arr[j][k] += 1;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]<1){
                    answer++;
                    T.BFS(i,j);
                    list.add(answer);
                    answer=0;                   
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int x:list) System.out.print(x+ " ");
    }
}