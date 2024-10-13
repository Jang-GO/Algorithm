import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public long count(int[] arr, long mid) {
        long cnt = 0;
        for (int x : arr) {
           cnt += (x / mid);
        }
        return cnt;
    }

    public long solution(int k, int n, int[] arr) {
        Arrays.sort(arr);
        long answer = 0;
        long lt = 1;
        long rt = arr[k - 1];
        
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            if (count(arr, mid) >= n) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(T.solution(k, n, arr));
    }
}
