import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public long checkHeight(int[] arr, int mid) {
        long sum = 0;
        for (int x : arr) {
            if (x > mid) sum += (x - mid);
        }
        return sum;
    }

    public int solution(int n, int m, int[] trees) {
        Arrays.sort(trees);
        int answer = 0;
        int lt = 0;
        int rt = trees[n - 1];

        while (lt <= rt) {
            int mid = (lt + rt) >>> 1; 
            long wood = checkHeight(trees, mid); 
            
            if (wood >= m) {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(T.solution(n, m, trees));
    }
}
