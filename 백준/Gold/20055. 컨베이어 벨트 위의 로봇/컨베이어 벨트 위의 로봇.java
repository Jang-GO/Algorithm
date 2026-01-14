import java.util.*;
import java.io.*;

class Main {

    private static int solution(int n, int k, int[] arr) {
        int stage = 0;
        Belt belt = new Belt(n, k, arr);

        while (true) {
            stage++;

            // 회전 && 탈출
            belt.rotate();

            // 이동 && 탈출
            belt.moveRobot();

            // 로봇 올리기
            belt.putRobot();

            // 종료 조건 확인
            if (belt.impossible()) break;
        }
        return stage;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }

    static class Belt {
        int n;
        int k;
        int[] arr;
        boolean[] onRobot;

        Belt(int n, int k, int[] arr) {
            this.n = n;
            this.k = k;
            this.arr = arr;
            this.onRobot = new boolean[n];
        }

        void rotate() {
            int last = arr[n * 2 - 1];
            for (int i = n * 2 - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;

            for (int i = n - 1; i > 0; i--) {
                onRobot[i] = onRobot[i - 1];
            }
            onRobot[0] = false;

            onRobot[n - 1] = false;
        }

        void moveRobot() {
            for (int i = n - 2; i >= 0; i--) {
                if (onRobot[i] && !onRobot[i + 1] && arr[i + 1] > 0) {
                    onRobot[i] = false;
                    onRobot[i + 1] = true;
                    arr[i + 1]--;
                }
            }

            onRobot[n - 1] = false;
        }

        void putRobot() {
            if (!onRobot[0] && arr[0] > 0) {
                onRobot[0] = true;
                arr[0]--;
            }
        }

        boolean impossible() {
            int count = 0;
            for (int i = 0; i < n * 2; i++) {
                if (arr[i] == 0) count++;
            }
            return count >= k;
        }
    }
}
