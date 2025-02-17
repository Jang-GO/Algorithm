import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] chessPan;
    static int N,cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chessPan = new boolean[N][N];
        solution(0);
        System.out.println(cnt);
    }

    private static void solution(int idx) {
        if(idx == N){
            cnt++;
            return;
        }

        for(int i=0;i<N;i++){
            if(canBatch(idx, i)){
                chessPan[idx][i] = true;
                solution(idx+1);
                chessPan[idx][i] = false;
            }
        }
    }

    // 가로세로대각선 중 true 가 존재하는지 검사
    private static boolean canBatch(int row, int col) {
        for(int i=0;i<N;i++){
            if(chessPan[row][i]) return false;
            if(chessPan[i][col]) return false;
        }

        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (chessPan[row - i][col - i]) return false;
        }

        for (int i = 1; row - i >= 0 && col + i < N; i++) {
            if (chessPan[row - i][col + i]) return false;
        }

        return true;
    }
}
