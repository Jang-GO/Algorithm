import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) arr[i] = Integer.parseInt(st.nextToken());

        int lt = Arrays.stream(arr).max().getAsInt(); // 가장 긴 레슨 시간
        int rt = Arrays.stream(arr).sum();

        int answer = Integer.MAX_VALUE;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (possible(mid, arr) <= m) {
                answer = Math.min(answer, mid);
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static int possible(int mid, int[] arr) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            } else {
                cnt++;
                sum = arr[i];
            }
        }
        return cnt;
    }
}
