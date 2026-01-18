import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int[] solution(int n, int m, int b, int[][] arr) {
        int[] answer = new int[2];
        answer[0] = Integer.MAX_VALUE;

        for (int height = 0; height <= 256; height++) {
            int aa = 0; // 제거
            int bb = 0; // 설치
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] > height) aa += arr[i][j] - height;
                    else bb += height - arr[i][j];
                }
            }
            if (aa + b < bb) continue;
            int sum = aa * 2 + bb;
            if (sum < answer[0] || (sum == answer[0] && height > answer[1])) {
                answer[0] = sum;
                answer[1] = height;
            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(n, m, b, arr);
        System.out.println(answer[0] + " " + answer[1]);
    }
}