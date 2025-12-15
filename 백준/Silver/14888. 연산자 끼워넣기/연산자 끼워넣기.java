import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, operators, answer;

    private static void dfs(int L, int sum){
        if(L == n-1){
            if(sum > answer[0]) {
                answer[0] = sum;
            }
            if(sum < answer[1]) {
                answer[1] = sum;
            }
            return;
        }

        for(int i=0;i<4;i++){
            if(operators[i] > 0) {
                operators[i]--;
                dfs(L+1, operation(sum, i, L+1));
                operators[i]++;
            }
        }
    }

    private static int operation(int sum, int op, int idx){
        if(op==0) return sum + arr[idx];
        if(op==1) return sum - arr[idx];
        if(op==2) return sum * arr[idx];
        return sum / arr[idx];
    }

    private static void solution(){
        dfs(0,arr[0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        operators = new int[4];
        answer = new int[2];
        answer[0] = Integer.MIN_VALUE;
        answer[1] = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++) operators[i] = Integer.parseInt(st.nextToken());

        solution();

        System.out.println(answer[0]);
        System.out.print(answer[1]);
    }
}
