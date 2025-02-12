import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(T.solution(n));
    }

    private int solution(int n) {
        int kg5 = n/5;
        int answer = -1;

        for(;kg5>=0;kg5--){
            int remain = n - (5 * kg5);
            if(remain %3 == 0){
                int kg3 = remain / 3;
                answer = kg5 +  kg3;
                break;
            }
        }

        return answer;
    }
}
