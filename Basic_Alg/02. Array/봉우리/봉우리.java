import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class 봉우리{
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int solution(int[][] arr){
        int answer=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                boolean isTop = true;
                for(int k=0;k<4;k++){
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x>=0 && y>=0 && x<arr.length && y<arr.length && arr[x][y]>=arr[i][j]){
                         isTop=false;
                         break;
                    }
                }
                if(isTop) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        봉우리 T = new 봉우리();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i=0;i<arr.length;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        System.out.println(T.solution(arr));
    }
}