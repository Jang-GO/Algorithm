import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(arr[i], '*');

        solution(0, 0, n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solution(int x, int y, int n) {
        if(n==1){
            return;
        }

        int repeatPoint = n/3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    for (int dx = 0; dx < repeatPoint; dx++) {
                        for (int dy = 0; dy < repeatPoint; dy++) {
                            arr[x + i * repeatPoint + dx][y + j * repeatPoint + dy] = ' ';
                        }
                    }
                } else {
                    solution(x + i * repeatPoint, y + j * repeatPoint, repeatPoint);
                }
            }
        }
    }
}
