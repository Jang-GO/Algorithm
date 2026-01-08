import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int n = Integer.parseInt(br.readLine());
            int[] arr1 = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                int target = Integer.parseInt(st.nextToken());

                int lt = 0;
                int rt = n - 1;
                boolean found = false;

                while (lt <= rt) {
                    int mid = (lt + rt) / 2;

                    if (arr1[mid] == target) {
                        found = true;
                        break;
                    } else if (arr1[mid] > target) {
                        rt = mid - 1;
                    } else {
                        lt = mid + 1;
                    }
                }

                sb.append(found ? 1 : 0).append('\n');
            }
        }

        System.out.print(sb);
    }
}
