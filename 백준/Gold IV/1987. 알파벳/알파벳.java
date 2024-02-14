import java.io.*;
public class Main {
    static int r,c,answer=1;
    static char[][] arr;
    static char[] ch = new char[27];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void DFS(int x, int y,int cnt){
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<r && ny>=0 && ny<c && ch[(arr[nx][ny]-'A')]==0){
                cnt++;
                ch[(arr[nx][ny]-'A')]=1;
                DFS(nx,ny,cnt);
                cnt--;
                ch[(arr[nx][ny]-'A')]=0;
            }
        }
        answer = Math.max(answer,cnt);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        r = Integer.parseInt(tmp[0]);
        c = Integer.parseInt(tmp[1]);
        arr = new char[r][c];
        for(int i=0;i<r;i++){
            String tmp1 = br.readLine();
            arr[i] = tmp1.toCharArray();
        }
        ch[(arr[0][0]-'A')]++;
        DFS(0,0,1);
        System.out.println(answer);
    }
}
