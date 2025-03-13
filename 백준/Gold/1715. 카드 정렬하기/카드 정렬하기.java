import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{
    static PriorityQueue<Integer> pQ = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(arr));
    }

    private static int solution(int[] arr){
        Arrays.stream(arr).forEach(a -> pQ.offer(a));

        int sum = 0;
        while(pQ.size() > 1){
            int polled1 = pQ.poll();
            int polled2 = pQ.poll();
            int cost = polled1 +polled2;
            sum += cost;
            pQ.offer(cost);
        }

        return sum;
    }
}