import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n;
    static long[] dy;
    public void solution(){
        dy = new long[n+1];
        dy[0] = 0;
        dy[1] = 1;
        if(n>=2) dy[2] = 3;

        for(int i=3;i<=n;i++){
            dy[i] = (dy[i-1] + dy[i-2] * 2) % 10007;
        }

        System.out.println(dy[n]);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        T.solution();
    }
}